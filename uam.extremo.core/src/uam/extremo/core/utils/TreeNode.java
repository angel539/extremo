package uam.extremo.core.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 875018598998638169L;
	T[] data;
	int kind;
	String definition = null;
	String[] usages = null;
	List<TreeNode<T>> children;
	
	boolean valid = true;
	int points = 0;
	int countWordnet = 0;
	
	public int getCountWordnet() {
		return countWordnet;
	}

	public void setCountWordnet(int countWordnet) {
		this.countWordnet = countWordnet;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addPoints(int points) {
		this.points = this.points + points;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public T[] getData() {
		return data;
	}
	public void setData(T[] data) {
		this.data = data;
	}
	
	public List<TreeNode<T>> getChildren() {
		if(this.children == null) this.children = new ArrayList<TreeNode<T>>();
		return children;
	}
	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String[] getUsages() {
		return usages;
	}
	public void setUsages(String[] usages) {
		this.usages = usages;
	}
}
