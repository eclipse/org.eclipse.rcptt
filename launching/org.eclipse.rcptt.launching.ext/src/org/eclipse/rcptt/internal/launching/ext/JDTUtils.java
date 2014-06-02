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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.RuntimeProcess;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.launching.LaunchingMessages;
import org.eclipse.jdt.internal.launching.LaunchingPlugin;
import org.eclipse.jdt.launching.AbstractVMInstall;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstall3;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.eclipse.rcptt.internal.core.RcpttPlugin;

@SuppressWarnings("restriction")
public class JDTUtils {
	private static final String TARGET_VM_INSTALL_TYPE = "org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType";
	private static final String HOST_VM_INSTALL_ID = "Q7 Host JVM";

	private static final String SUN_ARCH_DATA_MODEL = "sun.arch.data.model";
	private static final String JAVA_VM_INFO = "java.vm.info";
	private static final String OS_ARCH = "os.arch";
	private static final Map<String, Map<String, String>> systemPropertiesMap = new HashMap<String, Map<String, String>>();

	public static void registerCurrentJVM() throws CoreException {
		IVMInstallType type = JavaRuntime
				.getVMInstallType(TARGET_VM_INSTALL_TYPE);
		if (type == null)
			return;

		IVMInstall install = type.findVMInstall(HOST_VM_INSTALL_ID);
		if (install != null)
			type.disposeVMInstall(HOST_VM_INSTALL_ID);

		install = type.createVMInstall(HOST_VM_INSTALL_ID);
		install.setInstallLocation(new File(System.getProperty("java.home")));
		install.setName(HOST_VM_INSTALL_ID);
		JavaRuntime.saveVMConfiguration();
	}

	static class GetPropertiesThread extends Thread {

		private Map<String, String> map = new HashMap<String, String>();
		private CoreException coreException;

		private final AbstractVMInstall install;
		private final IProgressMonitor monitor;
		private final boolean d32;

		public Map<String, String> getMap() {
			return map;
		}

		public CoreException getCoreException() {
			return coreException;
		}

		public GetPropertiesThread(AbstractVMInstall install,
				IProgressMonitor monitor, boolean d32) {
			this.install = install;
			this.monitor = monitor;
			this.d32 = d32;
		}

		@Override
		public void run() {
			try {
				map = evaluateSystemProperties(install, monitor, d32);
			} catch (CoreException e) {
				coreException = e;
			}
		}
	}

	public static Map<String, String> evaluateSystemPropertiesInThread(
			AbstractVMInstall install, IProgressMonitor monitor, boolean d32,
			int timeout) throws CoreException {

		String installId = install.getId();
		Map<String, String> cashedMap = systemPropertiesMap.get(installId
				+ (d32 ? "32" : "64"));
		if (cashedMap != null) {
			return cashedMap;
		}

		GetPropertiesThread thread = new GetPropertiesThread(install, monitor,
				d32);
		thread.start();
		try {
			thread.join(timeout);
		} catch (InterruptedException e) {
			RcpttPlugin.log(e);
		}
		thread.interrupt();
		if (thread.getCoreException() != null) {
			throw thread.getCoreException();
		}
		return thread.getMap();
	}

	protected static void abort(String message, Throwable exception, int code)
			throws CoreException {
		throw new CoreException(
				new Status(IStatus.ERROR,
						LaunchingPlugin.getUniqueIdentifier(), code, message,
						exception));
	}

