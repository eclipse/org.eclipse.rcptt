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
package org.eclipse.rcptt.launching.internal.target;

import static com.google.common.base.Charsets.UTF_8;
import static java.util.Collections.emptyList;
import static org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin.PLUGIN_ID;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.frameworkadmin.BundleInfo;
import org.eclipse.equinox.internal.simpleconfigurator.utils.SimpleConfiguratorUtils;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.osgi.service.resolver.ResolverError;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PDEExtensionRegistry;
import org.eclipse.pde.internal.core.PDEState;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.core.target.DirectoryBundleContainer;
import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.pde.internal.core.target.P2TargetUtils;
import org.eclipse.pde.internal.core.target.ProfileBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.IBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.IResolvedBundle;
import org.eclipse.pde.internal.core.target.provisional.ITargetDefinition;
import org.eclipse.pde.internal.core.target.provisional.ITargetPlatformService;
import org.eclipse.pde.internal.launching.launcher.LaunchValidationOperation;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.launching.ext.AJConstants;
import org.eclipse.rcptt.internal.launching.ext.OSArchitecture;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin;
import org.eclipse.rcptt.launching.ext.OriginalOrderProperties;
import org.eclipse.rcptt.launching.ext.Q7LaunchDelegateUtils;
import org.eclipse.rcptt.launching.injection.Directory;
import org.eclipse.rcptt.launching.injection.Entry;
import org.eclipse.rcptt.launching.injection.InjectionConfiguration;
import org.eclipse.rcptt.launching.injection.UpdateSite;
import org.eclipse.rcptt.launching.p2utils.P2Utils;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.rcptt.launching.target.TargetPlatformManager;
import org.eclipse.rcptt.util.FileUtil;
import org.osgi.framework.Version;

import com.google.common.collect.Iterables;
import com.google.common.io.Files;

@SuppressWarnings("restriction")
public class TargetPlatformHelper implements ITargetPlatformHelper {
	public static final String IDE_APPLICATION = "org.eclipse.ui.ide.workbench";
	public static final String APPLICATION_PROPERTY = "eclipse.application"; //$NON-NLS-1$
	public static final String PRODUCT_PROPERTY = "eclipse.product"; //$NON-NLS-1$
	private static final String ID_PROPERTY = "id"; //$NON-NLS-1$
	private static final String OSGI_BUNDLES = "osgi.bundles";
	private static final String SIMPLECONFIGURATOR = "org.eclipse.equinox.simpleconfigurator"; //$NON-NLS-1$
	private static final String SC_BUNDLES_PATH = "configuration/org.eclipse.equinox.simpleconfigurator/bundles.info"; //$NON-NLS-1$
	private IStatus status = Status.OK_STATUS;
	private final ITargetDefinition target;
	private final ArrayList<IBundleContainer> extra = new ArrayList<IBundleContainer>();
	private IPluginModelBase[] models;
	private PDEExtensionRegistry registry;

	private Q7Target q7target = new Q7Target();

	public TargetPlatformHelper(ITargetDefinition target) {
		this.target = target;
		initialize();
	}


	public Q7Target getQ7Target() {
		return q7target;
	}

	@Deprecated
	/** Use getStatus().isOK() instead */
	public boolean isValid() {
		return getStatus().isOK();
	}

	public boolean isResolved() {
		if (target != null) {
			return target.isResolved();
		}
		return false;
	}

	public boolean isInstanceContainerValid() {
		return getInstanceContainer() != null
				&& getInstanceContainer().getStatus().isOK();
	}

	public IStatus getStatus() {
		if (status == null) {
			return new Status(IStatus.ERROR, PLUGIN_ID, "Target platform is unset");
		}
		return status;
	}

	@Deprecated
	public String getErrorMessage() {
		return getNonMultiStatusMessage(getStatus());
	}

	public String getWarningMessage() {
		if (target != null) {
			IStatus bundleStatus = getBundleWarningStatus();
			return getNonMultiStatusMessage(bundleStatus);
		}
		return null;
	}

