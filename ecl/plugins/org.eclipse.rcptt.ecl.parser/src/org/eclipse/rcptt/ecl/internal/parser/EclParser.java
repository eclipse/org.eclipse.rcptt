/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
// $ANTLR 3.5.2 Ecl.g 2015-01-29 20:14:24

package org.eclipse.rcptt.ecl.internal.parser;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
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
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.gen.ast.AstFactory;
import org.eclipse.rcptt.ecl.gen.ast.AstLiteral;

@SuppressWarnings("all")
public class EclParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "COLON", "COMMENT", "CURLY_STRING",
		"DIGIT", "DNAME", "IP4", "LBRACK", "LCURLY", "LINE_COMMENT", "LOPEN",
		"MINUS", "NAME", "NEWLINE", "NUMBER", "OR", "RBRACK", "RCURLY", "ROPEN",
		"SEMICOLON", "STRING", "WS", "'$'", "'+'", "'='", "'@'"
	};
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EclParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EclParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EclParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Ecl.g"; }

	  
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
		
	    @Override
		public void displayRecognitionError(String[] tokenNames,
	        RecognitionException e) {
	              if (e.token.getType() == Token.EOF) {
	                Token prev = getTokenStream().get(e.index - 1);
	                throw new SyntaxErrorException(prev.getLine(),
	                    prev.getCharPositionInLine());
	              }
	        throw new SyntaxErrorException(e.line, e.charPositionInLine);
	    }



	// $ANTLR start "eos"
	// Ecl.g:79:1: eos : ( NEWLINE | SEMICOLON )+ ;
	public final void eos() throws RecognitionException {
		try {
			// Ecl.g:79:4: ( ( NEWLINE | SEMICOLON )+ )
			// Ecl.g:79:6: ( NEWLINE | SEMICOLON )+
			{
			// Ecl.g:79:6: ( NEWLINE | SEMICOLON )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==NEWLINE||LA1_0==SEMICOLON) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Ecl.g:
					{
					if ( input.LA(1)==NEWLINE||input.LA(1)==SEMICOLON ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "eos"



	// $ANTLR start "commands"
	// Ecl.g:80:1: commands returns [Command cmd=null;] : ( eos )* exprs= open_expr_list ( eos )* EOF ;
	public final Command commands() throws RecognitionException {
		Command cmd = null;;


		Command exprs =null;

		try {
			// Ecl.g:80:36: ( ( eos )* exprs= open_expr_list ( eos )* EOF )
			// Ecl.g:81:2: ( eos )* exprs= open_expr_list ( eos )* EOF
			{
			// Ecl.g:81:2: ( eos )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==NEWLINE||LA2_0==SEMICOLON) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Ecl.g:81:2: eos
					{
					pushFollow(FOLLOW_eos_in_commands80);
					eos();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			pushFollow(FOLLOW_open_expr_list_in_commands85);
			exprs=open_expr_list();
			state._fsp--;

			cmd=exprs;
			// Ecl.g:81:41: ( eos )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==NEWLINE||LA3_0==SEMICOLON) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Ecl.g:81:41: eos
					{
					pushFollow(FOLLOW_eos_in_commands89);
					eos();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_commands92);

			            if (cmd == null)
			                cmd =factory.createSequence();
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "commands"



	// $ANTLR start "expression"
	// Ecl.g:88:1: expression returns [Command cmd=null;] : c= and_expr ;
	public final Command expression() throws RecognitionException {
		Command cmd = null;;


		Command c =null;

		try {
			// Ecl.g:88:38: (c= and_expr )
			// Ecl.g:89:4: c= and_expr
			{
			pushFollow(FOLLOW_and_expr_in_expression119);
			c=and_expr();
			state._fsp--;


			   	cmd = c;
			   
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "expression"



	// $ANTLR start "and_expr"
	// Ecl.g:94:1: and_expr returns [Command cmd=null;] : or1= or_expr ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )* ;
	public final Command and_expr() throws RecognitionException {
		Command cmd = null;;


		Command or1 =null;
		Command or2 =null;

		try {
			// Ecl.g:94:37: (or1= or_expr ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )* )
			// Ecl.g:95:3: or1= or_expr ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )*
			{
			pushFollow(FOLLOW_or_expr_in_and_expr138);
			or1=or_expr();
			state._fsp--;

			cmd=or1;
			// Ecl.g:95:26: ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==NEWLINE) ) {
					int LA6_1 = input.LA(2);
					if ( (LA6_1==AND) ) {
						alt6=1;
					}

				}
				else if ( (LA6_0==AND) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Ecl.g:95:28: ( NEWLINE )? AND ( NEWLINE )? or2= or_expr
					{
					// Ecl.g:95:28: ( NEWLINE )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==NEWLINE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// Ecl.g:95:28: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_and_expr144);
							}
							break;

					}

					match(input,AND,FOLLOW_AND_in_and_expr147);
					// Ecl.g:95:41: ( NEWLINE )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==NEWLINE) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// Ecl.g:95:41: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_and_expr149);
							}
							break;

					}

					pushFollow(FOLLOW_or_expr_in_and_expr154);
					or2=or_expr();
					state._fsp--;


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
					  
					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "and_expr"



	// $ANTLR start "or_expr"
	// Ecl.g:113:1: or_expr returns [Command cmd=null;] : c= cmd ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )* ;
	public final Command or_expr() throws RecognitionException {
		Command cmd = null;;


		Command c =null;
		Command cmd2 =null;

		try {
			// Ecl.g:113:36: (c= cmd ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )* )
			// Ecl.g:114:3: c= cmd ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )*
			{
			pushFollow(FOLLOW_cmd_in_or_expr176);
			c=cmd();
			state._fsp--;


			  cmd = c;
			  
			// Ecl.g:116:6: ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==NEWLINE) ) {
					int LA9_1 = input.LA(2);
					if ( (LA9_1==OR) ) {
						alt9=1;
					}

				}
				else if ( (LA9_0==OR) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Ecl.g:116:8: ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd
					{
					// Ecl.g:116:8: ( NEWLINE )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==NEWLINE) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// Ecl.g:116:8: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_or_expr183);
							}
							break;

					}

					match(input,OR,FOLLOW_OR_in_or_expr186);
					// Ecl.g:116:20: ( NEWLINE )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==NEWLINE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// Ecl.g:116:20: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_or_expr188);
							}
							break;

					}

					pushFollow(FOLLOW_cmd_in_or_expr193);
					cmd2=cmd();
					state._fsp--;


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
					  
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "or_expr"



	// $ANTLR start "open_expr_list"
	// Ecl.g:134:1: open_expr_list returns [Command cmd=null] : (c= one_or_more_expr )? ;
	public final Command open_expr_list() throws RecognitionException {
		Command cmd = null;


		Command c =null;

		try {
			// Ecl.g:134:42: ( (c= one_or_more_expr )? )
			// Ecl.g:135:5: (c= one_or_more_expr )?
			{
			// Ecl.g:135:5: (c= one_or_more_expr )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==DNAME||LA10_0==LOPEN||LA10_0==NAME||LA10_0==26) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// Ecl.g:136:8: c= one_or_more_expr
					{
					pushFollow(FOLLOW_one_or_more_expr_in_open_expr_list226);
					c=one_or_more_expr();
					state._fsp--;

					cmd = c;
					}
					break;

			}


			        if (cmd == null)
			            cmd =factory.createSequence();
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "open_expr_list"



	// $ANTLR start "one_or_more_expr"
	// Ecl.g:144:1: one_or_more_expr returns [Command cmd=null] : c= expression ( ( eos )+ c2= one_or_more_expr )? ;
	public final Command one_or_more_expr() throws RecognitionException {
		Command cmd = null;


		Command c =null;
		Command c2 =null;

		try {
			// Ecl.g:144:44: (c= expression ( ( eos )+ c2= one_or_more_expr )? )
			// Ecl.g:145:5: c= expression ( ( eos )+ c2= one_or_more_expr )?
			{
			pushFollow(FOLLOW_expression_in_one_or_more_expr263);
			c=expression();
			state._fsp--;

			cmd = processSequence(cmd, c);
			// Ecl.g:146:5: ( ( eos )+ c2= one_or_more_expr )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==NEWLINE) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==DNAME||LA12_1==LOPEN||LA12_1==NAME||LA12_1==26) ) {
					alt12=1;
				}
				else if ( (LA12_1==NEWLINE||LA12_1==SEMICOLON) ) {
					alt12=1;
				}
			}
			else if ( (LA12_0==SEMICOLON) ) {
				int LA12_4 = input.LA(2);
				if ( (LA12_4==DNAME||LA12_4==LOPEN||LA12_4==NAME||LA12_4==26) ) {
					alt12=1;
				}
				else if ( (LA12_4==NEWLINE||LA12_4==SEMICOLON) ) {
					alt12=1;
				}
			}
			switch (alt12) {
				case 1 :
					// Ecl.g:146:6: ( eos )+ c2= one_or_more_expr
					{
					// Ecl.g:146:6: ( eos )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==NEWLINE||LA11_0==SEMICOLON) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// Ecl.g:146:6: eos
							{
							pushFollow(FOLLOW_eos_in_one_or_more_expr273);
							eos();
							state._fsp--;

							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					pushFollow(FOLLOW_one_or_more_expr_in_one_or_more_expr280);
					c2=one_or_more_expr();
					state._fsp--;

					cmd = processSequence(cmd, c2);
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "one_or_more_expr"



	// $ANTLR start "cmd"
	// Ecl.g:150:1: cmd returns [Command cmd=null;] : (c= named_command | ( LOPEN c= open_expr_list ROPEN ) | ( '$' n= command_name ) );
	public final Command cmd() throws RecognitionException {
		Command cmd = null;;


		Command c =null;
		String n =null;

		try {
			// Ecl.g:150:32: (c= named_command | ( LOPEN c= open_expr_list ROPEN ) | ( '$' n= command_name ) )
			int alt13=3;
			switch ( input.LA(1) ) {
			case DNAME:
			case NAME:
				{
				alt13=1;
				}
				break;
			case LOPEN:
				{
				alt13=2;
				}
				break;
			case 26:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// Ecl.g:151:2: c= named_command
					{
					pushFollow(FOLLOW_named_command_in_cmd300);
					c=named_command();
					state._fsp--;


						cmd = c;
					 
					}
					break;
				case 2 :
					// Ecl.g:154:2: ( LOPEN c= open_expr_list ROPEN )
					{
					// Ecl.g:154:2: ( LOPEN c= open_expr_list ROPEN )
					// Ecl.g:154:3: LOPEN c= open_expr_list ROPEN
					{
					match(input,LOPEN,FOLLOW_LOPEN_in_cmd308);
					pushFollow(FOLLOW_open_expr_list_in_cmd312);
					c=open_expr_list();
					state._fsp--;


					 	cmd = c;
					 
					match(input,ROPEN,FOLLOW_ROPEN_in_cmd316);
					}

					}
					break;
				case 3 :
					// Ecl.g:156:13: ( '$' n= command_name )
					{
					// Ecl.g:156:13: ( '$' n= command_name )
					// Ecl.g:156:14: '$' n= command_name
					{
					match(input,26,FOLLOW_26_in_cmd322);
					pushFollow(FOLLOW_command_name_in_cmd326);
					n=command_name();
					state._fsp--;


					   GetVal getVal = CoreFactory.eINSTANCE.createGetVal();
					   getVal.setName(n);
					   cmd = getVal;
					 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "cmd"



	// $ANTLR start "named_command"
	// Ecl.g:163:1: named_command returns [Exec cmd=null;] :n= command_name (ho= host )? (a= argument_value )* ( ( NEWLINE )? MINUS ( MINUS )? arg= argument )* ;
	public final Exec named_command() throws RecognitionException {
		Exec cmd = null;;


		String n =null;
		String ho =null;
		Parameter a =null;
		Parameter arg =null;

		try {
			// Ecl.g:163:38: (n= command_name (ho= host )? (a= argument_value )* ( ( NEWLINE )? MINUS ( MINUS )? arg= argument )* )
			// Ecl.g:164:3: n= command_name (ho= host )? (a= argument_value )* ( ( NEWLINE )? MINUS ( MINUS )? arg= argument )*
			{

			    Token t = input.LT(1);
			    int line = t.getLine();
			    int column = t.getCharPositionInLine();
			  
			pushFollow(FOLLOW_command_name_in_named_command349);
			n=command_name();
			state._fsp--;


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
			   
			// Ecl.g:183:4: (ho= host )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==29) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// Ecl.g:183:5: ho= host
					{
					pushFollow(FOLLOW_host_in_named_command360);
					ho=host();
					state._fsp--;


							cmd.setHost(ho);
					   
					}
					break;

			}

			// Ecl.g:186:4: (a= argument_value )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==NEWLINE) ) {
					int LA15_1 = input.LA(2);
					if ( (LA15_1==CURLY_STRING||LA15_1==LBRACK||LA15_1==STRING) ) {
						alt15=1;
					}

				}
				else if ( (LA15_0==CURLY_STRING||LA15_0==LBRACK||LA15_0==NAME||LA15_0==NUMBER||LA15_0==STRING||LA15_0==26) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// Ecl.g:186:5: a= argument_value
					{
					pushFollow(FOLLOW_argument_value_in_named_command372);
					a=argument_value();
					state._fsp--;


					   	if( a != null ) {
					 		cmd.getParameters().add(a);
					   	}
					   
					}
					break;

				default :
					break loop15;
				}
			}

			// Ecl.g:191:4: ( ( NEWLINE )? MINUS ( MINUS )? arg= argument )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==NEWLINE) ) {
					int LA18_1 = input.LA(2);
					if ( (LA18_1==MINUS) ) {
						alt18=1;
					}

				}
				else if ( (LA18_0==MINUS) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// Ecl.g:191:5: ( NEWLINE )? MINUS ( MINUS )? arg= argument
					{
					// Ecl.g:191:5: ( NEWLINE )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==NEWLINE) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// Ecl.g:191:5: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_named_command383);
							}
							break;

					}

					match(input,MINUS,FOLLOW_MINUS_in_named_command386);
					// Ecl.g:191:20: ( MINUS )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==MINUS) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// Ecl.g:191:20: MINUS
							{
							match(input,MINUS,FOLLOW_MINUS_in_named_command388);
							}
							break;

					}

					pushFollow(FOLLOW_argument_in_named_command393);
					arg=argument();
					state._fsp--;


					   	if( arg != null ) {
					 		cmd.getParameters().add(arg);
					   	}
					   
					}
					break;

				default :
					break loop18;
				}
			}


			    t = input.LT(-1);
			    int end = t.getCharPositionInLine()+t.getText().length();
			    int length = end - column;
			    exec.setLength(length);
			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cmd;
	}
	// $ANTLR end "named_command"



	// $ANTLR start "subcommand"
	// Ecl.g:204:1: subcommand returns [Parameter param=null;] : ( ( ( NEWLINE )? LBRACK ( NEWLINE )? c= open_expr_list ( NEWLINE )? RBRACK ) | '$' name= command_name );
	public final Parameter subcommand() throws RecognitionException {
		Parameter param = null;;


		Command c =null;
		String name =null;

		try {
			// Ecl.g:204:42: ( ( ( NEWLINE )? LBRACK ( NEWLINE )? c= open_expr_list ( NEWLINE )? RBRACK ) | '$' name= command_name )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==LBRACK||LA22_0==NEWLINE) ) {
				alt22=1;
			}
			else if ( (LA22_0==26) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// Ecl.g:205:3: ( ( NEWLINE )? LBRACK ( NEWLINE )? c= open_expr_list ( NEWLINE )? RBRACK )
					{
					// Ecl.g:205:3: ( ( NEWLINE )? LBRACK ( NEWLINE )? c= open_expr_list ( NEWLINE )? RBRACK )
					// Ecl.g:205:4: ( NEWLINE )? LBRACK ( NEWLINE )? c= open_expr_list ( NEWLINE )? RBRACK
					{
					// Ecl.g:205:4: ( NEWLINE )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==NEWLINE) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// Ecl.g:205:4: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_subcommand415);
							}
							break;

					}

					match(input,LBRACK,FOLLOW_LBRACK_in_subcommand418);
					// Ecl.g:205:20: ( NEWLINE )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==NEWLINE) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// Ecl.g:205:20: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_subcommand420);
							}
							break;

					}

					pushFollow(FOLLOW_open_expr_list_in_subcommand429);
					c=open_expr_list();
					state._fsp--;


					    	ExecutableParameter p = factory.createExecutableParameter();
					  		p.setCommand(c);
						  	param = p;
					    
					// Ecl.g:211:3: ( NEWLINE )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==NEWLINE) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// Ecl.g:211:3: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_subcommand435);
							}
							break;

					}

					match(input,RBRACK,FOLLOW_RBRACK_in_subcommand438);
					}

					}
					break;
				case 2 :
					// Ecl.g:211:22: '$' name= command_name
					{
					match(input,26,FOLLOW_26_in_subcommand443);
					pushFollow(FOLLOW_command_name_in_subcommand447);
					name=command_name();
					state._fsp--;


					    ExecutableParameter p = factory.createExecutableParameter();
					    GetVal cmd = CoreFactory.eINSTANCE.createGetVal();
					    cmd.setName(name);
					    p.setCommand(cmd);
					    param = p;
					  
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "subcommand"



	// $ANTLR start "command_name"
	// Ecl.g:220:1: command_name returns [String name=null;] : (n= NAME |n= DNAME ) ;
	public final String command_name() throws RecognitionException {
		String name = null;;


		Token n=null;

		try {
			// Ecl.g:220:40: ( (n= NAME |n= DNAME ) )
			// Ecl.g:221:2: (n= NAME |n= DNAME )
			{
			// Ecl.g:221:2: (n= NAME |n= DNAME )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==NAME) ) {
				alt23=1;
			}
			else if ( (LA23_0==DNAME) ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// Ecl.g:221:3: n= NAME
					{
					n=(Token)match(input,NAME,FOLLOW_NAME_in_command_name467);
					}
					break;
				case 2 :
					// Ecl.g:221:33: n= DNAME
					{
					n=(Token)match(input,DNAME,FOLLOW_DNAME_in_command_name474);
					}
					break;

			}

			 name = n.getText();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return name;
	}
	// $ANTLR end "command_name"



	// $ANTLR start "host"
	// Ecl.g:224:1: host returns [String host=null;] : ( '@' (n= NAME |n= IP4 ) ) ;
	public final String host() throws RecognitionException {
		String host = null;;


		Token n=null;

		try {
			// Ecl.g:224:33: ( ( '@' (n= NAME |n= IP4 ) ) )
			// Ecl.g:225:2: ( '@' (n= NAME |n= IP4 ) )
			{
			// Ecl.g:225:2: ( '@' (n= NAME |n= IP4 ) )
			// Ecl.g:225:3: '@' (n= NAME |n= IP4 )
			{
			match(input,29,FOLLOW_29_in_host492);
			// Ecl.g:225:7: (n= NAME |n= IP4 )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==NAME) ) {
				alt24=1;
			}
			else if ( (LA24_0==IP4) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// Ecl.g:225:8: n= NAME
					{
					n=(Token)match(input,NAME,FOLLOW_NAME_in_host497);
					}
					break;
				case 2 :
					// Ecl.g:225:15: n= IP4
					{
					n=(Token)match(input,IP4,FOLLOW_IP4_in_host501);
					}
					break;

			}

			}


			 	host = n.getText();
			 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return host;
	}
	// $ANTLR end "host"



	// $ANTLR start "argument"
	// Ecl.g:230:1: argument returns [Parameter param = null] : (p= named_argument ) ;
	public final Parameter argument() throws RecognitionException {
		Parameter param =  null;


		Parameter p =null;

		try {
			// Ecl.g:230:42: ( (p= named_argument ) )
			// Ecl.g:231:4: (p= named_argument )
			{
			// Ecl.g:231:4: (p= named_argument )
			// Ecl.g:231:5: p= named_argument
			{
			pushFollow(FOLLOW_named_argument_in_argument523);
			p=named_argument();
			state._fsp--;

			}

			 param = p;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "argument"



	// $ANTLR start "argument_value"
	// Ecl.g:233:1: argument_value returns [Parameter param=null;] : (p= simple_value |p= subcommand |p= convert_string ) ;
	public final Parameter argument_value() throws RecognitionException {
		Parameter param = null;;


		Parameter p =null;

		try {
			// Ecl.g:233:47: ( (p= simple_value |p= subcommand |p= convert_string ) )
			// Ecl.g:234:3: (p= simple_value |p= subcommand |p= convert_string )
			{
			// Ecl.g:234:3: (p= simple_value |p= subcommand |p= convert_string )
			int alt25=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				int LA25_1 = input.LA(2);
				if ( (LA25_1==COLON) ) {
					alt25=3;
				}
				else if ( (LA25_1==EOF||LA25_1==AND||LA25_1==CURLY_STRING||LA25_1==LBRACK||(LA25_1 >= MINUS && LA25_1 <= RBRACK)||(LA25_1 >= ROPEN && LA25_1 <= STRING)||LA25_1==26) ) {
					alt25=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 25, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CURLY_STRING:
			case NUMBER:
			case STRING:
				{
				alt25=1;
				}
				break;
			case NEWLINE:
				{
				int LA25_3 = input.LA(2);
				if ( (LA25_3==CURLY_STRING||LA25_3==STRING) ) {
					alt25=1;
				}
				else if ( (LA25_3==LBRACK) ) {
					alt25=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 25, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LBRACK:
			case 26:
				{
				alt25=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// Ecl.g:234:4: p= simple_value
					{
					pushFollow(FOLLOW_simple_value_in_argument_value544);
					p=simple_value();
					state._fsp--;

					}
					break;
				case 2 :
					// Ecl.g:234:23: p= subcommand
					{
					pushFollow(FOLLOW_subcommand_in_argument_value551);
					p=subcommand();
					state._fsp--;

					}
					break;
				case 3 :
					// Ecl.g:234:39: p= convert_string
					{
					pushFollow(FOLLOW_convert_string_in_argument_value559);
					p=convert_string();
					state._fsp--;

					}
					break;

			}


			  	param = p;
			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "argument_value"



	// $ANTLR start "simple_value"
	// Ecl.g:238:1: simple_value returns [Parameter param = null;] : (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING ) ;
	public final Parameter simple_value() throws RecognitionException {
		Parameter param =  null;;


		Token d=null;
		Token d3=null;
		String d2 =null;

		try {
			// Ecl.g:238:46: ( (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING ) )
			// Ecl.g:239:2: (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING )
			{
			// Ecl.g:239:2: (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING )
			int alt28=4;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt28=1;
				}
				break;
			case NUMBER:
				{
				alt28=2;
				}
				break;
			case NEWLINE:
				{
				int LA28_3 = input.LA(2);
				if ( (LA28_3==STRING) ) {
					alt28=3;
				}
				else if ( (LA28_3==CURLY_STRING) ) {
					alt28=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 28, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STRING:
				{
				alt28=3;
				}
				break;
			case CURLY_STRING:
				{
				alt28=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// Ecl.g:239:3: d= NAME
					{
					d=(Token)match(input,NAME,FOLLOW_NAME_in_simple_value576);
					}
					break;
				case 2 :
					// Ecl.g:239:10: d= NUMBER
					{
					d=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_simple_value580);
					}
					break;
				case 3 :
					// Ecl.g:239:19: ( NEWLINE )? d2= string
					{
					// Ecl.g:239:19: ( NEWLINE )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==NEWLINE) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// Ecl.g:239:19: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_simple_value582);
							}
							break;

					}

					pushFollow(FOLLOW_string_in_simple_value587);
					d2=string();
					state._fsp--;

					}
					break;
				case 4 :
					// Ecl.g:239:38: ( NEWLINE )? d3= CURLY_STRING
					{
					// Ecl.g:239:38: ( NEWLINE )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==NEWLINE) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// Ecl.g:239:38: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_simple_value589);
							}
							break;

					}

					d3=(Token)match(input,CURLY_STRING,FOLLOW_CURLY_STRING_in_simple_value594);
					}
					break;

			}

			 
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "simple_value"



	// $ANTLR start "named_argument"
	// Ecl.g:279:1: named_argument returns [Parameter param=null;] : (n= NAME ( ( '=' )? (v= argument_value ) )? ) ;
	public final Parameter named_argument() throws RecognitionException {
		Parameter param = null;;


		Token n=null;
		Parameter v =null;

		try {
			// Ecl.g:279:47: ( (n= NAME ( ( '=' )? (v= argument_value ) )? ) )
			// Ecl.g:280:2: (n= NAME ( ( '=' )? (v= argument_value ) )? )
			{
			// Ecl.g:280:2: (n= NAME ( ( '=' )? (v= argument_value ) )? )
			// Ecl.g:280:3: n= NAME ( ( '=' )? (v= argument_value ) )?
			{
			n=(Token)match(input,NAME,FOLLOW_NAME_in_named_argument613);
			// Ecl.g:280:10: ( ( '=' )? (v= argument_value ) )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==CURLY_STRING||LA30_0==LBRACK||LA30_0==NAME||LA30_0==NUMBER||LA30_0==STRING||LA30_0==26||LA30_0==28) ) {
				alt30=1;
			}
			else if ( (LA30_0==NEWLINE) ) {
				int LA30_4 = input.LA(2);
				if ( (LA30_4==CURLY_STRING||LA30_4==LBRACK||LA30_4==STRING) ) {
					alt30=1;
				}
			}
			switch (alt30) {
				case 1 :
					// Ecl.g:280:11: ( '=' )? (v= argument_value )
					{
					// Ecl.g:280:11: ( '=' )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==28) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// Ecl.g:280:11: '='
							{
							match(input,28,FOLLOW_28_in_named_argument616);
							}
							break;

					}

					// Ecl.g:280:16: (v= argument_value )
					// Ecl.g:280:17: v= argument_value
					{
					pushFollow(FOLLOW_argument_value_in_named_argument622);
					v=argument_value();
					state._fsp--;

					}

					}
					break;

			}

			}


			  if (v == null){
			    LiteralParameter l = factory.createLiteralParameter();
			    l.setLiteral("true");
			    param=l;
			  } else {
			    param=v;
			  }
			  param.setName(n.getText());
			 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "named_argument"



	// $ANTLR start "convert_string"
	// Ecl.g:292:1: convert_string returns [Parameter param=null;] : (f= NAME COLON v= CURLY_STRING ) ;
	public final Parameter convert_string() throws RecognitionException {
		Parameter param = null;;


		Token f=null;
		Token v=null;

		try {
			// Ecl.g:292:47: ( (f= NAME COLON v= CURLY_STRING ) )
			// Ecl.g:293:2: (f= NAME COLON v= CURLY_STRING )
			{
			// Ecl.g:293:2: (f= NAME COLON v= CURLY_STRING )
			// Ecl.g:293:3: f= NAME COLON v= CURLY_STRING
			{
			f=(Token)match(input,NAME,FOLLOW_NAME_in_convert_string644);
			match(input,COLON,FOLLOW_COLON_in_convert_string646);
			v=(Token)match(input,CURLY_STRING,FOLLOW_CURLY_STRING_in_convert_string650);
			}


			 		LiteralParameter p = factory.createLiteralParameter();
			 		String value = v.getText();
			  		p.setLiteral(value.substring(1, value.length()-1));
			  		p.setFormat(f.getText());
				  	param = p;
			 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return param;
	}
	// $ANTLR end "convert_string"



	// $ANTLR start "string"
	// Ecl.g:322:1: string returns [String s = null] : f= STRING ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )* ;
	public final String string() throws RecognitionException {
		String s =  null;


		Token f=null;
		Token r=null;

		try {
			// Ecl.g:322:33: (f= STRING ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )* )
			// Ecl.g:323:3: f= STRING ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )*
			{
			f=(Token)match(input,STRING,FOLLOW_STRING_in_string747);
			StringBuilder sb =
			    new StringBuilder(f.getText().substring(1, f.getText().length()-1));
			// Ecl.g:325:3: ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==NEWLINE) ) {
					int LA33_1 = input.LA(2);
					if ( (LA33_1==27) ) {
						alt33=1;
					}

				}
				else if ( (LA33_0==27) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// Ecl.g:325:4: ( NEWLINE )? '+' ( NEWLINE )? r= STRING
					{
					// Ecl.g:325:4: ( NEWLINE )?
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==NEWLINE) ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// Ecl.g:325:4: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_string755);
							}
							break;

					}

					match(input,27,FOLLOW_27_in_string758);
					// Ecl.g:325:17: ( NEWLINE )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==NEWLINE) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// Ecl.g:325:17: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_string760);
							}
							break;

					}

					r=(Token)match(input,STRING,FOLLOW_STRING_in_string765);
					sb.append(r.getText().substring(1, r.getText().length()-1));
					}
					break;

				default :
					break loop33;
				}
			}

			s = sb.toString();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "string"

	// Delegated rules



	public static final BitSet FOLLOW_eos_in_commands80 = new BitSet(new long[]{0x0000000004834200L});
	public static final BitSet FOLLOW_open_expr_list_in_commands85 = new BitSet(new long[]{0x0000000000820000L});
	public static final BitSet FOLLOW_eos_in_commands89 = new BitSet(new long[]{0x0000000000820000L});
	public static final BitSet FOLLOW_EOF_in_commands92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_expr_in_expression119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_expr_in_and_expr138 = new BitSet(new long[]{0x0000000000020012L});
	public static final BitSet FOLLOW_NEWLINE_in_and_expr144 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_AND_in_and_expr147 = new BitSet(new long[]{0x0000000004034200L});
	public static final BitSet FOLLOW_NEWLINE_in_and_expr149 = new BitSet(new long[]{0x0000000004014200L});
	public static final BitSet FOLLOW_or_expr_in_and_expr154 = new BitSet(new long[]{0x0000000000020012L});
	public static final BitSet FOLLOW_cmd_in_or_expr176 = new BitSet(new long[]{0x00000000000A0002L});
	public static final BitSet FOLLOW_NEWLINE_in_or_expr183 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_OR_in_or_expr186 = new BitSet(new long[]{0x0000000004034200L});
	public static final BitSet FOLLOW_NEWLINE_in_or_expr188 = new BitSet(new long[]{0x0000000004014200L});
	public static final BitSet FOLLOW_cmd_in_or_expr193 = new BitSet(new long[]{0x00000000000A0002L});
	public static final BitSet FOLLOW_one_or_more_expr_in_open_expr_list226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_one_or_more_expr263 = new BitSet(new long[]{0x0000000000820002L});
	public static final BitSet FOLLOW_eos_in_one_or_more_expr273 = new BitSet(new long[]{0x0000000004834200L});
	public static final BitSet FOLLOW_one_or_more_expr_in_one_or_more_expr280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_named_command_in_cmd300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOPEN_in_cmd308 = new BitSet(new long[]{0x0000000004414200L});
	public static final BitSet FOLLOW_open_expr_list_in_cmd312 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ROPEN_in_cmd316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_cmd322 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_command_name_in_cmd326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_name_in_named_command349 = new BitSet(new long[]{0x0000000025078882L});
	public static final BitSet FOLLOW_host_in_named_command360 = new BitSet(new long[]{0x0000000005078882L});
	public static final BitSet FOLLOW_argument_value_in_named_command372 = new BitSet(new long[]{0x0000000005078882L});
	public static final BitSet FOLLOW_NEWLINE_in_named_command383 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_MINUS_in_named_command386 = new BitSet(new long[]{0x0000000000018000L});
	public static final BitSet FOLLOW_MINUS_in_named_command388 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_argument_in_named_command393 = new BitSet(new long[]{0x0000000000028002L});
	public static final BitSet FOLLOW_NEWLINE_in_subcommand415 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LBRACK_in_subcommand418 = new BitSet(new long[]{0x0000000004134200L});
	public static final BitSet FOLLOW_NEWLINE_in_subcommand420 = new BitSet(new long[]{0x0000000004134200L});
	public static final BitSet FOLLOW_open_expr_list_in_subcommand429 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_NEWLINE_in_subcommand435 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_RBRACK_in_subcommand438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_subcommand443 = new BitSet(new long[]{0x0000000000010200L});
	public static final BitSet FOLLOW_command_name_in_subcommand447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_command_name467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DNAME_in_command_name474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_host492 = new BitSet(new long[]{0x0000000000010400L});
	public static final BitSet FOLLOW_NAME_in_host497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IP4_in_host501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_named_argument_in_argument523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_value_in_argument_value544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subcommand_in_argument_value551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_convert_string_in_argument_value559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_simple_value576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_simple_value580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_simple_value582 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_string_in_simple_value587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_simple_value589 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CURLY_STRING_in_simple_value594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_named_argument613 = new BitSet(new long[]{0x0000000015070882L});
	public static final BitSet FOLLOW_28_in_named_argument616 = new BitSet(new long[]{0x0000000005070880L});
	public static final BitSet FOLLOW_argument_value_in_named_argument622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_convert_string644 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_convert_string646 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CURLY_STRING_in_convert_string650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string747 = new BitSet(new long[]{0x0000000008020002L});
	public static final BitSet FOLLOW_NEWLINE_in_string755 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_string758 = new BitSet(new long[]{0x0000000001020000L});
	public static final BitSet FOLLOW_NEWLINE_in_string760 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_STRING_in_string765 = new BitSet(new long[]{0x0000000008020002L});
}
