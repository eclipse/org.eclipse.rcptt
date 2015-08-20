/**
 */
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Last Message Box</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetLastMessageBox()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets last shown MessageBox info. If MessageBox was not shown, then error is returned.' returns='MessageBoxInfo' example='set-dialog-result MessageBox 128\r\nget-view \"Q7 Quality Mockups\" | get-group \"MessageBox Test\" | get-button \"Message Box with YES/NO Buttons\" | click\r\nwith [get-last-message-box] {\r\n    get-property title | equals \"Warning\" | verify-true\r\n    get-property message | equals \"Yes or No?\" | verify-true\r\n}'"
 * @generated
 */
public interface GetLastMessageBox extends Command {
} // GetLastMessageBox
