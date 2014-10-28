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
package org.eclipse.rcptt.internal.launching.ext;

import static org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin.PLUGIN_ID;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.rcptt.internal.launching.ext.Q7UpdateSiteExtensions.Q7RuntimeInfo;
import org.eclipse.rcptt.launching.ext.AUTInformation;
import org.eclipse.rcptt.launching.injection.InjectionConfiguration;
import org.eclipse.rcptt.launching.injection.InjectionFactory;
import org.eclipse.rcptt.launching.injection.UpdateSite;
import org.eclipse.rcptt.launching.internal.target.PDEHelper;
import org.eclipse.rcptt.launching.internal.target.TargetPlatformHelper;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.osgi.framework.Bundle;

public class Q7TargetPlatformInitializer {

	private static final String GMF = "gmf";
	private static final String DRAW2D = "draw2d";
	private static final String GEF = "gef";
	private static final String EMF_FEATURE_GROUP = "org.eclipse.emf.feature.group";
	private static final String EMF_VALIDATION_FEATURE_GROUP = "org.eclipse.emf.validation.feature.group";
	private static final String EMF_TRANSACTION_FEATURE_GROUP = "org.eclipse.emf.transaction.feature.group";
	private static final String EMF_WORKSPACE_FEATURE_GROUP = "org.eclipse.emf.workspace.feature.group";
	public static final String P2_GROUP_FEATURE = "org.eclipse.equinox.p2.type.group";
	public static final String P2_CATEGORY_FEATURE = "org.eclipse.equinox.p2.type.category";

	public static class Q7Info {
		public URI q7;
		public URI aspectj;
		public URI deps;
		public List<URI> extra = new ArrayList<URI>();
	}

	private static final IStatus createError(String message) {
		return createError(message, null);
	}

	private static final IStatus createError(String message, Throwable error) {
		if (message == null && error != null) {
			message = error.getMessage();
		}
		return new Status(IStatus.ERROR, PLUGIN_ID, message, error);
	}

	public static IStatus initialize(ITargetPlatformHelper iinfo,
			IProgressMonitor monitor) {
		monitor.beginTask("Initialize AUT configuration", 100);
		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;

		IStatus rv = iinfo.getStatus();
		if (rv.matches(IStatus.ERROR))
			return rv;

		TargetPlatformHelper info = (TargetPlatformHelper) iinfo;
		Map<String, String> map = AUTInformation.getInformationMap(iinfo);

		String version = map.get(AUTInformation.VERSION);
		if (version == null)
			return createError("Invalid eclipse product location: " + iinfo.getTargetPlatformProfilePath());

		List<Q7RuntimeInfo> updates = Q7UpdateSiteExtensions.getDefault()
				.getRuntimes(version);
		if (updates.size() == 0) {
			return createError("Eclipse platform version " + version
					+ " is not supported");
		}
		Q7Info q7Info = collectQ7Information(updates);
		if (q7Info.q7 == null || q7Info.deps == null || q7Info.aspectj == null) {
			return createError("Eclipse platform version " + version
					+ " is not supported");
		}
		monitor.worked(20);

		try {
			// Check for dependencies
			IMetadataRepository repository = PDEHelper.safeLoadRepository(
					q7Info.q7, new SubProgressMonitor(monitor, 20));
			if (repository == null) {
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				return createError("Failed to load repository from " + q7Info.q7);
			}

			InjectionConfiguration injectionConfiguration = createInjectionConfiguration(
					new NullProgressMonitor(), q7Info, map, repository);
			if (injectionConfiguration != null) {
				info.applyInjection(injectionConfiguration, new SubProgressMonitor(
						monitor, 60));
			}
			return Status.OK_STATUS;
		} catch (CoreException e) {
			return e.getStatus();
		}
	}

	public static InjectionConfiguration createInjectionConfiguration(
			IProgressMonitor monitor, Q7Info q7Info, Map<String, String> map,
			IMetadataRepository repository) {
		boolean hasEMF = map.containsKey(AUTInformation.EMF);
		boolean hasEMFWorkspace = map.containsKey(AUTInformation.EMF_WORKSPACE);
		boolean hasEMFTransaction = map
				.containsKey(AUTInformation.EMF_TRANSACTION);
		boolean hasEMFValidation = map
				.containsKey(AUTInformation.EMF_VALIDATION);
		map.containsKey(AUTInformation.GMF);
		// boolean hasPDE = map.containsKey(AUTInformation.PDE);
		InjectionConfiguration injectionConfiguration = InjectionFactory.eINSTANCE
				.createInjectionConfiguration();

		// Add Q7 plugins
		// List<String> q7Units = collectQ7InstallIDs(monitor, hasGEF, hasGMF,
		// repository);
		UpdateSite q7Site = InjectionFactory.eINSTANCE.createUpdateSite();
		q7Site.setUri(q7Info.q7.toString());
		// Include all Q7 units to install
		// q7Site.getUnits().addAll(q7Units);
		injectionConfiguration.getEntries().add(q7Site);
		
		// Add aspectj plugins
		UpdateSite aspectsSite = InjectionFactory.eINSTANCE.createUpdateSite();
		aspectsSite.setUri(q7Info.aspectj.toString());
		injectionConfiguration.getEntries().add(aspectsSite);

		UpdateSite q7Deps = InjectionFactory.eINSTANCE.createUpdateSite();
		q7Deps.setUri(q7Info.deps.toString());
		if (!hasEMF || !hasEMFWorkspace || !hasEMFTransaction
				|| !hasEMFValidation) {
			if (!hasEMFWorkspace) {
				q7Deps.getUnits().add(EMF_WORKSPACE_FEATURE_GROUP);
			}
			if (!hasEMFTransaction) {
				q7Deps.getUnits().add(EMF_TRANSACTION_FEATURE_GROUP);
			}
			if (!hasEMFValidation) {
				q7Deps.getUnits().add(EMF_VALIDATION_FEATURE_GROUP);
			}
			if (!hasEMF) {
				q7Deps.getUnits().add(EMF_FEATURE_GROUP);
			}
			// if (!hasPDE) {
			// q7Deps.getUnits().add(PDE_FEATURE_GROUP);
			// }
		}
		injectionConfiguration.getEntries().add(q7Deps);
		// Add all from extra
		for (URI extraURI : q7Info.extra) {
			if (monitor.isCanceled()) {
				return null;
			}
			UpdateSite site = InjectionFactory.eINSTANCE.createUpdateSite();
			site.setUri(extraURI.toString());
			site.setAllUnits(true);
			injectionConfiguration.getEntries().add(site);
		}
		return injectionConfiguration;
	}

