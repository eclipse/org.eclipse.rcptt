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
package org.eclipse.rcptt.core.ecl.context.editor;

import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Script;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.ecl.context.EclContext;
import org.eclipse.rcptt.core.ecl.context.internal.viewer.EclContextViewer;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.editors.EditorContent;
import org.eclipse.rcptt.ui.editors.EditorHeader;
import org.eclipse.rcptt.ui.editors.ecl.EclDocumentProvider;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclEditorInput;

public class EclContextEditor extends EclEditor {
	public EclContextEditor() {
		setTitleImage(EclContextViewer.getEclContextImage().createImage());
	}

	@Override
	protected String getEclContext(NamedElement element) {
		if (element instanceof EclContext) {
			Script script = ((EclContext) element).getScript();
			if (script != null) {
				return script.getContent();
			}
		}
		return "";
	}

	@Override
	protected void setEclContext(NamedElement element, String value) {
		if (element instanceof EclContext) {
			Script sc = CoreFactory.eINSTANCE.createScript();
			sc.setContent(value);
			((EclContext) element).setScript(sc);
		}
	}

	@Override
	protected void checkReferences() {
		// do nothing
	}

	protected EditorHeader createEditorHeader() {
		return new EditorHeader(getModel(), getElement()) {

			protected Button createRecordButton(Composite composite,
					FormToolkit toolkit) {
				Button button = toolkit.createButton(composite,
						Messages.ContextEditorPage_CaptureButtonText, SWT.PUSH);
				button.setImage(Images.getImageDescriptor(Images.SNAPSHOT)
						.createImage());
				button.setBackground(null);
				GridDataFactory.fillDefaults().applyTo(button);
				button.setEnabled(false);
				return button;
			}

			protected Button createReplayButton(Composite composite,
					FormToolkit toolkit) {
				Button button = toolkit.createButton(composite,
						Messages.ContextEditorPage_ApplyButtonText, SWT.PUSH);
				button.setImage(DebugUITools.getImageDescriptor(
						IDebugUIConstants.IMG_ACT_RUN).createImage());
				button.setBackground(null);
				GridDataFactory.fillDefaults().applyTo(button);
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						if ((e.stateMask & SWT.SHIFT) != 0)
							multiReplay();
						else
							replay();
					}
				});
				return button;
			}

			@Override
			protected void record() {
				// TODO Auto-generated method stub

			}
		};
	}

	protected EditorContent createEditorContent() {
		return new EditorContent(header, false, true);
	}

	@Override
	protected EclDocumentProvider createDocumentProvider() {
		return new EclDocumentProvider() {
			@Override
			protected String getScriptContent(EclEditorInput element)
					throws ModelException {
				if (element.getElement() instanceof IContext) {
					IContext eclContext = (IContext) element.getElement();
					return getEclContext(eclContext.getNamedElement());
				}
				return "";
			}
		};
	}
}
