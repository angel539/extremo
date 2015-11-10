package metardf.owl;

import java.io.File;
import java.util.List;

import metardf.model.semantics.Entity;
import metardf.utils.EcoreUtils;

public class HelloOWLWorld {
	public static void main(String[] arguments){
		EcoreUtils model = new EcoreUtils();
		model.create(new File("/Users/angel/git/metaRDF/metaRDF/model/Empty.ecore"));
		
		OwlAssitant owl = new OwlAssitant();
		try {
			owl.load("http://purl.org/cerif/frapo/");
			List<Entity> entities = owl.getEntities();
			for(Entity entity : entities) owl.getProperties(entity);
			owl.save();
		} catch (Exception e) {
			e.printStackTrace();
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