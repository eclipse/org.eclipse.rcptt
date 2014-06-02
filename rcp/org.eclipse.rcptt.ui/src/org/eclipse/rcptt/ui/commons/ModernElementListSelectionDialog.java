/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.commons;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredList;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class ModernElementListSelectionDialog extends
		ElementListSelectionDialog {

	private SearchControl searchCtrl;
	private Label fMessage;

	public ModernElementListSelectionDialog(Shell parent,
			ILabelProvider renderer) {
		super(parent, renderer);
	}

	@Override
	protected Label createMessageArea(Composite composite) {
		Label msg = super.createMessageArea(composite);
		fMessage = msg;
		return msg;
	}

	@Override
	protected void setListElements(Object[] elements) {
		super.setListElements(elements);
		if (elements == null || elements.length == 0) {
			handleEmptyList();
		} else {
			handleNonemptyList();
		}
	}

	@Override
	protected void handleEmptyList() {
		super.handleEmptyList();
		searchCtrl.setEnabled(false);
	}

	protected void handleNonemptyList() {
		fMessage.setEnabled(true);
		searchCtrl.setEnabled(true);
		fFilteredList.setEnabled(true);
		updateOkState();
	}

	protected org.eclipse.swt.widgets.Text createFilterText(Composite parent) {
		Text text = super.createFilterText(parent.getShell());
		text.setVisible(false);
		GridDataFactory.fillDefaults().hint(0, 0).applyTo(text);

		Composite cp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(0, 0)
				.numColumns(1).applyTo(cp);
		GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(cp);

		searchCtrl = new SearchControl(cp) {
			@Override
			public void onCR() {
				Object[] elements = getSelectedElements();
				if( elements.length > 0) {
					buttonPressed(OK);
				}
			}
		};

		searchCtrl.setFilterText((getFilter() == null ? "" : getFilter())); //$NON-NLS-1$

		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				if (fFilteredList != null) {
					String value = searchCtrl.getFilterString();
					if (!searchCtrl.getInitialText().equals(value)) {
						// Check if name are context identifier
						boolean skipNormal = false;
						IQ7NamedElement[] elements = Q7SearchCore.findById(value,
								new AllProjectScope(),
								new NullProgressMonitor());
						if (elements.length > 0) {
							skipNormal = true;
							try {
								fFilteredList.setFilter(elements[0]
										.getElementName());
							} catch (Throwable e2) {
								Q7UIPlugin.log(e2);
								skipNormal = false;
							}
						}

						// IProject[] p = Q7Core.getQ7Projects();
						// boolean skipNormal = false;
						// for (IProject iProject : p) {
						// Context context = Q7Core.getGroup(iProject)
						// .findContext(value);
						// if (context != null) {
						// //
						// searchCtrl.setFilterText(context.getName().trim());
						// fFilteredList.setFilter(context.getName()
						// .trim());
						// skipNormal = true;
						// break;
						// }
						// }
						if (!skipNormal) {
							fFilteredList.setFilter(value);
						}
					}
				}
			}
		};
		searchCtrl.getFilterControl().addListener(SWT.Modify, listener);

		return searchCtrl.getFilterControl();
	};

	@Override
	protected FilteredList createFilteredList(Composite parent) {
		super.createFilteredList(parent);
		searchCtrl.setSearchResultControl(fFilteredList);
		return fFilteredList;
	}
}
