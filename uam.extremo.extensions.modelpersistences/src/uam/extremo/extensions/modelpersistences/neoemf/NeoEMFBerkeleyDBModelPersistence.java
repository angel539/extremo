package uam.extremo.extensions.modelpersistences.neoemf;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.berkeleydb.util.BerkeleyDbURI;
import fr.inria.atlanmod.neoemf.data.mapdb.MapDbPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.mapdb.option.MapDbOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.mapdb.util.MapDbURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;
import semanticmanager.RepositoryManager;
import semanticmanager.impl.ExtensibleModelPersistenceImpl;

public class NeoEMFBerkeleyDBModelPersistence extends ExtensibleModelPersistenceImpl {
	private TransactionalEditingDomain sharedEditingDomain = null;
	private org.eclipse.emf.ecore.resource.Resource resourceDb = null;
	
	public NeoEMFBerkeleyDBModelPersistence() {
		sharedEditingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("uam.extremo.ExtremoEditingDomain");
		
		PersistenceBackendFactoryRegistry.register(MapDbURI.SCHEME, MapDbPersistenceBackendFactory.getInstance());
		sharedEditingDomain.getResourceSet().getResourceFactoryRegistry().getProtocolToFactoryMap().put(BerkeleyDbURI.SCHEME, PersistentResourceFactory.getInstance());
	}
	
	@Override
	public boolean load(String path) {
		if(resourceDb == null){
			try {
				File file = new File(path);	 
				resourceDb = sharedEditingDomain.getResourceSet().createResource(BerkeleyDbURI.createFileURI(file));
				return true;
			} 
			catch (Exception e) {
				return false;
			}	
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
		if(! resourceDb.getContents().isEmpty()){
			return (RepositoryManager) resourceDb.getContents().get(0);
		}
		return null;
	}

	@Override
	public boolean save() {
		try {
			Map<String, Object> options = MapDbOptionsBuilder.newBuilder()
                    .directWriteCacheMany()
                    .autocommit()
                    .cacheIsSet()
                    .cacheSizes()
                    .asMap();
			resourceDb.save(options);
			
			if (resourceDb instanceof PersistentResource) ((PersistentResource) resourceDb).close();
			else resourceDb.unload();
			return true;
	    }
        catch (Exception e) {
        	return false;
        } 
	}
}
