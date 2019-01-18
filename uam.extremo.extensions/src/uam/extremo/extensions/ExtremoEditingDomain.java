package uam.extremo.extensions;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;

public class ExtremoEditingDomain extends TransactionalEditingDomainImpl.FactoryImpl{
	@Override
	public TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain result = super.createEditingDomain();
		result.setID("uam.extremo.ExtremoEditingDomain");
		return result;
	}
}
