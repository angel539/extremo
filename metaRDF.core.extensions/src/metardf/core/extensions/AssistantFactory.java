package metardf.core.extensions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

public class AssistantFactory {
	private List<IFormatAssistant> assistants = null;
	private static AssistantFactory INSTANCE = null;
	
	public static final String ASSISTANT_EXTENSIONS_ID = "metardf.core.extensions.assistant";
	
	public List<IFormatAssistant> getAssistances(){
		if (this.assistants == null) {
			this.assistants = new ArrayList<IFormatAssistant>();
		}
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(ASSISTANT_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(!isOnTheList(extension.getAttribute("id"))){
				if(extension.getName().compareTo("assistant") == 0){
					IFormatAssistant assistant;
					try{
						if(extension.createExecutableExtension("class") instanceof IFormatAssistant){
							assistant = (IFormatAssistant) extension.createExecutableExtension("class");
							((FormatAssistant)assistant).setId(extension.getAttribute("id"));
							((FormatAssistant)assistant).setNameExtension(extension.getAttribute("name"));
							
							String extensionsAttribute = StringUtils.deleteWhitespace(extension.getAttribute("extensions"));
							String[] extensionsSeparated = StringUtils.splitByWholeSeparator(extensionsAttribute, ",");
							
							for(String s : extensionsSeparated){
								((FormatAssistant)assistant).addExtension(s);
							}
							
							((FormatAssistant)assistant).setNameExtension(extension.getAttribute("extensions"));
							this.assistants.add(assistant);
						}
					}
					catch(CoreException e){
						//System.out.println(e.getMessage() + "Exception Creating assistant in meta.core");
						//e.printStackTrace();
					}
				}
			}		
		}
		
		return this.assistants;
	}
	
	private boolean isOnTheList(String attribute) {
		for(IFormatAssistant assistant : assistants){
			if(assistant instanceof FormatAssistant){
				if(((FormatAssistant) assistant).getId().compareTo(attribute)==0) return true;
			}
		}
		return false;
	}

	private static void createInstance() {
   	 if (INSTANCE == null) {
            synchronized(AssistantFactory.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new AssistantFactory();
                }
            }
        }
   }

   public static AssistantFactory getInstance() {
       if (INSTANCE == null){
       	createInstance();
       }
       return INSTANCE;
   }
   
   public Object clone() throws CloneNotSupportedException {
   	throw new CloneNotSupportedException(); 
   }
}
