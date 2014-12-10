grammar Tags;

options {
	language=Java;
	output=AST;
}

@lexer::header {
package org.eclipse.rcptt.core.search.tags.parser;
}
 
@parser::header {
package org.eclipse.rcptt.core.search.tags.parser;
}

// Override parser's reportError method
@parser::members {
// Override
public void reportError(RecognitionException e) {}
}

// Lexer rules
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&' | 'AND' | 'and';
OR : '|' | 'OR' | 'or';
NAME : (~( ' ' | '\t' | '\r' | '\n' | '(' | ')' | '"' ))+ | '"'(~('"'))+'"' {setText(getText().substring(1, getText().length()-1).trim());};
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };

// Parser rules
expression : orexpression;
orexpression : andexpression (OR^ andexpression)*;
andexpression : atom (AND^ atom)*;
atom : NAME | LPAREN! orexpression RPAREN!;
