// $ANTLR 3.5.2 Ecl.g 2014-07-30 19:44:36

package org.eclipse.rcptt.ecl.internal.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EclLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int MINUS=15;
	public static final int NAME=16;
	public static final int NEWLINE=17;
	public static final int NUMBER=18;
	public static final int OR=19;
	public static final int RBRACK=20;
	public static final int RCURLY=21;
	public static final int ROPEN=22;
	public static final int SEMICOLON=23;
	public static final int STRING=24;
	public static final int WS=25;
	  
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

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
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
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
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
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:19:7: ( '=' )
			// Ecl.g:19:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:20:7: ( '@' )
			// Ecl.g:20:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:304:10: ( ';' )
			// Ecl.g:304:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
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
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
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
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:307:6: ( ':' )
			// Ecl.g:307:8: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
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
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
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
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "IP4"
	public final void mIP4() throws RecognitionException {
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
		}
	}
	// $ANTLR end "IP4"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
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
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "LOPEN"
	public final void mLOPEN() throws RecognitionException {
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
		}
	}
	// $ANTLR end "LOPEN"

	// $ANTLR start "ROPEN"
	public final void mROPEN() throws RecognitionException {
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
		}
	}
	// $ANTLR end "ROPEN"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
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
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
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
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
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
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
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
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:355:7: ( '-' )
			// Ecl.g:355:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "CURLY_STRING"
	public final void mCURLY_STRING() throws RecognitionException {
		try {
			int _type = CURLY_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:356:13: ( LCURLY ( CURLY_STRING | LINE_COMMENT | COMMENT | STRING | ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )? )* RCURLY )
			// Ecl.g:357:3: LCURLY ( CURLY_STRING | LINE_COMMENT | COMMENT | STRING | ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )? )* RCURLY
			{
			mLCURLY(); 

			// Ecl.g:358:3: ( CURLY_STRING | LINE_COMMENT | COMMENT | STRING | ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )? )*
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
					// Ecl.g:359:5: CURLY_STRING
					{
					mCURLY_STRING(); 

					}
					break;
				case 2 :
					// Ecl.g:360:5: LINE_COMMENT
					{
					mLINE_COMMENT(); 

					}
					break;
				case 3 :
					// Ecl.g:361:5: COMMENT
					{
					mCOMMENT(); 

					}
					break;
				case 4 :
					// Ecl.g:362:5: STRING
					{
					mSTRING(); 

					}
					break;
				case 5 :
					// Ecl.g:363:5: ( '/' )? (~ ( '/' | '{' | '}' | '*' | '\"' ) )+ ( '*' )?
					{
					// Ecl.g:363:5: ( '/' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0=='/') ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// Ecl.g:363:5: '/'
							{
							match('/'); 
							}
							break;

					}

					// Ecl.g:363:10: (~ ( '/' | '{' | '}' | '*' | '\"' ) )+
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

					// Ecl.g:363:42: ( '*' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='*') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// Ecl.g:363:42: '*'
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
		}
	}
	// $ANTLR end "CURLY_STRING"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:368:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )* )
			// Ecl.g:369:2: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Ecl.g:369:22: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )*
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
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "DNAME"
	public final void mDNAME() throws RecognitionException {
		try {
			int _type = DNAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:372:6: ( NAME ( MINUS NAME )+ )
			// Ecl.g:373:2: NAME ( MINUS NAME )+
			{
			mNAME(); 

			// Ecl.g:373:7: ( MINUS NAME )+
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
					// Ecl.g:373:8: MINUS NAME
					{
					mMINUS(); 

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
		}
	}
	// $ANTLR end "DNAME"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:376:3: ( ( ' ' | '\\t' )+ )
			// Ecl.g:376:5: ( ' ' | '\\t' )+
			{
			// Ecl.g:376:5: ( ' ' | '\\t' )+
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
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
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
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
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
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Ecl.g:385:8: ( ( ( '\\r' | '\\n' )+ ( COMMENT | LINE_COMMENT | WS )* )+ )
			// Ecl.g:385:10: ( ( '\\r' | '\\n' )+ ( COMMENT | LINE_COMMENT | WS )* )+
			{
			// Ecl.g:385:10: ( ( '\\r' | '\\n' )+ ( COMMENT | LINE_COMMENT | WS )* )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0=='\n'||LA14_0=='\r') ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// Ecl.g:385:11: ( '\\r' | '\\n' )+ ( COMMENT | LINE_COMMENT | WS )*
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

					// Ecl.g:385:24: ( COMMENT | LINE_COMMENT | WS )*
					loop13:
					while (true) {
						int alt13=4;
						int LA13_0 = input.LA(1);
						if ( (LA13_0=='/') ) {
							int LA13_2 = input.LA(2);
							if ( (LA13_2=='*') ) {
								alt13=1;
							}
							else if ( (LA13_2=='/') ) {
								alt13=2;
							}

						}
						else if ( (LA13_0=='\t'||LA13_0==' ') ) {
							alt13=3;
						}

						switch (alt13) {
						case 1 :
							// Ecl.g:385:25: COMMENT
							{
							mCOMMENT(); 

							}
							break;
						case 2 :
							// Ecl.g:385:33: LINE_COMMENT
							{
							mLINE_COMMENT(); 

							}
							break;
						case 3 :
							// Ecl.g:385:46: WS
							{
							mWS(); 

							}
							break;

						default :
							break loop13;
						}
					}

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	@Override
	public void mTokens() throws RecognitionException {
		// Ecl.g:1:8: ( T__26 | T__27 | T__28 | T__29 | SEMICOLON | AND | OR | COLON | NUMBER | IP4 | STRING | LOPEN | ROPEN | LCURLY | RCURLY | LBRACK | RBRACK | MINUS | CURLY_STRING | NAME | DNAME | WS | COMMENT | LINE_COMMENT | NEWLINE )
		int alt15=25;
		alt15 = dfa15.predict(input);
		switch (alt15) {
			case 1 :
				// Ecl.g:1:10: T__26
				{
				mT__26(); 

				}
				break;
			case 2 :
				// Ecl.g:1:16: T__27
				{
				mT__27(); 

				}
				break;
			case 3 :
				// Ecl.g:1:22: T__28
				{
				mT__28(); 

				}
				break;
			case 4 :
				// Ecl.g:1:28: T__29
				{
				mT__29(); 

				}
				break;
			case 5 :
				// Ecl.g:1:34: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 6 :
				// Ecl.g:1:44: AND
				{
				mAND(); 

				}
				break;
			case 7 :
				// Ecl.g:1:48: OR
				{
				mOR(); 

				}
				break;
			case 8 :
				// Ecl.g:1:51: COLON
				{
				mCOLON(); 

				}
				break;
			case 9 :
				// Ecl.g:1:57: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 10 :
				// Ecl.g:1:64: IP4
				{
				mIP4(); 

				}
				break;
			case 11 :
				// Ecl.g:1:68: STRING
				{
				mSTRING(); 

				}
				break;
			case 12 :
				// Ecl.g:1:75: LOPEN
				{
				mLOPEN(); 

				}
				break;
			case 13 :
				// Ecl.g:1:81: ROPEN
				{
				mROPEN(); 

				}
				break;
			case 14 :
				// Ecl.g:1:87: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 15 :
				// Ecl.g:1:94: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 16 :
				// Ecl.g:1:101: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 17 :
				// Ecl.g:1:108: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 18 :
				// Ecl.g:1:115: MINUS
				{
				mMINUS(); 

				}
				break;
			case 19 :
				// Ecl.g:1:121: CURLY_STRING
				{
				mCURLY_STRING(); 

				}
				break;
			case 20 :
				// Ecl.g:1:134: NAME
				{
				mNAME(); 

				}
				break;
			case 21 :
				// Ecl.g:1:139: DNAME
				{
				mDNAME(); 

				}
				break;
			case 22 :
				// Ecl.g:1:145: WS
				{
				mWS(); 

				}
				break;
			case 23 :
				// Ecl.g:1:148: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 24 :
				// Ecl.g:1:156: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 25 :
				// Ecl.g:1:169: NEWLINE
				{
				mNEWLINE(); 

				}
				break;

		}
	}


	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA15_eotS =
		"\11\uffff\1\26\3\uffff\1\30\4\uffff\1\33\7\uffff\1\33\4\uffff";
	static final String DFA15_eofS =
		"\37\uffff";
	static final String DFA15_minS =
		"\1\11\10\uffff\1\56\3\uffff\1\0\4\uffff\1\55\1\uffff\1\52\5\uffff\1\55"+
		"\4\uffff";
	static final String DFA15_maxS =
		"\1\175\10\uffff\1\71\3\uffff\1\uffff\4\uffff\1\172\1\uffff\1\57\5\uffff"+
		"\1\172\4\uffff";
	static final String DFA15_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14\1\15\1\uffff"+
		"\1\17\1\20\1\21\1\22\1\uffff\1\26\1\uffff\1\31\1\11\1\12\1\16\1\23\1\uffff"+
		"\1\24\1\25\1\27\1\30";
	static final String DFA15_specialS =
		"\15\uffff\1\0\21\uffff}>";
	static final String[] DFA15_transitionS = {
			"\1\23\1\25\2\uffff\1\25\22\uffff\1\23\1\uffff\1\12\1\uffff\1\1\1\uffff"+
			"\1\6\1\uffff\1\13\1\14\1\uffff\1\2\1\uffff\1\21\1\uffff\1\24\12\11\1"+
			"\10\1\5\1\uffff\1\3\2\uffff\1\4\32\22\1\17\1\uffff\1\20\3\uffff\32\22"+
			"\1\15\1\7\1\16",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\27\1\uffff\12\11",
			"",
			"",
			"",
			"\52\31\1\uffff\uffd5\31",
			"",
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

	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;

	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	protected class DFA15 extends DFA {

		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__26 | T__27 | T__28 | T__29 | SEMICOLON | AND | OR | COLON | NUMBER | IP4 | STRING | LOPEN | ROPEN | LCURLY | RCURLY | LBRACK | RBRACK | MINUS | CURLY_STRING | NAME | DNAME | WS | COMMENT | LINE_COMMENT | NEWLINE );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA15_13 = input.LA(1);
						s = -1;
						if ( ((LA15_13 >= '\u0000' && LA15_13 <= ')')||(LA15_13 >= '+' && LA15_13 <= '\uFFFF')) ) {s = 25;}
						else s = 24;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 15, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
