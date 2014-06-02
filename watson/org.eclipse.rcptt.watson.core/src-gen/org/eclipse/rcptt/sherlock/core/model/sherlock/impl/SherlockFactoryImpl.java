/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.sherlock.core.model.sherlock.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SherlockFactoryImpl extends EFactoryImpl implements SherlockFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SherlockFactory init() {
		try {
			SherlockFactory theSherlockFactory = (SherlockFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/sherlock/core"); 
			if (theSherlockFactory != null) {
				return theSherlockFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SherlockFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SherlockFactoryImpl() {
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
			case SherlockPackage.SYSTEM_INFO: return createSystemInfo();
			case SherlockPackage.SYSTEM_VARIABLE: return createSystemVariable();
			case SherlockPackage.JAVA_INFO: return createJavaInfo();
			case SherlockPackage.JAVA_PROPERTY: return createJavaProperty();
			case SherlockPackage.ECLIPSE_INFO: return createEclipseInfo();
			case SherlockPackage.ECLIPSE_PLUGIN: return createEclipsePlugin();
			case SherlockPackage.ECLIPSE_FEATURE: return createEclipseFeature();
			case SherlockPackage.JAVA_EXCEPTION: return createJavaException();
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY: return createJavaStackTraceEntry();
			case SherlockPackage.ECLIPSE_STATUS: return createEclipseStatus();
			case SherlockPackage.ECLIPSE_PREFERENCE: return createEclipsePreference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemInfo createSystemInfo() {
		SystemInfoImpl systemInfo = new SystemInfoImpl();
		return systemInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemVariable createSystemVariable() {
		SystemVariableImpl systemVariable = new SystemVariableImpl();
		return systemVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaInfo createJavaInfo() {
		JavaInfoImpl javaInfo = new JavaInfoImpl();
		return javaInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaProperty createJavaProperty() {
		JavaPropertyImpl javaProperty = new JavaPropertyImpl();
		return javaProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseInfo createEclipseInfo() {
		EclipseInfoImpl eclipseInfo = new EclipseInfoImpl();
		return eclipseInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipsePlugin createEclipsePlugin() {
		EclipsePluginImpl eclipsePlugin = new EclipsePluginImpl();
		return eclipsePlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseFeature createEclipseFeature() {
		EclipseFeatureImpl eclipseFeature = new EclipseFeatureImpl();
		return eclipseFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaException createJavaException() {
		JavaExceptionImpl javaException = new JavaExceptionImpl();
		return javaException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaStackTraceEntry createJavaStackTraceEntry() {
		JavaStackTraceEntryImpl javaStackTraceEntry = new JavaStackTraceEntryImpl();
		return javaStackTraceEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipseStatus createEclipseStatus() {
		EclipseStatusImpl eclipseStatus = new EclipseStatusImpl();
		return eclipseStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EclipsePreference createEclipsePreference() {
		EclipsePreferenceImpl eclipsePreference = new EclipsePreferenceImpl();
		return eclipsePreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SherlockPackage getSherlockPackage() {
		return (SherlockPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SherlockPackage getPackage() {
		return SherlockPackage.eINSTANCE;
	}

} //SherlockFactoryImpl
