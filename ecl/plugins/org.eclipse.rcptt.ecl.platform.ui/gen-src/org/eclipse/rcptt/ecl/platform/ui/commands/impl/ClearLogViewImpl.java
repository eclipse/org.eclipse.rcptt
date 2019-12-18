/*******************************************************************************
 * Copyright (c) 2014, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.platform.ui.commands.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.ecl.platform.ui.commands.ClearLogView;
import org.eclipse.rcptt.ecl.platform.ui.commands.CommandsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clear Log View</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ClearLogViewImpl extends CommandImpl implements ClearLogView {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClearLogViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandsPackage.Literals.CLEAR_LOG_VIEW;
	}

} //ClearLogViewImpl
