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
package org.eclipse.rcptt.tesla.nebula.viewers;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils.safeMatches;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.nebula.widgets.grid.GridItem;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;

/**
 * Represents a part of the path to abstract item matching.
 * <p>
 * This class can also be useful for other tables & trees, so it should be generalized on demand.
 */
public class PathSelectorPart {

	private static final Pattern indexPattern = Pattern.compile("(.*?)%(.*)%");

	private final String regex;
	private final int index;

	public PathSelectorPart(String part) {
		Matcher m = indexPattern.matcher(part);
		if (!m.matches()) {
			regex = part;
			index = 0;
		} else {
			regex = m.group(1);
			index = Integer.parseInt(m.group(2));
		}
	}

	public GridItem findIn(GridItem[] items) {
		if (items == null)
			return null;

		List<GridItem> matchingItems = getMatchingItemsFrom(items);
		if (matchingItems.size() <= index)
			return null;

		return matchingItems.get(index);
	}

	private List<GridItem> getMatchingItemsFrom(GridItem[] items) {
		List<GridItem> matching = new ArrayList<GridItem>();
		for (GridItem gridItem : items)
			if (matches(gridItem))
				matching.add(gridItem);
		return matching;
	}

	private boolean matches(GridItem gridItem) {
		String text = gridItem.getText();
		return matches(text) || matches(SWTUIPlayer.toSelectionItem(text));
	}

	private boolean matches(String text) {
		return (text != null) && (text.equals(regex) || safeMatches(text, regex));
	}

}
