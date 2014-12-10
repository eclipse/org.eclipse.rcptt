// $ANTLR 3.5.2 Tags.g 2014-12-10 15:23:08

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
	public static final int OR=7;
	public static final int RPAREN=8;
	public static final int WS=9;

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
			// Tags.g:23:8: ( '(' )
			// Tags.g:23:10: '('
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
			// Tags.g:24:8: ( ')' )
			// Tags.g:24:10: ')'
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
			// Tags.g:25:5: ( '&' | 'AND' | 'and' )
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
					// Tags.g:25:7: '&'
					{
					match('&'); 
					}
					break;
				case 2 :
					// Tags.g:25:13: 'AND'
					{
					match("AND"); 

					}
					break;
				case 3 :
					// Tags.g:25:21: 'and'
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
			// Tags.g:26:4: ( '|' | 'OR' | 'or' )
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
					// Tags.g:26:6: '|'
					{
					match('|'); 
					}
					break;
				case 2 :
					// Tags.g:26:12: 'OR'
					{
					match("OR"); 

					}
					break;
				case 3 :
					// Tags.g:26:19: 'or'
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

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tags.g:27:6: ( (~ ( ' ' | '\\t' | '\\r' | '\\n' | '(' | ')' | '\"' ) )+ | '\"' (~ ( '\"' ) )+ '\"' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\b')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\u001F')||LA5_0=='!'||(LA5_0 >= '#' && LA5_0 <= '\'')||(LA5_0 >= '*' && LA5_0 <= '\uFFFF')) ) {
				alt5=1;
			}
			else if ( (LA5_0=='\"') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// Tags.g:27:8: (~ ( ' ' | '\\t' | '\\r' | '\\n' | '(' | ')' | '\"' ) )+
					{
					// Tags.g:27:8: (~ ( ' ' | '\\t' | '\\r' | '\\n' | '(' | ')' | '\"' ) )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\b')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\u001F')||LA3_0=='!'||(LA3_0 >= '#' && LA3_0 <= '\'')||(LA3_0 >= '*' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Tags.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||input.LA(1)=='!'||(input.LA(1) >= '#' && input.LA(1) <= '\'')||(input.LA(1) >= '*' && input.LA(1) <= '\uFFFF') ) {
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
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					}
					break;
				case 2 :
					// Tags.g:27:61: '\"' (~ ( '\"' ) )+ '\"'
					{
					match('\"'); 
					// Tags.g:27:64: (~ ( '\"' ) )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
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
							if ( cnt4 >= 1 ) break loop4;
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
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
			// Tags.g:28:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// Tags.g:28:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// Tags.g:28:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
		// Tags.g:1:8: ( LPAREN | RPAREN | AND | OR | NAME | WS )
		int alt7=6;
		int LA7_0 = input.LA(1);
		if ( (LA7_0=='(') ) {
			alt7=1;
		}
		else if ( (LA7_0==')') ) {
			alt7=2;
		}
		else if ( (LA7_0=='&') ) {
			int LA7_3 = input.LA(2);
			if ( ((LA7_3 >= '\u0000' && LA7_3 <= '\b')||(LA7_3 >= '\u000B' && LA7_3 <= '\f')||(LA7_3 >= '\u000E' && LA7_3 <= '\u001F')||LA7_3=='!'||(LA7_3 >= '#' && LA7_3 <= '\'')||(LA7_3 >= '*' && LA7_3 <= '\uFFFF')) ) {
				alt7=5;
			}

			else {
				alt7=3;
			}

		}
		else if ( (LA7_0=='A') ) {
			int LA7_4 = input.LA(2);
			if ( (LA7_4=='N') ) {
				int LA7_12 = input.LA(3);
				if ( (LA7_12=='D') ) {
					int LA7_17 = input.LA(4);
					if ( ((LA7_17 >= '\u0000' && LA7_17 <= '\b')||(LA7_17 >= '\u000B' && LA7_17 <= '\f')||(LA7_17 >= '\u000E' && LA7_17 <= '\u001F')||LA7_17=='!'||(LA7_17 >= '#' && LA7_17 <= '\'')||(LA7_17 >= '*' && LA7_17 <= '\uFFFF')) ) {
						alt7=5;
					}

					else {
						alt7=3;
					}

				}

				else {
					alt7=5;
				}

			}

			else {
				alt7=5;
			}

		}
		else if ( (LA7_0=='a') ) {
			int LA7_5 = input.LA(2);
			if ( (LA7_5=='n') ) {
				int LA7_13 = input.LA(3);
				if ( (LA7_13=='d') ) {
					int LA7_18 = input.LA(4);
					if ( ((LA7_18 >= '\u0000' && LA7_18 <= '\b')||(LA7_18 >= '\u000B' && LA7_18 <= '\f')||(LA7_18 >= '\u000E' && LA7_18 <= '\u001F')||LA7_18=='!'||(LA7_18 >= '#' && LA7_18 <= '\'')||(LA7_18 >= '*' && LA7_18 <= '\uFFFF')) ) {
						alt7=5;
					}

					else {
						alt7=3;
					}

				}

				else {
					alt7=5;
				}

			}

			else {
				alt7=5;
			}

		}
		else if ( (LA7_0=='|') ) {
			int LA7_6 = input.LA(2);
			if ( ((LA7_6 >= '\u0000' && LA7_6 <= '\b')||(LA7_6 >= '\u000B' && LA7_6 <= '\f')||(LA7_6 >= '\u000E' && LA7_6 <= '\u001F')||LA7_6=='!'||(LA7_6 >= '#' && LA7_6 <= '\'')||(LA7_6 >= '*' && LA7_6 <= '\uFFFF')) ) {
				alt7=5;
			}

			else {
				alt7=4;
			}

		}
		else if ( (LA7_0=='O') ) {
			int LA7_7 = input.LA(2);
			if ( (LA7_7=='R') ) {
				int LA7_15 = input.LA(3);
				if ( ((LA7_15 >= '\u0000' && LA7_15 <= '\b')||(LA7_15 >= '\u000B' && LA7_15 <= '\f')||(LA7_15 >= '\u000E' && LA7_15 <= '\u001F')||LA7_15=='!'||(LA7_15 >= '#' && LA7_15 <= '\'')||(LA7_15 >= '*' && LA7_15 <= '\uFFFF')) ) {
					alt7=5;
				}

				else {
					alt7=4;
				}

			}

			else {
				alt7=5;
			}

		}
		else if ( (LA7_0=='o') ) {
			int LA7_8 = input.LA(2);
			if ( (LA7_8=='r') ) {
				int LA7_16 = input.LA(3);
				if ( ((LA7_16 >= '\u0000' && LA7_16 <= '\b')||(LA7_16 >= '\u000B' && LA7_16 <= '\f')||(LA7_16 >= '\u000E' && LA7_16 <= '\u001F')||LA7_16=='!'||(LA7_16 >= '#' && LA7_16 <= '\'')||(LA7_16 >= '*' && LA7_16 <= '\uFFFF')) ) {
					alt7=5;
				}

				else {
					alt7=4;
				}

			}

			else {
				alt7=5;
			}

		}
		else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\b')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\u001F')||(LA7_0 >= '!' && LA7_0 <= '%')||LA7_0=='\''||(LA7_0 >= '*' && LA7_0 <= '@')||(LA7_0 >= 'B' && LA7_0 <= 'N')||(LA7_0 >= 'P' && LA7_0 <= '`')||(LA7_0 >= 'b' && LA7_0 <= 'n')||(LA7_0 >= 'p' && LA7_0 <= '{')||(LA7_0 >= '}' && LA7_0 <= '\uFFFF')) ) {
			alt7=5;
		}
		else if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
			alt7=6;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}

		switch (alt7) {
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
				// Tags.g:1:31: NAME
				{
				mNAME(); 

				}
				break;
			case 6 :
				// Tags.g:1:36: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
