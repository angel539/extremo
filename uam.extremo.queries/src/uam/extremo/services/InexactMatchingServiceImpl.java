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

import semanticmanager.impl.ExtensibleServiceImpl;
import uam.extremo.queries.services.utils.LangUtils;

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
