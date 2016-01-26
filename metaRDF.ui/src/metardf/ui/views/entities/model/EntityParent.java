package metardf.ui.views.entities.model;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class EntityParent extends TreeParent{
	public EntityParent(ISemanticClass semanticclass) {
		super(semanticclass);
	}
	
	public void drawSuperClasses(){
		FolderParent supersChild = new FolderParent("supers"  + " (" + ((ISemanticClass) element).getSuperclasses().size() + ")");
		
		for(ISemanticClass superClass : ((ISemanticClass) element).getSuperclasses()){
			EntityParent entitySuper;
			
			if((superClass.getName()==null)||(superClass.getName().compareTo("")==0)) entitySuper = new EntityParent(superClass);
			else entitySuper = new EntityParent(superClass);
			supersChild.addChild(entitySuper);
		}
		
		this.addChild(supersChild);
	}
	public void drawSubclasses(){
		FolderParent subsChild = new FolderParent("subs"  + " (" + ((ISemanticClass) element).getSubclasses().size() + ")");
		
		for(ISemanticClass subClass : ((ISemanticClass) element).getSubclasses()){
			EntityParent entitySuper;
			if((subClass.getName()==null)||(subClass.getName().compareTo("")==0)) entitySuper = new EntityParent(subClass);
			else entitySuper = new EntityParent(subClass);
			subsChild.addChild(entitySuper);
		}
		
		this.addChild(subsChild);
	}
	public void drawReferences(){
		FolderParent referencesChild = new FolderParent("references" + " (" + ((ISemanticClass) element).getReferences().size() + ")");
		
		for(IObjectProperty reference : ((ISemanticClass) element).getReferences()){
			PropertyParent entitySuper = new PropertyParent(reference);
			referencesChild.addChild(entitySuper);
		}
		
		this.addChild(referencesChild);
	}
	public void drawProperties(){
		FolderParent referencesChild = new FolderParent("attributes" + " (" + ((ISemanticClass) element).getProperties().size() + ")");
		
		for(IDataProperty attribute : ((ISemanticClass) element).getProperties()){
			TreeObject entitySuper = new TreeObject(attribute);
			referencesChild.addChild(entitySuper);
		}
		
		this.addChild(referencesChild);
	}
}