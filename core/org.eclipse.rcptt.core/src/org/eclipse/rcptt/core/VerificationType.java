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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.core.scenario.Verification;

public interface VerificationType {

	public static final String PHASE_START = "start";
	public static final String PHASE_RUN = "run";
	public static final String PHASE_FINISH = "finish";

	public abstract String[] getPhases();

	public abstract boolean supportsPhase(String name);

	public abstract String getId();

	public abstract String getName();

	public abstract String getDescription();

	public abstract EClass getEClass();

	public abstract boolean canCreate();

	public abstract int getPriority();

	public abstract String[] getWidgets();

	public abstract String getPrompt();

	public abstract boolean supportsWidget(String class_);

	public abstract Verification create(Resource resource, String name);

	public abstract IStatus validate(Verification verification);

	public abstract IVerificationMaker getMaker();

	public abstract boolean canMake();

}