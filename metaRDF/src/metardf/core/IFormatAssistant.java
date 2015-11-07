package metardf.core;

import java.util.List;
import java.util.Map;

import metardf.model.semantics.Descriptor;
import metardf.model.semantics.Entity;

public interface IFormatAssistant {
	public void load(String IRI); //cargar el documento de ontologias
	//recuperar todas las entidades de unagia
	//cargar las entidades (en owl, i.e. son entidades las clases y las propiedades)
	//puede haber un getEntities() y un getClasses()
	public List<Entity> getEntities(); 
	//recuperar todas las propiedades dada un nombre o una entidad
	public void getProperties(Entity entity);
	//recuperar todas las clases de las que heredo
	public List<Entity> getSuper(Entity entity);
	//recuperar todas las clases que heredan de mi (directamente)
	public List<Entity> getSub(Entity entity);
	//recuperar todas las clases que estan por debajo en una jerarquia de clases (todas)
	public Map<Entity, Entity> getSubRecursivelly(Entity entity);
	//saber si dos clases se encuentran relacionadas
	public boolean getRelation(Entity entityA, Entity entityB);
	//obtener la descripcion de una entidad o una propiedad
	public String getDescription(Descriptor descriptor);
	//hacer la informacion cargada persistente, en un XMI, ecore... 
	public boolean save();
}
