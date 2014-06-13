/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.interop.internal.commands;

import static org.eclipse.rcptt.ecl.interop.internal.EclInteropPlugin.error;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.interop.InvokeStatic;
import org.eclipse.rcptt.ecl.interop.internal.EclInteropPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.osgi.framework.Bundle;

public class InvokeStaticService implements ICommandService {
	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		InvokeStatic invokeStatic = (InvokeStatic) command;
		Bundle bundle = Platform.getBundle(invokeStatic.getPluginId());
		if (bundle == null) {
			return error("Can't find plugin %s", invokeStatic.getPluginId());
		}
		Class<?> class_;
		try {
			class_ = bundle.loadClass(invokeStatic.getClassName());
		} catch (ClassNotFoundException e) {
			return error(e, "Can't load class %s", invokeStatic.getClassName());
		}
		final Object[] args = invokeStatic.getArgs().toArray();
		final String name = invokeStatic.getMethodName();
		Object result = null;
		try {
			final Method method = InvokeService.matchMethod(class_, name, args);
			if (method == null) {
				if (args.length > 0) {
					return EclInteropPlugin.error("Method not found.");
				}
				result = getFieldValue(class_, name);
			} else {
				if ((method.getModifiers() & Modifier.STATIC) == 0) {
					return error("Method %s is not static", name);
				}
				result = method.invoke(null, args);
			}

		} catch (Exception e) {
			return error("%s: %s", e.getClass().getName(), e.getMessage());
		}

		if (result != null)
			context.getOutput().write(result);
		return Status.OK_STATUS;

	}

	private static Object getFieldValue(Class<?> class_, String name) throws CoreException {
		if (class_ == null) {
			throw new CoreException(error("method or field not fould"));
		}

		try {
			Field field = class_.getDeclaredField(name);
			if ((field.getModifiers() & Modifier.STATIC) == 0) {
				throw new CoreException(error("Field %s is not static", name));
			}
			// Can't be null -- NoSuchFieldException raised otherwise
			field.setAccessible(true);
			return field.get(null);
		} catch (IllegalArgumentException e) {
			// should not happen
			throw new CoreException(error(e, "Unexpected error getting field %s", name));
		} catch (SecurityException e) {
			throw new CoreException(error(e, "Unexpected error getting field %s", name));
		} catch (IllegalAccessException e) {
			throw new CoreException(error(e, "Unexpected error getting field %s", name));
		} catch (NoSuchFieldException e) {
			return getFieldValue(class_.getSuperclass(), name);
		}

	}

}
