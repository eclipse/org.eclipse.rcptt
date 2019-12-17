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
package org.eclipse.rcptt.core.internal.builder;

public class Q7Problem {
	private String message;
	private int line;
	private int offset;
	private int severity;
	private int length;
	private int id;

	public Q7Problem(String message, int line, int offset, int severity) {
		this.message = message;
		this.line = line;
		this.offset = offset;
		this.severity = severity;
		this.length = -1;
		this.id = -1;
	}

	public Q7Problem(String message, int line, int offset, int severity, int length, int id) {
		this(message, line, offset, severity);
		this.length = length;
		this.id = id;
	}

	public int getLine() {
		return line;
	}

	public String getMessage() {
		return message;
	}

	public int getSeverity() {
		return severity;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public int getSourceId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + line;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + offset;
		result = prime * result + severity;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Q7Problem other = (Q7Problem) obj;
		if (length != other.length)
			return false;
		if (line != other.line)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (offset != other.offset)
			return false;
		if (severity != other.severity)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