	@SuppressWarnings("unused")
	private static List<String> collectQ7InstallIDs(IProgressMonitor monitor,
			boolean hasGEF, boolean hasGMF, IMetadataRepository repository) {
		IQueryResult<IInstallableUnit> result = repository.query(
				QueryUtil.ALL_UNITS, monitor);
		List<String> q7Units = new ArrayList<String>();
		for (IInstallableUnit unit : result.toSet()) {
			if (hasProperty(unit, P2_GROUP_FEATURE, "true")) {
				continue;
			}
			if (hasProperty(unit, P2_CATEGORY_FEATURE, "true")) {
				continue;
			}

			// Skip gef/ gmf if not pressent
			String unitId = unit.getId();
			if (!hasGEF) {
				if (unitId.contains(GEF)) {
					continue;
				}
				if (unitId.contains(DRAW2D)) {
					continue;
				}
				if (unitId.contains(GMF)) {
					continue;
				}
			}
			if (!hasGMF) {
				if (unitId.contains(GMF)) {
					continue;
				}
			}
			q7Units.add(unitId);
		}
		return q7Units;
	}

	public static void logError(TargetPlatformHelper info) {
		Q7ExtLaunchingPlugin.getDefault().log(
				"Target platform initialization error:"
						+ info.getErrorMessage(), null);
	}

	public static Q7Info getInfo(ITargetPlatformHelper info) {
		Map<String, String> map = AUTInformation.getInformationMap(info);
		String version = map.get(AUTInformation.VERSION);
		List<Q7RuntimeInfo> updates = Q7UpdateSiteExtensions.getDefault()
				.getRuntimes(version);
		if (updates.size() == 0) {
			return null;
		}
		return collectQ7Information(updates);
	}

	public static Q7Info collectQ7Information(List<Q7RuntimeInfo> updates) {
		Q7Info q7Info = new Q7Info();
		// Initialize updates
		for (Q7RuntimeInfo q7RuntimeInfo : updates) {
			Bundle bundleItem = Platform.getBundle(q7RuntimeInfo.bundle);
			URL entry = null;
			if (q7RuntimeInfo.path != null
					&& q7RuntimeInfo.path.trim().length() > 0) {
				entry = bundleItem.getEntry(new Path(q7RuntimeInfo.path)
						.toString());
			}
			if (entry == null) {
				// Try to resolve as URI entry.
				try {
					entry = new URL(q7RuntimeInfo.path);
				} catch (MalformedURLException e) {
					Q7ExtLaunchingPlugin.getDefault().log(e);
				}
			}
			if (entry == null) {
				Q7ExtLaunchingPlugin.getDefault().log(
						"Failed to locate entry for Q7Runtime:"
								+ bundleItem.getBundleId() + " path:"
								+ q7RuntimeInfo.path, null);
				continue;
			}
			if ("runtime".equals(q7RuntimeInfo.kind)) {
				q7Info.q7 = safeToURI(entry);
			} else if ("dependency".equals(q7RuntimeInfo.kind)) {
				q7Info.deps = safeToURI(entry);
			} else if ("extra".equals(q7RuntimeInfo.kind)) {
				q7Info.extra.add(safeToURI(entry));
			}
			else if ("aspectj".equals(q7RuntimeInfo.kind)) {
				q7Info.aspectj =safeToURI(entry);
			}
		}
		return q7Info;
	}

	private static URI safeToURI(URL q7Entry) {
		URI q7 = null;
		try {
			q7 = q7Entry.toURI();
		} catch (URISyntaxException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
		return q7;
	}

	public static boolean hasProperty(IInstallableUnit unit, String prop,
			String value) {
		if (unit.getProperties().containsKey(prop)) {
			if (unit.getProperties().get(prop).equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static InjectionConfiguration getAspectJInjection(ITargetPlatformHelper targetPlatform,
			IProgressMonitor progressMonitor) {
		Map<String, String> map = AUTInformation
				.getInformationMap(targetPlatform);
		String version = map.get(AUTInformation.VERSION);
		List<Q7RuntimeInfo> updates = Q7UpdateSiteExtensions
				.getDefault().getRuntimes(version);
		if (updates.isEmpty())
			throw new RuntimeException("Failed to find built-in injections for " + version);
		InjectionConfiguration injectionConfiguration = InjectionFactory.eINSTANCE
				.createInjectionConfiguration();
		if (updates != null) {
			Q7Info q7Info = Q7TargetPlatformInitializer
					.collectQ7Information(updates);
			if (q7Info != null) {
				UpdateSite aspectsSite = InjectionFactory.eINSTANCE.createUpdateSite();
				aspectsSite.setUri(q7Info.aspectj.toString());
				injectionConfiguration.getEntries().add(aspectsSite);
			}
		}
		return injectionConfiguration;
	}
}
