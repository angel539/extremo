package metardf.ui.views.repositories.model;

import org.eclipse.jface.dialogs.MessageDialog;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;

public class RepositoryParent extends TreeParent{
	IRepository repository;
	
	public RepositoryParent(IRepository repository) {
		super(repository.getName());
		this.repository = repository;
	}	
	
	public void drawResources(){		
		for(IResource resource : repository.getResources()){
			ResourceObject object = new ResourceObject(resource);
			if(!object.getResource().isAlive()) showMessage("Resource + " + object.getName() + " seems not to be at your disposal");
			this.addChild(object);
		}
	}
	
	public void redrawResources(){
		for(TreeObject child : this.getChildren()){
			this.removeChild(child);
		}
		
		for(IResource resource : repository.getResources()){
			ResourceObject object = new ResourceObject(resource);
			if(!object.getResource().isAlive()) showMessage("Resource + " + object.getName() + " seems not to be at your disposal");
			this.addChild(object);
		}
	}
	
	public IRepository getRepository() {
		return repository;
	}

	public void setRepository(IRepository repository) {
		this.repository = repository;
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(null, "Repositories", message);
	}
}
