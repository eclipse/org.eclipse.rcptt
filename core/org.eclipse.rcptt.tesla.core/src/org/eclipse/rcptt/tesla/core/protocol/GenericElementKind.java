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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.core.runtime.Assert;

/**
 * This class represents a generalization for custom and built-in UI element
 * kinds.
 */
public class GenericElementKind {

	public final ElementKind kind;
	public final String customKindId;

	public GenericElementKind(ElementKind kind) {
		Assert.isNotNull(kind);
		this.kind = kind;
		this.customKindId = null;
	}

	public GenericElementKind(String customKindId) {
		this.kind = ElementKind.Custom;
		this.customKindId = customKindId;
	}

	// convenience constants
	public static final GenericElementKind Unknown = new GenericElementKind(ElementKind.Unknown);
	//
	@Override
	public boolean equals(Object kind) {
		if( kind instanceof ElementKind) {
			return is(kind);
		}
		return super.equals(kind);
	}

	public boolean is(ElementKind kind) {
		if (kind == null)
			return false;
		return (this.kind == kind);
	}

	public boolean is(String customKindId) {
		if (customKindId == null)
			return false;
		return customKindId.equals(this.customKindId);
	}

	public boolean is(GenericElementKind gk) {
		if (gk.kind == ElementKind.Custom)
			return (this.kind == ElementKind.Custom) && is(gk.customKindId);
		return is(gk.kind);
	}

	public boolean is(Object kind) {
		if (kind instanceof GenericElementKind)
			return is((GenericElementKind) kind);
		if (kind instanceof ElementKind)
			return is((ElementKind) kind);
		if (kind instanceof String)
			return is((String) kind);
		return false;
	}

	public boolean in(Object... kinds) {
		for (Object kind : kinds)
			if (is(kind))
				return true;
		return false;
	}


	public String name() {
		if (kind == ElementKind.Custom)
			return customKindId;
		return kind.name();
	}

	@Override
	public String toString() {
		return name();
	}


	// utility methods

	public boolean isLabel() {
		return (kind == ElementKind.Label) || (kind == ElementKind.Link);
	}

	public boolean skipFirstAfter() {
		return !((kind == ElementKind.Text) || (kind == ElementKind.Combo));
	}

	//

	public static GenericElementKind fromString(String kindName) {
		if (kindName == null)
			return null;

		ElementKind kind = ElementKind.kindOf(kindName);
		return (kind == ElementKind.Custom) ?
				new GenericElementKind(kindName) :
				new GenericElementKind(kind);
	}

}
