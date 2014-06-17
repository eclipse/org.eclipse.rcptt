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
package org.eclipse.rcptt.core.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

/**
 * RCP IO error.
 * 
 * Warning: getStatus() might return not a Q7Status
 */
public class ModelException extends CoreException {
	private static final long serialVersionUID = 1L;

	CoreException nestedCoreException;

	public ModelException(Throwable e, int code) {
		this(new Q7Status(code, e));
	}

	public ModelException(Throwable e, String message) {
		this(new Q7Status(0, message));
	}

	public ModelException(IStatus status) {
		super(status);
	}

	public ModelException(CoreException exception) {
		super(exception.getStatus());
		this.nestedCoreException = exception;
	}

	public Throwable getException() {
		if (this.nestedCoreException == null) {
			return getStatus().getException();
		} else {
			return this.nestedCoreException;
		}
	}
	
}
