package metardf.ui.wizards.importers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.impl.RepositoryManager;

public class NewFileExportSupportWizardDialog extends Wizard {
	NewFileExportSupportWizardPage newFileExportPage;
	
	public NewFileExportSupportWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Repository Manager Exporter";
	}
	
	public void addPages(){	
		newFileExportPage = new NewFileExportSupportWizardPage("Repository Manager Export", "... description ... ");
		addPage(newFileExportPage);		
	}

	@Override
	public boolean performFinish() {
		try {
			String aux = "";
			String OS = System.getProperty("os.name").toLowerCase();
			if(OS.indexOf("win") >= 0){
				aux = "\\";
			}else{
				aux = "/";
			}
			
			List<String> lines = Arrays.asList(RepositoryManager.getInstance().toString());
			
			//IRepository repository = RepositoryManager.getInstance().getRepositories();
			//repository.createResource(newResourcePage.getResourceName(), newResourcePage.getResourceDescription(), newResourcePage.getResourceUri());
			Path file = Paths.get(newFileExportPage.getFolder() + aux + newFileExportPage.getFileName());
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//IRepository repository = RepositoryManager.getInstance().addRepository(newFileExportPage.getRepositoryName(), newFileExportPage.getRepositoryDescription(), newFileExportPage.getRepositoryUri());
		//repository.createResource(newResourcePage.getResourceName(), newResourcePage.getResourceDescription(), newResourcePage.getResourceUri());
		return true;
	}
}
