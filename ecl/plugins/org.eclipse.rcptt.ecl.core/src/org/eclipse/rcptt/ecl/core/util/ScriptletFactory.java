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
package org.eclipse.rcptt.ecl.core.util;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.rcptt.ecl.core.Binding;
import org.eclipse.rcptt.ecl.core.Block;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parallel;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.With;

public class ScriptletFactory {

	public static <T extends Command> T bind(T command,
			EStructuralFeature feature, Command binded) {
		Binding binding = CoreFactory.eINSTANCE.createBinding();
		binding.setFeature(feature);
		binding.setCommand(binded);
		command.getBindings().add(binding);
		return command;
	}

	public static Sequence seq(Command... commands) {
		return makeSeq(Arrays.asList(commands));
	}

	public static Sequence makeSeq(Command... commands) {
		return makeSeq(Arrays.asList(commands));
	}

	public static Sequence makeSeq(List<Command> commands) {
		return block(CoreFactory.eINSTANCE.createSequence(), commands);
	}

	public static Pipeline makePipe(Command... commands) {
		return makePipe(Arrays.asList(commands));
	}

	public static Pipeline makePipe(List<Command> commands) {
		return block(CoreFactory.eINSTANCE.createPipeline(), commands);
	}

	public static Parallel makeParallel(Command... commands) {
		return makeParallel(Arrays.asList(commands));
	}

	public static Parallel makeParallel(List<Command> commands) {
		return block(CoreFactory.eINSTANCE.createParallel(), commands);
	}

	private static <T extends Block> T block(T block, List<Command> commands) {
		for (Command command : commands) {
			if (command != null) {
				if (block.getClass().isInstance(command))
					block.getCommands().addAll(((Block) command).getCommands());
				else
					block.getCommands().add(command);
			}
		}
		return block;
	}

	public static With makeWith(Command withObject, Command doObject) {
		With with = CoreFactory.eINSTANCE.createWith();
		with.setDo(doObject);
		return bind(with, CorePackage.eINSTANCE.getWith_Object(), withObject);
	}

	public static Exec makeExec(String name, Parameter... parameters) {
		return makeExec(null, name, parameters);
	}

	public static Exec makeExec(String ns, String name, Parameter... parameters) {
		Exec e = CoreFactory.eINSTANCE.createExec();
		e.setNamespace(ns);
		e.setName(name);
		for (Parameter p : parameters) {
			if (p != null)
				e.getParameters().add(p);
		}
		return e;
	}

	public static LiteralParameter makeLiteralParameter(String name,
			String value) {
		LiteralParameter p = CoreFactory.eINSTANCE.createLiteralParameter();
		p.setName(name);
		p.setLiteral(value);
		return p;
	}

	public static ExecutableParameter makeExecutableParameter(String name,
			Command value) {
		ExecutableParameter p = CoreFactory.eINSTANCE
				.createExecutableParameter();
		p.setName(name);
		p.setCommand(value);
		return p;
	}
}
