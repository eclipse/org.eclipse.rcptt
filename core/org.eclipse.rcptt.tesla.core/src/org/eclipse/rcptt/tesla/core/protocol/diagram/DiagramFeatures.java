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
package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.rcptt.tesla.core.TeslaFeatures;

public class DiagramFeatures {

	private static final String CAT_DIAGRAMS = "Diagrams";
	private static final String CAT_DIAGRAM_MOUSE_OPTIONS = "$Diagram mouse options";
	private static final String FIG_IDENT = "$Figure identity recording";
	public static final String STORE_PALETTE_AS_NAME = "org.eclipse.rcptt.tesla.protocol.diagram.palette.entry";

	public static final String PART_LOCATOR_USE_FEATURE_NAME_IDENTITY = "org.eclipse.rcptt.tesla.protocol.diagram.part.locator.name.feature.support";

	public static final String PART_LOCATOR_USE_FEATURE_IDENTITY = "org.eclipse.rcptt.tesla.protocol.diagram.part.locator.feature.identity.support";
	public static final String PART_LOCATOR_USE_FEATURE_IDENTITY_NAMES = "org.eclipse.rcptt.tesla.protocol.diagram.part.locator.feature.identity.names";

	public static final String PART_LOCATOR_USE_IDENTITY = "org.eclipse.rcptt.tesla.protocol.diagram.part.locator.identity";
	public static final String PART_LOCATOR_USE_TEXT_IDENTITY = "org.eclipse.rcptt.tesla.protocol.diagram.part.locator.text.support";

	public static enum PartIdentity {
		Address, ClassName
	};

	public static final String[] PART_IDENTITY = new String[] {
			PartIdentity.Address.name(), PartIdentity.ClassName.name() };

	/**
	 * Record mouse-move only then mouse-down is happen and no mouse-up
	 */
	public static final String MOUSE_MOVE_MODE = "org.eclipse.rcptt.tesla.protocol.diagram.mouse.move.mode";
	public static final String MOUSE_HOVER_SUPPORT = "org.eclipse.rcptt.tesla.protocol.diagram.mouse.hover.support";

	public static enum MouseMoveMode {
		Smart,
		Never,
		Always
	}
	private static final String[] MOUSE_MOVE_VALUES = new String [] { MouseMoveMode.Smart.toString(),
		MouseMoveMode.Never.toString(), MouseMoveMode.Always.toString() };
	
	public static void init(TeslaFeatures opt) {
		opt.boolOption(STORE_PALETTE_AS_NAME, true).category(CAT_DIAGRAMS)
				.name("Store palette tools by name").showIn(TeslaFeatures.NONE);

		opt.option(MOUSE_MOVE_MODE)
				.category(CAT_DIAGRAM_MOUSE_OPTIONS)
				.name("Mouse move recording mode")
				.values(MOUSE_MOVE_VALUES)
				.defaultValue(MouseMoveMode.Smart.toString())
				.value(MouseMoveMode.Smart.toString())
				.showIn(TeslaFeatures.ADV_OPTIONS, TeslaFeatures.CP_OPTIONS);

		opt.boolOption(MOUSE_HOVER_SUPPORT, true)
				.category(CAT_DIAGRAM_MOUSE_OPTIONS)
				.name("Record mouse-hover commands")
				.showIn(TeslaFeatures.ADV_OPTIONS, TeslaFeatures.CP_OPTIONS);

		// By EMF name
		opt.boolOption(PART_LOCATOR_USE_FEATURE_NAME_IDENTITY, true)
				.category(FIG_IDENT)
				.name("EMF object identity by 'name feature' support")
				.showIn(TeslaFeatures.NONE).order(0);
		// By Text identity
		opt.boolOption(PART_LOCATOR_USE_TEXT_IDENTITY, true)
				.category(FIG_IDENT).name("Use text content for part identity")
				.showIn(TeslaFeatures.ADV_OPTIONS, TeslaFeatures.CP_OPTIONS)
				.order(2);
		// EMF features
		opt.boolOption(PART_LOCATOR_USE_FEATURE_IDENTITY, false)
				.category(FIG_IDENT).defaultValue("").value("")
				.name("EMF object identity by specified features")
				.showIn(TeslaFeatures.NONE).order(3);
		opt.option(PART_LOCATOR_USE_FEATURE_IDENTITY_NAMES)
				.category(FIG_IDENT)
				.name("Use following EMF features for part identity")
				.value("id,title")
				.defaultValue("id,title")
				.description(
						"Use following feature names\n(comma separated) then generate edit part selector")
				.showIn(TeslaFeatures.ADV_OPTIONS, TeslaFeatures.CP_OPTIONS)
				.order(4);
		// By Class name
		opt.option(PART_LOCATOR_USE_IDENTITY).category(FIG_IDENT)
				.defaultValue(PART_IDENTITY[1]).value(PART_IDENTITY[1])
				.name("Non EMF object identity method").values(PART_IDENTITY)
				.showIn(TeslaFeatures.ADV_OPTIONS).order(5);

	}
}
