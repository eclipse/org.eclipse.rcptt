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
package org.eclipse.rcptt.ecl.operations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getInt()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Converts its argument to int.' returns='Returns integer value or fails if value cannot be converted. &lt;code&gt;true&lt;/code&gt; is converted to &lt;code&gt;1&lt;/code&gt; and &lt;code&gt;false&lt;/code&gt; is converted to &lt;code&gt;0&lt;/code&gt;.' example='//verifies that the number of Stops it less then 3\nget-view \"Execution View\" | get-label -after [get-label \"Stops:\"] | get-text | int | lt 3 | verify-true'"
 * @generated
 */
public interface Int extends Convert {
} // Int
