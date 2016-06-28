package org.eclipse.rcptt.ctx.capability.ui.views;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

public class OpenContextEditorHelper {

	public void open(IStructuredSelection selection, IQ7Project project) {
		if (selection.isEmpty()) {
			return;
		}
		for (Object element : selection.toArray()) {
			String elementId = (String) element;
			openSingleContext(elementId, project);
		}
	}

	public void openSingleContext(String contextId, IQ7Project project) {
		IQ7NamedElement element = getContentsElementById(contextId, project);
		if (element != null) {
			try {
				IDE.openEditor(WorkbenchUtils.getPage(), (IFile) element.getResource());
			} catch (PartInitException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	private static IQ7NamedElement getContentsElementById(String elementId, IQ7Project contentProject) {
		ISearchScope scope = new ReferencedProjectScope(contentProject);
		if (contentProject == null) {
			scope = new AllProjectScope();
		}
		IQ7NamedElement[] elts = Q7SearchCore.findById(elementId, scope, new NullProgressMonitor());
		if (elts != null && elts.length > 0) {
			return elts[0];
		}
		return null;
	}
}
