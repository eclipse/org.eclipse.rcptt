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
package org.eclipse.rcptt.core.tests;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("rawtypes")
public class TestSupport {

	/**
	 * Runs the calling JUnit test again and fails only if it unexpectedly runs.<br>
	 * 
	 * This is helpful for tests that don't currently work but should work one
	 * day, when the tested functionality has been implemented.<br>
	 * 
	 * The right way to use it is:
	 * 
	 * <pre>
	 * public void testXXX() {
	 *   if (TestSupport.notYetImplemented(this)) return;
	 *   ... the real (now failing) unit test
	 * }
	 * </pre>
	 * 
	 * @return <false> when not itself already in the call stack
	 */
	@SuppressWarnings("unchecked")
	public static boolean notYetImplemented(TestCase caller) {
		if (notYetImplementedFlag.get() != null) {
			return false;
		}
		notYetImplementedFlag.set(Boolean.TRUE);

		final Method testMethod = findRunningJUnitTestMethod(caller.getClass());
		try {
			log("Running " + testMethod.getName() + " as not yet implemented");
			Object arg = null;
			testMethod.invoke(caller, arg);
			Assert
					.fail(testMethod.getName()
							+ " is marked as not yet implemented but passes unexpectedly");
		} catch (final Exception e) {
			log(testMethod.getName()
					+ " fails which is expected as it is not yet implemented");
		} finally {
			notYetImplementedFlag.set(null);
		}
		return true;
	}

	private static final boolean DEBUG = false;

	/**
	 * @param string
	 */
	private static void log(String message) {
		if (DEBUG) {
			System.out.println(message);
		}
	}

	/**
	 * Finds from the call stack the active running JUnit test case
	 * 
	 * @return the test case method
	 * @throws RuntimeException
	 *             if no method could be found.
	 */
	@SuppressWarnings("unchecked")
	private static Method findRunningJUnitTestMethod(Class caller) {
		// search the initial junit test
		final Throwable t = new Exception();
		for (int i = t.getStackTrace().length - 1; i >= 0; --i) {
			final StackTraceElement element = t.getStackTrace()[i];
			if (element.getClassName().equals(caller.getName())) {
				try {
					final Method m = caller.getMethod(element.getMethodName(),
							NO_PARAMS);
					if (isPublicTestMethod(m)) {
						return m;
					}
				} catch (final Exception e) {
					// can't access, ignore it
				}
			}
		}
		throw new RuntimeException(
				"No JUnit test case method found in call stack");
	}

	private static final Class[] NO_PARAMS = new Class[] {};

	/**
	 * Test if the method is a junit test.
	 * 
	 * @param method
	 *            the method
	 * @return <code>true</code> if this is a junit test.
	 */
	private static boolean isPublicTestMethod(final Method method) {
		return method.getParameterTypes().length == 0
				&& method.getName().startsWith("test")
				&& method.getReturnType().equals(Void.TYPE)
				&& Modifier.isPublic(method.getModifiers());
	}

	private static final ThreadLocal notYetImplementedFlag = new ThreadLocal();
}
