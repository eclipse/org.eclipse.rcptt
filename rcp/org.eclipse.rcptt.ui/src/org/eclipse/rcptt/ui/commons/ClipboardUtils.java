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
package org.eclipse.rcptt.ui.commons;

import java.io.StringWriter;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

public class ClipboardUtils {

	static Object[] getClipboardContents(Transfer transfer) {
		Object[] result = null;
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		result = (Object[]) clipboard.getContents(transfer);
		clipboard.dispose();
		return result;
	}

	static void setClipboardContents(Object[] contents, Transfer transfer,
			IContentNamer namer) {
		boolean first = true;
		StringWriter writer = new StringWriter();
		for (Object obj : contents) {
			if (!first) {
				writer.write('\n');
			}
			writer.write(namer.getContentName(obj));
			first = false;
		}

		Clipboard clipboard = new Clipboard(Display.getCurrent());
		clipboard.setContents(new Object[] { contents, writer.toString() },
				new Transfer[] { transfer, TextTransfer.getInstance() });
		clipboard.dispose();
	}
}
