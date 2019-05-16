package comparator.exact.emfcompare;

import java.io.File;
import java.io.IOException;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.IdentifierEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import com.google.common.base.Function;
import comparator.MMComparator;

public abstract class MMComparatorEMFCompare extends MMComparator{
	private Comparison comp;
	
	public MMComparatorEMFCompare() throws IOException {
		super();
	}
	
	Function<EObject, String> idFunction = new Function<EObject, String>() {
		public String apply(EObject input) {
			if(input instanceof ENamedElement){
				return ((ENamedElement) input).getName();
			}
			return null;
		}
	};
	
	IDiffProcessor diffProcessor = new DiffBuilder() {
		@Override
		public void attributeChange(Match match, EAttribute attribute, Object value, DifferenceKind kind, DifferenceSource source) {
			if (attribute != EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE && attribute != EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL) {
				super.attributeChange(match, attribute, value, kind, source);
			}
		}
	};
	
	IDiffEngine diffEngine = new DefaultDiffEngine(diffProcessor) {
		@Override
		protected FeatureFilter createFeatureFilter() {
			return new FeatureFilter() {
				@Override
				protected boolean isIgnoredReference(Match match, EReference reference) {
					if(
							reference == EcorePackage.Literals.EPACKAGE || 
							reference == EcorePackage.Literals.ECLASS__EOPERATIONS || 
							reference == EcorePackage.Literals.EOPERATION__EEXCEPTIONS ||
							reference == EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE || 
							reference == EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL
					){
						return true;
					}
					else return super.isIgnoredReference(match, reference);
				}
				
				@Override
				public boolean checkForOrderingChanges(EStructuralFeature feature) {
					return false;
				}
			};
		}
		
		@Override
		protected void computeSingleValuedAttributeDifferences(Match match, EAttribute attribute) {}
		@Override
		protected void computeMultiValuedFeatureDifferencesTwoWay(Match match, EStructuralFeature feature, boolean checkOrdering) {};
		@Override
		protected void computeSingleValuedReferenceDifferencesTwoWay(Match match, EReference reference) {};
		@Override
		protected void computeContainmentDifferencesTwoWay(Match match, EReference reference, boolean checkOrdering) {};
	};
	
	@Override
	protected void compare(File file1, File file2) {
		Resource ecore1 = this.loadModel(file1, null);
		Resource ecore2 = this.loadModel(file2, null);
		
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, idFunction);
		
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(50);
		registry.add(matchEngineFactory);
		
		IComparisonScope scope = new DefaultComparisonScope(ecore1, ecore2, null);
		setComparison(EMFCompare.builder().setMatchEngineFactoryRegistry(registry).setDiffEngine(diffEngine).build().compare(scope));
	}
	
	public Comparison getComparison() {
		return comp;
	}

	public void setComparison(Comparison comp) {
		this.comp = comp;
	}
}