package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

import metaRDF.core.utils.PropertiesFile;

public class WordnetLocationWizardDialog extends Wizard {
	WordnetLocationWizardPage wordnetLocationPage;
	
	public WordnetLocationWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Wordnet Location";
	}
	
	public void addPages(){	
		wordnetLocationPage = new WordnetLocationWizardPage("Wordnet Location", "... description ... ");
		addPage(wordnetLocationPage);		
	}

	@Override
	public boolean performFinish() {
		PropertiesFile.getInstance().setWordnet(wordnetLocationPage.getLocation());
		return true;
	}
}
