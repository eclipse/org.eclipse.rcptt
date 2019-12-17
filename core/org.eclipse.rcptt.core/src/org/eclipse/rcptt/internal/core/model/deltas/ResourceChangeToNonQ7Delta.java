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
package org.eclipse.rcptt.internal.core.model.deltas;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

class ResourceChangeToNonQ7Delta implements IResourceDelta {

	private final IResource resource;

	public ResourceChangeToNonQ7Delta(IResource resource) {
		this.resource = resource;
	}

	public void accept(IResourceDeltaVisitor visitor) throws CoreException {
		accept(visitor, IResource.NONE);
	}

	public void accept(IResourceDeltaVisitor visitor, boolean includePhantoms)
			throws CoreException {
		accept(visitor, includePhantoms ? IContainer.INCLUDE_PHANTOMS
				: IResource.NONE);
	}

	public void accept(IResourceDeltaVisitor visitor, int memberFlags)
			throws CoreException {
		visitor.visit(this);
	}

	public IResourceDelta findMember(IPath path) {
		if (path.isEmpty()) {
			return this;
		} else {
			return null;
		}
	}

	public IResourceDelta[] getAffectedChildren() {
		return new IResourceDelta[0];
	}

	public IResourceDelta[] getAffectedChildren(int kindMask) {
		return getAffectedChildren();
	}

	public IResourceDelta[] getAffectedChildren(int kindMask, int memberFlags) {
		return getAffectedChildren();
	}

	public int getFlags() {
		return 0;
	}

	public IPath getFullPath() {
		return resource.getFullPath();
	}

	public int getKind() {
		return ADDED;
	}

	public IMarkerDelta[] getMarkerDeltas() {
		return new IMarkerDelta[0];
	}

	public IPath getMovedFromPath() {
		return null;
	}

	public IPath getMovedToPath() {
		return null;
	}

	public IPath getProjectRelativePath() {
		return resource.getProjectRelativePath();
	}

	public IResource getResource() {
		return resource;
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return null;
	}

}
