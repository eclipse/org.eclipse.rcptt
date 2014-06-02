/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eclipse Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getException <em>Exception</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getFeatureGuess <em>Feature Guess</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getThreadName <em>Thread Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus()
 * @model
 * @generated
 */
public interface EclipseStatus extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<EclipseStatus> getChildren();

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_Code()
	 * @model
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' attribute.
	 * @see #setPlugin(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_Plugin()
	 * @model
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(int)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_Severity()
	 * @model
	 * @generated
	 */
	int getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(int value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(JavaException)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_Exception()
	 * @model containment="true"
	 * @generated
	 */
	JavaException getException();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(JavaException value);

	/**
	 * Returns the value of the '<em><b>Feature Guess</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Guess</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Guess</em>' attribute list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_FeatureGuess()
	 * @model
	 * @generated
	 */
	EList<String> getFeatureGuess();

	/**
	 * Returns the value of the '<em><b>Thread Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Name</em>' attribute.
	 * @see #setThreadName(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseStatus_ThreadName()
	 * @model
	 * @generated
	 */
	String getThreadName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus#getThreadName <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Name</em>' attribute.
	 * @see #getThreadName()
	 * @generated
	 */
	void setThreadName(String value);

} // EclipseStatus
