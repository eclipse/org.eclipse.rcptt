package org.eclipse.rcptt.testing;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.runtime.SingleCommandService;
import org.eclipse.rcptt.launching.injection.InjectionFactory;
import org.eclipse.rcptt.launching.injection.UpdateSite;
import org.eclipse.rcptt.testing.commands.SiteInjection;

public class SiteInjectionService extends SingleCommandService<SiteInjection> {

	public SiteInjectionService() {
		super(SiteInjection.class);
	}

	@Override
	protected Object serviceTyped(SiteInjection command) throws InterruptedException, CoreException {
		final UpdateSite rv = InjectionFactory.eINSTANCE.createUpdateSite();
		rv.setUri(command.getUri());
		if (!command.getUnit().isEmpty()) {
			rv.setAllUnits(false);
			rv.getUnits().addAll(command.getUnit());
		} else {
			rv.setAllUnits(true);
		}

		return rv;
	}

}
