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
package org.eclipse.rcptt.ctx.internal.resources;

import java.util.List;

import org.eclipse.core.resources.IResource;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.index.IIndexDocument;
import org.eclipse.rcptt.core.model.index.IIndexer;
import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.resources.WSUtils;
import org.eclipse.rcptt.workspace.WSLink;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceContext;

public class WorkspaceContextIndexer implements IIndexer {

	public WorkspaceContextIndexer() {
	}

	public void index(IIndexDocument document) {
		IQ7NamedElement element = null;
		try {
			element = document.getElement();
			if (!(element instanceof IContext)) {
				return;
			}
			NamedElement namedElement = element.getNamedElement();
			if (namedElement instanceof WorkspaceContext) {
				WorkspaceContext ctx = (WorkspaceContext) namedElement;

				WSRoot content = ctx.getContent();
				List<WSLink> listLinks = WSUtils.listLinks(content);
				for (WSLink wsLink : listLinks) {
					IResource linkPath = WSUtils.getLinkResource(wsLink);
					if( linkPath  == null ) {
						linkPath = WSUtils.getLinkContainer(wsLink);
					}
					if (linkPath != null) {
						document.addKey(IQ7IndexConstants.WS_LINK_REF, linkPath
								.getFullPath().toString());
					} else {
						// Some value, since link is specified
						document.addKey(IQ7IndexConstants.WS_LINK_REF, "***");
					}
				}
			}
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
	}
}
