package metardf.ui.actions.test;

import java.util.List;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.owl.OwlAssistant;
import metardf.ui.dnd.ResourceViewAction;

public class SearchEntity extends ResourceViewAction {
	public SearchEntity() {
	}
	
	@Override
	public void execute() {
		if((RepositoryManager.getInstance()!=null) && (RepositoryManager.getInstance().getRepositories()!=null) && (RepositoryManager.getInstance().getRepositories().size() > 0)){
			for(IRepository repository : RepositoryManager.getInstance().getRepositories()){
				for(IResource resource : repository.getResources()){
					OwlAssistant.getInstance().load(resource.getURI());
					
					InputDialog inputDialog = new InputDialog(null, "Entity creation", "Enter a new entity", "", null);
					if (inputDialog.open() == Window.OK){
						String candidate = inputDialog.getValue();
						
						List<ISemanticClass> entities = OwlAssistant.getInstance().getClassesLike(candidate);
						if((entities == null) || (entities.size() < 1)) MessageDialog.openWarning(null, "Entity not found", "No entities were found matching the input " + candidate);
							
						for(ISemanticClass entity : entities){
							addEntity(entity);
						}
					}
				}		
			}
		}
	}
}
