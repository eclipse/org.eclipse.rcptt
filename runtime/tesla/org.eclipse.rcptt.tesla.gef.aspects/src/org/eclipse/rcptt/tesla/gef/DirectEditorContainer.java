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
package org.eclipse.rcptt.tesla.gef;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;

public class DirectEditorContainer {
	private DirectEditManager manager;

	public DirectEditorContainer(DirectEditManager mgr) {
		this.manager = mgr;
	}

	public DirectEditManager getManager() {
		return manager;
	}

	public void commit() {
		callVoidMethod("handleValueChanged");
		callVoidMethod("commit");
	}

	public void bringDown() {
		callVoidMethod("bringDown");
	}

	private void callVoidMethod(String methodName) {
		try {
			Method method = DirectEditManager.class.getDeclaredMethod(
					methodName, new Class<?>[0]);
			method.setAccessible(true);
			method.invoke(manager, new Object[0]);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CellEditor getCellEditor() {
		try {
			Method method = DirectEditManager.class.getDeclaredMethod(
					"getCellEditor", new Class<?>[0]);
			method.setAccessible(true);
			CellEditor editor = (CellEditor) method.invoke(manager,
					new Object[0]);
			return editor;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object getProperty(String name) {
		try {
			Field field = DirectEditManager.class.getDeclaredField(name);
			field.setAccessible(true);
			return field.get(manager);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void removeListeners() {
		CellEditor cellEditor = getCellEditor();
		Object listener = getProperty("cellEditorListener");
		Object source = getProperty("source");
		Object editPartListener = getProperty("editPartListener");
		if (listener != null) {
			cellEditor.removeListener((ICellEditorListener) listener);
		}
		if (source != null && editPartListener != null) {
			((GraphicalEditPart) source)
					.removeEditPartListener((EditPartListener) editPartListener);
		}
	}
}
