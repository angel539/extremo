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
package uam.extremo.ui.actions.compositesearch;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.CompositeSearchConfiguration;
import semanticmanager.ConnectionType;
import semanticmanager.RepositoryManager;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SimpleSearchConfiguration;

public class NotCompositeSearchConfigurationHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();
			
			if (firstselection != null) {
				if(firstselection instanceof SimpleSearchConfiguration){
					SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration) firstselection;
					
					EObject container = ((EObject) simpleSearchConfiguration).eContainer();	
					if (container instanceof CompositeSearchConfiguration) {
						CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) container;
						CompositeSearchConfiguration newComposition = SemanticmanagerFactory.eINSTANCE.createCompositeSearchConfiguration();
						newComposition.setType(ConnectionType.NOT);
						compositeSearchConfiguration.getSearchConfigurations().add(newComposition);
					}
					else{
						if (container instanceof RepositoryManager) {
							RepositoryManager repositoryManager = (RepositoryManager) container;
							CompositeSearchConfiguration newComposition = SemanticmanagerFactory.eINSTANCE.createCompositeSearchConfiguration();
							newComposition.setType(ConnectionType.NOT);
							repositoryManager.getConfigurations().add(newComposition);
						}
					}
				}
				else{
					if (firstselection instanceof CompositeSearchConfiguration) {
						CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) firstselection;
						CompositeSearchConfiguration newComposition = SemanticmanagerFactory.eINSTANCE.createCompositeSearchConfiguration();
						newComposition.setType(ConnectionType.NOT);
						compositeSearchConfiguration.getSearchConfigurations().add(newComposition);
					}
				}
			}
		}
		
		return null;
	}
}