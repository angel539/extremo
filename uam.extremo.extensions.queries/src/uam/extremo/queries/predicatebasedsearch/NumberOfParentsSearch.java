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
package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.NamedElement;
import semanticmanager.SearchParamValue;
import semanticmanager.SemanticNode;

public class NumberOfParentsSearch extends ExtensiblePredicateBasedSearchImpl {
	Object parentsValueField = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		parentsValueField = getParamValue("parents", inputs);
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			if((parentsValueField != null) && (parentsValueField instanceof String)){
				int parents = Integer.parseInt((String) parentsValueField);
				
				long count = semanticNode.getSupers().stream().count();
				
				if(count >= parents){
					return true;
				}
			}
		}
		return false;
	}
}
