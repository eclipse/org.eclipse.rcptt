/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restart Aut</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getRestartAut()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Restarts AUT.\nCan be used if there in no File/Restart option in AUT.\n\nPlease note that &lt;a href=\"#wait-until-eclipse-is-ready\"&gt;wait-until-eclipse-is-ready&lt;/a&gt; command should be used \nimmidiately after restart-aut command. ' example='get-view \"Package Explorer\" | get-tree | get-menu \"New/Java Project\" | click\nwith [get-window \"New Java Project\"] {\n    with [get-editbox -after [get-label \"Project name:\"]] {\n        set-text MyProjec\n        set-text MyProject\n    }\n    get-button Finish | click\n}\n\nrestart-aut\n\nwait-until-eclipse-is-ready\n\nget-view \"Package Explorer\" | get-tree | get-property itemCount | equals 1 | verify-true'"
 * @generated
 */
public interface RestartAut extends Command {
} // RestartAut
