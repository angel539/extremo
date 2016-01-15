package metaRDF.core.repository.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import metaRDF.core.model.impl.Repository;

public class RepositoryManagerParser {
	static final String REPOSITORY = "repository";
	
	static final String NAME = "name";
	static final String DESCRIPTION = "description";
	static final String URI = "uri";
	
	public List<Repository> readConfig(String configFile) {
		List<Repository> repositories = new ArrayList<Repository>();
		
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			
			Repository repository = null;
			
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					
					if (startElement.getName().getLocalPart() == (REPOSITORY)) {
						repository= new Repository();
						
						Iterator<?> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							if(attributes.next() instanceof Attribute){
								Attribute attribute = (Attribute) attributes.next();
								if(attribute.getName().toString().equals(NAME)){
									repository.setName(attribute.getValue());
								}
								
								if(attribute.getName().toString().equals(DESCRIPTION)){
									repository.setDescription(attribute.getValue());
								}
								
								if(attribute.getName().toString().equals(URI)){
									repository.setURI(attribute.getValue());
								}
							}
						}
					}
				}
				
		        if (event.isEndElement()) {
		          EndElement endElement = event.asEndElement();
		          if (endElement.getName().getLocalPart() == (REPOSITORY)) {
		            repositories.add(repository);
		          }
		        }
			}
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (XMLStreamException e) {
	      e.printStackTrace();
	    }
	    return repositories;
	  }
}
