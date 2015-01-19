package org.eclipse.rcptt.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Exceptions {
	public static String toString(Throwable e) {
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer, false);
		e.printStackTrace(printWriter);
		printWriter.close();
		return writer.toString();
	}
}
