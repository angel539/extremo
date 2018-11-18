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
package uam.extremo.queries.customsearch;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.AtomicSearchResult;
import semanticmanager.Repository;
import semanticmanager.SearchParamValue;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;

public class InRefsOverloadedSearch extends ExtensibleCustomSearchImpl {
	Object maxRefsOption = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		maxRefsOption = getParamValue("maxrefs", inputs);
	}
	
	@Override
	public void search(Repository repository, SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			int maxRefs = -1;

			if (maxRefsOption instanceof Integer) {
				maxRefs = (int) maxRefsOption;
			}
			else{
				if (maxRefsOption instanceof String){
					maxRefs = Integer.parseInt((String) maxRefsOption);
				}
			}
			
			if(maxRefs >= 0){
				final int maxRefsFinal = maxRefs;
				
				TreeIterator<EObject> iterator = repository.eAllContents();
				iterator.forEachRemaining( // O(n) in general -> with pruning
					e -> {
						if(e instanceof SemanticNode){
				        	SemanticNode range = (SemanticNode) e;
				        	if(range.getDomain().size() >= maxRefsFinal){
								atomicSearchResult.getElements().add(range);
							}
				        	iterator.prune(); // It skips over all the nodes below the most recent result of calling next().
				        }
					}
				);
			}
		}
	}
}
