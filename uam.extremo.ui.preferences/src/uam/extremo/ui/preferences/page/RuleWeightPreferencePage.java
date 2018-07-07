package uam.extremo.ui.preferences.page;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import uam.extremo.extensions.internal.preferences.IPointSettings;
import uam.extremo.ui.preferences.Activator;

public class RuleWeightPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	public static final String PREFERENCES_SETTINGS_EXTENSIONS_ID = "extremo.core.preferences.weights";
	
	private ScaleFieldEditor rangeRule1;
	private ScaleFieldEditor rangeRule2;
	private ScaleFieldEditor rangeRule3;
	private ScaleFieldEditor rangeRule4;
	private ScaleFieldEditor rangeRule5;
	private ComboFieldEditor presetsFieldEditor;
	private IntegerFieldEditor maxWeight;
	
	IConfigurationElement[] extensions;
	Map<String, IPointSettings> relevanceValues;
	
	public RuleWeightPreferencePage() {
		super(GRID);
	}

	public RuleWeightPreferencePage(int style) {
		super(style);
	}

	public RuleWeightPreferencePage(String title, int style) {
		super(title, style);
	}

	public RuleWeightPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Rule weights settings");
	}
	
	@Override
	protected void createFieldEditors() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		extensions = registry.getConfigurationElementsFor(PREFERENCES_SETTINGS_EXTENSIONS_ID);
		relevanceValues = new HashMap<String, IPointSettings>();
		
		String[][] presets = new String[extensions.length + 1][2];
		
		for(int i = 0; i < extensions.length; i++){
			if(extensions[i].getName().compareTo("preferencessettings") == 0){
				IPointSettings pointSettings;
				
				Bundle bundle = null;
				IContributor contributor = extensions[i].getContributor();

				if (contributor instanceof RegistryContributor) {
				  long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
				  Bundle thisBundle = FrameworkUtil.getBundle(getClass());
				  bundle = thisBundle.getBundleContext().getBundle(id);
				} else {
				  bundle = Platform.getBundle(contributor.getName());          
				}
				
				try{
					if(extensions[i].createExecutableExtension("class") instanceof IPointSettings){
						pointSettings = (IPointSettings) extensions[i].createExecutableExtension("class");
						
						presets[i][0] = extensions[i].getAttribute("name");
						presets[i][1] = extensions[i].getAttribute("id");
						
						relevanceValues.put(extensions[i].getAttribute("id"), pointSettings);
					}
				}
				catch(CoreException e){
				}
			}
		}
		
		presets[extensions.length][0] = "Own Selection";
		presets[extensions.length][1] = "ownselection";
		
		presetsFieldEditor = new ComboFieldEditor(
				"PRESETS",
				"Selection a preset of values",
				presets,
				getFieldEditorParent()
			);
		addField(presetsFieldEditor);
		
		rangeRule1 = new ScaleFieldEditor("RELEVANCE_R1", "Synonyms sharing between senses", getFieldEditorParent(), 0, 10, 1, 1);
		addField(rangeRule1);
		
		rangeRule2 = new ScaleFieldEditor("RELEVANCE_R2", "Path and derivations", getFieldEditorParent(), 0, 10, 1, 1);
		addField(rangeRule2);
		
		rangeRule3 = new ScaleFieldEditor("RELEVANCE_R3", "Definitions of the senses", getFieldEditorParent(), 0, 10, 1, 1);
		addField(rangeRule3);
		
		rangeRule4 = new ScaleFieldEditor("RELEVANCE_R4", "Usages of the senses", getFieldEditorParent(), 0, 10, 1, 1);
		addField(rangeRule4);
		
		rangeRule5 = new ScaleFieldEditor("RELEVANCE_R5", "Synonyms sharing between searching terms", getFieldEditorParent(), 0, 100, 1, 1);
		addField(rangeRule5);
		
		maxWeight = new IntegerFieldEditor("MAX_WEIGHT", "Maximum weight", getFieldEditorParent());
		addField(maxWeight);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getSource() instanceof ComboFieldEditor){
			ComboFieldEditor fieldEditor = (ComboFieldEditor) event.getSource();
			if(fieldEditor.getPreferenceName().equals("PRESETS")){
				if(event.getNewValue().equals("ownselection")){
					rangeRule1.getScaleControl().setEnabled(true);
					rangeRule2.getScaleControl().setEnabled(true);
					rangeRule3.getScaleControl().setEnabled(true);
					rangeRule4.getScaleControl().setEnabled(true);
					rangeRule5.getScaleControl().setEnabled(true);
					
					maxWeight.setEnabled(true, getFieldEditorParent());
				}
				else{
					rangeRule1.getScaleControl().setEnabled(false);
					rangeRule2.getScaleControl().setEnabled(false);
					rangeRule3.getScaleControl().setEnabled(false);
					rangeRule4.getScaleControl().setEnabled(false);
					rangeRule5.getScaleControl().setEnabled(false);
					
					IPointSettings pointSettings = relevanceValues.get(event.getNewValue());
					
					maxWeight.setEnabled(false, getFieldEditorParent());
					maxWeight.setStringValue(String.valueOf(pointSettings.getMaxWeight()));
					rangeRule1.getScaleControl().setSelection(pointSettings.getRelevanceOfSynonyms());
					rangeRule2.getScaleControl().setSelection(pointSettings.getRelevanceOfPaths());
					rangeRule3.getScaleControl().setSelection(pointSettings.getRelevanceOfDefinitions());
					rangeRule4.getScaleControl().setSelection(pointSettings.getRelevanceOfUsages());
					rangeRule5.getScaleControl().setSelection(pointSettings.getRelevanceOfInformationSharing());
				}
			}
		}
	}
}
