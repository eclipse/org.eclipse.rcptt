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
package org.eclipse.rcptt.ui.editors.verification;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
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
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.WorkbenchPart;

import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.CompositeNamedElementActions;
import org.eclipse.rcptt.ui.editors.IQ7Viewer2;
import org.eclipse.rcptt.ui.editors.NamedElementEditor;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.rcptt.ui.verification.VerificationUIManager;
import org.eclipse.rcptt.ui.verification.VerificationViewer;

public class VerificationEditor extends NamedElementEditor implements IGotoMarker {

	private VerificationEditorPage page;
	private IEditorPart part;
	private VerificationType type;
	private INamedElementActions verificationActions;

	public Verification getElement() {
		return (Verification) super.getElement();
	}

	@Override
	protected void addPages() {
		VerificationViewer viewer = VerificationUIManager.getInstance()
				.getViewer(type);
		if (viewer != null && viewer.getViewer() instanceof IQ7Viewer2<?>) {
			IQ7Viewer2<Verification> v2 = (IQ7Viewer2<Verification>) viewer
					.getViewer();
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
			page = new VerificationEditorPage(this);
			addPage(page);
		} catch (PartInitException e) {
			Q7UIPlugin.log(e);
		}
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
			type = VerificationTypeManager.getInstance().getTypeByVerification(
					(Verification) iq7Element.getNamedElement());
			if (type == null) {
				throw new PartInitException(Messages.bind(
						Messages.VerificationEditor_EmptyVerificationType,
						getElement()));
			}
			VerificationViewer viewer = VerificationUIManager.getInstance()
					.getViewer(type);
			if (viewer != null && viewer.getViewer() instanceof IQ7Viewer2<?>) {
				IQ7Viewer2<Verification> v2 = (IQ7Viewer2<Verification>) viewer
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

	public void createActions() {
		CompositeNamedElementActions compositeActions = new CompositeNamedElementActions(page.getContent(),
				verificationActions) {
			@Override
			public void update() {
				updateEnablement();
			}
		};
		actions = new NamedElementEditorActions(
				compositeActions, getEditorSite()
						.getActionBars());
	}

	public IEditorPart getEditor() {
		return part;
	}

	public void setVerificationActions(INamedElementActions actions) {
		this.verificationActions = actions;
		createActions();
	}

	@Override
	public void gotoMarker(IMarker marker) {
		IGotoMarker adapter = (IGotoMarker) page.getAdapter(IGotoMarker.class);
		if (adapter != null)
			adapter.gotoMarker(marker);
	}
}
