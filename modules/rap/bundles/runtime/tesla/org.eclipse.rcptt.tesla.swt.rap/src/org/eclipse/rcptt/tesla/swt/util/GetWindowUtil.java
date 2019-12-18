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
package org.eclipse.rcptt.tesla.swt.util;

import static org.eclipse.rcptt.tesla.core.protocol.IWindowProvider.CLASS_PATH_MARK;
import static org.eclipse.rcptt.tesla.core.protocol.IWindowProvider.FROM_PATH_MARK;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils.getText;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils.removeAcceleratorFromText;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils.safeMatches;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.jface.rap.TeslaWindowManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.util.IndexUtil.Criterion;


public class GetWindowUtil {

	public static String encodeFrom(String from) {
		return FROM_PATH_MARK + "/" + from;
	}

	public static String encodeClass(String klass) {
		return CLASS_PATH_MARK + "/" + klass;
	}

	public static String decodeFrom(String[] path) {
		if (path == null || path.length != 2) return null;
		return path[0].equals(FROM_PATH_MARK) ? path[1] : null;
	}

	public static String decodeClass(String[] path) {
		if (path == null || path.length != 2) return null;
		return path[0].equals(CLASS_PATH_MARK) ? path[1] : null;
	}


	//

	public static String getShellCreationMethodName(Shell shell) {
		return TeslaEventManager.getManager().getShellCreationMethod(shell);
	}

	public static String getWindowClassName(Shell shell) {
		return TeslaWindowManager.getInstance().getWindowClassNameByShell(shell);
	}


	// criterions

	public static Criterion byFrom(final String methodName) {
		return new Criterion() {
			public boolean fits(SWTUIElement uiElem) {
				return methodName
						.equals(getShellCreationMethodName((Shell) unwrapWidget(uiElem)));
			}
		};
	}

	public static Criterion byClass(final String className) {
		return new Criterion() {
			public boolean fits(SWTUIElement uiElem) {
				return className
						.equals(getWindowClassName((Shell) unwrapWidget(uiElem)));
			}
		};
	}

	public static Criterion byText(final String pattern) {
		return new Criterion() {
			public boolean fits(SWTUIElement uie) {
				if (pattern == null) return true;

				String text = getText(uie);
				if (text == null) return false;

				text = removeAcceleratorFromText(text);
				return (text != null) &&
						(text.equals(pattern) || safeMatches(text, pattern));
			}
		};
	}

}
