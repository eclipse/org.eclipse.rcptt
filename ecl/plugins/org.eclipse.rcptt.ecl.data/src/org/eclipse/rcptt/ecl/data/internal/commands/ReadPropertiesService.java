/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.data.commands.ReadProperties;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ReadPropertiesService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		ReadProperties rp = (ReadProperties) command;
		EclFile file = FileResolver.resolve(rp.getUri());
		Properties p = new Properties();
		Reader reader = null;
		try {
			reader = new InputStreamReader(file.read(), "UTF-8");
			p.load(reader);
		} catch (Exception e) {
			throw new CoreException(EclDataPlugin.createErr(e, "Error reading file %s", file.toURI()));
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}

		EclMap result = CoreFactory.eINSTANCE.createEclMap();
		for (Entry<Object, Object> entry : p.entrySet()) {
			EclMapEntry mapEntry = CoreFactory.eINSTANCE.createEclMapEntry();
			mapEntry.setKey(BoxedValues.box(entry.getKey()));
			mapEntry.setValue(BoxedValues.box(entry.getValue()));
			result.getEntries().add(mapEntry);
		}
		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

}
