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
package org.eclipse.rcptt.verifications.log.ui;

import static org.eclipse.rcptt.verifications.log.tools.ErrorLogUtil.describe;
import static org.eclipse.rcptt.verifications.log.tools.ErrorLogUtil.getIndex;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.verifications.log.ErrorLogVerification;
import org.eclipse.rcptt.verifications.log.LogEntryPredicate;
import org.eclipse.rcptt.verifications.log.tools.ErrorLogUtil;

public class ErrorLogVerificationValidator implements IQ7Validator {

	public ErrorLogVerificationValidator() {
	}

	class Processor {
		private final IQ7NamedElement element;
		private final IQ7ProblemReporter reporter;

		public Processor(IQ7NamedElement element, IQ7ProblemReporter reporter) throws ModelException {
			super();
			this.element = element;
			this.reporter = reporter;
			this.verification = (ErrorLogVerification) element
					.getNamedElement();
		}

		private final ErrorLogVerification verification;

		private LogEntryPredicate findDenying(LogEntryPredicate predicate) {
			for (LogEntryPredicate denied : verification.getDenied()) {
				if (ErrorLogUtil.includes(predicate, denied)) {
					return denied;
				}
			}
			return null;
		}

		public void processAllowed(LogEntryPredicate predicate) {
			LogEntryPredicate denied = findDenying(predicate);
			if (denied != null) {
				reporter.reportProblem((IFile) element.getResource(),
						ProblemType.Warning, "Predicate " + describe(predicate) + " is always allowed by another predicate "
								+ describe(predicate), getIndex(denied), -1, -1, -1);
				reporter.reportProblem((IFile) element.getResource(),
						ProblemType.Warning, "Predicate " + describe(predicate) + " always allows another predicate " + describe(denied), getIndex(predicate), -1,
						-1, -1);
			}
		}

		public void process(IProgressMonitor monitor) {
			monitor.beginTask("", verification.getRequired().size()
					+ verification.getAllowed().size());
			for (LogEntryPredicate predicate : verification.getRequired()) {
				processAllowed(predicate);
			}
			for (LogEntryPredicate predicate : verification.getAllowed()) {
				processAllowed(predicate);
			}
			
		}
	}

	@Override
	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		if (!(element instanceof IVerification))
			return;
		try {
			NamedElement namedElement = element.getNamedElement();
			if (namedElement instanceof ErrorLogVerification) {
				Processor processor = new Processor(element, reporter);
				processor.process(SubMonitor.convert(monitor));
			}
		} catch (ModelException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}

}
