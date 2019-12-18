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
package org.eclipse.rcptt.ecl.perf.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.perf.ConstrainMax;
import org.eclipse.rcptt.ecl.perf.internal.EclPerfPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ConstrainMaxService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ConstrainMax constrain = (ConstrainMax) command;
		EObject counter = constrain.getCounter();
		String property = constrain.getProperty();
		int max = constrain.getValue();

		Object valueObj = getAttrVal(counter, property);
		if (valueObj != null && valueObj instanceof Integer) {
			int value = (Integer) valueObj;
			if (value > max) {
				Object nameObj = getAttrVal(counter, "name");
				String label = nameObj == null ? counter.toString() : nameObj
						.toString();
				return new Status(IStatus.ERROR, EclPerfPlugin.PLUGIN_ID,
						Messages.getMaxConstraintViolation(label, property,
								value, max));
			}
		}

		context.getOutput().write(constrain);
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}

	private Object getAttrVal(EObject o, String name) {
		EAttribute e = findAttr(o, name);
		if (e == null) {
			return null;
		}

		return o.eGet(e);
	}

	private EAttribute findAttr(EObject o, String name) {
		for (EAttribute e : o.eClass().getEAllAttributes()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}

}
