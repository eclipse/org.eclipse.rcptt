// $ANTLR 3.5.2 Tags.g 2014-12-10 15:23:08

package org.eclipse.rcptt.core.search.tags.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class TagsParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "LPAREN", "NAME", "OR", 
		"RPAREN", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int LPAREN=5;
	public static final int NAME=6;
	public static final int OR=7;
	public static final int RPAREN=8;
	public static final int WS=9;

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


	// Override
	public void reportError(RecognitionException e) {}


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// Tags.g:31:1: expression : orexpression ;
	public final TagsParser.expression_return expression() throws RecognitionException {
		TagsParser.expression_return retval = new TagsParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope orexpression1 =null;


		try {
			// Tags.g:31:12: ( orexpression )
			// Tags.g:31:14: orexpression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_orexpression_in_expression184);
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
	// Tags.g:32:1: orexpression : andexpression ( OR ^ andexpression )* ;
	public final TagsParser.orexpression_return orexpression() throws RecognitionException {
		TagsParser.orexpression_return retval = new TagsParser.orexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR3=null;
		ParserRuleReturnScope andexpression2 =null;
		ParserRuleReturnScope andexpression4 =null;

		Object OR3_tree=null;

		try {
			// Tags.g:32:14: ( andexpression ( OR ^ andexpression )* )
			// Tags.g:32:16: andexpression ( OR ^ andexpression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andexpression_in_orexpression191);
			andexpression2=andexpression();
			state._fsp--;

			adaptor.addChild(root_0, andexpression2.getTree());

			// Tags.g:32:30: ( OR ^ andexpression )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==OR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Tags.g:32:31: OR ^ andexpression
					{
					OR3=(Token)match(input,OR,FOLLOW_OR_in_orexpression194); 
					OR3_tree = (Object)adaptor.create(OR3);
					root_0 = (Object)adaptor.becomeRoot(OR3_tree, root_0);

					pushFollow(FOLLOW_andexpression_in_orexpression197);
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
	// Tags.g:33:1: andexpression : atom ( AND ^ atom )* ;
	public final TagsParser.andexpression_return andexpression() throws RecognitionException {
		TagsParser.andexpression_return retval = new TagsParser.andexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND6=null;
		ParserRuleReturnScope atom5 =null;
		ParserRuleReturnScope atom7 =null;

		Object AND6_tree=null;

		try {
			// Tags.g:33:15: ( atom ( AND ^ atom )* )
			// Tags.g:33:17: atom ( AND ^ atom )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_atom_in_andexpression206);
			atom5=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom5.getTree());

			// Tags.g:33:22: ( AND ^ atom )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==AND) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Tags.g:33:23: AND ^ atom
					{
					AND6=(Token)match(input,AND,FOLLOW_AND_in_andexpression209); 
					AND6_tree = (Object)adaptor.create(AND6);
					root_0 = (Object)adaptor.becomeRoot(AND6_tree, root_0);

					pushFollow(FOLLOW_atom_in_andexpression212);
					atom7=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom7.getTree());

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


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// Tags.g:34:1: atom : ( NAME | LPAREN ! orexpression RPAREN !);
	public final TagsParser.atom_return atom() throws RecognitionException {
		TagsParser.atom_return retval = new TagsParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME8=null;
		Token LPAREN9=null;
		Token RPAREN11=null;
		ParserRuleReturnScope orexpression10 =null;

		Object NAME8_tree=null;
		Object LPAREN9_tree=null;
		Object RPAREN11_tree=null;

		try {
			// Tags.g:34:6: ( NAME | LPAREN ! orexpression RPAREN !)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==NAME) ) {
				alt3=1;
			}
			else if ( (LA3_0==LPAREN) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Tags.g:34:8: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME8=(Token)match(input,NAME,FOLLOW_NAME_in_atom221); 
					NAME8_tree = (Object)adaptor.create(NAME8);
					adaptor.addChild(root_0, NAME8_tree);

					}
					break;
				case 2 :
					// Tags.g:34:15: LPAREN ! orexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN9=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom225); 
					pushFollow(FOLLOW_orexpression_in_atom228);
					orexpression10=orexpression();
					state._fsp--;

					adaptor.addChild(root_0, orexpression10.getTree());

					RPAREN11=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom230); 
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



	public static final BitSet FOLLOW_orexpression_in_expression184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_andexpression_in_orexpression191 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_OR_in_orexpression194 = new BitSet(new long[]{0x0000000000000060L});
	public static final BitSet FOLLOW_andexpression_in_orexpression197 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_atom_in_andexpression206 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_andexpression209 = new BitSet(new long[]{0x0000000000000060L});
	public static final BitSet FOLLOW_atom_in_andexpression212 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_NAME_in_atom221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_atom225 = new BitSet(new long[]{0x0000000000000060L});
	public static final BitSet FOLLOW_orexpression_in_atom228 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_RPAREN_in_atom230 = new BitSet(new long[]{0x0000000000000002L});
}
