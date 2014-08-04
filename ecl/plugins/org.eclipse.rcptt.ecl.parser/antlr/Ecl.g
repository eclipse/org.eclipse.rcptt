grammar Ecl;

options {
//  output=AST;
	k=2;
	language=Java;
}

// applies only to the parser:
@header {
package org.eclipse.rcptt.ecl.internal.parser;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.GetVal;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parallel;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.gen.ast.AstFactory;
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.gen.ast.AstLiteral;
}

// applies only to the lexer:
@lexer::header {
package org.eclipse.rcptt.ecl.internal.parser;
}
@lexer::members {  
  public void displayRecognitionError(String[] tokenNames,
      RecognitionException e) {
      throw new SyntaxErrorException(e.line, e.charPositionInLine);
  }
}


@members {  
    CoreFactory factory = CoreFactory.eINSTANCE;  
    Command processSequence(Command cmd, Command c2 ) {
            //Construct sequence if not yet constructed.
            if (cmd == null)
                return c2;
            Sequence seq; 
            if (cmd instanceof Sequence) {
                    seq = (Sequence) cmd;
            } else {
              seq = factory.createSequence();
              seq.getCommands().add(cmd);
            }
            if (c2 instanceof Sequence) {
              seq.getCommands().addAll(((Sequence) c2).getCommands());
            } else {
              seq.getCommands().add(c2);
            }
          return seq;
    } 
	
    public void displayRecognitionError(String[] tokenNames,
        RecognitionException e) {
              if (e.token.getType() == Token.EOF) {
                Token prev = getTokenStream().get(e.index - 1);
                throw new SyntaxErrorException(prev.getLine(),
                    prev.getCharPositionInLine());
              }
        throw new SyntaxErrorException(e.line, e.charPositionInLine);
    }  
}
  
// Parser rules
eos: (NEWLINE | SEMICOLON) +;
commands returns[Command cmd=null;]:
	eos* exprs=open_expr_list	{cmd=exprs;} eos* EOF
        {
            if (cmd == null)
                cmd =factory.createSequence();
        }
;

expression returns[Command cmd=null;]: 
   c=and_expr {
   	cmd = c;
   }
;

and_expr returns [Command cmd=null;]: 
  or1=or_expr {cmd=or1;} ( NEWLINE? AND NEWLINE? or2=or_expr{
  	//Construct parallel if not yet constructed.
	if (cmd instanceof Parallel) {
		Parallel par = (Parallel) cmd;
		if (or2 != null) {
			par.getCommands().add(or2);
		}
		cmd = par;
	}
	else {
		Parallel par = factory.createParallel();
		par.getCommands().add(cmd);
		par.getCommands().add(or2);
		cmd = par;
	}
  })*
;

or_expr returns [Command cmd=null;]: 
  c = cmd {
  cmd = c;
  }  ( NEWLINE? OR NEWLINE? cmd2=cmd {
  	//Construct pipe if not yet constructed.
	if (cmd instanceof Pipeline) {
		Pipeline pipe = (Pipeline) cmd;
		if (cmd2 != null) {
			pipe.getCommands().add(cmd2);
		}
		cmd = pipe;
	}
	else {
		Pipeline pipe = factory.createPipeline();
		pipe.getCommands().add(cmd);
		pipe.getCommands().add(cmd2);
		cmd = pipe;
	}
  })*
;

open_expr_list returns [Command cmd=null]:
    (
       c = one_or_more_expr {cmd = c;} 
    )?
    {
        if (cmd == null)
            cmd =factory.createSequence();
    }
 ;

one_or_more_expr returns [Command cmd=null]:
    c = expression {cmd = processSequence(cmd, c);} 
    (eos+ c2 = one_or_more_expr {cmd = processSequence(cmd, c2);})?
;


cmd returns [Command cmd=null;]:
 c=named_command {
	cmd = c;
 } |
 (LOPEN c=open_expr_list {
 	cmd = c; 
 } ROPEN) | ('$' n=command_name {
   GetVal getVal = CoreFactory.eINSTANCE.createGetVal();
   getVal.setName(n);
   cmd = getVal;
 })
;

named_command returns[Exec cmd=null;]:
  {
    Token t = input.LT(1);
    int line = t.getLine();
    int column = t.getCharPositionInLine();
  }
   n=command_name {
   	AstExec exec = AstFactory.eINSTANCE.createAstExec();
   	exec.setLine(line);
    exec.setColumn(column + 1);
    cmd = exec;
   	int index = n.lastIndexOf("::");
   	if( index == -1 ) {
   		cmd.setName(n);
   	}
   	else {
   		cmd.setNamespace(n.substring(0, index));
   		cmd.setName(n.substring(index+2));
   	}
   } 
   (ho=host {
		cmd.setHost(ho);
   })?
   (a=argument_value {
   	if( a != null ) {
 		cmd.getParameters().add(a);
   	}
   })* 
   (NEWLINE? MINUS MINUS? arg=argument {
   	if( arg != null ) {
 		cmd.getParameters().add(arg);
   	}
   })*
  {
    t = input.LT(-1);
    int end = t.getCharPositionInLine()+t.getText().length();
    int length = end - column;
    exec.setLength(length);
  }
