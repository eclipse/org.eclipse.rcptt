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
package org.eclipse.swt.dnd;

import java.lang.reflect.Field;

public class DNDEventAdapter {
	private Object event;

	public DNDEventAdapter(Object event) {
		this.event = event;
	}

	public int getOperations() {
		return getInt("operations");
	}

	public int getFeedback() {
		return getInt("feedback");
	}

	public int getOffsetX() {
		return getInt("offsetX");
	}

	public int getOffsetY() {
		return getInt("offsetY");
	}

	public Object getDataType() {
		return getObject("dataType");
	}

	public Object getDataTypes() {
		return getObject("dataTypes");
	}

	public void setDataType(Object value) {
		setObject("dataType", value);
	}

	public void setDataTypes(Object value) {
		setObject("dataTypes", value);
	}

	public void setOperations(int value) {
		setInt("operations", value);
	}

	public void setFeedback(int value) {
		setInt("feedback", value);
	}

	public void setOffsetX(int value) {
		setInt("offsetX", value);
	}

	public void setOffsetY(int value) {
		setInt("offsetY", value);
	}

	private int getInt(String name) {
		Class<?> class1 = event.getClass();
		Field field;
		try {
			field = class1.getDeclaredField(name);
			field.setAccessible(true);
			Integer value = (Integer) field.get(event);
			return value.intValue();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private Object getObject(String name) {
		Class<?> class1 = event.getClass();
		Field field;
		try {
			field = class1.getDeclaredField(name);
			field.setAccessible(true);
			return field.get(event);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setInt(String name, int value) {
		Class<?> class1 = event.getClass();
		Field field;
		try {
			field = class1.getDeclaredField(name);
			field.setAccessible(true);
			field.set(event, Integer.valueOf(value));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void setObject(String name, Object value) {
		Class<?> class1 = event.getClass();
		Field field;
		try {
			field = class1.getDeclaredField(name);
			field.setAccessible(true);
			field.set(event, value);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static DNDEventAdapter createAdapter() {
		ClassLoader loader = DNDEventAdapter.class.getClassLoader();
		try {
			Class<?> class1 = loader.loadClass("org.eclipse.swt.internal.dnd.DNDEvent");
			Object instance = class1.newInstance();
			return new DNDEventAdapter(instance);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getEvent() {
		return event;
	}
}
