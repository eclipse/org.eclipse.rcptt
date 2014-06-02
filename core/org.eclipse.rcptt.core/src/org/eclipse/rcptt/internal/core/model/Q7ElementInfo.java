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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.rcptt.core.model.IQ7Element;

public class Q7ElementInfo {

	private List<IQ7Element> children;

	public static final Object[] NO_NON_Q7_RESOURCES = new Object[0];

	protected Q7ElementInfo() {
	}

	public void addChild(IQ7Element child) {
		if (this.children == null) {
			this.children = new ArrayList<IQ7Element>(5);
		}
		if (!this.children.contains(child)) {
			this.children.add(child);
		}
	}

	public int size() {
		if (this.children == null)
			return 0;
		return this.children.size();
	}

	protected IQ7Element get(int i) {
		if (this.children == null)
			return null;
		return children.get(i);
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}

	public IQ7Element[] getChildren() {
		if (children == null)
			return Q7Element.NO_ELEMENTS;
		return this.children.toArray(new IQ7Element[this.children.size()]);
	}

	public List<IQ7Element> getChildrenAsList() {
		if (children == null)
			return Collections.emptyList();
		else
			return this.children;
	}

	public void removeChild(IQ7Element child) {
		if (this.children != null) {
			this.children.remove(child);
		}
	}

	public <T extends IQ7Element> void setChildren(T[] children) {
		if (children == null) {
			this.children = null;
		} else {
			this.children = new ArrayList<IQ7Element>(children.length);
			for (int i = 0; i < children.length; i++) {
				this.children.add(children[i]);
			}
		}
	}

	public <T extends IQ7Element> void setChildren(List<T> children) {
		if (children == null) {
			this.children = null;
		} else {
			this.children = new ArrayList<IQ7Element>(children);
		}
	}

}