;

subcommand returns[Parameter param=null;]:
  (NEWLINE? LBRACK
    c=open_expr_list {
    	ExecutableParameter p = factory.createExecutableParameter();
  		p.setCommand(c);
	  	param = p;
    }
  RBRACK) | '$' name=command_name {
    ExecutableParameter p = factory.createExecutableParameter();
    GetVal cmd = CoreFactory.eINSTANCE.createGetVal();
    cmd.setName(name);
    p.setCommand(cmd);
    param = p;
  }
; 

command_name returns[String name=null;]:
 (n = NAME |/*n=COMMAND_NAME|*/ n=DNAME) { name = n.getText(); }
;
 
host returns [String host=null;]:
 ('@' (n=NAME|n=IP4)) {
 	host = n.getText();
 }
;

argument returns [Parameter param = null]:
   (p=named_argument) { param = p; }
;
argument_value returns [Parameter param=null;]:
  (p = simple_value | p= subcommand | p = convert_string) {
  	param = p;
  }
;
simple_value returns[Parameter param = null;]:
	(d=NAME|d=NUMBER|NEWLINE? d2=string|NEWLINE? d3=CURLY_STRING) { 
    AstLiteral literal = AstFactory.eINSTANCE.createAstLiteral();
    Token t = input.LT(-1);    
    literal.setLine(t.getLine());
    literal.setColumn(t.getCharPositionInLine());
    literal.setLength(t.getText().length());
		LiteralParameter p = literal;
		if( d != null ) {
  			p.setLiteral(d.getText());
  		}
  		else if( d2 != null ) {
        String value = d2;
        StringBuilder result = new StringBuilder(value.length());
        loop: for (int i = 0; i < value.length(); i++){
          char ch = value.charAt(i);
          if (ch == '\\'){
            if (i+1 >= value.length())
              throw new SyntaxErrorException(1, 1, "Invalid escape sequence");
            switch(value.charAt(i+1)){
              case 't': result.append("\t"); i++; continue loop;
              case 'b': result.append("\b"); i++; continue loop;
              case 'n': result.append("\n"); i++; continue loop;
              case 'r': result.append("\r"); i++; continue loop;
              case 'f': result.append("\f"); i++; continue loop;
              case '\'': result.append("'"); i++; continue loop;
              case '"': result.append("\""); i++; continue loop;
              case '\\': result.append("\\"); i++; continue loop;
            }
          }
          result.append(ch);
        }                      
        p.setLiteral(result.toString());
  		}
      else if( d3 != null ) {
        String text = d3.getText();
        p.setLiteral(text.substring(1, text.length()-1));
      }
	  	param = p;
	}
;
named_argument returns [Parameter param=null;]: 
 (n=NAME ('='? (v=argument_value))?) {
  if (v == null){    
    LiteralParameter l = factory.createLiteralParameter();
    l.setLiteral("true");
    param=l;
  } else {
    param=v;
  }
  param.setName(n.getText());
 }
;

convert_string returns [Parameter param=null;]:
 (f=NAME COLON v=CURLY_STRING) {
 		LiteralParameter p = factory.createLiteralParameter();
 		String value = v.getText();
  		p.setLiteral(value.substring(1, value.length()-1));
  		p.setFormat(f.getText());
	  	param = p;
 }
;

 
// Lexer
SEMICOLON: ';';
AND: '&';
OR: '|';
COLON: ':';

fragment DIGIT:
('0'..'9')
;

NUMBER:
  DIGIT+ 
;

// TODO: Add number checking
IP4:
  NUMBER '.' NUMBER '.' NUMBER '.' NUMBER
;
 
string returns [String s = null]:
  f=STRING  {StringBuilder sb = 
    new StringBuilder(f.getText().substring(1, f.getText().length()-1));}
  (NEWLINE? '+' NEWLINE? r=STRING 
    {sb.append(r.getText().substring(1, r.getText().length()-1));}
  )*
  {s = sb.toString();}
  ;
 
STRING:
   '"' (~('"'|'\n'|'\\')|('\\' . ))* '"'
;

protected
LOPEN  : '(';

protected
ROPEN  : ')';

protected
LCURLY  : '{';

protected
RCURLY  : '}';

protected
LBRACK  : '[';

protected
RBRACK  : ']';

protected
MINUS : '-';

CURLY_STRING:
  LCURLY 
  (
    CURLY_STRING | 
    LINE_COMMENT | 
    COMMENT | 
    STRING |
    '/'? ~('/' | '{' | '}' | '*' | '"')+ '*'?
  )*
  RCURLY
;

NAME:
 ('a'..'z'|'A'..'Z') (('a'..'z'|'A'..'Z'|'_'|'.'|'/')|DIGIT)*
; 

DNAME:
	NAME (MINUS NAME)+
;

WS: (' '|'\t')+ {$channel=HIDDEN;}
;

COMMENT: '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
;

LINE_COMMENT: '//' ~('\n'|'\r')* {$channel=HIDDEN;}
;

NEWLINE: (('\r'|'\n')+ (COMMENT|LINE_COMMENT|WS)*)+
;

