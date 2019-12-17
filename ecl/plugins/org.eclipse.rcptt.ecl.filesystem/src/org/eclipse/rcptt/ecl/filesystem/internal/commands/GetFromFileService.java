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
package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;
import static org.eclipse.rcptt.ecl.runtime.BoxedValues.unbox;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Get;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.File;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.filesystem.FilesystemFactory;
import org.eclipse.rcptt.ecl.runtime.SingleCommandService;

public class GetFromFileService extends SingleCommandService<Get> implements
		IScriptletExtension {

	public GetFromFileService() {
		super(Get.class);
	}

	enum Key {
		EXISTS {
			@Override
			Object handle(EclFile file) {
				return file.exists();
			}
		},
		CHILDREN {
			@Override
			Object handle(EclFile file) throws CoreException {
				Collection<? extends EclFile> files = file.getChildren();
				ArrayList<File> rv = new ArrayList<File>();
				for (EclFile child : files) {
					File item = FilesystemFactory.eINSTANCE.createFile();
					item.setUri(child.toURI().toString());
					rv.add(item);
				}
				return rv;
			}
		},
		NAME {
			@Override
			Object handle(EclFile file) {
				return file.getName();
			}
		},
		ISDIRECTORY {
			@Override
			Object handle(EclFile file) {
				return file.isDirectory();
			}
		};
		abstract Object handle(EclFile file) throws CoreException;
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
			throw new CoreException(createError("Invalid key: %s", command.getKey()));
		}
		String uriString = ((File) command.getInput()).getUri();
		URI uri = URI.create(uriString);
		EclFile input = FileResolver.resolve(uri);
		return key.handle(input);
	}

}
