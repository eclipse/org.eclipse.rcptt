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
package org.eclipse.rcptt.ui.panels.assertion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.ui.panels.assertion.AssertionUtils.ReferencePlaceholder;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;

public class AssertContentProvider implements ITreeContentProvider {

	private final AutLaunch launch;

	public AssertContentProvider(AutLaunch launch) {
		this.launch = launch;
	}

	public Object[] getElements(Object inputElement) {
		List<AssertGroup> asserts = ((AssertInput) inputElement).getAsserts();
		List<AssertGroup> result = new ArrayList<AssertGroup>();
		for (AssertGroup assertGroup : asserts) {
			if (!assertGroup.getAsserts().isEmpty()) {
				result.add(assertGroup);
			}
		}
		return result.toArray();
	}

	public Object getParent(Object element) {
		return input.getParent(element);
	}

	public boolean hasChildren(Object element) {
		return element instanceof AssertGroup;
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof AssertGroup) {
			AssertGroup parentGroup = (AssertGroup) parentElement;
			Object[] children = parentGroup.getAsserts().toArray(new Object[0]);
			if (children.length == 1
					&& children[0] instanceof ReferencePlaceholder) {
				Element element = ((ReferencePlaceholder) children[0])
						.getElement();
				return fetchChildren(parentGroup, element);
			}
			return children;
		}
		return null;
	}

	private AssertInput input;

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.input = (AssertInput) newInput;
	}

	public void dispose() {
		// Nothing to do
	}

	private Object[] fetchChildren(AssertGroup assertGroup, Element element) {
		String path = buildPath(assertGroup);
		AssertionUtils.fillAdvancedPropertiesGroup(assertGroup.getAsserts(),
				loadChildren(element, path).getPropertyNodes(), element, path);
		input.reindex();
		return assertGroup.getAsserts().toArray();
	}

	public PropertyNodeList loadChildren(Element element, String path) {
		GetPropertyNodes getNodes = TeslaFactory.eINSTANCE
				.createGetPropertyNodes();
		getNodes.setElement(EcoreUtil.copy(element));
		getNodes.setNodePath(path);
		Object result = null;
		try {
			result = launch.execute(getNodes);
		} catch (Exception e) {
			Q7UIPlugin.log(e);
		}
		if (result instanceof PropertyNodeList) {
			return (PropertyNodeList) result;
		}
		return UiFactory.eINSTANCE.createPropertyNodeList();
	}

	private String buildPath(AssertGroup assertGroup) {
		String path = assertGroup.getName();
		Object parent = getParent(assertGroup);
		while (parent != null) {
			String parentName = null;
			if (parent instanceof AssertGroup) {
				parentName = ((AssertGroup) parent).getName();
			}
			parent = getParent(parent);
			// ignore top level assert group
			if (parent != null && parentName != null) {
				path = parentName + "." + path;
			}
		}
		return path;
	}
}