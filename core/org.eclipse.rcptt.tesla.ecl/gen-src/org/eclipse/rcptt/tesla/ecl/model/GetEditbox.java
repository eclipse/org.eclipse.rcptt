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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Editbox</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetEditbox()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets editbox with defined parameter. If this editbox doesn\'t exist, then error is returned.' returns='link to the editbox' recorded='true' example='get-view \"Execution View\" | get-editbox -after [get-label \"Message:\"] | get-property text | equals \"\" | verify-true'"
 * @generated
 */
public interface GetEditbox extends Selector {
} // GetEditbox
