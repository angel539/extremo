package uam.extremo.extensions;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import semanticmanager.*;

public class ForkAssistant extends RecursiveAction {
	protected static int sThreshold = 10000;
	private int start;
    private int length;
    private List<SemanticNode> semanticNodes;
    private FormatAssistant assistant;
    
	public ForkAssistant(FormatAssistant assistant, List<SemanticNode> semanticNodes, int start, int length) {
		this.start = start;
		this.length = length;
		this.semanticNodes = semanticNodes;
		this.assistant = assistant;
    }	
	
    @Override
    protected void compute() {
        if (length < sThreshold) {
            transform();
            return;
        }
        
        int split = length / 2;
        invokeAll(new ForkAssistant(assistant, semanticNodes, start, split), new ForkAssistant(assistant, semanticNodes, start + split, length - split));
    }
    
    private void transform(){
    	for (int i = start; i < start + length; i++) {
    		SemanticNode semanticNode = semanticNodes.get(i);
    		assistant.toDataProperty(semanticNode);
			assistant.toObjectProperty(semanticNode);
			assistant.toSuper(semanticNode);
    	}
    }
}
