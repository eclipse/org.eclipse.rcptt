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
package org.eclipse.rcptt.tesla.gef.ecl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetObject;
import org.eclipse.rcptt.tesla.gef.FigureUIElement;
import org.eclipse.rcptt.tesla.gef.GefActivator;
import org.eclipse.rcptt.tesla.gef.GefProcessor;

public class GetEditPartObject implements IScriptletExtension {
	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		Element element = TeslaBridge.find((ControlHandler) ((GetObject) command).getObject(), context);
		GefProcessor processor = TeslaBridge.getClient().getProcessor(GefProcessor.class);
		FigureUIElement figureUIElement = processor.getMapper().get(element);
		if (figureUIElement == null) {
			return new Status(IStatus.ERROR, GefActivator.PLUGIN_ID, "Cannot find element");
		}
		context.getOutput().write(figureUIElement.getPart());
		return Status.OK_STATUS;
	}

	@Override
	public boolean canHandle(Command command) {
		if (!(command instanceof GetObject)) {
			return false;
		}
		GetObject cmd = (GetObject) command;
		EObject object = cmd.getObject();
		if (!(object instanceof ControlHandler)) {
			return false;
		}
		ControlHandler control = (ControlHandler) object;
		return control.getKind() == ElementKind.DiagramFigure;
	}

}
