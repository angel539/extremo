package semanticmanager;

public interface ExtensibleService extends Service {
	boolean matches(String expression, String value);
}
