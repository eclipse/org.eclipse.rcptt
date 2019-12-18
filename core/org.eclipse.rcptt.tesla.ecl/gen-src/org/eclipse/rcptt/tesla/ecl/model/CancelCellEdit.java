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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cancel Cell Edit</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getCancelCellEdit()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Cancels cell editing.' returns='value of &lt;code&gt;control&lt;/code&gt; parameter' example='with [get-editor context | get-section Parameters | get-table] {\n    select \"Add new parameter\" | activate-cell-edit\n    get-editbox | set-text \"this text won\'t be applied\"\n    cancel-cell-edit\n   }'"
 * @generated
 */
public interface CancelCellEdit extends CellEdit {
} // CancelCellEdit
