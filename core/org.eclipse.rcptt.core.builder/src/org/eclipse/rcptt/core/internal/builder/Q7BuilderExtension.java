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
package org.eclipse.rcptt.core.internal.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.core.IQ7Extension;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class Q7BuilderExtension implements IQ7Extension {

	public Q7BuilderExtension() {
	}

	class Q7DeltaVisitor implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
			case IResourceDelta.CHANGED:
				if (resource.getType() == IResource.PROJECT) {
					new MigrateProjectsJob((IProject)resource).schedule();
					return false;
				}
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	public void initialize() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(
				new IResourceChangeListener() {
					public void resourceChanged(IResourceChangeEvent e) {
						IResourceDelta delta = e.getDelta();
						if (delta != null) {
							try {
								delta.accept(new Q7DeltaVisitor());
							} catch (CoreException e1) {
								RcpttPlugin.log(e1);
							}
						}
					}
				});
		// Associate builders to all Q7 projects in workspace
		// In case project are not associated
		new MigrateProjectsJob(ResourcesPlugin.getWorkspace().getRoot()).schedule();
	}

	public boolean isBuilder() {
		return true;
	}

}
