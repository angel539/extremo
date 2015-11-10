package metardf.repository;

public class RDFEntity {
	String URI;
	String name;
	
	public RDFEntity(String uRI, String name) {
		super();
		URI = uRI;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
