package metardf.ui.actions.test;

import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.dnd.ResourceViewAction;

public class SearchEntity extends ResourceViewAction {
	public SearchEntity() {
	}
	
	@Override
	public void execute() {
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		if((repositoryManager!=null) && (repositoryManager.getRepositories()!=null) && (repositoryManager.getRepositories().size() > 0)){
			
			String candidate = null;
			InputDialog inputDialog = new InputDialog(null, "Entity creation", "Enter a new entity", "", null);
			if (inputDialog.open() == Window.OK){
				candidate = inputDialog.getValue();
			}
			
			if(candidate != null){
				for(IRepository repository : repositoryManager.getRepositories()){    
					for(IResource resource : repository.getResources()){
						if(resource instanceof SemanticResource){
							List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
							
							for(IFormatAssistant assistant : assistances){
								if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
									if(assistant.load((String) resource.getId())){
										List<ISemanticClass> entities = assistant.getClassesLike(candidate);
										for(Object entity : entities){
											addEntity(assistant, (ISemanticClass) entity);
										}
									}
								}
							}
						}	
					}		
				}
			}
		}  
	}
}
