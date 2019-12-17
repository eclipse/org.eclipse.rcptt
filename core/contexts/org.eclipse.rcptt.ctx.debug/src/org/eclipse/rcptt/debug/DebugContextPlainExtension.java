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
package org.eclipse.rcptt.debug;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.core.persistence.plain.IPlainTextPersistenceExtension;
import org.eclipse.rcptt.core.persistence.plain.PlainTextPersistenceModel;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class DebugContextPlainExtension implements
		IPlainTextPersistenceExtension {

	private static final String DEBUG_BREAKPOINTS = "debug.breakpoints";
	private static final String DEBUG_LAUNCHCONFIGURATION = ".debug.launchconfiguration";
	private static final String DEBUG_LAUNCHES = "debug.launches";
	private static final String DEBUG_TYPES = "debug.launchtypes";
	private static final String DEBUG_CONTEXT = ".debug.context";
	@SuppressWarnings("unused")
	private static final String DEBUG_LAUNCH = ".debug.launch";
	private static final String DEBUG_LAUNCH_EXCEPTIONS = "Debug-LaunchExceptions";
	private static final String DEBUG_LAUNCH_SHORTCUT_EXCEPTIONS = "Debug-LaunchShortcutExceptions";
	private static final String DEBUG_NO_BREAKPOINTS = "Debug-NoBreakpoints";
	private static final String DEBUG_NO_LAUNCH_SHORTCUTS = "Debug-NoLaunchShortcuts";
	private static final String DEBUG_NO_LAUNCHES = "Debug-NoLaunches";

	private static void readLaunchConfigurations(DebugContext context,
			PlainTextPersistenceModel plainTextPersistenceModel) {
		EList<LaunchType> types = context.getLaunchTypes();
		types.clear();
		for (EObject eObject2 : read(plainTextPersistenceModel, DEBUG_TYPES)) {
			if (eObject2 instanceof LaunchType) {
				// Copy is required to prevent concurrent modification of
				// contents EList
				types.add((LaunchType) EcoreUtil.copy(eObject2));
			}
		}
		DebugContextAdapter adapter = new DebugContextAdapter(context);
		for (String file : plainTextPersistenceModel.getNames()) {
			if (!file.endsWith(DEBUG_LAUNCHCONFIGURATION))
				continue;
			for (EObject eObject3 : read(plainTextPersistenceModel, file)) {
				LaunchConfiguration conf = (LaunchConfiguration) EcoreUtil.copy(eObject3);
				adapter.getLaunchType(conf.getTypeId()).getConfigurations().add(conf);
			}
		}
	}

	private static void writeLaunchConfigurations(DebugContext eObject,
			PlainTextPersistenceModel plainTextPersistenceModel) {
		List<EObject> toWrite = new ArrayList<EObject>();
		for (LaunchType type : eObject.getLaunchTypes()) {
			LaunchType copy = (LaunchType) EcoreUtil.copy(type);
			copy.getConfigurations().clear();
			toWrite.add(copy);
		}
		write(plainTextPersistenceModel, DEBUG_TYPES, toWrite);
		for (String file : plainTextPersistenceModel.getNames())
			if (file.endsWith(DEBUG_LAUNCHCONFIGURATION))
				plainTextPersistenceModel.delete(file);
		for (LaunchType type : eObject.getLaunchTypes()) {
			for (LaunchConfiguration conf : type.getConfigurations()) {
				conf.setTypeId(type.getId());
				write(plainTextPersistenceModel, conf.getName() + DEBUG_LAUNCHCONFIGURATION, conf);
			}
		}
	}

	private void readBreakpoints(DebugContext ctx,
			PlainTextPersistenceModel plainTextPersistenceModel) {
		ctx.getBreakpointResources().clear();
		for (EObject eObject2 : read(plainTextPersistenceModel,
				DEBUG_BREAKPOINTS)) {
			if (eObject2 instanceof BreakpointResource) {
				// Copy is required to prevent concurrent modification of
				// contents EList
				ctx.getBreakpointResources().add((BreakpointResource) EcoreUtil.copy(eObject2));
			}
		}
	}

	private void readLaunches(DebugContext ctx,
			PlainTextPersistenceModel plainTextPersistenceModel) {
		ctx.getLaunches().clear();
		DebugContextAdapter adapter = new DebugContextAdapter(ctx);
		for (EObject eObject2 : read(plainTextPersistenceModel, DEBUG_LAUNCHES)) {
			if (eObject2 instanceof Launch) {
				// Copy is required to prevent concurrent modification of
				// contents EList
				Launch launch = (Launch) EcoreUtil.copy(eObject2);
				LaunchConfiguration conf = adapter.getConfiguration(launch.getConfigurationName());
				launch.setConfiguration(conf);
				assert launch.getConfiguration().getName() != null;
				ctx.getLaunches().add(launch);
				assert launch.getConfiguration().getName() != null;
			}
		}
	}

	private void writeBreakpoints(DebugContext ctx,
			PlainTextPersistenceModel plainTextPersistenceModel) {
		write(plainTextPersistenceModel, DEBUG_BREAKPOINTS,
				ctx.getBreakpointResources());
	}

	public DebugContextPlainExtension() {
	}

	public String getTextContentType(String fName) {
		if (DEBUG_CONTEXT.equals(fName))
			return "text/ecl";
		if (fName.endsWith(DEBUG_LAUNCHCONFIGURATION))
			return "text/launchconfiguration";
		if (fName.equals(DEBUG_BREAKPOINTS))
			return "text/breakpoints";
		if (fName.equals(DEBUG_LAUNCHES))
			return "text/launch";
		return null;
	}

	public boolean isContentEntryOptional(EList<EObject> contents) {
		if (contents.get(0) instanceof DebugContext) {
			return true;
		}
		return false;
	}

	public void performObjectPreSaveUpdate(EObject eObject) {
	}

	private static EList<EObject> read(PlainTextPersistenceModel plainModel, String attachment) {
		Resource resource = new XMIResourceImpl();
		InputStream rawstream = null;
		try {
			rawstream = plainModel.read(attachment);
			if (rawstream == null)
				return resource.getContents();
			resource.load(rawstream, PersistenceManager.getOptions());
			rawstream.close();
		} catch (IOException e) {
			RcpttPlugin.log(e);
		} finally {
			FileUtil.safeClose(rawstream);
		}
		return resource.getContents();
	}

	private void writeLaunches(DebugContext ctx,
			PlainTextPersistenceModel plainTextPersistenceModel) {
		List<Launch> list = new ArrayList<Launch>();
		for (Launch launchOriginal : ctx.getLaunches()) {
			assert launchOriginal.getConfiguration().getName() != null;
			Launch launch = EcoreUtil.copy(launchOriginal);
			assert launchOriginal.getConfiguration().getName() != null;
			assert launch.getConfiguration().getName() != null;
			launch.setConfigurationName(launch.getConfiguration().getName());
			launch.setConfiguration(null);
			assert launchOriginal.getConfiguration().getName() != null;
			list.add(launch);
		}
		write(plainTextPersistenceModel, DEBUG_LAUNCHES, list);
	}

	public void updateAttributes(
			PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> masterAttributes, EObject eObject) {
		if (eObject instanceof DebugContext) {
			DebugContext ctx = (DebugContext) eObject;
			masterAttributes.put(DEBUG_NO_BREAKPOINTS,
					Boolean.toString(ctx.isNoBreakpoints()));
			masterAttributes.put(DEBUG_NO_LAUNCHES,
					Boolean.toString(ctx.isNoLaunches()));
			masterAttributes.put(DEBUG_NO_LAUNCH_SHORTCUTS,
					Boolean.toString(ctx.isNoLaunchShortcuts()));
			if (ctx.getLaunchShortcutExceptions() != null) {
				masterAttributes.put(DEBUG_LAUNCH_SHORTCUT_EXCEPTIONS,
						ctx.getLaunchShortcutExceptions());
			}
			if (ctx.getLaunchExceptions() != null) {
				masterAttributes.put(DEBUG_LAUNCH_EXCEPTIONS,
						ctx.getLaunchExceptions());
			}
			writeLaunchConfigurations(ctx, plainTextPersistenceModel);
			writeBreakpoints(ctx, plainTextPersistenceModel);
			writeLaunches(ctx, plainTextPersistenceModel);
		}
	}

	public void updateMetadata(
			PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> header, EObject eObject) {
		if (eObject instanceof DebugContext) {
			DebugContext ctx = (DebugContext) eObject;
			String value = header.get(DEBUG_NO_BREAKPOINTS);
			if (value != null) {
				ctx.setNoBreakpoints(Boolean.parseBoolean(value));
			}
			value = header.get(DEBUG_NO_LAUNCHES);
			if (value != null) {
				ctx.setNoLaunches(Boolean.parseBoolean(value));
			}
			value = header.get(DEBUG_NO_LAUNCH_SHORTCUTS);
			if (value != null) {
				ctx.setNoLaunchShortcuts(Boolean.parseBoolean(value));
			}
			value = header.get(DEBUG_LAUNCH_SHORTCUT_EXCEPTIONS);
			if (value != null) {
				ctx.setLaunchShortcutExceptions(value);
			}
			value = header.get(DEBUG_LAUNCH_EXCEPTIONS);
			if (value != null) {
				ctx.setLaunchExceptions(value);
			}
			readLaunchConfigurations(ctx, plainTextPersistenceModel);
			readBreakpoints(ctx, plainTextPersistenceModel);
			readLaunches(ctx, plainTextPersistenceModel);
		}
	}

	private static void write(PlainTextPersistenceModel plainModel, String attachment, EObject object) {
		List<EObject> value = new ArrayList<EObject>();
		value.add(object);
		write(plainModel, attachment, value);
	}

	private static void write(PlainTextPersistenceModel plainModel, String attachment, List<? extends EObject> objects) {
		OutputStream stream = null;
		try {
			XMIResourceImpl resource = new XMIResourceImpl();
			for (EObject object : objects) {
				resource.getContents().add(EcoreUtil.copy(object));
			}
			final Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMIResource.OPTION_ENCODING, "UTF-8");
			stream = plainModel.store(attachment);
			resource.save(stream, options);
		} catch (IOException e) {
			RcpttPlugin.log(e);
		} finally {
			FileUtil.safeClose(stream);
		}
	}
}
