package org.eclipse.rcptt.ctx.capability.ui.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.CapabilityContext;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.SuperContext;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public class ConvertContextTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		ISelection selection = new StructuredSelection(receiver);
		IResource[] resources = LaunchUtils.getContext(selection);

		if (resources == null || resources.length != 1)
			return false;

		final IResource res = resources[0];
		if (!RcpttCore.hasRcpttNature(res.getProject())) {
			return false;
		}

		if (!RcpttCore.isQ7Context(res.getFullPath())) {
			return false;
		}

		IQ7Project project = RcpttCore.create(res.getProject());
		IPath path = res.getFullPath().removeFirstSegments(1);
		IQ7Folder folder = project.getFolder(path.removeLastSegments(1));
		IContext context = folder.getContext(res.getName());
		NamedElement ctx;
		try {
			ctx = context.getNamedElement();
		} catch (ModelException e) {
			ctx = null;
		}
		if (ctx == null || ctx instanceof SuperContext || ctx instanceof GroupContext
				|| ctx instanceof CapabilityContext) {
			return false;
		}
		return true;
	}

}
