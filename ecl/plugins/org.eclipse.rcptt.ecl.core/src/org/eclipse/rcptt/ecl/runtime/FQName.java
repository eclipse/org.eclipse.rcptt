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
package org.eclipse.rcptt.ecl.runtime;

import static java.lang.String.format;
import static org.eclipse.rcptt.ecl.internal.core.CorePlugin.err;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.ecl.core.Command;

public final class FQName {
	public final String ns;
	public final String name;

	public FQName(String ns, String name) {
		this.ns = ns;
		this.name = name;
	}

	public static FQName fromCommand(Command command) {
		EClass eClass = command.eClass();
		return new FQName(eClass.getEPackage().getNsURI(), eClass.getName());

	}

	public static FQName fromAttributes(String ns, String name) throws CoreException {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(ns);
		if (ePackage == null) {
			throw new CoreException(err(format("Unknown package %s", ns)));
		}

		if (ePackage.getEClassifier(name) == null) {
			throw new CoreException(err(format("Unknown class %s in package %s", name, ns)));
		}

		return new FQName(ns, name);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ns == null) ? 0 : ns.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FQName other = (FQName) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ns == null) {
			if (other.ns != null)
				return false;
		} else if (!ns.equals(other.ns))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (ns == null || ns.length() == 0)
			return name;
		return ns + "::" + name;
	}
}
