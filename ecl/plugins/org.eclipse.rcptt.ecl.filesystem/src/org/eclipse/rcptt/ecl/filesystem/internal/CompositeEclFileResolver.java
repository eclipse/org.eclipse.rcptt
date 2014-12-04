package org.eclipse.rcptt.ecl.filesystem.internal;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.ecl.filesystem.EclFile;

public class CompositeEclFileResolver implements EclFileResolver {

	private final List<EclFileResolver> children = new ArrayList<EclFileResolver>();
	
	public void add(EclFileResolver resolver) {
		children.add(resolver);
	}
	
	@Override
	public EclFile resolve(URI uri) throws IOException {
		for (EclFileResolver child : children) {
			EclFile rv = child.resolve(uri);
			if (rv != null)
				return rv;
		}
		throw new IOException("failed to resolve " + uri);
	}

}
