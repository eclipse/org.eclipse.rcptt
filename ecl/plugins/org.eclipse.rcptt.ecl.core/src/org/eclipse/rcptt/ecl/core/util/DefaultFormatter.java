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
package org.eclipse.rcptt.ecl.core.util;

public class DefaultFormatter implements ICommandFormatter {

	private static final int INDENT_SIZE = 4;
	private static final int LINE_LENGTH = 120;

	private static final String LINE_SEP = "\n";
	private static final String SPACE = " ";
	private static final String PIPE = "|";
	private static final String OPEN_BRACE = "{";
	private static final String CLOSE_BRACE = "}";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String ATTR_PREFIX = "-";

	private final StringBuffer buffer = new StringBuffer();
	private int level;
	private int lineNumber = 0;
	private int posInLine = 0;
	private int possibleLineBreak;
	private String lineBreak;

	private boolean firstSequenceCommand = true;
	private boolean firstPipeCommand = true;
	private boolean firstPipeCommandInGroup = true;
	private boolean firstPipeCommandInExec = true;

	private final boolean wrap;

	public DefaultFormatter() {
		this(true);
	}

	public DefaultFormatter(boolean wrap) {
		this.wrap = wrap;
		resetLineBreak();
	}

	public void newPipeCommand() {
		if (!(firstPipeCommand || firstPipeCommandInExec || firstPipeCommandInGroup)) {
			append(SPACE);
			possibleLineBreak();
			append(PIPE).append(SPACE);
		}
		firstPipeCommand = firstPipeCommandInExec = firstPipeCommandInGroup = false;
	}

	public void newSequenceCommand() {
		if (!firstSequenceCommand) {
			newLine();
		}
		addIndent();
		firstSequenceCommand = false;
		firstPipeCommand = true;
	}

	public void addCommandName(String name) {
		append(name);
	}

	public void addAttrName(String name, boolean forced) {
		if (forced) {
			append(SPACE);
			possibleLineBreak();
			append(ATTR_PREFIX).append(name);
		}
	}

	public void addAttrValue(String value) {
		append(SPACE);
		if (value.startsWith("\"") && value.length() > 3) {
			if (value.contains("\\n")) {
				String[] parts = value.split("\\\\n");
				append(parts[0]);
				for (int i = 1; i < parts.length; i++) {
					append("\\n");
					if (parts[i].length() > 1) {
						lineBreak(posInLine, "\"\n+ \"");
					}
					append(parts[i]);
				}
			} else {
				append(value.substring(0, 2));
				for (int i = 2; i + 1 < value.length(); i++) {
					// possibleLineBreak("\"\n+ \"");
					append(value.substring(i, i + 1));
				}
				append("\"");
			}
		} else {
			append(value);
		}
	}

	public void openGroup(boolean singleLine) {
		firstPipeCommandInGroup = true;
		append(SPACE).append(OPEN_BRACE);
		if (!singleLine)
			level++;
	}

	public void closeGroup(boolean singleLine) {
		firstPipeCommandInGroup = false;
		if (!singleLine) {
			level--;
			newLine();
			addIndent();
		}
		append(CLOSE_BRACE);
	}

	public void openExec() {
		firstPipeCommandInExec = true;
		append(SPACE).append(OPEN_BRACKET);
	}

	public void closeExec() {
		firstPipeCommandInExec = false;
		append(CLOSE_BRACKET);
	}

	@Override
	public String toString() {
		return buffer.toString();
	}

	public int getLineNumber() {
		return lineNumber;
	}

	private void addIndent() {
		for (int i = 0; i < level * INDENT_SIZE; i++)
			append(SPACE);
	}

	private DefaultFormatter append(String s) {
		buffer.append(s);
		posInLine += s.length();
		if (posInLine > LINE_LENGTH && possibleLineBreak > 0 && possibleLineBreak < posInLine) {
			lineBreak(possibleLineBreak, lineBreak);
		}
		return this;
	}

	private void lineBreak(int pos, String lineBreak) {
		if (wrap) {
			int index = lineBreak.indexOf('\n');
			StringBuilder sb = new StringBuilder(lineBreak.substring(0, index + 1));
			for (int i = 0; i < (level + 1) * INDENT_SIZE; i++)
				sb.append(SPACE);
			sb.append(lineBreak.substring(index + 1, lineBreak.length()));
			buffer.insert(buffer.length() - posInLine + pos, sb.toString());
			lineNumber++;
			posInLine -= pos + 1;
			posInLine += sb.length() - index;
			resetLineBreak();
		}
	}

	private void resetLineBreak() {
		possibleLineBreak = -1;
		lineBreak = "\n";
	}

	private void newLine() {
		buffer.append(LINE_SEP);
		lineNumber++;
		posInLine = 0;
		resetLineBreak();
	}

	private void possibleLineBreak() {
		this.possibleLineBreak = posInLine;
		this.lineBreak = "\n";
	}

}
