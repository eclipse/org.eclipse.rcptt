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
package org.eclipse.rcptt.tesla.recording.core.internal.ecl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.rcptt.ecl.core.Binding;
import org.eclipse.rcptt.ecl.core.Block;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.With;

import org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart;

public class DiagramUtils {

	public static Collection<? extends Command> updateSelectors(
			List<Command> commands) {
		List<Command> newCommands = new ArrayList<Command>();
		for (int i = 0; i < commands.size();) {
			Command command = commands.get(i);
			updateCommand(command);
			if (command instanceof GetEditPart) {
				// Eat getEditPart commands after this one
				GetEditPart getEditPartCmd = (GetEditPart) command;
				for (int j = i + 1; j < commands.size(); j++) {
					Command nCommand = commands.get(j);
					if (nCommand instanceof GetEditPart) {
						GetEditPart nCommandCmd = (GetEditPart) nCommand;
						boolean next = false;
						if (getEditPartCmd.getPath() != null
								&& nCommandCmd.getPath() != null) {
							getEditPartCmd.setPath(getEditPartCmd.getPath()
									+ "/" + ((GetEditPart) nCommand).getPath());
							next = true;
						}
						// if (getEditPartCmd.getName() != null
						// && nCommandCmd.getName() != null) {
						// getEditPartCmd.setName(getEditPartCmd.getName()
						// + "/" + ((GetEditPart) nCommand).getName());
						// next = true;
						// }
						// if (getEditPartCmd.getFeature() != null
						// && nCommandCmd.getFeature() != null) {
						// getEditPartCmd.setFeature(getEditPartCmd
						// .getFeature()
						// + "/"
						// + ((GetEditPart) nCommand).getFeature());
						// next = true;
						// }
						if (next) {
							i++;
						} else {
							break;
						}
					} else {
						// Not same selector
						break;
					}
				}
			}
			newCommands.add(command);
			i++;
		}
		return newCommands;
	}

	private static void updateCommand(Command command) {
		if (command instanceof Block) {
			Block pipeline = (Block) command;

			Collection<? extends Command> content = updateSelectors(pipeline
					.getCommands());
			pipeline.getCommands().clear();
			pipeline.getCommands().addAll(content);
		}
		if (command instanceof With) {
			With with = (With) command;
			for (Binding binding : with.getBindings()) {
				Command cmd = binding.getCommand();
				if (cmd instanceof Pipeline) {
					Collection<? extends Command> newContent = updateSelectors(((Pipeline) cmd)
							.getCommands());
					((Pipeline) cmd).getCommands().clear();
					((Pipeline) cmd).getCommands().addAll(newContent);
				}
			}
			updateCommand(with.getDo());
		}
	}
}
