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
package org.eclipse.rcptt.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.scenario.Context;

public class ContextType {

	private static final String ATTR_ID = "id";
	private static final String ATTR_NAME = "name";
	private static final String ATTR_DESCRIPTION = "description";
	private static final String ATTR_CLASS = "eclass";
	private static final String ATTR_PACKAGE = "epackage-uri";
	private static final String ATTR_CAN_CREATE = "canCreate";
	private static final String ATTR_PRIORITY = "priority";

	private final String id;
	private final String name;
	private final String description;
	private final EClass eClass;
	private final String contributorId;
	private boolean canCreate;
	private final int priority;

	public ContextType(IConfigurationElement element) throws CoreException {
		id = getVal(element, ATTR_ID);
		name = getVal(element, ATTR_NAME);
		description = getVal(element, ATTR_DESCRIPTION);
		contributorId = element.getContributor().getName();
		canCreate = Boolean.TRUE.toString().equals(
				getVal(element, ATTR_CAN_CREATE));
		int parsed;
		try {
			parsed = Integer.parseInt(getVal(element, ATTR_PRIORITY));
		} catch (NumberFormatException e) {
			parsed = 10;
		}
		priority = parsed;
		String packageUri = getVal(element, ATTR_PACKAGE);
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageUri);
		if (ePackage == null)
			throw new IllegalArgumentException("Invalid package uri for '" + id
					+ "' context type: " + packageUri);
		String className = getVal(element, ATTR_CLASS);
		EClassifier classifier = ePackage.getEClassifier(className);
		if (classifier instanceof EClass) {
			eClass = (EClass) classifier;
		} else {
			throw new IllegalArgumentException("Invalid class name for '" + id
					+ "' context type: " + className);
		}
	}

	public String getContributorId() {
		return contributorId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public EClass getEClass() {
		return eClass;
	}

	public boolean canCreate() {
		return canCreate;
	}

	public int getPriority() {
		return priority;
	}

	public Context create(Resource resource, String name) {
		return getMaker().create(resource, this, name);
	}

	// public void remove(Context context, IFile file) {
	// getMaker().remove(context, file);
	// }

	// public Context copy(Context context, IFile destination)
	// throws CoreException {
	// IContextMaker maker = getMaker();
	// return DefaultContextMakerResources.copy(context, destination, maker);
	// }

	public IStatus validate(Context context) {
		return getMaker().validate(context);
	}

	public IContextMaker getMaker() {
		return ContextTypeManager.getInstance().getMaker(getId());
	}

	private String getVal(IConfigurationElement element, String attr) {
		String val = element.getAttribute(attr);
		if (val == null || val.length() == 0)
			throw new IllegalArgumentException("Context type " + attr
					+ " can't be empty");
		return val;
	}

	public boolean canMake() {
		return getMaker().canMake();
	}

}
