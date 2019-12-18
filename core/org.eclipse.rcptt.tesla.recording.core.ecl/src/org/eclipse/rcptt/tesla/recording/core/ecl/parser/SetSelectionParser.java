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
package org.eclipse.rcptt.tesla.recording.core.ecl.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Pipeline;

import org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.ecl.TeslaScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.GetCell;

public class SetSelectionParser {

	public Command parse(SetSelection c, TeslaParser p) {

		if (c.getPath() != null && c.getPath().size() > 0) {
			List<Command> paths = new ArrayList<Command>();

			Command first = makeItemFrom(c);
			if (first != null)
				paths.add(first);

			EList<MultiSelectionItem> additionalItems = c.getAdditionalItems();
			for (MultiSelectionItem multiSelectionItem : additionalItems)
				paths.add(makeItemFrom(multiSelectionItem));

			Command tree = p.selectorOf(c.getElement());
			Command select = TeslaParserUtil.makeSelect(paths);

			if (additionalItems.isEmpty() && shouldJoinNextCommand()) {
				Command result = tryJoinNextCommand(p, tree, select, first);
				if (result != null)
					return result;
			}

			return TeslaScriptletFactory.makePipe(tree, select);
		} else {
			// combos
			Command combo = p.selectorOf(c.getElement());
			return TeslaScriptletFactory.makePipe(combo,
					TeslaParserUtil.makeSelect(c.getPattern()));
		}
	}

	private Command tryJoinNextCommand(TeslaParser p, Command tree, Command select, Command first) {
		int mark = p.pos;
		Command cut = null;
		while (true) {
			if (p.pos >= p.teslaCommands.size()) // end of commands
				break;

			Command nextCmd = p.teslaCommand(); // modifies p.pos,
												// so we have to restore it in case of failed cutting
			if (nextCmd != null) {
				cut = TeslaParserUtil.cut(nextCmd, tree);
				if (TeslaParserUtil.cut(cut, first) != null)
					cut = null;
				break;
			}
		}

		if (cut != null) {
			if (shouldMakeSeq(cut))
				return TeslaScriptletFactory.makeWith(tree,
						TeslaScriptletFactory.seq(select, cut));
			else
				return TeslaScriptletFactory.makePipe(tree, select, cut);

		} else {
			p.pos = mark; // restoring initial value, so TeslaParser could handle the next command
			return null;
		}
	}

	//

	protected Command makeItemFrom(SetSelection c) {
		return TeslaParserUtil.makeItem(c.getPath());
	}

	protected Command makeItemFrom(MultiSelectionItem msi) {
		return TeslaParserUtil.makeItem(msi.getPath());
	}

	protected boolean shouldJoinNextCommand() {
		return true;
	}

	protected boolean shouldMakeSeq(Command cut) {
		if (cut instanceof Pipeline) {
			List<Command> cmds = ((Pipeline) cut).getCommands();
			return (cmds.size() > 0) && (cmds.get(0) instanceof GetCell);
		}
		return false;
	}

}
