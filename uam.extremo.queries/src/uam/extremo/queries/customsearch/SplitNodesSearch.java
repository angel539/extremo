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

import semanticmanager.GroupedSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchParamValue;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class SplitNodesSearch extends ExtensibleCustomSearchImpl {
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
					if(e instanceof Resource && ((Resource) e).getDescriptors().isEmpty()){
						preorder(groupedSearchResult, (Resource) e);
						iterator.prune();
					}	
				}
			);
		}	
	}
	
	public List<NamedElement> getAllSubs(NamedElement node){
		List<NamedElement> nonvisited = new ArrayList<NamedElement>();
		List<NamedElement> subs = new ArrayList<NamedElement>();
			
		nonvisited.addAll(node.getSubs());
			
		while(!nonvisited.isEmpty()){
			NamedElement sn = nonvisited.get(0);
			
			if(!subs.contains(sn)){
				subs.add(sn);
				nonvisited.addAll(sn.getSubs());
			}
			nonvisited.remove(sn);
		}
			
		return subs;
	}
	
	public synchronized void preorder(GroupedSearchResult result, Resource resource){
        preorderHelper(result, resource);
    }
     
    private void preorderHelper(GroupedSearchResult result, ResourceElement node)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			if(semanticNode.getSupers() == null || semanticNode.getSupers().size() == 0){
				if((semanticNode.getSubs() != null) && (semanticNode.getSubs().size() > 0)){
					SemanticGroup group = result.createSemanticGroup(node.getName(), node.getName());
					group.getElements().addAll(getAllSubs(semanticNode));
					result.getGroups().add(group);
				}
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement);
        }
    }
}
