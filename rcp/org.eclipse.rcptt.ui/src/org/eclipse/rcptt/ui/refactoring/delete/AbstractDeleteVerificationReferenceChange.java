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
package org.eclipse.rcptt.ui.refactoring.delete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;

public abstract class AbstractDeleteVerificationReferenceChange extends Change {
	private IQ7Element element;
	private final IVerification verification;
	private String verificationID;

	protected AbstractDeleteVerificationReferenceChange(IQ7Element element,
			IVerification verification, String verificationID) {
		this.element = element;
		this.verification = verification;
		this.verificationID = verificationID;
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
	}

	@Override
	public Object getModifiedElement() {
		return element.getResource();
	}

	protected final IQ7Element getElement() {
		return element;
	}

	protected final IVerification getVerification() {
		return verification;
	}

	protected final String getVerificationId() {
		return verificationID;
	}

	protected boolean isValid() throws ModelException {
		if (element == null || verification == null)
			return false;

		if (getVerificationId() == null || getVerificationId().length() == 0)
			return false;

		if (!(element instanceof ITestCase || element instanceof IQ7ProjectMetadata))
			return false;

		return true;
	}

	protected final List<String> getVerificationReferences(IQ7NamedElement copy)
			throws ModelException {
		if (copy instanceof ITestCase) {
			return new ArrayList<String>(Arrays.asList(((ITestCase) copy)
					.getVerifications()));
		}

		if (copy instanceof IQ7ProjectMetadata) {
			return new ArrayList<String>(Arrays.asList(((IQ7ProjectMetadata) copy)
					.getVerifications()));
		}

		throw new IllegalArgumentException();
	}
}
