/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
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
import java.io.InputStream;
import java.net.URL;
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

	public static OriginalOrderProperties load(URL url) throws IOException {
		final OriginalOrderProperties props = new OriginalOrderProperties();
		InputStream is = null;
		try {
			is = getStream(url);
			props.load(is);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					//ignore failure to close
				}
		}
		return props;
	}


	private static InputStream getStream(URL location) throws IOException {
		if ("file".equalsIgnoreCase(location.getProtocol())) { //$NON-NLS-1$
			// this is done to handle URLs with invalid syntax in the path
			File f = new File(location.getPath());
			if (f.exists()) {
				return new FileInputStream(f);
			}
		}
		return location.openStream();
	}
}
