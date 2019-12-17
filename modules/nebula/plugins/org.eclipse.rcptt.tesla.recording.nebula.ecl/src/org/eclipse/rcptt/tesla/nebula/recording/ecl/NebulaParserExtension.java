/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.nebula.recording.ecl;

import static org.eclipse.rcptt.tesla.nebula.recording.ecl.NebulaSelectorParserExtension.makeItemCell;
import static org.eclipse.rcptt.tesla.nebula.recording.ecl.NebulaSelectorParserExtension.makeRowHeader;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.util.EclCommandNameConvention;

import org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.ecl.TeslaScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.GetItem;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionEx;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange;
import org.eclipse.rcptt.tesla.recording.core.ecl.TeslaCommand;
import org.eclipse.rcptt.tesla.recording.core.ecl.parser.SetSelectionParser;
import org.eclipse.rcptt.tesla.recording.core.ecl.parser.TeslaParser;
import org.eclipse.rcptt.tesla.recording.core.ecl.parser.TeslaParserUtil;

public class NebulaParserExtension extends TeslaScriptletFactory {

	@TeslaCommand(packageUri = NebulaPackage.eNS_URI, classifier = "SetSelectionEx")
	public static Command setSelectionEx(TeslaParser p, SetSelectionEx c) {
		return new SetSelectionParser() {

			@Override
			protected Command makeItemFrom(SetSelection c) {
				// ignoring the 'main' item
				// and using only additionalItems
				return null;
			}

			@Override
			protected Command makeItemFrom(MultiSelectionItem msi) {
				return NebulaParserExtension.makeItemFrom((MultiSelectionItemEx) msi);
			}

			@Override
			protected boolean shouldJoinNextCommand() {
				return false;
			}

		}.parse(c, p);
	}

	@TeslaCommand(packageUri = NebulaPackage.eNS_URI, classifier = "SetSelectionRange")
	public static Command setSelectionRange(TeslaParser p, SetSelectionRange c) {
		Command from, to;
		
		if (c.getFrom() != null) {
			// parts
			from = makeItemFrom(c.getFrom());
			to = makeItemFrom(c.getTo());
		} else {
			// paths
			from = TeslaParserUtil.makeItem(c.getPath());
			to = TeslaParserUtil.makeItem(c.getToPath());
		}
		
		Command grid = p.selectorOf(c.getElement());
		return makePipe(grid, makeSelectGridRange(from, to));
	}

	//

	private static Command makeSelectGridRange(Command from, Command to) {
		Exec exec = CoreFactory.eINSTANCE.createExec();
		exec.setName(EclCommandNameConvention
				.toCommandName(org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage.Literals.SELECT_GRID_RANGE.getName()));

		exec.getParameters().add(
				createParam(from, org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage.Literals.SELECT_GRID_RANGE__FROM));
		exec.getParameters().add(
				createParam(to, org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage.Literals.SELECT_GRID_RANGE__TO));
		return exec;
	}

	private static Parameter createParam(Command c, EAttribute attr) {
		if (c instanceof GetItem) {
			LiteralParameter literal = CoreFactory.eINSTANCE.createLiteralParameter();
			literal.setLiteral(((GetItem) c).getPath());
			literal.setName(attr.getName());
			return literal;
		} else {
			ExecutableParameter executable = CoreFactory.eINSTANCE.createExecutableParameter();
			executable.setCommand(c);
			executable.setName(attr.getName());
			return executable;
		}
	}


	private static Command makeItemFrom(MultiSelectionItemEx msie) {
		// Command item = super.makeItemFrom(msi);
		Command item = TeslaParserUtil.makeItem(msie.getPath());

		if (msie.isRowHeader())
			return makePipe(item, makeRowHeader());
		if (msie.getCellColumn() != null)
			return makePipe(item, makeItemCell(msie.getCellColumn()));

		return item;
	}

}
