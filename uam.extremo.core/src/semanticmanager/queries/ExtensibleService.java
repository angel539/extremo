package semanticmanager.queries;

public interface ExtensibleService extends Service {
	boolean matches(String expression, String value);
}
