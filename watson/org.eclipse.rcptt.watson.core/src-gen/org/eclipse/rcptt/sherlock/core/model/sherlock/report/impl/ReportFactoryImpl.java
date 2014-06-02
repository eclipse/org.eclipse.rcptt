/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReportFactoryImpl extends EFactoryImpl implements ReportFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReportFactory init() {
		try {
			ReportFactory theReportFactory = (ReportFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/sherlock/report"); 
			if (theReportFactory != null) {
				return theReportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ReportFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportFactoryImpl() {
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
			case ReportPackage.REPORT: return createReport();
			case ReportPackage.REPORT_CONTAINER: return createReportContainer();
			case ReportPackage.NODE: return createNode();
			case ReportPackage.EVENT: return createEvent();
			case ReportPackage.EVENT_SOURCE: return createEventSource();
			case ReportPackage.PROPERTY_MAP: return (EObject)createPropertyMap();
			case ReportPackage.SNAPHOT: return createSnaphot();
			case ReportPackage.REPORT_BUILDER_STORE: return createReportBuilderStore();
			case ReportPackage.SCREENSHOT: return createScreenshot();
			case ReportPackage.TRACE_DATA: return createTraceData();
			case ReportPackage.LOGGING_DATA: return createLoggingData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ReportPackage.EVENT_KIND:
				return createEventKindFromString(eDataType, initialValue);
			case ReportPackage.SCREENSHOT_KIND:
				return createScreenshotKindFromString(eDataType, initialValue);
			case ReportPackage.LOGGING_CATEGORY:
				return createLoggingCategoryFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ReportPackage.EVENT_KIND:
				return convertEventKindToString(eDataType, instanceValue);
			case ReportPackage.SCREENSHOT_KIND:
				return convertScreenshotKindToString(eDataType, instanceValue);
			case ReportPackage.LOGGING_CATEGORY:
				return convertLoggingCategoryToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Report createReport() {
		ReportImpl report = new ReportImpl();
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportContainer createReportContainer() {
		ReportContainerImpl reportContainer = new ReportContainerImpl();
		return reportContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSource createEventSource() {
		EventSourceImpl eventSource = new EventSourceImpl();
		return eventSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EObject> createPropertyMap() {
		PropertyMapImpl propertyMap = new PropertyMapImpl();
		return propertyMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snaphot createSnaphot() {
		SnaphotImpl snaphot = new SnaphotImpl();
		return snaphot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportBuilderStore createReportBuilderStore() {
		ReportBuilderStoreImpl reportBuilderStore = new ReportBuilderStoreImpl();
		return reportBuilderStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Screenshot createScreenshot() {
		ScreenshotImpl screenshot = new ScreenshotImpl();
		return screenshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceData createTraceData() {
		TraceDataImpl traceData = new TraceDataImpl();
		return traceData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggingData createLoggingData() {
		LoggingDataImpl loggingData = new LoggingDataImpl();
		return loggingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventKind createEventKindFromString(EDataType eDataType, String initialValue) {
		EventKind result = EventKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenshotKind createScreenshotKindFromString(EDataType eDataType, String initialValue) {
		ScreenshotKind result = ScreenshotKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScreenshotKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggingCategory createLoggingCategoryFromString(EDataType eDataType, String initialValue) {
		LoggingCategory result = LoggingCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoggingCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportPackage getReportPackage() {
		return (ReportPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ReportPackage getPackage() {
		return ReportPackage.eINSTANCE;
	}

} //ReportFactoryImpl
