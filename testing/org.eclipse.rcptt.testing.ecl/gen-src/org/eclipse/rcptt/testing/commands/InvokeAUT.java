/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.testing.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke AUT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getVmargs <em>Vmargs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT()
 * @model
 * @generated
 */
public interface InvokeAUT extends Command {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' attribute.
	 * @see #setArgs(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Args()
	 * @model required="true"
	 * @generated
	 */
	String getArgs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getArgs <em>Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Args</em>' attribute.
	 * @see #getArgs()
	 * @generated
	 */
	void setArgs(String value);

	/**
	 * Returns the value of the '<em><b>Vmargs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vmargs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vmargs</em>' attribute.
	 * @see #setVmargs(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Vmargs()
	 * @model
	 * @generated
	 */
	String getVmargs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getVmargs <em>Vmargs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vmargs</em>' attribute.
	 * @see #getVmargs()
	 * @generated
	 */
	void setVmargs(String value);

} // InvokeAUT
