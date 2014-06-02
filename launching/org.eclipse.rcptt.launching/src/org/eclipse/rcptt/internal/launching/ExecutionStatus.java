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
package org.eclipse.rcptt.internal.launching;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;

public class ExecutionStatus extends Status {
	private int line = -1;
	private int column = -1;
	private int length = -1;

	private IStatus cause;

	private IQ7NamedElement element;

	private AdvancedInformation info;

	public ExecutionStatus(IStatus status) {
		super(status.getSeverity(), status.getPlugin(), status.getCode(),
				status.getMessage(), status.getException());
		cause = status;
		if (cause instanceof ScriptErrorStatus) {
			ScriptErrorStatus ss = (ScriptErrorStatus) cause;
			line = ss.getLine();
			column = ss.getColumn();
			length = ss.getLength();
		}
		if (cause instanceof ExecutionStatus) {
			ExecutionStatus ss = (ExecutionStatus) cause;
			line = ss.getLine();
			column = ss.getColumn();
			length = ss.getLength();
		}
	}

	public ExecutionStatus(int severity, String pluginId, String message) {
		super(severity, pluginId, message);
	}

	public ExecutionStatus(int severity, String pluginId, String message,
			Throwable exception) {
		super(severity, pluginId, message, exception);
	}

	public ExecutionStatus(int severity, String pluginId, int line, int column,
			int length) {
		super(severity, pluginId, String.format(
				"Execution failed on line %d at column %d", line, column));
		this.line = line;
		this.column = column;
		this.length = length;
	}

	public boolean hasLocation() {
		return line > 0 && column > 0 && length > 0;
	}

	@Override
	public void setMessage(String message) {
		super.setMessage(message);
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	private void updateMessage() {
		if (getMessage().matches(
				".*Execution failed on line (\\d+) at column (\\d+).*")) {
			setMessage(getMessage().replaceFirst(
					"Execution failed on line (\\d+) at column (\\d+)",
					String.format("Execution failed on line %d at column %d",
							line, column)));
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public IStatus getCause() {
		return getCause(false);
	}

	public IStatus getCause(boolean flatten) {
		if (flatten && cause instanceof ExecutionStatus) {
			return ((ExecutionStatus) cause).getCause(flatten);
		}
		return cause;
	}

	public void setCause(IStatus cause) {
		this.cause = cause;
	}

	public void setAdvancedInfo(AdvancedInformation info) {
		this.info = info;
	}

	public AdvancedInformation getInfo() {
		if (info != null) {
			return info;
		}
		TeslaErrorStatus status = extractTeslaStatus(this);
		return status == null ? null : status.getInfo();
	}

	private static TeslaErrorStatus extractTeslaStatus(ExecutionStatus status) {
		if (status.getCause() instanceof TeslaErrorStatus) {
			return (TeslaErrorStatus) status.getCause();
		}
		if (status.getCause() instanceof ScriptErrorStatus) {
			return extractTeslaStatus((ScriptErrorStatus) status.getCause());
		}
		return null;
	}

	private static TeslaErrorStatus extractTeslaStatus(ScriptErrorStatus status) {
		if (status.getCause() instanceof TeslaErrorStatus) {
			return (TeslaErrorStatus) status.getCause();
		}
		if (status.getCause() instanceof ScriptErrorStatus) {
			return extractTeslaStatus((ScriptErrorStatus) status.getCause());
		}
		return null;
	}

	public IQ7NamedElement getElement() {
		return element;
	}

	public void setElement(IQ7NamedElement element) {
		this.element = element;
	}

	public void updateLine(int actualLine) {
		setLine(actualLine);
		updateMessage();
	}
}
