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
 * A representation of the model object '<em><b>Get Items</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetItems()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets item list of a table, or visible items of a tree, or visible children of a tree item.' returns='List of items.' example='get-view \"Q7 Explorer\" | get-tree | get-items | foreach {get-property caption -raw | str | log}'"
 * @generated
 */
public interface GetItems extends ControlCommand {
} // GetItems
