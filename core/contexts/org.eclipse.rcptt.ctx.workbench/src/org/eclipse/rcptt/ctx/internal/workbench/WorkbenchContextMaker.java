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
package org.eclipse.rcptt.ctx.internal.workbench;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.WorkbenchContext;

public class WorkbenchContextMaker extends DefaultContextMaker {

	@Override
	public IStatus validate(Context context) {
		WorkbenchContext pc = (WorkbenchContext) context;
		String pid = pc.getPerspectiveId();
		if (pid == null || pid.length() == 0) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Perspective id can't be empty");
		}
		return super.validate(context);
	}

}
