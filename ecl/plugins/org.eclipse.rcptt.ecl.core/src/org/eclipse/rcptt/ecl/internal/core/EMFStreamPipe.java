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
package org.eclipse.rcptt.ecl.internal.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.ecl.core.ConvertedToEMFPipe;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.util.ECLBinaryResourceImpl;
import org.eclipse.rcptt.ecl.runtime.IPipe;

public class EMFStreamPipe implements IPipe, IMarkeredPipe {

	private static final int CLOSE_PIPE_ID = 123;
	private static final int OBJECT_ID = 121;
	private final DataInputStream in;
	private final DataOutputStream out;
	private boolean closed = false;

	public EMFStreamPipe(InputStream in, OutputStream out) {
		this.in = new DataInputStream(in);
		this.out = new DataOutputStream(out);
	}

	public void reinit() {
		closed = false;
	}

	public void writeCloseMarker() throws CoreException {
		writeStatus(CLOSE_PIPE_ID);
	}

	public void closeNoWait() {
		closed = true;
	}

	public IPipe close(IStatus status) throws CoreException {
		// Ignore status
		// in.close();
		// out.close();
		if (!closed) {
			closed = true;
			try {
				int kind = this.in.readByte();
				if (CLOSE_PIPE_ID != kind) {
					Exception e = new Exception("Failed to close emf pipe");
					throw new CoreException(new Status(IStatus.ERROR,
							CorePlugin.PLUGIN_ID, e.getMessage() + "  ---- "
									+ "close", e));

				}
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR,
						CorePlugin.PLUGIN_ID, e.getMessage() + "  ---- "
								+ "close", e));
			}
		}
		return this;
	}

	public Object take(long timeout) throws CoreException {
		if (closed) {
			return null;
		}
		Resource r = new ECLBinaryResourceImpl();
		int size = 0;
		byte[] data = null;
		try {
			int kind = in.readByte();
			if (CLOSE_PIPE_ID == kind) {
				closed = true;
				return null;
			} else if (OBJECT_ID != kind) {
				throw new IOException("Failed to read object from stream");
			}
			size = in.readInt();
			if (size <= 0) {
				throw new IOException("Failed to read from stream");
			}
			data = new byte[size];
			in.readFully(data);
			ByteArrayInputStream bin = new ByteArrayInputStream(data);
			r.load(bin, getOptions());
			EObject eObject = r.getContents().get(0);
			if (eObject instanceof ConvertedToEMFPipe) {
				return EMFConverterManager.INSTANCE
						.fromEObject(((ConvertedToEMFPipe) eObject).getObject());
			} else {
				return eObject;
			}
		} catch (Throwable e) {
			if (e instanceof EOFException) {
				return new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
						"Connection is not Available", e);
			} else {
				throw new CoreException(new Status(IStatus.ERROR,
						CorePlugin.PLUGIN_ID, e.getMessage(), e));
			}

		}
	}

	private Map<String, Object> getOptions() {
		Map<String, Object> opts = new HashMap<String, Object>();
		return opts;
	}

	public IPipe write(Object object) throws CoreException {
		EObject eObject;
		if (object instanceof EObject) {
			eObject = (EObject) object;
		} else {
			ConvertedToEMFPipe converted = CoreFactory.eINSTANCE
					.createConvertedToEMFPipe();
			converted.setObject(EMFConverterManager.INSTANCE.toEObject(object));
			eObject = converted;
		}
		Resource r = new ECLBinaryResourceImpl();
		r.getContents().add(eObject);
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			r.save(bout, getOptions());
			out.writeByte(OBJECT_ID);
			out.writeInt(bout.size());
			bout.writeTo(out);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					CorePlugin.PLUGIN_ID, "Failed to write " + object,
					e));
		}
		return this;
	}

	private void writeStatus(int status) throws CoreException {
		try {
			out.writeByte(status);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					CorePlugin.PLUGIN_ID, e.getMessage() + "  ---- " + status,
					e));
		}
	}

	public boolean isClosed() {
		return closed;
	}
}
