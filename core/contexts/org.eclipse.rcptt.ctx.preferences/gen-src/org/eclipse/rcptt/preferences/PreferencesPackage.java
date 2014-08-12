/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.preferences;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

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
 * @see org.eclipse.rcptt.preferences.PreferencesFactory
 * @model kind="package"
 * @generated
 */
public interface PreferencesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "preferences";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/ctx/preferences";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ctx.preferences";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PreferencesPackage eINSTANCE = org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.impl.PreferencesContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesContextImpl
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getPreferencesContext()
	 * @generated
	 */
	int PREFERENCES_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__NAME = ScenarioPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__VERSION = ScenarioPackage.CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__ID = ScenarioPackage.CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__DESCRIPTION = ScenarioPackage.CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__TAGS = ScenarioPackage.CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__ATTACHMENTS = ScenarioPackage.CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__CONTENT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clean Preferences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__CLEAN_PREFERENCES = ScenarioPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT__SETTINGS = ScenarioPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_CONTEXT_FEATURE_COUNT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.impl.PrefNodeImpl <em>Pref Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.impl.PrefNodeImpl
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getPrefNode()
	 * @generated
	 */
	int PREF_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREF_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Childs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREF_NODE__CHILDS = 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREF_NODE__DATA = 2;

	/**
	 * The number of structural features of the '<em>Pref Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREF_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.PrefData <em>Pref Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.PrefData
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getPrefData()
	 * @generated
	 */
	int PREF_DATA = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREF_DATA__KEY = 0;

	/**
	 * The number of structural features of the '<em>Pref Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREF_DATA_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.impl.SettingsNodeImpl <em>Settings Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.impl.SettingsNodeImpl
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getSettingsNode()
	 * @generated
	 */
	int SETTINGS_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_NODE__NAME = PREF_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Childs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_NODE__CHILDS = PREF_NODE__CHILDS;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_NODE__DATA = PREF_NODE__DATA;

	/**
	 * The number of structural features of the '<em>Settings Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_NODE_FEATURE_COUNT = PREF_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.impl.StringPrefDataImpl <em>String Pref Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.impl.StringPrefDataImpl
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getStringPrefData()
	 * @generated
	 */
	int STRING_PREF_DATA = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREF_DATA__KEY = PREF_DATA__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREF_DATA__VALUE = PREF_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Pref Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PREF_DATA_FEATURE_COUNT = PREF_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.impl.ListPrefDataImpl <em>List Pref Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.impl.ListPrefDataImpl
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getListPrefData()
	 * @generated
	 */
	int LIST_PREF_DATA = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PREF_DATA__KEY = PREF_DATA__KEY;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PREF_DATA__VALUES = PREF_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Pref Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PREF_DATA_FEATURE_COUNT = PREF_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.preferences.impl.SecurePrefNodeImpl <em>Secure Pref Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.preferences.impl.SecurePrefNodeImpl
	 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getSecurePrefNode()
	 * @generated
	 */
	int SECURE_PREF_NODE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURE_PREF_NODE__NAME = PREF_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Childs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURE_PREF_NODE__CHILDS = PREF_NODE__CHILDS;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURE_PREF_NODE__DATA = PREF_NODE__DATA;

	/**
	 * The number of structural features of the '<em>Secure Pref Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURE_PREF_NODE_FEATURE_COUNT = PREF_NODE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.PreferencesContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.rcptt.preferences.PreferencesContext
	 * @generated
	 */
	EClass getPreferencesContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.preferences.PreferencesContext#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Content</em>'.
	 * @see org.eclipse.rcptt.preferences.PreferencesContext#getContent()
	 * @see #getPreferencesContext()
	 * @generated
	 */
	EReference getPreferencesContext_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.preferences.PreferencesContext#isCleanPreferences <em>Clean Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clean Preferences</em>'.
	 * @see org.eclipse.rcptt.preferences.PreferencesContext#isCleanPreferences()
	 * @see #getPreferencesContext()
	 * @generated
	 */
	EAttribute getPreferencesContext_CleanPreferences();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.preferences.PreferencesContext#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Settings</em>'.
	 * @see org.eclipse.rcptt.preferences.PreferencesContext#getSettings()
	 * @see #getPreferencesContext()
	 * @generated
	 */
	EReference getPreferencesContext_Settings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.PrefNode <em>Pref Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pref Node</em>'.
	 * @see org.eclipse.rcptt.preferences.PrefNode
	 * @generated
	 */
	EClass getPrefNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.preferences.PrefNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.preferences.PrefNode#getName()
	 * @see #getPrefNode()
	 * @generated
	 */
	EAttribute getPrefNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.preferences.PrefNode#getChilds <em>Childs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Childs</em>'.
	 * @see org.eclipse.rcptt.preferences.PrefNode#getChilds()
	 * @see #getPrefNode()
	 * @generated
	 */
	EReference getPrefNode_Childs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.preferences.PrefNode#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see org.eclipse.rcptt.preferences.PrefNode#getData()
	 * @see #getPrefNode()
	 * @generated
	 */
	EReference getPrefNode_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.PrefData <em>Pref Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pref Data</em>'.
	 * @see org.eclipse.rcptt.preferences.PrefData
	 * @generated
	 */
	EClass getPrefData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.preferences.PrefData#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.rcptt.preferences.PrefData#getKey()
	 * @see #getPrefData()
	 * @generated
	 */
	EAttribute getPrefData_Key();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.SettingsNode <em>Settings Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings Node</em>'.
	 * @see org.eclipse.rcptt.preferences.SettingsNode
	 * @generated
	 */
	EClass getSettingsNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.StringPrefData <em>String Pref Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Pref Data</em>'.
	 * @see org.eclipse.rcptt.preferences.StringPrefData
	 * @generated
	 */
	EClass getStringPrefData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.preferences.StringPrefData#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.preferences.StringPrefData#getValue()
	 * @see #getStringPrefData()
	 * @generated
	 */
	EAttribute getStringPrefData_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.ListPrefData <em>List Pref Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Pref Data</em>'.
	 * @see org.eclipse.rcptt.preferences.ListPrefData
	 * @generated
	 */
	EClass getListPrefData();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.preferences.ListPrefData#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.rcptt.preferences.ListPrefData#getValues()
	 * @see #getListPrefData()
	 * @generated
	 */
	EAttribute getListPrefData_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.preferences.SecurePrefNode <em>Secure Pref Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Secure Pref Node</em>'.
	 * @see org.eclipse.rcptt.preferences.SecurePrefNode
	 * @generated
	 */
	EClass getSecurePrefNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PreferencesFactory getPreferencesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.impl.PreferencesContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesContextImpl
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getPreferencesContext()
		 * @generated
		 */
		EClass PREFERENCES_CONTEXT = eINSTANCE.getPreferencesContext();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCES_CONTEXT__CONTENT = eINSTANCE.getPreferencesContext_Content();

		/**
		 * The meta object literal for the '<em><b>Clean Preferences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES_CONTEXT__CLEAN_PREFERENCES = eINSTANCE.getPreferencesContext_CleanPreferences();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCES_CONTEXT__SETTINGS = eINSTANCE.getPreferencesContext_Settings();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.impl.PrefNodeImpl <em>Pref Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.impl.PrefNodeImpl
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getPrefNode()
		 * @generated
		 */
		EClass PREF_NODE = eINSTANCE.getPrefNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREF_NODE__NAME = eINSTANCE.getPrefNode_Name();

		/**
		 * The meta object literal for the '<em><b>Childs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREF_NODE__CHILDS = eINSTANCE.getPrefNode_Childs();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREF_NODE__DATA = eINSTANCE.getPrefNode_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.PrefData <em>Pref Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.PrefData
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getPrefData()
		 * @generated
		 */
		EClass PREF_DATA = eINSTANCE.getPrefData();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREF_DATA__KEY = eINSTANCE.getPrefData_Key();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.impl.SettingsNodeImpl <em>Settings Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.impl.SettingsNodeImpl
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getSettingsNode()
		 * @generated
		 */
		EClass SETTINGS_NODE = eINSTANCE.getSettingsNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.impl.StringPrefDataImpl <em>String Pref Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.impl.StringPrefDataImpl
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getStringPrefData()
		 * @generated
		 */
		EClass STRING_PREF_DATA = eINSTANCE.getStringPrefData();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_PREF_DATA__VALUE = eINSTANCE.getStringPrefData_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.impl.ListPrefDataImpl <em>List Pref Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.impl.ListPrefDataImpl
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getListPrefData()
		 * @generated
		 */
		EClass LIST_PREF_DATA = eINSTANCE.getListPrefData();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST_PREF_DATA__VALUES = eINSTANCE.getListPrefData_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.preferences.impl.SecurePrefNodeImpl <em>Secure Pref Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.preferences.impl.SecurePrefNodeImpl
		 * @see org.eclipse.rcptt.preferences.impl.PreferencesPackageImpl#getSecurePrefNode()
		 * @generated
		 */
		EClass SECURE_PREF_NODE = eINSTANCE.getSecurePrefNode();

	}

} //PreferencesPackage
