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
package org.eclipse.rcptt.internal.core.model;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.Q7Status;
import org.eclipse.rcptt.core.model.Q7Status.Q7StatusCode;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.core.persistence.plain.IPlainConstants;
import org.eclipse.rcptt.core.persistence.plain.PlainTextPersistenceModel;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.core.Q7LazyResource;

public class Q7ResourceInfo extends OpenableElementInfo {
	private Resource resource;
	private NamedElement element;
	public long timestamp;
	private IPersistenceModel model;
	private String plainStoreFormat;

	public Q7ResourceInfo(String storeFormat) {
		this.plainStoreFormat = storeFormat;
	}

	public Q7ResourceInfo() {
		this(IPlainConstants.PLAIN_HEADER);
	}

	public void load(IFile file) throws ModelException {
		
		if (file != null) {
			timestamp = file.getModificationStamp();
		}
		if (resource == null) {
			URI uri = URI.createPlatformResourceURI(file != null ? file
					.getFullPath().toString() : "__uri__", true);
			createResource(uri);
		}
		model = getPersistenceModel();

		if (file != null && !file.exists()) {
			Q7Status status = new Q7Status(Q7Status.ERROR, "Element: " + file.getFullPath()
					+ " doesn't exist");
			status.setStatusCode(Q7StatusCode.NotPressent);
			throw new ModelException(status);
		}
		InputStream stream = PersistenceManager.getInstance().loadMetadata(model);

		try {
			if ((stream == null && file != null)
					&& !model.isAllowEmptyMetadataContent()) {
				stream = file.getContents();
			}
			if (stream != null) {
				resource.load(stream, PersistenceManager.getOptions());
			}
			IPersistenceModel model = getPersistenceModel();
			if (model != null) {
				model.updateMetadata();
			}
			EList<EObject> contents = resource.getContents();
			resource.setModified(false);
			if (contents.size() == 0 ) {
				throw new RuntimeException("Empty resource " + file.getLocation());
			}
			for (EObject eObject : contents) {
				if (eObject instanceof NamedElement) {
					element = (NamedElement) eObject;
				}
			}
			if (element == null) {
				throw new ModelException(new Q7Status(Q7Status.ERROR, "Illegal object type: " + contents.get(0).getClass().getName()));
			}
		} catch (Exception e) {
			// Q7Plugin.log(e);
			PersistenceManager.getInstance().remove(resource);
			throw new ModelException(e, Q7Status.ERROR);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (Throwable e) {

				}
			}
		}
	}

	public void createResource(URI uri) {
		resource = new Q7LazyResource(uri);
		resource.setTrackingModification(true);
	}

	protected IPersistenceModel getPersistenceModel() {
		return PersistenceManager.getInstance().getModel(resource);
	}

	public void unload() {
		PersistenceManager.getInstance().remove(resource);
		resource = null;
		element = null;
		this.model = null;
		timestamp = 0;
	}

	public NamedElement getNamedElement() {
		return element;
	}

	public void extractAllPersistence() {
		if (model != null) {
			model.extractAll();
		}
	}

	public void save() {
		if (model instanceof PlainTextPersistenceModel) {
			((PlainTextPersistenceModel)model).setSaveFormat(plainStoreFormat);
		}
		PersistenceManager.getInstance().saveResource(resource);
		resource.setModified(false);
		model.setUnmodified();
	}

	public IPersistenceModel getModel() {
		return model;
	}

	public boolean hasChanges() {
		if (resource == null || model == null) {
			return true;
		}
		return resource.isModified() || model.isModified();
	}

	public void createNamedElement(NamedElement createNamedElement) {
		this.element = createNamedElement;
		this.resource.getContents().add(this.element);
	}

	public Resource getResource() {
		return resource;
	}

	public void updatePersistenceModel(IPersistenceModel newModel) {
		model = newModel;
	}
}
