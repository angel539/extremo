package metardf.core.extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.SemanticResource;

public interface IFormatAssistant {
	static List<IFormatAssistant> INSTANCES = new ArrayList<IFormatAssistant>();
	
    public boolean load(SemanticResource semanticResource);
    public List<ISemanticClass> getAllClasses();
    public List<ISemanticClass> getClassesLike(String... names);
    public List<ISemanticClass> getClassesLike(Map<String, Integer> namesByRelevance);
    public List<IDataProperty> getDataProperties(ISemanticClass parent, boolean supers, boolean equivs);
    public List<IObjectProperty> getObjectProperties(ISemanticClass parent, boolean supers, boolean equivs);
    public List<ISemanticClass> getSiblings(ISemanticClass parent);
    public List<ISemanticClass> getRelatedClasses(ISemanticClass parent, boolean supers, boolean equivs);
    public List<ISemanticClass> getSuper(ISemanticClass parent, boolean direct);
    public List<ISemanticClass> getSub(ISemanticClass parent, boolean direct);
    public List<IObjectProperty> getPath(ISemanticClass entityA, ISemanticClass entityB);
    public IObjectProperty getInverseProperty (ISemanticClass parent, IObjectProperty property);
    public List<Class<? extends ISemanticElement>> getRegisteredTypes();
    
    //public ISemanticClass asSemanticClass(Object entity);
}
