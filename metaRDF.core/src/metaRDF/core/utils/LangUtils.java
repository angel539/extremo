package metaRDF.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import metaRDF.core.wordnet.Wordnet;

public class LangUtils {
	public static Map<String, List<String>> getSynomins(String... words){
		Map<String, List<String>> definitions = new HashMap<String, List<String>>();
		
		for(String word : words){
			definitions.put(word, getSynonims(word));
		}
		
		return definitions;
	}
	
	public static List<String> cleanRepeated(List<String> words){
		Set<String> hs = new HashSet<>();
		hs.addAll(words);
		words.clear();
		words.addAll(hs);
		
		return words;
	}
	public static List<String> getSynonims(String word){
		List<String> definitions = new ArrayList<String>();
		
		String[] spplited = StringUtils.splitByWholeSeparator(word, null, 0);
		String joinedCapitalize = "";
		for(String s : spplited) joinedCapitalize = joinedCapitalize + WordUtils.capitalize(s);
		
		String[] wordList = StringUtils.splitByCharacterTypeCamelCase(joinedCapitalize);
		
		for(String s : wordList){
			String wordnetPath = PropertiesFile.getInstance().getWordnet();
			if(wordnetPath == null){
				definitions.add(s);
				//List<String> aux = new ArrayList<String>();
				//aux.add(s);
				//definitions.put(s, aux);
			}
			else{
				/*Wordnet wordnet = new Wordnet(wordnetPath);
				List<String> wordnetProposals = null;
				if(wordnet.isNoun(s)){
					List<List<String>> synonymsByName = wordnet.getSynonymsProposal(s);
					
					if(synonymsByName.size() > 0){
						wordnetProposals = new ArrayList<String>();
						for(List<String> partial : synonymsByName){
							wordnetProposals.addAll(partial);
						}
					}	
				}
				
				HashSet<String> aux = new HashSet<String>(wordnetProposals);
				wordnetProposals.clear();
				wordnetProposals.addAll(aux);
				
				definitions.put(s, wordnetProposals);*/
				
				Wordnet wordnet = new Wordnet(wordnetPath);
				List<String> wordnetProposals = null;
				if(wordnet.isNoun(s)){
					List<List<String>> synonymsByName = wordnet.getSynonymsProposal(s);
					
					if(synonymsByName.size() > 0){
						wordnetProposals = new ArrayList<String>();
						for(List<String> partial : synonymsByName){
							wordnetProposals.addAll(partial);
						}
					}	
				}
				
				HashSet<String> aux = new HashSet<String>(wordnetProposals);
				wordnetProposals.clear();
				wordnetProposals.addAll(aux);
				
				definitions.addAll(wordnetProposals);
			}	
			
			/*HashSet<String> aux = new HashSet<String>(wordnetProposals);
			wordnetProposals.clear();
			wordnetProposals.addAll(aux);
			
			definitions.put(s, wordnetProposals);
			
			List<String> aux = new ArrayList<String>();
			aux.add(s);
			definitions.put(s, aux);*/
		}
		
		return definitions;
	}
}
