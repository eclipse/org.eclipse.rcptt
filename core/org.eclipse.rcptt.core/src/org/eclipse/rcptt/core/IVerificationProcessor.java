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
package org.eclipse.rcptt.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.scenario.Verification;

public interface IVerificationProcessor {

	public Object start(Verification verification, IProcess process) throws CoreException;

	public Object run(Verification verification, Object data, IProcess process) throws CoreException;

	public void finish(Verification verification, Object data, IProcess process) throws CoreException;

	public Verification create(EObject param, IProcess process) throws CoreException;

}
