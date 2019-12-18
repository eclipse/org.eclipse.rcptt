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
package org.eclipse.rcptt.tesla.core.info;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Q7 Wait Info Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTick <em>Tick</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getClassNames <em>Class Names</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTypesNames <em>Types Names</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getInnerClassMap <em>Inner Class Map</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot()
 * @model
 * @generated
 */
public interface Q7WaitInfoRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infos</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infos</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot_Infos()
	 * @model containment="true"
	 * @generated
	 */
	EList<Q7WaitInfo> getInfos();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot_StartTime()
	 * @model
	 * @generated
	 */
	long getStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(long value);

	/**
	 * Returns the value of the '<em><b>Tick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tick</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tick</em>' attribute.
	 * @see #setTick(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot_Tick()
	 * @model
	 * @generated
	 */
	long getTick();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTick <em>Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tick</em>' attribute.
	 * @see #getTick()
	 * @generated
	 */
	void setTick(long value);

	/**
	 * Returns the value of the '<em><b>Class Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Names</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot_ClassNames()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getClassNames();

	/**
	 * Returns the value of the '<em><b>Types Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types Names</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot_TypesNames()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getTypesNames();

	/**
	 * Returns the value of the '<em><b>Inner Class Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Class Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Class Map</em>' map.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfoRoot_InnerClassMap()
	 * @model mapType="org.eclipse.rcptt.tesla.core.info.Q7WaitInfoInnerClassMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getInnerClassMap();

} // Q7WaitInfoRoot
