/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package uam.extremo.queries.services.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.eclipse.core.runtime.FileLocator;
//import org.eclipse.core.runtime.IPath;
//import org.eclipse.core.runtime.Path;
//import org.eclipse.core.runtime.Platform;
//import org.osgi.framework.Bundle;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.WordSense;
import uam.extremo.queries.Activator;

public class Wordnet{
	private WordNetDatabase database = null;
	
	public Wordnet(){
		super();
		System.setProperty("wordnet.database.dir", Activator.getPath("dict"));
		database = WordNetDatabase.getFileInstance();
	}
   
   public List<String> getDefinitions(String concept){
	   List<String> definitions = new ArrayList<String>();
	   Synset[] synsets = database.getSynsets(concept);
	   
	   if(synsets.length > 0){
		   for (int i = 0; i < synsets.length; i++){
			   definitions.add(synsets[i].getDefinition());
		   }
	   }
	   else
		   return null;
	   
	   return definitions;
   }
   
   public Map<String, Tuple<String[], String[]>> getSynonymsProposal(String concept){
	   Map<String, Tuple<String[], String[]>> synonyms = new HashMap<String, Tuple<String[], String[]>>();
	   
	   Synset[] synsets = database.getSynsets(concept);
	   
	   for(Synset synset : synsets){
		   int tagCount = 0;
		   
		   try{
			   tagCount = synset.getTagCount(concept);
		   }catch(edu.smu.tspell.wordnet.WordNetException e){
			   tagCount = synset.getTagCount(synset.getWordForms()[0]);
		   }
		   
		   Tuple<String[], String[]> wordformsAndExamples = new Tuple<String[], String[]>(synset.getWordForms(), synset.getUsageExamples(), tagCount);
		   synonyms.put(synset.getDefinition(), wordformsAndExamples);
		   System.out.println("tag counts for " + concept + ">><" + tagCount + ":::" + concept);
	   }
	   
	   return synonyms;
   }
   
   public List<String> getExamples(String concept){
	   List<String> examples = new ArrayList<String>();
	   
	   Synset[] synsets = database.getSynsets(concept);
	   for(Synset synset : synsets){
		   for(String s : synset.getUsageExamples()) examples.add(s);
	   }
	   
	   return examples;
   }
   

   
   public List<String> getMeanings(String concept){
	   List<String> meanings = new ArrayList<String>();
	   
	   Synset[] synsets = database.getSynsets(concept);
	   for(Synset synset : synsets){
		   meanings.add(synset.getDefinition());
	   }
	   
	   return meanings;
   }
   
   public List<String> getDerivation(String concept1, String concept2){
	   List<String> derivation = new ArrayList<String>();
	   
	   Synset[] synsets = database.getSynsets(concept1);
	   for(Synset synset : synsets){
		   for(WordSense wordsense : synset.getDerivationallyRelatedForms(concept2))
			   derivation.add(wordsense.getWordForm());
	   }
	   
	   return derivation;
   }
   
   public List<String> getSynonymsByDefition(String concept, String definition){
	   List<String> synonyms = new ArrayList<String>();
	   Synset[] synsets = database.getSynsets(concept);
	   if(synsets.length > 0){
		   for (int i = 0; i < synsets.length; i++){
			   if(synsets[i].getDefinition().equals(definition)){
				   String[] words = synsets[i].getWordForms();
				   for (int j = 0; j < words.length; j++){
					   synonyms.add(words[j]);
				   }
				   break;
			   }
		   }
	   }else return null;
	   return synonyms;
	   }
   
   public boolean isNoun(String word){
	   for(Synset s : database.getSynsets(word))
		   if(s.getType().equals(SynsetType.NOUN))
			   return true;
	   
	   if(LexicalInflector.isPlural(word))
		   return isNoun(LexicalInflector.singularize(word));
	   
	   return false;
   }
   
   public boolean isVerb(String word){
	   for(Synset s : database.getSynsets(word))
		   if(s.getType().equals(SynsetType.VERB))
			   return true;
	   
	   return false;
   }
   
   public boolean isAdjective(String word){
	   for(Synset s : database.getSynsets(word))
		   if(s.getType().equals(SynsetType.ADJECTIVE))
			   return true;
	   
	   return false;
   }
}