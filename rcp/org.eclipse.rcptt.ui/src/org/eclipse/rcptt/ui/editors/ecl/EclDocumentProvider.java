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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Scenario;

@SuppressWarnings("restriction")
public class EclDocumentProvider extends AbstractDocumentProvider {
	private WorkspaceOperationRunner fOperationRunner;

	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		if (element instanceof EclEditorInput) {
			String scriptContent = getScriptContent((EclEditorInput) element);
			Document document = new Document(scriptContent);
			return document;
		}
		return null;
	}

	protected String getScriptContent(EclEditorInput element)
			throws ModelException {
		if (element.getElement() instanceof ITestCase) {
			ITestCase scenario = (ITestCase) element.getElement();
			String scriptContent = Scenarios
					.getScriptContent((Scenario) scenario.getNamedElement());
			return scriptContent;
		}
		return "";
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element)
			throws CoreException {
		if (element instanceof EclEditorInput) {
			return new ResourceMarkerAnnotationModel(((EclEditorInput) element)
					.getElement().getResource());
		}
		return null;
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element,
			IDocument document, boolean overwrite) throws CoreException {

	}

	@Override
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		if (fOperationRunner == null)
			fOperationRunner = new WorkspaceOperationRunner();
		fOperationRunner.setProgressMonitor(monitor);
		return fOperationRunner;
	}

	@Override
	public boolean isModifiable(Object element) {
		return true;
	}

	@Override
	public boolean isReadOnly(Object element) {
		return false;
	}

	@Override
	public IContentType getContentType(Object element) throws CoreException {
		IContentType contentType = null;
		if (!canSaveDocument(element) && element instanceof EclEditorInput)
			contentType = getContentType(((EclEditorInput) element)
					.getElement().getResource());

		if (contentType == null)
			contentType = super.getContentType(element);

		if (contentType == null && element instanceof EclEditorInput)
			contentType = getContentType(((EclEditorInput) element)
					.getElement().getResource());

		return contentType;
	}

	public boolean isSynchronized(Object element) {
		if (element instanceof EclEditorInput) {
			if (getElementInfo(element) != null) {
				IFileEditorInput input = (EclEditorInput) element;
				IResource resource = input.getFile();
				return resource.isSynchronized(IResource.DEPTH_ZERO);
			}
			return false;
		}
		return super.isSynchronized(element);
	}
}
