package metaRDF.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class LangUtils {
	public static List<String> cleanRepeated(List<String> dirtyList){
		Set<String> hs = new HashSet<>();
		hs.addAll(dirtyList);
		dirtyList.clear();
		dirtyList.addAll(hs);
		
		return dirtyList;
	}
	
	public static List<String> cleanAndSeparateWords(String dirty){
		List<String> cleaned = new ArrayList<String>();
		
		String[] noSpaces = StringUtils.splitByWholeSeparator(dirty, " ", 0);
		for(String noSpace : noSpaces){
			String[] camelCaseSpplited = StringUtils.splitByCharacterTypeCamelCase(noSpace);
			cleaned.addAll(Arrays.asList(camelCaseSpplited));
		}
		
		return cleaned;
	}
	
	public static boolean containsSemanticConcept(String word, String[] candidates){
		for(String candidate : candidates){
			if(StringUtils.contains(word, candidate)) return true;
		}
		return false;
	}
	
	/*public static List<String> getSynonimsWithWordnet(String wordnetDict, String word){
		List<String> definitions = new ArrayList<String>();

		String wordnetPath = Wordnet.getInstance(wordnetDict).getWordnet();
		
		if(wordnetPath == null){
			definitions.add(s);
				List<String> aux = new ArrayList<String>();
				aux.add(s);
				definitions.put(s, aux);
			}
			else{
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
				
				definitions.put(s, wordnetProposals);
				
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
			
			HashSet<String> aux = new HashSet<String>(wordnetProposals);
			wordnetProposals.clear();
			wordnetProposals.addAll(aux);
			
			definitions.put(s, wordnetProposals);
			
			List<String> aux = new ArrayList<String>();
			aux.add(s);
			definitions.put(s, aux);
		}
		
		return definitions;
	}*/
	
	/*private static List<String> stemList(List<String> list){
		List<String> stemmed = new ArrayList<String>();
		
		char[] w = new char[501];
		
		Stemmer s = new Stemmer();
		
		for(String string : list){
			InputStream in = new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
			
			try{
				while(true){
					int ch = in.read();
					
					if (Character.isLetter((char) ch)){
						int j = 0;
						while(true){
							ch = Character.toLowerCase((char) ch);
							w[j] = (char) ch;
							
							if (j < 500) j++;
							ch = in.read();
							
							if (!Character.isLetter((char) ch)){
								for (int c = 0; c < j; c++) s.add(w[c]);
								
								s.stem();
								{
									String u;
									u = s.toString();
									
									stemmed.add(u);
	                       }
	                       break;
	                    }
	                 }
	              }
	              if (ch < 0) break;
	           }
	         }
	         catch (IOException e){
	            break;
	         }
		}
		return stemmed;
	}*/
	
	public static boolean haveTheSameStem(String term1, String term2){
		if(stemTerm(term1.toLowerCase()).compareTo(stemTerm(term2.toLowerCase())) == 0) return true;
		return false;
	}
	
	private static String stemTerm(String term){
		Stemmer stemmer = new Stemmer();
		stemmer.add(term.toCharArray(), term.length());
		stemmer.stem();
		return stemmer.toString();
	}
	
	public static void stem(List<String> toStem){
		//Search search = new Search("class, instance, reference, association, type, object, feature, concept, relation, relationship", false, false);
		//search.expand();
		
		//List<String> toSearch = search.getOrderSearchesListByWeight();
		for(String s : toStem){
			String[] multi = StringUtils.splitPreserveAllTokens(s, null, 0);
			for(String m : multi) System.out.println(stemTerm(m.toLowerCase()));
		}
	}
}
