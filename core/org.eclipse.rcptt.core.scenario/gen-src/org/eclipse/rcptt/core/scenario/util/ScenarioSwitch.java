/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.scenario.util;

import org.eclipse.rcptt.core.scenario.*;

import java.util.List;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage
 * @generated
 */
public class ScenarioSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScenarioPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioSwitch() {
		if (modelPackage == null) {
			modelPackage = ScenarioPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ScenarioPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.SCENARIO: {
				Scenario scenario = (Scenario)theEObject;
				T result = caseScenario(scenario);
				if (result == null) result = caseNamedElement(scenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.SCENARIO_PROPERTY: {
				ScenarioProperty scenarioProperty = (ScenarioProperty)theEObject;
				T result = caseScenarioProperty(scenarioProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.CONTEXT: {
				Context context = (Context)theEObject;
				T result = caseContext(context);
				if (result == null) result = caseNamedElement(context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.WORKBENCH_CONTEXT: {
				WorkbenchContext workbenchContext = (WorkbenchContext)theEObject;
				T result = caseWorkbenchContext(workbenchContext);
				if (result == null) result = caseContext(workbenchContext);
				if (result == null) result = caseNamedElement(workbenchContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.EDITOR: {
				Editor editor = (Editor)theEObject;
				T result = caseEditor(editor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.FILE_EDITOR: {
				FileEditor fileEditor = (FileEditor)theEObject;
				T result = caseFileEditor(fileEditor);
				if (result == null) result = caseEditor(fileEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.GROUP_CONTEXT: {
				GroupContext groupContext = (GroupContext)theEObject;
				T result = caseGroupContext(groupContext);
				if (result == null) result = caseContext(groupContext);
				if (result == null) result = caseNamedElement(groupContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.UNRESOLVED_CONTEXT: {
				UnresolvedContext unresolvedContext = (UnresolvedContext)theEObject;
				T result = caseUnresolvedContext(unresolvedContext);
				if (result == null) result = caseContext(unresolvedContext);
				if (result == null) result = caseNamedElement(unresolvedContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.ATTACHMENT: {
				Attachment attachment = (Attachment)theEObject;
				T result = caseAttachment(attachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.TEST_SUITE_ITEM: {
				TestSuiteItem testSuiteItem = (TestSuiteItem)theEObject;
				T result = caseTestSuiteItem(testSuiteItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.TEST_SUITE: {
				TestSuite testSuite = (TestSuite)theEObject;
				T result = caseTestSuite(testSuite);
				if (result == null) result = caseNamedElement(testSuite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.PROJECT_METADATA: {
				ProjectMetadata projectMetadata = (ProjectMetadata)theEObject;
				T result = caseProjectMetadata(projectMetadata);
				if (result == null) result = caseNamedElement(projectMetadata);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.SUPER_CONTEXT: {
				SuperContext superContext = (SuperContext)theEObject;
				T result = caseSuperContext(superContext);
				if (result == null) result = caseContext(superContext);
				if (result == null) result = caseNamedElement(superContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.VERIFICATION: {
				Verification verification = (Verification)theEObject;
				T result = caseVerification(verification);
				if (result == null) result = caseNamedElement(verification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.UNRESOLVED_VERIFICATION: {
				UnresolvedVerification unresolvedVerification = (UnresolvedVerification)theEObject;
				T result = caseUnresolvedVerification(unresolvedVerification);
				if (result == null) result = caseVerification(unresolvedVerification);
				if (result == null) result = caseNamedElement(unresolvedVerification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.WIDGET_VERIFICATION: {
				WidgetVerification widgetVerification = (WidgetVerification)theEObject;
				T result = caseWidgetVerification(widgetVerification);
				if (result == null) result = caseVerification(widgetVerification);
				if (result == null) result = caseNamedElement(widgetVerification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.CAPABILITY_CONTEXT: {
				CapabilityContext capabilityContext = (CapabilityContext)theEObject;
				T result = caseCapabilityContext(capabilityContext);
				if (result == null) result = caseContext(capabilityContext);
				if (result == null) result = caseNamedElement(capabilityContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM: {
				CapabilityContextItem capabilityContextItem = (CapabilityContextItem)theEObject;
				T result = caseCapabilityContextItem(capabilityContextItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenario(Scenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenarioProperty(ScenarioProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workbench Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workbench Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkbenchContext(WorkbenchContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditor(Editor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileEditor(FileEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupContext(GroupContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unresolved Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unresolved Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnresolvedContext(UnresolvedContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachment(Attachment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Suite Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Suite Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSuiteItem(TestSuiteItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Suite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Suite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSuite(TestSuite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Metadata</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectMetadata(ProjectMetadata object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperContext(SuperContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerification(Verification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unresolved Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unresolved Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnresolvedVerification(UnresolvedVerification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidgetVerification(WidgetVerification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapabilityContext(CapabilityContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability Context Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability Context Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapabilityContextItem(CapabilityContextItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ScenarioSwitch
