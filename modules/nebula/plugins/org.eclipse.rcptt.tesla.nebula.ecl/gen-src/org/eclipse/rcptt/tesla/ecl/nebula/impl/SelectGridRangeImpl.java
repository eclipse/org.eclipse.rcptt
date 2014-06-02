/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.ecl.nebula.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;

import org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage;
import org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select Grid Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectGridRangeImpl extends CommandImpl implements SelectGridRange {
	/**
	 * The cached value of the '{@link #getControl() <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControl()
	 * @generated
	 * @ordered
	 */
	protected ControlHandler control;

	/**
	 * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected static final Object FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Object from = FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #getTo() <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected static final Object TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Object to = TO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectGridRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NebulaPackage.Literals.SELECT_GRID_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlHandler getControl() {
		if (control != null && control.eIsProxy()) {
			InternalEObject oldControl = (InternalEObject)control;
			control = (ControlHandler)eResolveProxy(oldControl);
			if (control != oldControl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NebulaPackage.SELECT_GRID_RANGE__CONTROL, oldControl, control));
			}
		}
		return control;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlHandler basicGetControl() {
		return control;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControl(ControlHandler newControl) {
		ControlHandler oldControl = control;
		control = newControl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.SELECT_GRID_RANGE__CONTROL, oldControl, control));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(Object newFrom) {
		Object oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.SELECT_GRID_RANGE__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(Object newTo) {
		Object oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.SELECT_GRID_RANGE__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NebulaPackage.SELECT_GRID_RANGE__CONTROL:
				if (resolve) return getControl();
				return basicGetControl();
			case NebulaPackage.SELECT_GRID_RANGE__FROM:
				return getFrom();
			case NebulaPackage.SELECT_GRID_RANGE__TO:
				return getTo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NebulaPackage.SELECT_GRID_RANGE__CONTROL:
				setControl((ControlHandler)newValue);
				return;
			case NebulaPackage.SELECT_GRID_RANGE__FROM:
				setFrom(newValue);
				return;
			case NebulaPackage.SELECT_GRID_RANGE__TO:
				setTo(newValue);
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
			case NebulaPackage.SELECT_GRID_RANGE__CONTROL:
				setControl((ControlHandler)null);
				return;
			case NebulaPackage.SELECT_GRID_RANGE__FROM:
				setFrom(FROM_EDEFAULT);
				return;
			case NebulaPackage.SELECT_GRID_RANGE__TO:
				setTo(TO_EDEFAULT);
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
			case NebulaPackage.SELECT_GRID_RANGE__CONTROL:
				return control != null;
			case NebulaPackage.SELECT_GRID_RANGE__FROM:
				return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals(from);
			case NebulaPackage.SELECT_GRID_RANGE__TO:
				return TO_EDEFAULT == null ? to != null : !TO_EDEFAULT.equals(to);
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
		result.append(" (from: ");
		result.append(from);
		result.append(", to: ");
		result.append(to);
		result.append(')');
		return result.toString();
	}

} //SelectGridRangeImpl
