/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
// $ANTLR 3.5.2 Tags.g 2014-12-15 16:08:03

package org.eclipse.rcptt.core.search.tags.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class TagsParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "LPAREN", "NAME", "NOT", 
		"OR", "RPAREN", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int LPAREN=5;
	public static final int NAME=6;
	public static final int NOT=7;
	public static final int OR=8;
	public static final int RPAREN=9;
	public static final int WS=10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public TagsParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TagsParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return TagsParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Tags.g"; }


	private List<RecognitionException> errors = new ArrayList<RecognitionException>();

	public List<RecognitionException> getAllErrors() {
		return new ArrayList<RecognitionException>(errors);
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public void reportError(RecognitionException e) {
		errors.add(e);
	}


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// Tags.g:60:1: expression : orexpression ;
	public final TagsParser.expression_return expression() throws RecognitionException {
		TagsParser.expression_return retval = new TagsParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope orexpression1 =null;


		try {
			// Tags.g:60:12: ( orexpression )
			// Tags.g:60:14: orexpression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_orexpression_in_expression212);
			orexpression1=orexpression();
			state._fsp--;

			adaptor.addChild(root_0, orexpression1.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class orexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orexpression"
	// Tags.g:61:1: orexpression : andexpression ( OR ^ andexpression )* ;
	public final TagsParser.orexpression_return orexpression() throws RecognitionException {
		TagsParser.orexpression_return retval = new TagsParser.orexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR3=null;
		ParserRuleReturnScope andexpression2 =null;
		ParserRuleReturnScope andexpression4 =null;

		Object OR3_tree=null;

		try {
			// Tags.g:61:14: ( andexpression ( OR ^ andexpression )* )
			// Tags.g:61:16: andexpression ( OR ^ andexpression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andexpression_in_orexpression219);
			andexpression2=andexpression();
			state._fsp--;

			adaptor.addChild(root_0, andexpression2.getTree());

			// Tags.g:61:30: ( OR ^ andexpression )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==OR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Tags.g:61:31: OR ^ andexpression
					{
					OR3=(Token)match(input,OR,FOLLOW_OR_in_orexpression222); 
					OR3_tree = (Object)adaptor.create(OR3);
					root_0 = (Object)adaptor.becomeRoot(OR3_tree, root_0);

					pushFollow(FOLLOW_andexpression_in_orexpression225);
					andexpression4=andexpression();
					state._fsp--;

					adaptor.addChild(root_0, andexpression4.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "orexpression"


	public static class andexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andexpression"
	// Tags.g:62:1: andexpression : notexpression ( AND ^ notexpression )* ;
	public final TagsParser.andexpression_return andexpression() throws RecognitionException {
		TagsParser.andexpression_return retval = new TagsParser.andexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND6=null;
		ParserRuleReturnScope notexpression5 =null;
		ParserRuleReturnScope notexpression7 =null;

		Object AND6_tree=null;

		try {
			// Tags.g:62:15: ( notexpression ( AND ^ notexpression )* )
			// Tags.g:62:17: notexpression ( AND ^ notexpression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_notexpression_in_andexpression234);
			notexpression5=notexpression();
			state._fsp--;

			adaptor.addChild(root_0, notexpression5.getTree());

			// Tags.g:62:31: ( AND ^ notexpression )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==AND) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Tags.g:62:32: AND ^ notexpression
					{
					AND6=(Token)match(input,AND,FOLLOW_AND_in_andexpression237); 
					AND6_tree = (Object)adaptor.create(AND6);
					root_0 = (Object)adaptor.becomeRoot(AND6_tree, root_0);

					pushFollow(FOLLOW_notexpression_in_andexpression240);
					notexpression7=notexpression();
					state._fsp--;

					adaptor.addChild(root_0, notexpression7.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "andexpression"


	public static class notexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "notexpression"
	// Tags.g:63:1: notexpression : ( NOT ^ atom | atom );
	public final TagsParser.notexpression_return notexpression() throws RecognitionException {
		TagsParser.notexpression_return retval = new TagsParser.notexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT8=null;
		ParserRuleReturnScope atom9 =null;
		ParserRuleReturnScope atom10 =null;

		Object NOT8_tree=null;

		try {
			// Tags.g:63:15: ( NOT ^ atom | atom )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==NOT) ) {
				alt3=1;
			}
			else if ( ((LA3_0 >= LPAREN && LA3_0 <= NAME)) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Tags.g:63:17: NOT ^ atom
					{
					root_0 = (Object)adaptor.nil();


					NOT8=(Token)match(input,NOT,FOLLOW_NOT_in_notexpression249); 
					NOT8_tree = (Object)adaptor.create(NOT8);
					root_0 = (Object)adaptor.becomeRoot(NOT8_tree, root_0);

					pushFollow(FOLLOW_atom_in_notexpression252);
					atom9=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom9.getTree());

					}
					break;
				case 2 :
					// Tags.g:63:29: atom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom_in_notexpression256);
					atom10=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom10.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "notexpression"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// Tags.g:64:1: atom : ( NAME | LPAREN ! orexpression RPAREN !);
	public final TagsParser.atom_return atom() throws RecognitionException {
		TagsParser.atom_return retval = new TagsParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME11=null;
		Token LPAREN12=null;
		Token RPAREN14=null;
		ParserRuleReturnScope orexpression13 =null;

		Object NAME11_tree=null;
		Object LPAREN12_tree=null;
		Object RPAREN14_tree=null;

		try {
			// Tags.g:64:6: ( NAME | LPAREN ! orexpression RPAREN !)
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NAME) ) {
				alt4=1;
			}
			else if ( (LA4_0==LPAREN) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// Tags.g:64:8: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME11=(Token)match(input,NAME,FOLLOW_NAME_in_atom263); 
					NAME11_tree = (Object)adaptor.create(NAME11);
					adaptor.addChild(root_0, NAME11_tree);

					}
					break;
				case 2 :
					// Tags.g:64:15: LPAREN ! orexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN12=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom267); 
					pushFollow(FOLLOW_orexpression_in_atom270);
					orexpression13=orexpression();
					state._fsp--;

					adaptor.addChild(root_0, orexpression13.getTree());

					RPAREN14=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom272); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_orexpression_in_expression212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_andexpression_in_orexpression219 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_OR_in_orexpression222 = new BitSet(new long[]{0x00000000000000E0L});
	public static final BitSet FOLLOW_andexpression_in_orexpression225 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_notexpression_in_andexpression234 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_andexpression237 = new BitSet(new long[]{0x00000000000000E0L});
	public static final BitSet FOLLOW_notexpression_in_andexpression240 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_NOT_in_notexpression249 = new BitSet(new long[]{0x0000000000000060L});
	public static final BitSet FOLLOW_atom_in_notexpression252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_notexpression256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_atom263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_atom267 = new BitSet(new long[]{0x00000000000000E0L});
	public static final BitSet FOLLOW_orexpression_in_atom270 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_RPAREN_in_atom272 = new BitSet(new long[]{0x0000000000000002L});
}
