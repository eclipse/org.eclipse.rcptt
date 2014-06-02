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
package org.eclipse.rcptt.ui.editors.quickfix;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.core.internal.validators.ScriptValidator;
import org.eclipse.rcptt.core.ecl.parser.ast.Command;
import org.eclipse.rcptt.core.ecl.parser.ast.LiteralArg;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class GetParamCmdQuickFixer extends QuickFixer {

	private static final String label = "Replace 'get-param' with '$' annotation";
	private static final Image img = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_CUT);

	public GetParamCmdQuickFixer(int start, int end) {
		super(label, img, start, end);
	}

	@Override
	public void quickFix(IDocument doc) {
		String content = doc.get();
		int startOffset = start;

		Command badCmd = ScriptValidator.findCommand(content, startOffset);
		if (badCmd == null
				|| badCmd.args.size() > 1
				|| !(badCmd.lastArg() instanceof LiteralArg)) {
			return;
		}
		LiteralArg arg = (LiteralArg) badCmd.lastArg();
		String value = arg.value.text;
		if (value.startsWith("\"") && value.endsWith("\"")) {
			value = value.substring(1, value.length());
			value = value.substring(0, value.length() - 1);
		}

		try {
			doc.replace(badCmd.begin, badCmd.length(), "$" + value);
		} catch (BadLocationException e) {
			Q7UIPlugin.log(e);
		}
	}
}
