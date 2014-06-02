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
package org.eclipse.rcptt.expandbar.runtime.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;

import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;

public class ItemLocation {
	private static final int NO_INDEX = 0;

	private ItemLocation(String text, int index) {
		assert index >= 0;
		this.text = text;
		this.index = index;
	}

	private ItemLocation(String text) {
		this(text, NO_INDEX);
	}

	private ItemLocation(int index) {
		this(null, index);
	}

	private final String text;
	private final int index;

	public String toPathFragment() {
		if (text == null) {
			throw new IllegalStateException("Null text is not expected");
		}
		return index == NO_INDEX ?
				SWTUIPlayer.buildPathFragment(text)
				: SWTUIPlayer.buildPathFragment(text, index);
	}

	private static final Pattern indexedFragment = Pattern.compile("^(.*)%(\\d+)%$");

	public static ItemLocation fromPathFragment(String path) {
		Matcher m = indexedFragment.matcher(path);
		return m.matches() ? new ItemLocation(m.group(1), Integer.parseInt(m.group(2)))
				: new ItemLocation(path);
	}

	public static ItemLocation fromItem(ExpandItem item) {
		ExpandItem[] items = item.getParent().getItems();
		int matchCount = 0;
		for (ExpandItem sibling : items) {
			if (sibling == item) {
				break;
			}
			if (sibling.getText().equals(item.getText())) {
				matchCount++;
			}
		}
		return new ItemLocation(item.getText(), matchCount);
	}

	public static ItemLocation fromIndex(int index) {
		return new ItemLocation(null, index);
	}

	public static ItemLocation fromSelectionFilter(PlayerSelectionFilter f) {
		return f.path == null || f.path.length == 0 ?
				fromIndex(f.index == null ? 0 : f.index)
				: fromPathFragment(f.path[0]);
	}

	public ExpandItem findMatch(ExpandBar bar) {
		if (text == null) {
			return bar.getItemCount() > index ? bar.getItem(index) : null;
		}
		for (ExpandItem item : bar.getItems()) {
			if (matchesExactly(item)) {
				return item;
			}
		}
		for (ExpandItem item : bar.getItems()) {
			if (regexMatches(item)) {
				return item;
			}
		}
		return null;
	}

	public boolean matchesExactly(ExpandItem item) {
		return equals(fromItem(item));
	}

	public boolean regexMatches(ExpandItem item) {
		if (text == null) {
			return false;
		}
		Pattern pattern = null;
		try {
			pattern = Pattern.compile(text);
		} catch (PatternSyntaxException e) {
			return false;
		}

		int matchIndex = -1;
		for (ExpandItem sibling : item.getParent().getItems()) {
			if (!pattern.matcher(sibling.getText()).matches()) {
				continue;
			}
			matchIndex++;
			if (sibling == item) {
				// found
				return index == matchIndex;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLocation other = (ItemLocation) obj;
		if (index != other.index)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
