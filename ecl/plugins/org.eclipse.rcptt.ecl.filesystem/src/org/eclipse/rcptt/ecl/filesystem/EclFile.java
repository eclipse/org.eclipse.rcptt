package org.eclipse.rcptt.ecl.filesystem;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;

public interface EclFile {

	String getName();

	boolean exists();

	Collection<EclFile> getChildren() throws IOException;

	URI toURI();

	boolean isDirectory();

	void delete() throws IOException;
	
	void append(InputStream data) throws IOException;

	void write(InputStream data) throws IOException;

	InputStream read() throws IOException;
}
