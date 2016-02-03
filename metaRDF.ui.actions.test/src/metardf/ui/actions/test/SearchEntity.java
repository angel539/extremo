package metardf.ui.actions.test;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.dnd.ResourceViewAction;
import metardf.ui.views.entities.EntityView;
import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.DataPropertyObject;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.FolderParent;
import metardf.ui.views.entities.model.PropertyParent;
import metardf.ui.views.entities.model.SearchParent;

public class SearchEntity extends ResourceViewAction {
	public SearchEntity() {
	}
	
	@Override
	public void execute() {
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		
		if((repositoryManager!=null) && (repositoryManager.getRepositories()!=null) && (repositoryManager.getRepositories().size() > 0)){
			String candidate = null;
			
			InputDialog inputDialog = new InputDialog(null, "Search", "Enter a list of words", "", null);
			if (inputDialog.open() == Window.OK){
				candidate = inputDialog.getValue();
			}
			
			if(candidate != null){
				SearchParent search = createSearchParent(candidate);
				
				List<ISemanticClass> searchResults = search(candidate);
				for(ISemanticClass entity : searchResults){
					EntityParent parent = new EntityParent(entity);
					drawEntityParentContent(parent);
					search.addChild(parent);
				}
				
				if(this.view instanceof EntityView){
					((EntityView) this.view).getInvisibleRoot().addChild(search);
					((EntityView) this.view).getViewer().refresh();
				}
			}
		}  
	}
	
	protected List<ISemanticClass> search(String candidate) {
		List<ISemanticClass> searchResults = new ArrayList<ISemanticClass>();
		
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
		//searching
		for(IRepository repository : repositoryManager.getRepositories()){    
			for(IResource resource : repository.getResources()){
				if(resource instanceof SemanticResource){			
					for(IFormatAssistant assistant : assistances){
						if((resource.isAlive()) && (resource.getAssistant() != null)){
							if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
								if((resource != null) && (resource instanceof SemanticResource) && (assistant.load((SemanticResource) resource))){	
									List<ISemanticClass> entities = assistant.getClassesLike(candidate);
									for(ISemanticClass entity : entities){
										defineEntity(assistant, entity);
										searchResults.add(entity);
									}
								}
							}
						}
					}
				}	
			}		
		}
		
		return searchResults;
	}

	private SearchParent createSearchParent(String search) {
		SearchParent searchParent = new SearchParent(search);
		return searchParent;
	}
	
	protected void defineEntity(IFormatAssistant assistant, ISemanticElement entity){
		if(entity instanceof ISemanticClass){
			List<ISemanticClass> superclasses = assistant.getSuper(entity.getId(), false);
			((ISemanticClass) entity).setSuperclasses(superclasses);
			List<ISemanticClass> subclasses = assistant.getSub(entity.getId(), false);
			((ISemanticClass) entity).setSubclasses(subclasses);
			List<IObjectProperty> references = assistant.getObjectProperties(entity.getId(), true, true);
			((ISemanticClass) entity).setReferences(references);
			List<IDataProperty> properties = assistant.getDataProperties(entity.getId(), true, true);
			((ISemanticClass) entity).setProperties(properties);
		}
	}
	
	protected void drawEntityParentContent(EntityParent entityParent) {
		drawSuperClasses(entityParent);
		drawSubclasses(entityParent);
		drawReferences(entityParent);
		drawProperties(entityParent);
	}
	
	public void drawSuperClasses(EntityParent parent){
		int superClassesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			superClassesCount = superClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSuperclasses().size();
		}
		if(superClassesCount > 0){
			FolderParent supersChild = new FolderParent("supers"  + " (" + superClassesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(ISemanticClass superClass : ((ISemanticClass) parent.getSemanticElement()).getSuperclasses()){
					EntityParent entitySuperClass = new EntityParent(superClass);
					supersChild.addChild(entitySuperClass);
				}
			}
			
			parent.addChild(supersChild);
		}
	}
	
	public void drawSubclasses(EntityParent parent){
		int subClassesCount = 0;

		if(parent.getSemanticElement() instanceof ISemanticClass){
			subClassesCount = subClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSubclasses().size();
		}
		if(subClassesCount > 0){
			FolderParent subsChild = new FolderParent("subs"  + " (" + subClassesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(ISemanticClass subClass : ((ISemanticClass) parent.getSemanticElement()).getSubclasses()){
					EntityParent entitySubClass = new EntityParent(subClass);
					subsChild.addChild(entitySubClass);
				}
			}
			
			parent.addChild(subsChild);
		}
		
	}
	public void drawReferences(EntityParent parent){
		int referencesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			referencesCount = referencesCount + ((ISemanticClass) parent.getSemanticElement()).getReferences().size();
		}
		if(referencesCount > 0 ){
			FolderParent referencesChild = new FolderParent("references" + " (" + referencesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
		
				for(IObjectProperty reference : ((ISemanticClass) parent.getSemanticElement()).getReferences()){
					PropertyParent entitySuper = new PropertyParent(reference);
					referencesChild.addChild(entitySuper);
				}
			}
			
			parent.addChild(referencesChild);
		}
		
	}
	public void drawProperties(EntityParent parent){
		int propertiesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			propertiesCount = propertiesCount + ((ISemanticClass) parent.getSemanticElement()).getProperties().size();
		}
		if(propertiesCount > 0){
			AttrFolderParent referencesChild = new AttrFolderParent("attributes" + " (" + propertiesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(IDataProperty attribute : ((ISemanticClass) parent.getSemanticElement()).getProperties()){
					DataPropertyObject entitySuper = new DataPropertyObject(attribute);
					referencesChild.addChild(entitySuper);
				}
			}
			
			parent.addChild(referencesChild);
		}
	}
}
