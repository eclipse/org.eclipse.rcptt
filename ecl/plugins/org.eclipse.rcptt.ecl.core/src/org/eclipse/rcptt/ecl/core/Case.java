/**
 */
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Case#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Case#getThen <em>Then</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getCase()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Corresponds command from <code>then</code> branch if an object from the <code>input</code> matches the <code>condition</code> object.' returns='An internal object describing the case.' example='list 1 2 3 | get 0 | switch [case 1 {\r\n\tlog -message \"First item is 1\"\r\n}] [case 2 {\n\tlog -message \"First item is 2\"\n}]'"
 * @generated
 */
public interface Case extends Command {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(EObject)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getCase_Condition()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Object used to match to the <code>input</code>. Accepted values are boolean, string (<code>true</code> when case-insensitive equals to <code>true</code>, <code>false</code> otherwise) and number (<code>0</code> for <code>false</code>, <code>true</code> otherwise). '"
	 * @generated
	 */
	EObject getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Case#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(EObject value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(Command)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getCase_Then()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Branch being executed when <code>input</code> matches the object specified in <code>condition</code>'"
	 * @generated
	 */
	Command getThen();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Case#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(Command value);

} // Case
