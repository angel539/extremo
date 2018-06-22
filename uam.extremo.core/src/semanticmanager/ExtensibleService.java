package semanticmanager;

import semanticmanager.Service;

public interface ExtensibleService extends Service {
	boolean matches(String expression, String value);
}
