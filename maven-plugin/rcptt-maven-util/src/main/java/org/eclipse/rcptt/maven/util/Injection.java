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
package org.eclipse.rcptt.maven.util;

public class Injection {
	private String site;
	private String[] features;

	public String getSite() {
		checkValid();
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String[] getFeatures() {
		return features;
	}

	public void setFeatures(String[] features) {
		this.features = features;
	}

	public void checkValid() {
		if (site == null || site.isEmpty()) {
			throw new IllegalStateException("Injection should have non-empty site URL");
		}
	}
}
