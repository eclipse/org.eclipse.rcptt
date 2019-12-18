/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.tags;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.rcptt.core.tags.TagsFactory
 * @model kind="package"
 * @generated
 */
public interface TagsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tags";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.com/rcptt/ide/tags";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TagsPackage eINSTANCE = org.eclipse.rcptt.core.tags.impl.TagsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.tags.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.tags.impl.TagImpl
	 * @see org.eclipse.rcptt.core.tags.impl.TagsPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__REFS = 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__TAGS = 2;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.tags.impl.TagsRegistryImpl <em>Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.tags.impl.TagsRegistryImpl
	 * @see org.eclipse.rcptt.core.tags.impl.TagsPackageImpl#getTagsRegistry()
	 * @generated
	 */
	int TAGS_REGISTRY = 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS_REGISTRY__TAGS = 0;

	/**
	 * The number of structural features of the '<em>Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>EQ7 Named Element</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.model.IQ7NamedElement
	 * @see org.eclipse.rcptt.core.tags.impl.TagsPackageImpl#getEQ7NamedElement()
	 * @generated
	 */
	int EQ7_NAMED_ELEMENT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.tags.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see org.eclipse.rcptt.core.tags.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.tags.Tag#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.core.tags.Tag#getValue()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Value();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.tags.Tag#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Refs</em>'.
	 * @see org.eclipse.rcptt.core.tags.Tag#getRefs()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Refs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.tags.Tag#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.rcptt.core.tags.Tag#getTags()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.tags.TagsRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registry</em>'.
	 * @see org.eclipse.rcptt.core.tags.TagsRegistry
	 * @generated
	 */
	EClass getTagsRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.tags.TagsRegistry#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.rcptt.core.tags.TagsRegistry#getTags()
	 * @see #getTagsRegistry()
	 * @generated
	 */
	EReference getTagsRegistry_Tags();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.rcptt.core.model.IQ7NamedElement <em>EQ7 Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EQ7 Named Element</em>'.
	 * @see org.eclipse.rcptt.core.model.IQ7NamedElement
	 * @model instanceClass="org.eclipse.rcptt.core.model.IQ7NamedElement" serializeable="false"
	 * @generated
	 */
	EDataType getEQ7NamedElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TagsFactory getTagsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.tags.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.tags.impl.TagImpl
		 * @see org.eclipse.rcptt.core.tags.impl.TagsPackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__VALUE = eINSTANCE.getTag_Value();

		/**
		 * The meta object literal for the '<em><b>Refs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__REFS = eINSTANCE.getTag_Refs();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__TAGS = eINSTANCE.getTag_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.tags.impl.TagsRegistryImpl <em>Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.tags.impl.TagsRegistryImpl
		 * @see org.eclipse.rcptt.core.tags.impl.TagsPackageImpl#getTagsRegistry()
		 * @generated
		 */
		EClass TAGS_REGISTRY = eINSTANCE.getTagsRegistry();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAGS_REGISTRY__TAGS = eINSTANCE.getTagsRegistry_Tags();

		/**
		 * The meta object literal for the '<em>EQ7 Named Element</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.model.IQ7NamedElement
		 * @see org.eclipse.rcptt.core.tags.impl.TagsPackageImpl#getEQ7NamedElement()
		 * @generated
		 */
		EDataType EQ7_NAMED_ELEMENT = eINSTANCE.getEQ7NamedElement();

	}

} //TagsPackage
