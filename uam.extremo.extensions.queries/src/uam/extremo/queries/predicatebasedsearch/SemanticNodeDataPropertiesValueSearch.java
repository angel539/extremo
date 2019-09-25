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
import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.Property;
import semanticmanager.SearchParamValue;
import semanticmanager.SemanticNode;
import semanticmanager.Service;

public class SemanticNodeDataPropertiesValueSearch extends ExtensiblePredicateBasedSearchImpl {
	Object optionvalue = null;
	Service service = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		optionvalue = getParamValue("value", inputs);
		service = getServiceForParamValue("value", inputs);	
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {		
			if((optionvalue != null) && (optionvalue instanceof String)){
				String valuefieldString = (String) optionvalue;
				SemanticNode semanticNode = (SemanticNode) namedElement; 
				
				for(Property property : semanticNode.getProperties()){
					if (property instanceof DataProperty) {
						DataProperty dataProperty = (DataProperty) property;
						if(dataProperty.getValue() == null) return false;
						
						if(service != null){
							return callService(service, dataProperty.getValue(), valuefieldString);
						}
						else{		
							if(dataProperty.getValue().compareTo(valuefieldString) == 0)
								return true;
							else
								return false;
						}
					}
				}
			}
			return false;
		}
		
		return false;
	}
}
