package metaRDF.core.model.impl;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;

public class SemanticResource implements IResource{	
	private String name;
	private String description;
	private String uri;
	private List<ISemanticClass> classes;
	
	SemanticResource(String name, String description, String uri){
		super();
		this.name = name;
		this.description = description;
		this.uri = uri;
		this.classes = new ArrayList<ISemanticClass>();
	}

	@Override
	public List<ISemanticClass> getClasses() {
		return classes;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getURI() {
		return uri;
	}

	@Override
	public void setClasses(List<ISemanticClass> classes) {
		this.classes = classes;
		//firePropertyChange("classes", this.classes, this.classes = classes);
	}

	@Override
	public void addClasses(List<ISemanticClass> classes) {
		this.classes.addAll(classes);
	}

	@Override
	public void addClass(ISemanticClass clazz) {
		this.classes.add(clazz);
	}

	@Override
	public boolean isAlive() {
		if(uri.startsWith("file:")){
			File file = new File(uri);
			return file.exists();
		}else{
			try {
				HttpURLConnection con = (HttpURLConnection) new URL(uri).openConnection();
				
				boolean redirect = false;
				
				int status = con.getResponseCode();
				if (status != HttpURLConnection.HTTP_OK) {
					if (status == HttpURLConnection.HTTP_MOVED_TEMP
						|| status == HttpURLConnection.HTTP_MOVED_PERM
							|| status == HttpURLConnection.HTTP_SEE_OTHER)
					redirect = true;
				}

				if(redirect){
					String newUrl = con.getHeaderField("Location");
					String cookies = con.getHeaderField("Set-Cookie");

					con = (HttpURLConnection) new URL(newUrl).openConnection();
					con.setRequestProperty("Cookie", cookies);
					setUri(newUrl);
				}
				
				return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
			}
			catch (Exception e) {
				return false;
			}
		}
	}

	@Override
	public void setName(String name) {
		this.name = name;
		//firePropertyChange("name", this.name, this.name = name);
	}


	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public void setComment(String comment) {
		this.description = comment;
	}
	
	@Override
	public String toString() {
		String repositoryString = "resource";
		repositoryString = repositoryString + " @name=" + getName();
		repositoryString = repositoryString + " @description=" + getDescription();
		repositoryString = repositoryString + " @uri=" + getURI();
		return repositoryString;
	}
}
