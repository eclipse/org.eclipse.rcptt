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
package org.eclipse.rcptt.ecl.data.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.data.objects.Attribute;
import org.eclipse.rcptt.ecl.data.objects.Tree;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getTreeNode()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Creates a new tree node' returns='<code>Tree</code> EMF Object' example='tree-node \"Device\"\n\t[map [entry \"id\" \"1\"]]\n\t[tree-node -name \"DeviceName\" -text \"device\"]\n\t[tree-node -name \"DeviceTarget\" -text \"target\"]'"
 * @generated
 */
public interface TreeNode extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getTreeNode_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Name of the new node'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Attrs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attrs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attrs</em>' reference.
	 * @see #setAttrs(EclMap)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getTreeNode_Attrs()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Map with node attributes'"
	 * @generated
	 */
	EclMap getAttrs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getAttrs <em>Attrs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attrs</em>' reference.
	 * @see #getAttrs()
	 * @generated
	 */
	void setAttrs(EclMap value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.data.objects.Tree}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getTreeNode_Children()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Children of the new node'"
	 * @generated
	 */
	EList<Tree> getChildren();

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getTreeNode_Text()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Text of the new node'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // TreeNode
