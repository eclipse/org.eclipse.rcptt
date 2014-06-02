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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;

import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;

public class TestSuiteEditor extends NamedElementEditor {

	TestSuiteEditorPage page;

	@Override
	public ITestSuite getModel() {
		return (ITestSuite) super.getModel();
	}

	@Override
	public TestSuite getElement() {
		return (TestSuite) super.getElement();
	}

	@Override
	protected void addPages() {
		try {
			page = new TestSuiteEditorPage(this);
			addPage(page);
		} catch (PartInitException e) {
			Q7UIPlugin.log(e);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		page.updateContent();
		super.doSave(monitor);
	}

	@Override
	protected void createPages() {
		super.createPages();
		if (getPageCount() < 2) {
			hideTabs();
		}
	}

	@Override
	protected void afterMissingReferencesAdded() {
		page.refreshPage();
	}

	@Override
	public void createActions() {
		actions = new NamedElementEditorActions(new INamedElementActions() {

			@Override
			public void undo() {
				page.getContent().undo();
				updateEnablement();
			}

			@Override
			public void redo() {
				page.getContent().redo();
				updateEnablement();
			}

			@Override
			public void paste() {
				if (page.getContent().isInFocus()) {
					page.getContent().paste();
				}
				else {
					page.getTestCasesviewer().paste();
				}
				updateEnablement();
			}

			@Override
			public void cut() {
				if (page.getContent().isInFocus()) {
					page.getContent().cut();
				}
				else {
					page.getTestCasesviewer().cut();
				}
				updateEnablement();
			}

			@Override
			public void copy() {
				if (page.getContent().isInFocus()) {
					page.getContent().copy();
				}
				else if (page.getTestCasesviewer().getControl().isFocusControl()) {
					page.getTestCasesviewer().copy();
				}
				updateEnablement();
			}

			@Override
			public boolean canUndo() {
				return page.getContent().canUndo();
			}

			@Override
			public boolean canRedo() {
				return page.getContent().canRedo();
			}

			@Override
			public boolean canPaste() {
				return page.getContent().canPaste() || page.getTestCasesviewer().canPaste();
			}

			@Override
			public boolean canCut() {
				return page.getContent().canCut() || page.getTestCasesviewer().canCut();
			}

			@Override
			public boolean canCopy() {
				return page.getContent().canCopy() || page.getTestCasesviewer().canCopy();
			}
		}, getEditorSite().getActionBars());
		actions.activate();
	}
}
