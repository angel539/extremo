package uam.extremo.queries.customsearch;

import semanticmanager.SearchResult;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class DataPropertiesValueRangeSearch extends ExtensibleCustomSearchImpl{
	public DataPropertiesValueRangeSearch(){
	}
	
	@Override
	public void search(SearchResult search) {
		if((search.getOptionValue("minvaluefield") != null) && (search.getOptionValue("minvaluefield") instanceof Integer) &&
				(search.getOptionValue("maxvaluefield") != null) && (search.getOptionValue("maxvaluefield") instanceof Integer)){
			
			/*
			Integer minValueField = (Integer) search.getOptionValue("minvaluefield");
			Integer maxValueField = (Integer) search.getOptionValue("maxvaluefield");
			
			List<NamedElement> namedElements = new ArrayList<NamedElement>();
			
			if(search.getApplyOnElements().isEmpty()){
				for(Resource resource : search.getResources()){
					for(SemanticNode semanticNode : resource.getNodes()){
						for(Property property : semanticNode.getProperties()){
							if(property instanceof DataProperty){
								DataProperty dataProperty = (DataProperty) property;
								namedElements.add(dataProperty);
							}
						}
					}
				}	
			}
			else{
				namedElements = search.getApplyOnElements();
			}
			
			SemanticGroup dataPropertiesName = search.createSemanticGroup("properties", "properties");
			
			namedElements.forEach(
					element -> {
						if(element instanceof DataProperty){
							DataProperty dataProperty = (DataProperty) element;
							if((dataProperty.getDescriptor() != null) && (((DataProperty) dataProperty.getDescriptor()).getType().equals(Type.INT))){
								try{
									int valueOf = Integer.valueOf(dataProperty.getValue());
									
									if((minValueField <= valueOf) && (valueOf >= maxValueField)){
										search.addNamedElementToSemanticGroup(dataPropertiesName, dataProperty);
									}
								}
								catch(NumberFormatException e){
									
								}
							}
						}
					}
			);
			*/
		}
	}
}
