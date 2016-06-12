package metardf.core.owl.assistant.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import metaRDF.core.model.impl.SemanticClass;

public class OWLSemanticClass extends SemanticClass{
	String id;
	String label;
	int weight;
	
	public OWLSemanticClass(String id, String name, String description, boolean isExplored){
		super(id, name, description);
		this.id = id;
	}
	
	public OWLSemanticClass(String id, String name, boolean isExplored){
		super(id, name);
		this.id = id;
	}
	
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
	
	public void setLabel(String label){
		this.label = label;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
