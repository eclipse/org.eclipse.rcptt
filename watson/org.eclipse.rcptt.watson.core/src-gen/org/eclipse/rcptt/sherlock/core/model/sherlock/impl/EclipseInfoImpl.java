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
package org.eclipse.rcptt.sherlock.core.model.sherlock.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eclipse Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getWorkspaceLocation <em>Workspace Location</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getApplicationArgs <em>Application Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getUptime <em>Uptime</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl#getPreferences <em>Preferences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EclipseInfoImpl extends EObjectImpl implements EclipseInfo {
	/**
	 * The default value of the '{@link #getWorkspaceLocation() <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspaceLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKSPACE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkspaceLocation() <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspaceLocation()
	 * @generated
	 * @ordered
	 */
	protected String workspaceLocation = WORKSPACE_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected String productId = PRODUCT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationId()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationId()
	 * @generated
	 * @ordered
	 */
	protected String applicationId = APPLICATION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getApplicationArgs() <em>Application Args</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> applicationArgs;

	/**
	 * The default value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildId()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildId()
	 * @generated
	 * @ordered
	 */
	protected String buildId = BUILD_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUptime() <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUptime()
	 * @generated
	 * @ordered
	 */
	protected static final long UPTIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getUptime() <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUptime()
	 * @generated
	 * @ordered
	 */
	protected long uptime = UPTIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlugins() <em>Plugins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugins()
	 * @generated
	 * @ordered
	 */
	protected EList<EclipsePlugin> plugins;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EclipseFeature> features;

	/**
	 * The default value of the '{@link #getWorkspacePartitionTotalDiskspace() <em>Workspace Partition Total Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionTotalDiskspace()
	 * @generated
	 * @ordered
	 */
	protected static final long WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWorkspacePartitionTotalDiskspace() <em>Workspace Partition Total Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionTotalDiskspace()
	 * @generated
	 * @ordered
	 */
	protected long workspacePartitionTotalDiskspace = WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkspacePartitionUsableDiskspace() <em>Workspace Partition Usable Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionUsableDiskspace()
	 * @generated
	 * @ordered
	 */
	protected static final long WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWorkspacePartitionUsableDiskspace() <em>Workspace Partition Usable Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionUsableDiskspace()
	 * @generated
	 * @ordered
	 */
	protected long workspacePartitionUsableDiskspace = WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkspacePartitionFreeDiskspace() <em>Workspace Partition Free Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionFreeDiskspace()
	 * @generated
	 * @ordered
	 */
	protected static final long WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWorkspacePartitionFreeDiskspace() <em>Workspace Partition Free Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionFreeDiskspace()
	 * @generated
	 * @ordered
	 */
	protected long workspacePartitionFreeDiskspace = WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreferences() <em>Preferences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<EclipsePreference> preferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EclipseInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SherlockPackage.Literals.ECLIPSE_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWorkspaceLocation() {
		return workspaceLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkspaceLocation(String newWorkspaceLocation) {
		String oldWorkspaceLocation = workspaceLocation;
		workspaceLocation = newWorkspaceLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__WORKSPACE_LOCATION, oldWorkspaceLocation, workspaceLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProductId() {
		return productId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProductId(String newProductId) {
		String oldProductId = productId;
		productId = newProductId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__PRODUCT_ID, oldProductId, productId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicationId(String newApplicationId) {
		String oldApplicationId = applicationId;
		applicationId = newApplicationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__APPLICATION_ID, oldApplicationId, applicationId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getApplicationArgs() {
		if (applicationArgs == null) {
			applicationArgs = new EDataTypeUniqueEList<String>(String.class, this, SherlockPackage.ECLIPSE_INFO__APPLICATION_ARGS);
		}
		return applicationArgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBuildId() {
		return buildId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildId(String newBuildId) {
		String oldBuildId = buildId;
		buildId = newBuildId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__BUILD_ID, oldBuildId, buildId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getUptime() {
		return uptime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUptime(long newUptime) {
		long oldUptime = uptime;
		uptime = newUptime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__UPTIME, oldUptime, uptime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EclipsePlugin> getPlugins() {
		if (plugins == null) {
			plugins = new EObjectContainmentEList<EclipsePlugin>(EclipsePlugin.class, this, SherlockPackage.ECLIPSE_INFO__PLUGINS);
		}
		return plugins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EclipseFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<EclipseFeature>(EclipseFeature.class, this, SherlockPackage.ECLIPSE_INFO__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getWorkspacePartitionTotalDiskspace() {
		return workspacePartitionTotalDiskspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkspacePartitionTotalDiskspace(long newWorkspacePartitionTotalDiskspace) {
		long oldWorkspacePartitionTotalDiskspace = workspacePartitionTotalDiskspace;
		workspacePartitionTotalDiskspace = newWorkspacePartitionTotalDiskspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE, oldWorkspacePartitionTotalDiskspace, workspacePartitionTotalDiskspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getWorkspacePartitionUsableDiskspace() {
		return workspacePartitionUsableDiskspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkspacePartitionUsableDiskspace(long newWorkspacePartitionUsableDiskspace) {
		long oldWorkspacePartitionUsableDiskspace = workspacePartitionUsableDiskspace;
		workspacePartitionUsableDiskspace = newWorkspacePartitionUsableDiskspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE, oldWorkspacePartitionUsableDiskspace, workspacePartitionUsableDiskspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getWorkspacePartitionFreeDiskspace() {
		return workspacePartitionFreeDiskspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkspacePartitionFreeDiskspace(long newWorkspacePartitionFreeDiskspace) {
		long oldWorkspacePartitionFreeDiskspace = workspacePartitionFreeDiskspace;
		workspacePartitionFreeDiskspace = newWorkspacePartitionFreeDiskspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE, oldWorkspacePartitionFreeDiskspace, workspacePartitionFreeDiskspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EclipsePreference> getPreferences() {
		if (preferences == null) {
			preferences = new EObjectContainmentEList<EclipsePreference>(EclipsePreference.class, this, SherlockPackage.ECLIPSE_INFO__PREFERENCES);
		}
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SherlockPackage.ECLIPSE_INFO__PLUGINS:
				return ((InternalEList<?>)getPlugins()).basicRemove(otherEnd, msgs);
			case SherlockPackage.ECLIPSE_INFO__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case SherlockPackage.ECLIPSE_INFO__PREFERENCES:
				return ((InternalEList<?>)getPreferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_LOCATION:
				return getWorkspaceLocation();
			case SherlockPackage.ECLIPSE_INFO__PRODUCT_ID:
				return getProductId();
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ID:
				return getApplicationId();
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ARGS:
				return getApplicationArgs();
			case SherlockPackage.ECLIPSE_INFO__BUILD_ID:
				return getBuildId();
			case SherlockPackage.ECLIPSE_INFO__UPTIME:
				return getUptime();
			case SherlockPackage.ECLIPSE_INFO__PLUGINS:
				return getPlugins();
			case SherlockPackage.ECLIPSE_INFO__FEATURES:
				return getFeatures();
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				return getWorkspacePartitionTotalDiskspace();
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				return getWorkspacePartitionUsableDiskspace();
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE:
				return getWorkspacePartitionFreeDiskspace();
			case SherlockPackage.ECLIPSE_INFO__PREFERENCES:
				return getPreferences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_LOCATION:
				setWorkspaceLocation((String)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__PRODUCT_ID:
				setProductId((String)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ID:
				setApplicationId((String)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ARGS:
				getApplicationArgs().clear();
				getApplicationArgs().addAll((Collection<? extends String>)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__BUILD_ID:
				setBuildId((String)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__UPTIME:
				setUptime((Long)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__PLUGINS:
				getPlugins().clear();
				getPlugins().addAll((Collection<? extends EclipsePlugin>)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends EclipseFeature>)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				setWorkspacePartitionTotalDiskspace((Long)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				setWorkspacePartitionUsableDiskspace((Long)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE:
				setWorkspacePartitionFreeDiskspace((Long)newValue);
				return;
			case SherlockPackage.ECLIPSE_INFO__PREFERENCES:
				getPreferences().clear();
				getPreferences().addAll((Collection<? extends EclipsePreference>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_LOCATION:
				setWorkspaceLocation(WORKSPACE_LOCATION_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__PRODUCT_ID:
				setProductId(PRODUCT_ID_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ID:
				setApplicationId(APPLICATION_ID_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ARGS:
				getApplicationArgs().clear();
				return;
			case SherlockPackage.ECLIPSE_INFO__BUILD_ID:
				setBuildId(BUILD_ID_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__UPTIME:
				setUptime(UPTIME_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__PLUGINS:
				getPlugins().clear();
				return;
			case SherlockPackage.ECLIPSE_INFO__FEATURES:
				getFeatures().clear();
				return;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				setWorkspacePartitionTotalDiskspace(WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				setWorkspacePartitionUsableDiskspace(WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE:
				setWorkspacePartitionFreeDiskspace(WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_INFO__PREFERENCES:
				getPreferences().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_LOCATION:
				return WORKSPACE_LOCATION_EDEFAULT == null ? workspaceLocation != null : !WORKSPACE_LOCATION_EDEFAULT.equals(workspaceLocation);
			case SherlockPackage.ECLIPSE_INFO__PRODUCT_ID:
				return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ID:
				return APPLICATION_ID_EDEFAULT == null ? applicationId != null : !APPLICATION_ID_EDEFAULT.equals(applicationId);
			case SherlockPackage.ECLIPSE_INFO__APPLICATION_ARGS:
				return applicationArgs != null && !applicationArgs.isEmpty();
			case SherlockPackage.ECLIPSE_INFO__BUILD_ID:
				return BUILD_ID_EDEFAULT == null ? buildId != null : !BUILD_ID_EDEFAULT.equals(buildId);
			case SherlockPackage.ECLIPSE_INFO__UPTIME:
				return uptime != UPTIME_EDEFAULT;
			case SherlockPackage.ECLIPSE_INFO__PLUGINS:
				return plugins != null && !plugins.isEmpty();
			case SherlockPackage.ECLIPSE_INFO__FEATURES:
				return features != null && !features.isEmpty();
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				return workspacePartitionTotalDiskspace != WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				return workspacePartitionUsableDiskspace != WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT;
			case SherlockPackage.ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE:
				return workspacePartitionFreeDiskspace != WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT;
			case SherlockPackage.ECLIPSE_INFO__PREFERENCES:
				return preferences != null && !preferences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (workspaceLocation: ");
		result.append(workspaceLocation);
		result.append(", productId: ");
		result.append(productId);
		result.append(", applicationId: ");
		result.append(applicationId);
		result.append(", applicationArgs: ");
		result.append(applicationArgs);
		result.append(", buildId: ");
		result.append(buildId);
		result.append(", uptime: ");
		result.append(uptime);
		result.append(", workspacePartitionTotalDiskspace: ");
		result.append(workspacePartitionTotalDiskspace);
		result.append(", workspacePartitionUsableDiskspace: ");
		result.append(workspacePartitionUsableDiskspace);
		result.append(", workspacePartitionFreeDiskspace: ");
		result.append(workspacePartitionFreeDiskspace);
		result.append(')');
		return result.toString();
	}

} //EclipseInfoImpl
