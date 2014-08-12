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
package org.eclipse.rcptt.ecl.platform.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class PlatformPlugin extends Plugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.platform";

	private static PlatformPlugin plugin;

	public static PlatformPlugin getDefault() {
		return plugin;
	}

	private BundleContext bundleContext;

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		bundleContext = context;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		bundleContext = null;
		super.stop(context);
	}

	public Bundle[] getBundles() {
		return bundleContext == null ? new Bundle[0] : bundleContext
				.getBundles();
	}

	public static IStatus err(String message, Throwable t) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, t);
	}

	@SuppressWarnings("unchecked")
	public static IProvisioningAgent getProvisioningAgent() {
		BundleContext bc = getDefault().bundleContext;
		@SuppressWarnings("rawtypes")
		ServiceReference reference = bc.getServiceReference(IProvisioningAgent.SERVICE_NAME);
		if (reference == null)
			return null;
		Object service = bc.getService(reference);
		if (service != null) {
			bc.ungetService(reference);
		}
		return (IProvisioningAgent) service;
	}

	public static IMetadataRepositoryManager getMetadataMgr() {
		return (IMetadataRepositoryManager) getProvisioningAgent().getService(
				IMetadataRepositoryManager.SERVICE_NAME);
	}

	public static IArtifactRepositoryManager getArtifactMgr() {
		return (IArtifactRepositoryManager) getProvisioningAgent().getService(
				IArtifactRepositoryManager.SERVICE_NAME);
	}

	public static ProvisioningSession createProvisioningSession() {
		return new ProvisioningSession(getProvisioningAgent());
	}

	public static IProfileRegistry getProfileRegistry() {
		return (IProfileRegistry) getProvisioningAgent().getService(
				IProfileRegistry.SERVICE_NAME);
	}
}
