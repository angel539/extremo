package metardf.core.rdf.assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.util.FileManager;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.SemanticResource;
import metaRDF.core.utils.LangUtils;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.core.rdf.assistant.model.RDFDataDataProperty;
import metardf.core.rdf.assistant.model.RDFDataObjectProperty;
import metardf.core.rdf.assistant.model.RDFDataSemanticClass;

public class RdfAssistant extends FormatAssistant implements IFormatAssistant {
	InfModel model = null;
	SemanticResource semanticResource = null;
	
	public RdfAssistant() {
	}

	@Override
	public boolean load(SemanticResource semanticResource) {
		this.semanticResource = semanticResource;
		if(semanticResource != null && semanticResource.getIdToString() != null){
			Model modelTmp = FileManager.get().loadModel(semanticResource.getIdToString());
			
			model = ModelFactory.createRDFSModel(modelTmp);
			ValidityReport validity = model.validate();
			
			if (validity.isValid()) {
			    return true;
			} else {
				return false;
			    /*System.out.println("Conflicts");
			    for (Iterator i = validity.getReports(); i.hasNext(); ) {
			        System.out.println(" - " + i.next());
			    }*/
			}
		}
		return false;
	}

	@Override
	public List<ISemanticClass> getAllClasses() {
		List<ISemanticClass> allSemanticClasses = new ArrayList<ISemanticClass>();
		if(model != null){
			StmtIterator iterator = model.listStatements(
	        		new SimpleSelector(null, null, (RDFNode) null) {
	                    @Override
	                    public boolean selects(Statement s) {
	                            return s.getObject().toString().endsWith("#Resource");
	                    }  
	                }
	            );
			
			//List<String> lines = new ArrayList<String>();
			
			while(iterator.hasNext()){
				/*Resource subject = iterator.nextStatement().getSubject();
				//Property predicate = iterator.nextStatement().getPredicate();
				RDFNode object = iterator.nextStatement().getObject();
				
				String s = "";
				if(subject != null) s = s + "subject: " + subject.toString();
				//if(predicate != null) s = s + "predicate: " + predicate.toString();
				if(object!= null) s = s + "_object: " + object.toString();
				System.out.println(s);*/
				Statement statement = iterator.nextStatement();
				Resource subject = statement.getSubject();
				//lines.add(iterator.nextStatement().toString());
				RDFDataSemanticClass semanticClass = new RDFDataSemanticClass(subject, subject.getLocalName(), subject.getURI());
				allSemanticClasses.add(semanticClass);
				
				//System.out.println(iterator.nextStatement());
			}
			
			/*Path file = Paths.get("the-file-name.txt");
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e) {
			}*/
		}
		return allSemanticClasses;
	}

	@Override
	public List<ISemanticClass> getClassesLike(String... names) {
		List<ISemanticClass> semanticClasses = new ArrayList<ISemanticClass>();
		
		if(model != null){
			for(String name : names){
				StmtIterator iterator = model.listStatements(
		        		new SimpleSelector(null, null, (RDFNode) null) {
		                    @Override
		                    public boolean selects(Statement s) {
		                    	if(s.getObject().toString().endsWith("#Resource")){
		                    		List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(s.getSubject().getLocalName());
		                    		for(String wordInName : wordInNameClass){
		    							if(LangUtils.haveTheSameStem(wordInName, name)){
		    								return true;
		    							}
		    						}
		                    	}
		                    	return false;
		                    }  
		                }
		            );
				
				while(iterator.hasNext()){
					/*RDFDataSemanticClass semanticClass = new RDFDataSemanticClass(, ((EClass) obj).getName(), ((EClass) obj).getName());
					semanticClass.setResourceFrom(semanticResource);
					classes.add((ISemanticClass) semanticClass);*/
					
					Statement statement = iterator.nextStatement();
					Resource subject = statement.getSubject();
					RDFDataSemanticClass semanticClass = new RDFDataSemanticClass(subject, subject.getLocalName(), subject.getURI());
					semanticClasses.add(semanticClass);
				}
			}	
		}
		return semanticClasses;
		
		//TRANQUILO, TRABAJA QUE LO ESTAS HACIENDO BIEN. DEBES AHORA COGER Y LIMPIAR
		// LA BUSQUEDA RDF COPIANDO LO QUE HACES EN ECORE.
		// QUEDAN DIAS DUROS. PERO LO VAS A CONSEGUIR :)
	}

