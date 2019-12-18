/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.refactoring;

import java.util.List;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsRegistry;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class RefactoringUtils {

	public static String elementToString(IQ7NamedElement element) {
		try {
			if (element instanceof ITestCase) {
				return NLS.bind(Messages.RefactoringUtils_TestCase,
						element.getElementName());
			}
			if (element instanceof IContext) {
				return NLS.bind(Messages.RefactoringUtils_Context,
						element.getElementName());
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return NLS.bind(Messages.RefactoringUtils_Element, element.getName());
	}

	public static RefactoringStatus validateTagInSync(Tag tag) {
		TagsRegistry registry = Q7UIPlugin.getDefault().getTags();
		synchronized (registry) {
			if (containTag(registry.getTags(), tag)) {
				return new RefactoringStatus();
			}
		}
		return RefactoringStatus.createErrorStatus(NLS.bind(
				Messages.RefactoringUtils_TagOutOfSyncMsg, tag.getPath()));
	}

	private static boolean containTag(List<Tag> tags, Tag target) {
		if (tags.contains(target))
			return true;
		for (Tag t : tags) {
			if (containTag(t.getTags(), target)) {
				return true;
			}
		}
		return false;
	}

	private RefactoringUtils() {
		throw new AssertionError();
	}
}
