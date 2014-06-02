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
package org.eclipse.rcptt.verifications.log.impl;

import static org.eclipse.rcptt.verifications.log.tools.ErrorLogUtil.createMatchingPredicate;
import static org.eclipse.rcptt.verifications.log.tools.ErrorLogUtil.describe;
import static org.eclipse.rcptt.verifications.log.tools.ErrorLogUtil.find;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.VerificationProcessor;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.verifications.log.ErrorLogVerification;
import org.eclipse.rcptt.verifications.log.LogEntryPredicate;
import org.eclipse.rcptt.verifications.log.LogFactory;
import org.eclipse.rcptt.verifications.runtime.ErrorList;

public class ErrorLogVerificationProcessor extends VerificationProcessor implements ILogListener {
	
	
	private final Set<LogEntryPredicate> whiteList = new HashSet<LogEntryPredicate>();
	private final List<IStatus> testLog = new ArrayList<IStatus>(); 
	
	
	class State {
		State onStart(){return this;}
		State onRun() {return this;}
		State onFinish(){return this;}
	}
	
	private final State STARTED  = new  State() {
		@Override
		State onFinish() {
			return FINISHED;
		}
		@Override
		State onRun() {
			return RUNNING;
		}
	};
	
	private final State FINISHED = new State() {
		@Override
		State onStart() {
			reset();
			return STARTED;
		}

	};
	
	private final State RUNNING = new State() {
		@Override
		State onStart() {
			reset();
			return STARTED;
		}
		@Override
		State onFinish() {
			return FINISHED;
		}
	};

	private void reset() {
		whiteList.clear();
		testLog.clear();
	}
	
	private State currentState = FINISHED;

	public ErrorLogVerificationProcessor() {
		Platform.addLogListener(this);
	}
	
	@Override
	synchronized public Object start(Verification verification, IProcess process)
			throws CoreException {
		currentState = currentState.onStart();
		ErrorLogVerification logVer = (ErrorLogVerification) verification;
		whiteList.addAll(logVer.getAllowed());
		whiteList.addAll(logVer.getRequired());
		return null;
	}

	@Override
	synchronized public Object run(Verification verification, Object data, IProcess process)
			throws CoreException {
		currentState = currentState.onFinish();
		return data;
	}

	@Override
	synchronized public void finish(Verification verification, Object data, IProcess process)
			throws CoreException {
		currentState = currentState.onFinish();
		ErrorLogVerification logVerification = (ErrorLogVerification) verification;
		ErrorList errors = new ErrorList();
		for (IStatus status: testLog) {
			if (isWhiteListed(status))
				continue;
			LogEntryPredicate denied = find(logVerification.getDenied(), status);
			if (denied != null) {
				errors.add(
						"Log entry\n%s\nis denied by predicate\n%s",
						describe(status),
						describe(denied));
			}
		}
		
		for (LogEntryPredicate predicate: logVerification.getRequired()) {
			if (find(testLog, predicate) == null) {
				errors.add("Required \n%s\nnot found", describe(predicate));
			}
		}
		errors.throwIfAny("Error log verification failed:", this.getClass().getPackage().getName(), verification.getId());
	}

	@Override
	synchronized public void logging(IStatus status, String plugin) {
		testLog.add(status);
	}
	
	private boolean isWhiteListed(IStatus status) {
		LogEntryPredicate rv = find(whiteList, status);
		if (rv != null) {
			ErrorLogVerification verification = (ErrorLogVerification) rv.eContainer();
			ReportManager.appendLog(format("Log entry %s is allowed by verification %s with %s",
					describe(status),
					verification.getName(),
					describe(rv)
					));
		}
		return rv != null;
	}

	@Override
	public Verification create(EObject param, IProcess process)
			throws CoreException {
		ErrorLogVerification rv = LogFactory.eINSTANCE.createErrorLogVerification();
		for (IStatus entry: testLog) {
			rv.getAllowed().add(createMatchingPredicate(entry));
		}
		return rv;
	}

	
}
