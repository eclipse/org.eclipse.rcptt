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
package org.eclipse.rcptt.ecl.parser;

import java.util.ArrayList;
import java.util.List;

public class EclParserErrorCollector implements IEclParserErrorReporter {
	public static class EclError {
		private String header;
		private String message;
		private int start = -1;
		private int end = -1;

		public String getHeader() {
			return header;
		}

		public String getMessage() {
			return message;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public EclError(String hdr, String msg) {
			this.header = hdr;
			this.message = msg;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result
					+ ((header == null) ? 0 : header.hashCode());
			result = prime * result
					+ ((message == null) ? 0 : message.hashCode());
			result = prime * result + start;
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
			EclError other = (EclError) obj;
			if (end != other.end)
				return false;
			if (header == null) {
				if (other.header != null)
					return false;
			} else if (!header.equals(other.header))
				return false;
			if (message == null) {
				if (other.message != null)
					return false;
			} else if (!message.equals(other.message))
				return false;
			if (start != other.start)
				return false;
			return true;
		}

	}

	private List<EclError> errors = new ArrayList<EclError>();

	public EclError[] getErrors() {
		return this.errors.toArray(new EclError[this.errors.size()]);
	}

	public void reportError(String hdr, String msg) {
		this.errors.add(new EclError(hdr, msg));
	}

}
