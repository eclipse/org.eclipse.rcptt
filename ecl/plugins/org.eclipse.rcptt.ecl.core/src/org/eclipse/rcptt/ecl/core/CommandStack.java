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
package org.eclipse.rcptt.ecl.core;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.rcptt.ecl.internal.core.DeclarationContainer;

public class CommandStack {

	public CommandStack(Command command, CommandStack parent) {
		this.command = command;
		this.parent = parent;
		this.locals = new DeclarationContainer(parent == null ? null
				: parent.locals);
	}

	private DeclarationContainer locals;

	public DeclarationContainer getDeclarations() {
		return locals;
	}

	public Command getCommand() {
		return command;
	}

	public CommandStack getParent() {
		return parent;
	}

	public static void addListener(IStackListener listener) {
		listeners.addIfAbsent(listener);
	}

	public static void removeListener(IStackListener listener) {
		listeners.remove(listener);
	}

	public static void fireEnter(CommandStack stack) {
		for (IStackListener l : listeners) {
			l.enter(stack);
		}
	}

	public static void fireExit(CommandStack stack) {
		for (IStackListener l : listeners) {
			l.exit(stack);
		}
	}

	private final Command command;
	private final CommandStack parent;

	private static CopyOnWriteArrayList<IStackListener> listeners = new CopyOnWriteArrayList<IStackListener>();

}
