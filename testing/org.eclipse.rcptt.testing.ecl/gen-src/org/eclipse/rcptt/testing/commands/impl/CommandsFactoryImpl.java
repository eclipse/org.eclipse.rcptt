/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.testing.commands.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.core.recording.NetworkRecorder;

import org.eclipse.rcptt.testing.commands.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandsFactoryImpl extends EFactoryImpl implements CommandsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandsFactory init() {
		try {
			CommandsFactory theCommandsFactory = (CommandsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/testing/ecl"); 
			if (theCommandsFactory != null) {
				return theCommandsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommandsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsFactoryImpl() {
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
			case CommandsPackage.GET_AUT: return createGetAut();
			case CommandsPackage.EVAL: return createEval();
			case CommandsPackage.GET_RECORDER: return createGetRecorder();
			case CommandsPackage.SET_FEATURE: return createSetFeature();
			case CommandsPackage.INVOKE_AUT: return createInvokeAUT();
			case CommandsPackage.FIND_CONTEXTS: return createFindContexts();
			case CommandsPackage.CAPTURE_CONTEXT: return createCaptureContext();
			case CommandsPackage.APPLY_CONTEXT: return createApplyContext();
			case CommandsPackage.GET_GLOBAL: return createGetGlobal();
			case CommandsPackage.SET_GLOBAL: return createSetGlobal();
			case CommandsPackage.CLEAN_SELF_AUT: return createCleanSelfAUT();
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
			case CommandsPackage.NETWORK_RECORDER:
				return createNetworkRecorderFromString(eDataType, initialValue);
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
			case CommandsPackage.NETWORK_RECORDER:
				return convertNetworkRecorderToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetAut createGetAut() {
		GetAutImpl getAut = new GetAutImpl();
		return getAut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Eval createEval() {
		EvalImpl eval = new EvalImpl();
		return eval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetRecorder createGetRecorder() {
		GetRecorderImpl getRecorder = new GetRecorderImpl();
		return getRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetFeature createSetFeature() {
		SetFeatureImpl setFeature = new SetFeatureImpl();
		return setFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeAUT createInvokeAUT() {
		InvokeAUTImpl invokeAUT = new InvokeAUTImpl();
		return invokeAUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FindContexts createFindContexts() {
		FindContextsImpl findContexts = new FindContextsImpl();
		return findContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaptureContext createCaptureContext() {
		CaptureContextImpl captureContext = new CaptureContextImpl();
		return captureContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyContext createApplyContext() {
		ApplyContextImpl applyContext = new ApplyContextImpl();
		return applyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetGlobal createGetGlobal() {
		GetGlobalImpl getGlobal = new GetGlobalImpl();
		return getGlobal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetGlobal createSetGlobal() {
		SetGlobalImpl setGlobal = new SetGlobalImpl();
		return setGlobal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CleanSelfAUT createCleanSelfAUT() {
		CleanSelfAUTImpl cleanSelfAUT = new CleanSelfAUTImpl();
		return cleanSelfAUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkRecorder createNetworkRecorderFromString(EDataType eDataType, String initialValue) {
		return (NetworkRecorder)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNetworkRecorderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsPackage getCommandsPackage() {
		return (CommandsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommandsPackage getPackage() {
		return CommandsPackage.eINSTANCE;
	}

} //CommandsFactoryImpl
