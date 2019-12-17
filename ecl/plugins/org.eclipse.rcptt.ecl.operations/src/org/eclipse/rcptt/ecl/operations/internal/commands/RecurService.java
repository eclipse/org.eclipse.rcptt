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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import static org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin.PLUGIN_ID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.Recur;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class RecurService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		Recur recur = (Recur) command;
		throw new CoreException(new RecurStatus(recur.getValues().toArray(new EObject[0])));
	}

	public static class RecurStatus implements IStatus {
		public final EObject[] vals;

		public RecurStatus(EObject[] vals) {
			this.vals = vals;
		}

		@Override
		public IStatus[] getChildren() {
			return new IStatus[0];
		}

		@Override
		public int getCode() {
			return 0;
		}

		@Override
		public Throwable getException() {
			return null;
		}

		@Override
		public String getMessage() {
			return null;
		}

		@Override
		public String getPlugin() {
			return PLUGIN_ID;
		}

		@Override
		public int getSeverity() {
			return OK;
		}

		@Override
		public boolean isMultiStatus() {
			return false;
		}

		@Override
		public boolean isOK() {
			return true;
		}

		@Override
		public boolean matches(int severityMask) {
			return (OK & severityMask) != 0;
		}

	}

}
