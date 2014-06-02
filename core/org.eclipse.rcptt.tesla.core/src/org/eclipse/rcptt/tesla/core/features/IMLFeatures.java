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
package org.eclipse.rcptt.tesla.core.features;

import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager;

public class IMLFeatures {
	// Canvas operations
	/**
	 * Allow UI Buttons
	 */
	public final static String USE_IMAGING_SUPPORTED = "org.eclipse.rcptt.tesla.recording.iml.imaging.supported";

	/**
	 * Enable IML for Canvas controls
	 */
	public final static String USE_IMAGING = "org.eclipse.rcptt.tesla.recording.iml.imaging.use";
	public final static String USE_IMAGING_RAW_CANVAS = "org.eclipse.rcptt.tesla.recording.iml.imaging.use.raw.canvas.only";

	public final static String USE_IMAGING_ALG_SEARCH = "org.eclipse.rcptt.tesla.recording.iml.imaging.alg.search";
	public final static String USE_IMAGING_ALG_SELECT = "org.eclipse.rcptt.tesla.recording.iml.imaging.alg.select";
	public final static String USE_IMAGING_ALG_SELECT_LEVEL = "org.eclipse.rcptt.tesla.recording.iml.imaging.alg.select.level";

	public final static String IML_CAPTURES_FOLDER = "org.eclipse.rcptt.tesla.recording.iml.imaging.captures_folder";

	public IMLFeatures() {
	}

	public static void init(AbstractFeatureManager manager) {
		manager.option(USE_IMAGING_SUPPORTED).category("Image Recognition")
				.name("Enable IR UI")
				.description("Should IR UI be enabled(testing)")
				.values(AbstractFeatureManager.BOOLEAN_VALUES).value("true")
				.defaultValue("true").editable(true)
				.showIn(/*TeslaFeatures.ADV_OPTIONS*/);

		manager.option(USE_IMAGING).name("").category("Image Recognition")
				.description("").values(AbstractFeatureManager.BOOLEAN_VALUES)
				.value("false").defaultValue("false").editable(true)
				.showIn(TeslaFeatures.NONE);

		manager.option(USE_IMAGING_RAW_CANVAS).category("Image Recognition")
				.name("Don't use IR for supported controls(GEF/GMF)")
				.description("Skip GEF/GMF and so on controls for IR")
				.values(AbstractFeatureManager.BOOLEAN_VALUES).value("true")
				.defaultValue("true").editable(true)
				.showIn(/*TeslaFeatures.ADV_OPTIONS*/);

		String[] search = new String[] { "advanced", "simple" };
		String[] select = new String[] { "connectedRegion", "text", "simple" };

		manager.option(USE_IMAGING_ALG_SEARCH).category("Image Recognition")
				.name("Search method")
				.description("Use this particular IR search algorithm")
				.values(search).value(search[0]).defaultValue(search[0])
				.editable(true).showIn(/*TeslaFeatures.ADV_OPTIONS*/);
		manager.option(IML_CAPTURES_FOLDER)
				.category("Image Recognition")
				.name("Folder to capture screenshots to")
				.description(
						"Use this folder to capture screenshots. Folder should exist")
				.value("").defaultValue("").editable(true)
				.showIn(/*TeslaFeatures.ADV_OPTIONS*/);

		manager.option(USE_IMAGING_ALG_SELECT).category("Image Recognition")
				.name("Selection method")
				.description("Use this particular image selection algorithm")
				.values(select).value(select[0]).defaultValue(select[0])
				.editable(true).showIn(/*TeslaFeatures.ADV_OPTIONS*/);

		manager.option(USE_IMAGING_ALG_SELECT_LEVEL)
				.category("Image Recognition").name("Selection level")
				.description("Use bigger values for selecting bigger areas")
				.value("0").defaultValue("0").editable(true)
				.showIn(/*TeslaFeatures.ADV_OPTIONS*/);

	}
}
