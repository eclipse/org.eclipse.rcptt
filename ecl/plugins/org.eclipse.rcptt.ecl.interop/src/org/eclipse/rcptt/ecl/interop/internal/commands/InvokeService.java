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
package org.eclipse.rcptt.ecl.interop.internal.commands;

import static org.eclipse.rcptt.ecl.interop.internal.EclInteropPlugin.error;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.interop.Invoke;
import org.eclipse.rcptt.ecl.interop.InvokeUi;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public class InvokeService implements ICommandService {

	private static final Object NOT_CONVERTIBLE = new Object();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IStatus service(Command command, IProcess context)
			throws CoreException {

		final Invoke cmd = (Invoke) command;

		final Object object = cmd.getObject();
		if (object == null)
			return error("Null invocation target.");

		final Class class_ = object.getClass();
		final String name = cmd.getName();
		if (name == null || name.length() == 0)
			return error("Empty method name.");

		final Object[] args = cmd.getArgs().toArray();

		// --

		if (class_.isArray())
			return processArrayMethod(object, name, args, context.getOutput());

		// --

		Object result = null;
		try {
			final Method method = matchMethod(class_, name, args);
			if (method == null) {
				if (args.length > 0) {
					return error("Method not found.");
				}
				result = getFieldValue(class_, object, name);
			} else {

				if (object instanceof Widget || cmd instanceof InvokeUi) {
					Display display = object instanceof Widget ? ((Widget) object).getDisplay() : Display.getDefault();

					// no reason to go into generics here, everything is just Object
					RunnableFuture future = new FutureTask(new Callable() {
						public Object call() throws Exception {
							return method.invoke(object, args);
						}
					});

					display.syncExec(future);
					result = future.get();
				} else
					result = method.invoke(object, args);
			}

		} catch (Exception e) {
			return error(e, "%s: %s", e.getClass().getName(), e.getMessage());
		}

		if (result != null)
			context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	private static Object getFieldValue(Class<?> class_, Object object, String name) throws CoreException {
		if (class_ == null) {
			throw new CoreException(error("method or field not fould"));
		}

		try {
			Field field = class_.getDeclaredField(name);
			// Can't be null -- NoSuchFieldException raised otherwise
			field.setAccessible(true);
			return field.get(object);
		} catch (IllegalArgumentException e) {
			// should not happen
			throw new CoreException(error(e, "Unexpected error getting field %s", name));
		} catch (SecurityException e) {
			throw new CoreException(error(e, "Unexpected error getting field %s", name));
		} catch (IllegalAccessException e) {
			throw new CoreException(error(e, "Unexpected error getting field %s", name));
		} catch (NoSuchFieldException e) {
			return getFieldValue(class_.getSuperclass(), object, name);
		}

	}

	private static IStatus processArrayMethod(Object array, String name,
			Object[] args, IPipe out) throws CoreException {
		if (name.equals("get")) {
			if (args.length != 1)
				return error("Invalid number of arguments.");
			Object index = convert(int.class, args[0], true, true);
			if (index == NOT_CONVERTIBLE)
				return error("Invalid index type.");

			Object result = Array.get(array, (Integer) index);
			if (result != null)
				out.write(result);

			return Status.OK_STATUS;
		} else if (name.equals("set")) {
			if (args.length != 2)
				return error("Invalid number of arguments.");

			Object index = convert(int.class, args[0], true, true);
			if (index == NOT_CONVERTIBLE)
				return error("Invalid index type.");

			Object value = convert(array.getClass().getComponentType(),
					args[1], true, true);
			if (value == NOT_CONVERTIBLE)
				return error("Invalid value type.");

			Array.set(array, (Integer) index, value);

			return Status.OK_STATUS;
		} else if (name.equals("length")) {
			if (args.length != 0)
				return error("Invalid number of arguments.");

			out.write(Array.getLength(array));
			return Status.OK_STATUS;
		} else
			return error("Unknown array pseudo-method name.");
	}

	@SuppressWarnings("rawtypes")
	static Method matchMethod(Class class_, String name, Object[] args) {
		Method result = matchMethod(class_, name, args, false, false);
		if (result == null)
			result = matchMethod(class_, name, args, true, false);
		if (result == null)
			result = matchMethod(class_, name, args, true, true);
		return result;
	}

	/*
	 * TODO:
	 * 
	 * 1. Null handling. 2. Proper overloading resolution.
	 * 
	 * Standard says we must select the most "specific" method.
	 * 
	 * 3. What will happen if arrays passed?
	 * 
	 * Useful reading:
	 * http://geekexplains.blogspot.com/2009/06/choosing-most-specific
	 * -method-tricky.html
	 */
	@SuppressWarnings({ "rawtypes" })
	static Method matchMethod(Class class_, String name, Object[] args,
			boolean doWiden, boolean doNarrow) {
		final Method[] methods = class_.getMethods();

		for (Method m : methods) {
			if (!m.getName().equals(name))
				continue;

			final Class[] paramTypes = m.getParameterTypes();
			if (paramTypes.length != args.length)
				continue;

			boolean done = true;
			for (int i = 0; i < paramTypes.length; ++i) {
				if (convert(paramTypes[i], args[i], doWiden, doNarrow) == NOT_CONVERTIBLE) {
					done = false;
					break;
				}
			}

			if (done)
				return m;
		}

		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object convert(Class to, Object value, boolean doWiden,
			boolean doNarrow) {

		Class from = value.getClass();

		// if Java tells us it is convertible, let it go
		if (to.isAssignableFrom(from))
			return value;

		to = toPrimitive(to);
		from = toPrimitive(from);

		// if one of the types or both are not convertible to primitive,
		// we can not do anything about it
		if (to == null || from == null)
			return NOT_CONVERTIBLE;

		// always self assignable
		if (to == from)
			return value;

		if (doWiden) {
			// try to widen
			Object converted = widden(to, value);
			if (converted != NOT_CONVERTIBLE)
				return converted;
		}

		if (doNarrow) {
			// try to narrow
			Object converted = narrow(to, value);
			if (converted != NOT_CONVERTIBLE)
				return converted;
		}

		return NOT_CONVERTIBLE;
	}

	@SuppressWarnings("rawtypes")
	private static Object widden(Class to, Object value) {

		if (to == value.getClass())
			return value;
		if (to == toPrimitive(value.getClass()))
			return value;

		Number number = null;
		Character character = null;

		if (value instanceof Number)
			number = (Number) value;
		if (value instanceof Character)
			character = (Character) value;

		if (to == long.class) {
			if (value instanceof Byte || value instanceof Short
					|| value instanceof Integer)
				return new Long(number.longValue());
			else if (value instanceof Character)
				return new Long(character.charValue());
			else
				return NOT_CONVERTIBLE;
		}

		if (to == int.class) {
			if (value instanceof Byte || value instanceof Short)
				return new Integer(number.intValue());
			else if (value instanceof Character)
				return new Integer(character.charValue());
			else
				return NOT_CONVERTIBLE;
		}

		if (to == short.class) {
			if (value instanceof Byte)
				return new Short(number.shortValue());
			else
				return NOT_CONVERTIBLE;
		}

		if (to == byte.class) {
			return NOT_CONVERTIBLE; // nothing can be widened to byte
		}

		if (to == double.class) {
			if (value instanceof Byte || value instanceof Short
					|| value instanceof Integer || value instanceof Long
					|| value instanceof Float)
				return new Double(number.doubleValue());
			else if (value instanceof Character)
				return new Double(character.charValue());
			else
				return NOT_CONVERTIBLE;
		}

		if (to == float.class) {
			if (value instanceof Byte || value instanceof Short
					|| value instanceof Integer || value instanceof Long)
				return new Float(number.floatValue());
			else if (value instanceof Character)
				return new Float(character.charValue());
			else
				return NOT_CONVERTIBLE;
		}

		if (to == char.class) {
			return NOT_CONVERTIBLE; // nothing can be widened to char
		}

		return NOT_CONVERTIBLE;
	}

	@SuppressWarnings("rawtypes")
	private static Object narrow(Class to, Object value) {
		if (to == value.getClass())
			return value;
		if (to == toPrimitive(value.getClass()))
			return value;

		Number number = null;
		Character character = null;

		if (value instanceof Number)
			number = (Number) value;
		if (value instanceof Character)
			character = (Character) value;

		if (to == long.class) {
			if (value instanceof Number) {
				long l = number.longValue();
				double d = number.doubleValue();
				if (l == d && d >= Long.MIN_VALUE && d <= Long.MAX_VALUE)
					return new Long(l);
				else
					return NOT_CONVERTIBLE;
			} else
				return NOT_CONVERTIBLE;
		}

		if (to == int.class) {
			if (value instanceof Number) {
				long l = number.longValue();
				double d = number.doubleValue();
				if (l == d && l >= Integer.MIN_VALUE && l <= Integer.MAX_VALUE)
					return new Integer((int) l);
				else
					return NOT_CONVERTIBLE;
			} else
				return NOT_CONVERTIBLE;
		}

		if (to == short.class) {
			if (value instanceof Number) {
				long l = number.longValue();
				double d = number.doubleValue();
				if (l == d && l >= Short.MIN_VALUE && l <= Short.MAX_VALUE)
					return new Short((short) l);
				else
					return NOT_CONVERTIBLE;
			} else if (value instanceof Character) {
				char c = character.charValue();
				if (c >= Short.MIN_VALUE && c <= Short.MAX_VALUE)
					return new Short((short) c);
				else
					return NOT_CONVERTIBLE;
			} else
				return NOT_CONVERTIBLE;
		}

		if (to == byte.class) {
			if (value instanceof Number) {
				long l = number.longValue();
				double d = number.doubleValue();
				if (l == d && l >= Byte.MIN_VALUE && l <= Byte.MAX_VALUE)
					return new Byte((byte) l);
				else
					return NOT_CONVERTIBLE;
			} else if (value instanceof Character) {
				char c = character.charValue();
				if (c >= Byte.MIN_VALUE && c <= Byte.MAX_VALUE)
					return new Byte((byte) c);
				else
					return NOT_CONVERTIBLE;
			} else
				return NOT_CONVERTIBLE;
		}

		if (to == double.class) {
			return NOT_CONVERTIBLE; // double is the widest type in the world
		}

		if (to == float.class) {
			if (value instanceof Double) {
				double d = number.doubleValue();
				if (d >= Float.MIN_VALUE && d <= Float.MAX_VALUE)
					return new Float((float) d);
				else
					return NOT_CONVERTIBLE;
			} else
				return NOT_CONVERTIBLE;
		}

		if (to == char.class) {
			if (value instanceof Number) {
				long l = number.longValue();
				double d = number.doubleValue();
				if (l == d && l >= Character.MIN_VALUE
						&& l <= Character.MAX_VALUE)
					return new Character((char) l);
				else
					return NOT_CONVERTIBLE;
			} else
				return NOT_CONVERTIBLE;
		}

		return NOT_CONVERTIBLE;
	}

	@SuppressWarnings("rawtypes")
	private static Class toPrimitive(Class boxed) {
		if (boxed.isPrimitive())
			return boxed;

		if (boxed == Boolean.class)
			return boolean.class;
		if (boxed == Character.class)
			return char.class;
		if (boxed == Byte.class)
			return byte.class;
		if (boxed == Short.class)
			return short.class;
		if (boxed == Integer.class)
			return int.class;
		if (boxed == Long.class)
			return long.class;
		if (boxed == Float.class)
			return float.class;
		if (boxed == Double.class)
			return double.class;

		return null;
	}
}
