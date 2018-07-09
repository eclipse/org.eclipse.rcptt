/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ecl.impl.rap.ServiceUtil;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;
import org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary;
import org.eclipse.rcptt.util.Base64;
import org.eclipse.rcptt.util.FileSystemResolver;
import org.eclipse.rcptt.util.FileUtil;
import org.eclipse.rcptt.util.PrefixScheme;
import org.eclipse.rcptt.util.StringUtils;

public class MatchBinaryService implements ICommandService {

	private FileSystemResolver resolver = makeResolver();

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		final MatchBinary match = (MatchBinary) command;

		byte[] value;
		try {
			value = getValue(match);
		} catch (CoreException e) {
			return e.getStatus();
		} catch (IOException e) {
			return new Status(IStatus.ERROR, TeslaImplPlugin.PLUGIN_ID, "Invalid command", e);
		}

		if (match.getInput() instanceof Wrapper) {
			boolean result = matching((Wrapper) match.getInput(), value);
			context.getOutput().write(ServiceUtil.wrap(result));
		}

		return Status.OK_STATUS;
	}

	private boolean matching(Wrapper wrapper, byte[] bytes) {

		Object object = wrapper.getObject();
		if (object instanceof String) {
			object = Base64.decode(object.toString());
		}
		if (object instanceof byte[]) {
			return Arrays.equals(bytes, (byte[]) wrapper.getObject());
		}

		return false;
	}

	private byte[] getValue(MatchBinary command) throws CoreException, IOException {
		if (!StringUtils.isEmpty(command.getBase64())) {
			return Base64.decode(command.getBase64());
		}

		String path = getPath(command.getFilePath());
		File file = getFile(path);
		return FileUtil.getContents(file);
	}

	private String getPath(String path) throws CoreException {

		if (StringUtils.isEmpty(path)) {
			throw new CoreException(TeslaImplPlugin.error("The path to file is empty"));
		}
		// Tries to substitute variables
		try {
			path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(path, true);
		} catch (NoClassDefFoundError e) {
			throw new CoreException(TeslaImplPlugin.error("Invalid path to file."));
		}

		path = resolver.resolve(path);
		if (StringUtils.isEmpty(path)) {
			throw new CoreException(TeslaImplPlugin.error("The path is not resolved."));
		}

		return path;
	}

	private File getFile(String path) throws CoreException {

		final File file = new File(path);

		if (!file.exists()) {
			throw new CoreException(TeslaImplPlugin.error("The file does not exist."));
		}

		if (!file.isFile()) {
			throw new CoreException(TeslaImplPlugin.error("It is not a file path."));
		}

		return file;
	}

	private static FileSystemResolver makeResolver() {
		FileSystemResolver resolver = new FileSystemResolver();

		{ // workspace
			Location location = Platform.getInstanceLocation();
			if (location != null) {
				URL url = location.getURL();
				if (url != null) {
					try {
						File file = new File(url.toURI());
						resolver.register(new PrefixScheme(PrefixScheme.WORKSPACE, file.toString()));
					} catch (Exception e) {
					}
				}
			}
		}

		{ // aut
			Location location = Platform.getInstallLocation();
			if (location != null) {
				URL url = location.getURL();
				if (url != null) {
					try {
						File file = new File(url.toURI());
						resolver.register(new PrefixScheme(PrefixScheme.AUT, file.toString()));
					} catch (Exception e) {
					}
				}
			}
		}

		{ // file
			resolver.register(new PrefixScheme(PrefixScheme.FILE, null));
		}

		{ // home
			resolver.register(
					new PrefixScheme(PrefixScheme.HOME, new File(System.getProperty("user.home")).getAbsolutePath()));
		}
		return resolver;
	}

}
