package org.eclipse.rcptt.ecl.core.util;

import org.eclipse.core.runtime.IStatus;

public class Statuses {
	public interface Visitor {
		/** @true is argument's children should be inspected too */
		boolean visit(IStatus status);
	}

	public static void visit(IStatus status, Visitor visitor) {
		if (status == null)
			return;
		if (visitor.visit(status)) {
			if (status.isMultiStatus()) {
				for (IStatus child : status.getChildren()) {
					visit(child, visitor);
				}
			}
		}
	}

	public static boolean hasCode(IStatus status, final int code) {
		final boolean[] rv = new boolean[] { false };
		visit(status, new Visitor() {

			@Override
			public boolean visit(IStatus status) {
				if (status.getCode() == code)
					rv[0] = true;
				return !rv[0];
			}
		});
		return rv[0];
	}
}
