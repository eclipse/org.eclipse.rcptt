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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Text;

public class TextUtils {
	public static void copy(Text text) {
		Clipboard cb = new Clipboard(text.getDisplay());
		String textData = text.getSelectionText();
		if (textData != null) {
			TextTransfer textTransfer = TextTransfer.getInstance();
			cb.setContents(new Object[] { textData },
					new Transfer[] { textTransfer });
		}
	}

	public static void paste(Text text) {
		Clipboard cb = new Clipboard(text.getDisplay());
		TextTransfer transfer = TextTransfer.getInstance();
		String data = (String) cb.getContents(transfer);
		if (data != null) {
			text.insert(data);
		}
	}

	public static void cut(Text text) {
		copy(text);
		text.insert("");
	}

	public static boolean canCopy(Text nameText) {
		return nameText.getSelectionCount() > 0;
	}

	public static boolean canPaste(Text nameText) {
		Clipboard cb = new Clipboard(nameText.getDisplay());
		TextTransfer transfer = TextTransfer.getInstance();
		String data = (String) cb.getContents(transfer);
		return data != null;
	}

	public static boolean canCut(Text nameText) {
		return nameText.getSelectionCount() > 0;
	}

	// / Styled text
	public static void copy(StyledText text) {
		Clipboard cb = new Clipboard(text.getDisplay());
		String textData = text.getSelectionText();
		if (textData != null) {
			TextTransfer textTransfer = TextTransfer.getInstance();
			cb.setContents(new Object[] { textData },
					new Transfer[] { textTransfer });
		}
	}

	public static void paste(StyledText text) {
		text.paste();
	}

	public static void cut(StyledText text) {
		copy(text);
		text.insert("");
	}

	public static boolean canCopy(StyledText nameText) {
		return nameText.getSelectionCount() > 0;
	}

	public static boolean canPaste(StyledText nameText) {
		Clipboard cb = new Clipboard(nameText.getDisplay());
		TextTransfer transfer = TextTransfer.getInstance();
		String data = (String) cb.getContents(transfer);
		return data != null;
	}

	public static boolean canCut(StyledText nameText) {
		return nameText.getSelectionCount() > 0;
	}
}
