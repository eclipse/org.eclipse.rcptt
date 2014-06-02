lexer grammar Ecl;
options {
  language=Java;

}
@members {  
  public void displayRecognitionError(String[] tokenNames,
      RecognitionException e) {
      throw new SyntaxErrorException(e.line, e.charPositionInLine);
  }
}
@header {
package org.eclipse.rcptt.ecl.internal.parser;
}

T25 : '$' ;
T26 : '@' ;
T27 : '-' ;
T28 : '=' ;
T29 : '+' ;

// $ANTLR src "Ecl.g" 354
COLON: ';';
// $ANTLR src "Ecl.g" 355
AND: '&';
// $ANTLR src "Ecl.g" 356
OR: '|';
// $ANTLR src "Ecl.g" 357
SEMI: ':';

// $ANTLR src "Ecl.g" 359
fragment DIGIT:
('0'..'9')
;

// $ANTLR src "Ecl.g" 363
NUMBER:
  DIGIT+ 
;

// TODO: Add number checking
// $ANTLR src "Ecl.g" 368
IP4:
  NUMBER '.' NUMBER '.' NUMBER '.' NUMBER
;
 
// $ANTLR src "Ecl.g" 381
STRING:
   '"' (~('"'|'\n'|'\\')|('\\' . ))* '"'
;

// $ANTLR src "Ecl.g" 385
protected
LOPEN  : '(';

// $ANTLR src "Ecl.g" 388
protected
ROPEN  : ')';

// $ANTLR src "Ecl.g" 391
protected
LCURLY  : '{';

// $ANTLR src "Ecl.g" 394
protected
RCURLY  : '}';

// $ANTLR src "Ecl.g" 397
protected
LBRACK  : '[';

// $ANTLR src "Ecl.g" 400
protected
RBRACK  : ']';

//CURLY_STRING:
//'{'(
//('(')=>CURLY_STRING | .
// )* '}'
//;

// $ANTLR src "Ecl.g" 409
CURLY_STRING: { int deep = 0; }
  LCURLY { deep += 1; }
  (
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
  }.)* 
  RCURLY
  { 
  if( deep > 1 ) {
    MismatchedTokenException e = new MismatchedTokenException(RCURLY,input);
    e.expecting='}';
    throw e;
  }
  }
;

// $ANTLR src "Ecl.g" 436
NAME:
 ('a'..'z'|'A'..'Z') (('a'..'z'|'A'..'Z'|'_'|'.'|'/')|DIGIT)*
; 

//COMMAND_NAME:
// ((NAME SEMI)? NAME ('::' NAME)+ ('-' NAME)*)
// | (d=NAME s=SEMI c=CURLY_STRING ) {
// 	$d.setType(NAME);
//	emit(d);
//	$s.setType(SEMI);
//	emit(s);
//	$c.setType(CURLY_STRING);
//	emit(c);
// }
//;
// $ANTLR src "Ecl.g" 451
DNAME:
	NAME ('-' NAME)+
;

// $ANTLR src "Ecl.g" 455
WS: (' '|'\t')+ 
{
  $channel=HIDDEN;
}
;

// $ANTLR src "Ecl.g" 461
NEWLINE: ('\r'|'\n')+
{
  $channel=HIDDEN;
}
;

// $ANTLR src "Ecl.g" 467
COMMENT: '/*' ( options {greedy=false;} : . )* '*/' {skip();}
;

// $ANTLR src "Ecl.g" 470
LINE_COMMENT: '//' ~('\n'|'\r')* {skip();}
;
