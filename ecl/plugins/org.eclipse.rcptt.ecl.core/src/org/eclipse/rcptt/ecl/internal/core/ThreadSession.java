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
package org.eclipse.rcptt.ecl.internal.core;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class ThreadSession extends AbstractRootSession implements ISession {
	private static ExecutorService cachedPool;
	static {
		cachedPool = Executors.newCachedThreadPool();
	}

	public static abstract class EclJob extends Job {

		private EclJob(Command scriptlet) {
			super("ECL session execute: "
					+ CoreUtils.getScriptletNameByClass(scriptlet.eClass()));
		}
	}

	protected void doExecute(final Command scriptlet,
			final ICommandService svc, final List<Object> inputContent,
			final Process process) {
		cachedPool.execute(new Runnable() {
			public void run() {
				internalDoExecute(scriptlet, svc, inputContent, process);
			}
		});
	}
}
