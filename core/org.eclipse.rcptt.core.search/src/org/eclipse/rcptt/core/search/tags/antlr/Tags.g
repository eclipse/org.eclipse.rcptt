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

// Override lexer to collect errors
@lexer::members {
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
}

// Override parser to collect errors
@parser::members {
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
}

// Lexer rules
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&' | 'AND' | 'and';
OR : '|' | 'OR' | 'or';
NOT : '!' | 'NOT' | 'not';
NAME : (~( ' ' | '\t' | '\r' | '\n' | '(' | ')' | '"' | '!' ))+ | '"'(~('"'))+'"' {setText(getText().substring(1, getText().length()-1).trim());};
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };

// Parser rules
expression : orexpression;
orexpression : andexpression (OR^ andexpression)*;
andexpression : notexpression (AND^ notexpression)*;
notexpression : NOT^ atom | atom;
atom : NAME | LPAREN! orexpression RPAREN!;
