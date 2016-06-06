package metardf.ui.views.entities;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.DataPropertyObject;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.FolderParent;
import metardf.ui.views.entities.model.PropertyParent;

public class EntityTreeViewDrawingProvider {
	public static void drawEntityParentContent(EntityParent entityParent) {
		drawSuperClasses(entityParent);
		drawSubclasses(entityParent);
		drawReferences(entityParent);
		drawProperties(entityParent);
	}
	
	public static void drawSuperClasses(EntityParent parent){
		int superClassesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			superClassesCount = superClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSuperclasses().size();
		}
		if(superClassesCount > 0){
			FolderParent supersChild = new FolderParent("supers");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(ISemanticClass superClass : ((ISemanticClass) parent.getSemanticElement()).getSuperclasses()){
					EntityParent entitySuperClass = new EntityParent(superClass);
					supersChild.addChild(entitySuperClass);
				}
			}
			
			parent.addChild(supersChild);
		}
	}
	
	public static void drawSubclasses(EntityParent parent){
		int subClassesCount = 0;

		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass){
				subClassesCount = subClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSubclasses().size();
			}
			if(subClassesCount > 0){
				FolderParent subsChild = new FolderParent("subs");
				
				if(parent.getSemanticElement() instanceof ISemanticClass){
					for(ISemanticClass subClass : ((ISemanticClass) parent.getSemanticElement()).getSubclasses()){
						EntityParent entitySubClass = new EntityParent(subClass);
						subsChild.addChild(entitySubClass);
					}
				}
				
				parent.addChild(subsChild);
			}
		}
		
	}
	
	public static void drawReferences(EntityParent parent){
		int referencesCount = 0;
		
		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass){
				referencesCount = referencesCount + ((ISemanticClass) parent.getSemanticElement()).getReferences().size();
			}
			if(referencesCount > 0 ){
				FolderParent referencesChild = new FolderParent("references");
				
				if(parent.getSemanticElement() instanceof ISemanticClass){
			
					for(IObjectProperty reference : ((ISemanticClass) parent.getSemanticElement()).getReferences()){
						PropertyParent entitySuper = new PropertyParent(reference);
						referencesChild.addChild(entitySuper);
					}
				}
				
				parent.addChild(referencesChild);
			}
		}
		
	}
	
	private static void drawProperties(EntityParent parent){
		int propertiesCount = 0;
		
		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass){
				propertiesCount = propertiesCount + ((ISemanticClass) parent.getSemanticElement()).getProperties().size();
			}
			if(propertiesCount > 0){
				AttrFolderParent referencesChild = new AttrFolderParent("attributes");
				
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
}
