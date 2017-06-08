package uam.extremo.ui.wizards.dialogs.searchnew;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.*;
import uam.extremo.ui.wizards.Activator;

public class QueryCatalogueTableTreeViewerAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{
	public QueryCatalogueTableTreeViewerAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		
		if(obj instanceof CustomSearch) return Activator.getImageDescriptor("icons/queries/customsearch.png").createImage();
		if(obj instanceof PredicateBasedSearch) return Activator.getImageDescriptor("icons/queries/predicatebasedsearch.png").createImage();
		if(obj instanceof CompositeSearchConfiguration) return Activator.getImageDescriptor("icons/queries/compositesearch.png").createImage();
		
		if(obj instanceof AtomicSearchResult) return Activator.getImageDescriptor("icons/queries/atomicsearchresult.png").createImage();
		if(obj instanceof GroupedSearchResult) return Activator.getImageDescriptor("icons/queries/groupedsearchresult.png").createImage();
		
		if(obj instanceof SearchResultOptionValue) return Activator.getImageDescriptor("icons/queries/value16.png").createImage();
		if(obj instanceof SearchOption) return Activator.getImageDescriptor("icons/queries/option16.png").createImage();
		if(obj instanceof SemanticGroup) return Activator.getImageDescriptor("icons/queries/class_set.gif").createImage();
		
		if(obj instanceof Constraint) return Activator.getImageDescriptor("icons/constraints/constraint.png").createImage();
		if(obj instanceof ConstraintResult) return Activator.getImageDescriptor("icons/constraints/constraintsresult16.png").createImage();
		if(obj instanceof ConstraintInterpreter) return Activator.getImageDescriptor("icons/constraints/constraintinterpreter.png").createImage();
		
