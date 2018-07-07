package uam.extremo.services;

import java.util.List;

import uam.extremo.core.impl.ExtensibleServiceImpl;
import uam.extremo.queries.services.stemmer.LangUtils;

public class InexactMatchingServiceImpl extends ExtensibleServiceImpl {
	@Override
	public boolean matches(String expression, String value) {
		List<String> expressionList = LangUtils.cleanAndSeparateWords(expression);
		
		for(String e : expressionList){	
			if(e.compareToIgnoreCase(value) == 0){
				return true;
			}
			else{
				if(LangUtils.haveTheSameStem(e, value)){
					return true;
				}
			}
		}
		
		return false;
	}
}
