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
package org.eclipse.rcptt.launching.injection.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.launching.injection.Directory;
import org.eclipse.rcptt.launching.injection.Entry;
import org.eclipse.rcptt.launching.injection.InjectionConfiguration;
import org.eclipse.rcptt.launching.injection.InjectionFactory;
import org.eclipse.rcptt.launching.injection.UpdateSite;
import org.eclipse.rcptt.launching.injection.internal.InjectionPlugin;

public class InjectionUtil {
	/**
	 * Returns string representation of {@link UpdateSite} entry which is
	 * suitable for logging and/or command-line passing.
	 * {@link #siteFromString(String)} can be used to perform reverse conversion
	 * 
	 * @param site
	 * @return
	 */
	public static String siteToString(UpdateSite site) {
		StringBuilder sb = new StringBuilder();
		sb.append(site.getUri());
		if (site.isAllUnits()) {
			return sb.toString();
		}
		sb.append(UNIT_SEP);
		for (String unit : site.getUnits()) {
			sb.append(unit).append(UNIT_SEP);
		}
		return sb.toString();
	}

	private static final String UNIT_SEP = ";";

	public static UpdateSite siteFromString(String string) {
		String[] entries = string.split(UNIT_SEP);
		UpdateSite result = InjectionFactory.eINSTANCE.createUpdateSite();
		result.setUri(entries[0]);
		for (int i = 1; i < entries.length; i++) {
			if (entries[i].length() > 0) {
				result.getUnits().add(entries[i]);
			}
		}
		result.setAllUnits(result.getUnits().isEmpty());
		return result;
	}

	public static String entryToString(Entry entry) {
		if (entry instanceof UpdateSite) {
			return siteToString((UpdateSite) entry);
		} else if (entry instanceof Directory) {
			return dirToString((Directory) entry);
		}
		return "";
	}

	public static Directory dirFromString(String string) {
		Directory result = InjectionFactory.eINSTANCE.createDirectory();
		result.setPath(string);
		return result;
	}

	public static String dirToString(Directory dir) {
		return dir.getPath();
	}

	/**
	 * Returns {@link InjectionConfiguration} containing features from both
	 * configs specified
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static InjectionConfiguration merge(InjectionConfiguration a,
			InjectionConfiguration b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		Map<String, Entry> aMap = getEntryMap(a);
		Map<String, Entry> bMap = getEntryMap(b);

		Map<String, Entry> resultMap = new HashMap<String, Entry>();

		for (String key : aMap.keySet()) {
			Entry merged = mergeEntry(key, aMap.get(key), bMap, resultMap);
			resultMap.put(key, merged);
		}

		for (String key : bMap.keySet()) {
			Entry merged = mergeEntry(key, bMap.get(key), aMap, resultMap);
			resultMap.put(key, merged);
		}

		InjectionConfiguration result = InjectionFactory.eINSTANCE
				.createInjectionConfiguration();
		result.getEntries().addAll(resultMap.values());

		return result;
	}

	private static Entry mergeEntry(String key, Entry entry,
			Map<String, Entry> other, Map<String, Entry> result) {
		// entry already merged
		if (result.containsKey(key)) {
			return result.get(key);
		}

		Entry otherEntry = other.get(key);
		if (otherEntry == null) {
			return (Entry) EcoreUtil.copy(entry);
		}

		return mergeEntry(entry, otherEntry);
	}

	private static Entry mergeEntry(Entry a, Entry b) {
		if ((a instanceof UpdateSite) && (b instanceof UpdateSite)) {
			UpdateSite site1 = (UpdateSite) a;
			UpdateSite site2 = (UpdateSite) b;

			if (site1.isAllUnits()) {
				return (Entry) EcoreUtil.copy(a);
			}
			if (site2.isAllUnits()) {
				return (Entry) EcoreUtil.copy(b);
			}
			UpdateSite result = InjectionFactory.eINSTANCE.createUpdateSite();
			result.setUri(site1.getUri());
			result.setAllUnits(false);
			Set<String> units = new HashSet<String>();
			units.addAll(site1.getUnits());
			units.addAll(site2.getUnits());
			result.getUnits().addAll(units);
			return result;
		} else if ((a instanceof Directory) && (b instanceof Directory)) {
			return (Entry) EcoreUtil.copy(a);
		} else {
			InjectionPlugin
					.logWarn("Injection entries have the same key but different type");
			return (Entry) EcoreUtil.copy(a);
		}
	}

	private static Map<String, Entry> getEntryMap(InjectionConfiguration config) {
		Map<String, Entry> result = new HashMap<String, Entry>();
		for (Entry entry : config.getEntries()) {
			if (entry instanceof UpdateSite) {
				result.put(((UpdateSite) entry).getUri(), entry);
			} else if (entry instanceof Directory) {
				result.put(((Directory) entry).getPath(), entry);
			}
		}
		return result;
	}
}
