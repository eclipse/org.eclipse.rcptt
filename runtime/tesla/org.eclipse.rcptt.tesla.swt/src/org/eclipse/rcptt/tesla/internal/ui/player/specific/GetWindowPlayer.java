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
package org.eclipse.rcptt.tesla.internal.ui.player.specific;

import static org.eclipse.rcptt.tesla.swt.util.GetWindowUtil.byClass;
import static org.eclipse.rcptt.tesla.swt.util.GetWindowUtil.byFrom;
import static org.eclipse.rcptt.tesla.swt.util.GetWindowUtil.byText;
import static org.eclipse.rcptt.tesla.swt.util.GetWindowUtil.decodeClass;
import static org.eclipse.rcptt.tesla.swt.util.GetWindowUtil.decodeFrom;
import static org.eclipse.rcptt.tesla.swt.util.IndexUtil.selectFrom;

import org.eclipse.core.runtime.Platform;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.swt.util.IndexUtil.Criterion;
import org.eclipse.swt.widgets.Shell;

public class GetWindowPlayer {
	private static final boolean DEBUG = "true".equals(Platform.getDebugOption("org.eclipse.rcptt.tesla.swt/debug/shellSelect"));

	private SWTUIPlayer player;
	private SWTUIElement[] ignoreWindows;

	public GetWindowPlayer(SWTUIPlayer player, SWTUIElement[] ignoreWindows) {
		this.player = player;
		this.ignoreWindows = ignoreWindows;
	}


	public SWTUIElement selectShell(PlayerSelectionFilter f) {

		String from = decodeFrom(f.path);
		if (from != null) {
			return selectShellBy(f, byFrom(from));
		}

		String klass = decodeClass(f.path);
		if (klass != null) {
			return selectShellBy(f, byClass(klass));
		}

		String pattern = (f.pattern != null) ? f.pattern.trim()
				: null;
		SWTUIElement rv = selectShellBy(f, byText(pattern));
		debug("Selected shell: " + f.path + ", " + f.pattern + ", found: " + rv);
		return rv;
	}

	//
	
	private SWTUIElement selectShellBy(PlayerSelectionFilter f, Criterion crite) {
		return selectShellBy(f.parent, f.index, f.after, crite);
	}

	private SWTUIElement selectShellBy(SWTUIElement parent,
			Integer index, SWTUIElement after, Criterion crite) {

		SWTUIElement ret = selectFrom(children(parent, after), index, crite);
		if (ret != null) return ret;

		// Because of remove of get-eclipse-window
		// it is unclear how to handle parent
		// sometimes.
		if (parent != null)
			return selectShellBy(null, index, after, crite);

		return null;
	}

	private SWTUIElement[] children(SWTUIElement parent, SWTUIElement after) {
		Class<?>[] classes = new Class<?>[] { Shell.class };
		return player.children.collectFor(parent, ignoreWindows, true, classes, after);
	}

	private static void debug(String message) {
		if (DEBUG)
			System.out.println(message);
	}

}
