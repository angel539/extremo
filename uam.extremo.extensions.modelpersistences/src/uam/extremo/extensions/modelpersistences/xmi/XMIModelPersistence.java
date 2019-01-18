package uam.extremo.extensions.modelpersistences.xmi;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import semanticmanager.RepositoryManager;
import semanticmanager.impl.ExtensibleModelPersistenceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class XMIModelPersistence extends ExtensibleModelPersistenceImpl  {
	private TransactionalEditingDomain sharedEditingDomain = null;
	private org.eclipse.emf.ecore.resource.Resource resource = null;
	
	public XMIModelPersistence(){
		sharedEditingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("uam.extremo.ExtremoEditingDomain");
		
		Registry registry = sharedEditingDomain.getResourceSet().getResourceFactoryRegistry();
        Map<String, Object> mapExtensions = registry.getExtensionToFactoryMap();
        mapExtensions.put("xmi", new XMIResourceFactoryImpl());
	}
	
	@Override
	public boolean load(String path) {
		try {
			if(resource != null){
				resource = sharedEditingDomain.getResourceSet().createResource(URI.createURI(path));
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
		
		// already loaded
		return true;
	}
	
	@Override
	public boolean addContent(RepositoryManager repositoryManager){
		return true;
	}

	@Override
	public RepositoryManager getContent(){
		if(! resource.getContents().isEmpty()){
			return (RepositoryManager) resource.getContents().get(0);
		}
		return null;
	}

	@Override
	public boolean save() {
		try {
            resource.save(Collections.EMPTY_MAP);
            resource.unload();
            return true;
        } catch (IOException e) {
            return false;
        }
	}
}
