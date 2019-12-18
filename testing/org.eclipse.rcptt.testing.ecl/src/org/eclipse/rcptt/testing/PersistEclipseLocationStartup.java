package org.eclipse.rcptt.testing;
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
import org.eclipse.ui.IStartup;


public class PersistEclipseLocationStartup implements IStartup {

	public void earlyStartup() {
		InvokeAUTService.updateEclipseLocation();
	}

}
