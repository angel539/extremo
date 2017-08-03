package uam.extremo.casestudy.epmltext.tests;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import uam.extremo.casestudy.epmltext.serializer.EPMLTextSerializer;

/**
 * SerializerTest
 * 
 * Step-by-step round-trip: EPMLText --> XMI --> XML --> XMI --> EPMLText
 * Direct one-way: EPMLText --> XML
 * Direct one-way: XML --> EPMLText
 * 
 * (!) Check if model resources are available before executing this test
 * 
 * @author pneubaue
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerializerTest {

	private static final String INPUT_MODEL = "models/ConveyorBeltSystemModel.epml"; // must end with .epml
	private static final String OUTPUT_MODEL_PATH = "models/generated/"; // must end with /
	
//	@Test
//	public void _0_xmiToEpmltextTest() throws IOException {
//		URI inputModelResourceURI = URI.createFileURI(new File(INPUT_MODEL).getAbsolutePath());		
//		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat(".epml")).getAbsolutePath());
//		EPMLTextSerializer serializer = new EPMLTextSerializer();
//		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
//	}// xmiToEpmltextTest

	@Test
	public void _1_epmltextToXmiTest() throws IOException {
		URI inputModelResourceURI = URI.createFileURI(new File(INPUT_MODEL).getAbsolutePath());		
		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat(".xmi")).getAbsolutePath());
		EPMLTextSerializer serializer = new EPMLTextSerializer();
		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
	}// epmltextToXmiTest
	
	@Test
	public void _2_xmiToXmlTest() throws IOException {
		URI inputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat(".xmi")).getAbsolutePath());
		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat(".xml")).getAbsolutePath());
		EPMLTextSerializer serializer = new EPMLTextSerializer();
		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
	}// xmiToXmlTest
	
	@Test
	public void _3_xmlToXmiTest() throws IOException {
		URI inputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat(".xml")).getAbsolutePath());		
		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat("_reverse.xmi")).getAbsolutePath());
		EPMLTextSerializer serializer = new EPMLTextSerializer();
		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
	}// xmlToXmiTest
	
	@Test
	public void _4_xmiToEpmltextTest() throws IOException {
		URI inputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat("_reverse.xmi")).getAbsolutePath());
		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat("_reverse.epml")).getAbsolutePath());
		EPMLTextSerializer serializer = new EPMLTextSerializer();
		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
	}// xmiToEpmltextTest
	
	@Test
	public void _5_epmltextToXmlDirectlyTest() throws IOException {
		URI inputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat("_reverse.epml")).getAbsolutePath());
		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat("_directly.xml")).getAbsolutePath());
		EPMLTextSerializer serializer = new EPMLTextSerializer();
		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
	}// epmltextToXmlDirectlyTest

	@Test
	public void _6_xmlToEpmltextDirectlyTest() throws IOException {
		URI inputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat(".xml")).getAbsolutePath());
		URI outputModelResourceURI = URI.createFileURI(new File(OUTPUT_MODEL_PATH + INPUT_MODEL.substring(INPUT_MODEL.lastIndexOf('/'), INPUT_MODEL.lastIndexOf('.')).concat("_directly.epml")).getAbsolutePath());
		EPMLTextSerializer serializer = new EPMLTextSerializer();
		serializer.writeOutput(inputModelResourceURI, outputModelResourceURI, XMLResource.OPTION_EXTENDED_META_DATA);
	}// xmlToEpmltextDirectlyTest

}// SerializerTest