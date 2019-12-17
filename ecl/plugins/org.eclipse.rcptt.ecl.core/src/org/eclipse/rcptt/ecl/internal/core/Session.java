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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class Session extends AbstractRootSession implements ISession {

	public static abstract class EclJob extends Job {
		Command scriptlet;
		private EclJob(Command scriptlet) {
			super("ECL session execute: "
					+ CoreUtils.getScriptletNameByClass(scriptlet.eClass()));
			this.scriptlet = scriptlet;
		}
		
		public Command getScriptlet() {
			return scriptlet;
		}

	}

	protected void doExecute(Command scriptlet,
			final ICommandService svc, final List<Object> inputContent,
			final Process process){
		
		EclJob job = new EclJob(scriptlet) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				internalDoExecute(scriptlet, svc, inputContent, process);
				return Status.OK_STATUS;
			}

			@Override
			protected void canceling() {
				// Waiting for process is finished
				while (getResult() == null) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// Ignore
					}
				}
				super.canceling();
			}
		};		
		
		job.setSystem(true);
		job.schedule();

	}

}
