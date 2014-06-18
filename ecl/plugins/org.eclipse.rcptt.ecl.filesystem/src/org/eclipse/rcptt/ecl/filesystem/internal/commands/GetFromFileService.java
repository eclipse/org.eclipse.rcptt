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
package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;
import static org.eclipse.rcptt.ecl.runtime.BoxedValues.unbox;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Get;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.filesystem.File;
import org.eclipse.rcptt.ecl.filesystem.FilesystemFactory;
import org.eclipse.rcptt.ecl.runtime.SingleCommandService;

public class GetFromFileService extends SingleCommandService<Get> implements
		IScriptletExtension {

	public GetFromFileService() {
		super(Get.class);
	}

	enum Key {
		EXISTS, CHILDREN, NAME, ISDIRECTORY
	}

	static private Key parseKey(Object object) {
		Object keyObject = unbox(object);
		if (keyObject == null)
			return null;
		if (!(keyObject instanceof String))
			return null;
		String keyString = (String) keyObject;
		try {
			// TODO: implement a method that doesn't use exceptions to indicate
			// invalid strings
			return Key.valueOf(Key.class, keyString.toUpperCase(Locale.US));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public boolean canHandle(Command command) {
		if (!(command instanceof Get))
			return false;
		Get get = (Get) command;
		if (!(get.getInput() instanceof File))
			return false;
		return parseKey(get.getKey()) != null;
	}

	@Override
	protected Object serviceTyped(Get command) throws InterruptedException,
			CoreException {
		Key key = parseKey(command.getKey());
		if (key == null) {
			throw new CoreException(createError("Invalid key: "
					+ command.getKey()));
		}
		String uriString = ((File) command.getInput()).getUri();
		URI input = URI.create(uriString);
		switch (key) {
		case CHILDREN:
			return handleChildren(input);
		case EXISTS:
			return handleExists(input);
		case ISDIRECTORY:
			return handleIsDirectory(input);
		case NAME:
			return handleName(input);
		}
		throw new CoreException(createError("Wrong key: " + key));
	}

	private boolean handleIsDirectory(URI input) throws CoreException {
		return EFS.getStore(input).fetchInfo().isDirectory();
	}

	private List<File> handleChildren(URI input) throws CoreException {
		try {
			IFileStore[] files = EFS.getStore(input)
					.childStores(EFS.NONE, null);
			ArrayList<File> rv = new ArrayList<File>();
			for (IFileStore child : files) {
				File item = FilesystemFactory.eINSTANCE.createFile();
				item.setUri(child.toURI().toURL().toExternalForm());
				rv.add(item);
			}
			return rv;
		} catch (MalformedURLException e) {
			throw new CoreException(createError("Can't create child URI", e));
		}
	}

	private Object handleName(URI uri) {
		return URIUtil.lastSegment(uri);
	}

	private boolean handleExists(URI input) throws CoreException {
		return EFS.getStore(input).fetchInfo().exists();
	}

}
