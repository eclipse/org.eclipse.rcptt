/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
// $ANTLR 3.0 Ecl.g 2013-07-31 23:05:38

package org.eclipse.rcptt.ecl.internal.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EclLexer extends Lexer {
    public static final int RBRACK=10;
    public static final int LBRACK=9;
    public static final int LINE_COMMENT=24;
    public static final int NUMBER=14;
    public static final int LCURLY=19;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int AND=5;
    public static final int Tokens=30;
    public static final int EOF=-1;
    public static final int SEMI=16;
    public static final int COLON=4;
    public static final int NAME=11;
    public static final int WS=21;
    public static final int NEWLINE=22;
    public static final int CURLY_STRING=15;
    public static final int DNAME=12;
    public static final int RCURLY=20;
    public static final int OR=6;
    public static final int LOPEN=7;
    public static final int IP4=13;
    public static final int DIGIT=17;
    public static final int ROPEN=8;
    public static final int COMMENT=23;
    public static final int STRING=18;
      
      public void displayRecognitionError(String[] tokenNames,
          RecognitionException e) {
          throw new SyntaxErrorException(e.line, e.charPositionInLine);
      }

    public EclLexer() {;} 
    public EclLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "Ecl.g"; }

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // Ecl.g:16:7: ( '$' )
            // Ecl.g:16:7: '$'
            {
            match('$'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // Ecl.g:17:7: ( '@' )
            // Ecl.g:17:7: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // Ecl.g:18:7: ( '-' )
            // Ecl.g:18:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // Ecl.g:19:7: ( '=' )
            // Ecl.g:19:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // Ecl.g:20:7: ( '+' )
            // Ecl.g:20:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // Ecl.g:354:8: ( ';' )
            // Ecl.g:354:8: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // Ecl.g:355:6: ( '&' )
            // Ecl.g:355:6: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // Ecl.g:356:5: ( '|' )
            // Ecl.g:356:5: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            // Ecl.g:357:7: ( ':' )
            // Ecl.g:357:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // Ecl.g:360:1: ( ( '0' .. '9' ) )
            // Ecl.g:360:1: ( '0' .. '9' )
            {
            // Ecl.g:360:1: ( '0' .. '9' )
            // Ecl.g:360:2: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // Ecl.g:364:3: ( ( DIGIT )+ )
            // Ecl.g:364:3: ( DIGIT )+
            {
            // Ecl.g:364:3: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Ecl.g:364:3: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start IP4
    public final void mIP4() throws RecognitionException {
        try {
            int _type = IP4;
            // Ecl.g:369:3: ( NUMBER '.' NUMBER '.' NUMBER '.' NUMBER )
            // Ecl.g:369:3: NUMBER '.' NUMBER '.' NUMBER '.' NUMBER
            {
            mNUMBER(); 
            match('.'); 
            mNUMBER(); 
            match('.'); 
            mNUMBER(); 
            match('.'); 
            mNUMBER(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IP4

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // Ecl.g:382:4: ( '\"' (~ ( '\"' | '\\n' | '\\\\' ) | ( '\\\\' . ) )* '\"' )
            // Ecl.g:382:4: '\"' (~ ( '\"' | '\\n' | '\\\\' ) | ( '\\\\' . ) )* '\"'
            {
            match('\"'); 
            // Ecl.g:382:8: (~ ( '\"' | '\\n' | '\\\\' ) | ( '\\\\' . ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }
                else if ( (LA2_0=='\\') ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // Ecl.g:382:9: ~ ( '\"' | '\\n' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // Ecl.g:382:26: ( '\\\\' . )
            	    {
            	    // Ecl.g:382:26: ( '\\\\' . )
            	    // Ecl.g:382:27: '\\\\' .
            	    {
            	    match('\\'); 
            	    matchAny(); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start LOPEN
    public final void mLOPEN() throws RecognitionException {
        try {
            int _type = LOPEN;
            // Ecl.g:386:10: ( '(' )
            // Ecl.g:386:10: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LOPEN

    // $ANTLR start ROPEN
    public final void mROPEN() throws RecognitionException {
        try {
            int _type = ROPEN;
            // Ecl.g:389:10: ( ')' )
            // Ecl.g:389:10: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ROPEN

    // $ANTLR start LCURLY
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            // Ecl.g:392:11: ( '{' )
            // Ecl.g:392:11: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LCURLY

    // $ANTLR start RCURLY
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            // Ecl.g:395:11: ( '}' )
            // Ecl.g:395:11: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RCURLY

    // $ANTLR start LBRACK
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            // Ecl.g:398:11: ( '[' )
            // Ecl.g:398:11: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LBRACK

    // $ANTLR start RBRACK
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            // Ecl.g:401:11: ( ']' )
            // Ecl.g:401:11: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RBRACK

    // $ANTLR start CURLY_STRING
    public final void mCURLY_STRING() throws RecognitionException {
        try {
            int _type = CURLY_STRING;
            // Ecl.g:409:15: ( LCURLY ( . )* RCURLY )
            // Ecl.g:409:15: LCURLY ( . )* RCURLY
            {
             int deep = 0; 
            mLCURLY(); 
             deep += 1; 
            // Ecl.g:411:3: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='}') ) {
                    int LA3_1 = input.LA(2);

                    if ( ((LA3_1>='\u0000' && LA3_1<='\uFFFE')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='|')||(LA3_0>='~' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Ecl.g:412:3: .
            	    {
            	     
            	        if (input.LA(1) == '"') {
            	          mSTRING();
            	        }
            	        if( input.LA( 1 ) == '{' ) {
            	          deep += 1;
            	        }
            	        else if( input.LA( 1 ) == '}' ) {
            	          deep -= 1;
            	        }
            	        if( deep == 0 ) {
            	          break loop3;
            	        }
            	      
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            mRCURLY(); 
             
              if( deep > 1 ) {
                MismatchedTokenException e = new MismatchedTokenException(RCURLY,input);
                e.expecting='}';
                throw e;
              }
              

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CURLY_STRING

    // $ANTLR start NAME
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            // Ecl.g:437:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )* )
            // Ecl.g:437:2: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // Ecl.g:437:22: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' ) | DIGIT )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='.' && LA4_0<='/')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // Ecl.g:437:23: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '/' )
            	    {
            	    if ( (input.LA(1)>='.' && input.LA(1)<='/')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // Ecl.g:437:55: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NAME

    // $ANTLR start DNAME
    public final void mDNAME() throws RecognitionException {
        try {
            int _type = DNAME;
            // Ecl.g:452:2: ( NAME ( '-' NAME )+ )
            // Ecl.g:452:2: NAME ( '-' NAME )+
            {
            mNAME(); 
            // Ecl.g:452:7: ( '-' NAME )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='-') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Ecl.g:452:8: '-' NAME
            	    {
            	    match('-'); 
            	    mNAME(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DNAME

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // Ecl.g:455:5: ( ( ' ' | '\\t' )+ )
            // Ecl.g:455:5: ( ' ' | '\\t' )+
            {
            // Ecl.g:455:5: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Ecl.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


              channel=HIDDEN;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // Ecl.g:461:10: ( ( '\\r' | '\\n' )+ )
            // Ecl.g:461:10: ( '\\r' | '\\n' )+
            {
            // Ecl.g:461:10: ( '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Ecl.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


              channel=HIDDEN;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // Ecl.g:467:10: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // Ecl.g:467:10: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // Ecl.g:467:15: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFE')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Ecl.g:467:43: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            // Ecl.g:470:15: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // Ecl.g:470:15: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // Ecl.g:470:20: (~ ( '\\n' | '\\r' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Ecl.g:470:20: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // Ecl.g:1:10: ( T25 | T26 | T27 | T28 | T29 | COLON | AND | OR | SEMI | NUMBER | IP4 | STRING | LOPEN | ROPEN | LCURLY | RCURLY | LBRACK | RBRACK | CURLY_STRING | NAME | DNAME | WS | NEWLINE | COMMENT | LINE_COMMENT )
        int alt10=25;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // Ecl.g:1:10: T25
                {
                mT25(); 

                }
                break;
            case 2 :
                // Ecl.g:1:14: T26
                {
                mT26(); 

                }
                break;
            case 3 :
                // Ecl.g:1:18: T27
                {
                mT27(); 

                }
                break;
            case 4 :
                // Ecl.g:1:22: T28
                {
                mT28(); 

                }
                break;
            case 5 :
                // Ecl.g:1:26: T29
                {
                mT29(); 

                }
                break;
            case 6 :
                // Ecl.g:1:30: COLON
                {
                mCOLON(); 

                }
                break;
            case 7 :
                // Ecl.g:1:36: AND
                {
                mAND(); 

                }
                break;
            case 8 :
                // Ecl.g:1:40: OR
                {
                mOR(); 

                }
                break;
            case 9 :
                // Ecl.g:1:43: SEMI
                {
                mSEMI(); 

                }
                break;
            case 10 :
                // Ecl.g:1:48: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 11 :
                // Ecl.g:1:55: IP4
                {
                mIP4(); 

                }
                break;
            case 12 :
                // Ecl.g:1:59: STRING
                {
                mSTRING(); 

                }
                break;
            case 13 :
                // Ecl.g:1:66: LOPEN
                {
                mLOPEN(); 

                }
                break;
            case 14 :
                // Ecl.g:1:72: ROPEN
                {
                mROPEN(); 

                }
                break;
            case 15 :
                // Ecl.g:1:78: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 16 :
                // Ecl.g:1:85: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 17 :
                // Ecl.g:1:92: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 18 :
                // Ecl.g:1:99: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 19 :
                // Ecl.g:1:106: CURLY_STRING
                {
                mCURLY_STRING(); 

                }
                break;
            case 20 :
                // Ecl.g:1:119: NAME
                {
                mNAME(); 

                }
                break;
            case 21 :
                // Ecl.g:1:124: DNAME
                {
                mDNAME(); 

                }
                break;
            case 22 :
                // Ecl.g:1:130: WS
                {
                mWS(); 

                }
                break;
            case 23 :
                // Ecl.g:1:133: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 24 :
                // Ecl.g:1:141: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 25 :
                // Ecl.g:1:149: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\12\uffff\1\26\3\uffff\1\30\3\uffff\1\34\7\uffff\2\34\4\uffff";
    static final String DFA10_eofS =
        "\40\uffff";
    static final String DFA10_minS =
        "\1\11\11\uffff\1\56\3\uffff\1\0\3\uffff\1\55\2\uffff\1\52\4\uffff"+
        "\2\55\4\uffff";
    static final String DFA10_maxS =
        "\1\175\11\uffff\1\71\3\uffff\1\ufffe\3\uffff\1\172\2\uffff\1\57"+
        "\4\uffff\2\172\4\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\14\1\15"+
        "\1\16\1\uffff\1\20\1\21\1\22\1\uffff\1\26\1\27\1\uffff\1\12\1\13"+
        "\1\17\1\23\2\uffff\1\24\1\25\1\30\1\31";
    static final String DFA10_specialS =
        "\40\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\23\1\24\2\uffff\1\24\22\uffff\1\23\1\uffff\1\13\1\uffff\1"+
            "\1\1\uffff\1\7\1\uffff\1\14\1\15\1\uffff\1\5\1\uffff\1\3\1\uffff"+
            "\1\25\12\12\1\11\1\6\1\uffff\1\4\2\uffff\1\2\32\22\1\20\1\uffff"+
            "\1\21\3\uffff\32\22\1\16\1\10\1\17",
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
            "\uffff\31",
            "",
            "",
            "",
            "\1\35\2\32\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\36\4\uffff\1\37",
            "",
            "",
            "",
            "",
            "\1\35\2\32\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\35\2\32\12\33\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T25 | T26 | T27 | T28 | T29 | COLON | AND | OR | SEMI | NUMBER | IP4 | STRING | LOPEN | ROPEN | LCURLY | RCURLY | LBRACK | RBRACK | CURLY_STRING | NAME | DNAME | WS | NEWLINE | COMMENT | LINE_COMMENT );";
        }
    }
 

}