package metaRDF.core.model;

public interface Property {
	String getName();
	String getURI();
	String getDescription();
	String toString();
	boolean isFromSuper();
}
