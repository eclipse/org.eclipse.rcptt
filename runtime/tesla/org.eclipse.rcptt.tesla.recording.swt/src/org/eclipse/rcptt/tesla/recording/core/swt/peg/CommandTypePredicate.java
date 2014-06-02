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
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public class CommandTypePredicate implements Predicate<Command> {
	public final EClass type;

	public CommandTypePredicate(EClass type) {
		this.type = type;
	}

	public boolean apply(Command input) {
		return type.isSuperTypeOf(input.eClass());
	}

}