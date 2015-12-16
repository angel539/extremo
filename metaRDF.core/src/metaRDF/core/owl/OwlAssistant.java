package metaRDF.core.owl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
//import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import metaRDF.core.rdf.IFormatAssistant;
import metaRDF.core.repository.MetaRDFRepositoryManager;
import metaRDF.core.model.DataProperty;
import metaRDF.core.model.Datatype;
import metaRDF.core.model.ObjectProperty;
import metaRDF.core.model.SemanticClass;
import metaRDF.core.wordnet.Wordnet;

public class OwlAssistant implements IFormatAssistant{
	private static OwlAssistant INSTANCE = null;
	
	public IRI owl_iri = null;
	public File owl_file = null;
	public String path = null;

	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLOntology ontology = null;

	public OwlAssistant() {
		super();
	}
	
	class DataOWL implements DataProperty{
		String name;
		String uri;
		Datatype range;
		boolean isFromSuper;
		String description;
		
		DataOWL(String name, String uri, Datatype type, boolean isFromSuper, String description){
			this.name = name;
			this.uri = uri;
			this.range = type;
			this.isFromSuper = isFromSuper;
			this.description = description;
		}
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public String getURI() {
			// TODO Auto-generated method stub
			return uri;
		}

		@Override
		public Datatype getRange() {
			// TODO Auto-generated method stub
			return range;
		}
		
		@Override
		public String toString() {
			return "[" + name + ", " + uri + ", " + range + "]";
		}

		@Override
		public boolean isFromSuper() {
			return isFromSuper;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return description;
		}
		
	}
	
	class SemanticOWL implements SemanticClass{
		String uri;
		String name;
		String label;
		String comment;
		List<SemanticClass> superclasses;
		List<SemanticClass> subclasses;
		List<DataProperty> properties;
		List<ObjectProperty> references;
		
		SemanticOWL(String name, String uri, String label, String description){
			this.name = name;
			this.uri = uri;
			this.label = label;
			this.comment = description;
		}
		
		@Override
		public String getUri() {
			// TODO Auto-generated method stub
			return uri;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public String getLabel() {
			String clean = label.toString().replace('_', ' ').replace('.', ' ');
			String[] spplited = StringUtils.splitByWholeSeparator(clean, null, 0);
			String joinedCapitalize = "";
			for(String s : spplited) joinedCapitalize = joinedCapitalize + WordUtils.capitalize(s);
			
			String[] wordList = StringUtils.splitByCharacterTypeCamelCase(joinedCapitalize);
			
			String parsedName = "";
			for(String s : wordList) parsedName = parsedName + s + " ";
			return parsedName;
			//return label;
		}

		@Override
		public String getComment() {
			// TODO Auto-generated method stub
			return comment;
		}

		@Override
		public List<DataProperty> getProperties() {
			// TODO Auto-generated method stub
			return properties;
		}

		@Override
		public List<ObjectProperty> getReferences() {
			// TODO Auto-generated method stub
			return references;
		}

		@Override
		public List<SemanticClass> getSuperclasses() {
			// TODO Auto-generated method stub
			return superclasses;
		}

		@Override
		public List<SemanticClass> getSubclasses() {
			// TODO Auto-generated method stub
			return subclasses;
		}
		
		@Override
		public void setProperties(List<DataProperty> properties) {
			this.properties = properties;
		}
		
		@Override
		public void addProperties(List<DataProperty> properties) {
			if (this.properties == null) this.properties = new ArrayList<DataProperty>();
			this.properties.addAll(properties);
		}

		@Override
		public void setReferences(List<ObjectProperty> references) {
			this.references = references;
		}

		@Override
		public void addReferences(List<ObjectProperty> references) {
			if (this.references == null) this.references = new ArrayList<ObjectProperty>();
			this.references.addAll(references);
		}
		
		@Override
		public void setSuperclasses(List<SemanticClass> superclasses) {
			this.superclasses = superclasses;
		}
		
		@Override
		public void addSuperclasses(List<SemanticClass> superclasses) {
			if (this.superclasses == null) this.superclasses = new ArrayList<SemanticClass>();
			this.superclasses.addAll(superclasses);
		}

		@Override
		public void setSubclasses(List<SemanticClass> subclasses) {
			this.subclasses = subclasses;
		}
		
		@Override
		public void addSubclasses(List<SemanticClass> subclasses) {
			if (this.subclasses == null) this.subclasses = new ArrayList<SemanticClass>();
			this.subclasses.addAll(subclasses);
		}
	}
	
