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
package uam.extremo.ui.views.repositories;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;

import semanticmanager.Constraint;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;

public class ColumnReferencesRepositoryViewAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{
	public ColumnReferencesRepositoryViewAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof SemanticNode) {
			SemanticNode objectProperty = (SemanticNode) element;
			return new StyledString(Integer.toString(objectProperty.getDomain().size()));
		}
		
		return new StyledString("");
	}
	
	@Override
	public Image getImage(Object object) {
		return null;
	}
}
