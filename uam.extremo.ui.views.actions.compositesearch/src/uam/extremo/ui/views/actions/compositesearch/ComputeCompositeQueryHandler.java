package uam.extremo.ui.views.actions.compositesearch;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.AtomicSearchResult;
import semanticmanager.CompositeSearchConfiguration;
import semanticmanager.ConnectionType;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.GroupedSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;

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
        String connectionTypeLiteral = connectionType.getLiteral();
        
        switch (connectionTypeLiteral) {
			case "or":
				computeOrQueriesCompositeSearch(compositeSearchConfiguration);
				break;
			case "and":
				computeAndQueriesCompositeSearch(compositeSearchConfiguration);
				break;
			case "not":
				computeNotQueriesCompositeSearch(compositeSearchConfiguration);
				break;
			default:
				break;
        }
        
        /*for(CompositeSearchConfiguration childCompositeSearchConfiguration
        						: compositeSearchConfiguration.getChildren()){
        	for(SearchResult searchResult : childCompositeSearchConfiguration.getResults()){
        		
        		if (searchResult instanceof AtomicSearchResult) {
            		AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;
            		
            		String connectionTypeLiteral = connectionType.getLiteral();
            		
    			}
            		GroupedSearchResult groupedSearchResult = (GroupedSearchResult) searchResult;
            		
            		String connectionTypeLiteral = connectionType.getLiteral();
            		
    			}
        	}
        }*/
    }

	private void computeNotQueriesCompositeSearch(CompositeSearchConfiguration compositeSearchConfiguration) {
		List<NamedElement> notElements = new ArrayList<NamedElement>();
		
		for(SearchResult searchResult : compositeSearchConfiguration.getSearchResults()){
			List<NamedElement> applyOnElements = searchResult.getApplyOnElements();
			
			if (searchResult instanceof AtomicSearchResult) {
				AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;
				
				for(NamedElement e : atomicSearchResult.getElements()){
					if(! applyOnElements.contains(e))
						notElements.add(e);
				}
			}
			else{
				GroupedSearchResult groupedSearchResult = (GroupedSearchResult) searchResult;
				
				for(SemanticGroup semanticGroup : groupedSearchResult.getGroups()){
					for(NamedElement e : semanticGroup.getElements()){
						if(! applyOnElements.contains(e))
							notElements.add(e);
					}
				}
			}
		}
		
		Set<NamedElement> hs = new HashSet<>();
		hs.addAll(notElements);
		notElements.clear();
		notElements.addAll(hs);
		
		AtomicSearchResult notSearchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
		notSearchResult.getElements().addAll(notElements);
		compositeSearchConfiguration.getResults().add(notSearchResult);
	}

	private void computeAndQueriesCompositeSearch(CompositeSearchConfiguration compositeSearchConfiguration) {	
	}

	private void computeOrQueriesCompositeSearch(CompositeSearchConfiguration compositeSearchConfiguration) {
	}
}