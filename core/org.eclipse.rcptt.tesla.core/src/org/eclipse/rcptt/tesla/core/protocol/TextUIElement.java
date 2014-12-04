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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.core.utils.Cryptography;

public class TextUIElement extends ControlUIElement {

	public TextUIElement(Element e, UIPlayer player) {
		super(e, player);
	}

	public void setText(String text) {
		SetText cmd = factory.createSetText();
		cmd.setElement(getElement());
		cmd.setValue(text);
		player.safeExecuteCommand(cmd);
	}

	public void setText(String text, boolean select, boolean hide) {
		SetText cmd = factory.createSetText();
		cmd.setElement(getElement());
		cmd.setValue(hide ? Cryptography.INSTANCE.encrypt(text) : text);
		cmd.setSelect(select);
		cmd.setHidden(hide);
		player.safeExecuteCommand(cmd);
	}

	public void select(String text) {
		SetSelection cmd = factory.createSetSelection();
		cmd.setElement(getElement());
		cmd.setPattern(text);
		player.safeExecuteCommand(cmd);
	}

	public void setSelection(int startLine, int startOffset, int endLine,
			int endOffset) {
		SetTextSelection cmd = factory.createSetTextSelection();
		cmd.setOffset(startOffset);
		cmd.setStartLine(startLine);
		cmd.setEndline(endLine);
		cmd.setEndoffset(endOffset);

		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void setSelection2(int startLine, int startOffset, int endLine,
			int endOffset) {
		SetTextSelection2 cmd = factory.createSetTextSelection2();
		cmd.setStartOffset(startOffset);
		cmd.setStartLine(startLine);
		cmd.setEndLine(endLine);
		cmd.setEndOffset(endOffset);

		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void setSelection(int offset, int length) {
		SetTextSelection cmd = factory.createSetTextSelection();
		cmd.setOffset(offset);
		cmd.setLength(length);

		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	/**
	 * Set current cursot cater position.
	 * 
	 * @param offset
	 */
	public void setTextOffset(int line, int offset) {
		SetTextOffset cmd = factory.createSetTextOffset();
		cmd.setOffset(offset);
		cmd.setLine(line);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void setTextCursor(int line, int offset) {
		SetCursorOffset cmd = factory.createSetCursorOffset();
		cmd.setLine(line);
		cmd.setOffset(offset);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void showSelection() {
		ShowSelection cmd = factory.createShowSelection();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void gotoLine(int line) {
		GoToTextLine cmd = factory.createGoToTextLine();
		cmd.setLine(line);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public TextSelection getSelection() {
		GetTextSelection cmd = factory.createGetTextSelection();
		cmd.setElement(getElement());
		TextSelectionResponse response = (TextSelectionResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return null;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute getSelection");
		}
		TextSelection selection = new TextSelection();
		selection.startOffset = response.getX();
		selection.endOffset = response.getY();
		selection.text = response.getText();
		return selection;
	}

	public int getLineOffset(int line) {
		GetTextLineOffset cmd = factory.createGetTextLineOffset();
		cmd.setElement(getElement());
		cmd.setLine(line);
		IntResponse response = (IntResponse) player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return -1;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute getLineOffset");
		}
		return response.getResult();
	}

	public int getLineLength(int line) {
		GetTextLineLength cmd = factory.createGetTextLineLength();
		cmd.setElement(getElement());
		cmd.setLine(line);
		IntResponse response = (IntResponse) player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return -1;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute getTextLineLength");
		}
		return response.getResult();
	}

	public void selectLine(int line) {
		SelectTextLine cmd = factory.createSelectTextLine();
		cmd.setElement(getElement());
		cmd.setLine(line);
		Response response = player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute selectLine");
		}
	}

	public String getLine(int line) {
		GetTextLine cmd = factory.createGetTextLine();
		cmd.setElement(getElement());
		cmd.setLine(line);
		GetTextResponse response = (GetTextResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return null;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute getTextLine");
		}
		return response.getText();
	}

	public String getText(int startOffset, int endOffset) {
		GetTextRange cmd = factory.createGetTextRange();
		cmd.setElement(getElement());
		cmd.setStartOffset(startOffset);
		cmd.setEndOffset(endOffset);
		GetTextResponse response = (GetTextResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return null;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute getTextRange");
		}
		return response.getText();
	}

	public void copy() {
		CopyTextSelection cmd = factory.createCopyTextSelection();
		cmd.setElement(getElement());
		Response response = player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute copy");
		}
	}

	public void cut() {
		CutTextSelection cmd = factory.createCutTextSelection();
		cmd.setElement(getElement());
		Response response = player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute cut");
		}
	}

	public void paste() {
		PasteTextSelection cmd = factory.createPasteTextSelection();
		cmd.setElement(getElement());
		Response response = player.safeExecuteCommand(cmd);
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute paste");
		}
	}

	public void replaceSelection(String text) {
		ReplaceTextSelection cmd = factory.createReplaceTextSelection();
		cmd.setElement(getElement());
		cmd.setText(text);
		Response response = player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute replace selection");
		}
	}

	public static class TextSelection {
		public int startOffset = 0;
		public int endOffset = 0;
		public String text = "";
	}

	public void defaultClick() {
		Click click = factory.createClick();
		click.setElement(getElement());
		click.setDefault(true);
		Response response = player.safeExecuteCommand(click);
		if (response == null) { // In case we are in recording
			return;
		}
	}

	@Override
	public void press(int code, int mask) {
		press(code, mask, (char) (code & 0xFF));
	}

	public void press(int code) {
		press(code, 0, (char) (code & 0xFF));
	}

	public void showContentAssist() {
		ShowContentAssist cmd = factory.createShowContentAssist();
		cmd.setElement(getElement());
		Response response = player.safeExecuteCommand(cmd);
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute show content assist");
		}
	}

	/**
	 * The difference of this command from {@link #hoverAtText(int, int, int)}
	 * is that this command is more low-level - it targets StyledText control,
	 * while {@link #hoverAtText(int, int, int)} works with text editors
	 * 
	 * @param offset
	 * @param line
	 */
	public void hoverAtOffset(int offset, int line) {
		HoverAtTextOffset hover = factory.createHoverAtTextOffset();
		hover.setElement(getElement());
		hover.setOffset(offset);
		hover.setLine(line);
		Response response = player.safeExecuteCommand(hover);
		if (response == null) { // In case we are in recording
			return;
		}
	}

	public void hoverAtText(int line, int offset, int stateMask) {
		HoverAtText hover = factory.createHoverAtText();
		hover.setElement(getElement());
		hover.setLine(line);
		hover.setOffset(offset);
		hover.setStateMask(stateMask);
		Response response = player.safeExecuteCommand(hover);
		if (response == null) { // In case we are in recording
			return;
		}
	}

	public void openDeclaration() {
		OpenDeclaration openDeclaration = factory.createOpenDeclaration();
		openDeclaration.setElement(getElement());
		Response response = player.safeExecuteCommand(openDeclaration);
		if (response == null) { // In case we are in recording
			return;
		}
	}
}
