/**
 */
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Switch#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Switch#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Switch#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Reads object from input pipe or <code>input</code> parameter and executes a <code>case</code> part with matching <code>condition</code> parameter (if any) sending <code>input</code> parameter as an input. If no <code>case</code> matched, the <code>default<code> block (if any) will be executed.' returns='An output of executed block (<code>case</code> command or <code>-default</code> block). If nothing is executed, no output will be produced.' example='list 1 2 3 | get 0 | switch [case 1 {\n\techo \"Found 1\"\n}] [case 2 {\n\techo \"Found 2\"\n}] - default {\n\techo \"Unknown item\"\n} | equals \"Found 1\" | verify-true'"
 * @generated
 */
public interface Switch extends Command {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Case}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch_Items()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='One or more <code>case</code> blocks. Block with a condition matching the input will be executed.'"
	 * @generated
	 */
	EList<Case> getItems();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Command)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch_Default()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Optional parameter. The block which will be executed in case no <code>case</code> block is executed.'"
	 * @generated
	 */
	Command getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Switch#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Command value);

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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch_Input()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='The input object to match.'"
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Switch#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

} // Switch
