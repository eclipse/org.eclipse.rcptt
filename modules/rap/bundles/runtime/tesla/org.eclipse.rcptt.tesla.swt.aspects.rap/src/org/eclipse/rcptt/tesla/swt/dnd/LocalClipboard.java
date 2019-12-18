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
package org.eclipse.rcptt.tesla.swt.dnd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.tesla.swt.aspects.rap.SWTAspectActivator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

public class LocalClipboard {
	private static final Integer SELECTION_CLIPBOARD = Integer.valueOf(2);
	private static final Integer CLIPBOARD = Integer.valueOf(1);

	private static class ContentEntry {
		public ContentEntry(Object[] objs, Transfer[] tr) {
			this.objects = objs;
			this.transfers = tr;
		}

		Object[] objects;
		Transfer[] transfers;
	}

	private static boolean useLocalClipboard = false;

	public static boolean isEnabled() {
		return useLocalClipboard;
	}

	private static Map<Integer, ContentEntry> contents = new HashMap<Integer, ContentEntry>();

	public synchronized static void setContents(Object[] data,
			Transfer[] dataTypes, int type) {
		if (data == null || dataTypes == null
				|| data.length != dataTypes.length || data.length == 0) {
			DND.error(SWT.ERROR_INVALID_ARGUMENT);
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null || dataTypes[i] == null
					|| !validate(data, dataTypes, i)) {
				DND.error(SWT.ERROR_INVALID_ARGUMENT);
			}
		}
		if ((type & DND.CLIPBOARD) != 0) {
			contents.put(CLIPBOARD, new ContentEntry(data, dataTypes));
		}
		if ((type & DND.SELECTION_CLIPBOARD) != 0) {
			contents.put(SELECTION_CLIPBOARD, new ContentEntry(data, dataTypes));
		}
	}

	private static boolean validate(Object[] data, Transfer[] dataTypes, int i) {
		try {
			Method validateMethod = Transfer.class.getDeclaredMethod(
					"validate", Object.class);
			validateMethod.setAccessible(true);
			return (Boolean) validateMethod.invoke(dataTypes[i], data[i]);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return false;
	}

	private synchronized static Object convert(Transfer tr, Object original) {
		try {
			Method javaToNative = Transfer.class.getDeclaredMethod(
					"javaToNative", Object.class, TransferData.class);
			javaToNative.setAccessible(true);
			Method nativeToJava = Transfer.class.getDeclaredMethod(
					"nativeToJava", TransferData.class);
			nativeToJava.setAccessible(true);

			TransferData[] types = tr.getSupportedTypes();
			for (TransferData transferData : types) {
				try {
					javaToNative.invoke(tr, original, transferData);
					Object result = nativeToJava.invoke(tr, transferData);
					if (result != null) {
						return result;
					}
				} catch (Throwable e) {
					// SWTAspectActivator.log(e);
				}
			}
			// Try to use clone
			// Try to use object itself
			if (original instanceof EObject) {
				return EcoreUtil.copy((EObject) original);
			}
			if (original instanceof Object[]) {
				Object[] o = (Object[]) original;
				Object[] result = new Object[o.length];
				for (int i = 0; i < result.length; i++) {
					result[i] = o[i];
					if (result[i] instanceof EObject) {
						result[i] = EcoreUtil.copy((EObject) result[i]);
					}
				}
				return result;
			}
			return original;

		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return null;
	}

	public synchronized static Object getContents(Transfer tr, int type) {
		Object result = null;
		if ((type & DND.CLIPBOARD) != 0) {
			ContentEntry entry = contents.get(CLIPBOARD);
			if (entry != null) {
				for (int i = 0; i < entry.transfers.length; i++) {
					if (entry.transfers[i].equals(tr)) {
						result = entry.objects[i];
					}
				}
			}
			if (result != null) {
				return convert(tr, result);
			}
		}
		if ((type & DND.SELECTION_CLIPBOARD) != 0) {
			ContentEntry entry = contents.get(SELECTION_CLIPBOARD);
			if (entry != null) {
				for (int i = 0; i < entry.transfers.length; i++) {
					if (entry.transfers[i].equals(tr)) {
						result = entry.objects[i];
					}
				}
			}
			if (result != null) {
				return convert(tr, result);
			}
		}

		return result;
	}

	public synchronized static TransferData[] getAvailableTypes(int type) {
		Set<TransferData> result = new HashSet<TransferData>();
		if ((type & DND.CLIPBOARD) != 0) {
			result.addAll(getClipboardTypes(CLIPBOARD));

		}
		if ((type & DND.SELECTION_CLIPBOARD) != 0) {
			result.addAll(getClipboardTypes(SELECTION_CLIPBOARD));
		}
		return result.toArray(new TransferData[result.size()]);
	}

	private synchronized static Set<TransferData> getClipboardTypes(
			Integer clipboard2) {
		ContentEntry contentEntry = contents.get(clipboard2);
		Set<TransferData> result = new HashSet<TransferData>();
		if (contentEntry != null && contentEntry.transfers != null) {
			for (int i = 0; i < contentEntry.transfers.length; i++) {
				TransferData[] types = contentEntry.transfers[i]
						.getSupportedTypes();
				if (types != null) {
					result.addAll(Arrays.asList(types));
				}
			}
		}
		return result;
	}

	private synchronized static Set<Transfer> getClipboardTransfers(
			Integer clipboard2) {
		ContentEntry contentEntry = contents.get(clipboard2);
		Set<Transfer> result = new HashSet<Transfer>();
		if (contentEntry != null && contentEntry.transfers != null) {
			result.addAll(Arrays.asList(contentEntry.transfers));
		}
		return result;
	}

	public synchronized static String[] getAvailableTypeNames(int type) {
		Set<Transfer> result = new HashSet<Transfer>();
		if ((type & DND.CLIPBOARD) != 0) {
			result.addAll(getClipboardTransfers(CLIPBOARD));

		}
		if ((type & DND.SELECTION_CLIPBOARD) != 0) {
			result.addAll(getClipboardTransfers(SELECTION_CLIPBOARD));
		}
		Set<String> names = new HashSet<String>();
		for (Transfer transferData : result) {
			try {
				String[] values = getTypeNames(transferData);
				if (values != null) {
					names.addAll(Arrays.asList(values));
				}
			} catch (Throwable e) {
				SWTAspectActivator.log(e);
			}
		}
		return names.toArray(new String[names.size()]);
	}

	private synchronized static String[] getTypeNames(Transfer transferData)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		Method method = TransferData.class.getDeclaredMethod("getTypeNames");
		method.setAccessible(true);
		String[] values = (String[]) method.invoke(transferData);
		return values;
	}

	public synchronized static void clearContents(int type) {
		if ((type & DND.CLIPBOARD) != 0) {
			contents.remove(CLIPBOARD);

		}
		if ((type & DND.SELECTION_CLIPBOARD) != 0) {
			contents.remove(SELECTION_CLIPBOARD);
		}
	}

	public static void setEnabled(boolean useInternalClipboard) {
		useLocalClipboard = useInternalClipboard;
	}
}
