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
package org.eclipse.rcptt.ui.editors.ecl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.ide.IGotoMarker;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.ui.debug.EclLineBreakpointAdapter;

public class EclEditorInput extends PlatformObject implements IFileEditorInput,
		IPathEditorInput, IPersistableElement {

	private final IQ7NamedElement scenario;

	public IFile getFile() {
		return (IFile) scenario.getResource();
	}

	public IPath getPath() {
		return scenario.getResource().getFullPath();
	}

	public EclEditorInput(IQ7NamedElement scenario) {
		this.scenario = scenario;
	}

	public IQ7NamedElement getElement() {
		return scenario;
	}

	public boolean exists() {
		return true;
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getName() {
		try {
			return scenario.getElementName();
		} catch (ModelException e) {
			return scenario.getName();
		}
	}

	public IPersistableElement getPersistable() {
		return this;
	}

	public String getToolTipText() {
		return getName();
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (IToggleBreakpointsTarget.class.isAssignableFrom(adapter)) {
			return new EclLineBreakpointAdapter(scenario.getResource());
		}
		if (IGotoMarker.class.isAssignableFrom(adapter)) {
			return this;
		}
		Object result = scenario.getAdapter(adapter);
		if (result != null) {
			return result;
		}
		result = scenario.getResource().getAdapter(adapter);
		if (result != null) {
			return result;
		}

		return super.getAdapter(adapter);
	}

	public IStorage getStorage() throws CoreException {
		return new IStorage() {
			@SuppressWarnings("rawtypes")
			public Object getAdapter(Class adapter) {
				return null;
			}

			public boolean isReadOnly() {
				return false;
			}

			public String getName() {
				return scenario.getName();
			}

			public IPath getFullPath() {
				return scenario.getPath();
			}

			public InputStream getContents() throws CoreException {
				String content = Scenarios.getScriptContent((Scenario) scenario
						.getNamedElement());
				return new ByteArrayInputStream(content.getBytes());
			}
		};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((scenario == null) ? 0 : scenario.getResource().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof EclEditorInput) {
			EclEditorInput other = (EclEditorInput) obj;
			if (scenario == null) {
				if (other.scenario.getResource() != null)
					return false;
			} else if (!scenario.getResource().equals(
					other.scenario.getResource()))
				return false;

			return true;
		}
		if (obj instanceof IFileEditorInput) {
			IFileEditorInput other = (IFileEditorInput) obj;
			if (scenario == null) {
				if (other.getFile() != null)
					return false;
			} else if (!scenario.getResource().equals(other.getFile()))
				return false;

			return true;
		}
		return false;
	}

	public void saveState(IMemento memento) {
		EclEditorInputFactory.saveState(memento, this);
	}

	public String getFactoryId() {
		return EclEditorInputFactory.getFactoryId();
	}

}
