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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Label</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetLabel()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets label with defined text. If this label doesn\'t exist, then error is returned.' returns='link to the label' recorded='true' example='get-view \"Execution View\" | get-label -after [get-label \"Runs:\"] | get-property caption | equals \"3/3\" | verify-true'"
 * @generated
 */
public interface GetLabel extends TextSelector {
} // GetLabel
