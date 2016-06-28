/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.util.swt.KeysAndButtons;

import org.eclipse.rcptt.util.KeysAndButtons.IKeysAndButtonExtension;
import org.eclipse.swt.SWT;;

public class KeysAndButtonExtension implements IKeysAndButtonExtension {

	@Override
	public int getMod1() {
		return SWT.MOD1;
	}
	@Override
	public int getMod2() {
		return SWT.MOD2;
	}

	@Override
	public int getMod3() {
		return SWT.MOD3;
	}

	@Override
	public int getMod4() {
		return SWT.MOD4;
	}
	@Override
	public int getButton1() {
		return SWT.BUTTON1;
	}
	@Override
	public int getButton2() {
		return SWT.BUTTON2;
	}
	@Override
	public int getButton3() {
		return SWT.BUTTON3;
	}
	@Override
	public int getButton4() {
		return SWT.BUTTON4;
	}
	@Override
	public int getButton5() {
		return SWT.BUTTON5;
	}

}
