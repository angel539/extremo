package metardf.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.apache.jena.query.*;

public class SparqQLGenerator {
	//Classes
	 List<Resource> getSubClasses(String className){
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
				
				//reconoce que el parametro que devuelve el select es un Literal o un recurso=CLASE
				Resource resclass = soln.getResource("class");
				Literal reslabel = soln.getLiteral("label");
				
				//Iterator properties = resclass.listProperties();
				//while(properties.hasNext()) System.out.println(properties.next());
				
				System.out.println(resclass);
				System.out.println(">>" + reslabel.getLanguage() + " " + reslabel.getLexicalForm());
				
				System.out.println(soln  + " " + resclass + " " + reslabel);
		    }
		}
		finally{
			qexec.close();
		}
		
		List<Resource> subclasses = new ArrayList<Resource>();
		return subclasses;
	}
		
	//Attributes
	List<Resource> getAttributes(String className){
		List<Resource> properties = new ArrayList<Resource>();
		
		String query = "select distinct ?property where { "
				+ "?property <http://www.w3.org/2000/01/rdf-schema#domain> "
				+ "<http://dbpedia.org/ontology/"+ className + "> . }";
		
		/*String query = "SELECT DISTINCT ?property WHERE {"
				+ "?instance a <http://dbpedia.org/ontology/" + className + "> . "
				+ "?instance ?property ?obj . } "
				+ "LIMIT 100 "
				+ "OFFSET 0";*/
		
		
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
		
		return properties;
	}
}

/*
SELECT DISTINCT ?class ?label WHERE {
	?s a ?class .
	?class rdfs:label ?label .
}
LIMIT 100
OFFSET 0
*/

/*
select distinct ?property where { 
        ?property <http://www.w3.org/2000/01/rdf-schema#domain> 
                     <http://dbpedia.org/ontology/Person> . }
 */

/*
select distinct ?property where {
 ?instance a <http://dbpedia.org/ontology/Person> . 
 ?instance ?property ?obj . }
 */

//Literal reslabel = soln.getLiteral("label");

//Iterator properties = resclass.listProperties();
//while(properties.hasNext()) System.out.println(properties.next());