	class ObjectOWL implements ObjectProperty{
		String name;
		String uri;
		List<String> ranges;
		boolean isFromSuper;
		String description;
		
		ObjectOWL(String name, String uri, List<String> ranges, boolean isFromSuper, String description){
			this.name = name;
			this.uri = uri;
			this.ranges = ranges;	
			this.isFromSuper = isFromSuper;
			this.description = description;
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getURI() {
			return uri;
		}

		@Override
		public List<String> getRanges() {
			return ranges;
		}
		
		@Override
		public String toString() {
			return "[" + name + ", " + uri + ", " + ranges.toString() + "]";
		}

		@Override
		public boolean isFromSuper() {
			// TODO Auto-generated method stub
			return isFromSuper;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return description;
		}
	}
	
	private OWLOntologyManager create(){
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		//m.addIRIMapper(new AutoIRIMapper(new File("materializedOntologies"), true));
		return manager;
	}
	
	public void createOntology() throws OWLOntologyCreationException{
		OWLOntologyManager m = create();
		ontology = m.createOntology(owl_iri);
	}
	
	public void createOntologyFromFile() throws OWLOntologyCreationException{
		OWLOntologyManager m = create();
		ontology = m.createOntology(owl_iri);
	}

	@Override
	public void load(String path) {
		this.path = path;
				
		if((path.startsWith("http://"))||(path.startsWith("https://"))){
			this.owl_iri = IRI.create(path);
		}else{
			this.owl_file = new File(path);
		}
		
		OWLOntologyManager m = create();
		if(owl_file==null){
			try {
				ontology = m.loadOntologyFromOntologyDocument(owl_iri);
			} catch (OWLOntologyCreationException e) {
				System.err.println("No connection");
			}
		}else{
			try {
				ontology = m.loadOntologyFromOntologyDocument(owl_file);
			} catch (OWLOntologyCreationException e) {
				System.err.println("File not found");
			}
		}
	}