	public IStatus getBundleStatus() {
		IBundleContainer[] containers = getBundleContainers();
		if (containers != null) {
			// Check if the containers have any resolution problems
			MultiStatus result = new MultiStatus(
					PDECore.PLUGIN_ID,
					0,
					org.eclipse.pde.internal.core.target.Messages.TargetDefinition_5,
					null);
			for (int i = 0; i < containers.length; i++) {
				IBundleContainer container = containers[i];
				IStatus containerStatus = container.getStatus();
				if (containerStatus != null && !containerStatus.isOK()) {
					result.add(containerStatus);
				}
			}
			if (!result.isOK()) {
				return result;
			}

			// Check if any of the included bundles have problems
			// build status from bundle list
			IResolvedBundle[] bundles = target.getBundles();
			for (int i = 0; i < bundles.length; i++) {
				IResolvedBundle bundle = bundles[i];
				if (!bundle.getStatus().isOK()) {
					BundleInfo info = bundle.getBundleInfo();
					URI uri = info.getLocation();
					if (uri != null) {
						File file = new File(uri);
						if (!file.exists()) {
							reportUnexistingFile(info);
							continue;
						}
					}
					result.add(bundle.getStatus());
				}
			}

			if (result.isOK()) {
				// Return generic ok status instead of problem multi-status with
				// no children
				return Status.OK_STATUS;
			}
			return result;
		}
		return Status.OK_STATUS;
	}

	private void reportUnexistingFile(BundleInfo info) {
		// Skip problem of unexisted file.
		Q7LaunchingPlugin.log(Q7LaunchingPlugin.createStatus(IStatus.WARNING,
				"Skip unexisted bundle: " + info.getSymbolicName()
						+ ", then resolve configuration.", null));
	}

	public IStatus getBundleWarningStatus() {
		IBundleContainer[] containers = getBundleContainers();
		if (containers != null) {
			// Check if the containers have any resolution problems
			MultiStatus result = new MultiStatus(
					PDECore.PLUGIN_ID,
					0,
					org.eclipse.pde.internal.core.target.Messages.TargetDefinition_5,
					null);

			// Check if any of the included bundles have problems
			// build status from bundle list
			IResolvedBundle[] bundles = target.getBundles();
			for (int i = 0; i < bundles.length; i++) {
				IResolvedBundle bundle = bundles[i];
				IStatus status = bundle.getStatus();
				if (!status.isOK()) {
					BundleInfo info = bundle.getBundleInfo();
					URI uri = info.getLocation();
					if (uri != null) {
						File file = new File(uri);
						if (!file.exists()) {
							// Skip problem of unexisted file.
							IStatus st = new Status(IStatus.WARNING,
									status.getPlugin(), status.getMessage(),
									status.getException());
							result.add(st);
						}
					}

				}
			}

			if (result.isOK()) {
				// Return generic ok status instead of problem multi-status with
				// no children
				return Status.OK_STATUS;
			}
			return result;
		}
		return Status.OK_STATUS;
	}

	private String getNonMultiStatusMessage(IStatus st) {
		if (st != null && st.isMultiStatus()) {
			StringBuilder buf = new StringBuilder();
			IStatus[] children = st.getChildren();
			for (IStatus iStatus : children) {
				if (iStatus.isMultiStatus()) {
					String msg = getNonMultiStatusMessage(iStatus);
					if (msg != null) {
						buf.append(msg).append('\n');
					}
				}
				if (!iStatus.isOK()) {
					buf.append(iStatus.getMessage()).append('\n');
				}
			}
			return buf.toString();
		}
		return st == null ? "" : st.getMessage();
	}

	private void initialize() {
		extra.clear();
		q7target = new Q7Target();
		if (this.target != null && this.target.getBundleContainers() != null) {
			IBundleContainer[] containers = this.target.getBundleContainers();
			for (IBundleContainer iUBundleContainer : containers) {
				if (iUBundleContainer instanceof ProfileBundleContainer) {
					getQ7Target().setInstall(iUBundleContainer);
				} else if (iUBundleContainer instanceof DirectoryBundleContainer) {
					getQ7Target().pluginsDir = iUBundleContainer;
				} else {
					getQ7Target().addExtra(iUBundleContainer);
				}
				extra.add(iUBundleContainer);
			}
		}
	}

	public void setTargetName(String name) {
		if (target != null) {
			target.setName(name);
		}
	}

	public String getName() {
		if (target != null) {
			return target.getName();
		}
		return "";
	}

	public void save() {
		// Remove previous target platforms with same name.
		if (target != null) {
			TargetPlatformManager.deleteTargetPlatform(target.getName());
			try {
				ITargetPlatformService service = PDEHelper.getTargetService();
				service.saveTargetDefinition(target);
			} catch (CoreException e) {
				Q7ExtLaunchingPlugin.getDefault().log(e);
			}
		}
	}

