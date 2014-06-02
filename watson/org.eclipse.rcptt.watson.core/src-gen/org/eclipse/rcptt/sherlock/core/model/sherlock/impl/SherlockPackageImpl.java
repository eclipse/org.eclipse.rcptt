/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaException;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaStackTraceEntry;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SherlockPackageImpl extends EPackageImpl implements SherlockPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclipseInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclipsePluginEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclipseFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaExceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaStackTraceEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclipseStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclipsePreferenceEClass = null;

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
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SherlockPackageImpl() {
		super(eNS_URI, SherlockFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SherlockPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SherlockPackage init() {
		if (isInited) return (SherlockPackage)EPackage.Registry.INSTANCE.getEPackage(SherlockPackage.eNS_URI);

		// Obtain or create and register package
		SherlockPackageImpl theSherlockPackage = (SherlockPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SherlockPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SherlockPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSherlockPackage.createPackageContents();

		// Initialize created meta-data
		theSherlockPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSherlockPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SherlockPackage.eNS_URI, theSherlockPackage);
		return theSherlockPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemInfo() {
		return systemInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_OsName() {
		return (EAttribute)systemInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_OsVersion() {
		return (EAttribute)systemInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_OsArch() {
		return (EAttribute)systemInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_Username() {
		return (EAttribute)systemInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInfo_Variables() {
		return (EReference)systemInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemVariable() {
		return systemVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemVariable_Name() {
		return (EAttribute)systemVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemVariable_Value() {
		return (EAttribute)systemVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaInfo() {
		return javaInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_RuntimeName() {
		return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_RuntimeVersion() {
		return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_MaxMemory() {
		return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_FreeMemory() {
		return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_TotalMemory() {
		return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_Args() {
		return (EAttribute)javaInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaInfo_Properties() {
		return (EReference)javaInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaProperty() {
		return javaPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_Name() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaProperty_Value() {
		return (EAttribute)javaPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEclipseInfo() {
		return eclipseInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_WorkspaceLocation() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_ProductId() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_ApplicationId() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_ApplicationArgs() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_BuildId() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_Uptime() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEclipseInfo_Plugins() {
		return (EReference)eclipseInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEclipseInfo_Features() {
		return (EReference)eclipseInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_WorkspacePartitionTotalDiskspace() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_WorkspacePartitionUsableDiskspace() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseInfo_WorkspacePartitionFreeDiskspace() {
		return (EAttribute)eclipseInfoEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEclipseInfo_Preferences() {
		return (EReference)eclipseInfoEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEclipsePlugin() {
		return eclipsePluginEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePlugin_Id() {
		return (EAttribute)eclipsePluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePlugin_Name() {
		return (EAttribute)eclipsePluginEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePlugin_Version() {
		return (EAttribute)eclipsePluginEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePlugin_Provider() {
		return (EAttribute)eclipsePluginEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEclipseFeature() {
		return eclipseFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseFeature_Id() {
		return (EAttribute)eclipseFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseFeature_Name() {
		return (EAttribute)eclipseFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseFeature_Version() {
		return (EAttribute)eclipseFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseFeature_Provider() {
		return (EAttribute)eclipseFeatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaException() {
		return javaExceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaException_ClassName() {
		return (EAttribute)javaExceptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaException_Cause() {
		return (EReference)javaExceptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaException_Message() {
		return (EAttribute)javaExceptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaException_StackTrace() {
		return (EReference)javaExceptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaStackTraceEntry() {
		return javaStackTraceEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaStackTraceEntry_FileName() {
		return (EAttribute)javaStackTraceEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaStackTraceEntry_LineNumber() {
		return (EAttribute)javaStackTraceEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaStackTraceEntry_ClassName() {
		return (EAttribute)javaStackTraceEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaStackTraceEntry_MethodName() {
		return (EAttribute)javaStackTraceEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaStackTraceEntry_NativeMethod() {
		return (EAttribute)javaStackTraceEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEclipseStatus() {
		return eclipseStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEclipseStatus_Children() {
		return (EReference)eclipseStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseStatus_Code() {
		return (EAttribute)eclipseStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseStatus_Message() {
		return (EAttribute)eclipseStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseStatus_Plugin() {
		return (EAttribute)eclipseStatusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseStatus_Severity() {
		return (EAttribute)eclipseStatusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEclipseStatus_Exception() {
		return (EReference)eclipseStatusEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseStatus_FeatureGuess() {
		return (EAttribute)eclipseStatusEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipseStatus_ThreadName() {
		return (EAttribute)eclipseStatusEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEclipsePreference() {
		return eclipsePreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePreference_Name() {
		return (EAttribute)eclipsePreferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePreference_Value() {
		return (EAttribute)eclipsePreferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEclipsePreference_Path() {
		return (EAttribute)eclipsePreferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SherlockFactory getSherlockFactory() {
		return (SherlockFactory)getEFactoryInstance();
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
		systemInfoEClass = createEClass(SYSTEM_INFO);
		createEAttribute(systemInfoEClass, SYSTEM_INFO__OS_NAME);
		createEAttribute(systemInfoEClass, SYSTEM_INFO__OS_VERSION);
		createEAttribute(systemInfoEClass, SYSTEM_INFO__OS_ARCH);
		createEAttribute(systemInfoEClass, SYSTEM_INFO__USERNAME);
		createEReference(systemInfoEClass, SYSTEM_INFO__VARIABLES);

		systemVariableEClass = createEClass(SYSTEM_VARIABLE);
		createEAttribute(systemVariableEClass, SYSTEM_VARIABLE__NAME);
		createEAttribute(systemVariableEClass, SYSTEM_VARIABLE__VALUE);

		javaInfoEClass = createEClass(JAVA_INFO);
		createEAttribute(javaInfoEClass, JAVA_INFO__RUNTIME_NAME);
		createEAttribute(javaInfoEClass, JAVA_INFO__RUNTIME_VERSION);
		createEAttribute(javaInfoEClass, JAVA_INFO__MAX_MEMORY);
		createEAttribute(javaInfoEClass, JAVA_INFO__FREE_MEMORY);
		createEAttribute(javaInfoEClass, JAVA_INFO__TOTAL_MEMORY);
		createEAttribute(javaInfoEClass, JAVA_INFO__ARGS);
		createEReference(javaInfoEClass, JAVA_INFO__PROPERTIES);

		javaPropertyEClass = createEClass(JAVA_PROPERTY);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__NAME);
		createEAttribute(javaPropertyEClass, JAVA_PROPERTY__VALUE);

		eclipseInfoEClass = createEClass(ECLIPSE_INFO);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__WORKSPACE_LOCATION);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__PRODUCT_ID);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__APPLICATION_ID);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__APPLICATION_ARGS);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__BUILD_ID);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__UPTIME);
		createEReference(eclipseInfoEClass, ECLIPSE_INFO__PLUGINS);
		createEReference(eclipseInfoEClass, ECLIPSE_INFO__FEATURES);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE);
		createEAttribute(eclipseInfoEClass, ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE);
		createEReference(eclipseInfoEClass, ECLIPSE_INFO__PREFERENCES);

		eclipsePluginEClass = createEClass(ECLIPSE_PLUGIN);
		createEAttribute(eclipsePluginEClass, ECLIPSE_PLUGIN__ID);
		createEAttribute(eclipsePluginEClass, ECLIPSE_PLUGIN__NAME);
		createEAttribute(eclipsePluginEClass, ECLIPSE_PLUGIN__VERSION);
		createEAttribute(eclipsePluginEClass, ECLIPSE_PLUGIN__PROVIDER);

		eclipseFeatureEClass = createEClass(ECLIPSE_FEATURE);
		createEAttribute(eclipseFeatureEClass, ECLIPSE_FEATURE__ID);
		createEAttribute(eclipseFeatureEClass, ECLIPSE_FEATURE__NAME);
		createEAttribute(eclipseFeatureEClass, ECLIPSE_FEATURE__VERSION);
		createEAttribute(eclipseFeatureEClass, ECLIPSE_FEATURE__PROVIDER);

		javaExceptionEClass = createEClass(JAVA_EXCEPTION);
		createEAttribute(javaExceptionEClass, JAVA_EXCEPTION__CLASS_NAME);
		createEReference(javaExceptionEClass, JAVA_EXCEPTION__CAUSE);
		createEAttribute(javaExceptionEClass, JAVA_EXCEPTION__MESSAGE);
		createEReference(javaExceptionEClass, JAVA_EXCEPTION__STACK_TRACE);

		javaStackTraceEntryEClass = createEClass(JAVA_STACK_TRACE_ENTRY);
		createEAttribute(javaStackTraceEntryEClass, JAVA_STACK_TRACE_ENTRY__FILE_NAME);
		createEAttribute(javaStackTraceEntryEClass, JAVA_STACK_TRACE_ENTRY__LINE_NUMBER);
		createEAttribute(javaStackTraceEntryEClass, JAVA_STACK_TRACE_ENTRY__CLASS_NAME);
		createEAttribute(javaStackTraceEntryEClass, JAVA_STACK_TRACE_ENTRY__METHOD_NAME);
		createEAttribute(javaStackTraceEntryEClass, JAVA_STACK_TRACE_ENTRY__NATIVE_METHOD);

		eclipseStatusEClass = createEClass(ECLIPSE_STATUS);
		createEReference(eclipseStatusEClass, ECLIPSE_STATUS__CHILDREN);
		createEAttribute(eclipseStatusEClass, ECLIPSE_STATUS__CODE);
		createEAttribute(eclipseStatusEClass, ECLIPSE_STATUS__MESSAGE);
		createEAttribute(eclipseStatusEClass, ECLIPSE_STATUS__PLUGIN);
		createEAttribute(eclipseStatusEClass, ECLIPSE_STATUS__SEVERITY);
		createEReference(eclipseStatusEClass, ECLIPSE_STATUS__EXCEPTION);
		createEAttribute(eclipseStatusEClass, ECLIPSE_STATUS__FEATURE_GUESS);
		createEAttribute(eclipseStatusEClass, ECLIPSE_STATUS__THREAD_NAME);

		eclipsePreferenceEClass = createEClass(ECLIPSE_PREFERENCE);
		createEAttribute(eclipsePreferenceEClass, ECLIPSE_PREFERENCE__NAME);
		createEAttribute(eclipsePreferenceEClass, ECLIPSE_PREFERENCE__VALUE);
		createEAttribute(eclipsePreferenceEClass, ECLIPSE_PREFERENCE__PATH);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(systemInfoEClass, SystemInfo.class, "SystemInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemInfo_OsName(), ecorePackage.getEString(), "osName", null, 0, 1, SystemInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemInfo_OsVersion(), ecorePackage.getEString(), "osVersion", null, 0, 1, SystemInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemInfo_OsArch(), ecorePackage.getEString(), "osArch", null, 0, 1, SystemInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemInfo_Username(), ecorePackage.getEString(), "username", null, 0, 1, SystemInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemInfo_Variables(), this.getSystemVariable(), null, "variables", null, 0, -1, SystemInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemVariableEClass, SystemVariable.class, "SystemVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, SystemVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemVariable_Value(), ecorePackage.getEString(), "value", null, 0, 1, SystemVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaInfoEClass, JavaInfo.class, "JavaInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaInfo_RuntimeName(), ecorePackage.getEString(), "runtimeName", null, 0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaInfo_RuntimeVersion(), ecorePackage.getEString(), "runtimeVersion", null, 0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaInfo_MaxMemory(), ecorePackage.getELong(), "maxMemory", null, 0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaInfo_FreeMemory(), ecorePackage.getELong(), "freeMemory", null, 0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaInfo_TotalMemory(), ecorePackage.getELong(), "totalMemory", null, 0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaInfo_Args(), ecorePackage.getEString(), "args", null, 0, -1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaInfo_Properties(), this.getJavaProperty(), null, "properties", null, 0, -1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaPropertyEClass, JavaProperty.class, "JavaProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, JavaProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eclipseInfoEClass, EclipseInfo.class, "EclipseInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEclipseInfo_WorkspaceLocation(), ecorePackage.getEString(), "workspaceLocation", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_ProductId(), ecorePackage.getEString(), "productId", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_ApplicationId(), ecorePackage.getEString(), "applicationId", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_ApplicationArgs(), ecorePackage.getEString(), "applicationArgs", null, 0, -1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_BuildId(), ecorePackage.getEString(), "buildId", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_Uptime(), ecorePackage.getELong(), "uptime", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEclipseInfo_Plugins(), this.getEclipsePlugin(), null, "plugins", null, 0, -1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEclipseInfo_Features(), this.getEclipseFeature(), null, "features", null, 0, -1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_WorkspacePartitionTotalDiskspace(), ecorePackage.getELong(), "workspacePartitionTotalDiskspace", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_WorkspacePartitionUsableDiskspace(), ecorePackage.getELong(), "workspacePartitionUsableDiskspace", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseInfo_WorkspacePartitionFreeDiskspace(), ecorePackage.getELong(), "workspacePartitionFreeDiskspace", null, 0, 1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEclipseInfo_Preferences(), this.getEclipsePreference(), null, "preferences", null, 0, -1, EclipseInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eclipsePluginEClass, EclipsePlugin.class, "EclipsePlugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEclipsePlugin_Id(), ecorePackage.getEString(), "id", null, 0, 1, EclipsePlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipsePlugin_Name(), ecorePackage.getEString(), "name", null, 0, 1, EclipsePlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipsePlugin_Version(), ecorePackage.getEString(), "version", null, 0, 1, EclipsePlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipsePlugin_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, EclipsePlugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eclipseFeatureEClass, EclipseFeature.class, "EclipseFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEclipseFeature_Id(), ecorePackage.getEString(), "id", null, 0, 1, EclipseFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, EclipseFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseFeature_Version(), ecorePackage.getEString(), "version", null, 0, 1, EclipseFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseFeature_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, EclipseFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaExceptionEClass, JavaException.class, "JavaException", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaException_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, JavaException.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaException_Cause(), this.getJavaException(), null, "cause", null, 0, 1, JavaException.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaException_Message(), ecorePackage.getEString(), "message", null, 0, 1, JavaException.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaException_StackTrace(), this.getJavaStackTraceEntry(), null, "stackTrace", null, 0, -1, JavaException.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaStackTraceEntryEClass, JavaStackTraceEntry.class, "JavaStackTraceEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaStackTraceEntry_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, JavaStackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaStackTraceEntry_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, JavaStackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaStackTraceEntry_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, JavaStackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaStackTraceEntry_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, JavaStackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaStackTraceEntry_NativeMethod(), ecorePackage.getEBoolean(), "nativeMethod", null, 0, 1, JavaStackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eclipseStatusEClass, EclipseStatus.class, "EclipseStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEclipseStatus_Children(), this.getEclipseStatus(), null, "children", null, 0, -1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseStatus_Code(), ecorePackage.getEInt(), "code", null, 0, 1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseStatus_Message(), ecorePackage.getEString(), "message", null, 0, 1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseStatus_Plugin(), ecorePackage.getEString(), "plugin", null, 0, 1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseStatus_Severity(), ecorePackage.getEInt(), "severity", null, 0, 1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEclipseStatus_Exception(), this.getJavaException(), null, "exception", null, 0, 1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseStatus_FeatureGuess(), ecorePackage.getEString(), "featureGuess", null, 0, -1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipseStatus_ThreadName(), ecorePackage.getEString(), "threadName", null, 0, 1, EclipseStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eclipsePreferenceEClass, EclipsePreference.class, "EclipsePreference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEclipsePreference_Name(), ecorePackage.getEString(), "name", null, 0, 1, EclipsePreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipsePreference_Value(), ecorePackage.getEString(), "value", null, 0, 1, EclipsePreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEclipsePreference_Path(), ecorePackage.getEString(), "path", null, 0, 1, EclipsePreference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SherlockPackageImpl