	@Override
	public List<SemanticClass> getClassesLike(String... names) {
		List<SemanticClass> classes = new ArrayList<SemanticClass>();
		Map<String, List<String>> definitions = new HashMap<String, List<String>>();
		
		for(String name : names){
			
			String[] spplited = StringUtils.splitByWholeSeparator(name, null, 0);
			String joinedCapitalize = "";
			for(String s : spplited) joinedCapitalize = joinedCapitalize + WordUtils.capitalize(s);
			
			String[] wordList = StringUtils.splitByCharacterTypeCamelCase(joinedCapitalize);

			
			for(String s : wordList){
				Wordnet wordnet = new Wordnet();
				List<String> wordnetProposals = null;
				if(wordnet.isNoun(s)){
					List<List<String>> synonymsByName = wordnet.getSynonymsProposal(s);
					//conformando toda la lista de palabras a partir de los conjuntos de sinonimos
					if(synonymsByName.size() > 0){
						wordnetProposals = new ArrayList<String>();
						for(List<String> partial : synonymsByName){
							wordnetProposals.addAll(partial);
						}
					}	
				}
				
				HashSet<String> aux = new HashSet<String>(wordnetProposals);
				wordnetProposals.clear();
				wordnetProposals.addAll(aux);
				
				definitions.put(s, wordnetProposals);
			}
		}
		
		/*boolean forget = false;
		//Entry<Palabra, Lista de sinonimos>
		
		for (Entry<String, List<String>> definition : definitions.entrySet()){
			if(definition.getValue() == null) forget = true;
		}*/
		
		//if(!forget){
			//para el mapa hay que buscar una palabra en cada una de las entradas...
			
			//List<int> limits = new ArrayList<int>();
			if(ontology!=null){
				int positions[] = new int[definitions.size()];
				
				int pos = 0;
				for (Entry<String, List<String>> definition : definitions.entrySet()){
					positions[pos] = definition.getValue().size() - 1;
					pos++;
				}
				
				//System.out.println(Arrays.toString(positions));
				
				int positionEvaluated[] = new int[positions.length];
				for(int i = 0; i < positionEvaluated.length; i++) positionEvaluated[i] = 0;
				
				
				boolean moreCombinations = true;
				boolean[] pointers = new boolean[positionEvaluated.length];
				for(int i = 0; i < pointers.length; i++){
					pointers[i] = false;
				}
				
				pointers[pointers.length-1] = true;
				
				while(moreCombinations){
					// mientras que positions [3, 2, 4, 1] -> positionEvaluated [0, 0, 0, 0]
					String[] searchCombination = new String[definitions.size()];
					
					int j = 0;
					for (Entry<String, List<String>> definition : definitions.entrySet()){
						searchCombination[j] = definition.getValue().get(positionEvaluated[j]);
						j++;
					}
					
					//searchcombination done... change position evaluated
					
					//for (Entry<String, List<String>> definition : definitions.entrySet()){
					for(OWLClass clazz : ontology.getClassesInSignature()){
						String description = "";
						String label = "";
						
						for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSComment())) {
							if (annotation.getValue() instanceof OWLLiteral) {
								OWLLiteral val = (OWLLiteral) annotation.getValue();
								description = val.getLiteral();
							}
						}
						
						boolean labeled = false;
						for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSLabel())) {
							if (annotation.getValue() instanceof OWLLiteral) {
								OWLLiteral val = (OWLLiteral) annotation.getValue();
								label = val.getLiteral();
								
								boolean contained = true;
								for(int i = 0; i < searchCombination.length; i++){
									//esto está mal. no es por cada entry sino en combinacion	
									if(!val.toString().contains(searchCombination[i])){
										contained = false;
									}
									
									if(contained){
										classes.add(new SemanticOWL(clazz.getIRI().getShortForm(), clazz.getIRI().toString(), val.getLiteral(), description));
										labeled = true;
									}else{
										label = val.getLiteral();
									}
								}
								
								
								/*boolean[] contained = new boolean[searchCombination.length];
								for(int i = 0; i < contained.length; i++) contained[i] = false;
								
								for(int i = 0; i < searchCombination.length; i++){
									//esto está mal. no es por cada entry sino en combinacion	
									if(val.toString().contains(searchCombination[i])){
										contained[i] = true;
										labeled = true;		
									}
								}
								
								boolean match = true;
								for(int i = 0; i < contained.length; i++){
									if(!contained[i]){
										match = false;
										break;
									}
								}*/
								
								//if(match) classes.add(new SemanticOWL(clazz.getIRI().getShortForm(), clazz.getIRI().toString(), label, description));
								/*for(String entry : searchCombination){
									//esto está mal. no es por cada entry sino en combinacion
									if(val.toString().contains(entry.toLowerCase())){
										contained
										classes.add(new SemanticOWL(clazz.getIRI().getShortForm(), clazz.getIRI().toString(), val.getLiteral(), description));
										labeled = true;		
									}else{
										label = val.getLiteral();
									}
								}*/
							}
						}
						
						if(!labeled){
							boolean contained = true;
							for(int i = 0; i < searchCombination.length; i++){
								//esto está mal. no es por cada entry sino en combinacion	
								if(!clazz.getIRI().getShortForm().toLowerCase().contains(searchCombination[i].toLowerCase())){
									contained = false;
								}
							}
							
							if(contained) classes.add(new SemanticOWL(clazz.getIRI().getShortForm(), clazz.getIRI().toString(), label, description));
						}
					}
					
					// mientras que positions [3, 2, 4, 1] -> positionEvaluated [0, 0, 0, 0] /*3, 0, 0, 0*/
					// 0000, 0001, 0002, 0003, 0010, 0011, ...
					
					boolean[] tmpNoMoreCombination = new boolean[positions.length];
					for(int i = 0; i < tmpNoMoreCombination.length; i++) tmpNoMoreCombination[i] = false;
					
					for(int i = 0; i < positions.length; i++){
						if(positions[i] == positionEvaluated[i]) tmpNoMoreCombination[i] = true;
					}
					
					// si son todas true se acabó.
					moreCombinations = false;
					
					for(int i = 0; i < tmpNoMoreCombination.length; i++){
						if(!tmpNoMoreCombination[i]){
							moreCombinations = true;
							break;
						}
					}
					
