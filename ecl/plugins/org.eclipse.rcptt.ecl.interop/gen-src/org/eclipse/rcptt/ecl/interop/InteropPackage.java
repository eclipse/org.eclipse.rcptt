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
package org.eclipse.rcptt.ecl.interop;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.ecl.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.interop.InteropFactory
 * @model kind="package"
 * @generated
 */
public interface InteropPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "interop";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/interop.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InteropPackage eINSTANCE = org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.interop.impl.InvokeImpl <em>Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.interop.impl.InvokeImpl
	 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getInvoke()
	 * @generated
	 */
	int INVOKE = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Args</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__ARGS = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl <em>Exec Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl
	 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getExecProcess()
	 * @generated
	 */
	int EXEC_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__COMMAND = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Args</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__ARGS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__TIMEOUT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ignore Exit Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__IGNORE_EXIT_CODE = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ignore Stderr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__IGNORE_STDERR = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Stdin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS__STDIN = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Exec Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessResultImpl <em>Exec Process Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.interop.impl.ExecProcessResultImpl
	 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getExecProcessResult()
	 * @generated
	 */
	int EXEC_PROCESS_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Exit Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS_RESULT__EXIT_CODE = 0;

	/**
	 * The feature id for the '<em><b>Stdout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS_RESULT__STDOUT = 1;

	/**
	 * The feature id for the '<em><b>Stderr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS_RESULT__STDERR = 2;

	/**
	 * The number of structural features of the '<em>Exec Process Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_PROCESS_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.interop.impl.GetMemoryUsageImpl <em>Get Memory Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.interop.impl.GetMemoryUsageImpl
	 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getGetMemoryUsage()
	 * @generated
	 */
	int GET_MEMORY_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MEMORY_USAGE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MEMORY_USAGE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Memory Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MEMORY_USAGE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.interop.impl.GetJavaPropertyImpl <em>Get Java Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.interop.impl.GetJavaPropertyImpl
	 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getGetJavaProperty()
	 * @generated
	 */
	int GET_JAVA_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_JAVA_PROPERTY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_JAVA_PROPERTY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_JAVA_PROPERTY__KEY = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_JAVA_PROPERTY__DEFAULT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Java Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_JAVA_PROPERTY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.interop.Invoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.Invoke
	 * @generated
	 */
	EClass getInvoke();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.Invoke#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.Invoke#getObject()
	 * @see #getInvoke()
	 * @generated
	 */
	EAttribute getInvoke_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.Invoke#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.Invoke#getName()
	 * @see #getInvoke()
	 * @generated
	 */
	EAttribute getInvoke_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.interop.Invoke#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Args</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.Invoke#getArgs()
	 * @see #getInvoke()
	 * @generated
	 */
	EAttribute getInvoke_Args();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.interop.ExecProcess <em>Exec Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Process</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess
	 * @generated
	 */
	EClass getExecProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcess#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess#getCommand()
	 * @see #getExecProcess()
	 * @generated
	 */
	EAttribute getExecProcess_Command();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.interop.ExecProcess#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Args</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess#getArgs()
	 * @see #getExecProcess()
	 * @generated
	 */
	EAttribute getExecProcess_Args();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcess#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess#getTimeout()
	 * @see #getExecProcess()
	 * @generated
	 */
	EAttribute getExecProcess_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcess#isIgnoreExitCode <em>Ignore Exit Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Exit Code</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess#isIgnoreExitCode()
	 * @see #getExecProcess()
	 * @generated
	 */
	EAttribute getExecProcess_IgnoreExitCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcess#isIgnoreStderr <em>Ignore Stderr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Stderr</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess#isIgnoreStderr()
	 * @see #getExecProcess()
	 * @generated
	 */
	EAttribute getExecProcess_IgnoreStderr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcess#getStdin <em>Stdin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stdin</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcess#getStdin()
	 * @see #getExecProcess()
	 * @generated
	 */
	EAttribute getExecProcess_Stdin();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult <em>Exec Process Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Process Result</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcessResult
	 * @generated
	 */
	EClass getExecProcessResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getExitCode <em>Exit Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exit Code</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcessResult#getExitCode()
	 * @see #getExecProcessResult()
	 * @generated
	 */
	EAttribute getExecProcessResult_ExitCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStdout <em>Stdout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stdout</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStdout()
	 * @see #getExecProcessResult()
	 * @generated
	 */
	EAttribute getExecProcessResult_Stdout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStderr <em>Stderr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stderr</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStderr()
	 * @see #getExecProcessResult()
	 * @generated
	 */
	EAttribute getExecProcessResult_Stderr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.interop.GetMemoryUsage <em>Get Memory Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Memory Usage</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.GetMemoryUsage
	 * @generated
	 */
	EClass getGetMemoryUsage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty <em>Get Java Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Java Property</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.GetJavaProperty
	 * @generated
	 */
	EClass getGetJavaProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.GetJavaProperty#getKey()
	 * @see #getGetJavaProperty()
	 * @generated
	 */
	EAttribute getGetJavaProperty_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.rcptt.ecl.interop.GetJavaProperty#getDefault()
	 * @see #getGetJavaProperty()
	 * @generated
	 */
	EAttribute getGetJavaProperty_Default();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InteropFactory getInteropFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.interop.impl.InvokeImpl <em>Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.interop.impl.InvokeImpl
		 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getInvoke()
		 * @generated
		 */
		EClass INVOKE = eINSTANCE.getInvoke();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE__OBJECT = eINSTANCE.getInvoke_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE__NAME = eINSTANCE.getInvoke_Name();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE__ARGS = eINSTANCE.getInvoke_Args();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl <em>Exec Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl
		 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getExecProcess()
		 * @generated
		 */
		EClass EXEC_PROCESS = eINSTANCE.getExecProcess();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS__COMMAND = eINSTANCE.getExecProcess_Command();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS__ARGS = eINSTANCE.getExecProcess_Args();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS__TIMEOUT = eINSTANCE.getExecProcess_Timeout();

		/**
		 * The meta object literal for the '<em><b>Ignore Exit Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS__IGNORE_EXIT_CODE = eINSTANCE.getExecProcess_IgnoreExitCode();

		/**
		 * The meta object literal for the '<em><b>Ignore Stderr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS__IGNORE_STDERR = eINSTANCE.getExecProcess_IgnoreStderr();

		/**
		 * The meta object literal for the '<em><b>Stdin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS__STDIN = eINSTANCE.getExecProcess_Stdin();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessResultImpl <em>Exec Process Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.interop.impl.ExecProcessResultImpl
		 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getExecProcessResult()
		 * @generated
		 */
		EClass EXEC_PROCESS_RESULT = eINSTANCE.getExecProcessResult();

		/**
		 * The meta object literal for the '<em><b>Exit Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS_RESULT__EXIT_CODE = eINSTANCE.getExecProcessResult_ExitCode();

		/**
		 * The meta object literal for the '<em><b>Stdout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS_RESULT__STDOUT = eINSTANCE.getExecProcessResult_Stdout();

		/**
		 * The meta object literal for the '<em><b>Stderr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_PROCESS_RESULT__STDERR = eINSTANCE.getExecProcessResult_Stderr();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.interop.impl.GetMemoryUsageImpl <em>Get Memory Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.interop.impl.GetMemoryUsageImpl
		 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getGetMemoryUsage()
		 * @generated
		 */
		EClass GET_MEMORY_USAGE = eINSTANCE.getGetMemoryUsage();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.interop.impl.GetJavaPropertyImpl <em>Get Java Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.interop.impl.GetJavaPropertyImpl
		 * @see org.eclipse.rcptt.ecl.interop.impl.InteropPackageImpl#getGetJavaProperty()
		 * @generated
		 */
		EClass GET_JAVA_PROPERTY = eINSTANCE.getGetJavaProperty();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_JAVA_PROPERTY__KEY = eINSTANCE.getGetJavaProperty_Key();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_JAVA_PROPERTY__DEFAULT = eINSTANCE.getGetJavaProperty_Default();

	}

} //InteropPackage
