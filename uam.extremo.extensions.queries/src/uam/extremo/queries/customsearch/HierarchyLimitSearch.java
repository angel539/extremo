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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.AtomicSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.SearchParamValue;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;

public class HierarchyLimitSearch extends ExtensibleCustomSearchImpl {	
	Object maxDepthOption = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		maxDepthOption = getParamValue("maxdepth", inputs);
	}
	
	@Override
	public void search(Repository repository, SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			
			int maxDepth = -1;
			if (maxDepthOption instanceof Integer) {
				maxDepth = (int) maxDepthOption;
			}
			else{
				if (maxDepthOption instanceof String){
					maxDepth = Integer.parseInt((String) maxDepthOption);
				}
			}
			
			if(maxDepth >= 0){
				final int maxDepthFinal = maxDepth;
				
				TreeIterator<EObject> iterator = repository.eAllContents();
				iterator.forEachRemaining(
					e -> {
						if(e instanceof SemanticNode){
							int maxD = maxDepth((SemanticNode) e);
							
							if(maxD >= maxDepthFinal){
								atomicSearchResult.getElements().add((SemanticNode) e);
							}
							iterator.prune();
						}
					}
				);
			}
		}
	}
	
	int maxDepth(NamedElement node){
		 if ((node == null) || (node.getSupers() == null) || (node.getSupers().size() == 0))
			 return 0;
		 else{
			 int[] depths = new int[node.getSupers().size()];
			 
			 for(int i = 0; i < node.getSupers().size(); i++){
				 depths[i] = maxDepth(node.getSupers().get(i));
			 }
			 
			 List<Integer> depthsList = Arrays.stream(depths).boxed().collect(Collectors.toList());
			 return Collections.max(depthsList) + 1;
		 }
	 } 
}
