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

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class SWTFactory {

	/**
	 * Sets width and height hint for the button control. <b>Note:</b> This is a
	 * NOP if the button's layout data is not an instance of
	 * <code>GridData</code>.
	 * 
	 * @param the
	 *            button for which to set the dimension hint
	 */
	public static void setButtonDimensionHint(Button button) {
		Dialog.applyDialogFont(button);
		Assert.isNotNull(button);
		Object gd = button.getLayoutData();
		if (gd instanceof GridData) {
			((GridData) gd).widthHint = getButtonWidthHint(button);
		}
	}

	/**
	 * Returns a width hint for a button control.
	 */
	public static int getButtonWidthHint(Button button) {
		if (button.getFont().equals(JFaceResources.getDefaultFont()))
			button.setFont(JFaceResources.getDialogFont());
		PixelConverter converter = new PixelConverter(button);
		int widthHint = converter
				.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		return Math.max(widthHint,
				button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
	}

	/**
	 * This method is used to make a combo box
	 * 
	 * @param parent
	 *            the parent composite to add the new combo to
	 * @param style
	 *            the style for the Combo
	 * @param hspan
	 *            the horizontal span to take up on the parent composite
	 * @param fill
	 *            how the combo will fill into the composite Can be one of
	 *            <code>GridData.FILL_HORIZONAL</code>,
	 *            <code>GridData.FILL_BOTH</code> or
	 *            <code>GridData.FILL_VERTICAL</code>
	 * @param items
	 *            the item to put into the combo
	 * @return a new Combo instance
	 */
	public static Combo createCombo(Composite parent, int style, int hspan,
			int fill, String[] items) {
		Combo c = new Combo(parent, style);
		c.setFont(parent.getFont());
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		c.setLayoutData(gd);
		if (items != null) {
			c.setItems(items);
		}
		// Some platforms open up combos in bad sizes without this, see bug
		// 245569
		c.setVisibleItemCount(30);
		c.select(0);
		return c;
	}

	/**
	 * This method is used to make a combo box with a default fill style of
	 * GridData.FILL_HORIZONTAL
	 * 
	 * @param parent
	 *            the parent composite to add the new combo to
	 * @param style
	 *            the style for the Combo
	 * @param hspan
	 *            the horizontal span to take up on the parent composite
	 * @param items
	 *            the item to put into the combo
	 * @return a new Combo instance
	 */
	public static Combo createCombo(Composite parent, int style, int hspan,
			String[] items) {
		Combo c = new Combo(parent, style);
		c.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = hspan;
		c.setLayoutData(gd);
		if (items != null) {
			c.setItems(items);
		}
		// Some platforms open up combos in bad sizes without this, see bug
		// 245569
		c.setVisibleItemCount(30);
		c.select(0);
		return c;
	}

	/**
	 * This method allows us to open the preference dialog on the specific page,
	 * in this case the perspective page
	 * 
	 * @param shell
	 *            the parent shell
	 * @param id
	 *            the id of preference page to show
	 * @param page
	 *            the actual page to show
	 * @return the result of Window.open()
	 */
	public static int showPreferencePage(Shell shell, String id, Object data) {
		return PreferencesUtil.createPreferenceDialogOn(shell, id,
				new String[] { id }, data).open();
	}
}
