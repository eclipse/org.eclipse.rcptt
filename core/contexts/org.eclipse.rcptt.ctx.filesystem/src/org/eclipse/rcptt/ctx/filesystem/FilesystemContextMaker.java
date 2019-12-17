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
package org.eclipse.rcptt.ctx.filesystem;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.filesystem.FilesystemContext;
import org.eclipse.rcptt.filesystem.FilesystemFactory;

public class FilesystemContextMaker extends DefaultContextMaker {
	@Override
	public Context create(Resource resource, ContextType type, String name) {
		FilesystemContext result = (FilesystemContext) super.create(resource,
				type, name);
		// Ivan Inozemtsev: because of backward compatibility we
		// cannot change default value from 'true' to 'false', as
		// existing filesystem contexts do not store the state of this flag
		// However because of QS-2765 we want this value to be 'false' for
		// newly created contexts
		result.setClear(false);
		result.setRoot(FilesystemFactory.eINSTANCE.createFSFolder());
		return result;
	}
}
