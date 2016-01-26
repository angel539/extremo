package metardf.ui.wizards.importers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IRepositoryManager;

public class NewFileImportSupportWizardDialog extends Wizard {
	NewFileImportSupportWizardPage newFileImportPage;
	
	public NewFileImportSupportWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Repository Manager Importer";
	}
	
	public void addPages(){	
		newFileImportPage = new NewFileImportSupportWizardPage("Repository Manager Import", "... description ... ");
		addPage(newFileImportPage);		
	}

	@Override
	public boolean performFinish() {
		try {			
			Path file = Paths.get(newFileImportPage.getFilePath());
			List<String> repositoryManagerString = Files.readAllLines(file);
			
			//repository.createResource(newResourcePage.getResourceName(), newResourcePage.getResourceDescription(), newResourcePage.getResourceUri());
			
			Iterator<String> linesIterator = repositoryManagerString.iterator();
			IRepository repository = null;
			
			while(linesIterator.hasNext()){
				
				String line = linesIterator.next();
				
				System.out.println(line);
				
				if((line != null) && (line.compareTo("\n")!=0 && (line.compareTo("")!=0))){
					String name = line.substring(line.indexOf(" @name=") + " @name=".length(), line.indexOf(" @description="));
					String description = line.substring(line.lastIndexOf(" @description=") + " @description=".length(), line.indexOf(" @uri="));
					
					String uri;
					if(line.lastIndexOf(" @uri=")>=line.length()) uri = "";
					else uri = line.substring(line.lastIndexOf(" @uri=") + " @uri=".length(), line.length());
					
					if(line.startsWith("repository")){
						
						
						Class<? extends IRepositoryManager> c;
						try {
							c = Class.forName("metardf.core").asSubclass(IRepositoryManager.class);
							IRepositoryManager repositoryManager = c.newInstance();
							
							repository = repositoryManager.addRepository(name, description, uri);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
						
						
						
					}
					if(line.startsWith("resource")){
						if(repository != null) repository.createResource(name, description, uri);
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//IRepository repository = RepositoryManager.getInstance().addRepository(newFileExportPage.getRepositoryName(), newFileExportPage.getRepositoryDescription(), newFileExportPage.getRepositoryUri());
		//repository.createResource(newResourcePage.getResourceName(), newResourcePage.getResourceDescription(), newResourcePage.getResourceUri());
		return true;
	}
}
