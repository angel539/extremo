package uam.extremo.ui.views.extensions.dnd;

import org.eclipse.gef.examples.logicdesigner.model.LogicLabel;
import org.eclipse.gef.requests.CreationFactory;

public class NamedElementLabelFactory implements CreationFactory {
	private String text = "";
	
	@Override
	public Object getNewObject() {
		LogicLabel label = new LogicLabel();
		label.setLabelContents(text);
		return null;
	}
	
	 public Object getObjectType() {
	      return LogicLabel.class;
	   }

	   public void setText(String s) {
	      text = s;
	   }
}
