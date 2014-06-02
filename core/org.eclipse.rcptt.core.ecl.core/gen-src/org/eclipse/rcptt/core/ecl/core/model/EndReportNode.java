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
package org.eclipse.rcptt.core.ecl.core.model;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Report Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#getSnaphots <em>Snaphots</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#isTakeSnaphots <em>Take Snaphots</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getEndReportNode()
 * @model
 * @generated
 */
public interface EndReportNode extends Command {
	/**
	 * Returns the value of the '<em><b>Snaphots</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snaphots</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snaphots</em>' attribute list.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getEndReportNode_Snaphots()
	 * @model
	 * @generated
	 */
	EList<String> getSnaphots();

	/**
	 * Returns the value of the '<em><b>Take Snaphots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Take Snaphots</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Take Snaphots</em>' attribute.
	 * @see #setTakeSnaphots(boolean)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getEndReportNode_TakeSnaphots()
	 * @model
	 * @generated
	 */
	boolean isTakeSnaphots();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#isTakeSnaphots <em>Take Snaphots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Take Snaphots</em>' attribute.
	 * @see #isTakeSnaphots()
	 * @generated
	 */
	void setTakeSnaphots(boolean value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getEndReportNode_Properties()
	 * @model mapType="org.eclipse.rcptt.sherlock.core.model.sherlock.report.PropertyMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getProperties();

} // EndReportNode
