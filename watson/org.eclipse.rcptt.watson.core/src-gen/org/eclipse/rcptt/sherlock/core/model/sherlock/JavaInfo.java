/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeName <em>Runtime Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeVersion <em>Runtime Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getMaxMemory <em>Max Memory</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getFreeMemory <em>Free Memory</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getTotalMemory <em>Total Memory</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo()
 * @model
 * @generated
 */
public interface JavaInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Runtime Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Name</em>' attribute.
	 * @see #setRuntimeName(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_RuntimeName()
	 * @model
	 * @generated
	 */
	String getRuntimeName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeName <em>Runtime Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Name</em>' attribute.
	 * @see #getRuntimeName()
	 * @generated
	 */
	void setRuntimeName(String value);

	/**
	 * Returns the value of the '<em><b>Runtime Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Version</em>' attribute.
	 * @see #setRuntimeVersion(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_RuntimeVersion()
	 * @model
	 * @generated
	 */
	String getRuntimeVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeVersion <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Version</em>' attribute.
	 * @see #getRuntimeVersion()
	 * @generated
	 */
	void setRuntimeVersion(String value);

	/**
	 * Returns the value of the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Memory</em>' attribute.
	 * @see #setMaxMemory(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_MaxMemory()
	 * @model
	 * @generated
	 */
	long getMaxMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getMaxMemory <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Memory</em>' attribute.
	 * @see #getMaxMemory()
	 * @generated
	 */
	void setMaxMemory(long value);

	/**
	 * Returns the value of the '<em><b>Free Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Free Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Memory</em>' attribute.
	 * @see #setFreeMemory(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_FreeMemory()
	 * @model
	 * @generated
	 */
	long getFreeMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getFreeMemory <em>Free Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Free Memory</em>' attribute.
	 * @see #getFreeMemory()
	 * @generated
	 */
	void setFreeMemory(long value);

	/**
	 * Returns the value of the '<em><b>Total Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Memory</em>' attribute.
	 * @see #setTotalMemory(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_TotalMemory()
	 * @model
	 * @generated
	 */
	long getTotalMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getTotalMemory <em>Total Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Memory</em>' attribute.
	 * @see #getTotalMemory()
	 * @generated
	 */
	void setTotalMemory(long value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' attribute list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_Args()
	 * @model
	 * @generated
	 */
	EList<String> getArgs();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getJavaInfo_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<JavaProperty> getProperties();

} // JavaInfo
