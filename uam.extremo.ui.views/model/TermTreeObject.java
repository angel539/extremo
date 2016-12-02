package metardf.ui.views.searchtree.model;

import java.util.Map.Entry;

public class TermTreeObject extends TreeObject{
	private Entry<String, Integer> entry;
	
	public TermTreeObject(String word) {
		super(word);
	}
	
	public TermTreeObject(Entry<String, Integer> entry) {
		super(entry);
		this.setEntry(entry);
	}

	public Entry<String, Integer> getEntry() {
		return entry;
	}

	public void setEntry(Entry<String, Integer> entry) {
		this.entry = entry;
	}
}
