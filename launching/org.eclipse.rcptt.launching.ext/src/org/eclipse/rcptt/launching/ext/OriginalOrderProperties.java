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
package org.eclipse.rcptt.launching.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class OriginalOrderProperties extends Properties {
	private static final long serialVersionUID = -8939534425662357037L;
	private List<Object> indexes = new ArrayList<Object>();
	private boolean addToBegining = false;

	@Override
	public synchronized Object put(Object key, Object value) {
		if (!indexes.contains(key)) {
			if (addToBegining) {
				indexes.add(0, key);
			} else {
				indexes.add(key);
			}
		}
		return super.put(key, value);
	}

	@Override
	public synchronized Object remove(Object key) {
		indexes.remove(key);
		return super.remove(key);
	}

	@Override
	public synchronized void clear() {
		indexes.clear();
		super.clear();
	}

	@Override
	public synchronized Enumeration<Object> keys() {
		return Collections.enumeration(indexes);
	}

	public void setBeginAdd(boolean b) {
		this.addToBegining = b;
	}

	public static OriginalOrderProperties fromFile(File file)
			throws IOException {
		OriginalOrderProperties result = new OriginalOrderProperties();
		FileInputStream f = null;

		f = new FileInputStream(file);
		result.load(f);
		f.close();

		return result;
	}
}
