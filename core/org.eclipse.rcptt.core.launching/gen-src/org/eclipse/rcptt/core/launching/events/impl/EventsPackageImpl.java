/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.launching.events.impl;

import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.core.launching.events.AutEvent;
import org.eclipse.rcptt.core.launching.events.AutEventInit;
import org.eclipse.rcptt.core.launching.events.AutEventLocation;
import org.eclipse.rcptt.core.launching.events.AutEventPing;
import org.eclipse.rcptt.core.launching.events.AutEventPingResponse;
import org.eclipse.rcptt.core.launching.events.AutEventStart;
import org.eclipse.rcptt.core.launching.events.AutReconnect;
import org.eclipse.rcptt.core.launching.events.AutSendEvent;
import org.eclipse.rcptt.core.launching.events.AutStartState;
import org.eclipse.rcptt.core.launching.events.Capability;
import org.eclipse.rcptt.core.launching.events.EventsFactory;
import org.eclipse.rcptt.core.launching.events.EventsPackage;

import org.eclipse.rcptt.core.launching.events.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventsPackageImpl extends EPackageImpl implements EventsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autEventInitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autEventStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autBundleStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autEventLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autEventPingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autEventPingResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autSendEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autReconnectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum autStartStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum platformEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum capabilityEEnum = null;

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
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventsPackageImpl() {
		super(eNS_URI, EventsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EventsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventsPackage init() {
		if (isInited) return (EventsPackage)EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);

		// Obtain or create and register package
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEventsPackage.createPackageContents();

		// Initialize created meta-data
		theEventsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventsPackage.eNS_URI, theEventsPackage);
		return theEventsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutEvent() {
		return autEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutEventInit() {
		return autEventInitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAutEventInit_BundleState() {
		return (EReference)autEventInitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutEventStart() {
		return autEventStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventStart_EclPort() {
		return (EAttribute)autEventStartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventStart_TeslaPort() {
		return (EAttribute)autEventStartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventStart_Message() {
		return (EAttribute)autEventStartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventStart_State() {
		return (EAttribute)autEventStartEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventStart_Platform() {
		return (EAttribute)autEventStartEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventStart_Capability() {
		return (EAttribute)autEventStartEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutBundleState() {
		return autBundleStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutBundleState_Id() {
		return (EAttribute)autBundleStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutBundleState_Location() {
		return (EAttribute)autBundleStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutBundleState_State() {
		return (EAttribute)autBundleStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutEventLocation() {
		return autEventLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventLocation_Location() {
		return (EAttribute)autEventLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutEventPing() {
		return autEventPingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutEventPing_Location() {
		return (EAttribute)autEventPingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutEventPingResponse() {
		return autEventPingResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutSendEvent() {
		return autSendEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutSendEvent_Id() {
		return (EAttribute)autSendEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAutSendEvent_Event() {
		return (EReference)autSendEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutReconnect() {
		return autReconnectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutReconnect_Q7EclPort() {
		return (EAttribute)autReconnectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutReconnect_Id() {
		return (EAttribute)autReconnectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAutStartState() {
		return autStartStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPlatform() {
		return platformEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCapability() {
		return capabilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactory getEventsFactory() {
		return (EventsFactory)getEFactoryInstance();
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
		autEventEClass = createEClass(AUT_EVENT);

		autEventInitEClass = createEClass(AUT_EVENT_INIT);
		createEReference(autEventInitEClass, AUT_EVENT_INIT__BUNDLE_STATE);

		autEventStartEClass = createEClass(AUT_EVENT_START);
		createEAttribute(autEventStartEClass, AUT_EVENT_START__ECL_PORT);
		createEAttribute(autEventStartEClass, AUT_EVENT_START__TESLA_PORT);
		createEAttribute(autEventStartEClass, AUT_EVENT_START__MESSAGE);
		createEAttribute(autEventStartEClass, AUT_EVENT_START__STATE);
		createEAttribute(autEventStartEClass, AUT_EVENT_START__PLATFORM);
		createEAttribute(autEventStartEClass, AUT_EVENT_START__CAPABILITY);

		autBundleStateEClass = createEClass(AUT_BUNDLE_STATE);
		createEAttribute(autBundleStateEClass, AUT_BUNDLE_STATE__ID);
		createEAttribute(autBundleStateEClass, AUT_BUNDLE_STATE__LOCATION);
		createEAttribute(autBundleStateEClass, AUT_BUNDLE_STATE__STATE);

		autEventLocationEClass = createEClass(AUT_EVENT_LOCATION);
		createEAttribute(autEventLocationEClass, AUT_EVENT_LOCATION__LOCATION);

		autEventPingEClass = createEClass(AUT_EVENT_PING);
		createEAttribute(autEventPingEClass, AUT_EVENT_PING__LOCATION);

		autEventPingResponseEClass = createEClass(AUT_EVENT_PING_RESPONSE);

		autSendEventEClass = createEClass(AUT_SEND_EVENT);
		createEAttribute(autSendEventEClass, AUT_SEND_EVENT__ID);
		createEReference(autSendEventEClass, AUT_SEND_EVENT__EVENT);

		autReconnectEClass = createEClass(AUT_RECONNECT);
		createEAttribute(autReconnectEClass, AUT_RECONNECT__Q7_ECL_PORT);
		createEAttribute(autReconnectEClass, AUT_RECONNECT__ID);

		// Create enums
		autStartStateEEnum = createEEnum(AUT_START_STATE);
		platformEEnum = createEEnum(PLATFORM);
		capabilityEEnum = createEEnum(CAPABILITY);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		autEventInitEClass.getESuperTypes().add(this.getAutEvent());
		autEventStartEClass.getESuperTypes().add(this.getAutEvent());
		autEventLocationEClass.getESuperTypes().add(this.getAutEvent());
		autEventPingEClass.getESuperTypes().add(this.getAutEvent());
		autSendEventEClass.getESuperTypes().add(theCorePackage.getCommand());
		autReconnectEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(autEventEClass, AutEvent.class, "AutEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(autEventInitEClass, AutEventInit.class, "AutEventInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAutEventInit_BundleState(), this.getAutBundleState(), null, "bundleState", null, 0, -1, AutEventInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autEventStartEClass, AutEventStart.class, "AutEventStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutEventStart_EclPort(), theEcorePackage.getEInt(), "eclPort", null, 0, 1, AutEventStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutEventStart_TeslaPort(), theEcorePackage.getEInt(), "teslaPort", null, 0, 1, AutEventStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutEventStart_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AutEventStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutEventStart_State(), this.getAutStartState(), "state", null, 0, 1, AutEventStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutEventStart_Platform(), this.getPlatform(), "platform", "Other", 0, 1, AutEventStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutEventStart_Capability(), this.getCapability(), "capability", "Other", 0, 1, AutEventStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autBundleStateEClass, AutBundleState.class, "AutBundleState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutBundleState_Id(), theEcorePackage.getEString(), "id", null, 0, 1, AutBundleState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutBundleState_Location(), theEcorePackage.getEString(), "location", null, 0, 1, AutBundleState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutBundleState_State(), theEcorePackage.getEString(), "state", null, 0, 1, AutBundleState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autEventLocationEClass, AutEventLocation.class, "AutEventLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutEventLocation_Location(), ecorePackage.getEString(), "location", null, 0, 1, AutEventLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autEventPingEClass, AutEventPing.class, "AutEventPing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutEventPing_Location(), ecorePackage.getEString(), "location", null, 0, 1, AutEventPing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autEventPingResponseEClass, AutEventPingResponse.class, "AutEventPingResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(autSendEventEClass, AutSendEvent.class, "AutSendEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutSendEvent_Id(), ecorePackage.getEString(), "id", null, 0, 1, AutSendEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAutSendEvent_Event(), this.getAutEvent(), null, "event", null, 0, 1, AutSendEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autReconnectEClass, AutReconnect.class, "AutReconnect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutReconnect_Q7EclPort(), theEcorePackage.getEInt(), "q7EclPort", null, 0, 1, AutReconnect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutReconnect_Id(), theEcorePackage.getEString(), "id", null, 0, 1, AutReconnect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(autStartStateEEnum, AutStartState.class, "AutStartState");
		addEEnumLiteral(autStartStateEEnum, AutStartState.OK);
		addEEnumLiteral(autStartStateEEnum, AutStartState.FAIL);

		initEEnum(platformEEnum, Platform.class, "Platform");
		addEEnumLiteral(platformEEnum, Platform.OTHER);
		addEEnumLiteral(platformEEnum, Platform.MAC_OS);
		addEEnumLiteral(platformEEnum, Platform.WINDOWS);
		addEEnumLiteral(platformEEnum, Platform.LINUX);

		initEEnum(capabilityEEnum, Capability.class, "Capability");
		addEEnumLiteral(capabilityEEnum, Capability.OTHER);
		addEEnumLiteral(capabilityEEnum, Capability.E3);
		addEEnumLiteral(capabilityEEnum, Capability.E4);
		addEEnumLiteral(capabilityEEnum, Capability.RAP);

		// Create resource
		createResource(eNS_URI);
	}

} //EventsPackageImpl
