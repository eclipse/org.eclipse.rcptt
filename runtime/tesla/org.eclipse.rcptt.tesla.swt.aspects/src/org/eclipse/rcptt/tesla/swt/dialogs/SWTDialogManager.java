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
package org.eclipse.rcptt.tesla.swt.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.MessageBox;

public class SWTDialogManager {
	private static List<String> fileDialogValues = new ArrayList<String>();
	private static List<String> folderDialogValues = new ArrayList<String>();
	private static List<Integer> messageBoxValues = new ArrayList<Integer>();
	private static MessageBoxInfo lastMessageBoxInfo = null;
	private static List<RGB> colorValues = new ArrayList<RGB>();
	private static List<FontData> fontValues = new ArrayList<FontData>();
	private static boolean cancelMessageBoxesDisplay = false;

	public static boolean hasFileDialogInfo() {
		return !fileDialogValues.isEmpty();
	}

	public static boolean hasFolderDialogInfo() {
		return !folderDialogValues.isEmpty();
	}

	public static boolean hasMessageBoxInfo() {
		return !messageBoxValues.isEmpty();
	}

	public static boolean hasFontInfo() {
		return !fontValues.isEmpty();
	}

	public static boolean hasColorInfo() {
		return !colorValues.isEmpty();
	}

	public static String getFileDialogResult() {
		return fileDialogValues.get(0);
	}

	public static String getFileDialogFilterPath() {
		final String value = fileDialogValues.get(0);
		if (value == null) {
			return null;
		}
		IPath filterPath = new Path(fileDialogValues.get(0));
		return filterPath.removeLastSegments(1).toOSString();
	}

	public static String[] getFileDialogFilesList(String filterPath) {
		List<String> files = new ArrayList<String>();
		while (!fileDialogValues.isEmpty()) {
			final String nextValue = fileDialogValues.get(0);
			if (nextValue == null) {
				fileDialogValues.remove(0);
				break;
			}
			final IPath nextFile = new Path(nextValue);
			if (!nextFile.toOSString().startsWith(filterPath)) {
				break;
			}
			fileDialogValues.remove(0);
			files.add(nextFile.lastSegment());
		}
		return files.toArray(new String[files.size()]);
	}
	
	public static void resetFileDialogInfo() {
		fileDialogValues.clear();
	}

	public static FontData getFontResult() {
		return fontValues.remove(0);
	}

	public static RGB getColorResult() {
		return colorValues.remove(0);
	}

	public static String getFolderDialogResult() {
		return folderDialogValues.remove(0);
	}

	public static Integer getMessageBoxResult() {
		return messageBoxValues.remove(0);
	}
	
	public static MessageBoxInfo getMessageBoxInfo() {
		return lastMessageBoxInfo;
	}

	public static void addFileDialogInfo(String value) {
		fileDialogValues.add(0, value);
	}

	public static void addFolderDialogInfo(String value) {
		folderDialogValues.add(0, value);
	}

	public static void addMessageBoxInfo(int result) {
		messageBoxValues.add(0, result);
	}
	
	public static void setMessageBoxInfo(MessageBox dialog) {
		lastMessageBoxInfo = TeslaFactory.eINSTANCE.createMessageBoxInfo();
		lastMessageBoxInfo.setTitle(dialog.getText());
		lastMessageBoxInfo.setMessage(dialog.getMessage());
	}

	public static void addFontInfo(FontData value) {
		fontValues.add(0, value);
	}

	public static void addColorInfo(RGB value) {
		colorValues.add(0, value);
	}

	public static void clear() {
		fileDialogValues.clear();
		folderDialogValues.clear();
		messageBoxValues.clear();
		lastMessageBoxInfo = null;
		colorValues.clear();
		fontValues.clear();
	}

	public static boolean isCancelAllMessageBoxes() {
		return cancelMessageBoxesDisplay;
	}

	public static void setCancelMessageBoxesDisplay(
			boolean cancelMessageBoxesDisplay) {
		SWTDialogManager.cancelMessageBoxesDisplay = cancelMessageBoxesDisplay;
	}
}