	@Override
	public List<ISemanticClass> getClassesLike(Map<String, Integer> namesByRelevance) {
		List<ISemanticClass> semanticClasses = new ArrayList<ISemanticClass>();
		
		if(model != null){
			for(Entry<String, Integer> name : namesByRelevance.entrySet()){
				// max weight iterator selector
				
				StmtIterator iteratorExactMatch = model.listStatements(
		        		new SimpleSelector(null, null, (RDFNode) null) {
		                    @Override
		                    public boolean selects(Statement s) {
		                    	if(s.getObject().toString().endsWith(name.getKey())){
		                    		return true;
		                    	}
								return false;
		                    }  
		                }
		            );
				
				while(iteratorExactMatch.hasNext()){					
					Statement statement = iteratorExactMatch.nextStatement();
					Resource subject = statement.getSubject();
					RDFDataSemanticClass semanticClass = new RDFDataSemanticClass(subject, subject.getLocalName(), subject.getURI());
					semanticClass.setWeight(name.getValue() + 500);
					semanticClass.setResourceFrom(semanticResource);
					semanticClasses.add(semanticClass);
				}
				
				StmtIterator iteratorNearMatch = model.listStatements(
		        		new SimpleSelector(null, null, (RDFNode) null) {
		                    @Override
		                    public boolean selects(Statement s) {
		                    	if(s.getObject().toString().endsWith("#Resource")){
		                    		List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(s.getSubject().getLocalName());
		                    		for(String wordInName : wordInNameClass){
		    							if(LangUtils.haveTheSameStem(wordInName, name.getKey())){
		    								return true;
		    							}
		    						}
		                    	}
		                    	return false;
		                    }  
		                }
		            );
				
				while(iteratorNearMatch.hasNext()){					
					Statement statement = iteratorNearMatch.nextStatement();
					Resource subject = statement.getSubject();
					RDFDataSemanticClass semanticClass = new RDFDataSemanticClass(subject, subject.getLocalName(), subject.getURI());
					semanticClass.setWeight(name.getValue() + 100);
					semanticClass.setResourceFrom(semanticResource);
					semanticClasses.add(semanticClass);
				}
			}	
		}
		return semanticClasses;
	}

	@Override
	public List<IDataProperty> getDataProperties(Object parent, boolean supers, boolean equivs) {
		List<IDataProperty> properties = new ArrayList<IDataProperty>();
		return properties;
	}

	@Override
	public List<IObjectProperty> getObjectProperties(Object parent, boolean supers, boolean equivs) {
		List<IObjectProperty> properties = new ArrayList<IObjectProperty>();
		return properties;
	}

	@Override
	public List<ISemanticClass> getSiblings(Object parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISemanticClass> getRelatedClasses(Object parent, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISemanticClass> getSuper(Object parent, boolean direct) {
		List<ISemanticClass> supers = new ArrayList<ISemanticClass>();
		return supers;
	}

	@Override
	public List<ISemanticClass> getSub(Object parent, boolean direct) {
		List<ISemanticClass> subs = new ArrayList<ISemanticClass>();
		return subs;
	}

	@Override
	public List<IObjectProperty> getPath(Object entityA, Object entityB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IObjectProperty getInverseProperty(Object parent, Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends ISemanticElement>> getRegisteredTypes() {
		List<Class<? extends ISemanticElement>> types = new ArrayList<Class<? extends ISemanticElement>>();
		types.add(RDFDataSemanticClass.class);
		types.add(RDFDataObjectProperty.class);
		types.add(RDFDataDataProperty.class);
		return types;
	}
	
	public static void main (String args[]) {
		RdfAssistant assistant = new RdfAssistant();
		boolean loaded = assistant.load(new SemanticResource("http://www.oegov.us/democracy/us/federal/agency/owl/us1dhs", "US1DHS"));
		
		if(loaded){
			List<ISemanticClass> classes = assistant.getClassesLike("agency");
			System.out.println(classes.toString());
		}
	}
}
