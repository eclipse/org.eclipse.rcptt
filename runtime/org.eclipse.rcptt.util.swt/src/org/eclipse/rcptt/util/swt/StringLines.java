/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.util.swt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.graphics.Point;

public class StringLines {

	private final String[] lines;
	public StringLines(String text) {
		lines = linesWithEndings(text);
	}
	
	private static final Pattern endings = Pattern.compile(".*(\r\n|\r|\n)");
	private static String[] linesWithEndings(String text) {
		Matcher m = endings.matcher(text);
		List<String> lines = new ArrayList<String>();
		int last = 0;
		while (m.find()) {
			String line = m.group();
			if (!line.isEmpty()) {
				lines.add(line);
			}
			last = m.end();
		}
		lines.add(text.substring(last)); // adding last line
		return lines.toArray(new String[lines.size()]);
	}
	
	private int lineWithoutEndingLength(int lineIndex) {
		String line = lines[lineIndex];
		int len = line.length();
		if (line.endsWith("\r\n")) return len - 2;
		if (line.endsWith("\r") || line.endsWith("\n")) return len - 1;
		return len;
	}
	
	//
	
	public String calcLineColumn(int istart) {
		int pos = 0;
		for (int j = 0; j < lines.length; j++) {
			assert (pos <= istart); // otherwise it would fits condition on previous step
			boolean lastLine = (j == lines.length - 1);
			if (istart < pos + lines[j].length() || lastLine) {
				return Integer.toString(j + 1) + ":"
						+ Integer.toString(istart - pos + 1);
			}
			pos += lines[j].length();
		}
		throw new AssertionError("should not be here");
	}
	
	//
	
	public int calcOffset(String coords) {
		try {
			return calcOffset(parseLineColumnCoords(coords));
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	public int calcOffset(Point coords) {
		try {
			int line = coords.x;
			int column = coords.y;
	
			if (line < 0 || line >= lines.length
					|| column < 0 || column > lineWithoutEndingLength(line)) {
				return -1;
			}
			
			int offset = 0;
			if (line > 0 && line < lines.length) {
				int ppos = 0;
				for (int j = 0; j < line; j++) {
					ppos += lines[j].length();
				}
				offset += ppos;
			}
			return offset + column;
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	private static Point parseLineColumnCoords(String pos) throws Exception {
		try {
			String[] split = pos.split(":");
			if (split.length == 2) {
				int line = Integer.parseInt(split[0]) - 1;
				int column = Integer.parseInt(split[1]) - 1;
				return new Point(line, column);
			}
		}
		catch (Exception e) {
			// throw exception below
		}
		throw new Exception("Cannot parse text location value");
	}
	
	public static int parseSingleLineCoord(String pos) {
		try {
			return Integer.parseInt(pos) - 1;
		}
		catch (Exception e) {
			return -1;
		}
	}
	
}
