/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getEncode <em>Encode</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getInput <em>Input</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getToString()
 * @model
 * @generated
 */
public interface ToString extends Command {
	/**
	 * Returns the value of the '<em><b>Encode</b></em>' attribute.
	 * The default value is <code>"UTF-8"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encode</em>' attribute.
	 * @see #setEncode(String)
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getToString_Encode()
	 * @model default="UTF-8"
	 * @generated
	 */
	String getEncode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getEncode <em>Encode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encode</em>' attribute.
	 * @see #getEncode()
	 * @generated
	 */
	void setEncode(String value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' reference.
	 * @see #setInput(EObject)
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getToString_Input()
	 * @model required="true"
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

} // ToString
