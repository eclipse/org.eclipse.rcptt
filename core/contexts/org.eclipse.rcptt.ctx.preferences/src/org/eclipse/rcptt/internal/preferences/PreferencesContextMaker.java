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
package org.eclipse.rcptt.internal.preferences;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.preferences.PreferencesContext;

public class PreferencesContextMaker extends DefaultContextMaker {
	@Override
	public void captureContents(IContext context, Context data,
			IProgressMonitor monitor) throws CoreException {
		boolean isClean = ((PreferencesContext) context.getNamedElement())
				.isCleanPreferences();
		super.captureContents(context, data, monitor);
		((PreferencesContext) context.getNamedElement())
				.setCleanPreferences(isClean);
	}
}
