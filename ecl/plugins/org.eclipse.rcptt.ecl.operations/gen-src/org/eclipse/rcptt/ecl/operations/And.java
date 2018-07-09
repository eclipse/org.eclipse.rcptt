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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>And</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.And#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAnd()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Computes the result of logical And operation for passed arguments.' returns='&lt;code&gt;true&lt;/code&gt; or &lt;code&gt;false&lt;/code&gt;.' example='with [get-view \"Q7 Explorer\" | get-tree] {\n  if [and[get-item Project | get-property caption -raw | eq Project][get-property itemCount -raw | eq 1]] {\n    log -message \"Both verifications passed\"\n  }\n}'"
 * @generated
 */
public interface And extends Command {
	/**
	 * Returns the value of the '<em><b>Args</b></em>' reference list. The list
	 * contents are of type {@link org.eclipse.emf.ecore.EObject}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Args</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAnd_Args()
	 * @model lower="2" annotation=
	 *        "http://www.eclipse.org/ecl/docs description='Arguments to compute on.'"
	 * @generated
	 */
	EList<EObject> getArgs();

} // And
