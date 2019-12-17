/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.info;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Q7 Wait Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getLastTick <em>Last Tick</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getClassId <em>Class Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTypeId <em>Type Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTicks <em>Ticks</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getLastStartTime <em>Last Start Time</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo()
 * @model
 * @generated
 */
public interface Q7WaitInfo extends EObject {
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
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_StartTime()
	 * @model
	 * @generated
	 */
	long getStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(long value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_EndTime()
	 * @model
	 * @generated
	 */
	long getEndTime();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(long value);

	/**
	 * Returns the value of the '<em><b>Last Tick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Tick</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Tick</em>' attribute.
	 * @see #setLastTick(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_LastTick()
	 * @model
	 * @generated
	 */
	long getLastTick();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getLastTick <em>Last Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Tick</em>' attribute.
	 * @see #getLastTick()
	 * @generated
	 */
	void setLastTick(long value);

	/**
	 * Returns the value of the '<em><b>Class Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Id</em>' attribute.
	 * @see #setClassId(int)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_ClassId()
	 * @model
	 * @generated
	 */
	int getClassId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getClassId <em>Class Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Id</em>' attribute.
	 * @see #getClassId()
	 * @generated
	 */
	void setClassId(int value);

	/**
	 * Returns the value of the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Id</em>' attribute.
	 * @see #setTypeId(int)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_TypeId()
	 * @model
	 * @generated
	 */
	int getTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTypeId <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Id</em>' attribute.
	 * @see #getTypeId()
	 * @generated
	 */
	void setTypeId(int value);

	/**
	 * Returns the value of the '<em><b>Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ticks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ticks</em>' attribute.
	 * @see #setTicks(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_Ticks()
	 * @model
	 * @generated
	 */
	long getTicks();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTicks <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ticks</em>' attribute.
	 * @see #getTicks()
	 * @generated
	 */
	void setTicks(long value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_Duration()
	 * @model
	 * @generated
	 */
	long getDuration();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(long value);

	/**
	 * Returns the value of the '<em><b>Last Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Start Time</em>' attribute.
	 * @see #setLastStartTime(long)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getQ7WaitInfo_LastStartTime()
	 * @model
	 * @generated
	 */
	long getLastStartTime();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getLastStartTime <em>Last Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Start Time</em>' attribute.
	 * @see #getLastStartTime()
	 * @generated
	 */
	void setLastStartTime(long value);

} // Q7WaitInfo
