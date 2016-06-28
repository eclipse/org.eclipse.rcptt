/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mark Download Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler#getHandler <em>Handler</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getMarkDownloadHandler()
 * @model
 * @generated
 */
public interface MarkDownloadHandler extends Command {
	/**
	 * Returns the value of the '<em><b>Handler</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handler</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getMarkDownloadHandler_Handler()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getHandler();

} // MarkDownloadHandler
