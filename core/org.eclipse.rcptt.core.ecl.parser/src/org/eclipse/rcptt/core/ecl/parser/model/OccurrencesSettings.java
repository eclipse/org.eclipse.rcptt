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
package org.eclipse.rcptt.core.ecl.parser.model;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

public class OccurrencesSettings {
	public OccurrencesSettings(boolean enabled, boolean commands, boolean procs, boolean globals, boolean locals) {
		this.enabled = enabled;
		this.commands = commands;
		this.procs = procs;
		this.globals = globals;
		this.locals = locals;
	}

	public final boolean enabled;
	public final boolean commands;
	public final boolean procs;
	public final boolean locals;
	public final boolean globals;

	public void toPrefs(IEclipsePreferences prefs) {
		prefs.putBoolean(KEY_ENABLED, enabled);
		prefs.putBoolean(KEY_COMMANDS, commands);
		prefs.putBoolean(KEY_PROCS, procs);
		prefs.putBoolean(KEY_GLOBALS, globals);
		prefs.putBoolean(KEY_LOCALS, locals);
	}

	public static OccurrencesSettings fromPrefs(IEclipsePreferences prefs) {
		return new OccurrencesSettings(
				prefs.getBoolean(KEY_ENABLED, DEF_ENABLED),
				prefs.getBoolean(KEY_COMMANDS, DEF_COMMANDS),
				prefs.getBoolean(KEY_PROCS, DEF_PROCS),
				prefs.getBoolean(KEY_GLOBALS, DEF_GLOBALS),
				prefs.getBoolean(KEY_LOCALS, DEF_LOCALS));
	}

	private static final String KEY_ENABLED = "markOccurences";
	private static final String KEY_COMMANDS = "markCommands";
	private static final String KEY_PROCS = "markProcs";
	private static final String KEY_GLOBALS = "markGlobals";
	private static final String KEY_LOCALS = "markLocals";

	private static final boolean DEF_ENABLED = true;
	private static final boolean DEF_COMMANDS = true;
	private static final boolean DEF_PROCS = true;
	private static final boolean DEF_GLOBALS = true;
	private static final boolean DEF_LOCALS = true;

	public static final OccurrencesSettings DEFAULT = new OccurrencesSettings(DEF_ENABLED, DEF_COMMANDS, DEF_PROCS,
			DEF_GLOBALS, DEF_LOCALS);

}
