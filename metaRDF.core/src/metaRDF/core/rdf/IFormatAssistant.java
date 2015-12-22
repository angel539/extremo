package metaRDF.core.rdf;

import java.util.List;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public interface IFormatAssistant {
    public void load(String path);
    public List<ISemanticClass> getClassesLike(String... names); //Devuelve una lista de clases cuyo nombre es uno de los nombres en name, o bien un sinónimo.
    public List<IDataProperty> getDataProperties(String name, boolean supers, boolean equivs);
    public List<IObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs);
    public List<ISemanticClass> getSiblings(String name);
    public List<ISemanticClass> getRelatedClasses(String name, boolean supers, boolean equivs);
    public List<ISemanticClass> getSuper(String name, boolean direct);
    public List<ISemanticClass> getSub(String name, boolean direct);
    public List<IObjectProperty> getPath(String entityA, String entityB);
    public IObjectProperty getInverseProperty (String cl, String property);
}