					if(moreCombinations){
						// actualizar positionEvaluated:
						// pointers apunta a los elementos que tienen que ir variando...
						int firstPositionTrue = pointers.length - 1;
						int lastPositionTrue = pointers.length - 1;
						int currentPositionTrue = pointers.length - 1;
						
						for(int i = 0; i < pointers.length; i++){
							if(pointers[i]){
								firstPositionTrue = i;
								break;
							}
						}
						
						// mientras que positions [3, 2, 4, 1] -> positionEvaluated [0, 0, 0, 0] /*3, 0, 0, 0*/
						// 0000, 0001, 0002, 0003, 0010, 0011, ...
						
						for(int i = positionEvaluated.length-1; i >= 0; i--){
							if(pointers[i]){
								if(positionEvaluated[i] >= positions[i]){
									positionEvaluated[i] = 0;
									if((i>0) && (i < firstPositionTrue)){
										pointers[i-1] = true;
										currentPositionTrue = i;
										firstPositionTrue = i-1;
									}
								}
								else{
									if((i >= currentPositionTrue) && (i <= lastPositionTrue)){
										positionEvaluated[i] = positionEvaluated[i] + 1;
									}
									break;
								}	
							}else{
								break;
							}
						}
						
						//System.out.println(Arrays.toString(positions) + " " + Arrays.toString(positionEvaluated));
					}	
				}	
				//}
				
