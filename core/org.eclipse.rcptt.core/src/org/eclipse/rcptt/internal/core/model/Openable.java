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
package org.eclipse.rcptt.internal.core.model;

import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;

import org.eclipse.rcptt.core.model.IOpenable;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.ModelException;

public abstract class Openable extends Q7Element implements IOpenable {

	protected Openable(Q7Element parent) throws IllegalArgumentException {
		super(parent);
	}

	public boolean canBeRemovedFromCache() {
		return true;
	}

	protected abstract boolean buildStructure(OpenableElementInfo info,
			IProgressMonitor pm, Map<IQ7Element, Object> newElements,
			IResource underlyingResource) throws ModelException;

	protected void openParent(Object childInfo,
			Map<IQ7Element, Object> newElements, IProgressMonitor pm)
			throws ModelException {

		Openable openableParent = (Openable) getOpenableParent();
		if (openableParent != null && !openableParent.isOpen()) {
			openableParent.generateInfos(openableParent.createElementInfo(),
					newElements, pm);
		}
	}

	protected boolean parentExists() {
		IQ7Element parentElement = getParent();
		if (parentElement == null)
			return true;
		return parentElement.exists();
	}

	public void open(IProgressMonitor pm) throws ModelException {
		getElementInfo(pm);
	}

	protected void generateInfos(Object info,
			Map<IQ7Element, Object> newElements, IProgressMonitor monitor)
			throws ModelException {
		// open the parent if necessary
		openParent(info, newElements, monitor);
		if (monitor != null && monitor.isCanceled())
			throw new OperationCanceledException();

		newElements.put(this, info);

		// build the structure of the openable (this will open the buffer if
		// needed)
		try {
			OpenableElementInfo openableElementInfo = (OpenableElementInfo) info;
			boolean isStructureKnown = buildStructure(openableElementInfo,
					monitor, newElements, getResource());
			openableElementInfo.setIsStructureKnown(isStructureKnown);
		} catch (ModelException e) {
			newElements.remove(this);
			throw e;
		}
	}

	protected void closing(Object info) throws ModelException {
	}

	public boolean isOpen() {
		return ModelManager.getModelManager().getInfo(this) != null;
	}

	protected boolean resourceExists() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace == null)
			return false;
		return Q7Model.getTarget(workspace.getRoot(), this.getPath()
				.makeRelative(), true) != null;
	}
	public boolean isStructureKnown() throws ModelException {
		return ((OpenableElementInfo) getElementInfo()).isStructureKnown();
	}
	@Override
	public IOpenable getOpenable() {
		return this;
	}
}
