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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Drag Over</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragOver()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Emulates drag over event.' returns='value of <code>control</code> parameter' example='with [get-view \"Project Explorer\" | get-tree] {\n    select \"Project/t.test\"\n    get-item \"Project/t.test\" | drag-start 23 5\n    get-item \"Project/t.test\" | drag-enter 23 11 -detail copy\n    get-item \"Project/t.test\" | drag-over 23 11 -detail copy\n    get-item \"Project/q7.properties\" | drag-over 21 2 -detail copy\n    drag-over 70 84 -detail copy\n    get-item \"Project/file.csv\" | drag-over 19 0 -detail copy\n    get-item \"Project/context2.ctx\" | drag-over 18 0 -detail copy\n    drag-over 69 33 -detail copy\n    get-item \"Project/Folder\" | drag-over 18 11 -detail copy\n    get-item \"Project/t.test\" | drag-exit\n    get-item \"Project/Folder\" | drag-accept 18 11 -detail copy\n    drag-set-data\n    get-item \"Project/Folder\" | drop 18 11 -detail copy\n}'"
 * @generated
 */
public interface DragOver extends DragAction {
} // DragOver
