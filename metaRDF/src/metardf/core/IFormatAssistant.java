package metardf.core;

import java.util.List;

public interface IFormatAssistant {
	 //cargar un recurso con información semántica
    public void load(String resource);     // could be a URI or a URL in the future
    
    // Devuelve una lista de clases cuyo nombre es uno de los nombres en name, o bien
    // un sinónimo
    public List<String> getClassesLike(String... names);
    // recuperar todas las propiedades de tipo primitivo de una clase que se llame name, y
    // de todas las clases equivalentes si equivs es true, y de todas las super clases si supers es true
    public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs);
    // recuperar todas las propiedades de tipo objeto de una clase que se llame name, y
    // de todas las clases equivalentes si equivs es true, y de todas las super clases si supers es true
    public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs);    
        
    //recuperar todas las clases relacionadas con la clase name name
    public List<String> getRelatedClasses(String name, boolean supers, boolean equivs);
        
    //recuperar todas las clases de las que heredo. Sólo las directas si direct es true
    public List<String> getSuper(String name, boolean direct);
    //recuperar todas las clases que heredan de mi (directamente si direct es true)
    public List<String> getSub(String entity, boolean direct);
    
 // saber si dos clases se encuentran relacionadas (directa o indirectamente si indirect es true).
    // devuelve la Lista de OBjectProperty que van de A a B
    public List<ObjectProperty> getPath(String entityA, String entityB, boolean indirect);
    
    // Returns the inverse property of cl.property, if any
    public ObjectProperty getInverseProperty (String cl, String property);
    // other methods to query property characteristics (symmetric, functional, etc) can also be added 
}
