package metaRDF.core.repository.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.impl.RepositoryManager;

public class RepositoryManagerWriter {
	private String file;
	private RepositoryManager manager;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	public RepositoryManagerWriter(String file, RepositoryManager manager) {
		super();
		this.file = file;
		this.setManager(manager);
	}
	
	public void saveConfigFile(){
		try {
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		    XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(file));
		    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		    XMLEvent end = eventFactory.createDTD("\n");
		    // create and write Start Tag
		    StartDocument startDocument = eventFactory.createStartDocument();
	    
			eventWriter.add(startDocument);
			
			StartElement configStartElement = eventFactory.createStartElement("", "", "manager");
		    eventWriter.add(configStartElement);
		    eventWriter.add(end);
		    
		    for(IRepository repository : manager.getRepositories()){
		    	createNode(eventWriter, repository);
		    }
		    /*// Write the different nodes
		    createNode(eventWriter, "mode", "1");
		    createNode(eventWriter, "unit", "901");
		    createNode(eventWriter, "current", "0");
		    createNode(eventWriter, "interactive", "0");*/

		    eventWriter.add(eventFactory.createEndElement("", "", "manager"));
		    eventWriter.add(end);
		    eventWriter.add(eventFactory.createEndDocument());
		    eventWriter.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void createNode(XMLEventWriter eventWriter, IRepository repository){
		try {
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			XMLEvent end = eventFactory.createDTD("\n");
			XMLEvent tab = eventFactory.createDTD("\t");
			    // create Start nod
			
			StartElement sElement = eventFactory.createStartElement("", "", "repository");
			
			Attribute attributeName = eventFactory.createAttribute("name", repository.getName());
			Attribute attributeDescription = eventFactory.createAttribute("description", repository.getDescription());
			Attribute attributeUri = eventFactory.createAttribute("uri", repository.getURI());
			
			eventWriter.add(tab);
			eventWriter.add(sElement);
			
			eventWriter.add(tab);
			eventWriter.add(attributeName);
			
			eventWriter.add(tab);
		
			eventWriter.add(attributeDescription);
			
			eventWriter.add(tab);
			eventWriter.add(attributeUri);
			
			// create Content
			/*Characters characters = eventFactory.createCharacters(value);
			eventWriter.add(characters);*/
			// create End node
			
			EndElement eElement = eventFactory.createEndElement("", "", "repository");
			eventWriter.add(eElement);
			eventWriter.add(end);
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RepositoryManager getManager() {
		return manager;
	}

	public void setManager(RepositoryManager manager) {
		this.manager = manager;
	}

}
