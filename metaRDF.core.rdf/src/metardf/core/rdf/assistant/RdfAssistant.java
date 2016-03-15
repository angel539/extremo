package metardf.core.rdf.assistant;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.core.rdf.assistant.model.RDFDataDataProperty;
import metardf.core.rdf.assistant.model.RDFDataObjectProperty;
import metardf.core.rdf.assistant.model.RDFDataSemanticClass;

public class RdfAssistant extends FormatAssistant implements IFormatAssistant {
	public RdfAssistant() {
	}

	@Override
	public boolean load(SemanticResource semanticResource) {
        Model model = ModelFactory.createDefaultModel();
        
        InputStream in = FileManager.get().open(semanticResource.getIdToString());
        if (in == null) {
        	return false;
        }
        model.read(in, "");
        model.write(System.out);
        
		return false;
	}

	@Override
	public List<ISemanticClass> getAllClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISemanticClass> getClassesLike(String... names) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISemanticClass> getClassesLike(Map<String, Integer> namesByRelevance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IDataProperty> getDataProperties(Object parent, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IObjectProperty> getObjectProperties(Object parent, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISemanticClass> getSub(Object parent, boolean direct) {
		// TODO Auto-generated method stub
		return null;
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
		assistant.load(new SemanticResource("http://www.oegov.us/democracy/us/federal/agency/owl/us1dhs", "US1DHS"));
	}
}