				/*for (String entry : wordnetProposals){
					for(OWLClass clazz : ontology.getClassesInSignature()){
						String description = "";
						String label = "";
						
						for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSComment())) {
							if (annotation.getValue() instanceof OWLLiteral) {
								OWLLiteral val = (OWLLiteral) annotation.getValue();
								description = val.getLiteral();
							}
						}
						
						boolean labeled = false;
						for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSLabel())) {
							if (annotation.getValue() instanceof OWLLiteral) {
								OWLLiteral val = (OWLLiteral) annotation.getValue();
								if(val.toString().contains(entry.toLowerCase())){
									classes.add(new SemanticOWL(clazz.getIRI().getShortForm(), clazz.getIRI().toString(), val.getLiteral(), description));
									labeled = true;
								}else{
									label = val.getLiteral();
								}
							}
						}
						
						if((!labeled) && (clazz.getIRI().getShortForm().toLowerCase().compareTo(entry.toLowerCase()) == 0)){
							classes.add(new SemanticOWL(clazz.getIRI().getShortForm(), clazz.getIRI().toString(), label, description));	
						}
					}
				}*/			
			}
		//}else{
			//return null;
		//}
		
		/*HashSet<SemanticClass> aux = new HashSet<SemanticClass>(classes);
		classes.clear();
		classes.addAll(aux);*/
		
		return classes;
	}
	
	public String getShortName(String uri){
		IRI iri = IRI.create(uri);
		
		if((ontology!=null) && (ontology.containsClassInSignature(iri))){
			OWLClass clazz = factory.getOWLClass(iri);
			return clazz.getIRI().getShortForm();
		}
		
		return "No short name";
	}
	
	/*private List<String> allTheProperties(){
		List<String> properties = new ArrayList<String>();
		for(OWLDataProperty property : ontology.getDataPropertiesInSignature()){
			properties.add(property.getIRI().toString());
		}
		return properties;
	}*/
	
	@Override
	public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs) {
		if((name == null) || name.compareTo("") == 0) return null;
		
		List<DataProperty> properties = new ArrayList<DataProperty>();
		IRI iri = IRI.create(name);
		
		if((ontology!=null) && (ontology.containsClassInSignature(iri))){
			for(OWLDataProperty property : ontology.getDataPropertiesInSignature()){
				for(OWLClassExpression domain : property.getDomains(ontology)){
					if(!domain.isAnonymous()){
						if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
							Collection<OWLDataRange> ranges = property.getRanges(ontology);
							List<String> rangeURIs = new ArrayList<String>();
							
							for(OWLDataRange range : ranges){
								rangeURIs.add(range.asOWLDatatype().getIRI().toString());
							}
							
							/*Set<OWLAnnotation> annotations = property.getAnnotations(ontology);
							for(OWLAnnotation annotation : annotations){
								annotation.
							}*/
							
							if(property.isOWLDatatype()){
								Datatype datatype = Datatype.string;
								if(property.asOWLDatatype().isBoolean()) datatype = Datatype.bool;
								if(property.asOWLDatatype().isDouble()) datatype = Datatype.real;
								if(property.asOWLDatatype().isFloat()) datatype = Datatype.real;
								if(property.asOWLDatatype().isInteger()) datatype = Datatype.integer;
								//if(property.asOWLDatatype().is) datatype = Datatype.bool;
								properties.add(new DataOWL(property.getIRI().getShortForm(), property.getIRI().toString(), datatype, supers, null));
							}
							
							if(property.isOWLDataProperty()){
								//property.asOWLDataProperty().GET
								properties.add(new DataOWL(property.getIRI().getShortForm(), property.getIRI().toString(), null, supers, null));
							}	
						}
					}
				}
			}
		}
		else{
			return null;
		}
		
		if(supers){
			List<SemanticClass> superclasses = getSuper(name, true);
			for(SemanticClass superclass : superclasses) properties.addAll(getDataProperties(superclass.getUri(), supers, equivs));
		}
		
		if(equivs){
			List<SemanticClass> superclasses = equivs(name);
			for(SemanticClass superclass : superclasses) properties.addAll(getDataProperties(superclass.getUri(), supers, equivs));
		}
		
		return properties;
	}
	
	@Override
	public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs) {
		if((name == null) || name.compareTo("") == 0) return null;
		
		List<ObjectProperty> properties = new ArrayList<ObjectProperty>();
		IRI iri = IRI.create(name);
		
		if((ontology!=null) && (ontology.containsClassInSignature(iri))){
			for(OWLObjectProperty property : ontology.getObjectPropertiesInSignature()){
				for(OWLClassExpression domain : property.getDomains(ontology)){
					if(!domain.isAnonymous()){
						if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
							//Set<OWLClassExpression> ranges = property.getRanges(ontology);
							Collection<OWLClassExpression> ranges = property.getRanges(ontology);
							List<String> rangeURIs = new ArrayList<String>();
							
							for(OWLClassExpression range : ranges){
								if(!range.isAnonymous()){
									rangeURIs.add(range.asOWLClass().getIRI().toString());
								}
							}
							
							properties.add(new ObjectOWL(property.getIRI().getShortForm(), property.getIRI().toString(), rangeURIs, supers, null));
						}
					}
				}
			}
		}
		else{
			return null;
		}
		
		if(supers){
			List<SemanticClass> superclasses = getSuper(name, true);
			for(SemanticClass superclass : superclasses) properties.addAll(getObjectProperties(superclass.getUri(), supers, equivs));
		}
		
		if(equivs){
			List<SemanticClass> superclasses = equivs(name);
			for(SemanticClass superclass : superclasses) properties.addAll(getObjectProperties(superclass.getUri(), supers, equivs));
		}
		
		return properties;
	}

	@Override
	public List<SemanticClass> getRelatedClasses(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SemanticClass> getSuper(String name, boolean direct) {
		if((name == null) || name.compareTo("") == 0) return null;
		
		List<SemanticClass> supers = new ArrayList<SemanticClass>();
		
		IRI iri = IRI.create(name);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> superclasses = clazz.getSuperClasses(ontology);
			//Collection<OWLClassExpression> superclasses = Searcher.sup(ontology.getSubClassAxiomsForSubClass(clazz));
			for(OWLClassExpression superclass : superclasses){
				if(!superclass.isAnonymous()){
					String description = "";
					String label = "";
					
					for (OWLAnnotation annotation : superclass.asOWLClass().getAnnotations(ontology, factory.getRDFSComment())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							description = val.toString();
						}
					}

					for (OWLAnnotation annotation : superclass.asOWLClass().getAnnotations(ontology, factory.getRDFSLabel())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							label = val.getLiteral();
						}
					}
					
					supers.add(new SemanticOWL(superclass.asOWLClass().getIRI().getShortForm(), superclass.asOWLClass().getIRI().toString(), label, description));
					
					if(!direct){
						supers.addAll(getSuper(superclass.asOWLClass().getIRI().toString(), direct));
					}
				}	
			}
			
		}
		else{
			System.err.println("Salta super null");
			return null;
		}
		
		return supers;
	}

	private List<SemanticClass> equivs(String name){
		if((name == null) || name.compareTo("") == 0) return null;
		
		List<SemanticClass> equivs = new ArrayList<SemanticClass>();
		IRI iri = IRI.create(name);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> equivalents = clazz.getEquivalentClasses(ontology);
			//Collection<OWLClassExpression> equivalents = EntitySearcher.getEquivalentClasses(clazz, ontology);
			for(OWLClassExpression equivalent : equivalents){
				if(!equivalent.isAnonymous()){
					String description = "";
					String label = "";
					
					for (OWLAnnotation annotation : equivalent.asOWLClass().getAnnotations(ontology, factory.getRDFSComment())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							description = val.toString();
						}
					}

					for (OWLAnnotation annotation : equivalent.asOWLClass().getAnnotations(ontology, factory.getRDFSLabel())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							label = val.getLiteral();
						}
					}
					
					equivs.add(new SemanticOWL(equivalent.asOWLClass().getIRI().getShortForm(), equivalent.asOWLClass().getIRI().toString(), label, description));
					//equivs.add(equivalent.asOWLClass().getIRI().toString());
				}	
			}
			
		}
		else{
			return null;
		}
		
		return equivs;
	}
	
	@Override
	public List<SemanticClass> getSub(String name, boolean direct) {
		if((name == null) || name.compareTo("") == 0) return null;
		
		List<SemanticClass> subs = new ArrayList<SemanticClass>();
		IRI iri = IRI.create(name);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> subclasses = clazz.getSubClasses(ontology);
			//Collection<OWLClassExpression> subclasses = Searcher.sub(ontology.getSubClassAxiomsForSuperClass(clazz));
			for(OWLClassExpression subclass : subclasses){
				
				
				if(!subclass.isAnonymous()){
					String description = "";
					String label = "";
					
					for (OWLAnnotation annotation : subclass.asOWLClass().getAnnotations(ontology, factory.getRDFSComment())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							description = val.toString();
						}
					}

					for (OWLAnnotation annotation : subclass.asOWLClass().getAnnotations(ontology, factory.getRDFSLabel())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							label = val.getLiteral();
						}
					}
					
					subs.add(new SemanticOWL(subclass.asOWLClass().getIRI().getShortForm(), subclass.asOWLClass().getIRI().toString(), label, description));
					//subs.add(subclass.asOWLClass().getIRI().toString());
					if(!direct){
						subs.addAll(getSub(subclass.asOWLClass().getIRI().toString(), direct));
					}
				}	
			}
			
		}
		else{
			return null;
		}
		
		return subs;
	}

	@Override
	public ObjectProperty getInverseProperty(String cl, String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SemanticClass> getSiblings(String name) {
		List<SemanticClass> superclasses = getSuper(name, true);
		List<SemanticClass> siblings = new ArrayList<SemanticClass>();
		for(SemanticClass superclass : superclasses){
			siblings.addAll(getSub(superclass.getUri(), true));
		}
		
		HashSet<SemanticClass> aux = new HashSet<SemanticClass>(siblings);
		siblings.clear();
		siblings.addAll(aux);
		
		return siblings;
	}
	
	@Override
	public List<ObjectProperty> getPath(String start, String finish) {
		List<ObjectProperty> path = new LinkedList<ObjectProperty>();
		
		if(start.compareTo(finish) == 0) return path;
		
		IRI iriA = IRI.create(start);
		IRI iriB = IRI.create(finish);
		
		if((!ontology.containsClassInSignature(iriA))||(!ontology.containsClassInSignature(iriB))) return null;
		
		List<ObjectProperty> objectPropertiesA = getObjectProperties(start, true, true);
		
		for(ObjectProperty property : objectPropertiesA){
			if(property.getURI().compareTo(iriB.toString())==0){
				path.clear();
				path.add(property);
				return path;
			}
		}
		
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		Map<String, String> prev = new HashMap<String, String>();
		
	    Queue<String> q = new LinkedList<String>();
	    String current = start;
	    q.add(current);
	    visited.put(current, true);
	    
	    while(!q.isEmpty()){
	        current = q.remove();
	        if (current.equals(finish)){
	            break;
	        }
	        else{
	            for(ObjectProperty node : getObjectProperties(current, true, true)){
	            	for(String range : node.getRanges()){
	            		if(!visited.containsKey(range)){
	            			q.add(range);
		                    visited.put(range, true);
		                    prev.put(range, current);
	            		}
	            	}
	            }
	        }
	    }
	    if (!current.equals(finish)){
	        System.out.println("can't reach destination");
	    }
	    
		return path;
	}
	
		private static void createInstance() {
		   	 if (INSTANCE == null) {
		   		 synchronized(MetaRDFRepositoryManager.class) {
		   			 if (INSTANCE == null) {
		   				 INSTANCE = new OwlAssistant();
		   			 }
		   		 }
		     }
		}

	   public static OwlAssistant getInstance() {
	       if (INSTANCE == null){
	       	createInstance();
	       }
	       return INSTANCE;
	   }
	   
	   public Object clone() throws CloneNotSupportedException {
	   	throw new CloneNotSupportedException(); 
	   }
}
