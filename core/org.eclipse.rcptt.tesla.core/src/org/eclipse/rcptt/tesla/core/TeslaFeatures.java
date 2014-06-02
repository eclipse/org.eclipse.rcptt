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
package org.eclipse.rcptt.tesla.core;

import org.eclipse.rcptt.tesla.core.features.IMLFeatures;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFeatures;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class TeslaFeatures extends AbstractFeatureManager {
	private static final String CAT_COMMAND_DELAYS = "Command Delays";
	private static final String TESLA_PROTOCOL_VERSION = "1.0.1";
	// Protocol options
	public final static String PROTOCOL_VERSION = "org.eclipse.rcptt.tesla.protocol.version";

	public final static String COMMAND_EXECUTION_DELAY = "org.eclipse.rcptt.tesla.ecl.execution.delay";
	public final static String INTERNAL_CLIPBOARD = "org.eclipse.rcptt.tesla.internal.clipboard";
	public final static String COMMAND_EXECUTION_DELAY_TESLA = "org.eclipse.rcptt.tesla.execution.delay";
	public final static String RECORD_ALL_SELECTIONS = "org.eclipse.rcptt.tesla.record.all.selections";

	public final static String ACTIVITY_LOGS = "com.xored.runtime.enable.activity.logs";

	public static final String ADV_OPTIONS = "adv.options";

	public static final String NONE = "";
	public static final String CP_OPTIONS = "cp.options";

	public static final String STATUS_DIALOG_ALLOWED = "com.xored.runtime.status.dialog.allowed";

	public static final String ENABLE_PROTECTED_MEMBERS = "enable.protected.members";

	public static String PROFILING = "q7.profilig";

	// Logging features
	public static final String LOGGING_OPTIONS = "logging.options";
	public static final String CAT_LOGGING = "Logging";
	public static String CAPTURE_EXECUTION = "q7.image.capture";

	public static String CAT_REPORTING = "Reporting";
	public final static String REPORT_PASSED_TEST_DETAILS = "com.xored.reporting.passed.test.details";
	public final static String REPORT_INCLUDE_IGNORED_WAIT_DETAILS = "com.xored.reporting.include.ignored.wait.details";
	public final static String REPORT_PASSED_WAIT_DETAILS = "com.xored.reporting.include.passed.wait.details";

	// Code:
	private static TeslaFeatures features;

	public static TeslaFeatures getInstance() {
		if (features == null) {
			features = new TeslaFeatures();
			features.loadFromPreferences(TeslaCore.getPreferences());
		}
		return features;
	}

	public TeslaFeatures() {
		option(PROTOCOL_VERSION).name("Protocol version")
				.value(TESLA_PROTOCOL_VERSION).editable(false)
				.showIn(ADV_OPTIONS);

		option(COMMAND_EXECUTION_DELAY)
				.name("ECL command execution delay")
				.category(CAT_COMMAND_DELAYS)
				.value("0")
				.defaultValue("0")
				.values(AbstractFeatureManager.INT_VALUES)
				.description(
						"Wait for specified milliseconds before execution of next Tesla ECL command")
				.editable(true).showIn(NONE);

		option(COMMAND_EXECUTION_DELAY_TESLA)
				.name("Tesla command execution delay")
				.category(CAT_COMMAND_DELAYS)
				.value("0")
				.defaultValue("0")
				.values(AbstractFeatureManager.INT_VALUES)
				.description(
						"Wait for specified milliseconds before execution of next Tesla command")
				.editable(true).showIn(NONE);

		option(INTERNAL_CLIPBOARD)
				.name("Use internal clipboard")
				.category("Clipboard options")
				.value("false")
				.defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES)
				.description(
						"Do not use OS clipboard for copy/paste operations.")
				.editable(true).showIn(ADV_OPTIONS);

		option(REPORT_PASSED_TEST_DETAILS).category(CAT_REPORTING)
				.name("Include 'trace' and 'take-screenshot' in HTML report")
				.value("false")
				.defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES)
				.description(
						"Command 'trace' and 'take-screenshot' can be used to add data into test report")
				.editable(true).showIn(ADV_OPTIONS);

		option(REPORT_INCLUDE_IGNORED_WAIT_DETAILS).category(CAT_REPORTING)
				.name("Include 'ignored' timers into report files.")
				.value("false")
				.defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES)
				.description(
						"RCPTT widget details will contain ignored timer calls.")
				.editable(true).showIn(ADV_OPTIONS);

		option(REPORT_PASSED_WAIT_DETAILS).category(CAT_REPORTING)
				.name("Include 'wait details' into passed report entries.")
				.value("true")
				.defaultValue("true")
				.values(AbstractFeatureManager.BOOLEAN_VALUES)
				.description(
						"RCPTT widget wait details will be also added to passed reports as separate section.")
				.editable(true).showIn(ADV_OPTIONS);

		option(RECORD_ALL_SELECTIONS)
				.name("Record all selections for tables and trees")
				.value("false")
				.defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES)
				.description(
						"Enables or disables collapsing of selection events")
				.editable(true).showIn(ADV_OPTIONS, CP_OPTIONS);

		option(STATUS_DIALOG_ALLOWED)
				.name("Allow status dialogs")
				.description(
						"Should the test pass, if appears the status dialog with an error ?")
				.value("false").defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES).editable(true)
				.showIn(TeslaFeatures.ADV_OPTIONS, TeslaFeatures.CP_OPTIONS);

		option(ENABLE_PROTECTED_MEMBERS)
				.name("Use protected members in Advanced properties")
				.description(
						"Enable assertions for protected fields and methods")
				.value("false").defaultValue("false").values(BOOLEAN_VALUES)
				.editable(true).showIn(ADV_OPTIONS);
		// Diagram options
		DiagramFeatures.init(this);
		// Initialize other features
		IMLFeatures.init(this);
		// Timesouts
		TeslaLimits.init(this);

		option(PROFILING).name("Enable Job/async/sync profiling")
				.description("Do advanced logging of jobs/async/syncs").value("false")
				.defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES).editable(true)
				.showIn();// TeslaFeatures.LOGGING_OPTIONS,
							// TeslaFeatures.CP_OPTIONS);
		option(CAPTURE_EXECUTION).category(CAT_LOGGING).name("Enable per command image capture")
				.description("Capture screenshots on each command execution")
				.value("false").defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES).editable(true)
				.showIn(TeslaFeatures.ADV_OPTIONS, TeslaFeatures.CP_OPTIONS);
		option(ACTIVITY_LOGS)
				.name("Enable Activity logging")
				.category(CAT_LOGGING)
				.value("false")
				.defaultValue("false")
				.values(AbstractFeatureManager.BOOLEAN_VALUES)
				.description(
						"Store RCPTT runtime activity events into .metadata/.plugins/org.eclipse.rcptt.logging")
				.editable(true).showIn(ADV_OPTIONS);
	}

	public static boolean isUseInternalClipboard() {
		return getInstance().isTrue(INTERNAL_CLIPBOARD);
	}

	public static boolean isActivityLogging() {
		return getInstance().isTrue(TeslaFeatures.ACTIVITY_LOGS);
	}

	public static boolean isIncludeIgnoredWaitDetails() {
		return getInstance().isTrue(TeslaFeatures.REPORT_INCLUDE_IGNORED_WAIT_DETAILS);
	}

	public static boolean isIncludePassedWaitDetails() {
		return getInstance().isTrue(TeslaFeatures.REPORT_PASSED_WAIT_DETAILS);
	}

	public static boolean isProtectedEnabled() {
		return getInstance().isTrue(ENABLE_PROTECTED_MEMBERS);
	}

	public boolean isProfilingEnabled() {
		return getInstance().isTrue(TeslaFeatures.PROFILING);
	}
}
