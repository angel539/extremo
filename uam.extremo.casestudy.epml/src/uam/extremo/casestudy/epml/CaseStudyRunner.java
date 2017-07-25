package uam.extremo.casestudy.epml;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import at.ac.tuwien.big.xmltext.CustomSerializer;
import at.ac.tuwien.big.xmltext.MultiEcoreToGenericEcoreTransformer;

public class CaseStudyRunner {

	@Test
	public void transformEClassStandardResources() {
		// remove previous results
		for (int i=1; i<=9; i++) {
			File file = new File("model/eClassDictionary/eClassDictionary" + i + ".ecore");
			file.delete();
		}
		
		MultiEcoreToGenericEcoreTransformer transformer = new MultiEcoreToGenericEcoreTransformer();
		transformer.setTargetFilename("model/eClassDictionary");
		transformer.addXsdEcore("model/eClassStandard/dictionary.xsd");
		transformer.getResult();
		
		transformer.saveResult();
		Resource simplifiedXmi = transformer.loadXml("model/eClassStandard/eClass9_1_BASIC_EN_SG_27.xml");
		CustomSerializer serializer = new CustomSerializer();
		try {
			serializer.writeOutput(simplifiedXmi, "model/eClassStandard/eClass9_1_BASIC_EN_SG_27.xmi");
			// complete round-trip
			serializer.writeOutput(simplifiedXmi, "model/eClassStandard/eClass9_1_BASIC_EN_SG_27_ROUND_TRIP.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// assert
		for (int i=1; i<=9; i++) {
			File file = new File("model/eClassDictionary/eClassDictionary" + i + ".ecore");
			assertTrue(file.exists());
		}

	}
	
	
	
}
