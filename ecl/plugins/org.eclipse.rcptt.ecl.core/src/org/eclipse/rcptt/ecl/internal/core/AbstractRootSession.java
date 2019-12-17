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
package org.eclipse.rcptt.ecl.internal.core;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.CommandStack;

public abstract class AbstractRootSession extends AbstractSession {

	private AtomicBoolean closed = new AtomicBoolean(false);

	public AbstractRootSession() {
		super();
	}

	@Override
	protected CommandStack getStack() {
		return null;
	}

	@Override
	public AbstractRootSession getRoot() {
		return this;
	}

	public void reconnect() throws CoreException {
		closed.compareAndSet(true, false);
	}

	public void close() throws CoreException {
		closed.set(true);
	}

	private LocalProcManager manager = new LocalProcManager();

	public LocalProcManager getProcManager() {
		return manager;
	}

	private DeclarationContainer globals = new DeclarationContainer(null);

	public DeclarationContainer getGlobals() {
		return globals;
	}

	public boolean isClosed() {
		return closed.get();
	}
}
