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

import semanticmanager.impl.ExtensibleCustomSearchImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import semanticmanager.GroupedSearchResult;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SearchParamValue;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;

public class IsolatedClassesSearch extends ExtensibleCustomSearchImpl {	
	@Override
	public void init(EList<SearchParamValue> inputs) {
	}
	
	@Override
	public void search(Repository repository, SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			
			TreeIterator<EObject> iterator = repository.eAllContents();
			iterator.forEachRemaining(
					e -> {
						if(e instanceof Resource && (e.eContainer() instanceof Repository || e.eContainer() instanceof Resource)){
							Resource resource = (Resource) e;
							SemanticGroup group = groupedSearchResult.createSemanticGroup(((Resource)e).getName(), ((Resource)e).getName());
							resource.getResourceElements().forEach(
									resourceElement -> {
										if(resourceElement instanceof SemanticNode){
											SemanticNode semanticNode = (SemanticNode) resourceElement;
											if(semanticNode.getDomain().size() == 0){
												group.getElements().add(resourceElement);
											}
										}
									}
								);
							
							groupedSearchResult.getGroups().add(group);
							iterator.prune();
						}
					}
			);
		}
	}
}
