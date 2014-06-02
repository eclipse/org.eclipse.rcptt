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
package org.eclipse.rcptt.core;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager;

public class OptionsHandler {
	public void applyOptions(Map<String, String> options) {
		for (Entry<String, String> option : options.entrySet()) {
			applyOption(option.getKey(), option.getValue());
		}
	}

	public void applyOptions(EMap<String, String> options) {
		for (Entry<String, String> option : options.entrySet()) {
			applyOption(option.getKey(), option.getValue());
		}
	}

	public void applyOption(String key, String value) {
		if (handleSpecialOption(key, value)) {
			return;
		}

		String suffix = guessSuffix(key);
		for (AbstractFeatureManager manager : featureManagers) {
			String featureName = guessFeature(manager, suffix);
			if (featureName != null) {
				manager.getOption(featureName).setValue(value);
				System.out.println(String.format("%s set to %s", featureName,
						value));
				break;
			}
		}
	}

	private AbstractFeatureManager[] featureManagers = new AbstractFeatureManager[] {
			TeslaFeatures.getInstance(), Q7Features.getInstance() };

	private static String guessFeature(AbstractFeatureManager manager,
			String suffix) {
		for (String name : manager.getOptionNames()) {
			if (name.endsWith(suffix)) {
				return name;
			}
		}
		return null;
	}

	private String guessSuffix(String value) {
		StringBuilder sb = new StringBuilder();
		for (char ch : value.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				sb.append(".");
				sb.append(Character.toLowerCase(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	protected final String TEST_EXEC_TIMEOUT = "testExecTimeout";

	protected final String RESTART_AUT_ON_FAILURE = "restartAUTOnFailure";

	protected boolean handleSpecialOption(String key, String value) {
		return false;
	}
}
