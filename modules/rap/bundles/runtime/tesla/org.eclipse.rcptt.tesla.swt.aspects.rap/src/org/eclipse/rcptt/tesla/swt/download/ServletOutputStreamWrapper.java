/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.download;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class ServletOutputStreamWrapper extends ServletOutputStream {

	private OutputStream realOutput;
	private OutputStream spyStream;
	private boolean closed = false;

	public ServletOutputStreamWrapper(OutputStream realOutput, OutputStream duplicateStream) {
		this.realOutput = realOutput;
		this.spyStream = duplicateStream;
	}

	@Override
	public void close() throws IOException {
		if (closed) {
			throw new IOException("This output stream has already been closed");
		}
		if (realOutput != null) {
			realOutput.flush();
			realOutput.close();
		}

		spyStream.flush();
		spyStream.close();

		closed = true;
	}

	@Override
	public void flush() throws IOException {
		if (closed) {
			throw new IOException("Cannot flush a closed output stream");
		}
		if (realOutput != null) {
			realOutput.flush();
		}
		spyStream.flush();
	}

	@Override
	public void write(int b) throws IOException {
		if (closed) {
			throw new IOException("Cannot write to a closed output stream");
		}
		if (realOutput != null) {
			realOutput.write((byte) b);
		}
		spyStream.write((byte) b);
	}

	@Override
	public void write(byte b[]) throws IOException {
		write(b, 0, b.length);
	}

	@Override
	public void write(byte b[], int off, int len) throws IOException {
		if (closed) {
			throw new IOException("Cannot write to a closed output stream");
		}
		if (realOutput != null) {
			realOutput.write(b, off, len);
		}
		spyStream.write(b, off, len);
	}

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
	}

}