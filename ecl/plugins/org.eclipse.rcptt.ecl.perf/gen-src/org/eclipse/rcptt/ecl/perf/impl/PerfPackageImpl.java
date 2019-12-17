/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.perf.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.ecl.perf.ConstrainMax;
import org.eclipse.rcptt.ecl.perf.MeasureTime;
import org.eclipse.rcptt.ecl.perf.PerfCounter;
import org.eclipse.rcptt.ecl.perf.PerfFactory;
import org.eclipse.rcptt.ecl.perf.PerfPackage;
import org.eclipse.rcptt.ecl.perf.StartTimeMeasure;
import org.eclipse.rcptt.ecl.perf.StopTimeMeasure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerfPackageImpl extends EPackageImpl implements PerfPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perfCounterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startTimeMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stopTimeMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainMaxEClass = null;

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
	 * @see org.eclipse.rcptt.ecl.perf.PerfPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PerfPackageImpl() {
		super(eNS_URI, PerfFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PerfPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PerfPackage init() {
		if (isInited) return (PerfPackage)EPackage.Registry.INSTANCE.getEPackage(PerfPackage.eNS_URI);

		// Obtain or create and register package
		PerfPackageImpl thePerfPackage = (PerfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PerfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PerfPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePerfPackage.createPackageContents();

		// Initialize created meta-data
		thePerfPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePerfPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PerfPackage.eNS_URI, thePerfPackage);
		return thePerfPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerfCounter() {
		return perfCounterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerfCounter_Name() {
		return (EAttribute)perfCounterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerfCounter_Duration() {
		return (EAttribute)perfCounterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartTimeMeasure() {
		return startTimeMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartTimeMeasure_Label() {
		return (EAttribute)startTimeMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStopTimeMeasure() {
		return stopTimeMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStopTimeMeasure_Label() {
		return (EAttribute)stopTimeMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureTime() {
		return measureTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureTime_Label() {
		return (EAttribute)measureTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureTime_Do() {
		return (EReference)measureTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstrainMax() {
		return constrainMaxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstrainMax_Counter() {
		return (EReference)constrainMaxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstrainMax_Property() {
		return (EAttribute)constrainMaxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstrainMax_Value() {
		return (EAttribute)constrainMaxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerfFactory getPerfFactory() {
		return (PerfFactory)getEFactoryInstance();
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
		perfCounterEClass = createEClass(PERF_COUNTER);
		createEAttribute(perfCounterEClass, PERF_COUNTER__NAME);
		createEAttribute(perfCounterEClass, PERF_COUNTER__DURATION);

		startTimeMeasureEClass = createEClass(START_TIME_MEASURE);
		createEAttribute(startTimeMeasureEClass, START_TIME_MEASURE__LABEL);

		stopTimeMeasureEClass = createEClass(STOP_TIME_MEASURE);
		createEAttribute(stopTimeMeasureEClass, STOP_TIME_MEASURE__LABEL);

		measureTimeEClass = createEClass(MEASURE_TIME);
		createEAttribute(measureTimeEClass, MEASURE_TIME__LABEL);
		createEReference(measureTimeEClass, MEASURE_TIME__DO);

		constrainMaxEClass = createEClass(CONSTRAIN_MAX);
		createEReference(constrainMaxEClass, CONSTRAIN_MAX__COUNTER);
		createEAttribute(constrainMaxEClass, CONSTRAIN_MAX__PROPERTY);
		createEAttribute(constrainMaxEClass, CONSTRAIN_MAX__VALUE);
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
		startTimeMeasureEClass.getESuperTypes().add(theCorePackage.getCommand());
		stopTimeMeasureEClass.getESuperTypes().add(theCorePackage.getCommand());
		measureTimeEClass.getESuperTypes().add(theCorePackage.getCommand());
		constrainMaxEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(perfCounterEClass, PerfCounter.class, "PerfCounter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerfCounter_Name(), ecorePackage.getEString(), "name", null, 0, 1, PerfCounter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerfCounter_Duration(), ecorePackage.getEInt(), "duration", null, 0, 1, PerfCounter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startTimeMeasureEClass, StartTimeMeasure.class, "StartTimeMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartTimeMeasure_Label(), ecorePackage.getEString(), "label", null, 0, 1, StartTimeMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stopTimeMeasureEClass, StopTimeMeasure.class, "StopTimeMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStopTimeMeasure_Label(), theEcorePackage.getEString(), "label", null, 0, 1, StopTimeMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureTimeEClass, MeasureTime.class, "MeasureTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasureTime_Label(), theEcorePackage.getEString(), "label", null, 0, 1, MeasureTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasureTime_Do(), theCorePackage.getCommand(), null, "do", null, 0, 1, MeasureTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constrainMaxEClass, ConstrainMax.class, "ConstrainMax", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainMax_Counter(), theEcorePackage.getEObject(), null, "counter", null, 0, 1, ConstrainMax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstrainMax_Property(), theEcorePackage.getEString(), "property", null, 0, 1, ConstrainMax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstrainMax_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, ConstrainMax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (startTimeMeasureEClass, 
		   source, 
		   new String[] {
			 "description", "Start measuring time with a certain counter name.",
			 "returns", "nothing",
			 "example", "start-time-measure MyCounter\r\n//Some ECL script\r\nstop-time-measure MyCounter | constrain-max duration 2000"
		   });		
		addAnnotation
		  (stopTimeMeasureEClass, 
		   source, 
		   new String[] {
			 "description", "Finishes measuring time. Writes to the output stream the object with fields name and duration, where the name is counterName, and duration - the execution in milliseconds.",
			 "returns", "object with fields name and the duration of execution in milliseconds",
			 "example", "start-time-measure MyCounter\r\n//Some ECL script\r\nstop-time-measure MyCounter | constrain-max duration 2000"
		   });		
		addAnnotation
		  (measureTimeEClass, 
		   source, 
		   new String[] {
			 "description", "Takes the name of the counter and the command on execution. Writes to the output stream the object with fields name and duration, where the name is counterName, and duration - the execution in milliseconds.",
			 "returns", "object with fields name and the duration of execution in milliseconds",
			 "example", "measure-time \"MyCounterName\" {\r\n   // some ECL script\r\n} | constrain-max duration 2000 \r\n// fail if the operation was more than 2 seconds with a message \r\n//Max constraint violation: \'MyCounterName\' duration is 100500 which is greater than 2000."
		   });		
		addAnnotation
		  (constrainMaxEClass, 
		   source, 
		   new String[] {
			 "description", "Takes a property name and a number. Reads from the input stream object, takes his property and compares with a defined value.",
			 "returns", "True if received number is less or equal to defined value. False if number is greater than defined value.",
			 "example", "measure-time \"MyCounterName\" {\r\n   // some ECL script\r\n} | constrain-max duration 2000 \r\n// fail if the operation was more than 2 seconds with a message \r\n//Max constraint violation: \'MyCounterName\' duration is 100500 which is greater than 2000."
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
		  (getConstrainMax_Counter(), 
		   source, 
		   new String[] {
		   });
	}

} //PerfPackageImpl
