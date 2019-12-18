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
package org.eclipse.rcptt.ecl.operations;


import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plus</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getPlus()
 * @model annotation="http://www.eclipse.org/ecl/docs description='&lt;p&gt;returns &lt;code&gt;left + right&lt;/code&gt;&lt;/p&gt;\n&lt;p&gt;Before performing an operation, arguments are converted to the widest type according to the following rules:&lt;/p&gt;\n&lt;ol&gt;\n  &lt;li&gt;&lt;code&gt;string&lt;/code&gt; arguments converted to &lt;code&gt;long&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;&lt;code&gt;boolean&lt;/code&gt; arguments converted to &lt;code&gt;long&lt;/code&gt; (1 for &lt;code&gt;true&lt;/code&gt; and 0 for &lt;code&gt;false&lt;/code&gt;)&lt;/li&gt;\n  &lt;li&gt;If one of arguments is &lt;code&gt;double&lt;/code&gt;, converts the other one to &lt;code&gt;double&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;If one of arguments is &lt;code&gt;float&lt;/code&gt;, converts the other one to &lt;code&gt;float&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;If one of arguments is &lt;code&gt;long&lt;/code&gt;, converts the other one to &lt;code&gt;long&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;Otherwise (in case of &lt;code&gt;byte&lt;/code&gt;, &lt;code&gt;char&lt;/code&gt;, or &lt;code&gt;short&lt;/code&gt;) converts both arguments to &lt;code&gt;int&lt;/code&gt;&lt;/li&gt;\n&lt;/ol&gt;\n' example='plus 10 3 | equals 13 | verify-true\nint 8 | plus 2 | equals 10 | assert-true \"8 + 2 not equals 10!\"'"
 * @generated
 */
public interface Plus extends BinaryOp {

} // Plus
