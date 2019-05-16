package comparator.inexact.own;

import java.io.Serializable;
import org.eclipse.emf.ecore.ENamedElement;

public class StatMatchFlattened implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ENamedElement match;
	private int fittingRatio;
	private String type;
	private boolean isUnmatch;
	
	public StatMatchFlattened(String type, ENamedElement match, boolean isUnmatch) {
		this.setType(type);
		this.setMatch(match);
		this.setUnmatch(isUnmatch);
	}

	public void calculateFittingRatio(){
	}
	
	public ENamedElement getMatch() {
		return match;
	}

	public void setMatch(ENamedElement match) {
		this.match = match;
	}

	public int getFittingRatio() {
		return fittingRatio;
	}

	public void setFittingRatio(int fittingRatio) {
		this.fittingRatio = fittingRatio;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isUnmatch() {
		return isUnmatch;
	}

	public void setUnmatch(boolean isUnmatch) {
		this.isUnmatch = isUnmatch;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" > Type: ");
		stringBuilder.append(type);
		stringBuilder.append(" ");
		
		stringBuilder.append(" > Name: ");
		stringBuilder.append(((ENamedElement) match).getName());
		stringBuilder.append(" ");
		
		return stringBuilder.toString();
	}
}
