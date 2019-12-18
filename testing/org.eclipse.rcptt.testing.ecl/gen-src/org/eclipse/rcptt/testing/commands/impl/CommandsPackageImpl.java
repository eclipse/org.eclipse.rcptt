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
package org.eclipse.rcptt.testing.commands.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.core.recording.NetworkRecorder;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.launching.injection.InjectionPackage;
import org.eclipse.rcptt.testing.commands.ApplyContext;
import org.eclipse.rcptt.testing.commands.CaptureContext;
import org.eclipse.rcptt.testing.commands.CleanSelfAUT;
import org.eclipse.rcptt.testing.commands.CommandsFactory;
import org.eclipse.rcptt.testing.commands.CommandsPackage;
import org.eclipse.rcptt.testing.commands.Eval;
import org.eclipse.rcptt.testing.commands.FindContexts;
import org.eclipse.rcptt.testing.commands.GetAut;
import org.eclipse.rcptt.testing.commands.GetGlobal;
import org.eclipse.rcptt.testing.commands.GetRecorder;
import org.eclipse.rcptt.testing.commands.InvokeAUT;
import org.eclipse.rcptt.testing.commands.SetFeature;
import org.eclipse.rcptt.testing.commands.SetGlobal;
import org.eclipse.rcptt.testing.commands.SiteInjection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandsPackageImpl extends EPackageImpl implements CommandsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getAutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeAUTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass findContextsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass captureContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applyContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getGlobalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setGlobalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cleanSelfAUTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siteInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType networkRecorderEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommandsPackageImpl() {
		super(eNS_URI, CommandsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CommandsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommandsPackage init() {
		if (isInited) return (CommandsPackage)EPackage.Registry.INSTANCE.getEPackage(CommandsPackage.eNS_URI);

		// Obtain or create and register package
		CommandsPackageImpl theCommandsPackage = (CommandsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommandsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommandsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		InjectionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCommandsPackage.createPackageContents();

		// Initialize created meta-data
		theCommandsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommandsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommandsPackage.eNS_URI, theCommandsPackage);
		return theCommandsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetAut() {
		return getAutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetAut_Name() {
		return (EAttribute)getAutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEval() {
		return evalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEval_AutId() {
		return (EAttribute)evalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEval_Script() {
		return (EAttribute)evalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetRecorder() {
		return getRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetFeature() {
		return setFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetFeature_Recorder() {
		return (EAttribute)setFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetFeature_Name() {
		return (EAttribute)setFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetFeature_Value() {
		return (EAttribute)setFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvokeAUT() {
		return invokeAUTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeAUT_Name() {
		return (EAttribute)invokeAUTEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeAUT_Args() {
		return (EAttribute)invokeAUTEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeAUT_Path() {
		return (EAttribute)invokeAUTEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvokeAUT_Vmargs() {
		return (EAttribute)invokeAUTEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvokeAUT_Inject() {
		return (EReference)invokeAUTEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFindContexts() {
		return findContextsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFindContexts_Type() {
		return (EAttribute)findContextsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaptureContext() {
		return captureContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaptureContext_Path() {
		return (EAttribute)captureContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaptureContext_Type() {
		return (EAttribute)captureContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplyContext() {
		return applyContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplyContext_Path() {
		return (EAttribute)applyContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetGlobal() {
		return getGlobalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetGlobal_Name() {
		return (EAttribute)getGlobalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetGlobal() {
		return setGlobalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetGlobal_Values() {
		return (EReference)setGlobalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetGlobal_Name() {
		return (EAttribute)setGlobalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCleanSelfAUT() {
		return cleanSelfAUTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSiteInjection() {
		return siteInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSiteInjection_Uri() {
		return (EAttribute)siteInjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSiteInjection_Unit() {
		return (EAttribute)siteInjectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNetworkRecorder() {
		return networkRecorderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsFactory getCommandsFactory() {
		return (CommandsFactory)getEFactoryInstance();
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
		getAutEClass = createEClass(GET_AUT);
		createEAttribute(getAutEClass, GET_AUT__NAME);

		evalEClass = createEClass(EVAL);
		createEAttribute(evalEClass, EVAL__AUT_ID);
		createEAttribute(evalEClass, EVAL__SCRIPT);

		getRecorderEClass = createEClass(GET_RECORDER);

		setFeatureEClass = createEClass(SET_FEATURE);
		createEAttribute(setFeatureEClass, SET_FEATURE__RECORDER);
		createEAttribute(setFeatureEClass, SET_FEATURE__NAME);
		createEAttribute(setFeatureEClass, SET_FEATURE__VALUE);

		invokeAUTEClass = createEClass(INVOKE_AUT);
		createEAttribute(invokeAUTEClass, INVOKE_AUT__NAME);
		createEAttribute(invokeAUTEClass, INVOKE_AUT__ARGS);
		createEAttribute(invokeAUTEClass, INVOKE_AUT__PATH);
		createEAttribute(invokeAUTEClass, INVOKE_AUT__VMARGS);
		createEReference(invokeAUTEClass, INVOKE_AUT__INJECT);

		findContextsEClass = createEClass(FIND_CONTEXTS);
		createEAttribute(findContextsEClass, FIND_CONTEXTS__TYPE);

		captureContextEClass = createEClass(CAPTURE_CONTEXT);
		createEAttribute(captureContextEClass, CAPTURE_CONTEXT__PATH);
		createEAttribute(captureContextEClass, CAPTURE_CONTEXT__TYPE);

		applyContextEClass = createEClass(APPLY_CONTEXT);
		createEAttribute(applyContextEClass, APPLY_CONTEXT__PATH);

		getGlobalEClass = createEClass(GET_GLOBAL);
		createEAttribute(getGlobalEClass, GET_GLOBAL__NAME);

		setGlobalEClass = createEClass(SET_GLOBAL);
		createEReference(setGlobalEClass, SET_GLOBAL__VALUES);
		createEAttribute(setGlobalEClass, SET_GLOBAL__NAME);

		cleanSelfAUTEClass = createEClass(CLEAN_SELF_AUT);

		siteInjectionEClass = createEClass(SITE_INJECTION);
		createEAttribute(siteInjectionEClass, SITE_INJECTION__URI);
		createEAttribute(siteInjectionEClass, SITE_INJECTION__UNIT);

		// Create data types
		networkRecorderEDataType = createEDataType(NETWORK_RECORDER);
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
		InjectionPackage theInjectionPackage = (InjectionPackage)EPackage.Registry.INSTANCE.getEPackage(InjectionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		getAutEClass.getESuperTypes().add(theCorePackage.getCommand());
		evalEClass.getESuperTypes().add(theCorePackage.getCommand());
		getRecorderEClass.getESuperTypes().add(theCorePackage.getCommand());
		setFeatureEClass.getESuperTypes().add(theCorePackage.getCommand());
		invokeAUTEClass.getESuperTypes().add(theCorePackage.getCommand());
		findContextsEClass.getESuperTypes().add(theCorePackage.getCommand());
		captureContextEClass.getESuperTypes().add(theCorePackage.getCommand());
		applyContextEClass.getESuperTypes().add(theCorePackage.getCommand());
		getGlobalEClass.getESuperTypes().add(theCorePackage.getCommand());
		setGlobalEClass.getESuperTypes().add(theCorePackage.getCommand());
		cleanSelfAUTEClass.getESuperTypes().add(theCorePackage.getCommand());
		siteInjectionEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(getAutEClass, GetAut.class, "GetAut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetAut_Name(), theEcorePackage.getEString(), "name", null, 1, 1, GetAut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evalEClass, Eval.class, "Eval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEval_AutId(), theEcorePackage.getEString(), "autId", null, 1, 1, Eval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEval_Script(), theEcorePackage.getEString(), "script", null, 1, 1, Eval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getRecorderEClass, GetRecorder.class, "GetRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setFeatureEClass, SetFeature.class, "SetFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetFeature_Recorder(), this.getNetworkRecorder(), "recorder", null, 1, 1, SetFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetFeature_Name(), theEcorePackage.getEString(), "name", null, 1, 1, SetFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetFeature_Value(), theEcorePackage.getEString(), "value", null, 1, 1, SetFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeAUTEClass, InvokeAUT.class, "InvokeAUT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvokeAUT_Name(), theEcorePackage.getEString(), "name", null, 1, 1, InvokeAUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeAUT_Args(), theEcorePackage.getEString(), "args", null, 1, 1, InvokeAUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeAUT_Path(), theEcorePackage.getEString(), "path", null, 0, 1, InvokeAUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvokeAUT_Vmargs(), theEcorePackage.getEString(), "vmargs", null, 0, 1, InvokeAUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvokeAUT_Inject(), theInjectionPackage.getEntry(), null, "inject", null, 0, -1, InvokeAUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(findContextsEClass, FindContexts.class, "FindContexts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFindContexts_Type(), theEcorePackage.getEString(), "type", null, 0, 1, FindContexts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(captureContextEClass, CaptureContext.class, "CaptureContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaptureContext_Path(), theEcorePackage.getEString(), "path", null, 0, 1, CaptureContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCaptureContext_Type(), theEcorePackage.getEString(), "type", null, 0, 1, CaptureContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applyContextEClass, ApplyContext.class, "ApplyContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplyContext_Path(), theEcorePackage.getEString(), "path", null, 0, 1, ApplyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getGlobalEClass, GetGlobal.class, "GetGlobal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetGlobal_Name(), theEcorePackage.getEString(), "name", null, 0, 1, GetGlobal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setGlobalEClass, SetGlobal.class, "SetGlobal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetGlobal_Values(), theEcorePackage.getEObject(), null, "values", null, 0, -1, SetGlobal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetGlobal_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SetGlobal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cleanSelfAUTEClass, CleanSelfAUT.class, "CleanSelfAUT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(siteInjectionEClass, SiteInjection.class, "SiteInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSiteInjection_Uri(), theEcorePackage.getEString(), "uri", null, 1, 1, SiteInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSiteInjection_Unit(), theEcorePackage.getEString(), "unit", null, 0, -1, SiteInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(networkRecorderEDataType, NetworkRecorder.class, "NetworkRecorder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/internal
		createInternalAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/internal</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInternalAnnotations() {
		String source = "http://www.eclipse.org/ecl/internal";		
		addAnnotation
		  (getAutEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (evalEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getRecorderEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (setFeatureEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (invokeAUTEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (findContextsEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (captureContextEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (applyContextEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (getGlobalEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (setGlobalEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (cleanSelfAUTEClass, 
		   source, 
		   new String[] {
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
		  (getEval_AutId(), 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (getSetFeature_Recorder(), 
		   source, 
		   new String[] {
		   });																	
		addAnnotation
		  (getSetGlobal_Values(), 
		   source, 
		   new String[] {
		   });	
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
		  (findContextsEClass, 
		   source, 
		   new String[] {
			 "description", "Searches for all contexts of a given type (or all if type is empty) and writes their paths to output pipe",
			 "returns", "List of context paths"
		   });			
		addAnnotation
		  (getFindContexts_Type(), 
		   source, 
		   new String[] {
			 "description", "Class name of context to find. When empty, all context types.\nPossible values:\n<ul>\n<li>WorkspaceContext</li>\n<li>WorkbenchContext</li>\n<li>GroupContext</li>\n<li>DebugContext</li>\n<li>EclContext</li>\n</ul>"
		   });		
		addAnnotation
		  (captureContextEClass, 
		   source, 
		   new String[] {
			 "description", "Captures context from AUT",
			 "returns", "Nothing"
		   });			
		addAnnotation
		  (getCaptureContext_Path(), 
		   source, 
		   new String[] {
			 "description", "Workspace-relative path of context"
		   });		
		addAnnotation
		  (getCaptureContext_Type(), 
		   source, 
		   new String[] {
			 "description", "Class name of context to apply. If context already exists, can be omitted. If context exists, but has another type, command fails\nPossible values:\n<ul>\n<li>WorkspaceContext</li>\n<li>WorkbenchContext</li>\n<li>GroupContext</li>\n<li>DebugContext</li>\n<li>EclContext</li>\n</ul>"
		   });		
		addAnnotation
		  (applyContextEClass, 
		   source, 
		   new String[] {
			 "description", "Searches for all contexts of a given type (or all if type is empty) and writes their paths to output pipe",
			 "returns", "List of context paths"
		   });			
		addAnnotation
		  (getApplyContext_Path(), 
		   source, 
		   new String[] {
			 "description", "Workspace-relative path of context"
		   });		
		addAnnotation
		  (getGlobalEClass, 
		   source, 
		   new String[] {
			 "description", "Gets value with a given key from global hash map",
			 "returns", "Value identified by given key"
		   });			
		addAnnotation
		  (setGlobalEClass, 
		   source, 
		   new String[] {
			 "description", "Stores value from input pipe into global hash map by given key",
			 "returns", "Value identified by given key"
		   });			
	}

} //CommandsPackageImpl
