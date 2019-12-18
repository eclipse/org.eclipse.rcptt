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
package org.eclipse.rcptt.core.versioning.updaters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.versioning.IQ7VersionManager;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.internal.core.ModelUtils;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;

/**
 * Update element names contained in scenario, to be unique.
 */
public class TeslaElementUpdater implements IQ7VersionManager {

	public TeslaElementUpdater() {
	}

	public void updateElement(NamedElement element, boolean allowSave) {
		double version = getVersion(element);
		if (version < 3.0) {
			if (element instanceof Scenario) {
				Scenario sc = (Scenario) element;
				EObject content = sc.getContent();
				// We could update only tesla scenarious
				if (content instanceof TeslaScenario) {
					updateScenario((TeslaScenario) content);
				}
			}
		}
	}

	public void updateScenario(TeslaScenario content) {
		EList<Command> commands = content.getCommands();
		EList<CommandToElementEntry> mappingRaw = content.getElementMapping();
		Set<String> resolvedNames = new HashSet<String>();
		Map<Command, CommandToElementEntry> mapping = new HashMap<Command, CommandToElementEntry>();
		for (CommandToElementEntry mapEntry : mappingRaw) {
			Command command = mapEntry.getCommand();
			mapping.put(command, mapEntry);
		}
		ElementGenerator gen = new ElementGenerator();
		Map<String, Element> updateMap = new HashMap<String, Element>();
		for (Command cmd : commands) {
			CommandToElementEntry entry = mapping.get(cmd);
			if (entry != null) {
				EList<Element> elements = entry.getElements();
				List<Element> newElements = new ArrayList<Element>();
				for (Element element : elements) {
					String key = ModelUtils.makeKey(element);
					if (resolvedNames.contains(key)) {
						// We need to update this element to new one
						Element newElement = generateElement(gen,
								resolvedNames, element);
						String newKey = ModelUtils.makeKey(newElement);
						updateMap.put(key, newElement);
						resolvedNames.add(newKey);
						newElements.add(newElement);
					} else {
						resolvedNames.add(key);
						updateMap.put(key, element);
						newElements.add(element);
					}
				}
				entry.getElements().clear();
				entry.getElements().addAll(newElements);
			}
			ModelUtils.updateElementsAccordingTo(cmd, updateMap,
					new HashSet<EObject>());
		}
	}

	private Element generateElement(ElementGenerator gen,
			Set<String> resolvedNames, Element element) {
		Element g = gen.generate(element.getKind());
		while (resolvedNames.contains(ModelUtils.makeKey(g))) {
			gen.updateToNext(g);
		}
		return g;
	}

	private double getVersion(NamedElement e) {
		try {
			return Double.parseDouble(e.getVersion());
		} catch (NumberFormatException ee) {
			return 1.0;
		}
	}
}
