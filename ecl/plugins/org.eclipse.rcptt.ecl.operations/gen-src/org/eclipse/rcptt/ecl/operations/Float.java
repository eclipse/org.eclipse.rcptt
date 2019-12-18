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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getFloat()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Converts its argument to float.' returns='&lt;p&gt;Returns float value or fails if value cannot be converted. &lt;code&gt;true&lt;/code&gt; is converted to &lt;code&gt;1.0&lt;/code&gt; and &lt;code&gt;false&lt;/code&gt; is converted to &lt;code&gt;0&lt;/code&gt;. This command uses &lt;code&gt;java.lang.Float.parseFloat&lt;/code&gt; method, but also supports a few additional text values for infinity:&lt;/p&gt;\n&lt;ul&gt;\n  &lt;li&gt;&lt;b&gt;+inf&lt;/b&gt; &amp;ndash; returns &lt;code&gt;Float.POSITIVE_INFINITY&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;&lt;b&gt;inf&lt;/b&gt; &amp;ndash; returns &lt;code&gt;Float.POSITIVE_INFINITY&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;&lt;b&gt;-inf&lt;/b&gt; &amp;ndash; returns &lt;code&gt;Float.NEGATIVE_INFINITY&lt;/code&gt;&lt;/li&gt;\n&lt;/ul&gt;'"
 * @generated
 */
public interface Float extends Convert {
} // Float
