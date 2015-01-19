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
package org.eclipse.rcptt.ecl.doc;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Stack;

public class EclDocWriter {

	public static String writeToString(IEclDocProvider provider,
			String errorMessage) {
		try {
			StringWriter buffer = new StringWriter();
			EclDocWriter w = new EclDocWriter(buffer);
			provider.writeEclDoc(w);
			w.finish();
			return buffer.toString();
		} catch (IOException e) {
			return errorMessage;
		}
	}

	private Writer out;

	public EclDocWriter(Writer out) {
		this.out = out;
	}

	public void finish() throws IOException {
		while (!openNodes.isEmpty()) {
			close();
		}
		out.flush();
		out.close();
	}

	public void dl() throws IOException {
		open("dl");
	}

	public void dt(String innerHtml) throws IOException {
		open("dt");
		text(innerHtml);
		close();
	}

	public void b(String innerHtml) throws IOException {
		open("b");
		text(innerHtml);
		close();
	}

	public void dd() throws IOException {
		open("dd");
	}

	public void dd(String innerHtml) throws IOException {
		dd();
		text(innerHtml);
		close();
	}

	public void pre(String innerHtml) throws IOException {
		open("pre");
		closeOpenTag();
		out.append(innerHtml);
		close();
	}

	public void anchor(String anchor) throws IOException {
		open("a").attr("id", anchor).text("").close();
	}

	public EclDocWriter text(String text) throws IOException {
		closeOpenTag();

		for (String line : text.split("(\r)?\n")) {
			writeIndent();
			out.append(line).append(NEWLINE);
		}

		return this;
	}

	public void raw(String text) throws IOException {
		out.append(text);
	}

	public void raw(Integer number) throws IOException {
		raw(number.toString());
	}

	public void tag(String node, String text) throws IOException {
		closeOpenTag();
		writeIndent();
		out.append(String.format("<%s>", node)).append(text)
				.append(String.format("</%s>", node)).append(NEWLINE);
	}

	public void close() throws IOException {
		level--;
		if (!openNodeClosed) {
			out.append(" />").append(NEWLINE);
			openNodeClosed = true;
			openNodes.pop();
		} else {
			writeIndent();
			out.append(String.format("</%s>", openNodes.pop())).append(NEWLINE);
		}
	}

	private void closeOpenTag() throws IOException {
		if (openNodeClosed) {
			return;
		}
		out.append(">").append(NEWLINE);
		openNodeClosed = true;

	}

	public EclDocWriter open(String node) throws IOException {
		if (!openNodeClosed) {
			out.append(">").append(NEWLINE);
		}

		writeIndent();
		out.append(String.format("<%s", node));
		openNodes.push(node);
		openNodeClosed = false;
		level++;

		return this;
	}

	public EclDocWriter attr(String name, String value) throws IOException {
		out.append(String.format(" %s=\"%s\"", name, value));
		return this;
	}

	private void writeIndent() throws IOException {
		for (int i = 0; i < level; i++) {
			out.append(INDENT);
		}
	}

	private boolean openNodeClosed = true;

	private static final String NEWLINE = "\n";
	private static final String INDENT = "  ";
	private int level = 0;
	private Stack<String> openNodes = new Stack<String>();
}
