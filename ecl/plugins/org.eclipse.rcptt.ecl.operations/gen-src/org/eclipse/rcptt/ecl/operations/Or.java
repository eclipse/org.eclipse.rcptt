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
 * <em><b>Or</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Or#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getOr()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Computes the result of logical Or operation for passed arguments.' returns='<code>true</code> or <code>false</code>.' example='with [get-view \"Q7 Explorer\" | get-tree] {\n  if [or[get-item Project | get-property caption -raw | eq Project][get-property itemCount -raw | eq 1]] {\n    log -message \"One of two verifications passed\"\n  }\n}'"
 * @generated
 */
public interface Or extends Command {
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
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getOr_Args()
	 * @model lower="2" annotation=
	 *        "http://www.eclipse.org/ecl/docs description='Arguments to compute on.'"
	 * @generated
	 */
	EList<EObject> getArgs();

} // Or
