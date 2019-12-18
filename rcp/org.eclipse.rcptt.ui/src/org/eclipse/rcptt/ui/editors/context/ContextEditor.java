/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.editors.context;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.WorkbenchPart;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.context.ContextUIManager;
import org.eclipse.rcptt.ui.context.ContextViewer;
import org.eclipse.rcptt.ui.editors.CompositeNamedElementActions;
import org.eclipse.rcptt.ui.editors.IQ7Viewer2;
import org.eclipse.rcptt.ui.editors.NamedElementEditor;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class ContextEditor extends NamedElementEditor {

	private ContextEditorPage page;
	private IEditorPart part;
	private ContextType type;
	INamedElementActions ctxActions;

	public void setSelectionAtLine(int line) {
		if (page != null) {
			page.setSelectionAtLine(line);
		}
	}

	public Context getElement() {
		return (Context) super.getElement();
	}

	@Override
	protected void addPages() {
		ContextViewer viewer = ContextUIManager.getInstance().getViewer(type);
		if (viewer != null && viewer.getViewer() instanceof IQ7Viewer2<?>) {
			IQ7Viewer2<Context> v2 = (IQ7Viewer2<Context>) viewer.getViewer();
			part = v2.createEditorPart();
			part.addPropertyListener(new IPropertyListener() {
				public void propertyChanged(Object source, int propId) {
					if (IWorkbenchPartConstants.PROP_PART_NAME == propId) {
						setPartName(((WorkbenchPart) part).getPartName());
					}
				}
			});
			try {
				addPage(part, getEditorInput());
				setTitleImage(viewer.getIcon().createImage());
				setPartName(part.getTitle());
			} catch (PartInitException e) {
				Q7UIPlugin.log(e);
			}
			return;
		}

		try {
			page = new ContextEditorPage(this);
			addPage(page);
		} catch (PartInitException e) {
			Q7UIPlugin.log(e);
		}
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (part instanceof EclEditor) {
			return part.getAdapter(adapter);
		}
		return super.getAdapter(adapter);
	}

	@Override
	public void setFocus() {
		super.setFocus();
		if (page != null) {
			page.setFocus();
		}
		if (part != null) {
			part.setFocus();
		}
	}

	protected IFile getInputFile(IEditorInput input) {
		if (input instanceof IFileEditorInput) {
			return ((IFileEditorInput) input).getFile();
		}
		return null;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		try {
			IFile inputFile = getInputFile(input);
			if (inputFile == null) {
				throw new PartInitException(
						Messages.NamedElementEditor_InvalidInputType);
			}
			IQ7NamedElement iq7Element = (IQ7NamedElement) RcpttCore
					.create(inputFile);
			type = ContextTypeManager.getInstance().getTypeByContext(
					(Context) iq7Element.getNamedElement());
			if (type == null) {
				throw new PartInitException(Messages.bind(
						Messages.ContextEditor_EmptyContextType, getElement()));
			}
			ContextViewer viewer = ContextUIManager.getInstance().getViewer(
					type);
			if (viewer != null && viewer.getViewer() instanceof IQ7Viewer2<?>) {
				IQ7Viewer2<Context> v2 = (IQ7Viewer2<Context>) viewer
						.getViewer();
				setEnableResourceTracking(v2.isEnableResourceTracking());
			}

		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		super.init(site, input);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			if (page != null) {
				page.save();
			}
			if (part != null) {
				part.doSave(monitor);
			} else {
				super.doSave(monitor);
			}
			assert !isDirty();
		} catch (CoreException e) {
			Q7UIPlugin.log(e);
		}
	}

	public void setEditorImage(Image img) {
		setTitleImage(img);
	}

	@Override
	protected void createPages() {
		super.createPages();
		hideTabs();
	}
	@Override
	public void createActions() {
		CompositeNamedElementActions compositeActions = new CompositeNamedElementActions(page.getContent(), ctxActions) {
			@Override
			public void update() {
				updateEnablement();
			}
		};
		actions = new NamedElementEditorActions(compositeActions, getEditorSite()
				.getActionBars());
	}

	public IEditorPart getEditor() {
		return part;
	}

	public void setCtxActions(INamedElementActions createActions) {
		ctxActions = createActions;
	}
}
