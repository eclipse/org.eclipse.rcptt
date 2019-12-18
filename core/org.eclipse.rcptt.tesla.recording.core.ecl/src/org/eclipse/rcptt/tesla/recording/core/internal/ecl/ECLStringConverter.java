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

package org.eclipse.rcptt.tesla.recording.core.internal.ecl;

import org.eclipse.rcptt.ecl.core.util.CommandToStringConverter;
import org.eclipse.rcptt.tesla.recording.core.ecl.ISelectorParserExtension;

/**
 * @author Yuri Strot
 *
 */
public class ECLStringConverter extends CommandToStringConverter {

	public static final ECLStringConverter INSTANCE = new ECLStringConverter();

	private ECLStringConverter() {
	}

	// simple array of tuples <commandName, paramName>. At most
	// one part of tuple can be null which would correspond to any command or
	// param name
	private static final String[][] forcedParams = new String[][] {
			new String[] { "activate-cell-edit", "column" },
			new String[] { "set-text-selection", null },
			new String[] { "hover-ruler", null },
			new String[] { "click-ruler", null },
			new String[] { null, "index" },
			new String[] { null, "after" },
			new String[] { "get-item", "column" },
			new String[] { "select", "column" },
			new String[] { null, "height" },
			new String[] { null, "width" },
			new String[] { null, "detail" },
			new String[] { null, "operation" },
			new String[] { null, "with" },
			new String[] { null, "url" },
			new String[] { null, "path" },
			new String[] { null, "file" },
			new String[] { null, "base64" },
			new String[] { "download-file", null }
			};

	@Override
	protected boolean isForced(String commandName, String paramName) {

		// check selector-parser extensions
		for (ISelectorParserExtension ext : TeslaSelectorParser.extensions)
			if (ext.isParamNameForced(commandName, paramName))
				return true;
		//

		for (String[] tuple : forcedParams) {
			if ((tuple[0] == null || tuple[0].equals(commandName))
					&& (tuple[1] == null || tuple[1].equals(paramName))) {
				return true;
			}
		}
		return super.isForced(commandName, paramName);
	}

}
