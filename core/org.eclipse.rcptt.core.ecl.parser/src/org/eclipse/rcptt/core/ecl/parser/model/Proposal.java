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
package org.eclipse.rcptt.core.ecl.parser.model;

import org.eclipse.rcptt.core.ecl.model.ArgDecl;
import org.eclipse.rcptt.core.ecl.model.Declaration;
import org.eclipse.rcptt.core.ecl.model.ProcDecl;
import org.eclipse.rcptt.core.ecl.model.VarDecl;

public abstract class Proposal {
	public Proposal(Declaration decl) {
		this.decl = decl;
	}

	public final Declaration decl;

	public final boolean startsWith(String prefix) {
		return fullText().toLowerCase().startsWith(prefix);
	}

	public int prefixLength = 0;

	public String insertionString() {
		return fullText().substring(prefixLength);
	}

	public abstract String fullText();
	
	@Override
	public String toString() {
		return fullText();
	}

	public static class ArgNameProposal extends Proposal {
		public ArgNameProposal(ArgDecl decl) {
			super(decl);
		}

		@Override
		public String fullText() {
			return "-" + decl.name;
		}
	}

	public static class VarValueProposal extends Proposal {
		public VarValueProposal(VarDecl decl) {
			super(decl);
		}

		@Override
		public String fullText() {
			return "$" + decl.name;
		}
	}

	public static class ProcNameProposal extends Proposal {
		public ProcNameProposal(ProcDecl decl) {
			super(decl);
		}

		@Override
		public String fullText() {
			return decl.name;
		}

	}

}
