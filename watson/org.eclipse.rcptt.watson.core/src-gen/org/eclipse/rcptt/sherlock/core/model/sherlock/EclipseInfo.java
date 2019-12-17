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
package org.eclipse.rcptt.sherlock.core.model.sherlock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eclipse Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspaceLocation <em>Workspace Location</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getProductId <em>Product Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationArgs <em>Application Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getUptime <em>Uptime</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getPreferences <em>Preferences</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo()
 * @model
 * @generated
 */
public interface EclipseInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Workspace Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Location</em>' attribute.
	 * @see #setWorkspaceLocation(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_WorkspaceLocation()
	 * @model
	 * @generated
	 */
	String getWorkspaceLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspaceLocation <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Location</em>' attribute.
	 * @see #getWorkspaceLocation()
	 * @generated
	 */
	void setWorkspaceLocation(String value);

	/**
	 * Returns the value of the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Id</em>' attribute.
	 * @see #setProductId(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_ProductId()
	 * @model
	 * @generated
	 */
	String getProductId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getProductId <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Id</em>' attribute.
	 * @see #getProductId()
	 * @generated
	 */
	void setProductId(String value);

	/**
	 * Returns the value of the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Id</em>' attribute.
	 * @see #setApplicationId(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_ApplicationId()
	 * @model
	 * @generated
	 */
	String getApplicationId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationId <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Id</em>' attribute.
	 * @see #getApplicationId()
	 * @generated
	 */
	void setApplicationId(String value);

	/**
	 * Returns the value of the '<em><b>Application Args</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Args</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Args</em>' attribute list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_ApplicationArgs()
	 * @model
	 * @generated
	 */
	EList<String> getApplicationArgs();

	/**
	 * Returns the value of the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Id</em>' attribute.
	 * @see #setBuildId(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_BuildId()
	 * @model
	 * @generated
	 */
	String getBuildId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getBuildId <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Id</em>' attribute.
	 * @see #getBuildId()
	 * @generated
	 */
	void setBuildId(String value);

	/**
	 * Returns the value of the '<em><b>Uptime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uptime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uptime</em>' attribute.
	 * @see #setUptime(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Uptime()
	 * @model
	 * @generated
	 */
	long getUptime();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getUptime <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uptime</em>' attribute.
	 * @see #getUptime()
	 * @generated
	 */
	void setUptime(long value);

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Plugins()
	 * @model containment="true"
	 * @generated
	 */
	EList<EclipsePlugin> getPlugins();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<EclipseFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Workspace Partition Total Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Partition Total Diskspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Partition Total Diskspace</em>' attribute.
	 * @see #setWorkspacePartitionTotalDiskspace(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_WorkspacePartitionTotalDiskspace()
	 * @model
	 * @generated
	 */
	long getWorkspacePartitionTotalDiskspace();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Partition Total Diskspace</em>' attribute.
	 * @see #getWorkspacePartitionTotalDiskspace()
	 * @generated
	 */
	void setWorkspacePartitionTotalDiskspace(long value);

	/**
	 * Returns the value of the '<em><b>Workspace Partition Usable Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Partition Usable Diskspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Partition Usable Diskspace</em>' attribute.
	 * @see #setWorkspacePartitionUsableDiskspace(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_WorkspacePartitionUsableDiskspace()
	 * @model
	 * @generated
	 */
	long getWorkspacePartitionUsableDiskspace();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Partition Usable Diskspace</em>' attribute.
	 * @see #getWorkspacePartitionUsableDiskspace()
	 * @generated
	 */
	void setWorkspacePartitionUsableDiskspace(long value);

	/**
	 * Returns the value of the '<em><b>Workspace Partition Free Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Partition Free Diskspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Partition Free Diskspace</em>' attribute.
	 * @see #setWorkspacePartitionFreeDiskspace(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_WorkspacePartitionFreeDiskspace()
	 * @model
	 * @generated
	 */
	long getWorkspacePartitionFreeDiskspace();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Partition Free Diskspace</em>' attribute.
	 * @see #getWorkspacePartitionFreeDiskspace()
	 * @generated
	 */
	void setWorkspacePartitionFreeDiskspace(long value);

	/**
	 * Returns the value of the '<em><b>Preferences</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferences</em>' containment reference list.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Preferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<EclipsePreference> getPreferences();

} // EclipseInfo
