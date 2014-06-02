/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.expandbar.widgets;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.ui.Control;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expand Bar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.expandbar.widgets.ExpandBar#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.expandbar.widgets.WidgetsPackage#getExpandBar()
 * @model
 * @generated
 */
public interface ExpandBar extends Control {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.expandbar.widgets.ExpandItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipse.rcptt.expandbar.widgets.WidgetsPackage#getExpandBar_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpandItem> getItems();

} // ExpandBar
