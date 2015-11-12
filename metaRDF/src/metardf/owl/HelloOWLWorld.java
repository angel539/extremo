package metardf.owl;

import java.util.List;

public class HelloOWLWorld {
	public static void main(String[] arguments){
		try{          
            OwlAssitant assistant = new OwlAssitant();
            assistant.load("http://purl.org/cerif/frapo/");
            //account IS DEFINED by the ontology
            //provider IS NOT defined by the ontology but is synonym
            //bank IS NOT defined by the ontology
            //funding HAS an OBJECT property -> range
            List<String> results = assistant.getClassesLike("account", "provider", "bank", "funding");
            //quizás sería interesante observar los resultados ampliados, en plan... para cada uno que se ha encontrado...
            for(String result : results){
            	System.out.println(result);
            	System.out.println("supers: " + assistant.getSuper(result, true));
            	System.out.println("supers not direct of " + assistant.getSuper(result, false));
            	System.out.println("subs of " + assistant.getSub(result, true));
            	System.out.println("subs not direct of " + assistant.getSub(result, false));
            	System.out.println("siblings " + assistant.getSiblings(result));
            	//System.out.println("equivs " + result + assistant.equivs(result));
            	System.out.println("obj prop " + assistant.getObjectProperties(result, false, false));
            	System.out.println("data prop " + assistant.getDataProperties(result, false, false));
            	System.out.println("obj prop de supers " + assistant.getObjectProperties(result, true, false));
            	System.out.println("data prop de supers " + assistant.getDataProperties(result, true, false));
            	System.out.println("\n\n");
            }
            
            //System.err.println(assistant.allTheProperties());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {            
        	System.out.println("Params are needed");
        }
	}
	
	/*public void walkRepository(String repository){
		File master = new File(repository);
		if(master.exists()){
			File[] files = master.listFiles();
			if(files == null) return;
			
			for(File file : files){
				if(file.isDirectory()){
					walkRepository(file.getAbsolutePath());
				}
				else{
					String ext = FilenameUtils.getExtension(file.getAbsoluteFile().getAbsolutePath());
					if(ext.compareTo("owl") == 0){
						OwlAssitant owl = new OwlAssitant();
						try {
							owl.load(file.getAbsoluteFile().getAbsolutePath());
							owl.showEntities();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}*/
}