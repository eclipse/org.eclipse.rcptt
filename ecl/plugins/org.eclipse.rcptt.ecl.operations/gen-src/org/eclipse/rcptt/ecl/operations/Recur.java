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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Recur#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getRecur()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Returns an execution to the beginning of <a href=\"#loop\">loop</a> command. Cannot be used outside of a loop.' example='// calc and show a sum of ints from 3 to 10\n\nloop [val result 0] [val i 3] {\n    if [$i | eq 10] {\n        show-alert [str [$result | plus $i]]\n    } -else {\n        recur [$result | plus $i] [$i | plus 1]\n    }\n}'"
 * @generated
 */
public interface Recur extends Command {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getRecur_Values()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='A list of new values for variables, declared in <code>loop</code> command. Value count must exactly match to corresponding val count of a <code>loop</code> command.'"
	 * @generated
	 */
	EList<EObject> getValues();

} // Recur
