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
package org.eclipse.rcptt.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.tags.Tag;

public class TagsUtil {
	public static List<String> extractTags(final String tagsString) {
		final List<String> tags = new ArrayList<String>(4);
		if (tagsString != null && !"".equals(tagsString.trim())) { //$NON-NLS-1$
			for (final String s : tagsString.split("[,;\\:]")) { //$NON-NLS-1$
				tags.add(s.trim());
			}
		}
		return tags;
	}
	
	/**
	 * Returns true if given test or context has any of given tags.
	 * 
	 * @param e 
	 * @param tags
	 * @return <code>true</code> if e has any of tags
	 * @throws ModelException 
	 */
	public static boolean hasAny(final IQ7NamedElement e, List<String> tags) throws ModelException {
		List<String> elementTags = extractTags(e);
		return hasAny(tags, elementTags);
	}

	public static boolean hasAny(List<String> tags, List<String> elementTags) {
		for(String tag : tags) {
			if(elementTags.contains(tag)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasAny(final IQ7NamedElement e, String[] tags) throws ModelException {
		return hasAny(e, Arrays.asList(tags));
	}
	public static List<String> extractTags(final IQ7NamedElement e) throws ModelException {
		return extractTags(e.getTags());
	}
	
	public static List<IQ7NamedElement> getDistinctTagRefs(Tag tag) {
		return getDistinctTagRefs(tag, new ArrayList<IQ7NamedElement>());
	}

	public static int getDistinctTagRefsCount(Tag tag) {
		return getDistinctTagRefs(tag, new ArrayList<IQ7NamedElement>()).size();
	}

	private static List<IQ7NamedElement> getDistinctTagRefs(Tag tag,
			List<IQ7NamedElement> considered) {
		synchronized (tag) {
			for (IQ7NamedElement element : tag.getRefs()) {
				if (!considered.contains(element))
					considered.add(element);
			}
			for (Tag childTag : tag.getTags()) {
				getDistinctTagRefs(childTag, considered);
			}
		}
		return considered;
	}

	public static Tag getParentTag(Tag tag) {
		EObject parent = tag.eContainer();
		if (parent instanceof Tag) {
			return (Tag) parent;
		}
		return null;
	}
}
