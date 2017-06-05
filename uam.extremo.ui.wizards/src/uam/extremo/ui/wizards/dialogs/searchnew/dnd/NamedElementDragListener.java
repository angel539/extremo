/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import semanticmanager.NamedElement;

public class NamedElementDragListener implements DragSourceListener {
	private final RepositoryTreeViewer viewer;
	
	public NamedElementDragListener(RepositoryTreeViewer viewer){
		this.viewer = viewer;
	}
	
	@Override
	public void dragStart(DragSourceEvent event) {
		event.doit = !viewer.getSelection().isEmpty();
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
	    IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
	    
	    String data = ((NamedElement) selection.getFirstElement()).getName();	    
	    	    
	    if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
	    	event.data = data;
	    }
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
	}
}