	public static Map<String, String> evaluateSystemProperties(
			AbstractVMInstall install, IProgressMonitor monitor, boolean d32)
			throws CoreException {
		// locate the launching support jar - it contains the main program to
		// run
		Map<String, String> map = new HashMap<String, String>();
		String[] properties = new String[] { OS_ARCH, "java.version",
				"java.specification.name", "java.specification.version",
				JAVA_VM_INFO, "java.vm.name", "java.vm.version",
				"java.runtime.name", "java.runtime.version",
				SUN_ARCH_DATA_MODEL };
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		// launch VM to evaluate properties
		File file = LaunchingPlugin.getFileInPlugin(new Path(
				"lib/launchingsupport.jar")); //$NON-NLS-1$
		if (file != null && file.exists()) {
			String javaVersion = install.getJavaVersion();
			boolean hasXMLSupport = false;
			if (javaVersion != null) {
				hasXMLSupport = true;
				if (javaVersion.startsWith(JavaCore.VERSION_1_1)
						|| javaVersion.startsWith(JavaCore.VERSION_1_2)
						|| javaVersion.startsWith(JavaCore.VERSION_1_3)) {
					hasXMLSupport = false;
				}
			}
			String mainType = null;
			if (hasXMLSupport) {
				mainType = "org.eclipse.jdt.internal.launching.support.SystemProperties"; //$NON-NLS-1$
			} else {
				mainType = "org.eclipse.jdt.internal.launching.support.LegacySystemProperties"; //$NON-NLS-1$
			}
			VMRunnerConfiguration config = new VMRunnerConfiguration(mainType,
					new String[] { file.getAbsolutePath() });
			List<String> vmArgs = new ArrayList<String>(Arrays.asList(config
					.getVMArguments()));

			// there is no -d32 on Windows
			if (d32 && Platform.getOS().equals(Platform.OS_MACOSX)) {
				if (!vmArgs.contains("-d32")) {
					vmArgs.add("-d32");
					config.setVMArguments(vmArgs.toArray(new String[vmArgs
							.size()]));
				}
			}
			IVMRunner runner = install.getVMRunner(ILaunchManager.RUN_MODE);
			if (runner == null) {
				abort(LaunchingMessages.AbstractVMInstall_0, null,
						IJavaLaunchConfigurationConstants.ERR_INTERNAL_ERROR);
			}
			config.setProgramArguments(properties);
			Launch launch = new Launch(null, ILaunchManager.RUN_MODE, null);
			if (monitor.isCanceled()) {
				return map;
			}
			monitor.beginTask(LaunchingMessages.AbstractVMInstall_1, 2);
			runner.run(config, launch, monitor);
			IProcess[] processes = launch.getProcesses();
			if (processes.length != 1) {
				abort(LaunchingMessages.AbstractVMInstall_0, null,
						IJavaLaunchConfigurationConstants.ERR_INTERNAL_ERROR);
			}
			IProcess process = processes[0];

			if (process instanceof RuntimeProcess) {
				Q7ExtLaunchingPlugin
						.getDefault()
						.info(String
								.format("Launched external Java process. Command line is: %s",
										process.getAttribute(RuntimeProcess.ATTR_CMDLINE)));
			}
			try {
				int total = 0;
				// int max = Platform.getPreferencesService().getInt(
				// LaunchingPlugin.ID_PLUGIN,
				// JavaRuntime.PREF_CONNECT_TIMEOUT,
				// JavaRuntime.DEF_CONNECT_TIMEOUT, null);
				int max = 50 * 1000; // 50 seconds
				while (!process.isTerminated()) {
					try {
						if (total > max) {
							break;
						}
						Thread.sleep(50);
						total += 50;
					} catch (InterruptedException e) {
					}
				}
			} finally {
				if (!launch.isTerminated()) {
					launch.terminate();
					Q7ExtLaunchingPlugin.getDefault().info(
							"Java process timed out and terminated");
				} else {
					Q7ExtLaunchingPlugin.getDefault().info(
							"Java process completed normally");
				}
			}
			monitor.worked(1);
			if (monitor.isCanceled()) {
				return map;
			}

			monitor.subTask(LaunchingMessages.AbstractVMInstall_3);
			IStreamsProxy streamsProxy = process.getStreamsProxy();
			String text = null;
			if (streamsProxy != null) {
				text = streamsProxy.getOutputStreamMonitor().getContents();
			}
			if (text != null && text.length() > 0) {
				try {
					DocumentBuilder parser = LaunchingPlugin.getParser();
					Document document = parser.parse(new ByteArrayInputStream(
							text.getBytes()));
					Element envs = document.getDocumentElement();
					NodeList list = envs.getChildNodes();
					int length = list.getLength();
					for (int i = 0; i < length; ++i) {
						Node node = list.item(i);
						short type = node.getNodeType();
						if (type == Node.ELEMENT_NODE) {
							Element element = (Element) node;
							if (element.getNodeName().equals("property")) { //$NON-NLS-1$
								String name = element.getAttribute("name"); //$NON-NLS-1$
								String value = element.getAttribute("value"); //$NON-NLS-1$
								map.put(name, value);
							}
						}
					}
				} catch (SAXException e) {
					abort(LaunchingMessages.AbstractVMInstall_4,
							e,
							IJavaLaunchConfigurationConstants.ERR_INTERNAL_ERROR);
				} catch (IOException e) {
					abort(LaunchingMessages.AbstractVMInstall_4,
							e,
							IJavaLaunchConfigurationConstants.ERR_INTERNAL_ERROR);
				}
			} else {
				abort(LaunchingMessages.AbstractVMInstall_0, null,
						IJavaLaunchConfigurationConstants.ERR_INTERNAL_ERROR);
			}
			monitor.worked(1);
		} else {
			abort(LaunchingMessages.AbstractVMInstall_0, null,
					IJavaLaunchConfigurationConstants.ERR_INTERNAL_ERROR);
		}
		monitor.done();
		systemPropertiesMap.put(install.getId() + (d32 ? "32" : "64"), map);
		return map;
	}

	public static Map<String, String> detectArchitecture(IVMInstall install) {
		if (install instanceof AbstractVMInstall) {
			AbstractVMInstall avi = (AbstractVMInstall) install;
			try {
				Map<String, String> properties = evaluateSystemPropertiesInThread(
						avi, new NullProgressMonitor(), false, 60000);
				return properties;
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		// Could not detect
		return null;
	}

	public static OSArchitecture detect(IVMInstall install) {
		return detect(detectArchitecture(install));
	}

	private static OSArchitecture detect(Map<String, String> properties) {
		Object model = properties.get(SUN_ARCH_DATA_MODEL);
		if (model != null && "32".equals(model)) {
			return OSArchitecture.x86;
		}
		if (model != null && "64".equals(model)) {
			return OSArchitecture.x86_64;
		}

		Object arch = properties.get(OS_ARCH);
		if (arch != null && "amd64".equals(arch)) {
			return OSArchitecture.x86_64;
		}
		if (arch != null && "x86_64".equals(arch)) {
			return OSArchitecture.x86_64;
		}
		if (arch != null && "i386".equals(arch)) {
			return OSArchitecture.x86;
		}
		if (arch != null && "i686".equals(arch)) {
			return OSArchitecture.x86;
		}
		if (arch != null && "i586".equals(arch)) {
			return OSArchitecture.x86;
		}

		return null;
	}

	public static boolean canRun32bit(IVMInstall install) {
		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			if (install instanceof IVMInstall3) {
				AbstractVMInstall avi = (AbstractVMInstall) install;
				try {
					Map<String, String> properties2 = evaluateSystemPropertiesInThread(
							avi, new NullProgressMonitor(), true, 60000);
					if (!properties2.isEmpty()) {
						return true;
					}
				} catch (CoreException e) {

				}
			}
		}
		return false;
	}
}
