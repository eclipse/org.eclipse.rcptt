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
package org.eclipse.rcptt.core.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;

public interface IQ7ProblemReporter {
	enum ProblemType {
		Error(IMarker.SEVERITY_ERROR), Warning(IMarker.SEVERITY_WARNING), Info(
				IMarker.SEVERITY_INFO);
		ProblemType(int value) {
			this.value = value;
		}

		int value;

		public int getValue() {
			return value;
		}
	}

	void reportProblem(IFile element, ProblemType type, String message,
			int line, int offset, int length, int sourceId);
}
