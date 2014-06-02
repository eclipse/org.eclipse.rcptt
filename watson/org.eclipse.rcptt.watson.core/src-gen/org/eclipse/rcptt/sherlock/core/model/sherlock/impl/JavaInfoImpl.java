/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getRuntimeName <em>Runtime Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getRuntimeVersion <em>Runtime Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getMaxMemory <em>Max Memory</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getFreeMemory <em>Free Memory</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getTotalMemory <em>Total Memory</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaInfoImpl extends EObjectImpl implements JavaInfo {
	/**
	 * The default value of the '{@link #getRuntimeName() <em>Runtime Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeName()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNTIME_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuntimeName() <em>Runtime Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeName()
	 * @generated
	 * @ordered
	 */
	protected String runtimeName = RUNTIME_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuntimeVersion() <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNTIME_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuntimeVersion() <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeVersion()
	 * @generated
	 * @ordered
	 */
	protected String runtimeVersion = RUNTIME_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxMemory() <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxMemory() <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemory()
	 * @generated
	 * @ordered
	 */
	protected long maxMemory = MAX_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFreeMemory() <em>Free Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long FREE_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFreeMemory() <em>Free Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeMemory()
	 * @generated
	 * @ordered
	 */
	protected long freeMemory = FREE_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalMemory() <em>Total Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalMemory() <em>Total Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalMemory()
	 * @generated
	 * @ordered
	 */
	protected long totalMemory = TOTAL_MEMORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> args;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SherlockPackage.Literals.JAVA_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuntimeName() {
		return runtimeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeName(String newRuntimeName) {
		String oldRuntimeName = runtimeName;
		runtimeName = newRuntimeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_INFO__RUNTIME_NAME, oldRuntimeName, runtimeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuntimeVersion() {
		return runtimeVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeVersion(String newRuntimeVersion) {
		String oldRuntimeVersion = runtimeVersion;
		runtimeVersion = newRuntimeVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_INFO__RUNTIME_VERSION, oldRuntimeVersion, runtimeVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxMemory() {
		return maxMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMemory(long newMaxMemory) {
		long oldMaxMemory = maxMemory;
		maxMemory = newMaxMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_INFO__MAX_MEMORY, oldMaxMemory, maxMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFreeMemory() {
		return freeMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeMemory(long newFreeMemory) {
		long oldFreeMemory = freeMemory;
		freeMemory = newFreeMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_INFO__FREE_MEMORY, oldFreeMemory, freeMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalMemory() {
		return totalMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalMemory(long newTotalMemory) {
		long oldTotalMemory = totalMemory;
		totalMemory = newTotalMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_INFO__TOTAL_MEMORY, oldTotalMemory, totalMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getArgs() {
		if (args == null) {
			args = new EDataTypeUniqueEList<String>(String.class, this, SherlockPackage.JAVA_INFO__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<JavaProperty>(JavaProperty.class, this, SherlockPackage.JAVA_INFO__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SherlockPackage.JAVA_INFO__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case SherlockPackage.JAVA_INFO__RUNTIME_NAME:
				return getRuntimeName();
			case SherlockPackage.JAVA_INFO__RUNTIME_VERSION:
				return getRuntimeVersion();
			case SherlockPackage.JAVA_INFO__MAX_MEMORY:
				return getMaxMemory();
			case SherlockPackage.JAVA_INFO__FREE_MEMORY:
				return getFreeMemory();
			case SherlockPackage.JAVA_INFO__TOTAL_MEMORY:
				return getTotalMemory();
			case SherlockPackage.JAVA_INFO__ARGS:
				return getArgs();
			case SherlockPackage.JAVA_INFO__PROPERTIES:
				return getProperties();
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
			case SherlockPackage.JAVA_INFO__RUNTIME_NAME:
				setRuntimeName((String)newValue);
				return;
			case SherlockPackage.JAVA_INFO__RUNTIME_VERSION:
				setRuntimeVersion((String)newValue);
				return;
			case SherlockPackage.JAVA_INFO__MAX_MEMORY:
				setMaxMemory((Long)newValue);
				return;
			case SherlockPackage.JAVA_INFO__FREE_MEMORY:
				setFreeMemory((Long)newValue);
				return;
			case SherlockPackage.JAVA_INFO__TOTAL_MEMORY:
				setTotalMemory((Long)newValue);
				return;
			case SherlockPackage.JAVA_INFO__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends String>)newValue);
				return;
			case SherlockPackage.JAVA_INFO__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends JavaProperty>)newValue);
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
			case SherlockPackage.JAVA_INFO__RUNTIME_NAME:
				setRuntimeName(RUNTIME_NAME_EDEFAULT);
				return;
			case SherlockPackage.JAVA_INFO__RUNTIME_VERSION:
				setRuntimeVersion(RUNTIME_VERSION_EDEFAULT);
				return;
			case SherlockPackage.JAVA_INFO__MAX_MEMORY:
				setMaxMemory(MAX_MEMORY_EDEFAULT);
				return;
			case SherlockPackage.JAVA_INFO__FREE_MEMORY:
				setFreeMemory(FREE_MEMORY_EDEFAULT);
				return;
			case SherlockPackage.JAVA_INFO__TOTAL_MEMORY:
				setTotalMemory(TOTAL_MEMORY_EDEFAULT);
				return;
			case SherlockPackage.JAVA_INFO__ARGS:
				getArgs().clear();
				return;
			case SherlockPackage.JAVA_INFO__PROPERTIES:
				getProperties().clear();
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
			case SherlockPackage.JAVA_INFO__RUNTIME_NAME:
				return RUNTIME_NAME_EDEFAULT == null ? runtimeName != null : !RUNTIME_NAME_EDEFAULT.equals(runtimeName);
			case SherlockPackage.JAVA_INFO__RUNTIME_VERSION:
				return RUNTIME_VERSION_EDEFAULT == null ? runtimeVersion != null : !RUNTIME_VERSION_EDEFAULT.equals(runtimeVersion);
			case SherlockPackage.JAVA_INFO__MAX_MEMORY:
				return maxMemory != MAX_MEMORY_EDEFAULT;
			case SherlockPackage.JAVA_INFO__FREE_MEMORY:
				return freeMemory != FREE_MEMORY_EDEFAULT;
			case SherlockPackage.JAVA_INFO__TOTAL_MEMORY:
				return totalMemory != TOTAL_MEMORY_EDEFAULT;
			case SherlockPackage.JAVA_INFO__ARGS:
				return args != null && !args.isEmpty();
			case SherlockPackage.JAVA_INFO__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (runtimeName: ");
		result.append(runtimeName);
		result.append(", runtimeVersion: ");
		result.append(runtimeVersion);
		result.append(", maxMemory: ");
		result.append(maxMemory);
		result.append(", freeMemory: ");
		result.append(freeMemory);
		result.append(", totalMemory: ");
		result.append(totalMemory);
		result.append(", args: ");
		result.append(args);
		result.append(')');
		return result.toString();
	}

} //JavaInfoImpl
