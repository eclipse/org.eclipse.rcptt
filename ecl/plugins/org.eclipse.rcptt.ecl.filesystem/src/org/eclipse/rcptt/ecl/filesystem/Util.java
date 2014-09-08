package org.eclipse.rcptt.ecl.filesystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

public class Util {
	public static Writer getWriter(final EclFile file, final boolean append) {
		StringWriter writer = new StringWriter() {
			@Override
			public void close() throws IOException {
				super.close();
				InputStream is = new ByteArrayInputStream(toString().getBytes());
				if (append)
					file.append(is);
				else
					file.write(is);
			}
		};
		return writer;
	}
}
