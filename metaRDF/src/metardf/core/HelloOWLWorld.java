package metardf.core;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class HelloOWLWorld {
	public static void main(String[] arguments){
		String repository = "/Users/angel/git/metaRDF/metaRDF/repository";
		String file = "/Users/angel/git/metaRDF/metaRDF/repository/pml-provenance.owl";
		HelloOWLWorld walker = new HelloOWLWorld();
		//walker.walkRepository(repository);
		walker.walkFile(file);
		//OWLQueryManager manager = new OWLQueryManager();	
	}
	
	public void walkRepository(String repository){
		File master = new File(repository);
		if(master.exists()){
			File[] files = master.listFiles();
			if(files == null) return;
			
			for(File file : files){
				if(file.isDirectory()){
					walkRepository(file.getAbsolutePath());
					//System.out.println("Dir: " + file.getAbsolutePath());
				}
				else{
					String ext = FilenameUtils.getExtension(file.getAbsoluteFile().getAbsolutePath());
					if(ext.compareTo("owl") == 0){
						OWLQueryManager owl = new OWLQueryManager();
						try {
							owl.loadFromFilePath(file.getAbsoluteFile().getAbsolutePath());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//System.out.println("File: " + file.getAbsoluteFile() + "   --> " + ext);
				}
			}
		}	
	}
	
	public void walkFile(String path){
		File file = new File(path);
		if(file.exists()){
			String ext = FilenameUtils.getExtension(file.getAbsoluteFile().getAbsolutePath());
			if(ext.compareTo("owl") == 0){
				OWLQueryManager owl = new OWLQueryManager();
				try {
					owl.showClassesFromFile(file.getAbsoluteFile().getAbsolutePath());
				} catch (Exception e) {
							// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}