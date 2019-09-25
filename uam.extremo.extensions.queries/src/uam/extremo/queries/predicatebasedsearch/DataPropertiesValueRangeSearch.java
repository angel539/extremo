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
import semanticmanager.SearchParamValue;

public class DataPropertiesValueRangeSearch extends ExtensiblePredicateBasedSearchImpl{
	Object minValuefield = null;
	Object maxValuefield = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		minValuefield = getParamValue("minvaluefield", inputs);
		maxValuefield = getParamValue("maxvaluefield", inputs);
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof DataProperty) {
			if((minValuefield != null) 
					&& (minValuefield instanceof String) 
					&& (maxValuefield != null) 
					&& (maxValuefield instanceof String)){
				int min = Integer.parseInt((String) minValuefield);
				int max = Integer.parseInt((String) maxValuefield);

				int value = Integer.parseInt(((DataProperty) namedElement).getValue());
				
				if((min <= value) && (value <= max))
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}
}
