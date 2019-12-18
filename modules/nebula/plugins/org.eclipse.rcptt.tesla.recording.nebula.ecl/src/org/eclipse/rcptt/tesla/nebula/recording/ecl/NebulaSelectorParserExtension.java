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
package org.eclipse.rcptt.tesla.nebula.recording.ecl;

import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.COLUMN;
import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.LEFT;
import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.TOP;

import java.util.List;

import org.eclipse.rcptt.ecl.runtime.CoreUtils;

import org.eclipse.rcptt.tesla.ecl.model.Selector;
import org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea;
import org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell;
import org.eclipse.rcptt.tesla.ecl.nebula.GetNebulaGrid;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaFactory;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.tesla.recording.core.ecl.ISelectorParserExtension;

public class NebulaSelectorParserExtension implements ISelectorParserExtension {

	@Override
	public Selector selector(String customKindId, String text, List<String> path,
			List<Integer> indexes) {
		if (NebulaElementKinds.GRID.equals(customKindId))
			return makeNebulaGrid();
		if (NebulaElementKinds.ROW_HEADER.equals(customKindId))
			return makeRowHeader();
		if (NebulaElementKinds.ITEM_CELL.equals(customKindId))
			return makeItemCell(text);
		if (NebulaElementKinds.EMPTY_AREA.equals(customKindId))
			return makeEmptyArea(path);
		return null;
	}

	private static GetNebulaGrid makeNebulaGrid() {
		return NebulaFactory.eINSTANCE.createGetNebulaGrid();
	}

	static Selector makeRowHeader() {
		return NebulaFactory.eINSTANCE.createGetRowHeader();
	}

	static Selector makeItemCell(String columnTitle) {
		GetItemCell cell = NebulaFactory.eINSTANCE.createGetItemCell();
		cell.setColumn(columnTitle);
		return cell;
	}

	private Selector makeEmptyArea(List<String> path) {
		GetEmptyArea area = NebulaFactory.eINSTANCE.createGetEmptyArea();

		if (path.size() == 2 && path.get(0).equals(COLUMN))
			area.setColumn(path.get(1));
		else {
			for (String p : path) {
				if (p.equals(TOP))
					area.setTop(true);
				if (p.equals(LEFT))
					area.setLeft(true);
			}
		}
		return area;
	}


	//

	@Override
	public boolean isParamNameForced(String commandName, String paramName) {
		String getItemCell = CoreUtils.getScriptletNameByClass(NebulaPackage.eINSTANCE.getGetItemCell());
		return commandName.equals(getItemCell) && paramName.equals("column");
	}

}
