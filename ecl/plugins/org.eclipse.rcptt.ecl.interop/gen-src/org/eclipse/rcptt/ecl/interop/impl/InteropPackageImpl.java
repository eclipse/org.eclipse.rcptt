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
package org.eclipse.rcptt.ecl.interop.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.interop.ExecProcess;
import org.eclipse.rcptt.ecl.interop.ExecProcessResult;
import org.eclipse.rcptt.ecl.interop.GetJavaProperty;
import org.eclipse.rcptt.ecl.interop.GetMemoryUsage;
import org.eclipse.rcptt.ecl.interop.InteropFactory;
import org.eclipse.rcptt.ecl.interop.InteropPackage;
import org.eclipse.rcptt.ecl.interop.Invoke;
import org.eclipse.rcptt.ecl.interop.InvokeStatic;
import org.eclipse.rcptt.ecl.interop.InvokeUi;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteropPackageImpl extends EPackageImpl implements InteropPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execProcessResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getMemoryUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getJavaPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeStaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeUiEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
>>>>>>> 1.1
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InteropPackageImpl() {
		super(eNS_URI, InteropFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link InteropPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InteropPackage init() {
		if (isInited) return (InteropPackage)EPackage.Registry.INSTANCE.getEPackage(InteropPackage.eNS_URI);

		// Obtain or create and register package
		InteropPackageImpl theInteropPackage = (InteropPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InteropPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InteropPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInteropPackage.createPackageContents();

		// Initialize created meta-data
		theInteropPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInteropPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InteropPackage.eNS_URI, theInteropPackage);
		return theInteropPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvoke() {
		return invokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvoke_Object() {
		return (EAttribute)invokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvoke_Name() {
		return (EAttribute)invokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvoke_Args() {
		return (EAttribute)invokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvoke_NoResult() {
		return (EAttribute)invokeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecProcess() {
		return execProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcess_Command() {
		return (EAttribute)execProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcess_Args() {
		return (EAttribute)execProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcess_Timeout() {
		return (EAttribute)execProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcess_IgnoreExitCode() {
		return (EAttribute)execProcessEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcess_IgnoreStderr() {
		return (EAttribute)execProcessEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcess_Stdin() {
		return (EAttribute)execProcessEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecProcessResult() {
		return execProcessResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcessResult_ExitCode() {
		return (EAttribute)execProcessResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcessResult_Stdout() {
		return (EAttribute)execProcessResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecProcessResult_Stderr() {
		return (EAttribute)execProcessResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetMemoryUsage() {
		return getMemoryUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetJavaProperty() {
		return getJavaPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetJavaProperty_Key() {
		return (EAttribute)getJavaPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetJavaProperty_Default() {
		return (EAttribute)getJavaPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeStatic() {
		return invokeStaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeStatic_PluginId() {
		return (EAttribute)invokeStaticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeStatic_ClassName() {
		return (EAttribute)invokeStaticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeStatic_MethodName() {
		return (EAttribute)invokeStaticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeStatic_Args() {
		return (EAttribute)invokeStaticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeUi() {
		return invokeUiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteropFactory getInteropFactory() {
		return (InteropFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		invokeEClass = createEClass(INVOKE);
		createEAttribute(invokeEClass, INVOKE__OBJECT);
		createEAttribute(invokeEClass, INVOKE__NAME);
		createEAttribute(invokeEClass, INVOKE__ARGS);
		createEAttribute(invokeEClass, INVOKE__NO_RESULT);

		execProcessEClass = createEClass(EXEC_PROCESS);
		createEAttribute(execProcessEClass, EXEC_PROCESS__COMMAND);
		createEAttribute(execProcessEClass, EXEC_PROCESS__ARGS);
		createEAttribute(execProcessEClass, EXEC_PROCESS__TIMEOUT);
		createEAttribute(execProcessEClass, EXEC_PROCESS__IGNORE_EXIT_CODE);
		createEAttribute(execProcessEClass, EXEC_PROCESS__IGNORE_STDERR);
		createEAttribute(execProcessEClass, EXEC_PROCESS__STDIN);

		execProcessResultEClass = createEClass(EXEC_PROCESS_RESULT);
		createEAttribute(execProcessResultEClass, EXEC_PROCESS_RESULT__EXIT_CODE);
		createEAttribute(execProcessResultEClass, EXEC_PROCESS_RESULT__STDOUT);
		createEAttribute(execProcessResultEClass, EXEC_PROCESS_RESULT__STDERR);

		getMemoryUsageEClass = createEClass(GET_MEMORY_USAGE);

		getJavaPropertyEClass = createEClass(GET_JAVA_PROPERTY);
		createEAttribute(getJavaPropertyEClass, GET_JAVA_PROPERTY__KEY);
		createEAttribute(getJavaPropertyEClass, GET_JAVA_PROPERTY__DEFAULT);

		invokeStaticEClass = createEClass(INVOKE_STATIC);
		createEAttribute(invokeStaticEClass, INVOKE_STATIC__PLUGIN_ID);
		createEAttribute(invokeStaticEClass, INVOKE_STATIC__CLASS_NAME);
		createEAttribute(invokeStaticEClass, INVOKE_STATIC__METHOD_NAME);
		createEAttribute(invokeStaticEClass, INVOKE_STATIC__ARGS);

		invokeUiEClass = createEClass(INVOKE_UI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		invokeEClass.getESuperTypes().add(theCorePackage.getCommand());
		execProcessEClass.getESuperTypes().add(theCorePackage.getCommand());
		getMemoryUsageEClass.getESuperTypes().add(theCorePackage.getCommand());
		getJavaPropertyEClass.getESuperTypes().add(theCorePackage.getCommand());
		invokeStaticEClass.getESuperTypes().add(theCorePackage.getCommand());
		invokeUiEClass.getESuperTypes().add(this.getInvoke());

		// Initialize classes and features; add operations and parameters
		initEClass(invokeEClass, Invoke.class, "Invoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvoke_Object(), theEcorePackage.getEJavaObject(), "object", null, 1, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvoke_Name(), theEcorePackage.getEString(), "name", null, 1, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvoke_Args(), theEcorePackage.getEJavaObject(), "args", null, 0, -1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvoke_NoResult(), theEcorePackage.getEBoolean(), "noResult", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execProcessEClass, ExecProcess.class, "ExecProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExecProcess_Command(), theEcorePackage.getEString(), "command", null, 1, 1, ExecProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcess_Args(), theEcorePackage.getEString(), "args", null, 0, -1, ExecProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcess_Timeout(), theEcorePackage.getEInt(), "timeout", "60", 0, 1, ExecProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcess_IgnoreExitCode(), theEcorePackage.getEBoolean(), "ignoreExitCode", "false", 0, 1, ExecProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcess_IgnoreStderr(), theEcorePackage.getEBoolean(), "ignoreStderr", "false", 0, 1, ExecProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcess_Stdin(), theEcorePackage.getEString(), "stdin", null, 0, 1, ExecProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execProcessResultEClass, ExecProcessResult.class, "ExecProcessResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExecProcessResult_ExitCode(), theEcorePackage.getEInt(), "exitCode", null, 0, 1, ExecProcessResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcessResult_Stdout(), theEcorePackage.getEString(), "stdout", null, 0, 1, ExecProcessResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecProcessResult_Stderr(), theEcorePackage.getEString(), "stderr", null, 0, 1, ExecProcessResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getMemoryUsageEClass, GetMemoryUsage.class, "GetMemoryUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getJavaPropertyEClass, GetJavaProperty.class, "GetJavaProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetJavaProperty_Key(), theEcorePackage.getEString(), "key", null, 1, 1, GetJavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetJavaProperty_Default(), theEcorePackage.getEString(), "default", null, 0, 1, GetJavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeStaticEClass, InvokeStatic.class, "InvokeStatic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvokeStatic_PluginId(), theEcorePackage.getEString(), "pluginId", null, 0, 1, InvokeStatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeStatic_ClassName(), theEcorePackage.getEString(), "className", null, 0, 1, InvokeStatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeStatic_MethodName(), theEcorePackage.getEString(), "methodName", null, 0, 1, InvokeStatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeStatic_Args(), theEcorePackage.getEJavaObject(), "args", null, 0, -1, InvokeStatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeUiEClass, InvokeUi.class, "InvokeUi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/docs</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocsAnnotations() {
		String source = "http://www.eclipse.org/ecl/docs";	
		addAnnotation
		  (invokeEClass, 
		   source, 
		   new String[] {
			 "description", "Invokes method on Java object.",
			 "returns", "Value returned by method.",
			 "example", "get-eclipse-window | get-object | invoke setSize 700 700"
		   });	
		addAnnotation
		  (getInvoke_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to call the method on."
		   });	
		addAnnotation
		  (getInvoke_Name(), 
		   source, 
		   new String[] {
			 "description", "Name of the method to call. As a useful addtion, there are three pseudo-methods for arrays: <code>get <i>index</i></code>, <code>set <i>index value</i></code> and <code>length</code>."
		   });	
		addAnnotation
		  (getInvoke_Args(), 
		   source, 
		   new String[] {
			 "description", "Variable number of arguments to the method."
		   });	
		addAnnotation
		  (execProcessEClass, 
		   source, 
		   new String[] {
			 "description", "Executes shell command.",
			 "returns", "ExecProcessResult filled with execution results: exit code, captured stdout and stderr.",
			 "example", "exec-process \"\\\"C:\\\\Program Files\\\\Sikuli X\\\\Sikuli-IDE.exe\\\"\"\"-r\" [substitute-variables \"\\\"${resource_loc:sikuli/MistypeClassName.sikuli}\\\"\"]\"-s\"-ignoreExitCode"
		   });	
		addAnnotation
		  (getExecProcess_Command(), 
		   source, 
		   new String[] {
			 "description", "Shell command to execute."
		   });	
		addAnnotation
		  (getExecProcess_Args(), 
		   source, 
		   new String[] {
			 "description", "Arguments for the command."
		   });	
		addAnnotation
		  (getExecProcess_Timeout(), 
		   source, 
		   new String[] {
			 "description", "Timeout period in seconds. Use zero timeout (<code>-timeout 0</code>) for infinite timeout."
		   });	
		addAnnotation
		  (getExecProcess_IgnoreExitCode(), 
		   source, 
		   new String[] {
			 "description", "If set to true, command will not fail with error message if non-zero exit code returned."
		   });	
		addAnnotation
		  (getExecProcess_IgnoreStderr(), 
		   source, 
		   new String[] {
			 "description", "If set to true, command will not fail with error message if stderr is not empty."
		   });	
		addAnnotation
		  (getExecProcess_Stdin(), 
		   source, 
		   new String[] {
			 "description", "String to send to stdin of executed command."
		   });	
		addAnnotation
		  (getJavaPropertyEClass, 
		   source, 
		   new String[] {
			 "description", "Gets the Java system property indicated by the specified key.",
			 "returns", "The string value of the system property.",
			 "example", "get-java-property \"java.home\" | log"
		   });	
		addAnnotation
		  (getGetJavaProperty_Key(), 
		   source, 
		   new String[] {
			 "description", "The name of the system property."
		   });	
		addAnnotation
		  (getGetJavaProperty_Default(), 
		   source, 
		   new String[] {
			 "description", "Default value to use if there is no property with the key."
		   });	
		addAnnotation
		  (getInvokeStatic_Args(), 
		   source, 
		   new String[] {
			 "description", "Variable number of arguments to the method."
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/input</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInputAnnotations() {
		String source = "http://www.eclipse.org/ecl/input";	
		addAnnotation
		  (getInvoke_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExecProcess_Stdin(), 
		   source, 
		   new String[] {
		   });
	}

} // InteropPackageImpl
