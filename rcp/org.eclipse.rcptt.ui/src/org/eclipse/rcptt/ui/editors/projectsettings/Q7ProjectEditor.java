/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.editors.projectsettings;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.ProjectMetadata;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.NamedElementEditor;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

public class Q7ProjectEditor extends NamedElementEditor {

	Q7ProjectEditorPage page;

	@Override
	public IQ7ProjectMetadata getModel() {
		return (IQ7ProjectMetadata) super.getModel();
	}

	@Override
	public ProjectMetadata getElement() {
		return (ProjectMetadata) super.getElement();
	}

	@Override
	protected void updateElement() throws ModelException, PartInitException {
		super.updateElement();
		updateEditorTitle();
	}

	protected void updateEditorTitle() {
		setPartName(getModel().getQ7Project().getName() + " - Project Settings");
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		updateEditorTitle();
	}

	@Override
	protected void addPages() {
		try {
			page = new Q7ProjectEditorPage(this);
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
	public void createActions() {
		actions = new NamedElementEditorActions(new INamedElementActions() {

			private boolean isContextsFocus() {
				return page.getContextTable().getControl().isFocusControl();
			}

			private boolean isVerificationFocus() {
				return page.getVerificationsTable().getControl().isFocusControl();
			}

			private boolean isDescriptionFocus() {
				return page.getDescriptionComposite().getDescriptionControl().isFocusControl();
			}

			@Override
			public void undo() {
				if (isDescriptionFocus()) {
					page.getDescriptionComposite().getActions().undo();
				}
				updateEnablement();
			}

			@Override
			public void redo() {
				if (isDescriptionFocus()) {
					page.getDescriptionComposite().getActions().redo();
				}
				updateEnablement();
			}

			@Override
			public void paste() {
				if (isContextsFocus()) {
					page.getContextTable().paste();
				} else if (isVerificationFocus()) {
					page.getVerificationsTable().paste();
				} else if (isDescriptionFocus()) {
					page.getDescriptionComposite().getActions().paste();
				}
				updateEnablement();
			}

			@Override
			public void cut() {
				if (isContextsFocus()) {
					page.getContextTable().cut();
				} else if (isVerificationFocus()) {
					page.getVerificationsTable().cut();
				} else if (isDescriptionFocus()) {
					page.getDescriptionComposite().getActions().cut();
				}
				updateEnablement();
			}

			@Override
			public void copy() {
				if (isContextsFocus()) {
					page.getContextTable().copy();
				} else if (isVerificationFocus()) {
					page.getVerificationsTable().copy();
				} else if (isDescriptionFocus()) {
					page.getDescriptionComposite().getActions().copy();
				}
				updateEnablement();
			}

			@Override
			public boolean canUndo() {
				if (isDescriptionFocus()) {
					return page.getDescriptionComposite().getActions().canUndo();
				}
				return false;
			}

			@Override
			public boolean canRedo() {
				if (isDescriptionFocus()) {
					return page.getDescriptionComposite().getActions().canRedo();
				}
				return false;
			}

			@Override
			public boolean canPaste() {
				if (isContextsFocus()) {
					return page.getContextTable().canPaste();
				}
				if (isVerificationFocus()) {
					return page.getVerificationsTable().canPaste();
				}
				if (isDescriptionFocus()) {
					return page.getDescriptionComposite().getActions().canPaste();
				}
				return false;
			}

			@Override
			public boolean canCut() {
				if (isContextsFocus()) {
					return page.getContextTable().canCut();
				}
				if (isVerificationFocus()) {
					return page.getVerificationsTable().canCut();
				}
				if (isDescriptionFocus()) {
					return page.getDescriptionComposite().getActions().canCut();
				}
				return false;
			}

			@Override
			public boolean canCopy() {
				if (isContextsFocus()) {
					return page.getContextTable().canCopy();
				}
				if (isVerificationFocus()) {
					return page.getVerificationsTable().canCopy();
				}
				if (isDescriptionFocus()) {
					return page.getDescriptionComposite().getActions().canCopy();
				}
				return false;
			}
		}, getEditorSite().getActionBars());
	}

	@Override
	protected void afterMissingReferencesAdded() {
		page.refreshPage();
	}

}
