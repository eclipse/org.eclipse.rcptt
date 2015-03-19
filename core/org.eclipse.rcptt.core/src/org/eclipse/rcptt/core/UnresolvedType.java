package org.eclipse.rcptt.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

enum UnresolvedType implements VerificationType {
	INSTANCE;
	@Override
	public IStatus validate(Verification verification) {
		return new Status(IStatus.ERROR, RcpttPlugin.PLUGIN_ID, "Unresolved verification");
	}

	@Override
	public boolean supportsWidget(String class_) {
		return false;
	}

	@Override
	public boolean supportsPhase(String name) {
		return true; // To fail tests with unresolved verification
	}

	@Override
	public String[] getWidgets() {
		return new String[0];
	}

	@Override
	public String getPrompt() {
		return "";
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public String[] getPhases() {
		return new String[0];
	}

	@Override
	public String getName() {
		return "Unresolved Verification";
	}

	@Override
	public IVerificationMaker getMaker() {
		throw new UnsupportedOperationException("This verification is unresolved.");
	}

	@Override
	public String getId() {
		throw new UnsupportedOperationException("This verification is unresolved.");
	}

	@Override
	public EClass getEClass() {
		throw new UnsupportedOperationException("This verification is unresolved.");
	}

	@Override
	public String getDescription() {
		return "This is a reference to verification that was not resolved. Target verification was deleted, or is located in a closed project.";
	}

	@Override
	public Verification create(Resource resource, String name) {
		throw new UnsupportedOperationException("This verification is unresolved.");
	}

	@Override
	public boolean canMake() {
		return false;
	}

	@Override
	public boolean canCreate() {
		return false;
	}
}