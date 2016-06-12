package metardf.core.owl.assistant.model;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import metaRDF.core.model.impl.SemanticResource;

public class OWLSemanticResource extends SemanticResource{
	String url;
	
	protected OWLSemanticResource(String id, String name) {
		super(id, name);
		this.url = id;
	}

	@Override
	public boolean isAlive() {
		
		if(url.startsWith("file:")){
			File file = new File(url);
			return file.exists();
		}else{
			try {
				HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
				
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
					setId(newUrl);
				}
				
				return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
			}
			catch (Exception e) {
				return false;
			}
		}
	}
	
	@Override
	public String toString() {
		String repositoryString = "resource";
		repositoryString = repositoryString + " @name=" + getName();
		repositoryString = repositoryString + " @description=" + getDescription();
		repositoryString = repositoryString + " @uri=" + getId();
		return repositoryString;
	}
}
