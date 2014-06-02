/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.testing.commands;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.rcptt.testing.commands.CommandsFactory
 * @model kind="package"
 * @generated
 */
public interface CommandsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commands";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/testing/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.testing.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsPackage eINSTANCE = org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.GetAutImpl <em>Get Aut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.GetAutImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getGetAut()
	 * @generated
	 */
	int GET_AUT = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUT__NAME = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Aut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_AUT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.EvalImpl <em>Eval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.EvalImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getEval()
	 * @generated
	 */
	int EVAL = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Aut Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL__AUT_ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL__SCRIPT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Eval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.GetRecorderImpl <em>Get Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.GetRecorderImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getGetRecorder()
	 * @generated
	 */
	int GET_RECORDER = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RECORDER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RECORDER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RECORDER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.SetFeatureImpl <em>Set Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.SetFeatureImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getSetFeature()
	 * @generated
	 */
	int SET_FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Recorder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__RECORDER = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl <em>Invoke AUT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getInvokeAUT()
	 * @generated
	 */
	int INVOKE_AUT = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_AUT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_AUT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_AUT__NAME = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_AUT__ARGS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Vmargs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_AUT__VMARGS = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Invoke AUT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_AUT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.FindContextsImpl <em>Find Contexts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.FindContextsImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getFindContexts()
	 * @generated
	 */
	int FIND_CONTEXTS = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_CONTEXTS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_CONTEXTS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_CONTEXTS__TYPE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Find Contexts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_CONTEXTS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.CaptureContextImpl <em>Capture Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.CaptureContextImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getCaptureContext()
	 * @generated
	 */
	int CAPTURE_CONTEXT = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_CONTEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_CONTEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_CONTEXT__PATH = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_CONTEXT__TYPE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Capture Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_CONTEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.ApplyContextImpl <em>Apply Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.ApplyContextImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getApplyContext()
	 * @generated
	 */
	int APPLY_CONTEXT = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CONTEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CONTEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CONTEXT__PATH = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Apply Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CONTEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.GetGlobalImpl <em>Get Global</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.GetGlobalImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getGetGlobal()
	 * @generated
	 */
	int GET_GLOBAL = 8;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GLOBAL__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GLOBAL__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GLOBAL__NAME = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Global</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GLOBAL_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.SetGlobalImpl <em>Set Global</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.SetGlobalImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getSetGlobal()
	 * @generated
	 */
	int SET_GLOBAL = 9;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL__VALUES = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Global</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GLOBAL_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testing.commands.impl.CleanSelfAUTImpl <em>Clean Self AUT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testing.commands.impl.CleanSelfAUTImpl
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getCleanSelfAUT()
	 * @generated
	 */
	int CLEAN_SELF_AUT = 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAN_SELF_AUT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAN_SELF_AUT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Clean Self AUT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAN_SELF_AUT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>Network Recorder</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.recording.NetworkRecorder
	 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getNetworkRecorder()
	 * @generated
	 */
	int NETWORK_RECORDER = 11;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.GetAut <em>Get Aut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Aut</em>'.
	 * @see org.eclipse.rcptt.testing.commands.GetAut
	 * @generated
	 */
	EClass getGetAut();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.GetAut#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.testing.commands.GetAut#getName()
	 * @see #getGetAut()
	 * @generated
	 */
	EAttribute getGetAut_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.Eval <em>Eval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval</em>'.
	 * @see org.eclipse.rcptt.testing.commands.Eval
	 * @generated
	 */
	EClass getEval();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.Eval#getAutId <em>Aut Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aut Id</em>'.
	 * @see org.eclipse.rcptt.testing.commands.Eval#getAutId()
	 * @see #getEval()
	 * @generated
	 */
	EAttribute getEval_AutId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.Eval#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see org.eclipse.rcptt.testing.commands.Eval#getScript()
	 * @see #getEval()
	 * @generated
	 */
	EAttribute getEval_Script();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.GetRecorder <em>Get Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Recorder</em>'.
	 * @see org.eclipse.rcptt.testing.commands.GetRecorder
	 * @generated
	 */
	EClass getGetRecorder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.SetFeature <em>Set Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Feature</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetFeature
	 * @generated
	 */
	EClass getSetFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.SetFeature#getRecorder <em>Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recorder</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetFeature#getRecorder()
	 * @see #getSetFeature()
	 * @generated
	 */
	EAttribute getSetFeature_Recorder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.SetFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetFeature#getName()
	 * @see #getSetFeature()
	 * @generated
	 */
	EAttribute getSetFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.SetFeature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetFeature#getValue()
	 * @see #getSetFeature()
	 * @generated
	 */
	EAttribute getSetFeature_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.InvokeAUT <em>Invoke AUT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke AUT</em>'.
	 * @see org.eclipse.rcptt.testing.commands.InvokeAUT
	 * @generated
	 */
	EClass getInvokeAUT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.testing.commands.InvokeAUT#getName()
	 * @see #getInvokeAUT()
	 * @generated
	 */
	EAttribute getInvokeAUT_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Args</em>'.
	 * @see org.eclipse.rcptt.testing.commands.InvokeAUT#getArgs()
	 * @see #getInvokeAUT()
	 * @generated
	 */
	EAttribute getInvokeAUT_Args();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getVmargs <em>Vmargs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vmargs</em>'.
	 * @see org.eclipse.rcptt.testing.commands.InvokeAUT#getVmargs()
	 * @see #getInvokeAUT()
	 * @generated
	 */
	EAttribute getInvokeAUT_Vmargs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.FindContexts <em>Find Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Find Contexts</em>'.
	 * @see org.eclipse.rcptt.testing.commands.FindContexts
	 * @generated
	 */
	EClass getFindContexts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.FindContexts#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.testing.commands.FindContexts#getType()
	 * @see #getFindContexts()
	 * @generated
	 */
	EAttribute getFindContexts_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.CaptureContext <em>Capture Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capture Context</em>'.
	 * @see org.eclipse.rcptt.testing.commands.CaptureContext
	 * @generated
	 */
	EClass getCaptureContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.CaptureContext#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.testing.commands.CaptureContext#getPath()
	 * @see #getCaptureContext()
	 * @generated
	 */
	EAttribute getCaptureContext_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.CaptureContext#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.testing.commands.CaptureContext#getType()
	 * @see #getCaptureContext()
	 * @generated
	 */
	EAttribute getCaptureContext_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.ApplyContext <em>Apply Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apply Context</em>'.
	 * @see org.eclipse.rcptt.testing.commands.ApplyContext
	 * @generated
	 */
	EClass getApplyContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.ApplyContext#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.testing.commands.ApplyContext#getPath()
	 * @see #getApplyContext()
	 * @generated
	 */
	EAttribute getApplyContext_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.GetGlobal <em>Get Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Global</em>'.
	 * @see org.eclipse.rcptt.testing.commands.GetGlobal
	 * @generated
	 */
	EClass getGetGlobal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.GetGlobal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.testing.commands.GetGlobal#getName()
	 * @see #getGetGlobal()
	 * @generated
	 */
	EAttribute getGetGlobal_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.SetGlobal <em>Set Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Global</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetGlobal
	 * @generated
	 */
	EClass getSetGlobal();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.testing.commands.SetGlobal#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetGlobal#getValues()
	 * @see #getSetGlobal()
	 * @generated
	 */
	EReference getSetGlobal_Values();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testing.commands.SetGlobal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.testing.commands.SetGlobal#getName()
	 * @see #getSetGlobal()
	 * @generated
	 */
	EAttribute getSetGlobal_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testing.commands.CleanSelfAUT <em>Clean Self AUT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clean Self AUT</em>'.
	 * @see org.eclipse.rcptt.testing.commands.CleanSelfAUT
	 * @generated
	 */
	EClass getCleanSelfAUT();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.rcptt.core.recording.NetworkRecorder <em>Network Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Network Recorder</em>'.
	 * @see org.eclipse.rcptt.core.recording.NetworkRecorder
	 * @model instanceClass="org.eclipse.rcptt.core.recording.NetworkRecorder"
	 * @generated
	 */
	EDataType getNetworkRecorder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandsFactory getCommandsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.GetAutImpl <em>Get Aut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.GetAutImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getGetAut()
		 * @generated
		 */
		EClass GET_AUT = eINSTANCE.getGetAut();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_AUT__NAME = eINSTANCE.getGetAut_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.EvalImpl <em>Eval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.EvalImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getEval()
		 * @generated
		 */
		EClass EVAL = eINSTANCE.getEval();

		/**
		 * The meta object literal for the '<em><b>Aut Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVAL__AUT_ID = eINSTANCE.getEval_AutId();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVAL__SCRIPT = eINSTANCE.getEval_Script();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.GetRecorderImpl <em>Get Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.GetRecorderImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getGetRecorder()
		 * @generated
		 */
		EClass GET_RECORDER = eINSTANCE.getGetRecorder();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.SetFeatureImpl <em>Set Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.SetFeatureImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getSetFeature()
		 * @generated
		 */
		EClass SET_FEATURE = eINSTANCE.getSetFeature();

		/**
		 * The meta object literal for the '<em><b>Recorder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_FEATURE__RECORDER = eINSTANCE.getSetFeature_Recorder();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_FEATURE__NAME = eINSTANCE.getSetFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_FEATURE__VALUE = eINSTANCE.getSetFeature_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl <em>Invoke AUT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getInvokeAUT()
		 * @generated
		 */
		EClass INVOKE_AUT = eINSTANCE.getInvokeAUT();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_AUT__NAME = eINSTANCE.getInvokeAUT_Name();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_AUT__ARGS = eINSTANCE.getInvokeAUT_Args();

		/**
		 * The meta object literal for the '<em><b>Vmargs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOKE_AUT__VMARGS = eINSTANCE.getInvokeAUT_Vmargs();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.FindContextsImpl <em>Find Contexts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.FindContextsImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getFindContexts()
		 * @generated
		 */
		EClass FIND_CONTEXTS = eINSTANCE.getFindContexts();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIND_CONTEXTS__TYPE = eINSTANCE.getFindContexts_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.CaptureContextImpl <em>Capture Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.CaptureContextImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getCaptureContext()
		 * @generated
		 */
		EClass CAPTURE_CONTEXT = eINSTANCE.getCaptureContext();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPTURE_CONTEXT__PATH = eINSTANCE.getCaptureContext_Path();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPTURE_CONTEXT__TYPE = eINSTANCE.getCaptureContext_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.ApplyContextImpl <em>Apply Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.ApplyContextImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getApplyContext()
		 * @generated
		 */
		EClass APPLY_CONTEXT = eINSTANCE.getApplyContext();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLY_CONTEXT__PATH = eINSTANCE.getApplyContext_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.GetGlobalImpl <em>Get Global</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.GetGlobalImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getGetGlobal()
		 * @generated
		 */
		EClass GET_GLOBAL = eINSTANCE.getGetGlobal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_GLOBAL__NAME = eINSTANCE.getGetGlobal_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.SetGlobalImpl <em>Set Global</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.SetGlobalImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getSetGlobal()
		 * @generated
		 */
		EClass SET_GLOBAL = eINSTANCE.getSetGlobal();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_GLOBAL__VALUES = eINSTANCE.getSetGlobal_Values();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_GLOBAL__NAME = eINSTANCE.getSetGlobal_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testing.commands.impl.CleanSelfAUTImpl <em>Clean Self AUT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testing.commands.impl.CleanSelfAUTImpl
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getCleanSelfAUT()
		 * @generated
		 */
		EClass CLEAN_SELF_AUT = eINSTANCE.getCleanSelfAUT();

		/**
		 * The meta object literal for the '<em>Network Recorder</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.recording.NetworkRecorder
		 * @see org.eclipse.rcptt.testing.commands.impl.CommandsPackageImpl#getNetworkRecorder()
		 * @generated
		 */
		EDataType NETWORK_RECORDER = eINSTANCE.getNetworkRecorder();

	}

} //CommandsPackage
