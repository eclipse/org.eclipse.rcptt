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
package org.eclipse.rcptt.verifications.text.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.core.VerificationProcessor;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.verifications.runtime.ErrorList;
import org.eclipse.rcptt.verifications.text.TextFactory;
import org.eclipse.rcptt.verifications.text.TextVerification;
import org.eclipse.swt.widgets.Widget;

public class TextVerificationProcessor extends VerificationProcessor {

	@Override
	public void finish(Verification verification, Object data, IProcess process) throws CoreException {
		final TextVerification textVerification = (TextVerification)
				verification;
		final SWTUIElement swtuiElement =
				TeslaBridge.resolveSWTUIElement(textVerification.getSelector(), process);
		final Widget widget = swtuiElement.widget;

		final ErrorList errors = new ErrorList();

		widget.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				String expectedText = textVerification.getText();
				if (expectedText == null)
					expectedText = "";

				String actualText = PlayerTextUtils.getTextForVerification(swtuiElement);
				if (actualText == null)
					actualText = "";

				if (!actualText.equals(expectedText)) {
					errors.add("Expected text is \"%s\", but it was \"%s\".",
							expectedText, actualText);
				}
			}
		});

		errors.throwIfAny(String.format("Widget text verification '%s' failed:", verification.getName()),
				this.getClass().getPackage().getName(), verification.getId());
	}

	@Override
	public Verification create(EObject param, IProcess process) throws CoreException {
		final TextVerification p = (TextVerification) param;
		final SWTUIElement swtuiElement =
				TeslaBridge.resolveSWTUIElement(p.getSelector(), process);
		final Widget widget = swtuiElement.widget;

		final TextVerification result = TextFactory.eINSTANCE.createTextVerification();

		widget.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				result.setSelector(p.getSelector());
				result.setText(PlayerTextUtils.getTextForVerification(swtuiElement));

				result.setIgnoreStyling(true);
			}
		});

		return result;
	}
}
