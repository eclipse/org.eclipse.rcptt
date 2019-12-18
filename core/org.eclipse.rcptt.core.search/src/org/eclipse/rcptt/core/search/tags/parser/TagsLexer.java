/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
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

@SuppressWarnings("all")
public class TagsLexer extends Lexer {
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int LPAREN=5;
	public static final int NAME=6;
	public static final int NOT=7;
	public static final int OR=8;
	public static final int RPAREN=9;
	public static final int WS=10;

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


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public TagsLexer() {} 
	public TagsLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public TagsLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Tags.g"; }

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:51:8: ( '(' )
			// Tags.g:51:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:52:8: ( ')' )
			// Tags.g:52:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:53:5: ( '&' | 'AND' | 'and' )
			int alt1=3;
			switch ( input.LA(1) ) {
			case '&':
				{
				alt1=1;
				}
				break;
			case 'A':
				{
				alt1=2;
				}
				break;
			case 'a':
				{
				alt1=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// Tags.g:53:7: '&'
					{
					match('&'); 
					}
					break;
				case 2 :
					// Tags.g:53:13: 'AND'
					{
					match("AND"); 

					}
					break;
				case 3 :
					// Tags.g:53:21: 'and'
					{
					match("and"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:54:4: ( '|' | 'OR' | 'or' )
			int alt2=3;
			switch ( input.LA(1) ) {
			case '|':
				{
				alt2=1;
				}
				break;
			case 'O':
				{
				alt2=2;
				}
				break;
			case 'o':
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Tags.g:54:6: '|'
					{
					match('|'); 
					}
					break;
				case 2 :
					// Tags.g:54:12: 'OR'
					{
					match("OR"); 

					}
					break;
				case 3 :
					// Tags.g:54:19: 'or'
					{
					match("or"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:55:5: ( '!' | 'NOT' | 'not' )
			int alt3=3;
			switch ( input.LA(1) ) {
			case '!':
				{
				alt3=1;
				}
				break;
			case 'N':
				{
				alt3=2;
				}
				break;
			case 'n':
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// Tags.g:55:7: '!'
					{
					match('!'); 
					}
					break;
				case 2 :
					// Tags.g:55:13: 'NOT'
					{
					match("NOT"); 

					}
					break;
				case 3 :
					// Tags.g:55:21: 'not'
					{
					match("not"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:56:6: ( (~ ( ' ' | '\\t' | '\\r' | '\\n' | '(' | ')' | '\"' | '!' ) )+ | '\"' (~ ( '\"' ) )+ '\"' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '#' && LA6_0 <= '\'')||(LA6_0 >= '*' && LA6_0 <= '\uFFFF')) ) {
				alt6=1;
			}
			else if ( (LA6_0=='\"') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Tags.g:56:8: (~ ( ' ' | '\\t' | '\\r' | '\\n' | '(' | ')' | '\"' | '!' ) )+
					{
					// Tags.g:56:8: (~ ( ' ' | '\\t' | '\\r' | '\\n' | '(' | ')' | '\"' | '!' ) )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\b')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\u001F')||(LA4_0 >= '#' && LA4_0 <= '\'')||(LA4_0 >= '*' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Tags.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||(input.LA(1) >= '#' && input.LA(1) <= '\'')||(input.LA(1) >= '*' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt4 >= 1 ) break loop4;
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					}
					break;
				case 2 :
					// Tags.g:56:67: '\"' (~ ( '\"' ) )+ '\"'
					{
					match('\"'); 
					// Tags.g:56:70: (~ ( '\"' ) )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// Tags.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					match('\"'); 
					setText(getText().substring(1, getText().length()-1).trim());
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:57:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// Tags.g:57:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// Tags.g:57:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Tags.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// Tags.g:1:8: ( LPAREN | RPAREN | AND | OR | NOT | NAME | WS )
		int alt8=7;
		int LA8_0 = input.LA(1);
		if ( (LA8_0=='(') ) {
			alt8=1;
		}
		else if ( (LA8_0==')') ) {
			alt8=2;
		}
		else if ( (LA8_0=='&') ) {
			int LA8_3 = input.LA(2);
			if ( ((LA8_3 >= '\u0000' && LA8_3 <= '\b')||(LA8_3 >= '\u000B' && LA8_3 <= '\f')||(LA8_3 >= '\u000E' && LA8_3 <= '\u001F')||(LA8_3 >= '#' && LA8_3 <= '\'')||(LA8_3 >= '*' && LA8_3 <= '\uFFFF')) ) {
				alt8=6;
			}

			else {
				alt8=3;
			}

		}
		else if ( (LA8_0=='A') ) {
			int LA8_4 = input.LA(2);
			if ( (LA8_4=='N') ) {
				int LA8_15 = input.LA(3);
				if ( (LA8_15=='D') ) {
					int LA8_22 = input.LA(4);
					if ( ((LA8_22 >= '\u0000' && LA8_22 <= '\b')||(LA8_22 >= '\u000B' && LA8_22 <= '\f')||(LA8_22 >= '\u000E' && LA8_22 <= '\u001F')||(LA8_22 >= '#' && LA8_22 <= '\'')||(LA8_22 >= '*' && LA8_22 <= '\uFFFF')) ) {
						alt8=6;
					}

					else {
						alt8=3;
					}

				}

				else {
					alt8=6;
				}

			}

			else {
				alt8=6;
			}

		}
		else if ( (LA8_0=='a') ) {
			int LA8_5 = input.LA(2);
			if ( (LA8_5=='n') ) {
				int LA8_16 = input.LA(3);
				if ( (LA8_16=='d') ) {
					int LA8_23 = input.LA(4);
					if ( ((LA8_23 >= '\u0000' && LA8_23 <= '\b')||(LA8_23 >= '\u000B' && LA8_23 <= '\f')||(LA8_23 >= '\u000E' && LA8_23 <= '\u001F')||(LA8_23 >= '#' && LA8_23 <= '\'')||(LA8_23 >= '*' && LA8_23 <= '\uFFFF')) ) {
						alt8=6;
					}

					else {
						alt8=3;
					}

				}

				else {
					alt8=6;
				}

			}

			else {
				alt8=6;
			}

		}
		else if ( (LA8_0=='|') ) {
			int LA8_6 = input.LA(2);
			if ( ((LA8_6 >= '\u0000' && LA8_6 <= '\b')||(LA8_6 >= '\u000B' && LA8_6 <= '\f')||(LA8_6 >= '\u000E' && LA8_6 <= '\u001F')||(LA8_6 >= '#' && LA8_6 <= '\'')||(LA8_6 >= '*' && LA8_6 <= '\uFFFF')) ) {
				alt8=6;
			}

			else {
				alt8=4;
			}

		}
		else if ( (LA8_0=='O') ) {
			int LA8_7 = input.LA(2);
			if ( (LA8_7=='R') ) {
				int LA8_18 = input.LA(3);
				if ( ((LA8_18 >= '\u0000' && LA8_18 <= '\b')||(LA8_18 >= '\u000B' && LA8_18 <= '\f')||(LA8_18 >= '\u000E' && LA8_18 <= '\u001F')||(LA8_18 >= '#' && LA8_18 <= '\'')||(LA8_18 >= '*' && LA8_18 <= '\uFFFF')) ) {
					alt8=6;
				}

				else {
					alt8=4;
				}

			}

			else {
				alt8=6;
			}

		}
		else if ( (LA8_0=='o') ) {
			int LA8_8 = input.LA(2);
			if ( (LA8_8=='r') ) {
				int LA8_19 = input.LA(3);
				if ( ((LA8_19 >= '\u0000' && LA8_19 <= '\b')||(LA8_19 >= '\u000B' && LA8_19 <= '\f')||(LA8_19 >= '\u000E' && LA8_19 <= '\u001F')||(LA8_19 >= '#' && LA8_19 <= '\'')||(LA8_19 >= '*' && LA8_19 <= '\uFFFF')) ) {
					alt8=6;
				}

				else {
					alt8=4;
				}

			}

			else {
				alt8=6;
			}

		}
		else if ( (LA8_0=='!') ) {
			alt8=5;
		}
		else if ( (LA8_0=='N') ) {
			int LA8_10 = input.LA(2);
			if ( (LA8_10=='O') ) {
				int LA8_20 = input.LA(3);
				if ( (LA8_20=='T') ) {
					int LA8_24 = input.LA(4);
					if ( ((LA8_24 >= '\u0000' && LA8_24 <= '\b')||(LA8_24 >= '\u000B' && LA8_24 <= '\f')||(LA8_24 >= '\u000E' && LA8_24 <= '\u001F')||(LA8_24 >= '#' && LA8_24 <= '\'')||(LA8_24 >= '*' && LA8_24 <= '\uFFFF')) ) {
						alt8=6;
					}

					else {
						alt8=5;
					}

				}

				else {
					alt8=6;
				}

			}

			else {
				alt8=6;
			}

		}
		else if ( (LA8_0=='n') ) {
			int LA8_11 = input.LA(2);
			if ( (LA8_11=='o') ) {
				int LA8_21 = input.LA(3);
				if ( (LA8_21=='t') ) {
					int LA8_25 = input.LA(4);
					if ( ((LA8_25 >= '\u0000' && LA8_25 <= '\b')||(LA8_25 >= '\u000B' && LA8_25 <= '\f')||(LA8_25 >= '\u000E' && LA8_25 <= '\u001F')||(LA8_25 >= '#' && LA8_25 <= '\'')||(LA8_25 >= '*' && LA8_25 <= '\uFFFF')) ) {
						alt8=6;
					}

					else {
						alt8=5;
					}

				}

				else {
					alt8=6;
				}

			}

			else {
				alt8=6;
			}

		}
		else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\b')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\u001F')||(LA8_0 >= '\"' && LA8_0 <= '%')||LA8_0=='\''||(LA8_0 >= '*' && LA8_0 <= '@')||(LA8_0 >= 'B' && LA8_0 <= 'M')||(LA8_0 >= 'P' && LA8_0 <= '`')||(LA8_0 >= 'b' && LA8_0 <= 'm')||(LA8_0 >= 'p' && LA8_0 <= '{')||(LA8_0 >= '}' && LA8_0 <= '\uFFFF')) ) {
			alt8=6;
		}
		else if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||LA8_0=='\r'||LA8_0==' ') ) {
			alt8=7;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 8, 0, input);
			throw nvae;
		}

		switch (alt8) {
			case 1 :
				// Tags.g:1:10: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 2 :
				// Tags.g:1:17: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 3 :
				// Tags.g:1:24: AND
				{
				mAND(); 

				}
				break;
			case 4 :
				// Tags.g:1:28: OR
				{
				mOR(); 

				}
				break;
			case 5 :
				// Tags.g:1:31: NOT
				{
				mNOT(); 

				}
				break;
			case 6 :
				// Tags.g:1:35: NAME
				{
				mNAME(); 

				}
				break;
			case 7 :
				// Tags.g:1:40: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
