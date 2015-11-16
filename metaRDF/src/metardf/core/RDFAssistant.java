package metardf.core;

import java.util.List;
import metardf.model.DataProperty;
import metardf.model.ObjectProperty;

public class RDFAssistant implements IFormatAssistant {
	public RDFAssistant(){
		super();	
	}
	/*
	@Override
	public void load(String IRI) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Entity> getEntities() {
		String query = "SELECT DISTINCT ?class ?label "
				+ "WHERE {"
					+ "?s a ?class ."
					+ "?class rdfs:label ?label ."
				+ "}"
					+ "LIMIT 20"
					+ "OFFSET 0";
		
		QueryEngineHTTP qexec = new QueryEngineHTTP("http://dbpedia.org/sparql", query);
		List<String> defaultGraphURIs=new LinkedList<String>();
		defaultGraphURIs.add("http://dbpedia.org");
		qexec.setDefaultGraphURIs(defaultGraphURIs);
	
		try{
			ResultSet results = qexec.execSelect();

			while(results.hasNext()){
				QuerySolution soln = results.nextSolution() ;
				
				Resource resclass = soln.getResource("class");
				Literal reslabel = soln.getLiteral("label");
		    }
		}
		finally{
			qexec.close();
		}
		
		List<Resource> subclasses = new ArrayList<Resource>();
		
		return null;
	}

	@Override
	public void getProperties(Entity entity) {
		List<Resource> properties = new ArrayList<Resource>();
		
		String query = "select distinct ?property where { "
				+ "?property <http://www.w3.org/2000/01/rdf-schema#domain> "
				+ "<http://dbpedia.org/ontology/"+ entity.getName() + "> . }";
		
		
		QueryEngineHTTP qexec = new QueryEngineHTTP("http://dbpedia.org/sparql", query);
		List<String> defaultGraphURIs=new LinkedList<String>();
		defaultGraphURIs.add("http://dbpedia.org");
		qexec.setDefaultGraphURIs(defaultGraphURIs);
	
		try{
			ResultSet results = qexec.execSelect();

			while(results.hasNext()){
				QuerySolution soln = results.nextSolution() ;
				Resource resproperty = soln.getResource("property");
				properties.add(resproperty);
		    }
		}
		finally{
			qexec.close();
		}
		//return null;
	}

	@Override
	public List<Entity> getSuper(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRelation(Entity entityA, Entity entityB) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription(Descriptor descriptor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> getSub(Entity entity) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public Map<Entity, Entity> getSubRecursivelly(Entity entity) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}
	*/

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getClassesLike(String... names) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSiblings(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRelatedClasses(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSuper(String name, boolean direct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSub(String name, boolean direct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObjectProperty> getPath(String entityA, String entityB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectProperty getInverseProperty(String cl, String property) {
		// TODO Auto-generated method stub
		return null;
	}
}
