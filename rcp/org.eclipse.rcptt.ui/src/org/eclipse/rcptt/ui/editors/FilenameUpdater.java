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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.ui.refactoring.rename.RenameNamedElementChange;
import org.eclipse.rcptt.util.FileUtil;

public class FilenameUpdater {

	private String originalName;

	public FilenameUpdater(IQ7NamedElement element) throws ModelException {
		this.originalName = element.getElementName();
	}

	public void update(IQ7NamedElement element) throws ModelException {
		if (element.getElementName().equals(this.originalName))
			return;
		IResource resource = element.getResource();
		this.originalName = element.getElementName();

		String newName = selectNewName(resource, element.getElementName());
		if (newName == null) // no need in update
			return;

		try {
			RenameNamedElementChange change = new RenameNamedElementChange(
					resource.getFullPath(), newName, element.getElementName());
			change.perform(new NullProgressMonitor());
		} catch (CoreException e) {
			throw new ModelException(e);
		}
	}

	private static String selectNewName(IResource resource, String elementName) {
		String newName = FileUtil.escapeFileName(elementName, null);

		IContainer container = resource.getParent();
		int counter = 0;
		while (true) {
			String possibleName = (counter == 0 ? newName : newName + " ("
					+ counter + ")")
					+ "." + resource.getFileExtension();

			IResource existingResource = container.findMember(possibleName);
			if (existingResource == null)
				return possibleName;

			// if we pick a new name, but it equals to the old one, report this
			if (existingResource.equals(resource))
				return null;

			++counter;
		}
	}
}
