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
package org.eclipse.rcptt.debug.impl;

import org.eclipse.rcptt.core.scenario.impl.ContextImpl;

import org.eclipse.rcptt.debug.BreakpointResource;
import org.eclipse.rcptt.debug.DebugContext;
import org.eclipse.rcptt.debug.DebugPackage;
import org.eclipse.rcptt.debug.Launch;
import org.eclipse.rcptt.debug.LaunchType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#isNoLaunches <em>No Launches</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#isNoBreakpoints <em>No Breakpoints</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#isNoLaunchShortcuts <em>No Launch Shortcuts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#getLaunchShortcutExceptions <em>Launch Shortcut Exceptions</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#getLaunchExceptions <em>Launch Exceptions</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#getBreakpointResources <em>Breakpoint Resources</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#getLaunches <em>Launches</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.DebugContextImpl#getLaunchTypes <em>Launch Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DebugContextImpl extends ContextImpl implements DebugContext {
	/**
	 * The default value of the '{@link #isNoLaunches() <em>No Launches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoLaunches()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_LAUNCHES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNoLaunches() <em>No Launches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoLaunches()
	 * @generated
	 * @ordered
	 */
	protected boolean noLaunches = NO_LAUNCHES_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoBreakpoints() <em>No Breakpoints</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoBreakpoints()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_BREAKPOINTS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNoBreakpoints() <em>No Breakpoints</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoBreakpoints()
	 * @generated
	 * @ordered
	 */
	protected boolean noBreakpoints = NO_BREAKPOINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoLaunchShortcuts() <em>No Launch Shortcuts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoLaunchShortcuts()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_LAUNCH_SHORTCUTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoLaunchShortcuts() <em>No Launch Shortcuts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoLaunchShortcuts()
	 * @generated
	 * @ordered
	 */
	protected boolean noLaunchShortcuts = NO_LAUNCH_SHORTCUTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaunchShortcutExceptions() <em>Launch Shortcut Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchShortcutExceptions()
	 * @generated
	 * @ordered
	 */
	protected static final String LAUNCH_SHORTCUT_EXCEPTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLaunchShortcutExceptions() <em>Launch Shortcut Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchShortcutExceptions()
	 * @generated
	 * @ordered
	 */
	protected String launchShortcutExceptions = LAUNCH_SHORTCUT_EXCEPTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaunchExceptions() <em>Launch Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchExceptions()
	 * @generated
	 * @ordered
	 */
	protected static final String LAUNCH_EXCEPTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLaunchExceptions() <em>Launch Exceptions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchExceptions()
	 * @generated
	 * @ordered
	 */
	protected String launchExceptions = LAUNCH_EXCEPTIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBreakpointResources() <em>Breakpoint Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakpointResources()
	 * @generated
	 * @ordered
	 */
	protected EList<BreakpointResource> breakpointResources;

	/**
	 * The cached value of the '{@link #getLaunches() <em>Launches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunches()
	 * @generated
	 * @ordered
	 */
	protected EList<Launch> launches;

	/**
	 * The cached value of the '{@link #getLaunchTypes() <em>Launch Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<LaunchType> launchTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebugContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DebugPackage.Literals.DEBUG_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoLaunches() {
		return noLaunches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoLaunches(boolean newNoLaunches) {
		boolean oldNoLaunches = noLaunches;
		noLaunches = newNoLaunches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_CONTEXT__NO_LAUNCHES, oldNoLaunches, noLaunches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoBreakpoints() {
		return noBreakpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoBreakpoints(boolean newNoBreakpoints) {
		boolean oldNoBreakpoints = noBreakpoints;
		noBreakpoints = newNoBreakpoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_CONTEXT__NO_BREAKPOINTS, oldNoBreakpoints, noBreakpoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoLaunchShortcuts() {
		return noLaunchShortcuts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoLaunchShortcuts(boolean newNoLaunchShortcuts) {
		boolean oldNoLaunchShortcuts = noLaunchShortcuts;
		noLaunchShortcuts = newNoLaunchShortcuts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS, oldNoLaunchShortcuts, noLaunchShortcuts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLaunchShortcutExceptions() {
		return launchShortcutExceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaunchShortcutExceptions(String newLaunchShortcutExceptions) {
		String oldLaunchShortcutExceptions = launchShortcutExceptions;
		launchShortcutExceptions = newLaunchShortcutExceptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS, oldLaunchShortcutExceptions, launchShortcutExceptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLaunchExceptions() {
		return launchExceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaunchExceptions(String newLaunchExceptions) {
		String oldLaunchExceptions = launchExceptions;
		launchExceptions = newLaunchExceptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_CONTEXT__LAUNCH_EXCEPTIONS, oldLaunchExceptions, launchExceptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BreakpointResource> getBreakpointResources() {
		if (breakpointResources == null) {
			breakpointResources = new EObjectContainmentEList<BreakpointResource>(BreakpointResource.class, this, DebugPackage.DEBUG_CONTEXT__BREAKPOINT_RESOURCES);
		}
		return breakpointResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Launch> getLaunches() {
		if (launches == null) {
			launches = new EObjectContainmentEList<Launch>(Launch.class, this, DebugPackage.DEBUG_CONTEXT__LAUNCHES);
		}
		return launches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LaunchType> getLaunchTypes() {
		if (launchTypes == null) {
			launchTypes = new EObjectContainmentEList<LaunchType>(LaunchType.class, this, DebugPackage.DEBUG_CONTEXT__LAUNCH_TYPES);
		}
		return launchTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DebugPackage.DEBUG_CONTEXT__BREAKPOINT_RESOURCES:
				return ((InternalEList<?>)getBreakpointResources()).basicRemove(otherEnd, msgs);
			case DebugPackage.DEBUG_CONTEXT__LAUNCHES:
				return ((InternalEList<?>)getLaunches()).basicRemove(otherEnd, msgs);
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_TYPES:
				return ((InternalEList<?>)getLaunchTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCHES:
				return isNoLaunches();
			case DebugPackage.DEBUG_CONTEXT__NO_BREAKPOINTS:
				return isNoBreakpoints();
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS:
				return isNoLaunchShortcuts();
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS:
				return getLaunchShortcutExceptions();
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_EXCEPTIONS:
				return getLaunchExceptions();
			case DebugPackage.DEBUG_CONTEXT__BREAKPOINT_RESOURCES:
				return getBreakpointResources();
			case DebugPackage.DEBUG_CONTEXT__LAUNCHES:
				return getLaunches();
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_TYPES:
				return getLaunchTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCHES:
				setNoLaunches((Boolean)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__NO_BREAKPOINTS:
				setNoBreakpoints((Boolean)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS:
				setNoLaunchShortcuts((Boolean)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS:
				setLaunchShortcutExceptions((String)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_EXCEPTIONS:
				setLaunchExceptions((String)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__BREAKPOINT_RESOURCES:
				getBreakpointResources().clear();
				getBreakpointResources().addAll((Collection<? extends BreakpointResource>)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCHES:
				getLaunches().clear();
				getLaunches().addAll((Collection<? extends Launch>)newValue);
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_TYPES:
				getLaunchTypes().clear();
				getLaunchTypes().addAll((Collection<? extends LaunchType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCHES:
				setNoLaunches(NO_LAUNCHES_EDEFAULT);
				return;
			case DebugPackage.DEBUG_CONTEXT__NO_BREAKPOINTS:
				setNoBreakpoints(NO_BREAKPOINTS_EDEFAULT);
				return;
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS:
				setNoLaunchShortcuts(NO_LAUNCH_SHORTCUTS_EDEFAULT);
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS:
				setLaunchShortcutExceptions(LAUNCH_SHORTCUT_EXCEPTIONS_EDEFAULT);
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_EXCEPTIONS:
				setLaunchExceptions(LAUNCH_EXCEPTIONS_EDEFAULT);
				return;
			case DebugPackage.DEBUG_CONTEXT__BREAKPOINT_RESOURCES:
				getBreakpointResources().clear();
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCHES:
				getLaunches().clear();
				return;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_TYPES:
				getLaunchTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCHES:
				return noLaunches != NO_LAUNCHES_EDEFAULT;
			case DebugPackage.DEBUG_CONTEXT__NO_BREAKPOINTS:
				return noBreakpoints != NO_BREAKPOINTS_EDEFAULT;
			case DebugPackage.DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS:
				return noLaunchShortcuts != NO_LAUNCH_SHORTCUTS_EDEFAULT;
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS:
				return LAUNCH_SHORTCUT_EXCEPTIONS_EDEFAULT == null ? launchShortcutExceptions != null : !LAUNCH_SHORTCUT_EXCEPTIONS_EDEFAULT.equals(launchShortcutExceptions);
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_EXCEPTIONS:
				return LAUNCH_EXCEPTIONS_EDEFAULT == null ? launchExceptions != null : !LAUNCH_EXCEPTIONS_EDEFAULT.equals(launchExceptions);
			case DebugPackage.DEBUG_CONTEXT__BREAKPOINT_RESOURCES:
				return breakpointResources != null && !breakpointResources.isEmpty();
			case DebugPackage.DEBUG_CONTEXT__LAUNCHES:
				return launches != null && !launches.isEmpty();
			case DebugPackage.DEBUG_CONTEXT__LAUNCH_TYPES:
				return launchTypes != null && !launchTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (noLaunches: ");
		result.append(noLaunches);
		result.append(", noBreakpoints: ");
		result.append(noBreakpoints);
		result.append(", noLaunchShortcuts: ");
		result.append(noLaunchShortcuts);
		result.append(", launchShortcutExceptions: ");
		result.append(launchShortcutExceptions);
		result.append(", launchExceptions: ");
		result.append(launchExceptions);
		result.append(')');
		return result.toString();
	}

} //DebugContextImpl