		if(obj instanceof Resource){
			Resource resource = (Resource) obj;
			
			if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
				if((resource.getConstraints() == null) || (resource.getConstraints().isEmpty())){
					return Activator.getImageDescriptor("icons/datamodel/resource16.png").createImage();
				}
				else{
					return Activator.getImageDescriptor("icons/datamodel/resourcewithconstraints16.png").createImage();
				}
			}
			else{
				return Activator.getImageDescriptor("icons/datamodel/description16.png").createImage();
			}
    	}
		
		if(obj instanceof SemanticNode){
			SemanticNode semanticnode = (SemanticNode) obj;
			
			if((semanticnode.getDescriptors() == null) || (semanticnode.getDescriptors().isEmpty())){
				// node
				if((semanticnode.getConstraints() == null) || (semanticnode.getConstraints().isEmpty())){
					// without constraints
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/node16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/noderefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/nodeprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/nodeproprefs16.png").createImage();
							}
						}
					}	
				}
				else{
					// with constraints
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/nodewithconstraints16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsrefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsproprefs16.png").createImage();
							}
						}
					}	
				}
			}
			else{
				if((semanticnode.getDescribes() == null) || (semanticnode.getDescribes().isEmpty())){
					// object
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/object16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/objectwithrefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/objectwithprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/objectwithproprefs16.png").createImage();
							}
						}
					}	
				}
				else{
					// clabject
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/clabject16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/clabjectwithrefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/clabjectwithprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/clabjectwithproprefs16.png").createImage();
							}
						}
					}
				}
			}
    	}
		
		//if(obj instanceof Constraint) return Activator.getImageDescriptor("icons/constraint.png").createImage();
		
		if(obj instanceof ObjectProperty){
			ObjectProperty objectProperty = (ObjectProperty) obj;
			
			if((objectProperty.getConstraints() == null) || (objectProperty.getConstraints().isEmpty())){
				return Activator.getImageDescriptor("icons/datamodel/refs16.png").createImage();
			}
			else{
				return Activator.getImageDescriptor("icons/datamodel/refswithconstraints16.png").createImage();
			}
		}
		if(obj instanceof DataProperty){
			DataProperty dataProperty = (DataProperty) obj;
			
			if((dataProperty.getConstraints() == null) || (dataProperty.getConstraints().isEmpty())){
				return Activator.getImageDescriptor("icons/datamodel/prop16.png").createImage();
			}
			else{
				return Activator.getImageDescriptor("icons/datamodel/propwithconstraints16.png").createImage();
			}
		}
    	
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof SearchConfiguration) {
			SearchConfiguration searchConfiguration = (SearchConfiguration) element;
			StyledString styledString = new StyledString(searchConfiguration.getName());
			return styledString;
		}
		
		if (element instanceof SearchResult) {
			SearchResult searchResult = (SearchResult) element;
			StyledString styledString = new StyledString("");
			
			if(searchResult instanceof ExtensibleAtomicSearchResult){
				ExtensibleAtomicSearchResult atomicSearchResult = (ExtensibleAtomicSearchResult) searchResult;
				styledString.append("(" + atomicSearchResult.getApplyOnElements().size() + ") nodes in", StyledString.COUNTER_STYLER);
				styledString.append(" -> (" + atomicSearchResult.getElements().size() + ") nodes out", StyledString.COUNTER_STYLER);
			}
			
			if(searchResult instanceof ExtensibleGroupedSearchResult){
				ExtensibleGroupedSearchResult groupedSearchResult = (ExtensibleGroupedSearchResult) searchResult;
				styledString.append("(" + groupedSearchResult.getApplyOnElements().size() + ") nodes in", StyledString.COUNTER_STYLER);
				styledString.append(" -> (" + groupedSearchResult.getGroups().size() + ") groups out", StyledString.COUNTER_STYLER);
			}
			
			return styledString;
		}
		
		if (element instanceof PrimitiveTypeSearchResultOptionValue) {
			PrimitiveTypeSearchResultOptionValue searchResultOptionValue = (PrimitiveTypeSearchResultOptionValue) element;
			StyledString styledString = new StyledString(searchResultOptionValue.getOption().getName() + " : " + searchResultOptionValue.getValue());
			return styledString;
		}
		
		if (element instanceof DataModelTypeSearchResultOptionValue) {
			DataModelTypeSearchResultOptionValue searchResultOptionValue = (DataModelTypeSearchResultOptionValue) element;
			StyledString styledString = new StyledString(searchResultOptionValue.getOption().getName() + " : " + searchResultOptionValue.getValue());
			return styledString;
		}
		
		if (element instanceof PrimitiveTypeSearchOption) {
			PrimitiveTypeSearchOption searchOption = (PrimitiveTypeSearchOption) element;
			StyledString styledString = new StyledString(searchOption.getType().getLiteral());
			styledString.append(" " + searchOption.getName(), StyledString.COUNTER_STYLER);
			return styledString;
		}
		
		if (element instanceof DataModelTypeSearchOption) {
			DataModelTypeSearchOption searchOption = (DataModelTypeSearchOption) element;
			StyledString styledString = new StyledString(searchOption.getType().getLiteral());
			styledString.append(" " + searchOption.getName(), StyledString.COUNTER_STYLER);
			return styledString;
		}
		
		if(element instanceof SemanticGroup){
			SemanticGroup semanticGroup = (SemanticGroup) element;
			StyledString styledString = new StyledString(semanticGroup.getName());
			styledString.append(" (" + semanticGroup.getElements().size() + ") ", StyledString.QUALIFIER_STYLER);

			return styledString;
		}
		
		if(element instanceof Constraint){
			Constraint constraint = (Constraint) element;
			StyledString styledString = new StyledString(constraint.getName());
			styledString.append(" (" + constraint.getType().toString() + ")", StyledString.COUNTER_STYLER);

			return styledString;
		}
		
		if (element instanceof Resource) {
			StyledString styledString = new StyledString(((Resource) element).getName());
			
			Resource resource = (Resource) element;
			if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
				styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ") resources", StyledString.COUNTER_STYLER);
			}
			
			return styledString;
		}
		
		if(element instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) element; 
			if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
				StyledString styledString = new StyledString(semanticNode.getName());
				
				if(semanticNode.getDescribes().size() > 0)
					styledString.append(" describes (" + semanticNode.getDescribes().size() + ")", StyledString.COUNTER_STYLER);
				
				return styledString;
			}
			else{
				StyledString styledString = new StyledString(semanticNode.getName());
				
				for(NamedElement descriptor : semanticNode.getDescriptors())
					styledString.append(" :" + descriptor.getName(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
    	}
		
		if (element instanceof Constraint) {
			Constraint constraint = (Constraint) element;
			StyledString styledString = new StyledString(((Constraint) element).getName());
			styledString.append(" (" + constraint.getBody() + ")", StyledString.COUNTER_STYLER);
			return styledString;
		}
		
		if(element instanceof DataProperty){
			DataProperty dataProperty = (DataProperty) element;
			
			if((dataProperty.getDescriptors() == null) || (dataProperty.getDescriptors().isEmpty())){
				DataProperty property = (DataProperty) element;
				StyledString styledString = new StyledString(property.getName());
				if(property.getType() != null) styledString.append(": " + property.getType().getLiteral(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
			else{
				StyledString styledString = new StyledString(dataProperty.getValue());
				for(NamedElement namedElement : dataProperty.getDescriptors())
					styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
				return styledString;
			}
		}
		
		if(element instanceof ObjectProperty){
			ObjectProperty objectProperty = (ObjectProperty) element;
			
			if((objectProperty.getDescriptors() == null) || (objectProperty.getDescriptors().isEmpty())){
				ObjectProperty property = (ObjectProperty) element;
				StyledString styledString = new StyledString(property.getName());
				if(property.getRange() != null) styledString.append(" ->" + property.getRange().getName(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
			else{
				StyledString styledString = new StyledString(objectProperty.getName());
				
				for(NamedElement namedElement : objectProperty.getDescriptors())
					styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
				return styledString;
			}
		}
		
		return null;
	}
}
