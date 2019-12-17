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
package org.eclipse.rcptt.ecl.debug.runtime;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.debug.model.BreakpointCmd;
import org.eclipse.rcptt.ecl.debug.model.BreakpointEvent;
import org.eclipse.rcptt.ecl.debug.model.DebugCmd;
import org.eclipse.rcptt.ecl.debug.model.DebugType;
import org.eclipse.rcptt.ecl.debug.model.Event;
import org.eclipse.rcptt.ecl.debug.model.EventType;
import org.eclipse.rcptt.ecl.debug.model.ModelFactory;
import org.eclipse.rcptt.ecl.debug.model.ResolveVariableCmd;
import org.eclipse.rcptt.ecl.debug.model.SkipAllCmd;
import org.eclipse.rcptt.ecl.debug.model.StackEvent;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;

public class ModelUtils {
	public static Event createEvent(EventType type) {
		Event event = ModelFactory.eINSTANCE.createEvent();
		event.setType(type);
		return event;
	}

	public static BreakpointEvent createBreakpointEvent(EventType type, String path, int line) {
		BreakpointEvent event = ModelFactory.eINSTANCE.createBreakpointEvent();
		event.setType(type);
		event.setPath(path);
		event.setLine(line);
		return event;
	}

	public static StackEvent createStackEvent(EventType type, List<StackFrame> frames) {
		StackEvent event = ModelFactory.eINSTANCE.createStackEvent();
		event.setType(type);
		for (StackFrame fr : frames) {
			event.getStackFrame().add(EcoreUtil.copy(fr));
		}
		return event;
	}

	public static SkipAllCmd createSkipAllEvent(boolean value) {
		SkipAllCmd skipAll = ModelFactory.eINSTANCE.createSkipAllCmd();
		skipAll.setSkip(value);
		skipAll.setType(DebugType.SKIP_ALL);
		return skipAll;
	}

	public static DebugCmd createDebugCmd(DebugType type) {
		DebugCmd op = ModelFactory.eINSTANCE.createDebugCmd();
		op.setType(type);
		return op;
	}
	public static ResolveVariableCmd createVariableCmd(String id) {
		ResolveVariableCmd op = ModelFactory.eINSTANCE.createResolveVariableCmd();
		op.setId(id);
		op.setType(DebugType.RESOLVE_VARIABLE);
		return op;
	}

	public static BreakpointCmd createBreakpointCmd(DebugType type, String path, int line) {
		BreakpointCmd op = ModelFactory.eINSTANCE.createBreakpointCmd();
		op.setType(type);
		op.setPath(path);
		op.setLine(line);
		return op;
	}
}
