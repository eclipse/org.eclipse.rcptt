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
package org.eclipse.rcptt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.launching.events.AutEvent;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Script;

/**
 * This interface represents launched {@link Aut application under test} and
 * allows to manage this application.
 *
 * @author Yuri Strot
 */
public interface AutLaunch {

	/**
	 * Return unique launch identifier
	 *
	 * @return launch identifier
	 */
	String getId();

	/**
	 * Return AUT which was launched
	 *
	 * @return application under test
	 */
	Aut getAut();

	/**
	 * Return state of the launched AUT
	 *
	 * @return launch state
	 */
	AutLaunchState getState();

	/**
	 * Return the aut capability platform "e4", "rap".
	 *
	 * @return capability platform
	 */
	String getCapability();

	/**
	 * Returns associated ILaunch
	 *
	 * @return
	 */
	ILaunch getLaunch();

	/**
	 * Add launch listener
	 *
	 * @param listener
	 */
	void addListener(AutLaunchListener listener);

	/**
	 * Remove launch listener
	 *
	 * @param listener
	 */
	void removeListener(AutLaunchListener listener);

	/**
	 * Execute ECL command and return result of this execution
	 *
	 * @param command
	 *            ECL command
	 * @return result of the command execution
	 * @throws CoreException
	 *             if the command can't be executed or failed to execute
	 * @throws InterruptedException
	 *             if thread was interrupted during command execution
	 */
	Object execute(Command command) throws CoreException, InterruptedException;

	/**
	 * Execute ECL command and return result of this execution. This method
	 * allows to specify exact timeout to wait command result.
	 *
	 * @param command
	 *            ECL command
	 * @param timeout
	 *            time to wait command result
	 * @return result of the command execution or null if timeout
	 * @throws CoreException
	 *             if the command can't be executed or failed to execute
	 * @throws InterruptedException
	 *             if thread was interrupted during command execution
	 */
	Object execute(Command command, long timeout) throws CoreException,
			InterruptedException;

	/**
	 * Execute ECL command and return result of this execution. This method
	 * allows to specify exact timeout and to cancel the execution with a
	 * monitor.
	 *
	 * @param command
	 *            ECL command
	 * @param timeout
	 *            time to wait command result
	 * @param monitor
	 *            progress monitor (only for cancellation status)
	 * @return result of the command execution or null if timeout
	 * @throws CoreException
	 *             if the command can't be executed or failed to execute
	 * @throws InterruptedException
	 *             if thread was interrupted during command execution
	 */
	Object execute(Command command, long timeout, IProgressMonitor monitor)
			throws CoreException, InterruptedException;

	/**
	 * Execute Q7 test case
	 *
	 * @param test
	 *            test case
	 * @param monitor
	 *            progress monitor (only for cancellation status)
	 * @throws CoreException
	 *             if script fail to execute
	 */
	void run(IQ7NamedElement test, long timeout, IProgressMonitor monitor, ExecutionPhase phase)
			throws CoreException;

	/**
	 * Execute Q7 test case in debug mode
	 *
	 * @param test
	 *            test case
	 * @param monitor
	 *            progress monitor (only for cancellation status)
	 * @param debugger
	 *            test case debugger. Debugger automatically created as part of
	 *            test case debug launch
	 * @throws CoreException
	 *             if script fail to execute
	 */
	void debug(IQ7NamedElement test, IProgressMonitor monitor, TestCaseDebugger debugger,
			ExecutionPhase phase) throws CoreException;

	/**
	 * Execute ECL script
	 *
	 * @param script
	 *            ECL script
	 * @param monitor
	 *            progress monitor (only for cancellation status)
	 * @throws CoreException
	 *             if script fail to execute
	 */
	void execute(Script script, long timeout, IProgressMonitor monitor)
			throws CoreException;

	/**
	 * Connect to launched AUT to make sure it's available
	 *
	 * @throws CoreException
	 *             if AUT is not available
	 * @throws InterruptedException
	 */
	void ping() throws CoreException, InterruptedException;

	/**
	 * Wait for AUT restart. This method can be called even if AUT still active
	 * but going to be restarted.
	 *
	 * @param monitor
	 *            progress monitor (only for cancellation status)
	 * @throws CoreException
	 *             in the following cases:
	 *             <ul>
	 *             <li>monitor was cancelled</li>
	 *             <li>thread was interrupted</li>
	 *             <li>timeout error</li>
	 *             </ul>
	 **/
	void waitForRestart(IProgressMonitor monitor) throws CoreException;

	/**
	 * Safely shutdown launched AUT. This method blocks until AUT shutdown.
	 */
	void shutdown();

	/**
	 * Terminate launched AUT immediately. If quick termination is not required
	 * it's recommended to use {@link #shutdown()}
	 */
	void terminate();

	void cancelTestExecution();

	void resetState();

	void handleAutEvent(AutEvent autEvent);
}
