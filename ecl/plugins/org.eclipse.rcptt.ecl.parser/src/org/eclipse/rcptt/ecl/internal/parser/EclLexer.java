// $ANTLR 3.5.2 Ecl.g 2014-07-23 22:41:28

package org.eclipse.rcptt.ecl.internal.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EclLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int AND=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int CURLY_STRING=7;
	public static final int DIGIT=8;
	public static final int DNAME=9;
	public static final int IP4=10;
	public static final int LBRACK=11;
	public static final int LCURLY=12;
	public static final int LINE_COMMENT=13;
	public static final int LOPEN=14;
	public static final int NAME=15;
	public static final int NEWLINE=16;
	public static final int NUMBER=17;
	public static final int OR=18;
	public static final int RBRACK=19;
	public static final int RCURLY=20;
	public static final int ROPEN=21;
	public static final int SEMI=22;
	public static final int STRING=23;
	public static final int WS=24;
	  
	  public void displayRecognitionError(String[] tokenNames,
	      RecognitionException e) {
	      throw new SyntaxErrorException(e.line, e.charPositionInLine);
	  }


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public EclLexer() {} 
	public EclLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public EclLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Ecl.g"; }

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		traceIn("T__25", 1);
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:17:7: ( '$' )
			// Ecl.g:17:9: '$'
			{
			match('$'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("T__25", 1);
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		traceIn("T__26", 2);
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:18:7: ( '+' )
			// Ecl.g:18:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("T__26", 2);
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		traceIn("T__27", 3);
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:19:7: ( '-' )
			// Ecl.g:19:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("T__27", 3);
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		traceIn("T__28", 4);
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:20:7: ( '=' )
			// Ecl.g:20:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("T__28", 4);
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		traceIn("T__29", 5);
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:21:7: ( '@' )
			// Ecl.g:21:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("T__29", 5);
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		traceIn("COLON", 6);
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:304:6: ( ';' )
			// Ecl.g:304:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("COLON", 6);
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		traceIn("AND", 7);
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:305:4: ( '&' )
			// Ecl.g:305:6: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("AND", 7);
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		traceIn("OR", 8);
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:306:3: ( '|' )
			// Ecl.g:306:5: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("OR", 8);
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		traceIn("SEMI", 9);
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:307:5: ( ':' )
			// Ecl.g:307:7: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("SEMI", 9);
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		traceIn("DIGIT", 10);
		try {
			// Ecl.g:309:15: ( ( '0' .. '9' ) )
			// Ecl.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
			traceOut("DIGIT", 10);
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		traceIn("NUMBER", 11);
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:313:7: ( ( DIGIT )+ )
			// Ecl.g:314:3: ( DIGIT )+
			{
			// Ecl.g:314:3: ( DIGIT )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Ecl.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("NUMBER", 11);
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "IP4"
	public final void mIP4() throws RecognitionException {
		traceIn("IP4", 12);
		try {
			int _type = IP4;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:318:4: ( NUMBER '.' NUMBER '.' NUMBER '.' NUMBER )
			// Ecl.g:319:3: NUMBER '.' NUMBER '.' NUMBER '.' NUMBER
			{
			mNUMBER(); 

			match('.'); 
			mNUMBER(); 

			match('.'); 
			mNUMBER(); 

			match('.'); 
			mNUMBER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("IP4", 12);
		}
	}
	// $ANTLR end "IP4"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		traceIn("STRING", 13);
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:331:7: ( '\"' (~ ( '\"' | '\\n' | '\\\\' ) | ( '\\\\' . ) )* '\"' )
			// Ecl.g:332:4: '\"' (~ ( '\"' | '\\n' | '\\\\' ) | ( '\\\\' . ) )* '\"'
			{
			match('\"'); 
			// Ecl.g:332:8: (~ ( '\"' | '\\n' | '\\\\' ) | ( '\\\\' . ) )*
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}
				else if ( (LA2_0=='\\') ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// Ecl.g:332:9: ~ ( '\"' | '\\n' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// Ecl.g:332:26: ( '\\\\' . )
					{
					// Ecl.g:332:26: ( '\\\\' . )
					// Ecl.g:332:27: '\\\\' .
					{
					match('\\'); 
					matchAny(); 
					}

					}
					break;

				default :
					break loop2;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("STRING", 13);
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "LOPEN"
	public final void mLOPEN() throws RecognitionException {
		traceIn("LOPEN", 14);
		try {
			int _type = LOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:337:8: ( '(' )
			// Ecl.g:337:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("LOPEN", 14);
		}
	}
	// $ANTLR end "LOPEN"

	// $ANTLR start "ROPEN"
	public final void mROPEN() throws RecognitionException {
		traceIn("ROPEN", 15);
		try {
			int _type = ROPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:340:8: ( ')' )
			// Ecl.g:340:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("ROPEN", 15);
		}
	}
	// $ANTLR end "ROPEN"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		traceIn("LCURLY", 16);
		try {
			int _type = LCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:343:9: ( '{' )
			// Ecl.g:343:11: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("LCURLY", 16);
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		traceIn("RCURLY", 17);
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:346:9: ( '}' )
			// Ecl.g:346:11: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("RCURLY", 17);
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		traceIn("LBRACK", 18);
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:349:9: ( '[' )
			// Ecl.g:349:11: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("LBRACK", 18);
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		traceIn("RBRACK", 19);
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:352:9: ( ']' )
			// Ecl.g:352:11: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("RBRACK", 19);
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "CURLY_STRING"
	public final void mCURLY_STRING() throws RecognitionException {
		traceIn("CURLY_STRING", 20);
		try {
			int _type = CURLY_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:353:13: ( LCURLY ( CURLY_STRING | LINE_COMMENT | COMMENT | STRING | ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )? )* RCURLY )
			// Ecl.g:354:3: LCURLY ( CURLY_STRING | LINE_COMMENT | COMMENT | STRING | ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )? )* RCURLY
			{
			mLCURLY(); 

			// Ecl.g:355:3: ( CURLY_STRING | LINE_COMMENT | COMMENT | STRING | ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )? )*
			loop6:
			while (true) {
				int alt6=6;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='{') ) {
					alt6=1;
				}
				else if ( (LA6_0=='/') ) {
					int LA6_3 = input.LA(2);
					if ( (LA6_3=='/') ) {
						alt6=2;
					}
					else if ( (LA6_3=='*') ) {
						alt6=3;
					}
					else if ( ((LA6_3 >= '\u0000' && LA6_3 <= '!')||(LA6_3 >= '#' && LA6_3 <= ')')||(LA6_3 >= '+' && LA6_3 <= '.')||(LA6_3 >= '0' && LA6_3 <= 'z')||LA6_3=='|'||(LA6_3 >= '~' && LA6_3 <= '\uFFFF')) ) {
						alt6=5;
					}

				}
				else if ( (LA6_0=='\"') ) {
					alt6=4;
				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '.')||(LA6_0 >= '0' && LA6_0 <= 'z')||LA6_0=='|'||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {
					alt6=5;
				}

				switch (alt6) {
				case 1 :
					// Ecl.g:356:5: CURLY_STRING
					{
					mCURLY_STRING(); 

					}
					break;
				case 2 :
					// Ecl.g:357:5: LINE_COMMENT
					{
					mLINE_COMMENT(); 

					}
					break;
				case 3 :
					// Ecl.g:358:5: COMMENT
					{
					mCOMMENT(); 

					}
					break;
				case 4 :
					// Ecl.g:359:5: STRING
					{
					mSTRING(); 

					}
					break;
				case 5 :
					// Ecl.g:360:5: ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )?
					{
					// Ecl.g:360:5: ( '/' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0=='/') ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// Ecl.g:360:5: '/'
							{
							match('/'); 
							}
							break;

					}

					// Ecl.g:360:10: (~ ( '/' | '{' | '}' | '*' | '\"' ) )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '.')||(LA4_0 >= '0' && LA4_0 <= 'z')||LA4_0=='|'||(LA4_0 >= '~' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Ecl.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= ')')||(input.LA(1) >= '+' && input.LA(1) <= '.')||(input.LA(1) >= '0' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
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

					// Ecl.g:360:42: ( '*' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='*') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// Ecl.g:360:42: '*'
							{
							match('*'); 
							}
							break;

					}

					}
					break;

				default :
					break loop6;
				}
			}

			mRCURLY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("CURLY_STRING", 20);
		}
	}
	// $ANTLR end "CURLY_STRING"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		traceIn("NAME", 21);
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:365:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )* )
			// Ecl.g:366:2: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Ecl.g:366:22: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '.' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Ecl.g:
					{
					if ( (input.LA(1) >= '.' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop7;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("NAME", 21);
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "DNAME"
	public final void mDNAME() throws RecognitionException {
		traceIn("DNAME", 22);
		try {
			int _type = DNAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:369:6: ( NAME ( '-' NAME )+ )
			// Ecl.g:370:2: NAME ( '-' NAME )+
			{
			mNAME(); 

			// Ecl.g:370:7: ( '-' NAME )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0=='-') ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Ecl.g:370:8: '-' NAME
					{
					match('-'); 
					mNAME(); 

					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("DNAME", 22);
		}
	}
	// $ANTLR end "DNAME"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		traceIn("WS", 23);
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:373:3: ( ( ' ' | '\\t' )+ )
			// Ecl.g:373:5: ( ' ' | '\\t' )+
			{
			// Ecl.g:373:5: ( ' ' | '\\t' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\t'||LA9_0==' ') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Ecl.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}


			  _channel=HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("WS", 23);
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		traceIn("COMMENT", 24);
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:379:8: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// Ecl.g:379:10: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// Ecl.g:379:15: ( options {greedy=false; } : . )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='*') ) {
					int LA10_1 = input.LA(2);
					if ( (LA10_1=='/') ) {
						alt10=2;
					}
					else if ( ((LA10_1 >= '\u0000' && LA10_1 <= '.')||(LA10_1 >= '0' && LA10_1 <= '\uFFFF')) ) {
						alt10=1;
					}

				}
				else if ( ((LA10_0 >= '\u0000' && LA10_0 <= ')')||(LA10_0 >= '+' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// Ecl.g:379:43: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop10;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("COMMENT", 24);
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		traceIn("LINE_COMMENT", 25);
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:382:13: ( '//' (~ ( '\\n' | '\\r' ) )* )
			// Ecl.g:382:15: '//' (~ ( '\\n' | '\\r' ) )*
			{
			match("//"); 

			// Ecl.g:382:20: (~ ( '\\n' | '\\r' ) )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// Ecl.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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
					break loop11;
				}
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("LINE_COMMENT", 25);
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		traceIn("NEWLINE", 26);
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:385:8: ( ( ( '\\r' | '\\n' )+ ( COMMENT )* ( LINE_COMMENT )* ( WS )* )+ )
			// Ecl.g:385:10: ( ( '\\r' | '\\n' )+ ( COMMENT )* ( LINE_COMMENT )* ( WS )* )+
			{
			// Ecl.g:385:10: ( ( '\\r' | '\\n' )+ ( COMMENT )* ( LINE_COMMENT )* ( WS )* )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0=='\n'||LA16_0=='\r') ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// Ecl.g:385:11: ( '\\r' | '\\n' )+ ( COMMENT )* ( LINE_COMMENT )* ( WS )*
					{
					// Ecl.g:385:11: ( '\\r' | '\\n' )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0=='\n'||LA12_0=='\r') ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// Ecl.g:
							{
							if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					// Ecl.g:385:24: ( COMMENT )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0=='/') ) {
							int LA13_1 = input.LA(2);
							if ( (LA13_1=='*') ) {
								alt13=1;
							}

						}

						switch (alt13) {
						case 1 :
							// Ecl.g:385:24: COMMENT
							{
							mCOMMENT(); 

							}
							break;

						default :
							break loop13;
						}
					}

					// Ecl.g:385:33: ( LINE_COMMENT )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0=='/') ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// Ecl.g:385:33: LINE_COMMENT
							{
							mLINE_COMMENT(); 

							}
							break;

						default :
							break loop14;
						}
					}

					// Ecl.g:385:47: ( WS )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0=='\t'||LA15_0==' ') ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// Ecl.g:385:47: WS
							{
							mWS(); 

							}
							break;

						default :
							break loop15;
						}
					}

					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
			traceOut("NEWLINE", 26);
		}
	}
	// $ANTLR end "NEWLINE"

	@Override
	public void mTokens() throws RecognitionException {
		// Ecl.g:1:8: ( T__25 | T__26 | T__27 | T__28 | T__29 | COLON | AND | OR | SEMI | NUMBER | IP4 | STRING | LOPEN | ROPEN | LCURLY | RCURLY | LBRACK | RBRACK | CURLY_STRING | NAME | DNAME | WS | COMMENT | LINE_COMMENT | NEWLINE )
		int alt17=25;
		alt17 = dfa17.predict(input);
		switch (alt17) {
			case 1 :
				// Ecl.g:1:10: T__25
				{
				mT__25(); 

				}
				break;
			case 2 :
				// Ecl.g:1:16: T__26
				{
				mT__26(); 

				}
				break;
			case 3 :
				// Ecl.g:1:22: T__27
				{
				mT__27(); 

				}
				break;
			case 4 :
				// Ecl.g:1:28: T__28
				{
				mT__28(); 

				}
				break;
			case 5 :
				// Ecl.g:1:34: T__29
				{
				mT__29(); 

				}
				break;
			case 6 :
				// Ecl.g:1:40: COLON
				{
				mCOLON(); 

				}
				break;
			case 7 :
				// Ecl.g:1:46: AND
				{
				mAND(); 

				}
				break;
			case 8 :
				// Ecl.g:1:50: OR
				{
				mOR(); 

				}
				break;
			case 9 :
				// Ecl.g:1:53: SEMI
				{
				mSEMI(); 

				}
				break;
			case 10 :
				// Ecl.g:1:58: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 11 :
				// Ecl.g:1:65: IP4
				{
				mIP4(); 

				}
				break;
			case 12 :
				// Ecl.g:1:69: STRING
				{
				mSTRING(); 

				}
				break;
			case 13 :
				// Ecl.g:1:76: LOPEN
				{
				mLOPEN(); 

				}
				break;
			case 14 :
				// Ecl.g:1:82: ROPEN
				{
				mROPEN(); 

				}
				break;
			case 15 :
				// Ecl.g:1:88: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 16 :
				// Ecl.g:1:95: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 17 :
				// Ecl.g:1:102: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 18 :
				// Ecl.g:1:109: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 19 :
				// Ecl.g:1:116: CURLY_STRING
				{
				mCURLY_STRING(); 

				}
				break;
			case 20 :
				// Ecl.g:1:129: NAME
				{
				mNAME(); 

				}
				break;
			case 21 :
				// Ecl.g:1:134: DNAME
				{
				mDNAME(); 

				}
				break;
			case 22 :
				// Ecl.g:1:140: WS
				{
				mWS(); 

				}
				break;
			case 23 :
				// Ecl.g:1:143: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 24 :
				// Ecl.g:1:151: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 25 :
				// Ecl.g:1:164: NEWLINE
				{
				mNEWLINE(); 

				}
				break;

		}
	}


	protected DFA17 dfa17 = new DFA17(this);
	static final String DFA17_eotS =
		"\12\uffff\1\26\3\uffff\1\30\3\uffff\1\33\7\uffff\1\33\4\uffff";
	static final String DFA17_eofS =
		"\37\uffff";
	static final String DFA17_minS =
		"\1\11\11\uffff\1\56\3\uffff\1\0\3\uffff\1\55\1\uffff\1\52\5\uffff\1\55"+
		"\4\uffff";
	static final String DFA17_maxS =
		"\1\175\11\uffff\1\71\3\uffff\1\uffff\3\uffff\1\172\1\uffff\1\57\5\uffff"+
		"\1\172\4\uffff";
	static final String DFA17_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\14\1\15\1\16"+
		"\1\uffff\1\20\1\21\1\22\1\uffff\1\26\1\uffff\1\31\1\12\1\13\1\17\1\23"+
		"\1\uffff\1\24\1\25\1\27\1\30";
	static final String DFA17_specialS =
		"\16\uffff\1\0\20\uffff}>";
	static final String[] DFA17_transitionS = {
			"\1\23\1\25\2\uffff\1\25\22\uffff\1\23\1\uffff\1\13\1\uffff\1\1\1\uffff"+
			"\1\7\1\uffff\1\14\1\15\1\uffff\1\2\1\uffff\1\3\1\uffff\1\24\12\12\1\11"+
			"\1\6\1\uffff\1\4\2\uffff\1\5\32\22\1\20\1\uffff\1\21\3\uffff\32\22\1"+
			"\16\1\10\1\17",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\27\1\uffff\12\12",
			"",
			"",
			"",
			"\52\31\1\uffff\uffd5\31",
			"",
			"",
			"",
			"\1\34\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\35\4\uffff\1\36",
			"",
			"",
			"",
			"",
			"",
			"\1\34\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"",
			"",
			""
	};

	static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
	static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
	static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
	static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
	static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
	static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
	static final short[][] DFA17_transition;

	static {
		int numStates = DFA17_transitionS.length;
		DFA17_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
		}
	}

	protected class DFA17 extends DFA {

		public DFA17(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 17;
			this.eot = DFA17_eot;
			this.eof = DFA17_eof;
			this.min = DFA17_min;
			this.max = DFA17_max;
			this.accept = DFA17_accept;
			this.special = DFA17_special;
			this.transition = DFA17_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__25 | T__26 | T__27 | T__28 | T__29 | COLON | AND | OR | SEMI | NUMBER | IP4 | STRING | LOPEN | ROPEN | LCURLY | RCURLY | LBRACK | RBRACK | CURLY_STRING | NAME | DNAME | WS | COMMENT | LINE_COMMENT | NEWLINE );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA17_14 = input.LA(1);
						s = -1;
						if ( ((LA17_14 >= '\u0000' && LA17_14 <= ')')||(LA17_14 >= '+' && LA17_14 <= '\uFFFF')) ) {s = 25;}
						else s = 24;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 17, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
