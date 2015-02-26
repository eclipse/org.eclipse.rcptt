package org.eclipse.rcptt.internal.launching.ext;

import com.google.common.base.Predicate;

public class StartsWith implements Predicate<String> {
	private final String prefix;

	public StartsWith(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean apply(String input) {
		return input.startsWith(prefix);
	}

}