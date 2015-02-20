package org.eclipse.rcptt.reporting.core;

import java.io.PrintWriter;
import java.io.Writer;

public abstract class IndentedWriter extends PrintWriter {
	private boolean newLine = true;

	public IndentedWriter(Writer out) {
		super(out);
	}

	@Override
	public void println() {
		super.println();
		newLine = true;
	}

	@Override
	public void write(String s, int off, int len) {
		if (newLine) {
			newLine = false;
			writeIndent();
		}
		super.write(s, off, len);
	}

	public abstract void writeIndent();
}