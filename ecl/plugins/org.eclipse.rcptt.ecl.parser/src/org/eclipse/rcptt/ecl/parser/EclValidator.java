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
package org.eclipse.rcptt.ecl.parser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.runtime.EclCompiler;

public enum EclValidator {

	Instanse;

	public IStatus validate(String content) {
		try {
			Command raw = EclCoreParser.newCommand(content);
			if (raw instanceof Exec) {
				validate((Exec) raw);
			}
		} catch (CoreException e) {
			return e.getStatus();
		}
		return Status.OK_STATUS;
	}	

	private IStatus validate(Exec exec) throws CoreException {
		Command command = EclCompiler.compile(exec);
		EList<EObject> eContents = command.eContents();
		for (EObject e : eContents) {
			if (e instanceof Exec) {
				validate((Exec) e);
			}
		}
		return Status.OK_STATUS;
	}
}
