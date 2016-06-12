package metardf.ui.views.entities;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metardf.ui.views.entities.model.AttributeFolderTreeParent;
import metardf.ui.views.entities.model.DataPropertyTreeObject;
import metardf.ui.views.entities.model.SemanticClassTreeParent;
import metardf.ui.views.entities.model.FolderTreeParent;
import metardf.ui.views.entities.model.ObjectPropertyTreeParent;

public class EntityTreeViewDrawingProvider {
	public static void drawEntityParentContent(SemanticClassTreeParent entityParent) {
		drawSuperClasses(entityParent);
		drawSubclasses(entityParent);
		drawReferences(entityParent);
		drawProperties(entityParent);
	}
	
	public static void drawSuperClasses(SemanticClassTreeParent parent){
		int superClassesCount = 0;
		
		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass && ((ISemanticClass) parent.getSemanticElement()).getSuperclasses() != null){
				superClassesCount = superClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSuperclasses().size();
			}
			if(superClassesCount > 0){
				FolderTreeParent supersChild = new FolderTreeParent("supers");
				
				if(parent.getSemanticElement() instanceof ISemanticClass){
					for(ISemanticClass superClass : ((ISemanticClass) parent.getSemanticElement()).getSuperclasses()){
						SemanticClassTreeParent entitySuperClass = new SemanticClassTreeParent(superClass);
						supersChild.addChild(entitySuperClass);
					}
				}
				
				parent.addChild(supersChild);
			}
		}
	}
	
	public static void drawSubclasses(SemanticClassTreeParent parent){
		int subClassesCount = 0;

		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass && ((ISemanticClass) parent.getSemanticElement()).getSubclasses() != null){
				subClassesCount = subClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSubclasses().size();
			}
			if(subClassesCount > 0){
				FolderTreeParent subsChild = new FolderTreeParent("subs");
				
				if(parent.getSemanticElement() instanceof ISemanticClass){
					for(ISemanticClass subClass : ((ISemanticClass) parent.getSemanticElement()).getSubclasses()){
						SemanticClassTreeParent entitySubClass = new SemanticClassTreeParent(subClass);
						subsChild.addChild(entitySubClass);
					}
				}
				
				parent.addChild(subsChild);
			}
		}
		
	}
	
	public static void drawReferences(SemanticClassTreeParent parent){
		int referencesCount = 0;
		
		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass && ((ISemanticClass) parent.getSemanticElement()).getReferences() != null){
				referencesCount = referencesCount + ((ISemanticClass) parent.getSemanticElement()).getReferences().size();
			}
			if(referencesCount > 0 ){
				FolderTreeParent referencesChild = new FolderTreeParent("references");
				
				if(parent.getSemanticElement() instanceof ISemanticClass){
			
					for(IObjectProperty reference : ((ISemanticClass) parent.getSemanticElement()).getReferences()){
						ObjectPropertyTreeParent entitySuper = new ObjectPropertyTreeParent(reference);
						referencesChild.addChild(entitySuper);
					}
				}
				
				parent.addChild(referencesChild);
			}
		}
		
	}
	
	private static void drawProperties(SemanticClassTreeParent parent){
		int propertiesCount = 0;
		
		if(parent != null && parent.getSemanticElement() != null){
			if(parent.getSemanticElement() instanceof ISemanticClass && ((ISemanticClass) parent.getSemanticElement()).getProperties() != null){
				propertiesCount = propertiesCount + ((ISemanticClass) parent.getSemanticElement()).getProperties().size();
			}
			if(propertiesCount > 0){
				AttributeFolderTreeParent referencesChild = new AttributeFolderTreeParent("attributes");
				
				if(parent.getSemanticElement() instanceof ISemanticClass){
					for(IDataProperty attribute : ((ISemanticClass) parent.getSemanticElement()).getProperties()){
						DataPropertyTreeObject entitySuper = new DataPropertyTreeObject(attribute);
						referencesChild.addChild(entitySuper);
					}
				}
				
				parent.addChild(referencesChild);
			}
		}
	}
}
