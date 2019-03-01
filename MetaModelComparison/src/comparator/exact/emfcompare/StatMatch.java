package comparator.exact.emfcompare;

import java.io.Serializable;

import org.eclipse.emf.compare.Match;
import org.eclipse.emf.ecore.ENamedElement;

import com.google.common.collect.Iterators;

public class StatMatch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Match match;
	private int fittingRatio;
	private String type;
	private boolean isUnmatch;
	
	public StatMatch(String type, Match match, boolean isUnmatch) {
		this.setType(type);
		this.setMatch(match);
		this.setUnmatch(isUnmatch);
	}

	public void calculateFittingRatio(){
	}
	
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
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
		if((match.getLeft() != null) && (match.getLeft() instanceof ENamedElement)){
			stringBuilder.append(((ENamedElement) match.getLeft()).getName());
			stringBuilder.append(" ");
		}
		else{
			if((match.getRight() != null) && (match.getRight() instanceof ENamedElement)){
				stringBuilder.append("UNMATCHED RIGHT!: " + ((ENamedElement) match.getRight()).getName());
				stringBuilder.append(" ");
			}
		}
		
		stringBuilder.append(" > Differences: " + Iterators.size(match.getAllDifferences().iterator()));
		stringBuilder.append(" ");
		stringBuilder.append(" > Submatches: " + Iterators.size(match.getAllSubmatches().iterator()));
		stringBuilder.append(" ");
		
		return stringBuilder.toString();
	}
}
