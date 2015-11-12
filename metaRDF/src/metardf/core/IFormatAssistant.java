package metardf.core;

import java.util.List;

import metardf.model.DataProperty;
import metardf.model.ObjectProperty;

public interface IFormatAssistant {
    public void load(String path);
    public List<String> getClassesLike(String... names); //Devuelve una lista de clases cuyo nombre es uno de los nombres en name, o bien un sinónimo.
    public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs);
    public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs);
    public List<String> getSiblings(String name);
    public List<String> getRelatedClasses(String name, boolean supers, boolean equivs);
    public List<String> getSuper(String name, boolean direct);
    public List<String> getSub(String name, boolean direct);
    public List<String> getPath(String entityA, String entityB, boolean indirect);
    public ObjectProperty getInverseProperty (String cl, String property);
}
