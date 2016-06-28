package org.eclipse.rcptt.ctx.capability.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IElementChangedListener;
import org.eclipse.rcptt.core.model.IQ7ElementDelta;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.Q7ElementChangedEvent;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.internal.core.model.Q7TestCase;

class WorkspaceChangeListener implements IElementChangedListener {

	private final CapabiltyContextTable table;

	public WorkspaceChangeListener(CapabiltyContextTable table) {
		this.table = table;
	}

	public void elementChanged(Q7ElementChangedEvent event) {
		IQ7ElementDelta delta = event.getDelta();
		IQ7NamedElement newContent = findRenamed(delta, table.getNamedElement());
		if (newContent != null)
			table.setNamedElement(newContent);

		IQ7ElementDelta[] elementDeltas = event.getDelta()
				.getAffectedChildren();
		for (IQ7ElementDelta iq7ElementDelta : elementDeltas) {
			if (iq7ElementDelta.getElement() instanceof IQ7Project) {
				if ((iq7ElementDelta.getFlags() & IQ7ElementDelta.F_DESCRIPTION) != 0) {
					refreshTable(null);
					return;
				}
			}
		}
		IQ7NamedElement[] elements = event.getDelta().getNamedElements();
		refreshTable(elements);
	}

	private void refreshTable(IQ7NamedElement[] elements) {
		if (table.getTableViewer() == null || table.getControl() == null
				|| table.getControl().isDisposed()) {
			return;
		}
		boolean needRefresh = false;
		if (elements == null) {
			// It might mean that .project file was changed and some
			// dependencies was added/removed
			needRefresh = true;
		} else {
			IQ7NamedElement testCase = table.getNamedElement();
			String[] contexts = null;
			if (contexts == null && testCase instanceof ITestCase) {
				try {
					contexts = ((ITestCase) testCase).getContexts();
				} catch (ModelException e) {
					needRefresh = true;
				}
			}
			if (contexts == null && testCase instanceof IQ7ProjectMetadata) {
				try {
					contexts = ((IQ7ProjectMetadata) testCase)
							.getContexts();
				} catch (ModelException e) {
					needRefresh = true;
				}
			}
			try {
				if (contexts == null
						&& testCase instanceof IContext
						&& testCase.getNamedElement() instanceof GroupContext) {
					EList<String> list = ((GroupContext) table.getNamedElement().getNamedElement())
							.getContextReferences();
					if (list != null) {
						contexts = list.toArray(new String[list
								.size()]);
					}
				}
			} catch (Exception e) {
				// Ignore
				needRefresh = true;
			}
			List<String> lc = new ArrayList<String>();
			if (contexts != null) {
				lc.addAll(Arrays.asList(contexts));
			}
			for (IQ7NamedElement element : elements) {
				try {
					String elementID = Q7SearchCore
							.findIDByDocument(element);
					if (elementID == null) {
						elementID = element.getID();
					}
					needRefresh = lc.contains(elementID);
					if (needRefresh) {
						break;
					}
				} catch (ModelException e) {
					// Q7UIPlugin.log(e);
					needRefresh = true;
				}
			}
		}
		if (needRefresh) {
			table.refresh();
		}
	}

	private IQ7NamedElement findRenamed(IQ7ElementDelta delta,
			IQ7NamedElement element) {
		if (delta.getElement() instanceof ITestCase) {
			ITestCase test = (Q7TestCase) delta.getElement();
			if ((delta.getFlags() & IQ7ElementDelta.F_MOVED_FROM) != 0) {
				if (delta.getMovedFromElement().getPath()
						.equals(element.getPath())) {
					return test;
				}
			}
		}

		IQ7ElementDelta[] deltas = delta.getAffectedChildren();
		for (IQ7ElementDelta d : deltas) {
			IQ7NamedElement result = findRenamed(d, element);
			if (result != null)
				return result;
		}

		return null;
	}
}
