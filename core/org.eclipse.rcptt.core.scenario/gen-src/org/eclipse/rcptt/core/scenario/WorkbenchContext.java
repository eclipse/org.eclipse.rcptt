/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workbench Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getPerspectiveId <em>Perspective Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isNoModalDialogs <em>No Modal Dialogs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isCloseEditors <em>Close Editors</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isResetPerspective <em>Reset Perspective</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isClearClipboard <em>Clear Clipboard</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext()
 * @model
 * @generated
 */
public interface WorkbenchContext extends Context {
	/**
	 * Returns the value of the '<em><b>Perspective Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perspective Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perspective Id</em>' attribute.
	 * @see #setPerspectiveId(String)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_PerspectiveId()
	 * @model
	 * @generated
	 */
	String getPerspectiveId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getPerspectiveId <em>Perspective Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perspective Id</em>' attribute.
	 * @see #getPerspectiveId()
	 * @generated
	 */
	void setPerspectiveId(String value);

	/**
	 * Returns the value of the '<em><b>No Modal Dialogs</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Modal Dialogs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Modal Dialogs</em>' attribute.
	 * @see #setNoModalDialogs(boolean)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_NoModalDialogs()
	 * @model default="true"
	 * @generated
	 */
	boolean isNoModalDialogs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isNoModalDialogs <em>No Modal Dialogs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Modal Dialogs</em>' attribute.
	 * @see #isNoModalDialogs()
	 * @generated
	 */
	void setNoModalDialogs(boolean value);

	/**
	 * Returns the value of the '<em><b>Close Editors</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Close Editors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Close Editors</em>' attribute.
	 * @see #setCloseEditors(boolean)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_CloseEditors()
	 * @model default="true"
	 * @generated
	 */
	boolean isCloseEditors();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isCloseEditors <em>Close Editors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Close Editors</em>' attribute.
	 * @see #isCloseEditors()
	 * @generated
	 */
	void setCloseEditors(boolean value);

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.Editor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' containment reference list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_Editors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_Views()
	 * @model
	 * @generated
	 */
	EList<String> getViews();

	/**
	 * Returns the value of the '<em><b>Reset Perspective</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset Perspective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Perspective</em>' attribute.
	 * @see #setResetPerspective(boolean)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_ResetPerspective()
	 * @model default="true"
	 * @generated
	 */
	boolean isResetPerspective();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isResetPerspective <em>Reset Perspective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Perspective</em>' attribute.
	 * @see #isResetPerspective()
	 * @generated
	 */
	void setResetPerspective(boolean value);

	/**
	 * Returns the value of the '<em><b>Clear Clipboard</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear Clipboard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Clipboard</em>' attribute.
	 * @see #setClearClipboard(boolean)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getWorkbenchContext_ClearClipboard()
	 * @model default="true"
	 * @generated
	 */
	boolean isClearClipboard();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isClearClipboard <em>Clear Clipboard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Clipboard</em>' attribute.
	 * @see #isClearClipboard()
	 * @generated
	 */
	void setClearClipboard(boolean value);

} // WorkbenchContext
