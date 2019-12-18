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

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To List</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getToList()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Loads whole input pipe and returns a single EclList object, containing it.' example='emit 1 2 3 | to-list // same as list 1 2 3\nemit 1 2 3 | to-list | to-list // same as list [list 1 2 3]'"
 * @generated
 */
public interface ToList extends Command {
} // ToList
