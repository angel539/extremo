/**
 */
package isostdisois_13584_32ed_1techxmlschemaontomlSimplified.impl;

import epml.EpmlPackage;

import epml.impl.EpmlPackageImpl;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedFactory;
import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.util.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl extends EPackageImpl implements Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "isostdisois_13584_32ed_1techxmlschemaontomlSimplified.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternativeunitsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anytypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aposterioricaseofEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aposteriorisemanticrelationshipsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aposteriorisemanticrelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aposterioriviewofEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arraytypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignedvalueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authorsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axis1PLACEMENTTYPEEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axis2PLACEMENT2DTYPEEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axis2PLACEMENT3DTYPEEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bagtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleantypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categorizationclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classconstantvaluesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classesreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classextensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classpresentationonpaperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classpresentationonscreenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classreferencetypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classvalueassignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditiondetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationcontrolconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintorconstraintidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedclassesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedclassextensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containeddatatypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containeddocumentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedpropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedsuppliersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextdependentunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextparameterconstraintsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextparamiconEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextrestrictionconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversionbasedunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correspondingpropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createiconEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datatypereferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datatypesreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datedatatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datetimedatatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependentpdetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedunitelementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionariesreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionaryinstandardformatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionaryreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dicunitreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dicunitsreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dicunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dicvalueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionalexponentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentcontentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentidentifiernamelabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentidentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentsreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainconstraintsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass explicitfunctionalmodelclassextensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass explicititemclassextensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalfilesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalgraphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalresourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmclassviewofEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionalmodelclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generaltextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometriccontextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometricunitcontextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifieddocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illustrationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intcurrencytypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intdicvalueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integrityconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intmeasuretypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inttypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemclasscaseofEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itsvaluesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keywordlabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keywordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass languageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass levelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leveltypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryiimidentificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryinstandardformatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingfunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mathematicalstringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nondependentpdetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noninstantiablefunctionalviewclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonquantitativecodetypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonquantitativeinttypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonsiunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nontranslatablestringtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numbertypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ontomlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placementtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postconditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preconditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferrednamelabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferrednameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programreferencetypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyclassificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertymappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyvaluerecommendedpresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rationalmeasuretypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rationaltypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realcurrencytypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realmeasuretypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendedpresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceddocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencedgraphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remotelocationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representationpdetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representationreferencetypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setwithsubsetconstrainttypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortnamelabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortnameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siunitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourcedocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringdicvalueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringpatternconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringsizeconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subclassconstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supplierreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass suppliersreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supplierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supportedvepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synonymousnamelabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synonymousnameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synonymoussymbolsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedatatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translatablestringtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translationdataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uritypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vcvrangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewcontrolvariablerangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewexchangeprotocolidentificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum illustrationtypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum siprefixTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum siunitnameTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum standardsizeTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see isostdisois_13584_32ed_1techxmlschemaontomlSimplified.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl() {
		super(eNS_URI, Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage init() {
		if (isInited) return (Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI);

		// Obtain or create and register package
		Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage = (Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EpmlPackageImpl theEpmlPackage = (EpmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EpmlPackage.eNS_URI) instanceof EpmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EpmlPackage.eNS_URI) : EpmlPackage.eINSTANCE);

		// Load packages
		theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.loadPackage();

		// Create package meta-data objects
		theEpmlPackage.createPackageContents();

		// Initialize created meta-data
		theEpmlPackage.initializePackageContents();

		// Fix loaded packages
		theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI, theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage);
		return theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getALTERNATIVEUNITS() {
		if (alternativeunitsEClass == null) {
			alternativeunitsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(0);
		}
		return alternativeunitsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getALTERNATIVEUNITS_DicUnits() {
        return (EReference)getALTERNATIVEUNITS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getANYTYPE() {
		if (anytypeEClass == null) {
			anytypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(1);
		}
		return anytypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getANYTYPE_Constraints() {
        return (EReference)getANYTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPOSTERIORICASEOF() {
		if (aposterioricaseofEClass == null) {
			aposterioricaseofEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(2);
		}
		return aposterioricaseofEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORICASEOF_CaseOfSuper() {
        return (EReference)getAPOSTERIORICASEOF().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORICASEOF_CaseOfSub() {
        return (EReference)getAPOSTERIORICASEOF().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORICASEOF_CorrespondingProperties() {
        return (EReference)getAPOSTERIORICASEOF().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPOSTERIORISEMANTICRELATIONSHIPS() {
		if (aposteriorisemanticrelationshipsEClass == null) {
			aposteriorisemanticrelationshipsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(3);
		}
		return aposteriorisemanticrelationshipsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORISEMANTICRELATIONSHIPS_APosterioriSemanticRelationships() {
        return (EReference)getAPOSTERIORISEMANTICRELATIONSHIPS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPOSTERIORISEMANTICRELATIONSHIP() {
		if (aposteriorisemanticrelationshipEClass == null) {
			aposteriorisemanticrelationshipEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(4);
		}
		return aposteriorisemanticrelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAPOSTERIORISEMANTICRELATIONSHIP_Id() {
        return (EAttribute)getAPOSTERIORISEMANTICRELATIONSHIP().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAPOSTERIORIVIEWOF() {
		if (aposterioriviewofEClass == null) {
			aposterioriviewofEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(5);
		}
		return aposterioriviewofEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORIVIEWOF_Item() {
        return (EReference)getAPOSTERIORIVIEWOF().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORIVIEWOF_Model() {
        return (EReference)getAPOSTERIORIVIEWOF().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAPOSTERIORIVIEWOF_CorrespondingProperties() {
        return (EReference)getAPOSTERIORIVIEWOF().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getARRAYTYPE() {
		if (arraytypeEClass == null) {
			arraytypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(6);
		}
		return arraytypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getARRAYTYPE_Uniqueness() {
        return (EAttribute)getARRAYTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getARRAYTYPE_AreOptional() {
        return (EAttribute)getARRAYTYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getARRAYTYPE_ValueType() {
        return (EReference)getARRAYTYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getASSIGNEDVALUE() {
		if (assignedvalueEClass == null) {
			assignedvalueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(7);
		}
		return assignedvalueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAUTHORS() {
		if (authorsEClass == null) {
			authorsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(8);
		}
		return authorsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAUTHORS_Persons() {
        return (EReference)getAUTHORS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAXIS1PLACEMENTTYPE() {
		if (axis1PLACEMENTTYPEEClass == null) {
			axis1PLACEMENTTYPEEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(9);
		}
		return axis1PLACEMENTTYPEEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAXIS1PLACEMENTTYPE_ClassRef() {
        return (EAttribute)getAXIS1PLACEMENTTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAXIS2PLACEMENT2DTYPE() {
		if (axis2PLACEMENT2DTYPEEClass == null) {
			axis2PLACEMENT2DTYPEEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(10);
		}
		return axis2PLACEMENT2DTYPEEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAXIS2PLACEMENT2DTYPE_ClassRef() {
        return (EAttribute)getAXIS2PLACEMENT2DTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAXIS2PLACEMENT3DTYPE() {
		if (axis2PLACEMENT3DTYPEEClass == null) {
			axis2PLACEMENT3DTYPEEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(11);
		}
		return axis2PLACEMENT3DTYPEEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAXIS2PLACEMENT3DTYPE_ClassRef() {
        return (EAttribute)getAXIS2PLACEMENT3DTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAGTYPE() {
		if (bagtypeEClass == null) {
			bagtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(12);
		}
		return bagtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBAGTYPE_ValueType() {
        return (EReference)getBAGTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBOOLEANTYPE() {
		if (booleantypeEClass == null) {
			booleantypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(13);
		}
		return booleantypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBOOLEANTYPE_ValueFormat() {
        return (EAttribute)getBOOLEANTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCARDINALITYCONSTRAINT() {
		if (cardinalityconstraintEClass == null) {
			cardinalityconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(14);
		}
		return cardinalityconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCATEGORIZATIONCLASS() {
		if (categorizationclassEClass == null) {
			categorizationclassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(15);
		}
		return categorizationclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCATEGORIZATIONCLASS_CategorizationClassSuperclasses() {
        return (EReference)getCATEGORIZATIONCLASS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSCONSTANTVALUES() {
		if (classconstantvaluesEClass == null) {
			classconstantvaluesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(16);
		}
		return classconstantvaluesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSCONSTANTVALUES_ClassValueAssignments() {
        return (EReference)getCLASSCONSTANTVALUES().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSCONSTRAINT() {
		if (classconstraintEClass == null) {
			classconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(17);
		}
		return classconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSESREFERENCE() {
		if (classesreferenceEClass == null) {
			classesreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(18);
		}
		return classesreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSESREFERENCE_Class() {
        return (EReference)getCLASSESREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSEXTENSION() {
		if (classextensionEClass == null) {
			classextensionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(19);
		}
		return classextensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASSEXTENSION_ContentVersion() {
        return (EAttribute)getCLASSEXTENSION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASSEXTENSION_ContentRevision() {
        return (EAttribute)getCLASSEXTENSION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASSEXTENSION_TableLike() {
        return (EAttribute)getCLASSEXTENSION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSEXTENSION_DictionaryDefinition() {
        return (EReference)getCLASSEXTENSION().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSEXTENSION_RecommendedPresentation() {
        return (EReference)getCLASSEXTENSION().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSEXTENSION_Classification() {
        return (EReference)getCLASSEXTENSION().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSEXTENSION_InstanceIdentification() {
        return (EReference)getCLASSEXTENSION().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSIFICATION() {
		if (classificationEClass == null) {
			classificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(20);
		}
		return classificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSIFICATION_PropertyClassifications() {
        return (EReference)getCLASSIFICATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSPRESENTATIONONPAPER() {
		if (classpresentationonpaperEClass == null) {
			classpresentationonpaperEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(21);
		}
		return classpresentationonpaperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSPRESENTATIONONPAPER_Illustrations() {
        return (EReference)getCLASSPRESENTATIONONPAPER().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSPRESENTATIONONSCREEN() {
		if (classpresentationonscreenEClass == null) {
			classpresentationonscreenEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(22);
		}
		return classpresentationonscreenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSPRESENTATIONONSCREEN_Illustrations() {
        return (EReference)getCLASSPRESENTATIONONSCREEN().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSREFERENCE() {
		if (classreferenceEClass == null) {
			classreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(23);
		}
		return classreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASSREFERENCE_ClassRef() {
        return (EAttribute)getCLASSREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSREFERENCETYPE() {
		if (classreferencetypeEClass == null) {
			classreferencetypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(24);
		}
		return classreferencetypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSREFERENCETYPE_Domain() {
        return (EReference)getCLASSREFERENCETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASS() {
		if (classEClass == null) {
			classEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(25);
		}
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_DateOfOriginalDefinition() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_DateOfCurrentVersion() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_DateOfCurrentRevision() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_Revision() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_Status() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_IsDeprecated() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_HierarchicalPosition() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLASS_Id() {
        return (EAttribute)getCLASS().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Translation() {
        return (EReference)getCLASS().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_SourceLanguage() {
        return (EReference)getCLASS().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_IsDeprecatedInterpretation() {
        return (EReference)getCLASS().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_PreferredName() {
        return (EReference)getCLASS().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_SynonymousNames() {
        return (EReference)getCLASS().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_ShortName() {
        return (EReference)getCLASS().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Icon() {
        return (EReference)getCLASS().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Definition() {
        return (EReference)getCLASS().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_SourceDocOfDefinition() {
        return (EReference)getCLASS().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Note() {
        return (EReference)getCLASS().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Remark() {
        return (EReference)getCLASS().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_ItsSuperclass() {
        return (EReference)getCLASS().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_DescribedBy() {
        return (EReference)getCLASS().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_DefinedTypes() {
        return (EReference)getCLASS().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_DefinedDocuments() {
        return (EReference)getCLASS().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Constraints() {
        return (EReference)getCLASS().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_Keywords() {
        return (EReference)getCLASS().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_SubClassProperties() {
        return (EReference)getCLASS().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_ClassConstantValues() {
        return (EReference)getCLASS().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_GeometricRepresentationContext() {
        return (EReference)getCLASS().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASS_GlobalUnitContext() {
        return (EReference)getCLASS().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLASSVALUEASSIGNMENT() {
		if (classvalueassignmentEClass == null) {
			classvalueassignmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(26);
		}
		return classvalueassignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSVALUEASSIGNMENT_SuperClassDefinedProperty() {
        return (EReference)getCLASSVALUEASSIGNMENT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCLASSVALUEASSIGNMENT_AssignedValue() {
        return (EReference)getCLASSVALUEASSIGNMENT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONDITIONDET() {
		if (conditiondetEClass == null) {
			conditiondetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(27);
		}
		return conditiondetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONFIGURATIONCONTROLCONSTRAINT() {
		if (configurationcontrolconstraintEClass == null) {
			configurationcontrolconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(28);
		}
		return configurationcontrolconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONFIGURATIONCONTROLCONSTRAINT_Precondition() {
        return (EReference)getCONFIGURATIONCONTROLCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONFIGURATIONCONTROLCONSTRAINT_Postcondition() {
        return (EReference)getCONFIGURATIONCONTROLCONSTRAINT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONSTRAINTORCONSTRAINTID() {
		if (constraintorconstraintidEClass == null) {
			constraintorconstraintidEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(29);
		}
		return constraintorconstraintidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCONSTRAINTORCONSTRAINTID_ConstraintRef() {
        return (EAttribute)getCONSTRAINTORCONSTRAINTID().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONSTRAINTORCONSTRAINTID_ConstraintDefinition() {
        return (EReference)getCONSTRAINTORCONSTRAINTID().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONSTRAINTS() {
		if (constraintsEClass == null) {
			constraintsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(30);
		}
		return constraintsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONSTRAINTS_Constraints() {
        return (EReference)getCONSTRAINTS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONSTRAINT() {
		if (constraintEClass == null) {
			constraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(31);
		}
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCONSTRAINT_ConstraintId() {
        return (EAttribute)getCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTAINEDCLASSES() {
		if (containedclassesEClass == null) {
			containedclassesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(32);
		}
		return containedclassesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTAINEDCLASSES_Class() {
        return (EReference)getCONTAINEDCLASSES().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTAINEDCLASSEXTENSIONS() {
		if (containedclassextensionsEClass == null) {
			containedclassextensionsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(33);
		}
		return containedclassextensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTAINEDCLASSEXTENSIONS_ClassExtensions() {
        return (EReference)getCONTAINEDCLASSEXTENSIONS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTAINEDDATATYPES() {
		if (containeddatatypesEClass == null) {
			containeddatatypesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(34);
		}
		return containeddatatypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTAINEDDATATYPES_Datatypes() {
        return (EReference)getCONTAINEDDATATYPES().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTAINEDDOCUMENTS() {
		if (containeddocumentsEClass == null) {
			containeddocumentsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(35);
		}
		return containeddocumentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTAINEDDOCUMENTS_Documents() {
        return (EReference)getCONTAINEDDOCUMENTS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTAINEDPROPERTIES() {
		if (containedpropertiesEClass == null) {
			containedpropertiesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(36);
		}
		return containedpropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTAINEDPROPERTIES_Propertys() {
        return (EReference)getCONTAINEDPROPERTIES().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTAINEDSUPPLIERS() {
		if (containedsuppliersEClass == null) {
			containedsuppliersEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(37);
		}
		return containedsuppliersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTAINEDSUPPLIERS_Suppliers() {
        return (EReference)getCONTAINEDSUPPLIERS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTEXTDEPENDENTUNIT() {
		if (contextdependentunitEClass == null) {
			contextdependentunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(38);
		}
		return contextdependentunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCONTEXTDEPENDENTUNIT_Name() {
        return (EAttribute)getCONTEXTDEPENDENTUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTEXTPARAMETERCONSTRAINTS() {
		if (contextparameterconstraintsEClass == null) {
			contextparameterconstraintsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(39);
		}
		return contextparameterconstraintsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTEXTPARAMETERCONSTRAINTS_IntegrityConstraints() {
        return (EReference)getCONTEXTPARAMETERCONSTRAINTS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTEXTPARAMICON() {
		if (contextparamiconEClass == null) {
			contextparamiconEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(40);
		}
		return contextparamiconEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTEXTPARAMICON_A6Illustrations() {
        return (EReference)getCONTEXTPARAMICON().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONTEXTRESTRICTIONCONSTRAINT() {
		if (contextrestrictionconstraintEClass == null) {
			contextrestrictionconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(41);
		}
		return contextrestrictionconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONTEXTRESTRICTIONCONSTRAINT_ContextParameterConstraints() {
        return (EReference)getCONTEXTRESTRICTIONCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCONVERSIONBASEDUNIT() {
		if (conversionbasedunitEClass == null) {
			conversionbasedunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(42);
		}
		return conversionbasedunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCONVERSIONBASEDUNIT_Name() {
        return (EAttribute)getCONVERSIONBASEDUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCONVERSIONBASEDUNIT_UnitComponent() {
        return (EReference)getCONVERSIONBASEDUNIT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCORRESPONDINGPROPERTIES() {
		if (correspondingpropertiesEClass == null) {
			correspondingpropertiesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(43);
		}
		return correspondingpropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCORRESPONDINGPROPERTIES_Mappings() {
        return (EReference)getCORRESPONDINGPROPERTIES().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCREATEICON() {
		if (createiconEClass == null) {
			createiconEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(44);
		}
		return createiconEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCREATEICON_Illustrations() {
        return (EReference)getCREATEICON().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDATATYPEREFERENCE() {
		if (datatypereferenceEClass == null) {
			datatypereferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(45);
		}
		return datatypereferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPEREFERENCE_DatatypeRef() {
        return (EAttribute)getDATATYPEREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDATATYPESREFERENCE() {
		if (datatypesreferenceEClass == null) {
			datatypesreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(46);
		}
		return datatypesreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPESREFERENCE_Datatypes() {
        return (EReference)getDATATYPESREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDATATYPE() {
		if (datatypeEClass == null) {
			datatypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(47);
		}
		return datatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_DateOfOriginalDefinition() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_DateOfCurrentVersion() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_DateOfCurrentRevision() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_Revision() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_Status() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_IsDeprecated() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATATYPE_Id() {
        return (EAttribute)getDATATYPE().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_NameScope() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_Translation() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_SourceLanguage() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_IsDeprecatedInterpretation() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_PreferredName() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_SynonymousNames() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_ShortName() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_Icon() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDATATYPE_TypeDefinition() {
        return (EReference)getDATATYPE().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDATEDATATYPE() {
		if (datedatatypeEClass == null) {
			datedatatypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(48);
		}
		return datedatatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATEDATATYPE_ValueFormat() {
        return (EAttribute)getDATEDATATYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDATETIMEDATATYPE() {
		if (datetimedatatypeEClass == null) {
			datetimedatatypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(49);
		}
		return datetimedatatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDATETIMEDATATYPE_ValueFormat() {
        return (EAttribute)getDATETIMEDATATYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDEPENDENTPDET() {
		if (dependentpdetEClass == null) {
			dependentpdetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(50);
		}
		return dependentpdetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDEPENDENTPDET_DependsOn() {
        return (EReference)getDEPENDENTPDET().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDERIVEDUNITELEMENT() {
		if (derivedunitelementEClass == null) {
			derivedunitelementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(51);
		}
		return derivedunitelementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDERIVEDUNITELEMENT_Unit() {
        return (EReference)getDERIVEDUNITELEMENT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDERIVEDUNIT() {
		if (derivedunitEClass == null) {
			derivedunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(52);
		}
		return derivedunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDERIVEDUNIT_DerivedUnitElements() {
        return (EReference)getDERIVEDUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICTIONARIESREFERENCE() {
		if (dictionariesreferenceEClass == null) {
			dictionariesreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(53);
		}
		return dictionariesreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARIESREFERENCE_Dictionarys() {
        return (EReference)getDICTIONARIESREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICTIONARYINSTANDARDFORMAT() {
		if (dictionaryinstandardformatEClass == null) {
			dictionaryinstandardformatEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(54);
		}
		return dictionaryinstandardformatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICTIONARYREFERENCE() {
		if (dictionaryreferenceEClass == null) {
			dictionaryreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(55);
		}
		return dictionaryreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICTIONARYREFERENCE_DictionaryRef() {
        return (EAttribute)getDICTIONARYREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICTIONARY() {
		if (dictionaryEClass == null) {
			dictionaryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(56);
		}
		return dictionaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICTIONARY_IsComplete() {
        return (EAttribute)getDICTIONARY().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICTIONARY_UpdateAgreement() {
        return (EAttribute)getDICTIONARY().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_Updates() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ReferencedDictionaries() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ResponsibleSupplier() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ContainedClasses() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_APosterioriSemanticRelationships() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ContainedSuppliers() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ContainedProperties() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ContainedDocuments() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICTIONARY_ContainedDatatypes() {
        return (EReference)getDICTIONARY().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICUNITREFERENCE() {
		if (dicunitreferenceEClass == null) {
			dicunitreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(57);
		}
		return dicunitreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICUNITREFERENCE_DicUnitRef() {
        return (EAttribute)getDICUNITREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICUNITSREFERENCE() {
		if (dicunitsreferenceEClass == null) {
			dicunitsreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(58);
		}
		return dicunitsreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICUNITSREFERENCE_DicUnits() {
        return (EReference)getDICUNITSREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICUNIT() {
		if (dicunitEClass == null) {
			dicunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(59);
		}
		return dicunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICUNIT_UnitRef() {
        return (EAttribute)getDICUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICUNIT_StructuredRepresentation() {
        return (EReference)getDICUNIT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICUNIT_StringRepresentation() {
        return (EReference)getDICUNIT().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDICVALUE() {
		if (dicvalueEClass == null) {
			dicvalueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(60);
		}
		return dicvalueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICVALUE_Status() {
        return (EAttribute)getDICVALUE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICVALUE_IsDeprecated() {
        return (EAttribute)getDICVALUE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDICVALUE_ValueMeaningId() {
        return (EAttribute)getDICVALUE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_PreferredName() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_SynonymousNames() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_ShortName() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_Icon() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_SourceDocOfDefinition() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_Definition() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDICVALUE_IsDeprecatedInterpretation() {
        return (EReference)getDICVALUE().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDIMENSIONALEXPONENTS() {
		if (dimensionalexponentsEClass == null) {
			dimensionalexponentsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(61);
		}
		return dimensionalexponentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOCUMENTCONTENT() {
		if (documentcontentEClass == null) {
			documentcontentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(62);
		}
		return documentcontentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENTCONTENT_Revision() {
        return (EAttribute)getDOCUMENTCONTENT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOCUMENTIDENTIFIERNAMELABEL() {
		if (documentidentifiernamelabelEClass == null) {
			documentidentifiernamelabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(63);
		}
		return documentidentifiernamelabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENTIDENTIFIERNAMELABEL_Value() {
        return (EAttribute)getDOCUMENTIDENTIFIERNAMELABEL().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENTIDENTIFIERNAMELABEL_CountryCode() {
        return (EAttribute)getDOCUMENTIDENTIFIERNAMELABEL().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENTIDENTIFIERNAMELABEL_LanguageCode() {
        return (EAttribute)getDOCUMENTIDENTIFIERNAMELABEL().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOCUMENTIDENTIFIER() {
		if (documentidentifierEClass == null) {
			documentidentifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(64);
		}
		return documentidentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENTIDENTIFIER_Labels() {
        return (EReference)getDOCUMENTIDENTIFIER().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOCUMENTREFERENCE() {
		if (documentreferenceEClass == null) {
			documentreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(65);
		}
		return documentreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENTREFERENCE_DocumentRef() {
        return (EAttribute)getDOCUMENTREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOCUMENTSREFERENCE() {
		if (documentsreferenceEClass == null) {
			documentsreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(66);
		}
		return documentsreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENTSREFERENCE_Documents() {
        return (EReference)getDOCUMENTSREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOCUMENT() {
		if (documentEClass == null) {
			documentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(67);
		}
		return documentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_DateOfOriginalDefinition() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_DateOfCurrentVersion() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_DateOfCurrentRevision() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_Revision() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_Status() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_IsDeprecated() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOCUMENT_Id() {
        return (EAttribute)getDOCUMENT().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_NameScope() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Translation() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_SourceLanguage() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_IsDeprecatedInterpretation() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_PreferredName() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_SynonymousNames() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_ShortName() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Icon() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Definition() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Note() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Remark() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Authors() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_PublishingOrganisation() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOCUMENT_Content() {
        return (EReference)getDOCUMENT().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOMAINCONSTRAINTS() {
		if (domainconstraintsEClass == null) {
			domainconstraintsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(68);
		}
		return domainconstraintsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDOMAINCONSTRAINTS_Constraints() {
        return (EReference)getDOMAINCONSTRAINTS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOMAINCONSTRAINT() {
		if (domainconstraintEClass == null) {
			domainconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(69);
		}
		return domainconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getENUMERATIONCONSTRAINT() {
		if (enumerationconstraintEClass == null) {
			enumerationconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(70);
		}
		return enumerationconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getENUMERATIONCONSTRAINT_Subset() {
        return (EReference)getENUMERATIONCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getENUMERATIONCONSTRAINT_ValueMeaning() {
        return (EReference)getENUMERATIONCONSTRAINT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXPLICITFUNCTIONALMODELCLASSEXTENSION() {
		if (explicitfunctionalmodelclassextensionEClass == null) {
			explicitfunctionalmodelclassextensionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(71);
		}
		return explicitfunctionalmodelclassextensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITFUNCTIONALMODELCLASSEXTENSION_RequiredItemValues() {
        return (EReference)getEXPLICITFUNCTIONALMODELCLASSEXTENSION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITFUNCTIONALMODELCLASSEXTENSION_AvailableViewsIcon() {
        return (EReference)getEXPLICITFUNCTIONALMODELCLASSEXTENSION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITFUNCTIONALMODELCLASSEXTENSION_AvailableViewsMsg() {
        return (EReference)getEXPLICITFUNCTIONALMODELCLASSEXTENSION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITFUNCTIONALMODELCLASSEXTENSION_ContextParamIcon() {
        return (EReference)getEXPLICITFUNCTIONALMODELCLASSEXTENSION().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITFUNCTIONALMODELCLASSEXTENSION_ContextParamMsg() {
        return (EReference)getEXPLICITFUNCTIONALMODELCLASSEXTENSION().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXPLICITITEMCLASSEXTENSION() {
		if (explicititemclassextensionEClass == null) {
			explicititemclassextensionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(72);
		}
		return explicititemclassextensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITITEMCLASSEXTENSION_AccessIcon() {
        return (EReference)getEXPLICITITEMCLASSEXTENSION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITITEMCLASSEXTENSION_ContentMsg() {
        return (EReference)getEXPLICITITEMCLASSEXTENSION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITITEMCLASSEXTENSION_CreateIcon() {
        return (EReference)getEXPLICITITEMCLASSEXTENSION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITITEMCLASSEXTENSION_CreateMsg() {
        return (EReference)getEXPLICITITEMCLASSEXTENSION().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITITEMCLASSEXTENSION_ClassPresentationOnPaper() {
        return (EReference)getEXPLICITITEMCLASSEXTENSION().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXPLICITITEMCLASSEXTENSION_ClassPresentationOnScreen() {
        return (EReference)getEXPLICITITEMCLASSEXTENSION().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXTERNALFILES() {
		if (externalfilesEClass == null) {
			externalfilesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(73);
		}
		return externalfilesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXTERNALGRAPHICS() {
		if (externalgraphicsEClass == null) {
			externalgraphicsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(74);
		}
		return externalgraphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXTERNALGRAPHICS_Representation() {
        return (EReference)getEXTERNALGRAPHICS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXTERNALRESOURCE() {
		if (externalresourceEClass == null) {
			externalresourceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(75);
		}
		return externalresourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEXTERNALRESOURCE_Files() {
        return (EReference)getEXTERNALRESOURCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFILTER() {
		if (filterEClass == null) {
			filterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(76);
		}
		return filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFILTER_ReferencedProperty() {
        return (EReference)getFILTER().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFILTER_Domain() {
        return (EReference)getFILTER().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMCLASSVIEWOF() {
		if (fmclassviewofEClass == null) {
			fmclassviewofEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(77);
		}
		return fmclassviewofEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_CreatedView() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_VCVRange() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedPropertiesFromView() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedTypesFromView() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedDocumentsFromView() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedConstraintsFromView() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_CaseOf() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedPropertiesFromModels() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedTypesFromModels() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedDocumentsFromModels() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedConstraintsFromModels() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ViewOf() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedPropertiesFromItem() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedTypesFromItem() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedDocumentsFromItem() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFMCLASSVIEWOF_ImportedConstraintsFromItem() {
        return (EReference)getFMCLASSVIEWOF().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFUNCTIONALMODELCLASS() {
		if (functionalmodelclassEClass == null) {
			functionalmodelclassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(78);
		}
		return functionalmodelclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_CreatedView() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_VCVRange() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedPropertiesFromView() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedTypesFromView() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedDocumentsFromView() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedCosntraintsFromView() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_CaseOf() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedPropertiesFromModels() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedTypesFromModels() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedDocumentsFromModels() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFUNCTIONALMODELCLASS_ImportedConstraintsFromModels() {
        return (EReference)getFUNCTIONALMODELCLASS().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGENERALTEXT() {
		if (generaltextEClass == null) {
			generaltextEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(79);
		}
		return generaltextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGENERALTEXT_Value() {
        return (EAttribute)getGENERALTEXT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGENERALTEXT_CountryCode() {
        return (EAttribute)getGENERALTEXT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGENERALTEXT_LanguageCode() {
        return (EAttribute)getGENERALTEXT().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGEOMETRICCONTEXT() {
		if (geometriccontextEClass == null) {
			geometriccontextEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(80);
		}
		return geometriccontextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGEOMETRICCONTEXT_Description() {
        return (EReference)getGEOMETRICCONTEXT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGEOMETRICUNITCONTEXT() {
		if (geometricunitcontextEClass == null) {
			geometricunitcontextEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(81);
		}
		return geometricunitcontextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGEOMETRICUNITCONTEXT_LengthUnit() {
        return (EReference)getGEOMETRICUNITCONTEXT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGEOMETRICUNITCONTEXT_LengthUnitId() {
        return (EReference)getGEOMETRICUNITCONTEXT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGEOMETRICUNITCONTEXT_LangleUnit() {
        return (EReference)getGEOMETRICUNITCONTEXT().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGEOMETRICUNITCONTEXT_AngleUnitId() {
        return (EReference)getGEOMETRICUNITCONTEXT().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGRAPHICS() {
		if (graphicsEClass == null) {
			graphicsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(82);
		}
		return graphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHEADER() {
		if (headerEClass == null) {
			headerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(83);
		}
		return headerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Description() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Version() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Name() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_DateTimeStamp() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Authors() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Organisations() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_PreProcessorVersion() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_OriginatingSystem() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Authorisation() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHEADER_Id() {
        return (EAttribute)getHEADER().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHEADER_GlobalLanguage() {
        return (EReference)getHEADER().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHEADER_OntomlInformation() {
        return (EReference)getHEADER().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHEADER_OntomlStructure() {
        return (EReference)getHEADER().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHEADER_SupportedVep() {
        return (EReference)getHEADER().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHTTPFILE() {
		if (httpfileEClass == null) {
			httpfileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(84);
		}
		return httpfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPFILE_HttpFile() {
        return (EAttribute)getHTTPFILE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPFILE_FileName() {
        return (EAttribute)getHTTPFILE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPFILE_DirName() {
        return (EAttribute)getHTTPFILE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPFILE_CountryCode() {
        return (EAttribute)getHTTPFILE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHTTPFILE_LanguageCode() {
        return (EAttribute)getHTTPFILE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDENTIFIEDDOCUMENT() {
		if (identifieddocumentEClass == null) {
			identifieddocumentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(85);
		}
		return identifieddocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDENTIFIEDDOCUMENT_DocumentIdentifier() {
        return (EReference)getIDENTIFIEDDOCUMENT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILLUSTRATION() {
		if (illustrationEClass == null) {
			illustrationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(86);
		}
		return illustrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILLUSTRATION_Code() {
        return (EAttribute)getILLUSTRATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILLUSTRATION_KindOfContent() {
        return (EAttribute)getILLUSTRATION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILLUSTRATION_StandardSize() {
        return (EAttribute)getILLUSTRATION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINFORMATION() {
		if (informationEClass == null) {
			informationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(88);
		}
		return informationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINFORMATION_Revision() {
        return (EAttribute)getINFORMATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINFORMATION_PreferredName() {
        return (EReference)getINFORMATION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINFORMATION_SynonymousNames() {
        return (EReference)getINFORMATION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINFORMATION_ShortName() {
        return (EReference)getINFORMATION().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINFORMATION_Icon() {
        return (EReference)getINFORMATION().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINFORMATION_Note() {
        return (EReference)getINFORMATION().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINFORMATION_Remark() {
        return (EReference)getINFORMATION().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINTCURRENCYTYPE() {
		if (intcurrencytypeEClass == null) {
			intcurrencytypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(89);
		}
		return intcurrencytypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINTCURRENCYTYPE_ValueFormat() {
        return (EAttribute)getINTCURRENCYTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINTCURRENCYTYPE_Currency() {
        return (EAttribute)getINTCURRENCYTYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINTCURRENCYTYPE_CurrencyId() {
        return (EAttribute)getINTCURRENCYTYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINTDICVALUE() {
		if (intdicvalueEClass == null) {
			intdicvalueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(90);
		}
		return intdicvalueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINTEGRITYCONSTRAINT() {
		if (integrityconstraintEClass == null) {
			integrityconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(91);
		}
		return integrityconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINTEGRITYCONSTRAINT_RedefinedDomain() {
        return (EReference)getINTEGRITYCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINTMEASURETYPE() {
		if (intmeasuretypeEClass == null) {
			intmeasuretypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(92);
		}
		return intmeasuretypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINTMEASURETYPE_ValueFormat() {
        return (EAttribute)getINTMEASURETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINTMEASURETYPE_Unit() {
        return (EReference)getINTMEASURETYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINTMEASURETYPE_AlternativeUnits() {
        return (EReference)getINTMEASURETYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINTMEASURETYPE_UnitId() {
        return (EReference)getINTMEASURETYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getINTMEASURETYPE_AlternativeUnitIds() {
        return (EReference)getINTMEASURETYPE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINTTYPE() {
		if (inttypeEClass == null) {
			inttypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(93);
		}
		return inttypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getINTTYPE_ValueFormat() {
        return (EAttribute)getINTTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITEMCLASSCASEOF() {
		if (itemclasscaseofEClass == null) {
			itemclasscaseofEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(94);
		}
		return itemclasscaseofEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITEMCLASSCASEOF_CodedName() {
        return (EAttribute)getITEMCLASSCASEOF().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITEMCLASSCASEOF_InstanceSharable() {
        return (EAttribute)getITEMCLASSCASEOF().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASSCASEOF_SimplifiedDrawing() {
        return (EReference)getITEMCLASSCASEOF().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASSCASEOF_IsCaseOf() {
        return (EReference)getITEMCLASSCASEOF().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASSCASEOF_ImportedProperties() {
        return (EReference)getITEMCLASSCASEOF().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASSCASEOF_ImportedTypes() {
        return (EReference)getITEMCLASSCASEOF().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASSCASEOF_ImportedDocuments() {
        return (EReference)getITEMCLASSCASEOF().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASSCASEOF_ImportedConstraints() {
        return (EReference)getITEMCLASSCASEOF().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITEMCLASS() {
		if (itemclassEClass == null) {
			itemclassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(95);
		}
		return itemclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITEMCLASS_CodedName() {
        return (EAttribute)getITEMCLASS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITEMCLASS_InstanceSharable() {
        return (EAttribute)getITEMCLASS().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITEMCLASS_SimplifiedDrawing() {
        return (EReference)getITEMCLASS().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITSVALUES() {
		if (itsvaluesEClass == null) {
			itsvaluesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(96);
		}
		return itsvaluesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITSVALUES_DicValues() {
        return (EReference)getITSVALUES().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKEYWORDLABEL() {
		if (keywordlabelEClass == null) {
			keywordlabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(97);
		}
		return keywordlabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKEYWORDLABEL_Value() {
        return (EAttribute)getKEYWORDLABEL().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKEYWORDLABEL_CountryCode() {
        return (EAttribute)getKEYWORDLABEL().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKEYWORDLABEL_LanguageCode() {
        return (EAttribute)getKEYWORDLABEL().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKEYWORD() {
		if (keywordEClass == null) {
			keywordEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(98);
		}
		return keywordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKEYWORD_Labels() {
        return (EReference)getKEYWORD().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLANGUAGE() {
		if (languageEClass == null) {
			languageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(99);
		}
		return languageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLANGUAGE_CountryCode() {
        return (EAttribute)getLANGUAGE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLANGUAGE_LanguageCode() {
        return (EAttribute)getLANGUAGE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEVEL() {
		if (levelEClass == null) {
			levelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(100);
		}
		return levelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEVELTYPE() {
		if (leveltypeEClass == null) {
			leveltypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(101);
		}
		return leveltypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLEVELTYPE_Levels() {
        return (EReference)getLEVELTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLEVELTYPE_ValueType() {
        return (EReference)getLEVELTYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLIBRARYIIMIDENTIFICATION() {
		if (libraryiimidentificationEClass == null) {
			libraryiimidentificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(102);
		}
		return libraryiimidentificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLIBRARYIIMIDENTIFICATION_SourceDocumentIdentifier() {
        return (EAttribute)getLIBRARYIIMIDENTIFICATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLIBRARYIIMIDENTIFICATION_Status() {
        return (EAttribute)getLIBRARYIIMIDENTIFICATION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLIBRARYIIMIDENTIFICATION_Name() {
        return (EAttribute)getLIBRARYIIMIDENTIFICATION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLIBRARYIIMIDENTIFICATION_Application() {
        return (EAttribute)getLIBRARYIIMIDENTIFICATION().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLIBRARYIIMIDENTIFICATION_Level() {
        return (EAttribute)getLIBRARYIIMIDENTIFICATION().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLIBRARYINSTANDARDFORMAT() {
		if (libraryinstandardformatEClass == null) {
			libraryinstandardformatEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(103);
		}
		return libraryinstandardformatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLIBRARY() {
		if (libraryEClass == null) {
			libraryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(104);
		}
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLIBRARY_ContainedClassExtensions() {
        return (EReference)getLIBRARY().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLIBRARY_ResponsibleSupplier() {
        return (EReference)getLIBRARY().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLISTTYPE() {
		if (listtypeEClass == null) {
			listtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(105);
		}
		return listtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLISTTYPE_Uniqueness() {
        return (EAttribute)getLISTTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLISTTYPE_ValueType() {
        return (EReference)getLISTTYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAPPINGFUNCTION() {
		if (mappingfunctionEClass == null) {
			mappingfunctionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(106);
		}
		return mappingfunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMATHEMATICALSTRING() {
		if (mathematicalstringEClass == null) {
			mathematicalstringEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(107);
		}
		return mathematicalstringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMATHEMATICALSTRING_TextRepresentation() {
        return (EAttribute)getMATHEMATICALSTRING().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMESSAGE() {
		if (messageEClass == null) {
			messageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(108);
		}
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMESSAGE_Code() {
        return (EAttribute)getMESSAGE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAMEDTYPE() {
		if (namedtypeEClass == null) {
			namedtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(109);
		}
		return namedtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAMEDTYPE_ReferredType() {
        return (EReference)getNAMEDTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAMEDUNIT() {
		if (namedunitEClass == null) {
			namedunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(110);
		}
		return namedunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAMEDUNIT_Dimensions() {
        return (EReference)getNAMEDUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNONDEPENDENTPDET() {
		if (nondependentpdetEClass == null) {
			nondependentpdetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(111);
		}
		return nondependentpdetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNONINSTANTIABLEFUNCTIONALVIEWCLASS() {
		if (noninstantiablefunctionalviewclassEClass == null) {
			noninstantiablefunctionalviewclassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(112);
		}
		return noninstantiablefunctionalviewclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONINSTANTIABLEFUNCTIONALVIEWCLASS_ViewControlVariables() {
        return (EReference)getNONINSTANTIABLEFUNCTIONALVIEWCLASS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNONQUANTITATIVECODETYPE() {
		if (nonquantitativecodetypeEClass == null) {
			nonquantitativecodetypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(113);
		}
		return nonquantitativecodetypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNONQUANTITATIVECODETYPE_ValueFormat() {
        return (EAttribute)getNONQUANTITATIVECODETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVECODETYPE_ItsValues() {
        return (EReference)getNONQUANTITATIVECODETYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVECODETYPE_SourceDocOfValueDomain() {
        return (EReference)getNONQUANTITATIVECODETYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVECODETYPE_Definition() {
        return (EReference)getNONQUANTITATIVECODETYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVECODETYPE_Icon() {
        return (EReference)getNONQUANTITATIVECODETYPE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNONQUANTITATIVEINTTYPE() {
		if (nonquantitativeinttypeEClass == null) {
			nonquantitativeinttypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(114);
		}
		return nonquantitativeinttypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNONQUANTITATIVEINTTYPE_ValueFormat() {
        return (EAttribute)getNONQUANTITATIVEINTTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVEINTTYPE_ItsValues() {
        return (EReference)getNONQUANTITATIVEINTTYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVEINTTYPE_SourceDocOfValueDomain() {
        return (EReference)getNONQUANTITATIVEINTTYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVEINTTYPE_Definition() {
        return (EReference)getNONQUANTITATIVEINTTYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNONQUANTITATIVEINTTYPE_Icon() {
        return (EReference)getNONQUANTITATIVEINTTYPE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNONSIUNIT() {
		if (nonsiunitEClass == null) {
			nonsiunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(115);
		}
		return nonsiunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNONSIUNIT_Name() {
        return (EAttribute)getNONSIUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNONTRANSLATABLESTRINGTYPE() {
		if (nontranslatablestringtypeEClass == null) {
			nontranslatablestringtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(116);
		}
		return nontranslatablestringtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNONTRANSLATABLESTRINGTYPE_ValueFormat() {
        return (EAttribute)getNONTRANSLATABLESTRINGTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNUMBERTYPE() {
		if (numbertypeEClass == null) {
			numbertypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(117);
		}
		return numbertypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNUMBERTYPE_ValueFormat() {
        return (EAttribute)getNUMBERTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getONTOML() {
		if (ontomlEClass == null) {
			ontomlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(118);
		}
		return ontomlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getONTOML_Header() {
        return (EReference)getONTOML().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getONTOML_Dictionary() {
        return (EReference)getONTOML().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getONTOML_Library() {
        return (EReference)getONTOML().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getORGANIZATION() {
		if (organizationEClass == null) {
			organizationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(119);
		}
		return organizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getORGANIZATION_Id() {
        return (EAttribute)getORGANIZATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getORGANIZATION_Name() {
        return (EAttribute)getORGANIZATION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getORGANIZATION_Description() {
        return (EAttribute)getORGANIZATION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPERSON() {
		if (personEClass == null) {
			personEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(120);
		}
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPERSON_Id() {
        return (EAttribute)getPERSON().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPERSON_LastName() {
        return (EAttribute)getPERSON().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPERSON_FirstName() {
        return (EAttribute)getPERSON().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPERSON_MiddleNames() {
        return (EReference)getPERSON().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPERSON_PrefixTitles() {
        return (EReference)getPERSON().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPERSON_SuffixTitles() {
        return (EReference)getPERSON().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPLACEMENTTYPE() {
		if (placementtypeEClass == null) {
			placementtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(121);
		}
		return placementtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPLACEMENTTYPE_ClassRef() {
        return (EAttribute)getPLACEMENTTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPOSTCONDITION() {
		if (postconditionEClass == null) {
			postconditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(122);
		}
		return postconditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPOSTCONDITION_Filters() {
        return (EReference)getPOSTCONDITION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPRECONDITION() {
		if (preconditionEClass == null) {
			preconditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(123);
		}
		return preconditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRECONDITION_Filters() {
        return (EReference)getPRECONDITION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPREFERREDNAMELABEL() {
		if (preferrednamelabelEClass == null) {
			preferrednamelabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(124);
		}
		return preferrednamelabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPREFERREDNAMELABEL_Value() {
        return (EAttribute)getPREFERREDNAMELABEL().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPREFERREDNAMELABEL_CountryCode() {
        return (EAttribute)getPREFERREDNAMELABEL().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPREFERREDNAMELABEL_LanguageCode() {
        return (EAttribute)getPREFERREDNAMELABEL().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPREFERREDNAME() {
		if (preferrednameEClass == null) {
			preferrednameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(125);
		}
		return preferrednameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPREFERREDNAME_Labels() {
        return (EReference)getPREFERREDNAME().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROGRAMREFERENCETYPE() {
		if (programreferencetypeEClass == null) {
			programreferencetypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(126);
		}
		return programreferencetypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROGRAMREFERENCETYPE_ClassRef() {
        return (EAttribute)getPROGRAMREFERENCETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROGRAMREFERENCETYPE_InParameters() {
        return (EReference)getPROGRAMREFERENCETYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROGRAMREFERENCETYPE_OutParameters() {
        return (EReference)getPROGRAMREFERENCETYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROGRAMREFERENCETYPE_InoutParameters() {
        return (EReference)getPROGRAMREFERENCETYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTIESREFERENCE() {
		if (propertiesreferenceEClass == null) {
			propertiesreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(127);
		}
		return propertiesreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTIESREFERENCE_Propertys() {
        return (EReference)getPROPERTIESREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTYCLASSIFICATION() {
		if (propertyclassificationEClass == null) {
			propertyclassificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(128);
		}
		return propertyclassificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYCLASSIFICATION_PropDef() {
        return (EReference)getPROPERTYCLASSIFICATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTYCONSTRAINT() {
		if (propertyconstraintEClass == null) {
			propertyconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(129);
		}
		return propertyconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYCONSTRAINT_ConstrainedProperty() {
        return (EReference)getPROPERTYCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTYMAPPING() {
		if (propertymappingEClass == null) {
			propertymappingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(130);
		}
		return propertymappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYMAPPING_Domains() {
        return (EReference)getPROPERTYMAPPING().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYMAPPING_Range() {
        return (EReference)getPROPERTYMAPPING().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYMAPPING_Function() {
        return (EReference)getPROPERTYMAPPING().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTYREFERENCE() {
		if (propertyreferenceEClass == null) {
			propertyreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(131);
		}
		return propertyreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTYREFERENCE_PropertyRef() {
        return (EAttribute)getPROPERTYREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTY() {
		if (propertyEClass == null) {
			propertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(132);
		}
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_DateOfOriginalDefinition() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_DateOfCurrentVersion() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_DateOfCurrentRevision() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_Revision() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_Status() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_IsDeprecated() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_DetClassification() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_SuggestedValueList() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTY_Id() {
        return (EAttribute)getPROPERTY().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_NameScope() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Translation() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_SourceLanguage() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_IsDeprecatedInterpretation() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_PreferredName() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_SynonymousNames() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_ShortName() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Icon() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Definition() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_SourceDocOfDefinition() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Note() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Remark() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_PreferredSymbol() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_SynonymousSymbols() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Figure() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Domain() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTY_Formula() {
        return (EReference)getPROPERTY().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPROPERTYVALUERECOMMENDEDPRESENTATION() {
		if (propertyvaluerecommendedpresentationEClass == null) {
			propertyvaluerecommendedpresentationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(133);
		}
		return propertyvaluerecommendedpresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPROPERTYVALUERECOMMENDEDPRESENTATION_RecommendedPresentationFormat() {
        return (EAttribute)getPROPERTYVALUERECOMMENDEDPRESENTATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYVALUERECOMMENDEDPRESENTATION_PropDef() {
        return (EReference)getPROPERTYVALUERECOMMENDEDPRESENTATION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPROPERTYVALUERECOMMENDEDPRESENTATION_RecommendedPresentationUnit() {
        return (EReference)getPROPERTYVALUERECOMMENDEDPRESENTATION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRANGECONSTRAINT() {
		if (rangeconstraintEClass == null) {
			rangeconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(134);
		}
		return rangeconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRATIONALMEASURETYPE() {
		if (rationalmeasuretypeEClass == null) {
			rationalmeasuretypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(135);
		}
		return rationalmeasuretypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRATIONALMEASURETYPE_ValueFormat() {
        return (EAttribute)getRATIONALMEASURETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRATIONALMEASURETYPE_Unit() {
        return (EReference)getRATIONALMEASURETYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRATIONALMEASURETYPE_AlternativeUnits() {
        return (EReference)getRATIONALMEASURETYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRATIONALMEASURETYPE_UnitId() {
        return (EReference)getRATIONALMEASURETYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRATIONALMEASURETYPE_AlternativeUnitIds() {
        return (EReference)getRATIONALMEASURETYPE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRATIONALTYPE() {
		if (rationaltypeEClass == null) {
			rationaltypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(136);
		}
		return rationaltypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRATIONALTYPE_ValueFormat() {
        return (EAttribute)getRATIONALTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREALCURRENCYTYPE() {
		if (realcurrencytypeEClass == null) {
			realcurrencytypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(137);
		}
		return realcurrencytypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREALCURRENCYTYPE_ValueFormat() {
        return (EAttribute)getREALCURRENCYTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREALCURRENCYTYPE_Currency() {
        return (EAttribute)getREALCURRENCYTYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREALCURRENCYTYPE_CurrencyId() {
        return (EAttribute)getREALCURRENCYTYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREALMEASURETYPE() {
		if (realmeasuretypeEClass == null) {
			realmeasuretypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(138);
		}
		return realmeasuretypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREALMEASURETYPE_ValueFormat() {
        return (EAttribute)getREALMEASURETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREALMEASURETYPE_Unit() {
        return (EReference)getREALMEASURETYPE().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREALMEASURETYPE_AlternativeUnits() {
        return (EReference)getREALMEASURETYPE().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREALMEASURETYPE_UnitId() {
        return (EReference)getREALMEASURETYPE().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREALMEASURETYPE_AlternativeUnitIds() {
        return (EReference)getREALMEASURETYPE().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREALTYPE() {
		if (realtypeEClass == null) {
			realtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(139);
		}
		return realtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREALTYPE_ValueFormat() {
        return (EAttribute)getREALTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRECOMMENDEDPRESENTATION() {
		if (recommendedpresentationEClass == null) {
			recommendedpresentationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(140);
		}
		return recommendedpresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRECOMMENDEDPRESENTATION_PropertyValueRecommendedPresentations() {
        return (EReference)getRECOMMENDEDPRESENTATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREFERENCEDDOCUMENT() {
		if (referenceddocumentEClass == null) {
			referenceddocumentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(141);
		}
		return referenceddocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREFERENCEDDOCUMENT_DocumentReference() {
        return (EReference)getREFERENCEDDOCUMENT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREFERENCEDGRAPHICS() {
		if (referencedgraphicsEClass == null) {
			referencedgraphicsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(142);
		}
		return referencedgraphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREFERENCEDGRAPHICS_GraphicsReference() {
        return (EReference)getREFERENCEDGRAPHICS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREMOTELOCATIONS() {
		if (remotelocationsEClass == null) {
			remotelocationsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(143);
		}
		return remotelocationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getREMOTELOCATIONS_RemoteLocations() {
        return (EReference)getREMOTELOCATIONS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteLocation() {
		if (remoteLocationEClass == null) {
			remoteLocationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(144);
		}
		return remoteLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteLocation_Value() {
        return (EAttribute)getRemoteLocation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteLocation_Language() {
        return (EAttribute)getRemoteLocation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREPRESENTATIONPDET() {
		if (representationpdetEClass == null) {
			representationpdetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(145);
		}
		return representationpdetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREPRESENTATIONREFERENCETYPE() {
		if (representationreferencetypeEClass == null) {
			representationreferencetypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(146);
		}
		return representationreferencetypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getREPRESENTATIONREFERENCETYPE_ClassRef() {
        return (EAttribute)getREPRESENTATIONREFERENCETYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSETTYPE() {
		if (settypeEClass == null) {
			settypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(147);
		}
		return settypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSETTYPE_ValueType() {
        return (EReference)getSETTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSETWITHSUBSETCONSTRAINTTYPE() {
		if (setwithsubsetconstrainttypeEClass == null) {
			setwithsubsetconstrainttypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(148);
		}
		return setwithsubsetconstrainttypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSETWITHSUBSETCONSTRAINTTYPE_ValueType() {
        return (EReference)getSETWITHSUBSETCONSTRAINTTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSHORTNAMELABEL() {
		if (shortnamelabelEClass == null) {
			shortnamelabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(149);
		}
		return shortnamelabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSHORTNAMELABEL_Value() {
        return (EAttribute)getSHORTNAMELABEL().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSHORTNAMELABEL_CountryCode() {
        return (EAttribute)getSHORTNAMELABEL().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSHORTNAMELABEL_LanguageCode() {
        return (EAttribute)getSHORTNAMELABEL().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSHORTNAME() {
		if (shortnameEClass == null) {
			shortnameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(150);
		}
		return shortnameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSHORTNAME_Labels() {
        return (EReference)getSHORTNAME().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIUNIT() {
		if (siunitEClass == null) {
			siunitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(153);
		}
		return siunitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIUNIT_Prefix() {
        return (EAttribute)getSIUNIT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIUNIT_Name() {
        return (EAttribute)getSIUNIT().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSOURCEDOCUMENT() {
		if (sourcedocumentEClass == null) {
			sourcedocumentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(154);
		}
		return sourcedocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTRINGDICVALUE() {
		if (stringdicvalueEClass == null) {
			stringdicvalueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(156);
		}
		return stringdicvalueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTRINGDICVALUE_ValueCode() {
        return (EAttribute)getSTRINGDICVALUE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTRINGPATTERNCONSTRAINT() {
		if (stringpatternconstraintEClass == null) {
			stringpatternconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(157);
		}
		return stringpatternconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTRINGPATTERNCONSTRAINT_Pattern() {
        return (EAttribute)getSTRINGPATTERNCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTRINGSIZECONSTRAINT() {
		if (stringsizeconstraintEClass == null) {
			stringsizeconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(158);
		}
		return stringsizeconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTRINGS() {
		if (stringsEClass == null) {
			stringsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(159);
		}
		return stringsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTRINGS_Values() {
        return (EAttribute)getSTRINGS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTRINGTYPE() {
		if (stringtypeEClass == null) {
			stringtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(160);
		}
		return stringtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTRINGTYPE_ValueFormat() {
        return (EAttribute)getSTRINGTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUBCLASSCONSTRAINT() {
		if (subclassconstraintEClass == null) {
			subclassconstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(161);
		}
		return subclassconstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSUBCLASSCONSTRAINT_Subclasses() {
        return (EReference)getSUBCLASSCONSTRAINT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUBSET() {
		if (subsetEClass == null) {
			subsetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(162);
		}
		return subsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUPPLIERREFERENCE() {
		if (supplierreferenceEClass == null) {
			supplierreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(163);
		}
		return supplierreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIERREFERENCE_SupplierRef() {
        return (EAttribute)getSUPPLIERREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUPPLIERSREFERENCE() {
		if (suppliersreferenceEClass == null) {
			suppliersreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(164);
		}
		return suppliersreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSUPPLIERSREFERENCE_Suppliers() {
        return (EReference)getSUPPLIERSREFERENCE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUPPLIER() {
		if (supplierEClass == null) {
			supplierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(165);
		}
		return supplierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_DateOfOriginalDefinition() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_DateOfCurrentVersion() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_DateOfCurrentRevision() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Revision() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Status() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_IsDeprecated() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_InternalLocation() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_StreetNumber() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Street() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_PostalBox() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Town() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Region() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_PostalCode() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Country() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_FacsimileNumber() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_TelephoneNumber() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_ElectronicMailAddress() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_TelexNumber() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSUPPLIER_Id() {
        return (EAttribute)getSUPPLIER().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSUPPLIER_IsDeprecatedInterpretation() {
        return (EReference)getSUPPLIER().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSUPPLIER_Org() {
        return (EReference)getSUPPLIER().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSUPPORTEDVEP() {
		if (supportedvepEClass == null) {
			supportedvepEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(166);
		}
		return supportedvepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSUPPORTEDVEP_ViewExchangeProtocolIdentifications() {
        return (EReference)getSUPPORTEDVEP().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSYNONYMOUSNAMELABEL() {
		if (synonymousnamelabelEClass == null) {
			synonymousnamelabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(167);
		}
		return synonymousnamelabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSYNONYMOUSNAMELABEL_Value() {
        return (EAttribute)getSYNONYMOUSNAMELABEL().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSYNONYMOUSNAMELABEL_CountryCode() {
        return (EAttribute)getSYNONYMOUSNAMELABEL().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSYNONYMOUSNAMELABEL_LanguageCode() {
        return (EAttribute)getSYNONYMOUSNAMELABEL().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSYNONYMOUSNAME() {
		if (synonymousnameEClass == null) {
			synonymousnameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(168);
		}
		return synonymousnameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSYNONYMOUSNAME_Labels() {
        return (EReference)getSYNONYMOUSNAME().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSYNONYMOUSSYMBOLS() {
		if (synonymoussymbolsEClass == null) {
			synonymoussymbolsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(169);
		}
		return synonymoussymbolsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSYNONYMOUSSYMBOLS_MathematicalStrings() {
        return (EReference)getSYNONYMOUSSYMBOLS().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEXT() {
		if (textEClass == null) {
			textEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(170);
		}
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEXT_Texts() {
        return (EReference)getTEXT().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTIMEDATATYPE() {
		if (timedatatypeEClass == null) {
			timedatatypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(171);
		}
		return timedatatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTIMEDATATYPE_ValueFormat() {
        return (EAttribute)getTIMEDATATYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRANSLATABLESTRINGTYPE() {
		if (translatablestringtypeEClass == null) {
			translatablestringtypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(172);
		}
		return translatablestringtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRANSLATABLESTRINGTYPE_ValueFormat() {
        return (EAttribute)getTRANSLATABLESTRINGTYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRANSLATIONDATA() {
		if (translationdataEClass == null) {
			translationdataEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(173);
		}
		return translationdataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRANSLATIONDATA_TranslationRevision() {
        return (EAttribute)getTRANSLATIONDATA().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRANSLATIONDATA_DateOfCurrentTranslationRevision() {
        return (EAttribute)getTRANSLATIONDATA().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRANSLATIONDATA_Language() {
        return (EReference)getTRANSLATIONDATA().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRANSLATIONDATA_ResponsibleTranslator() {
        return (EReference)getTRANSLATIONDATA().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRANSLATION() {
		if (translationEClass == null) {
			translationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(174);
		}
		return translationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRANSLATION_TranslationDatas() {
        return (EReference)getTRANSLATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUNIT() {
		if (unitEClass == null) {
			unitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(175);
		}
		return unitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURITYPE() {
		if (uritypeEClass == null) {
			uritypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(176);
		}
		return uritypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURITYPE_ValueFormat() {
        return (EAttribute)getURITYPE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVCVRANGE() {
		if (vcvrangeEClass == null) {
			vcvrangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(177);
		}
		return vcvrangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVCVRANGE_ViewControlVariableRanges() {
        return (EReference)getVCVRANGE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVIEWCONTROLVARIABLERANGE() {
		if (viewcontrolvariablerangeEClass == null) {
			viewcontrolvariablerangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(178);
		}
		return viewcontrolvariablerangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVIEWCONTROLVARIABLERANGE_ParameterType() {
        return (EReference)getVIEWCONTROLVARIABLERANGE().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVIEWEXCHANGEPROTOCOLIDENTIFICATION() {
		if (viewexchangeprotocolidentificationEClass == null) {
			viewexchangeprotocolidentificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(179);
		}
		return viewexchangeprotocolidentificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVIEWEXCHANGEPROTOCOLIDENTIFICATION_SourceDocumentIdentifier() {
        return (EAttribute)getVIEWEXCHANGEPROTOCOLIDENTIFICATION().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVIEWEXCHANGEPROTOCOLIDENTIFICATION_Status() {
        return (EAttribute)getVIEWEXCHANGEPROTOCOLIDENTIFICATION().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVIEWEXCHANGEPROTOCOLIDENTIFICATION_Name() {
        return (EAttribute)getVIEWEXCHANGEPROTOCOLIDENTIFICATION().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVIEWEXCHANGEPROTOCOLIDENTIFICATION_Application() {
        return (EAttribute)getVIEWEXCHANGEPROTOCOLIDENTIFICATION().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVIEWEXCHANGEPROTOCOLIDENTIFICATION_Level() {
        return (EAttribute)getVIEWEXCHANGEPROTOCOLIDENTIFICATION().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getILLUSTRATIONTYPEType() {
		if (illustrationtypeTypeEEnum == null) {
			illustrationtypeTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(87);
		}
		return illustrationtypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIPREFIXType() {
		if (siprefixTypeEEnum == null) {
			siprefixTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(151);
		}
		return siprefixTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIUNITNAMEType() {
		if (siunitnameTypeEEnum == null) {
			siunitnameTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(152);
		}
		return siunitnameTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSTANDARDSIZEType() {
		if (standardsizeTypeEEnum == null) {
			standardsizeTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI).getEClassifiers().get(155);
		}
		return standardsizeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedFactory getIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedFactory() {
		return (Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("isostdisois_13584_32ed_1techxmlschemaontomlSimplified." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl
