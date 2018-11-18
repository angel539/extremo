package semanticmanager.impl;

import semanticmanager.Service;
import semanticmanager.impl.PredicateBasedSearchImpl;

public abstract class ExtensiblePredicateBasedSearchImpl extends PredicateBasedSearchImpl {	
	public final boolean callService(Service service, String valuefieldString, String name) {
		if(name == null) return false;
		if(service != null) return service.matches(valuefieldString, name);
		else return false;
	}
}
