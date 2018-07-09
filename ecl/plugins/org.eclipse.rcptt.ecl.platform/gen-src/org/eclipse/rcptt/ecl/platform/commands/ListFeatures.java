/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.platform.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Features</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsPackage#getListFeatures()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Returns list of all features.' returns='Lists all available features. ' example='list-features | foreach [val item]  {\n\tif [$item | get id | matches \"com.xored.q7.*\"]{\n    \t\t$item | get name | log\n\t}\n}'"
 * @generated
 */
public interface ListFeatures extends Command {
} // ListFeatures
