package uam.extremo.extensions.utils;

import java.util.concurrent.Callable;

import semanticmanager.SemanticNode;
import uam.extremo.extensions.IFormatAssistant;

public class ToDataPropertyTask implements Callable<SemanticNode> {
	private final SemanticNode semanticNode;
	IFormatAssistant assistant;

    public ToDataPropertyTask(IFormatAssistant assistant, SemanticNode semanticNode) {
        this.semanticNode = semanticNode;
        this.assistant = assistant;
    }
    
	@Override
	public SemanticNode call() throws Exception {
		assistant.toDataProperty(semanticNode);
		return semanticNode;
	}

}
