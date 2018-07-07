package uam.extremo.extensions;

import java.util.ArrayList;
import java.util.List;

import uam.extremo.core.ConstraintInterpreter;

public class FormatAssistant{
	private static FormatAssistant INSTANCE = null;
	private String id = null;
	private String nameExtension = null;
	private List<String> extensions = null;
	private String interpreter = null;
	private ConstraintInterpreter constraintInterpreter = null;
	
	private static void createInstance() {
	   	 if (INSTANCE == null) {
	   		 synchronized(FormatAssistant.class) {
	   			 if (INSTANCE == null) {
	   				 INSTANCE = new FormatAssistant();
	   			 }
	   		 }
	     }
	}

  public static FormatAssistant getInstance() {
      if (INSTANCE == null){
      	createInstance();
      }
      return INSTANCE;
  }
  
  	public Object clone() throws CloneNotSupportedException {
  		throw new CloneNotSupportedException(); 
  	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameExtension() {
		return nameExtension;
	}

	public void setNameExtension(String nameExtension) {
		this.nameExtension = nameExtension;
	}
	
	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}

	public List<String> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<String> extensions) {
		this.extensions = extensions;
	}
	
	public void addExtension(String extension) {
		if(this.extensions == null) extensions = new ArrayList<String>();
		extensions.add(extension);
	}

	public ConstraintInterpreter getConstraintInterpreter() {
		return constraintInterpreter;
	}

	public void setConstraintInterpreter(ConstraintInterpreter constraintInterpreter) {
		this.constraintInterpreter = constraintInterpreter;
	}
}
