/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.preferences;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Pref Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.preferences.ListPrefData#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.preferences.PreferencesPackage#getListPrefData()
 * @model
 * @generated
 */
public interface ListPrefData extends PrefData {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.eclipse.rcptt.preferences.PreferencesPackage#getListPrefData_Values()
	 * @model
	 * @generated
	 */
	EList<String> getValues();

} // ListPrefData
