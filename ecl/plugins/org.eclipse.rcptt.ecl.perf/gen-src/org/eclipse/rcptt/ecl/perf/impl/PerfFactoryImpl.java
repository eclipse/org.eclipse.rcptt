/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.ecl.perf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.ecl.perf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerfFactoryImpl extends EFactoryImpl implements PerfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PerfFactory init() {
		try {
			PerfFactory thePerfFactory = (PerfFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ecl/perf.ecore"); 
			if (thePerfFactory != null) {
				return thePerfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PerfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerfFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PerfPackage.PERF_COUNTER: return createPerfCounter();
			case PerfPackage.START_TIME_MEASURE: return createStartTimeMeasure();
			case PerfPackage.STOP_TIME_MEASURE: return createStopTimeMeasure();
			case PerfPackage.MEASURE_TIME: return createMeasureTime();
			case PerfPackage.CONSTRAIN_MAX: return createConstrainMax();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerfCounter createPerfCounter() {
		PerfCounterImpl perfCounter = new PerfCounterImpl();
		return perfCounter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartTimeMeasure createStartTimeMeasure() {
		StartTimeMeasureImpl startTimeMeasure = new StartTimeMeasureImpl();
		return startTimeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StopTimeMeasure createStopTimeMeasure() {
		StopTimeMeasureImpl stopTimeMeasure = new StopTimeMeasureImpl();
		return stopTimeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureTime createMeasureTime() {
		MeasureTimeImpl measureTime = new MeasureTimeImpl();
		return measureTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstrainMax createConstrainMax() {
		ConstrainMaxImpl constrainMax = new ConstrainMaxImpl();
		return constrainMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerfPackage getPerfPackage() {
		return (PerfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PerfPackage getPackage() {
		return PerfPackage.eINSTANCE;
	}

} //PerfFactoryImpl
