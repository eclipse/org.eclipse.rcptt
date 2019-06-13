/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.internal.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.EclException;
import org.eclipse.rcptt.ecl.core.EclStackTraceEntry;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.runtime.IEMFConverter;

public class ProcessStatusConverter implements
		IEMFConverter<IStatus, ProcessStatus> {

	public Class<IStatus> getJavaClass() {
		return IStatus.class;
	}

	public EClass getEClass() {
		return CorePackage.eINSTANCE.getProcessStatus();
	}

	public IStatus fromEObject(ProcessStatus ps) {
		Throwable th = null;
		EclException exception = ps.getException();
		if (exception != null) {
			th = getThrowable(exception);
		}
		if (!ps.getChildren().isEmpty()) {
			ArrayList<IStatus> children = new ArrayList<IStatus>(ps.getChildren().size());
			for (ProcessStatus child: ps.getChildren()) {
				try {
					children.add((IStatus) EMFConverterManager.INSTANCE.fromEObject(child));
				} catch (CoreException e) {
					CorePlugin.log(e.getStatus());
					children.add(e.getStatus());
				} catch (ClassCastException e) {
					CorePlugin.log(e);
					children.add(CorePlugin.err(e));
				}
			}
			return new MultiStatus(ps.getPluginId(), ps.getCode(), children.toArray(new IStatus[children.size()]),
					ps.getMessage(), th);
		} else {
			return new Status(ps.getSeverity(), ps.getPluginId(), ps.getCode(),
					ps.getMessage(), th);
		}
	}

	public static Throwable getThrowable(EclException exception) {
		if (exception == null)
			return null;
		Throwable th = null;
		try {
			// Try to restore stored exception.
			th = exception.getThrowable();
			if (!Objects.equals(th.getClass().getName(), exception.getClassName())) {
				throw new IllegalStateException(String.format("Bad class, expected: %s, actual: %s ", exception.getClassName(), th.getClass().getName()));
			}
		} catch (Throwable ee) {
			// Failed to restore exception, try to construct new one
			try {
				String className = exception.getClassName();
				Class<?> forName = Class.forName(className);
				try {
					Constructor<?> constructor = forName.getConstructor(
							String.class, Throwable.class);
					Throwable newInstance = (Throwable) constructor
							.newInstance(exception.getMessage(), getThrowable(exception.getCause()));
					th = newInstance;
				} catch (NoSuchMethodException  e) {
					if (exception.getStatus() == null)
						throw e;
					Constructor<?> constructor = forName.getConstructor(IStatus.class);
					Throwable newInstance = (Throwable) constructor
							.newInstance(toIStatus(exception.getStatus()), null);
					th = newInstance;
					th.addSuppressed(e);
				}
				th.addSuppressed(ee);
			} catch (Exception eee) {
				if (exception.getStatus() != null) {
					th = new CoreException(toIStatus(exception.getStatus()));
				} else {
					th = new Exception(exception.getMessage(), getThrowable(exception.getCause()));
				}
				th.addSuppressed(eee);
			}
		}
		if (th != null) {
			copyAttributesFromEObject(exception, th);
		}
		return th;
	}

	private static void copyAttributesFromEObject(EclException exception, Throwable newInstance) {
		EList<EclStackTraceEntry> list = exception.getStackTrace();
		if (list.size() > 0) {
			newInstance.setStackTrace(constructStack(list));
		}
	}

	private static StackTraceElement[] constructStack(EList<EclStackTraceEntry> list) {
		StackTraceElement[] stack = new StackTraceElement[list.size()];
		for (int i = 0; i < list.size(); i++) {
			EclStackTraceEntry entry = list.get(i);
			stack[i] = new StackTraceElement(entry.getDeclaringClass(),
					entry.getMethodName(), entry.getFileName(),
					entry.getLineNumber());
		}
		return stack;
	}

	public ProcessStatus toEObject(IStatus status) throws CoreException {
		ProcessStatus rv = CoreFactory.eINSTANCE.createProcessStatus();
		toEObject((IStatus) status, rv);
		return rv;
	}

	public static ProcessStatus toProcessStatus(IStatus status) {
		try {
			if (status == null)
				return null;
			return (ProcessStatus) EMFConverterManager.INSTANCE.toEObject(status);
		} catch (CoreException e) {
			try {
				return (ProcessStatus) EMFConverterManager.INSTANCE.toEObject(e.getStatus());
			} catch (CoreException e1) {
				CorePlugin.log(e1.getStatus());
				ProcessStatus ps = CoreFactory.eINSTANCE.createProcessStatus();
				ps.setSeverity(IStatus.ERROR);
				ps.setMessage("Failed to convert result status " + status.getClass().getName() + ". See AUT's log");
				ps.setPluginId(CorePlugin.PLUGIN_ID);
				return ps;
			}
		} catch (ClassCastException e) {
			return toProcessStatus(CorePlugin.err(e));
		}
	}

	public static IStatus toIStatus(ProcessStatus status) {
		try {
			return (IStatus) EMFConverterManager.INSTANCE.fromEObject(status);
		} catch (CoreException e) {
			try {
				return (IStatus) EMFConverterManager.INSTANCE.toEObject(e.getStatus());
			} catch (CoreException e1) {
				CorePlugin.log(e1.getStatus());
				return new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID, "Failed to convert result status. See IDE's log");
			}
		}
	}

	public static void toEObject(IStatus status, ProcessStatus ps) throws CoreException {
		ps.setCode(status.getCode());
		ps.setMessage(status.getMessage());
		ps.setPluginId(status.getPlugin());
		ps.setSeverity(status.getSeverity());
		Throwable exception = status.getException();
		if (exception != null) {
			ps.setException(toException(exception));
		}
		if (status.isMultiStatus()) {
			for (IStatus child : status.getChildren()) {
				ProcessStatus s;
				try {
					s = (ProcessStatus) EMFConverterManager.INSTANCE.toEObject(child);
				} catch (ClassCastException e) {
					s = CoreFactory.eINSTANCE.createProcessStatus();
					toEObject(CorePlugin.err(e), s);
				}
				ps.getChildren().add(s);
			}
		}
	}

	private static EclException toException(Throwable exception) {
		EclException ex = CoreFactory.eINSTANCE.createEclException();
		ex.setClassName(exception.getClass().getName());
		ex.setMessage(exception.getMessage());
		ex.setThrowable(exception);
		StackTraceElement[] elements = exception.getStackTrace();
		int index = 0;
		for (StackTraceElement ee : elements) {
			EclStackTraceEntry e = CoreFactory.eINSTANCE
					.createEclStackTraceEntry();
			e.setDeclaringClass(ee.getClassName());
			e.setFileName(ee.getFileName());
			e.setLineNumber(ee.getLineNumber());
			e.setMethodName(ee.getMethodName());
			e.setIndex(index++);
			e.setNativeMethod(ee.isNativeMethod());
			ex.getStackTrace().add(e);
		}
		Throwable cause = exception.getCause();
		if (cause != null) {
			ex.setCause(toException(cause));
		}
		if (exception instanceof CoreException) {
			ex.setStatus(toProcessStatus(((CoreException) exception).getStatus()));
		}
		return ex;
	}
}
