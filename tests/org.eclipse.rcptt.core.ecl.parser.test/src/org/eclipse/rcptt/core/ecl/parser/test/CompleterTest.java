/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.parser.test;

import static org.eclipse.rcptt.core.ecl.parser.test.ResolverTest.cont;
import static org.eclipse.rcptt.core.ecl.parser.test.ResolverTest.multiCommandCont;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.eclipse.rcptt.core.ecl.model.BaseContainer;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.model.Completer;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal.ArgNameProposal;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal.ProcNameProposal;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal.VarValueProposal;

public class CompleterTest {
	@Test
	public void testEmptyScript() {
		List<Proposal> proposals = proposals("", 0);
		assertEquals(3, proposals.size());

		assertProposal(proposals.get(0), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(1), VarValueProposal.class, "$param2");
		assertProposal(proposals.get(2), ProcNameProposal.class, "proc");
	}

	@Test
	public void testSingleCommand() {
		List<Proposal> proposals = proposals("p", 1);
		assertEquals(1, proposals.size());
		assertProposal(proposals.get(0), ProcNameProposal.class, "proc");
	}

	@Test
	public void testSingleCommandNoMatch() {
		List<Proposal> proposals = proposals("d", 1);
		assertEquals(0, proposals.size());
	}

	@Test
	public void testSingleDollar() {
		List<Proposal> proposals = proposals("$", 1);
		assertEquals(2, proposals.size());
		assertProposal(proposals.get(0), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(1), VarValueProposal.class, "$param2");
	}

	@Test
	public void testArgProposal() {
		List<Proposal> proposals = proposals("proc ", 5);
		assertEquals(5, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-arg1");
		assertProposal(proposals.get(1), ArgNameProposal.class, "-arg2");
		assertProposal(proposals.get(2), ArgNameProposal.class, "-lastArg");
		assertProposal(proposals.get(3), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(4), VarValueProposal.class, "$param2");
	}

	@Test
	public void testArgProposalAfterDash() {
		List<Proposal> proposals = proposals("proc -", 6);
		assertEquals(3, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-arg1");
		assertProposal(proposals.get(1), ArgNameProposal.class, "-arg2");
		assertProposal(proposals.get(2), ArgNameProposal.class, "-lastArg");
	}
	
	@Test
	public void testMultiCommandOneStringArgProposal() {
		final String scriptText = "proc -arg1 \"test1\" | proc2 \"test\" ";
		List<Proposal> proposals = proposals(scriptText, scriptText.length(), multiCommandCont);
		
		assertEquals(3, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-proc2Arg");
		assertProposal(proposals.get(1), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(2), VarValueProposal.class, "$param2");
	}
	
	@Test
	public void testMultiCommandMultiStringArgProposal() {
		final String scriptText = "proc -arg1 \"test1\" \nproc2 \"test\" ";
		List<Proposal> proposals = proposals(scriptText, scriptText.length(), multiCommandCont);
		
		assertEquals(3, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-proc2Arg");
		assertProposal(proposals.get(1), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(2), VarValueProposal.class, "$param2");
	}

	@Test
	public void testArgNonLastLineProposal() {
		List<Proposal> proposals = proposals("proc \nproc ", 5);
		assertEquals(5, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-arg1");
		assertProposal(proposals.get(1), ArgNameProposal.class, "-arg2");
		assertProposal(proposals.get(2), ArgNameProposal.class, "-lastArg");
		assertProposal(proposals.get(3), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(4), VarValueProposal.class, "$param2");
	}

	@Test
	public void testPrefixedArgProposalVar() {
		List<Proposal> proposals = proposals("proc $p", 6);
		assertEquals(2, proposals.size());
		assertProposal(proposals.get(0), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(1), VarValueProposal.class, "$param2");
	}

	@Test
	public void testDollarArgProposal() {
		List<Proposal> proposals = proposals("proc $", 5);
		assertEquals(2, proposals.size());
		assertProposal(proposals.get(0), VarValueProposal.class, "$param1");
		assertProposal(proposals.get(1), VarValueProposal.class, "$param2");
	}

	@Test
	public void testPrefixedArgProposalArgName() {
		List<Proposal> proposals = proposals("proc -a", 6);
		assertEquals(2, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-arg1");
		assertProposal(proposals.get(1), ArgNameProposal.class, "-arg2");
	}

	@Test
	public void testPrefixedFilteredArgProposalArgName() {
		List<Proposal> proposals = proposals("proc -l", 7);
		assertEquals(1, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-lastArg");
	}

	@Test
	public void testPrefixedFilteredArgProposalArgNameNonLastLine() {
		List<Proposal> proposals = proposals("proc -l\nfoo", 7);
		assertEquals(1, proposals.size());
		assertProposal(proposals.get(0), ArgNameProposal.class, "-lastArg");
	}

	@Test
	public void testCommentsProposals() {
		List<Proposal> proposals = proposals("/* */", 3);
		assertEquals(0, proposals.size());
	}

	private static void assertProposal(Proposal p, Class<? extends Proposal> type, String text) {
		assertTrue(type.isAssignableFrom(p.getClass()));
		assertEquals(text, p.fullText());
	}

	private static List<Proposal> proposals(String text, int offset) {
		return proposals(text, offset, cont);
	}
	
	private static List<Proposal> proposals(String text, int offset, BaseContainer container) {
		return Completer.proposals(Parser.parse(text), offset, container);
	}
}
