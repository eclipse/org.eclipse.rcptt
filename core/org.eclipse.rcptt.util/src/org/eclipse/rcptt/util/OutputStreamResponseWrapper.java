/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class OutputStreamResponseWrapper extends HttpServletResponseWrapper {
	protected HttpServletResponse origResponse = null;
	protected ByteArrayOutputStream duplicateOutput = null;
	protected ServletOutputStream stream = null;
	protected PrintWriter writer = null;
	private final boolean callRealOutputStream;

	public OutputStreamResponseWrapper(HttpServletResponse response, boolean callRealOutputStream) {
		super(response);
		origResponse = response;
		this.callRealOutputStream = callRealOutputStream;
	}

	public void finishResponse() {
		try {
			if (writer != null) {
				writer.close();
			} else {
				if (stream != null) {
					stream.close();
				}
			}
		} catch (IOException e) {
		}
	}

	@Override
	public void flushBuffer() throws IOException {
		stream.flush();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null) {
			throw new IllegalStateException("getOutputStream() has already been called!");
		}

		if (stream == null) {
			try {
				duplicateOutput = new ByteArrayOutputStream();
				OutputStream real = callRealOutputStream ? super.getOutputStream() : null;
				stream = new ServletOutputStreamWrapper(real, duplicateOutput);
			} catch (Exception ex) {
				throw new IOException("Unable to construct servlet output stream: " + ex.getMessage(), ex);
			}
		}
		return stream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return (writer);
		}

		if (stream != null) {
			throw new IllegalStateException("getOutputStream() has already been called!");
		}

		writer = new PrintWriter(new OutputStreamWriter(getOutputStream(), "UTF-8"));
		return (writer);
	}

	@Override
	public void setContentLength(int length) {
	}

	public ByteArrayOutputStream getSpyOutputStream() {
		return duplicateOutput;
	}
}