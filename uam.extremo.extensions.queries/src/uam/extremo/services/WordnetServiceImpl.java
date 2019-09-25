/*******************************************************************************
 * Copyright (c) 2018 Universidad Autónoma de Madrid (Spain).
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 3.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-3.0
 *
 * Contributors:
 * 				Ángel Mora Segura - implementation
 ******************************************************************************/
package uam.extremo.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import semanticmanager.impl.ExtensibleServiceImpl;
import uam.extremo.queries.services.utils.LangUtils;
import uam.extremo.queries.services.utils.WordnetSearchExpansionTree;

public class WordnetServiceImpl extends ExtensibleServiceImpl {	
	WordnetSearchExpansionTree wordnetSearchExpansionTree = null;
	
	public WordnetServiceImpl() {
		super();
		this.wordnetSearchExpansionTree = new WordnetSearchExpansionTree(40, 300, 50, 60, 90);
	}

	@Override
	public boolean matches(String expression, String value) {
		wordnetSearchExpansionTree.expand(expression);
		Map<String, Integer> searchList = (Map<String, Integer>) wordnetSearchExpansionTree.getOrderSearchesListByWeight();
		
		for(Entry<String, Integer> word : searchList.entrySet()){
			if(word.getKey().compareTo(value) == 0){
				return true;
			}
			
			List<String> spplitedValue = LangUtils.cleanAndSeparateWords(value);
			for(String s : spplitedValue){
				if(s.compareTo(value) == 0){
					return true;
				}
				else{
					if(LangUtils.haveTheSameStem(s, word.getKey())){
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
