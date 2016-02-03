package metardf.core.owl.assistant.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import metaRDF.core.model.impl.SemanticClass;

public class OWLSemanticClass extends SemanticClass{
	String label;
	
	public OWLSemanticClass(){
		super();
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
	public String getIdToString() {
		return this.label;
	}

	@Override
	public void setIdToString(String idString) {
		this.label = idString;
	}
}
