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
package org.eclipse.rcptt.ecl.perf;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @see org.eclipse.rcptt.ecl.perf.PerfFactory
 * @model kind="package"
 * @generated
 */
public interface PerfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "perf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/perf.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.perf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PerfPackage eINSTANCE = org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.perf.impl.PerfCounterImpl <em>Counter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.perf.impl.PerfCounterImpl
	 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getPerfCounter()
	 * @generated
	 */
	int PERF_COUNTER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERF_COUNTER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERF_COUNTER__DURATION = 1;

	/**
	 * The number of structural features of the '<em>Counter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERF_COUNTER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.perf.impl.StartTimeMeasureImpl <em>Start Time Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.perf.impl.StartTimeMeasureImpl
	 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getStartTimeMeasure()
	 * @generated
	 */
	int START_TIME_MEASURE = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIME_MEASURE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIME_MEASURE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIME_MEASURE__LABEL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Time Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIME_MEASURE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.perf.impl.StopTimeMeasureImpl <em>Stop Time Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.perf.impl.StopTimeMeasureImpl
	 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getStopTimeMeasure()
	 * @generated
	 */
	int STOP_TIME_MEASURE = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIME_MEASURE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIME_MEASURE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIME_MEASURE__LABEL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stop Time Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIME_MEASURE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.perf.impl.MeasureTimeImpl <em>Measure Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.perf.impl.MeasureTimeImpl
	 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getMeasureTime()
	 * @generated
	 */
	int MEASURE_TIME = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TIME__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TIME__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TIME__LABEL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TIME__DO = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Measure Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TIME_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl <em>Constrain Max</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl
	 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getConstrainMax()
	 * @generated
	 */
	int CONSTRAIN_MAX = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAIN_MAX__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAIN_MAX__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Counter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAIN_MAX__COUNTER = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAIN_MAX__PROPERTY = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAIN_MAX__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constrain Max</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAIN_MAX_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.perf.PerfCounter <em>Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counter</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.PerfCounter
	 * @generated
	 */
	EClass getPerfCounter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.PerfCounter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.PerfCounter#getName()
	 * @see #getPerfCounter()
	 * @generated
	 */
	EAttribute getPerfCounter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.PerfCounter#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.PerfCounter#getDuration()
	 * @see #getPerfCounter()
	 * @generated
	 */
	EAttribute getPerfCounter_Duration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.perf.StartTimeMeasure <em>Start Time Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Time Measure</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.StartTimeMeasure
	 * @generated
	 */
	EClass getStartTimeMeasure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.StartTimeMeasure#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.StartTimeMeasure#getLabel()
	 * @see #getStartTimeMeasure()
	 * @generated
	 */
	EAttribute getStartTimeMeasure_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.perf.StopTimeMeasure <em>Stop Time Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Time Measure</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.StopTimeMeasure
	 * @generated
	 */
	EClass getStopTimeMeasure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.StopTimeMeasure#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.StopTimeMeasure#getLabel()
	 * @see #getStopTimeMeasure()
	 * @generated
	 */
	EAttribute getStopTimeMeasure_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.perf.MeasureTime <em>Measure Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Time</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.MeasureTime
	 * @generated
	 */
	EClass getMeasureTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.MeasureTime#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.MeasureTime#getLabel()
	 * @see #getMeasureTime()
	 * @generated
	 */
	EAttribute getMeasureTime_Label();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.perf.MeasureTime#getDo <em>Do</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Do</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.MeasureTime#getDo()
	 * @see #getMeasureTime()
	 * @generated
	 */
	EReference getMeasureTime_Do();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.perf.ConstrainMax <em>Constrain Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrain Max</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.ConstrainMax
	 * @generated
	 */
	EClass getConstrainMax();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.perf.ConstrainMax#getCounter <em>Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Counter</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.ConstrainMax#getCounter()
	 * @see #getConstrainMax()
	 * @generated
	 */
	EReference getConstrainMax_Counter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.ConstrainMax#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.ConstrainMax#getProperty()
	 * @see #getConstrainMax()
	 * @generated
	 */
	EAttribute getConstrainMax_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.perf.ConstrainMax#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.perf.ConstrainMax#getValue()
	 * @see #getConstrainMax()
	 * @generated
	 */
	EAttribute getConstrainMax_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PerfFactory getPerfFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.perf.impl.PerfCounterImpl <em>Counter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.perf.impl.PerfCounterImpl
		 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getPerfCounter()
		 * @generated
		 */
		EClass PERF_COUNTER = eINSTANCE.getPerfCounter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERF_COUNTER__NAME = eINSTANCE.getPerfCounter_Name();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERF_COUNTER__DURATION = eINSTANCE.getPerfCounter_Duration();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.perf.impl.StartTimeMeasureImpl <em>Start Time Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.perf.impl.StartTimeMeasureImpl
		 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getStartTimeMeasure()
		 * @generated
		 */
		EClass START_TIME_MEASURE = eINSTANCE.getStartTimeMeasure();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute START_TIME_MEASURE__LABEL = eINSTANCE.getStartTimeMeasure_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.perf.impl.StopTimeMeasureImpl <em>Stop Time Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.perf.impl.StopTimeMeasureImpl
		 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getStopTimeMeasure()
		 * @generated
		 */
		EClass STOP_TIME_MEASURE = eINSTANCE.getStopTimeMeasure();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_TIME_MEASURE__LABEL = eINSTANCE.getStopTimeMeasure_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.perf.impl.MeasureTimeImpl <em>Measure Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.perf.impl.MeasureTimeImpl
		 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getMeasureTime()
		 * @generated
		 */
		EClass MEASURE_TIME = eINSTANCE.getMeasureTime();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TIME__LABEL = eINSTANCE.getMeasureTime_Label();

		/**
		 * The meta object literal for the '<em><b>Do</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_TIME__DO = eINSTANCE.getMeasureTime_Do();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl <em>Constrain Max</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl
		 * @see org.eclipse.rcptt.ecl.perf.impl.PerfPackageImpl#getConstrainMax()
		 * @generated
		 */
		EClass CONSTRAIN_MAX = eINSTANCE.getConstrainMax();

		/**
		 * The meta object literal for the '<em><b>Counter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAIN_MAX__COUNTER = eINSTANCE.getConstrainMax_Counter();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAIN_MAX__PROPERTY = eINSTANCE.getConstrainMax_Property();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAIN_MAX__VALUE = eINSTANCE.getConstrainMax_Value();

	}

} //PerfPackage
