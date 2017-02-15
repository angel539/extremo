package uam.extremo.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class ExtremoPerspective implements IPerspectiveFactory {
	private static final String REPOSITORIES_VIEW_ID = "uam.extremo.ui.views.RepositoryView";
	private static final String SEARCH_VIEW_ID = "uam.extremo.ui.views.SearchTree";
	private static final String GRAPH_VIEW_ID = "uam.extremo.ui.zest.views.InheritanceGraphViewPart";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	private void defineActions(IPageLayout layout) {
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
		layout.addNewWizardShortcut("uam.extremo.ui.wizards.searchnew");
		
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		//layout.addShowViewShortcut(REPOSITORIES_VIEW_ID);
		//layout.addShowViewShortcut(SEARCH_VIEW_ID);
		//layout.addShowViewShortcut(GRAPH_VIEW_ID);
	}
	
	private void defineLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float) 0.15, editorArea);
		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.70, editorArea);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		//bottom.addView(REPOSITORIES_VIEW_ID);
		//bottom.addView(SEARCH_VIEW_ID);
		
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float) 0.70, editorArea);
		//right.addView(GRAPH_VIEW_ID);
	}
}
