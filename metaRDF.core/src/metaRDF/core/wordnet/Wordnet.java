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
package metaRDF.core.wordnet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class Wordnet{
   private WordNetDatabase database = null;

   public Wordnet(){
	   super();
	   File f = new File("/Users/angel/Wordnet/dict");
	   
	   if(!f.exists()){
		   //Status status = new Status(IStatus.ERROR, "metardf", 0, "WordNet error", null);
		   //ErrorDialog.openError(null, "WordNet error", "The WordNet location preference is not valid", status);
	   }
	   
	   System.setProperty("wordnet.database.dir", "/Users/angel/Wordnet/dict");
	   database = WordNetDatabase.getFileInstance();
   }
   
   public WordNetDatabase getDatabase() {
       return database;
   }

   public void setDatabase(WordNetDatabase database) {
       this.database = database;
   }
   
   public List<String> getDefinitions(String concept){
	   List<String> definitions = new ArrayList<String>();
	   Synset[] synsets = database.getSynsets(concept);
	   
	   if(synsets.length > 0){
		   for (int i = 0; i < synsets.length; i++){
			   definitions.add(synsets[i].getDefinition());
		   }
	   }else return null;
	   return definitions;
   }
   
   public List<List<String>> getSynonymsProposal(String concept){
	   List<List<String>> synonyms = new ArrayList<List<String>>();
	   Synset[] synsets = database.getSynsets(concept);
	   
	   if(synsets.length > 0){
		   for (int i = 0; i < synsets.length; i++){
			   List<String> wordforms = new ArrayList<String>();
			   String[] words = synsets[i].getWordForms();
			   for (int j = 0; j < words.length; j++){
				   wordforms.add(words[j]);
			   }
			   synonyms.add(wordforms);
		   }
	   }else return null;
	   return synonyms;
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
   
   public boolean areSynonyms(String concept1, String concept2){
	   if(this.getSynonymsProposal(concept1) == null) return false;

	   for(List<String> meanings : this.getSynonymsProposal(concept1))
		   for(String word : meanings)
			   if(word.equalsIgnoreCase(concept2)){
				   //System.out.println(concept1 + " and " + concept2 + " are synonyms");
				   return true;
			   }
	   
	   return false;
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