package metardf.ui.actions.test;

import java.util.List;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import metaRDF.core.model.Repository;
import metaRDF.core.model.Resource;
import metaRDF.core.model.SemanticClass;
import metaRDF.core.owl.OwlAssistant;
import metaRDF.core.repository.MetaRDFRepositoryManager;
import metardf.ui.dnd.ResourceViewAction;

public class SearchEntity extends ResourceViewAction {
	public SearchEntity() {
	}
	
	@Override
	public void execute() {
		if((MetaRDFRepositoryManager.getInstance()!=null) && (MetaRDFRepositoryManager.getInstance().getRepositories()!=null) && (MetaRDFRepositoryManager.getInstance().getRepositories().size() > 0)){
			for(Repository repository : MetaRDFRepositoryManager.getInstance().getRepositories()){
				for(Resource resource : repository.getResources()){
					OwlAssistant.getInstance().load(resource.getURI());
					
					InputDialog inputDialog = new InputDialog(null, "Entity creation", "Enter a new entity", "", null);
					if (inputDialog.open() == Window.OK){
						String candidate = inputDialog.getValue();
						
						List<SemanticClass> entities = OwlAssistant.getInstance().getClassesLike(candidate);
						if((entities == null) || (entities.size() < 1)) MessageDialog.openWarning(null, "Entity not found", "No entities were found matching the input " + candidate);
							
						for(SemanticClass entity : entities){
							addEntity(entity);
						}
					}
				}		
			}
		}
	}
}
