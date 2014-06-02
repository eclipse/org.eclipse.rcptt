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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DNDEventAdapter createAdapter() {
		ClassLoader loader = DNDEventAdapter.class.getClassLoader();
		try {
			Class<?> class1 = loader.loadClass("org.eclipse.swt.dnd.DNDEvent");
			// Constructor<?>[] constructors = class1.getConstructors();
			Object instance = class1.newInstance();
			return new DNDEventAdapter(instance);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object getEvent() {
		return event;
	}
}
