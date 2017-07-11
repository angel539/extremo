package uam.extremo.ui.views.actions.compositesearch;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.AtomicSearchResult;
import semanticmanager.CompositeSearchConfiguration;
import semanticmanager.ConnectionType;
import semanticmanager.GroupedSearchResult;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import uam.extremo.ui.wizards.dialogs.link.LinkWizardDialog;

public class ComputeCompositeQueryHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();

			if (firstselection != null) {
				if(firstselection instanceof CompositeSearchConfiguration){
					CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) firstselection;
					postorderHelper(compositeSearchConfiguration);
				}
			}
			else{
				MessageDialog.openInformation(null, "Search entities", "Repository must be selected");
			}
		}
		
		return null;
	}
	
	public synchronized void postorder(CompositeSearchConfiguration compositeSearchConfiguration){
		postorderHelper(compositeSearchConfiguration);
    }
     
    private void postorderHelper(CompositeSearchConfiguration compositeSearchConfiguration){
        if(compositeSearchConfiguration == null)
            return;

        for(CompositeSearchConfiguration compositeSearch : compositeSearchConfiguration.getChildren())
        	postorderHelper(compositeSearch);
        
        ConnectionType connectionType = compositeSearchConfiguration.getType();
        
        for(SearchResult searchResult : compositeSearchConfiguration.getQueryResults()){
        	if (searchResult instanceof AtomicSearchResult) {
        		AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;
        		String connectionTypeLiteral = connectionType.getLiteral();
        		
        		switch (connectionTypeLiteral) {
					case "or":
						break;
					case "and":
						break;
					case "not":
						break;
					default:
						break;
				}
			}
        	else{
        		// then GroupedSearchResult
        		GroupedSearchResult groupedSearchResult = (GroupedSearchResult) searchResult;
        		String connectionTypeLiteral = connectionType.getLiteral();
        		
        		switch (connectionTypeLiteral) {
					case "or":
						break;
					case "and":
						break;
					case "not":
						break;
					default:
						break;
				}
			}
        }
        
        for(CompositeSearchConfiguration childCompositeSearchConfiguration
        						: compositeSearchConfiguration.getChildren()){
        	//ConnectionType connectionType = compositeSearchConfiguration.getType();
        	for(SearchResult searchResult : childCompositeSearchConfiguration.getResults()){
        		
        		if (searchResult instanceof AtomicSearchResult) {
            		AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;
            		
            		String connectionTypeLiteral = connectionType.getLiteral();
            		
            		switch (connectionTypeLiteral) {
    					case "or":
    						break;
    					case "and":
    						break;
    					case "not":
    						break;
    					default:
    						break;
    				}
    			}
            	else{
            		// then GroupedSearchResult
            		GroupedSearchResult groupedSearchResult = (GroupedSearchResult) searchResult;
            		
            		String connectionTypeLiteral = connectionType.getLiteral();
            		
            		switch (connectionTypeLiteral) {
    					case "or":
    						break;
    					case "and":
    						break;
    					case "not":
    						break;
    					default:
    						break;
    				}
    			}
        	}
        }
    }
}