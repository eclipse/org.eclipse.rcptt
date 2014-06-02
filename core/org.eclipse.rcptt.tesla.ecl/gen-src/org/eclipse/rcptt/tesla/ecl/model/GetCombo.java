/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Combo</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetCombo()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets combobox with defined parameter. If this combobox doesn\'t exist, then error is returned.' returns='link to the combobox' recorded='true' example='get-window \"Q7 Control Panel - Test\" | get-window \"Find/Replace\" | get-combo -after [get-label \"Replace with:\"] | get-property enablement | equals false'"
 * @generated
 */
public interface GetCombo extends Selector {
} // GetCombo
