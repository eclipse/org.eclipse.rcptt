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
 * A representation of the model object '<em><b>Get Toolbar</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetToolbar()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets toolbar with specified parameter. If toolbar doesn\'t exist, then error is returned.' returns='toolbar' recorded='true' example='get-window \"Q7 Control Panel - Test\" |   get-toolbar | get-menu Save | click &lt;br&gt; get-toolbar -index 11 | key-type \"M1+s\" '"
 * @generated
 */
public interface GetToolbar extends Selector {
} // GetToolbar
