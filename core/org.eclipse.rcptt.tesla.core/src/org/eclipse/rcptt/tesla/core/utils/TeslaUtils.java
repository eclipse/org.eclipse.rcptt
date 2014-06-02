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
package org.eclipse.rcptt.tesla.core.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.internal.core.ModelUtils;

public final class TeslaUtils {

	private TeslaUtils() {
	}

	public static TeslaScenario merge(TeslaScenario first, TeslaScenario second) {
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		TeslaScenario result = (first != null) ? (TeslaScenario) EcoreUtil
				.copy(first) : null;
		TeslaScenario secondCopy = (second != null) ? (TeslaScenario) EcoreUtil
				.copy(second) : null;

		int count = getElementsCount(result);
		IdGenerator idGenerator = new IdGenerator(count);

		Map<String, Element> elementsMap = new HashMap<String, Element>();
		if (secondCopy != null) {
			for (Command command : secondCopy.getCommands()) {
				ModelUtils.updateElementsAccordingTo(command, elementsMap,
						new HashSet<EObject>());
				List<Element> elements = getElements(secondCopy, command);
				if (elements != null) {
					for (Element element : elements) {
						elementsMap.put(ModelUtils.makeKey(element), element);
						String newId = idGenerator.getId(element.getId(),
								element.getKind());
						element.setId(newId);
					}
				}
			}

			result.getCommands().addAll(secondCopy.getCommands());
			result.getElementMapping().addAll(secondCopy.getElementMapping());
		}
		return result;
	}

	private static List<Element> getElements(TeslaScenario scenario,
			Command command) {
		EList<CommandToElementEntry> elementMapping = scenario
				.getElementMapping();
		for (CommandToElementEntry commandToElementEntry : elementMapping) {
			if (commandToElementEntry.getCommand().equals(command)) {
				return commandToElementEntry.getElements();
			}
		}
		return null;
	}

	private static int getElementsCount(TeslaScenario scenario) {
		int count = 0;
		List<CommandToElementEntry> entries = scenario.getElementMapping();
		for (CommandToElementEntry entry : entries) {
			count += entry.getElements().size();
		}
		return count;
	}

	private static class IdGenerator {

		private Map<String, Integer> map = new HashMap<String, Integer>();
		private int start;

		public IdGenerator(int startVal) {
			this.start = startVal;
		}

		public String getId(String oldId, String kind) {
			Integer val = map.get(kind);
			if (val == null) {
				val = start;
			}
			String id = oldId + "_" + ++val;
			map.put(kind, val);
			return id;
		}
	}

	private static Version eclipseVer;
	private static Version gefVer;

	public static Version getEclipseVersion() {
		if (eclipseVer == null)
			eclipseVer = new Version(Platform.getBundle("org.eclipse.osgi")
					.getHeaders().get("Bundle-Version").toString());
		return eclipseVer;
	}

	public static Version getGEFVersion() {
		if (gefVer == null) {
			Bundle gefBundle = Platform.getBundle("org.eclipse.gef");
			if (gefBundle != null) {
				gefVer = new Version(gefBundle.getHeaders()
						.get("Bundle-Version").toString());
			}
		}
		return gefVer;
	}

	public static String intToButtonName(int button) {
		switch (button) {
		case 1:
			return "left";
		case 2:
			return "middle";
		case 3:
			return "right";
		default:
			return "button" + button;
		}

	}

	public static final boolean isMac = Platform.getOS().equals(
			Platform.OS_MACOSX);
	public static final boolean isWin = Platform.getOS().equals(
			Platform.OS_WIN32);
	public static final boolean isLinux = Platform.getOS().equals(
			Platform.OS_LINUX);

	public static int buttonNameToInt(String name) {
		if (name == null)
			return 1;
		name = name.toLowerCase();
		if (name.equals("left"))
			return 1;
		if (name.equals("middle"))
			return 2;
		if (name.equals("right"))
			return 3;
		if (name.startsWith("button")) {
			String buttonNumber = name.substring("button".length());
			try {
				return Integer.parseInt(buttonNumber);
			} catch (NumberFormatException e) {
				// skip it
			}
		}

		return 0;
	}
}
