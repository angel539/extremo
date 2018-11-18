package uam.extremo.core;

import uam.extremo.core.Service;

public interface ExtensibleService extends Service {
	boolean matches(String expression, String value);
}
