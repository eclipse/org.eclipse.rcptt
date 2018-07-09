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
package org.eclipse.rcptt.sherlock.core.model.sherlock.report;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory
 * @model kind="package"
 * @generated
 */
public interface ReportPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "report";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/sherlock/report";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.sherlock.report";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReportPackage eINSTANCE = org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportImpl <em>Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReport()
	 * @generated
	 */
	int REPORT = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__SOURCES = 1;

	/**
	 * The number of structural features of the '<em>Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportContainerImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReportContainer()
	 * @generated
	 */
	int REPORT_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_CONTAINER__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.NodeImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__START_TIME = 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__END_TIME = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EVENTS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENT = 6;

	/**
	 * The feature id for the '<em><b>Report</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REPORT = 7;

	/**
	 * The feature id for the '<em><b>Snapshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SNAPSHOTS = 8;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DURATION = 9;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIME = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DATA = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__KIND = 4;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COLOR = 5;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COUNT = 6;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventSourceImpl <em>Event Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventSourceImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEventSource()
	 * @generated
	 */
	int EVENT_SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE__PROPERTIES = 1;

	/**
	 * The number of structural features of the '<em>Event Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.PropertyMapImpl <em>Property Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.PropertyMapImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getPropertyMap()
	 * @generated
	 */
	int PROPERTY_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.SnaphotImpl <em>Snaphot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.SnaphotImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getSnaphot()
	 * @generated
	 */
	int SNAPHOT = 6;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__TIME = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__DATA = 2;

	/**
	 * The number of structural features of the '<em>Snaphot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportBuilderStoreImpl <em>Builder Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportBuilderStoreImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReportBuilderStore()
	 * @generated
	 */
	int REPORT_BUILDER_STORE = 7;

	/**
	 * The feature id for the '<em><b>Report</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_BUILDER_STORE__REPORT = 0;

	/**
	 * The feature id for the '<em><b>Current Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_BUILDER_STORE__CURRENT_NODE = 1;

	/**
	 * The number of structural features of the '<em>Builder Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_BUILDER_STORE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ScreenshotImpl <em>Screenshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ScreenshotImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getScreenshot()
	 * @generated
	 */
	int SCREENSHOT = 8;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__DATA = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__KIND = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__MESSAGE = 2;

	/**
	 * The number of structural features of the '<em>Screenshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.TraceDataImpl <em>Trace Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.TraceDataImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getTraceData()
	 * @generated
	 */
	int TRACE_DATA = 9;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DATA__MESSAGE = 0;

	/**
	 * The number of structural features of the '<em>Trace Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DATA_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.LoggingDataImpl <em>Logging Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.LoggingDataImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getLoggingData()
	 * @generated
	 */
	int LOGGING_DATA = 10;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_DATA__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_DATA__CATEGORY = 1;

	/**
	 * The number of structural features of the '<em>Logging Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind <em>Event Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEventKind()
	 * @generated
	 */
	int EVENT_KIND = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind <em>Screenshot Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getScreenshotKind()
	 * @generated
	 */
	int SCREENSHOT_KIND = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory <em>Logging Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getLoggingCategory()
	 * @generated
	 */
	int LOGGING_CATEGORY = 13;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Report</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report
	 * @generated
	 */
	EClass getReport();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report#getRoot()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sources</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report#getSources()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Sources();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportContainer
	 * @generated
	 */
	EClass getReportContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportContainer#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportContainer#getContent()
	 * @see #getReportContainer()
	 * @generated
	 */
	EAttribute getReportContainer_Content();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getStartTime()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getEndTime()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_EndTime();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getChildren()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getEvents()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Events();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getProperties()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Properties();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getParent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parent();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Report</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getReport()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Report();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getSnapshots <em>Snapshots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Snapshots</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getSnapshots()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Snapshots();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node#getDuration()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Duration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getTime()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Time();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getProperties()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getData()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Data();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getSource()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getKind()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getColor()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Color();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event#getCount()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Count();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Source</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource
	 * @generated
	 */
	EClass getEventSource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource#getName()
	 * @see #getEventSource()
	 * @generated
	 */
	EAttribute getEventSource_Name();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource#getProperties()
	 * @see #getEventSource()
	 * @generated
	 */
	EReference getEventSource_Properties();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getPropertyMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyMap()
	 * @generated
	 */
	EAttribute getPropertyMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyMap()
	 * @generated
	 */
	EReference getPropertyMap_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot <em>Snaphot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snaphot</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot
	 * @generated
	 */
	EClass getSnaphot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getTime()
	 * @see #getSnaphot()
	 * @generated
	 */
	EAttribute getSnaphot_Time();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getProperties()
	 * @see #getSnaphot()
	 * @generated
	 */
	EReference getSnaphot_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getData()
	 * @see #getSnaphot()
	 * @generated
	 */
	EReference getSnaphot_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore <em>Builder Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Builder Store</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore
	 * @generated
	 */
	EClass getReportBuilderStore();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Report</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getReport()
	 * @see #getReportBuilderStore()
	 * @generated
	 */
	EReference getReportBuilderStore_Report();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getCurrentNode <em>Current Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Node</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getCurrentNode()
	 * @see #getReportBuilderStore()
	 * @generated
	 */
	EReference getReportBuilderStore_CurrentNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot <em>Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Screenshot</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot
	 * @generated
	 */
	EClass getScreenshot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getData()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getKind()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getMessage()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.TraceData <em>Trace Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Data</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.TraceData
	 * @generated
	 */
	EClass getTraceData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.TraceData#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.TraceData#getMessage()
	 * @see #getTraceData()
	 * @generated
	 */
	EAttribute getTraceData_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData <em>Logging Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logging Data</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData
	 * @generated
	 */
	EClass getLoggingData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData#getText()
	 * @see #getLoggingData()
	 * @generated
	 */
	EAttribute getLoggingData_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData#getCategory()
	 * @see #getLoggingData()
	 * @generated
	 */
	EAttribute getLoggingData_Category();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind <em>Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind
	 * @generated
	 */
	EEnum getEventKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind <em>Screenshot Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Screenshot Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind
	 * @generated
	 */
	EEnum getScreenshotKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory <em>Logging Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logging Category</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory
	 * @generated
	 */
	EEnum getLoggingCategory();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReportFactory getReportFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportImpl <em>Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReport()
		 * @generated
		 */
		EClass REPORT = eINSTANCE.getReport();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__ROOT = eINSTANCE.getReport_Root();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__SOURCES = eINSTANCE.getReport_Sources();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportContainerImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReportContainer()
		 * @generated
		 */
		EClass REPORT_CONTAINER = eINSTANCE.getReportContainer();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPORT_CONTAINER__CONTENT = eINSTANCE.getReportContainer_Content();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.NodeImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__START_TIME = eINSTANCE.getNode_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__END_TIME = eINSTANCE.getNode_EndTime();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EVENTS = eINSTANCE.getNode_Events();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PROPERTIES = eINSTANCE.getNode_Properties();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENT = eINSTANCE.getNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Report</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__REPORT = eINSTANCE.getNode_Report();

		/**
		 * The meta object literal for the '<em><b>Snapshots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SNAPSHOTS = eINSTANCE.getNode_Snapshots();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DURATION = eINSTANCE.getNode_Duration();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TIME = eINSTANCE.getEvent_Time();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PROPERTIES = eINSTANCE.getEvent_Properties();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__DATA = eINSTANCE.getEvent_Data();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__SOURCE = eINSTANCE.getEvent_Source();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__KIND = eINSTANCE.getEvent_Kind();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__COLOR = eINSTANCE.getEvent_Color();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__COUNT = eINSTANCE.getEvent_Count();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventSourceImpl <em>Event Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.EventSourceImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEventSource()
		 * @generated
		 */
		EClass EVENT_SOURCE = eINSTANCE.getEventSource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_SOURCE__NAME = eINSTANCE.getEventSource_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_SOURCE__PROPERTIES = eINSTANCE.getEventSource_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.PropertyMapImpl <em>Property Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.PropertyMapImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getPropertyMap()
		 * @generated
		 */
		EClass PROPERTY_MAP = eINSTANCE.getPropertyMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MAP__KEY = eINSTANCE.getPropertyMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_MAP__VALUE = eINSTANCE.getPropertyMap_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.SnaphotImpl <em>Snaphot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.SnaphotImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getSnaphot()
		 * @generated
		 */
		EClass SNAPHOT = eINSTANCE.getSnaphot();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPHOT__TIME = eINSTANCE.getSnaphot_Time();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPHOT__PROPERTIES = eINSTANCE.getSnaphot_Properties();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPHOT__DATA = eINSTANCE.getSnaphot_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportBuilderStoreImpl <em>Builder Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportBuilderStoreImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReportBuilderStore()
		 * @generated
		 */
		EClass REPORT_BUILDER_STORE = eINSTANCE.getReportBuilderStore();

		/**
		 * The meta object literal for the '<em><b>Report</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT_BUILDER_STORE__REPORT = eINSTANCE.getReportBuilderStore_Report();

		/**
		 * The meta object literal for the '<em><b>Current Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT_BUILDER_STORE__CURRENT_NODE = eINSTANCE.getReportBuilderStore_CurrentNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ScreenshotImpl <em>Screenshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ScreenshotImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getScreenshot()
		 * @generated
		 */
		EClass SCREENSHOT = eINSTANCE.getScreenshot();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__DATA = eINSTANCE.getScreenshot_Data();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__KIND = eINSTANCE.getScreenshot_Kind();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__MESSAGE = eINSTANCE.getScreenshot_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.TraceDataImpl <em>Trace Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.TraceDataImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getTraceData()
		 * @generated
		 */
		EClass TRACE_DATA = eINSTANCE.getTraceData();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DATA__MESSAGE = eINSTANCE.getTraceData_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.LoggingDataImpl <em>Logging Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.LoggingDataImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getLoggingData()
		 * @generated
		 */
		EClass LOGGING_DATA = eINSTANCE.getLoggingData();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGGING_DATA__TEXT = eINSTANCE.getLoggingData_Text();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGGING_DATA__CATEGORY = eINSTANCE.getLoggingData_Category();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind <em>Event Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEventKind()
		 * @generated
		 */
		EEnum EVENT_KIND = eINSTANCE.getEventKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind <em>Screenshot Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getScreenshotKind()
		 * @generated
		 */
		EEnum SCREENSHOT_KIND = eINSTANCE.getScreenshotKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory <em>Logging Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getLoggingCategory()
		 * @generated
		 */
		EEnum LOGGING_CATEGORY = eINSTANCE.getLoggingCategory();

	}

} //ReportPackage
