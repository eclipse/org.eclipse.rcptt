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
package org.eclipse.rcptt.core.swt.internal.ui;

import org.eclipse.rcptt.util.ShellUtils;
import org.eclipse.swt.widgets.Shell;

public class DefaultShellUtils implements ShellUtils {

	@Override
	public void forceActive(Object shell) {
		Shell s = (Shell) shell;
		s.forceActive();
	}
}
