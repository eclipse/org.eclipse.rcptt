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
package org.eclipse.rcptt.debug;

import org.eclipse.rcptt.core.scenario.Context;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#isNoLaunches <em>No Launches</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#isNoBreakpoints <em>No Breakpoints</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#isNoLaunchShortcuts <em>No Launch Shortcuts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#getLaunchShortcutExceptions <em>Launch Shortcut Exceptions</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#getLaunchExceptions <em>Launch Exceptions</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#getBreakpointResources <em>Breakpoint Resources</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#getLaunches <em>Launches</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.DebugContext#getLaunchTypes <em>Launch Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext()
 * @model
 * @generated
 */
public interface DebugContext extends Context {
	/**
	 * Returns the value of the '<em><b>No Launches</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Launches</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Launches</em>' attribute.
	 * @see #setNoLaunches(boolean)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_NoLaunches()
	 * @model default="true"
	 * @generated
	 */
	boolean isNoLaunches();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.DebugContext#isNoLaunches <em>No Launches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Launches</em>' attribute.
	 * @see #isNoLaunches()
	 * @generated
	 */
	void setNoLaunches(boolean value);

	/**
	 * Returns the value of the '<em><b>No Breakpoints</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Breakpoints</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Breakpoints</em>' attribute.
	 * @see #setNoBreakpoints(boolean)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_NoBreakpoints()
	 * @model default="true"
	 * @generated
	 */
	boolean isNoBreakpoints();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.DebugContext#isNoBreakpoints <em>No Breakpoints</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Breakpoints</em>' attribute.
	 * @see #isNoBreakpoints()
	 * @generated
	 */
	void setNoBreakpoints(boolean value);

	/**
	 * Returns the value of the '<em><b>No Launch Shortcuts</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Launch Shortcuts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Launch Shortcuts</em>' attribute.
	 * @see #setNoLaunchShortcuts(boolean)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_NoLaunchShortcuts()
	 * @model default="false"
	 * @generated
	 */
	boolean isNoLaunchShortcuts();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.DebugContext#isNoLaunchShortcuts <em>No Launch Shortcuts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Launch Shortcuts</em>' attribute.
	 * @see #isNoLaunchShortcuts()
	 * @generated
	 */
	void setNoLaunchShortcuts(boolean value);

	/**
	 * Returns the value of the '<em><b>Launch Shortcut Exceptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Launch Shortcut Exceptions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launch Shortcut Exceptions</em>' attribute.
	 * @see #setLaunchShortcutExceptions(String)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_LaunchShortcutExceptions()
	 * @model
	 * @generated
	 */
	String getLaunchShortcutExceptions();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.DebugContext#getLaunchShortcutExceptions <em>Launch Shortcut Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Launch Shortcut Exceptions</em>' attribute.
	 * @see #getLaunchShortcutExceptions()
	 * @generated
	 */
	void setLaunchShortcutExceptions(String value);

	/**
	 * Returns the value of the '<em><b>Launch Exceptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Launch Exceptions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launch Exceptions</em>' attribute.
	 * @see #setLaunchExceptions(String)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_LaunchExceptions()
	 * @model
	 * @generated
	 */
	String getLaunchExceptions();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.DebugContext#getLaunchExceptions <em>Launch Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Launch Exceptions</em>' attribute.
	 * @see #getLaunchExceptions()
	 * @generated
	 */
	void setLaunchExceptions(String value);

	/**
	 * Returns the value of the '<em><b>Breakpoint Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.debug.BreakpointResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Breakpoint Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Breakpoint Resources</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_BreakpointResources()
	 * @model containment="true"
	 * @generated
	 */
	EList<BreakpointResource> getBreakpointResources();

	/**
	 * Returns the value of the '<em><b>Launches</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.debug.Launch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Launches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launches</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_Launches()
	 * @model containment="true"
	 * @generated
	 */
	EList<Launch> getLaunches();

	/**
	 * Returns the value of the '<em><b>Launch Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.debug.LaunchType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Launch Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launch Types</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getDebugContext_LaunchTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<LaunchType> getLaunchTypes();

} // DebugContext
