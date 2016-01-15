package metaRDF.core.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.owl.OwlAssistant;

public class PropertiesFile {
	private static PropertiesFile INSTANCE = null;
	
	public String getWordnet() {
		Properties prop = new Properties();
		InputStream input = null;
		
		String wordnet = null;

		try {
			input = new FileInputStream("config.properties");
			wordnet = prop.getProperty("wordnet");
		} catch (IOException ex) {
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					return null;
				}
			}
		}
		
		return wordnet;
	}

	public void setWordnet(String wordnetLocation) {	
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");
			// set the properties value
			prop.setProperty("wordnet", wordnetLocation);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
		private static void createInstance() {
		   	 if (INSTANCE == null) {
		   		 synchronized(RepositoryManager.class) {
		   			 if (INSTANCE == null) {
		   				 INSTANCE = new PropertiesFile();
		   			 }
		   		 }
		     }
		}

	  public static PropertiesFile getInstance() {
	      if (INSTANCE == null){
	      	createInstance();
	      }
	      return INSTANCE;
	  }
	  
	  public Object clone() throws CloneNotSupportedException {
	  	throw new CloneNotSupportedException(); 
	  }
}
