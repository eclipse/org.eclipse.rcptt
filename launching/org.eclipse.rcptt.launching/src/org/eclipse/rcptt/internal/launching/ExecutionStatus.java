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
package org.eclipse.rcptt.internal.launching;

import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ExecutionStatus extends MultiStatus {
	private int line = -1;
	private int column = -1;
	private int length = -1;

	private IQ7NamedElement element;

	private AdvancedInformation info;

	public ExecutionStatus(IStatus status) {
		super(status.getPlugin(), status.getCode(), new IStatus[]{status},
				status.getMessage(), status.getException());
		if (status instanceof ScriptErrorStatus) {
			ScriptErrorStatus ss = (ScriptErrorStatus) status;
			line = ss.getLine();
			column = ss.getColumn();
			length = ss.getLength();
		}
		if (status instanceof ExecutionStatus) {
			ExecutionStatus ss = (ExecutionStatus) status;
			line = ss.getLine();
			column = ss.getColumn();
			length = ss.getLength();
		}
	}

	public ExecutionStatus(int severity, String pluginId, String message) {
		super(pluginId, 0, message, null);
		setSeverity(severity);
	}

	public ExecutionStatus(int severity, String pluginId, int line, int column,
			int length) {
		super(pluginId, 0, String.format(
				"Execution failed on line %d at column %d", line, column), null);
		setSeverity(severity);
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

	private static final Predicate<IStatus> IS_FAILED = new Predicate<IStatus>() {

		@Override
		public boolean apply(IStatus input) {
			return !input.isOK();
		}
	};
	public IStatus getCause(boolean flatten) {
		IStatus cause = Iterables.tryFind(Arrays.asList(getChildren()), IS_FAILED).orNull();
		if (flatten && cause instanceof ExecutionStatus) {
			return ((ExecutionStatus) cause).getCause(flatten);
		}
		return cause;
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
