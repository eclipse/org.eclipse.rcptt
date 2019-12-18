/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.tree;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capture Tree Verification Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData#getImages <em>Images</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCaptureTreeVerificationData()
 * @model
 * @generated
 */
public interface CaptureTreeVerificationData extends CommonTreeVerificationData {
	/**
	 * Returns the value of the '<em><b>Images</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link byte[]},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Images</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Images</em>' map.
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCaptureTreeVerificationData_Images()
	 * @model mapType="org.eclipse.rcptt.verifications.tree.ImagesMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EByteArray>"
	 * @generated
	 */
	EMap<String, byte[]> getImages();

} // CaptureTreeVerificationData
