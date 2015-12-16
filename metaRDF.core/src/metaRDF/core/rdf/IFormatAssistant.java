package metaRDF.core.rdf;

import java.util.List;

import metaRDF.core.model.DataProperty;
import metaRDF.core.model.ObjectProperty;
import metaRDF.core.model.SemanticClass;

public interface IFormatAssistant {
    public void load(String path);
    public List<SemanticClass> getClassesLike(String... names); //Devuelve una lista de clases cuyo nombre es uno de los nombres en name, o bien un sinónimo.
    public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs);
    public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs);
    public List<SemanticClass> getSiblings(String name);
    public List<SemanticClass> getRelatedClasses(String name, boolean supers, boolean equivs);
    public List<SemanticClass> getSuper(String name, boolean direct);
    public List<SemanticClass> getSub(String name, boolean direct);
    public List<ObjectProperty> getPath(String entityA, String entityB);
    public ObjectProperty getInverseProperty (String cl, String property);
}
