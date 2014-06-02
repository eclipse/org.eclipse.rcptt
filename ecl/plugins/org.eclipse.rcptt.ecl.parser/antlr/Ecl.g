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
		if (cmd instanceof Sequence) {
			Sequence seq = (Sequence) cmd;
			if (c2 != null) {
				seq.getCommands().add(c2);
			}
			return seq;
		}
		else {
			Sequence seq = factory.createSequence();
			seq.getCommands().add(cmd);
			seq.getCommands().add(c2);
			return seq;
		}
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
  
  private boolean lookupNL() {
    int index=input.index();
    int start=input.mark();
    
    if (index >= input.size()) {
      return true;
    }
    if(index < input.size())
    {
      if(input.get(index).getType() == RBRACK)
        return true;
      if(input.get(index).getType() == RCURLY)
        return true;
      if(input.get(index).getType() == ROPEN)
        return true;
    }
    Token token;
    boolean result=false;
    while (index > 0)
    {
      // look back in the hidden channel until we find a linebreak
      index--;
      token = input.get(index);
      if (token.getType() == EOF) {
        result=true;
        break;
      }
      if (token.getChannel() != Token.HIDDEN_CHANNEL)
      {
        /* We are out of the hidden channel, in other word we found a "real" item,
        which means we didn't find a linebreak, so we are done (false)
        */
        break;
      }
      if (token.getType() == NEWLINE)
      {
        // found our LineBreak (true)
        result=true;
        break;
      }
    }
    input.rewind(start);
    return result;
}
}
  
// Parser rules
commands returns[Command cmd=null;]:
	exprs=expr_list	{cmd=exprs;} EOF
;
expr_list returns [Command cmd=null]:
  {Sequence seq = factory.createSequence();} 
  ( c2=expression {seq.getCommands().add(c2);} )* 
  {
    if (seq.getCommands().size() == 1) {
      cmd = seq.getCommands().get(0);
    } else {
      cmd = seq;
    }
  }
;

expression returns[Command cmd=null;]: 
   c=and_expr {
   	cmd = c;
   }
   eos
;

eos
  :
    EOF
  | COLON
  | {lookupNL()}?;

and_expr returns [Command cmd=null;]: 
  or1=or_expr {cmd=or1;} (AND or2=or_expr{
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
  }  (OR cmd2=cmd {
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
  c = expression {
  	if( c != null ) {
  		cmd=c;
  	}
  } (c2=expression {
  	cmd = processSequence(cmd, c2);
  } )*
;

cmd returns [Command cmd=null;]:
 c=command {
	cmd = c;
 } |
 (LOPEN c=open_expr_list {
 	cmd = c; 
 } ROPEN) | '$' n=command_name {
  GetVal getVal = CoreFactory.eINSTANCE.createGetVal();
  getVal.setName(n);
  cmd = getVal;
 }
;

command returns[Exec cmd=null;]:
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
   (arg=argument {
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
  (LBRACK
    c=expr_list {
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
	(d=NAME|d=NUMBER|d2=string|d3=CURLY_STRING) { 
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
 ('-' '-'? n=NAME ('='? (v=argument_value))?) {
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
 (f=NAME SEMI v=CURLY_STRING) {
 		LiteralParameter p = factory.createLiteralParameter();
 		String value = v.getText();
  		p.setLiteral(value.substring(1, value.length()-1));
  		p.setFormat(f.getText());
	  	param = p;
 }
;

 
// Lexer
COLON: ';';
AND: '&';
OR: '|';
SEMI: ':';

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
  ('+' r=STRING 
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

//CURLY_STRING:
//'{'(
//('(')=>CURLY_STRING | .
// )* '}'
//;

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
DNAME:
	NAME ('-' NAME)+
;

WS: (' '|'\t')+ 
{
  $channel=HIDDEN;
}
;

NEWLINE: ('\r'|'\n')+
{
  $channel=HIDDEN;
}
;

COMMENT: '/*' ( options {greedy=false;} : . )* '*/' {skip();}
;

LINE_COMMENT: '//' ~('\n'|'\r')* {skip();}
;