	public String getTargetPlatformProfilePath() {
		ProfileBundleContainer container = (ProfileBundleContainer) getInstanceContainer();
		try {
			return container.getLocation(true).toString();
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete() {
		try {
			if (target != null && target.getHandle() != null) {
				PDEHelper.getTargetService().deleteTarget(target.getHandle());
			}
		} catch (CoreException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
	}

	public ITargetDefinition getTarget() {
		return target;
	}

	public void update() {
		List<IBundleContainer> newContainers = new ArrayList<IBundleContainer>();
		newContainers.addAll(Arrays.asList(target.getBundleContainers()));

		if (extra != null) {
			newContainers.addAll(extra);
		}
		target.setBundleContainers(newContainers
				.toArray(new IBundleContainer[newContainers.size()]));
		models = null;
		registry = null;
	}

	public IPluginModelBase[] getTargetModels() {
		calcModels();
		return models;
	}

	@Override
	public IPluginModelBase getWeavingHook() {
		calcModels();
		return weavingHook;
	}

	private void calcModels() {
		if (models == null) {
			List<IPluginModelBase> bundles = sumBundles();
			weavingHook = filterHooks(bundles);
			models = bundles.toArray(new IPluginModelBase[0]);
		}
	}

	private List<IPluginModelBase> sumBundles() {
		IResolvedBundle[] bundles = getTarget().getAllBundles();
		if (bundles == null) {
			return new ArrayList<IPluginModelBase>();
		}
		List<URL> urls = new ArrayList<URL>();
		for (IResolvedBundle bundle : bundles) {
			try {
				urls.add(new URL("file://"
						+ bundle.getBundleInfo().getLocation().getPath()));
			} catch (MalformedURLException e) {
				Q7ExtLaunchingPlugin.getDefault().log(e);
			}
		}

		PDEState state = new PDEState(new URL[0], urls.toArray(new URL[urls
				.size()]), true, true, new NullProgressMonitor());
		return new ArrayList<IPluginModelBase>(Arrays.asList(state
				.getTargetModels()));
	}

	private IPluginModelBase filterHooks(List<IPluginModelBase> models) {
		List<IPluginModelBase> hooks = new ArrayList<IPluginModelBase>();
		for (IPluginModelBase model : models) {
			String name = model.getBundleDescription().getSymbolicName();
			if (name.equals(AJConstants.HOOK)) {
				hooks.add(model);
			}
		}
		switch (hooks.size()) {
		case 0:
			// no weaving hook
			return null;
		case 1:
			// one weaving hook, nothing to filter
			return hooks.get(0);
		default:
			// find a hook with the latest version, remove other hooks
			IPluginModelBase maxHook = hooks.get(0);
			for (int i = 1; i < hooks.size(); i++) {
				IPluginModelBase hook = hooks.get(i);
				if (hook.getBundleDescription().getVersion()
						.compareTo(maxHook.getBundleDescription().getVersion()) > 0) {
					maxHook = hook;
				}
			}
			hooks.remove(maxHook);
			models.removeAll(hooks);
			return maxHook;
		}
	}

	private IPluginModelBase weavingHook;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IStatus validateBundles(IProgressMonitor monitor) {
		LaunchValidationOperation validation = new LaunchValidationOperation(
				null) {
			@Override
			protected IPluginModelBase[] getModels() throws CoreException {
				return getTargetModels();
			}

			@Override
			protected IExecutionEnvironment[] getMatchingEnvironments()
					throws CoreException {
				IExecutionEnvironmentsManager manager = JavaRuntime
						.getExecutionEnvironmentsManager();
				IExecutionEnvironment[] envs = manager
						.getExecutionEnvironments();
				return envs;
			}
		};
		try {
			StringBuilder b = new StringBuilder();
			validation.run(monitor);
			Map input = validation.getInput();
			Set<Map.Entry> entrySet = input.entrySet();
			for (Map.Entry e : entrySet) {
				Object value = e.getKey();
				if (value instanceof ResolverError) {
					b.append(value.toString()).append("\n");
				}
			}
			if (b.length() > 0) {
				return new Status(IStatus.ERROR, PLUGIN_ID, "Bundle validation failed: " + b.toString());
			}
			if (getWeavingHook() == null) {
				return new Status(IStatus.ERROR, PLUGIN_ID, "No " + AJConstants.HOOK + " plugin");
			}
		} catch (CoreException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
			return status = e.getStatus();
		} catch (OperationCanceledException e) {
			return status = Status.CANCEL_STATUS;
		}
		return status = Status.OK_STATUS;
	}

	public String[] getProducts() {
		if (!isValid()) {
			return new String[0];
		}
		PDEExtensionRegistry reg = getRegistry();
		Set<String> result = new TreeSet<String>();
		IExtension[] extensions = reg.findExtensions("org.eclipse.core.runtime.products", false); //$NON-NLS-1$
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i]
					.getConfigurationElements();
			if (elements.length != 1)
				continue;
			if (!"product".equals(elements[0].getName())) //$NON-NLS-1$
				continue;
			String id = extensions[i].getUniqueIdentifier();
			if (id != null && id.trim().length() > 0)
				result.add(id);
		}
		return result.toArray(new String[result.size()]);
	}

	public String[] getApplications() {
		if (!isValid()) {
			return new String[0];
		}
		PDEExtensionRegistry reg = getRegistry();

		Set<String> result = new TreeSet<String>();
		IExtension[] extensions = reg.findExtensions("org.eclipse.core.runtime.applications", false); //$NON-NLS-1$
		for (int i = 0; i < extensions.length; i++) {
			String id = extensions[i].getUniqueIdentifier();
			IConfigurationElement[] elements = extensions[i]
					.getConfigurationElements();
			if (elements.length != 1)
				continue;
			String visiblity = elements[0].getAttribute("visible"); //$NON-NLS-1$
			boolean visible = visiblity == null ? true : Boolean.valueOf(
					visiblity).booleanValue();
			if (id != null && visible) {
				result.add(id);
			}
		}
		//		result.add(IDE_APPLICATION); //$NON-NLS-1$
		return result.toArray(new String[result.size()]);
	}

	private PDEExtensionRegistry getRegistry() {
		if (registry == null) {
			registry = new PDEExtensionRegistry(getTargetModels());
		}
		return registry;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		ITargetDefinition target = getTarget();
		if (target != null) {
			return status = target.resolve(monitor);
		}
		return status = Status.CANCEL_STATUS;
	}

	public OriginalOrderProperties getConfigIniProperties() {
		File iniFile = new File(getTargetPlatformProfilePath(), "configuration/config.ini"); //$NON-NLS-1$
		OriginalOrderProperties pini = new OriginalOrderProperties();
		if (!iniFile.exists())
			return pini;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(iniFile);
			pini.load(fis);
			fis.close();
			return pini;
		} catch (IOException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				Q7ExtLaunchingPlugin.getDefault().log(e);
			}
		}
		return pini;
	}

	protected String getEclipseProductFileProperty(String name) {
		Properties props = getEclipseProductFileProperties();
		return props == null ? null : props.getProperty(name);
	}

	public Properties getEclipseProductFileProperties() {
		File iniFile = new File(getTargetPlatformProfilePath(), ".eclipseproduct"); //$NON-NLS-1$
		if (!iniFile.exists())
			return null;
		Properties pini = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(iniFile);
			pini.load(fis);
			fis.close();
			return pini;
		} catch (IOException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				Q7ExtLaunchingPlugin.getDefault().log(e);
			}
		}
		return null;
	}

	public String getDefaultApplication() {
		String app = getConfigIniProperty(APPLICATION_PROPERTY);
		HashSet<String> apps = new HashSet<String>(
				Arrays.asList(getApplications()));
		return isValidId(app, apps) ? app
				: (isValidId(IDE_APPLICATION, apps) ? IDE_APPLICATION : null);
	}

	public String getBundlesList() {
		String bundles = getConfigIniProperty(OSGI_BUNDLES);
		return bundles == null ? org.eclipse.pde.internal.core.TargetPlatformHelper
				.getDefaultBundleList()
				: org.eclipse.pde.internal.core.TargetPlatformHelper
						.stripPathInformation(bundles);
	}

	protected String getConfigIniProperty(String name) {
		Properties config = getConfigIniProperties();
		if (config == null) {
			return null;
		}
		return config.getProperty(name);
	}

	protected boolean isValidId(String id, Set<String> available) {
		return id == null ? false : available.contains(id);
	}

	public String getDefaultProduct() {
		Set<String> values = new HashSet<String>(Arrays.asList(getProducts()));
		String product = null;
		String productProperty = getConfigIniProperty(PRODUCT_PROPERTY);
		if (isValidId(productProperty, values)) {
			product = productProperty;
		}

		// Try to load .eclipseproduct file
		productProperty = getEclipseProductFileProperty(ID_PROPERTY);
		if (isValidId(productProperty, values)) {
			product = productProperty;
		}

		// Try to load from application ini file
		List<File> iniFiles = getAppIniFiles();
		for (File file : iniFiles) {
			productProperty = readProductFromIniFile(file);
			if (isValidId(productProperty, values)) {
				product = productProperty;
			}
		}
		return product;
	}

	public IBundleContainer[] getBundleContainers() {
		if (target == null) {
			return new IBundleContainer[0];
		}
		IBundleContainer[] bundleContainers = target.getBundleContainers();
		if (bundleContainers == null) {
			return new IBundleContainer[0];
		}
		return bundleContainers;
	}

	public IResolvedBundle[] getAllBundles() {
		if (target == null) {
			return new IResolvedBundle[0];
		}
		return target.getAllBundles();
	}

	public IFeatureModel[] getAllFeatures() {
		if (target == null) {
			return new IFeatureModel[0];
		}
		return target.getAllFeatures();
	}

	private InjectionConfiguration injectConfig;

	// Repository for all update site injections
	@SuppressWarnings("unused")
	private IFileArtifactRepository repository;

	public InjectionConfiguration getInjectConfig() {
		return injectConfig;
	}

	public IStatus applyInjection(InjectionConfiguration configuration,
			IProgressMonitor monitor) {
		injectConfig = configuration;
		// remove the "host" from bundles, it is handled in a separate, special
		// way
		Iterables.removeAll(extra, Arrays.asList(getInstanceContainer()));

		EList<Entry> entries = configuration.getEntries();
		monitor.beginTask("Apply injection plugins", 20 + entries.size() * 20);
		for (Entry entry : entries) {
			SubProgressMonitor mon = new SubProgressMonitor(monitor, 20);
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			IStatus result = new Status(IStatus.ERROR, PLUGIN_ID, "Unknown injection type: "
					+ entry.getClass().getName());
			if (entry instanceof UpdateSite) {
				result = processUpdateSite(mon, (UpdateSite) entry);
			} else if (entry instanceof Directory) {
				result = processDirectory(mon, (Directory) entry);
			}
			if (result.matches(IStatus.ERROR |IStatus.CANCEL)) {
				return result;
			}
		}
		update();
		IStatus resolveStatus = resolve(monitor);
		if (!resolveStatus.isOK()) {
			return resolveStatus;
		}
		save();
		return validateBundles(monitor);
	}

	private IStatus processDirectory(IProgressMonitor monitor, Directory entry) {
		String path = entry.getPath();
		MultiStatus rv = new MultiStatus(PLUGIN_ID, 0, "Processing " + path, null);
		if (path.startsWith("platform:///")) {
			// if path is platform uri, lets resolve it to file
			try {
				URL resolve = FileLocator.resolve(URI.create(path).toURL());
				path = resolve.getPath();
			} catch (MalformedURLException e) {
				rv.add(new Status(IStatus.WARNING, PLUGIN_ID, e.getMessage(), e));
			} catch (IOException e) {
				rv.add(new Status(IStatus.WARNING, PLUGIN_ID, e.getMessage(), e));
			}
		}
		IBundleContainer container = PDEHelper.getTargetService()
				.newDirectoryContainer(path);
		q7target.addExtra(container);
		extra.add(container);
		return Status.OK_STATUS;
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

	private IStatus processUpdateSite(IProgressMonitor monitor, UpdateSite site) {
		try {
			URI uri = URI.create(site.getUri());
			IMetadataRepository repository = PDEHelper.safeLoadRepository(uri,
					monitor);
			IArtifactRepository artifactRepository = PDEHelper
					.safeLoadArtifactRepository(uri, monitor);
			if (repository == null || artifactRepository == null) {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				return createError("Failed to load update site:" + uri);
			}

			List<IInstallableUnit> unitsToInstall = new ArrayList<IInstallableUnit>();

			// Query for all entries and then choose required.
			IQuery<IInstallableUnit> finalQuery = P2Utils.createQuery(site);

			IQueryResult<IInstallableUnit> result = repository.query(finalQuery,
					monitor);
			Set<IInstallableUnit> availableUnits = result.toSet();

			if (site.isAllUnits()) {
				unitsToInstall.addAll(availableUnits);
			} else {
				P2Utils.expandFeatures(monitor, repository, availableUnits);

				Set<String> unitIDs = P2Utils.mapUnitsToId(availableUnits);
				Set<String> missingUnits = new HashSet<String>(site.getUnits());
				missingUnits.removeAll(unitIDs);
				if (!missingUnits.isEmpty()) { // Some units are not available
					return createError("Few units are not available:"
							+ Arrays.toString(missingUnits.toArray()));
				}
				unitsToInstall.addAll(availableUnits);
			}
			if (unitsToInstall.size() > 0) {
				IInstallableUnit[] unitsAsArray = unitsToInstall
						.toArray(new IInstallableUnit[unitsToInstall.size()]);
				URI[] uriArray = new URI[] { uri };

				IBundleContainer container = PDEHelper.getTargetService()
						.newIUContainer(unitsAsArray, uriArray,
								IUBundleContainer.INCLUDE_ALL_ENVIRONMENTS);

				extra.add(container);
				q7target.addExtra(container);

			}

			// Lets mirror all required artifacts into bundle pool, since we don't
			// really trust P2.

			IFileArtifactRepository filesRepository = P2TargetUtils
					.getBundlePool();

			List<IInstallableUnit> toInstall = new ArrayList<IInstallableUnit>();
			toInstall.addAll(unitsToInstall);
			P2Utils.installUnits(monitor, artifactRepository, filesRepository,
					toInstall, 10, null, false, P2Utils.getProvisioningAgent());
			MultiStatus rv = new MultiStatus(PLUGIN_ID, 0, "Failed to install next units from repository: "
					+ repository.getName(), null);
			if (toInstall.size() > 0) {
				// Not all plugins are installed.
				for (IInstallableUnit u : toInstall) {
					rv.add(createError(u.getId()));
				}
				return rv;
			}
		} catch (CoreException e) {
			return e.getStatus();
		}

		return Status.OK_STATUS;
	}

	public String getIniVMArgs() {
		List<File> iniFiles = getAppIniFiles();
		for (File file : iniFiles) {
			String vmArgs = readVMArgsFromIniFile(file);
			if (vmArgs != null) {
				return vmArgs;
			}
		}
		return null;
	}

	private List<File> getAppIniFiles() {
		List<File> iniFiles = new ArrayList<File>();
		if (getInstanceContainer() == null) {
			return iniFiles;
		}
		File installDirectory = new File(getTargetPlatformProfilePath());

		if (!installDirectory.exists()) {
			return iniFiles;
		}

		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			File[] listFiles = installDirectory.listFiles();
			for (File file : listFiles) {
				if (file.getName().contains(".app")) {
					installDirectory = new File(file, "/Contents/MacOS");
					break;
				}
			}
		}

		File eclipseIniFile = new File(installDirectory, "eclipse.ini"); //$NON-NLS-1$
		if (eclipseIniFile.exists()) {
			iniFiles.add(eclipseIniFile);
			return iniFiles;
		}
		File[] list = installDirectory.listFiles();
		if (list != null) {
			for (File file : list) {
				if (file.getName().endsWith(".ini")) {
					iniFiles.add(file);
				}
			}
		}
		return iniFiles;
	}

	private String readProductFromIniFile(File eclipseIniFile) {
		BufferedReader in = null;
		if (eclipseIniFile.exists()) {
			try {
				in = new BufferedReader(new FileReader(eclipseIniFile));
				String str;
				while ((str = in.readLine()) != null) {
					if (str.trim().equals("-product")) { //$NON-NLS-1$
						String product = in.readLine();
						if (product != null) {
							return product.trim();
						}
					}
				}
			} catch (IOException e) {
				Q7ExtLaunchingPlugin.getDefault().log(e);
			} finally {
				if (in != null)
					try {
						in.close();
					} catch (IOException e) {
						Q7ExtLaunchingPlugin.getDefault().log(e);
					}
			}
		}
		return null;
	}

	@SuppressWarnings("resource")
	private String readLauncherLibraryFromIniFile(File eclipseIniFile) {
		BufferedReader in = null;
		try {
			if (eclipseIniFile.exists()) {
				in = new BufferedReader(new FileReader(eclipseIniFile));
				String str;
				while ((str = in.readLine()) != null) {
					if (str.trim().equals("--launcher.library")) { //$NON-NLS-1$
						String result = in.readLine();
						if (result != null) {
							return result.trim();
						}
					}
				}
			}
		} catch (IOException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		} finally {
			FileUtil.safeClose(in);
		}
		return null;
	}

	private static final String VMARGS = "-vmargs";
	private static final String VM = "-vm";

	private List<String> parseIniFile(File eclipseIni) {
		if (eclipseIni == null || !eclipseIni.exists()) {
			return emptyList();
		}

		List<String> result = new ArrayList<String>();
		try {
			for (String line : Files.readLines(eclipseIni, UTF_8)) {
				line = line.trim();
				if (line.length() > 0 && line.charAt(0) != '#') {
					result.add(line);
				}
			}
		} catch (IOException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
		return result;
	}

	private String getVmArg(File eclipseIniFile) {
		List<String> lines = parseIniFile(eclipseIniFile);
		int vmIndex = lines.indexOf("-vm") + 1;
		return vmIndex == 0 || vmIndex == lines.size() ? null : lines
				.get(vmIndex);
	}

	public String getVmFromIniFile() {
		for (File file : getAppIniFiles()) {
			String result = getVmArg(file);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	private String readVMArgsFromIniFile(File eclipseIniFile) {
		if (!eclipseIniFile.exists()) {
			return null;
		}

		List<String> lines = parseIniFile(eclipseIniFile);
		int vmargsIndex = lines.indexOf(VMARGS);
		if (vmargsIndex == -1) {
			return null;
		}
		lines = lines.subList(vmargsIndex + 1, lines.size());
		int vmIndex = lines.indexOf(VM);
		if (vmIndex != -1) {
			lines.subList(vmIndex, Math.min(vmIndex + 2, lines.size())).clear();
		}

		if (lines.isEmpty()) {
			return null;
		}

		return Q7LaunchDelegateUtils.joinCommandArgs(lines);
	}

	public String getTemplateConfigLocation() {
		File iniFile = new File(getTargetPlatformProfilePath(), "configuration/config.ini"); //$NON-NLS-1$
		if (!iniFile.exists())
			return null;
		return iniFile.getAbsolutePath();
	}

	public OSArchitecture detectArchitecture(
			boolean preferCurrentVmArchitecture, StringBuilder detectMsg) {

		// http://stackoverflow.com/a/808314
		final boolean isCurrentVm64 = System.getProperty("os.arch", "not null")
				.contains("64");

		boolean has32 = false;
		boolean has64 = false;

		String launcher64 = null;
		String launcher32 = null;

		List<File> iniFiles = getAppIniFiles();
		IPath targetPlatformProfilePath = new Path(
				getTargetPlatformProfilePath());
		Set<String> availableLaunchers = new HashSet<String>();
		String os = Platform.getOS();
		for (File file : iniFiles) {
			String launcherLibrary = readLauncherLibraryFromIniFile(file);
			if (launcherLibrary != null && launcherLibrary.contains(os)) {
				String configPath = new Path(file.getAbsolutePath())
						.removeFirstSegments(
								targetPlatformProfilePath.segmentCount())
						.setDevice(null).toOSString();
				if (launcherLibrary.contains("x86_64")) {
					has64 = true;
					launcher64 = "launcher library\n\t\"" + launcherLibrary
							+ "\" specified in config file: " + configPath;
				} else if (launcherLibrary.contains("x86")
						|| launcherLibrary.contains("cocoa.macosx")) {
					has32 = true;
					launcher32 = "launcher library\n\t\"" + launcherLibrary
							+ "\" specified in config file: " + configPath;
				}
			}
		}
		if (!has32 && !has64) {
			IResolvedBundle[] bundles = target.getAllBundles();
			for (IResolvedBundle b : bundles) {
				BundleInfo info = b.getBundleInfo();
				String name = info.getSymbolicName();
				if (name.startsWith("org.eclipse.equinox.launcher")) {
					if (name.contains("x86_64")) {
						if (name.contains(os)) {
							has64 = true;
							launcher64 = "Equinox launcher\n\t- "
									+ new Path(info.getLocation().getPath())
											.removeFirstSegments(
													targetPlatformProfilePath
															.segmentCount())
											.toOSString();
						} else {
							availableLaunchers.add("\t- "
									+ new Path(info.getLocation().getPath())
											.removeFirstSegments(
													targetPlatformProfilePath
															.segmentCount())
											.toOSString());
						}
					} else if (name.contains("x86")
							|| name.contains("cocoa.macosx")) {
						if (name.contains(os)) {
							has32 = true;
							launcher32 = "Equinox launcher\n\t- "
									+ new Path(info.getLocation().getPath())
											.removeFirstSegments(
													targetPlatformProfilePath
															.segmentCount())
											.toOSString();
						} else {
							availableLaunchers.add("\t- "
									+ new Path(info.getLocation().getPath())
											.removeFirstSegments(
													targetPlatformProfilePath
															.segmentCount())
											.toOSString());
						}
					}
				}
			}
		}

		if (has32 && !has64) {
			if (detectMsg != null) {
				detectMsg.append("32bit arch is selected because AUT uses "
						+ launcher32);
			}
			return OSArchitecture.x86;
		} else if (!has32 && has64) {
			if (detectMsg != null) {
				detectMsg.append("64bit arch is selected because AUT uses "
						+ launcher64);
			}
			return OSArchitecture.x86_64;
		} else if (preferCurrentVmArchitecture && has32 && has64) {
			OSArchitecture result = isCurrentVm64 ? OSArchitecture.x86_64
					: OSArchitecture.x86;
			if (detectMsg != null && result.equals(OSArchitecture.x86)) {
				if (detectMsg != null) {
					detectMsg
							.append("32bit arch is selected because\n- JVM is 32bit\n- AUT contains both launcher plugins\n\t-"
									+ launcher32 + "\n\t-" + launcher64);
				}
			}
			if (detectMsg != null && result.equals(OSArchitecture.x86_64)) {
				if (detectMsg != null) {
					detectMsg
							.append("64bit arch is selected because\n- JVM is 64bit\n- AUT contains both launcher plugins\n\t-"
									+ launcher32 + "\n\t-" + launcher64);
				}
			}
			return result;
		} else {
			if (detectMsg != null) {
				detectMsg
						.append("Cannot find appropriate Equinox launcher library.\n");
				if (availableLaunchers.size() > 0) {
					detectMsg.append("Available launchers:\n");
					for (String s : availableLaunchers) {
						detectMsg.append(s).append("\n");
					}
				}
			}
			return OSArchitecture.Unknown;
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> getRunlevelsFromSimpleConfigurator() {
		Map<String, String> result = new HashMap<String, String>();
		if (getTargetPlatformProfilePath() == null) {
			return result;
		}
		File infoFile = new File(getTargetPlatformProfilePath(),
				SC_BUNDLES_PATH);
		if (!infoFile.exists()) {
			return result;
		}
		InputStream input = null;
		try {
			input = new FileInputStream(infoFile);
			for (org.eclipse.equinox.internal.simpleconfigurator.utils.BundleInfo bi : (List<org.eclipse.equinox.internal.simpleconfigurator.utils.BundleInfo>) SimpleConfiguratorUtils
					.readConfiguration(input, infoFile.toURI())) {
				result.put(
						bi.getSymbolicName(),
						String.format("%d:%b", bi.getStartLevel(),
								bi.isMarkedAsStarted()));
			}
		} catch (Throwable e) {
			FileUtil.safeClose(input);
		}
		return result;
	}

	public Map<String, String> getRunlevelsMap() {
		Map<String, String> result = new HashMap<String, String>();
		String osgiBundles = getConfigIniProperty(OSGI_BUNDLES);
		if (osgiBundles == null) {
			return result;
		}

		if (osgiBundles.contains(SIMPLECONFIGURATOR)) {
			return getRunlevelsFromSimpleConfigurator();
		}

		// AUT uses bundles specified in osgiBundlesProperty
		StringTokenizer tokenizer = new StringTokenizer(osgiBundles, ","); //$NON-NLS-1$
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			int index = token.indexOf('@');
			String id = index != -1 ? token.substring(0, index) : token;
			String tk = token.substring(index + 1);
			if (tk.indexOf(":") == -1) {
				tk = tk + ":default";
			}
			result.put(id, tk);
		}
		return result;
	}

	public ArrayList<IBundleContainer> getExtra() {
		return extra;
	}

	public String getRuntimeVersion() {
		if (target != null && target.isResolved()) {
			String version = "";
			Version runtimeBundle = getBundleVersion("org.eclipse.rcptt.tesla.swt");
			if (runtimeBundle != null) {
				version = runtimeBundle.toString();
				if (runtimeBundle.getQualifier().equals("qualifier")) {
					// This is for development
					version = version + System.currentTimeMillis();
				}
			}
			return version;
		}
		return "unknown";
	}

	private Version getBundleVersion(String name) {
		if (target != null && target.isResolved()) {
			IBundleContainer[] containers = target.getBundleContainers();
			for (IBundleContainer iBundleContainer : containers) {
				IResolvedBundle[] bundles = iBundleContainer.getBundles();
				if (bundles != null) {
					for (IResolvedBundle iResolvedBundle : bundles) {
						if (iResolvedBundle.getBundleInfo().getSymbolicName()
								.equals(name)) {
							return new Version(iResolvedBundle.getBundleInfo()
									.getVersion());
						}
					}
				}
				if (iBundleContainer instanceof IUBundleContainer) {
					IUBundleContainer ct = (IUBundleContainer) iBundleContainer;
					try {
						Field ids = IUBundleContainer.class
								.getDeclaredField("fIds");
						Field versions = IUBundleContainer.class
								.getDeclaredField("fVersions");
						ids.setAccessible(true);
						versions.setAccessible(true);
						String[] idsValue = (String[]) ids.get(ct);
						org.eclipse.equinox.p2.metadata.Version[] versionsValue = (org.eclipse.equinox.p2.metadata.Version[]) versions
								.get(ct);
						for (int i = 0; i < idsValue.length; i++) {
							String n = idsValue[i];
							if (n != null && n.equals(name)) {
								return new Version(versionsValue[i].toString());
							}
						}
					} catch (Throwable e) {
						Q7ExtLaunchingPlugin.status(
								"Failed to check runtime version", e);
					}
				}
			}
		}
		return null;
	}

	public String getEquinoxStartupPath(String packageName) {
		IPluginModelBase[] targetModels = getTargetModels();
		for (IPluginModelBase plugin : targetModels) {
			if (plugin.getPluginBase().getId().equals(packageName)) {
				String location = plugin.getInstallLocation();
				if (new File(location).isFile()) {
					return location;
				}
			}
		}
		return null;
	}

	ProfileBundleContainer getInstanceContainer() {
		return getQ7Target().getInstall().container;
	}

	public void setBundleContainers(IBundleContainer[] containers) {
		target.setBundleContainers(containers);
		initialize();
	}


	@Override
	public String toString() {
		return (getName() == null ? "No name" : getName()) + " " + getTargetPlatformProfilePath();
	}

	
}
