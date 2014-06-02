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
package org.eclipse.rcptt.expandbar.runtime.internal;

import static org.eclipse.rcptt.expandbar.runtime.internal.GetItemsExtension.isExpandBarHandle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.ecl.model.CollapseAll;
import org.eclipse.rcptt.tesla.ecl.model.ControlCommand;
import org.eclipse.rcptt.tesla.ecl.model.ExpandAll;

public class ExpandCollapseAllExtension implements IScriptletExtension {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		throw new IllegalArgumentException("not implemented yet");
	}

	@Override
	public boolean canHandle(Command c) {
		return (c instanceof ExpandAll || c instanceof CollapseAll)
				&& isExpandBarHandle(((ControlCommand) c).getControl());
	}

}
