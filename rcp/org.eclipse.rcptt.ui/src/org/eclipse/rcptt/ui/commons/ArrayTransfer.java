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
package org.eclipse.rcptt.ui.commons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public abstract class ArrayTransfer extends ByteArrayTransfer {
	public ArrayTransfer() {
	}

	@Override
	protected void javaToNative(Object object, TransferData transferData) {
		if (!(object instanceof Object[])) {
			return;
		}
		Object[] objects = (Object[]) object;
		int count = objects.length;

		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objectOut = new ObjectOutputStream(out);

			objectOut.writeInt(count);

			for (int i = 0; i < objects.length; i++) {
				objectOut.writeObject(objects[i]);
			}

			objectOut.close();
			out.close();
			byte[] bytes = out.toByteArray();

			super.javaToNative(bytes, transferData);
		} catch (IOException e) {
			Q7UIPlugin.log(e);
		}
	}

	@Override
	protected Object nativeToJava(TransferData transferData) {
		byte[] bytes = (byte[]) super.nativeToJava(transferData);
		if (bytes == null)
			return null;

		try {
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(bytes));

			int count = in.readInt();
			Object[] objects = new Object[count];
			for (int i = 0; i < count; i++) {
				objects[i] = in.readObject();
			}
			in.close();
			return objects;
		} catch (ClassNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
}
