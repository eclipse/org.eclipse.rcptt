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
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getTeslaContent <em>Tesla Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getScenarioReferences <em>Scenario References</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#isRawSupported <em>Raw Supported</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getVerifications <em>Verifications</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.Scenario#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_Contexts()
	 * @model
	 * @generated
	 */
	EList<String> getContexts();

	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference.
	 * @see #setContent(EObject)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_Content()
	 * @model containment="true"
	 * @generated
	 */
	EObject getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.Scenario#getContent <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' containment reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(EObject value);

	/**
	 * Returns the value of the '<em><b>Tesla Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tesla Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tesla Content</em>' containment reference.
	 * @see #setTeslaContent(EObject)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_TeslaContent()
	 * @model containment="true"
	 * @generated
	 */
	EObject getTeslaContent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.Scenario#getTeslaContent <em>Tesla Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tesla Content</em>' containment reference.
	 * @see #getTeslaContent()
	 * @generated
	 */
	void setTeslaContent(EObject value);

	/**
	 * Returns the value of the '<em><b>Scenario References</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario References</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario References</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_ScenarioReferences()
	 * @model
	 * @generated
	 */
	EList<String> getScenarioReferences();

	/**
	 * Returns the value of the '<em><b>Raw Supported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Supported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Supported</em>' attribute.
	 * @see #setRawSupported(boolean)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_RawSupported()
	 * @model default="false"
	 * @generated
	 */
	boolean isRawSupported();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.Scenario#isRawSupported <em>Raw Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Supported</em>' attribute.
	 * @see #isRawSupported()
	 * @generated
	 */
	void setRawSupported(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.Scenario#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>External Reference</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Reference</em>' attribute.
	 * @see #setExternalReference(String)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_ExternalReference()
	 * @model default=""
	 * @generated
	 */
	String getExternalReference();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.Scenario#getExternalReference <em>External Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Reference</em>' attribute.
	 * @see #getExternalReference()
	 * @generated
	 */
	void setExternalReference(String value);

	/**
	 * Returns the value of the '<em><b>Verifications</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verifications</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verifications</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_Verifications()
	 * @model
	 * @generated
	 */
	EList<String> getVerifications();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.ScenarioProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getScenario_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<ScenarioProperty> getProperties();

} // Scenario
