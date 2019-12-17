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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.scenario.NamedElement;

public class DebugContextAdapter {
	final DebugContext model;
	public DebugContextAdapter(DebugContext context) {
		model = context;
	}
	public LaunchConfiguration getConfiguration(String name) {
		assert name != null;
		for (LaunchType type: model.getLaunchTypes()) {
			for (LaunchConfiguration conf: type.getConfigurations()) {
				assert conf.getName() != null;
				if (conf.getName().equals(name))
					return conf;
			}
		}
		throw new IllegalArgumentException("No configuration named " + name);
	}
	
	public List<LaunchType> getNonEmptyLaunchTypes() {
		List<LaunchType> rv = new ArrayList<LaunchType>();
		for (LaunchType type: model.getLaunchTypes()) {
			if (type.getConfigurations().size() > 0) {
				rv.add(type);				
			}
		}
		return rv;
	}
	
	public List<BreakpointResource> getNonEmptyBreakpointResources() {
		List<BreakpointResource> rv = new ArrayList<BreakpointResource>();
		for (BreakpointResource type: model.getBreakpointResources()) {
			if (type.getBreakpoints().size() > 0) {
				rv.add(type);				
			}
		}
		return rv;
	}
	
	public static NamedElement findAttribute(List<NamedElement> attributes, String name) {
		for (NamedElement attribute: attributes) {
			if (name.equals(attribute.getName())) {
				return attribute;
			}
		}
		return null;
	}
	public LaunchType getLaunchType(String id) {
		for (LaunchType type: model.getLaunchTypes()) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Can't find launch configuration type "+id);
	}
	
}
