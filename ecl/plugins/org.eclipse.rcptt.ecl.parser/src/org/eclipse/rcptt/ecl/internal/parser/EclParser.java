// $ANTLR 3.5.2 H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g 2014-07-30 18:12:41

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EclParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "COLON", "COMMENT", "CURLY_STRING", 
		"DIGIT", "DNAME", "IP4", "LBRACK", "LCURLY", "LINE_COMMENT", "LOPEN", 
		"NAME", "NEWLINE", "NUMBER", "OR", "RBRACK", "RCURLY", "ROPEN", "SEMI", 
		"STRING", "WS", "'$'", "'+'", "'-'", "'='", "'@'"
	};
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
	@Override public String getGrammarFileName() { return "H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g"; }

	  
	    CoreFactory factory = CoreFactory.eINSTANCE;  
	    Command processSequence(Command cmd, Command c2 ) {
	            //Construct sequence if not yet constructed.
	            if (cmd == null)
	                return c2;
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



	// $ANTLR start "eos"
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:79:1: eos : ( NEWLINE | COLON )+ ;
	public final void eos() throws RecognitionException {
		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:79:4: ( ( NEWLINE | COLON )+ )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:79:6: ( NEWLINE | COLON )+
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:79:6: ( NEWLINE | COLON )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==COLON||LA1_0==NEWLINE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:
					{
					if ( input.LA(1)==COLON||input.LA(1)==NEWLINE ) {
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:80:1: commands returns [Command cmd=null;] : ( eos )* exprs= open_expr_list ( eos )* EOF ;
	public final Command commands() throws RecognitionException {
		Command cmd = null;;


		Command exprs =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:80:36: ( ( eos )* exprs= open_expr_list ( eos )* EOF )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:81:2: ( eos )* exprs= open_expr_list ( eos )* EOF
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:81:2: ( eos )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==COLON||LA2_0==NEWLINE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:81:2: eos
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
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:81:41: ( eos )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COLON||LA3_0==NEWLINE) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:81:41: eos
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:88:1: expression returns [Command cmd=null;] : c= and_expr ;
	public final Command expression() throws RecognitionException {
		Command cmd = null;;


		Command c =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:88:38: (c= and_expr )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:89:4: c= and_expr
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:94:1: and_expr returns [Command cmd=null;] : or1= or_expr ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )* ;
	public final Command and_expr() throws RecognitionException {
		Command cmd = null;;


		Command or1 =null;
		Command or2 =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:94:37: (or1= or_expr ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )* )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:3: or1= or_expr ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )*
			{
			pushFollow(FOLLOW_or_expr_in_and_expr138);
			or1=or_expr();
			state._fsp--;

			cmd=or1;
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:26: ( ( NEWLINE )? AND ( NEWLINE )? or2= or_expr )*
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
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:28: ( NEWLINE )? AND ( NEWLINE )? or2= or_expr
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:28: ( NEWLINE )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==NEWLINE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:28: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_and_expr144); 
							}
							break;

					}

					match(input,AND,FOLLOW_AND_in_and_expr147); 
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:41: ( NEWLINE )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==NEWLINE) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:95:41: NEWLINE
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:113:1: or_expr returns [Command cmd=null;] : c= cmd ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )* ;
	public final Command or_expr() throws RecognitionException {
		Command cmd = null;;


		Command c =null;
		Command cmd2 =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:113:36: (c= cmd ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )* )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:114:3: c= cmd ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )*
			{
			pushFollow(FOLLOW_cmd_in_or_expr176);
			c=cmd();
			state._fsp--;


			  cmd = c;
			  
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:116:6: ( ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd )*
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
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:116:8: ( NEWLINE )? OR ( NEWLINE )? cmd2= cmd
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:116:8: ( NEWLINE )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==NEWLINE) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:116:8: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_or_expr183); 
							}
							break;

					}

					match(input,OR,FOLLOW_OR_in_or_expr186); 
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:116:20: ( NEWLINE )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==NEWLINE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:116:20: NEWLINE
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:134:1: open_expr_list returns [Command cmd=null] : (c= one_or_more_expr )? ;
	public final Command open_expr_list() throws RecognitionException {
		Command cmd = null;


		Command c =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:134:42: ( (c= one_or_more_expr )? )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:135:5: (c= one_or_more_expr )?
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:135:5: (c= one_or_more_expr )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==DNAME||(LA10_0 >= LOPEN && LA10_0 <= NAME)||LA10_0==25) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:136:8: c= one_or_more_expr
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:144:1: one_or_more_expr returns [Command cmd=null] : c= expression ( ( eos )+ c2= one_or_more_expr )? ;
	public final Command one_or_more_expr() throws RecognitionException {
		Command cmd = null;


		Command c =null;
		Command c2 =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:144:44: (c= expression ( ( eos )+ c2= one_or_more_expr )? )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:145:5: c= expression ( ( eos )+ c2= one_or_more_expr )?
			{
			pushFollow(FOLLOW_expression_in_one_or_more_expr263);
			c=expression();
			state._fsp--;

			cmd = processSequence(cmd, c);
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:146:5: ( ( eos )+ c2= one_or_more_expr )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==COLON||LA12_0==NEWLINE) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==DNAME||(LA12_1 >= LOPEN && LA12_1 <= NAME)||LA12_1==25) ) {
					alt12=1;
				}
				else if ( (LA12_1==COLON||LA12_1==NEWLINE) ) {
					alt12=1;
				}
			}
			switch (alt12) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:146:6: ( eos )+ c2= one_or_more_expr
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:146:6: ( eos )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==COLON||LA11_0==NEWLINE) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:146:6: eos
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:150:1: cmd returns [Command cmd=null;] : (c= named_command | ( LOPEN c= open_expr_list ROPEN ) | ( '$' n= command_name ) );
	public final Command cmd() throws RecognitionException {
		Command cmd = null;;


		Command c =null;
		String n =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:150:32: (c= named_command | ( LOPEN c= open_expr_list ROPEN ) | ( '$' n= command_name ) )
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
			case 25:
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
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:151:2: c= named_command
					{
					pushFollow(FOLLOW_named_command_in_cmd300);
					c=named_command();
					state._fsp--;


						cmd = c;
					 
					}
					break;
				case 2 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:154:2: ( LOPEN c= open_expr_list ROPEN )
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:154:2: ( LOPEN c= open_expr_list ROPEN )
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:154:3: LOPEN c= open_expr_list ROPEN
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
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:156:13: ( '$' n= command_name )
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:156:13: ( '$' n= command_name )
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:156:14: '$' n= command_name
					{
					match(input,25,FOLLOW_25_in_cmd322); 
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:163:1: named_command returns [Exec cmd=null;] :n= command_name (ho= host )? (a= argument_value )* ( ( NEWLINE )? '-' ( '-' )? arg= argument )* ;
	public final Exec named_command() throws RecognitionException {
		Exec cmd = null;;


		String n =null;
		String ho =null;
		Parameter a =null;
		Parameter arg =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:163:38: (n= command_name (ho= host )? (a= argument_value )* ( ( NEWLINE )? '-' ( '-' )? arg= argument )* )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:164:3: n= command_name (ho= host )? (a= argument_value )* ( ( NEWLINE )? '-' ( '-' )? arg= argument )*
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
			   
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:183:4: (ho= host )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==29) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:183:5: ho= host
					{
					pushFollow(FOLLOW_host_in_named_command360);
					ho=host();
					state._fsp--;


							cmd.setHost(ho);
					   
					}
					break;

			}

			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:186:4: (a= argument_value )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==NEWLINE) ) {
					int LA15_1 = input.LA(2);
					if ( (LA15_1==25) ) {
						alt15=1;
					}
					else if ( (LA15_1==CURLY_STRING||LA15_1==LBRACK||LA15_1==STRING) ) {
						alt15=1;
					}

				}
				else if ( (LA15_0==CURLY_STRING||LA15_0==LBRACK||LA15_0==NAME||LA15_0==NUMBER||LA15_0==STRING||LA15_0==25) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:186:5: a= argument_value
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

			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:191:4: ( ( NEWLINE )? '-' ( '-' )? arg= argument )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==NEWLINE) ) {
					int LA18_1 = input.LA(2);
					if ( (LA18_1==27) ) {
						alt18=1;
					}

				}
				else if ( (LA18_0==27) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:191:5: ( NEWLINE )? '-' ( '-' )? arg= argument
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:191:5: ( NEWLINE )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==NEWLINE) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:191:5: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_named_command383); 
							}
							break;

					}

					match(input,27,FOLLOW_27_in_named_command386); 
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:191:18: ( '-' )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==27) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:191:18: '-'
							{
							match(input,27,FOLLOW_27_in_named_command388); 
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:204:1: subcommand returns [Parameter param=null;] : ( ( LBRACK c= open_expr_list RBRACK ) | '$' name= command_name );
	public final Parameter subcommand() throws RecognitionException {
		Parameter param = null;;


		Command c =null;
		String name =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:204:42: ( ( LBRACK c= open_expr_list RBRACK ) | '$' name= command_name )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==LBRACK) ) {
				alt19=1;
			}
			else if ( (LA19_0==25) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:205:3: ( LBRACK c= open_expr_list RBRACK )
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:205:3: ( LBRACK c= open_expr_list RBRACK )
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:205:4: LBRACK c= open_expr_list RBRACK
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_subcommand415); 
					pushFollow(FOLLOW_open_expr_list_in_subcommand423);
					c=open_expr_list();
					state._fsp--;


					    	ExecutableParameter p = factory.createExecutableParameter();
					  		p.setCommand(c);
						  	param = p;
					    
					match(input,RBRACK,FOLLOW_RBRACK_in_subcommand429); 
					}

					}
					break;
				case 2 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:211:13: '$' name= command_name
					{
					match(input,25,FOLLOW_25_in_subcommand434); 
					pushFollow(FOLLOW_command_name_in_subcommand438);
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:220:1: command_name returns [String name=null;] : (n= NAME |n= DNAME ) ;
	public final String command_name() throws RecognitionException {
		String name = null;;


		Token n=null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:220:40: ( (n= NAME |n= DNAME ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:221:2: (n= NAME |n= DNAME )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:221:2: (n= NAME |n= DNAME )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==NAME) ) {
				alt20=1;
			}
			else if ( (LA20_0==DNAME) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:221:3: n= NAME
					{
					n=(Token)match(input,NAME,FOLLOW_NAME_in_command_name458); 
					}
					break;
				case 2 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:221:33: n= DNAME
					{
					n=(Token)match(input,DNAME,FOLLOW_DNAME_in_command_name465); 
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:224:1: host returns [String host=null;] : ( '@' (n= NAME |n= IP4 ) ) ;
	public final String host() throws RecognitionException {
		String host = null;;


		Token n=null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:224:33: ( ( '@' (n= NAME |n= IP4 ) ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:225:2: ( '@' (n= NAME |n= IP4 ) )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:225:2: ( '@' (n= NAME |n= IP4 ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:225:3: '@' (n= NAME |n= IP4 )
			{
			match(input,29,FOLLOW_29_in_host483); 
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:225:7: (n= NAME |n= IP4 )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==NAME) ) {
				alt21=1;
			}
			else if ( (LA21_0==IP4) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:225:8: n= NAME
					{
					n=(Token)match(input,NAME,FOLLOW_NAME_in_host488); 
					}
					break;
				case 2 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:225:15: n= IP4
					{
					n=(Token)match(input,IP4,FOLLOW_IP4_in_host492); 
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:230:1: argument returns [Parameter param = null] : (p= named_argument ) ;
	public final Parameter argument() throws RecognitionException {
		Parameter param =  null;


		Parameter p =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:230:42: ( (p= named_argument ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:231:4: (p= named_argument )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:231:4: (p= named_argument )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:231:5: p= named_argument
			{
			pushFollow(FOLLOW_named_argument_in_argument514);
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:233:1: argument_value returns [Parameter param=null;] : (p= simple_value | ( NEWLINE )? p= subcommand |p= convert_string ) ;
	public final Parameter argument_value() throws RecognitionException {
		Parameter param = null;;


		Parameter p =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:233:47: ( (p= simple_value | ( NEWLINE )? p= subcommand |p= convert_string ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:3: (p= simple_value | ( NEWLINE )? p= subcommand |p= convert_string )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:3: (p= simple_value | ( NEWLINE )? p= subcommand |p= convert_string )
			int alt23=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				int LA23_1 = input.LA(2);
				if ( (LA23_1==SEMI) ) {
					alt23=3;
				}
				else if ( (LA23_1==EOF||(LA23_1 >= AND && LA23_1 <= COLON)||LA23_1==CURLY_STRING||LA23_1==LBRACK||(LA23_1 >= NAME && LA23_1 <= RBRACK)||LA23_1==ROPEN||LA23_1==STRING||LA23_1==25||LA23_1==27) ) {
					alt23=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 23, 1, input);
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
				alt23=1;
				}
				break;
			case NEWLINE:
				{
				int LA23_3 = input.LA(2);
				if ( (LA23_3==CURLY_STRING||LA23_3==STRING) ) {
					alt23=1;
				}
				else if ( (LA23_3==LBRACK||LA23_3==25) ) {
					alt23=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 23, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LBRACK:
			case 25:
				{
				alt23=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:4: p= simple_value
					{
					pushFollow(FOLLOW_simple_value_in_argument_value535);
					p=simple_value();
					state._fsp--;

					}
					break;
				case 2 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:23: ( NEWLINE )? p= subcommand
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:23: ( NEWLINE )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==NEWLINE) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:23: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_argument_value539); 
							}
							break;

					}

					pushFollow(FOLLOW_subcommand_in_argument_value545);
					p=subcommand();
					state._fsp--;

					}
					break;
				case 3 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:234:48: p= convert_string
					{
					pushFollow(FOLLOW_convert_string_in_argument_value553);
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:238:1: simple_value returns [Parameter param = null;] : (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING ) ;
	public final Parameter simple_value() throws RecognitionException {
		Parameter param =  null;;


		Token d=null;
		Token d3=null;
		String d2 =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:238:46: ( (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:2: (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:2: (d= NAME |d= NUMBER | ( NEWLINE )? d2= string | ( NEWLINE )? d3= CURLY_STRING )
			int alt26=4;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt26=1;
				}
				break;
			case NUMBER:
				{
				alt26=2;
				}
				break;
			case NEWLINE:
				{
				int LA26_3 = input.LA(2);
				if ( (LA26_3==STRING) ) {
					alt26=3;
				}
				else if ( (LA26_3==CURLY_STRING) ) {
					alt26=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 26, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STRING:
				{
				alt26=3;
				}
				break;
			case CURLY_STRING:
				{
				alt26=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}
			switch (alt26) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:3: d= NAME
					{
					d=(Token)match(input,NAME,FOLLOW_NAME_in_simple_value570); 
					}
					break;
				case 2 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:10: d= NUMBER
					{
					d=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_simple_value574); 
					}
					break;
				case 3 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:19: ( NEWLINE )? d2= string
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:19: ( NEWLINE )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==NEWLINE) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:19: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_simple_value576); 
							}
							break;

					}

					pushFollow(FOLLOW_string_in_simple_value581);
					d2=string();
					state._fsp--;

					}
					break;
				case 4 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:38: ( NEWLINE )? d3= CURLY_STRING
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:38: ( NEWLINE )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==NEWLINE) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:239:38: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_simple_value583); 
							}
							break;

					}

					d3=(Token)match(input,CURLY_STRING,FOLLOW_CURLY_STRING_in_simple_value588); 
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:279:1: named_argument returns [Parameter param=null;] : (n= NAME ( ( '=' )? (v= argument_value ) )? ) ;
	public final Parameter named_argument() throws RecognitionException {
		Parameter param = null;;


		Token n=null;
		Parameter v =null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:279:47: ( (n= NAME ( ( '=' )? (v= argument_value ) )? ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:2: (n= NAME ( ( '=' )? (v= argument_value ) )? )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:2: (n= NAME ( ( '=' )? (v= argument_value ) )? )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:3: n= NAME ( ( '=' )? (v= argument_value ) )?
			{
			n=(Token)match(input,NAME,FOLLOW_NAME_in_named_argument607); 
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:10: ( ( '=' )? (v= argument_value ) )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==CURLY_STRING||LA28_0==LBRACK||LA28_0==NAME||LA28_0==NUMBER||LA28_0==STRING||LA28_0==25||LA28_0==28) ) {
				alt28=1;
			}
			else if ( (LA28_0==NEWLINE) ) {
				int LA28_4 = input.LA(2);
				if ( (LA28_4==CURLY_STRING||LA28_4==LBRACK||LA28_4==STRING) ) {
					alt28=1;
				}
				else if ( (LA28_4==25) ) {
					alt28=1;
				}
			}
			switch (alt28) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:11: ( '=' )? (v= argument_value )
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:11: ( '=' )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==28) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:11: '='
							{
							match(input,28,FOLLOW_28_in_named_argument610); 
							}
							break;

					}

					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:16: (v= argument_value )
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:280:17: v= argument_value
					{
					pushFollow(FOLLOW_argument_value_in_named_argument616);
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:292:1: convert_string returns [Parameter param=null;] : (f= NAME SEMI v= CURLY_STRING ) ;
	public final Parameter convert_string() throws RecognitionException {
		Parameter param = null;;


		Token f=null;
		Token v=null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:292:47: ( (f= NAME SEMI v= CURLY_STRING ) )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:293:2: (f= NAME SEMI v= CURLY_STRING )
			{
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:293:2: (f= NAME SEMI v= CURLY_STRING )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:293:3: f= NAME SEMI v= CURLY_STRING
			{
			f=(Token)match(input,NAME,FOLLOW_NAME_in_convert_string638); 
			match(input,SEMI,FOLLOW_SEMI_in_convert_string640); 
			v=(Token)match(input,CURLY_STRING,FOLLOW_CURLY_STRING_in_convert_string644); 
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
	// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:322:1: string returns [String s = null] : f= STRING ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )* ;
	public final String string() throws RecognitionException {
		String s =  null;


		Token f=null;
		Token r=null;

		try {
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:322:33: (f= STRING ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )* )
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:323:3: f= STRING ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )*
			{
			f=(Token)match(input,STRING,FOLLOW_STRING_in_string741); 
			StringBuilder sb = 
			    new StringBuilder(f.getText().substring(1, f.getText().length()-1));
			// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:325:3: ( ( NEWLINE )? '+' ( NEWLINE )? r= STRING )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==NEWLINE) ) {
					int LA31_1 = input.LA(2);
					if ( (LA31_1==26) ) {
						alt31=1;
					}

				}
				else if ( (LA31_0==26) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:325:4: ( NEWLINE )? '+' ( NEWLINE )? r= STRING
					{
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:325:4: ( NEWLINE )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==NEWLINE) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:325:4: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_string749); 
							}
							break;

					}

					match(input,26,FOLLOW_26_in_string752); 
					// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:325:17: ( NEWLINE )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==NEWLINE) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// H:\\rcptt\\git\\rcptt\\ecl\\plugins\\org.eclipse.rcptt.ecl.parser\\antlr\\Ecl.g:325:17: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_string754); 
							}
							break;

					}

					r=(Token)match(input,STRING,FOLLOW_STRING_in_string759); 
					sb.append(r.getText().substring(1, r.getText().length()-1));
					}
					break;

				default :
					break loop31;
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



	public static final BitSet FOLLOW_eos_in_commands80 = new BitSet(new long[]{0x000000000201C220L});
	public static final BitSet FOLLOW_open_expr_list_in_commands85 = new BitSet(new long[]{0x0000000000010020L});
	public static final BitSet FOLLOW_eos_in_commands89 = new BitSet(new long[]{0x0000000000010020L});
	public static final BitSet FOLLOW_EOF_in_commands92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_expr_in_expression119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_expr_in_and_expr138 = new BitSet(new long[]{0x0000000000010012L});
	public static final BitSet FOLLOW_NEWLINE_in_and_expr144 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_AND_in_and_expr147 = new BitSet(new long[]{0x000000000201C200L});
	public static final BitSet FOLLOW_NEWLINE_in_and_expr149 = new BitSet(new long[]{0x000000000200C200L});
	public static final BitSet FOLLOW_or_expr_in_and_expr154 = new BitSet(new long[]{0x0000000000010012L});
	public static final BitSet FOLLOW_cmd_in_or_expr176 = new BitSet(new long[]{0x0000000000050002L});
	public static final BitSet FOLLOW_NEWLINE_in_or_expr183 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OR_in_or_expr186 = new BitSet(new long[]{0x000000000201C200L});
	public static final BitSet FOLLOW_NEWLINE_in_or_expr188 = new BitSet(new long[]{0x000000000200C200L});
	public static final BitSet FOLLOW_cmd_in_or_expr193 = new BitSet(new long[]{0x0000000000050002L});
	public static final BitSet FOLLOW_one_or_more_expr_in_open_expr_list226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_one_or_more_expr263 = new BitSet(new long[]{0x0000000000010022L});
	public static final BitSet FOLLOW_eos_in_one_or_more_expr273 = new BitSet(new long[]{0x000000000201C220L});
	public static final BitSet FOLLOW_one_or_more_expr_in_one_or_more_expr280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_named_command_in_cmd300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOPEN_in_cmd308 = new BitSet(new long[]{0x000000000220C200L});
	public static final BitSet FOLLOW_open_expr_list_in_cmd312 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ROPEN_in_cmd316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_cmd322 = new BitSet(new long[]{0x0000000000008200L});
	public static final BitSet FOLLOW_command_name_in_cmd326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_name_in_named_command349 = new BitSet(new long[]{0x000000002A838882L});
	public static final BitSet FOLLOW_host_in_named_command360 = new BitSet(new long[]{0x000000000A838882L});
	public static final BitSet FOLLOW_argument_value_in_named_command372 = new BitSet(new long[]{0x000000000A838882L});
	public static final BitSet FOLLOW_NEWLINE_in_named_command383 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_named_command386 = new BitSet(new long[]{0x0000000008008000L});
	public static final BitSet FOLLOW_27_in_named_command388 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_argument_in_named_command393 = new BitSet(new long[]{0x0000000008010002L});
	public static final BitSet FOLLOW_LBRACK_in_subcommand415 = new BitSet(new long[]{0x000000000208C200L});
	public static final BitSet FOLLOW_open_expr_list_in_subcommand423 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RBRACK_in_subcommand429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_subcommand434 = new BitSet(new long[]{0x0000000000008200L});
	public static final BitSet FOLLOW_command_name_in_subcommand438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_command_name458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DNAME_in_command_name465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_host483 = new BitSet(new long[]{0x0000000000008400L});
	public static final BitSet FOLLOW_NAME_in_host488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IP4_in_host492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_named_argument_in_argument514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_value_in_argument_value535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_argument_value539 = new BitSet(new long[]{0x0000000002000800L});
	public static final BitSet FOLLOW_subcommand_in_argument_value545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_convert_string_in_argument_value553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_simple_value570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_simple_value574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_simple_value576 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_string_in_simple_value581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_simple_value583 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CURLY_STRING_in_simple_value588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_named_argument607 = new BitSet(new long[]{0x0000000012838882L});
	public static final BitSet FOLLOW_28_in_named_argument610 = new BitSet(new long[]{0x0000000002838880L});
	public static final BitSet FOLLOW_argument_value_in_named_argument616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_convert_string638 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_SEMI_in_convert_string640 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CURLY_STRING_in_convert_string644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string741 = new BitSet(new long[]{0x0000000004010002L});
	public static final BitSet FOLLOW_NEWLINE_in_string749 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_string752 = new BitSet(new long[]{0x0000000000810000L});
	public static final BitSet FOLLOW_NEWLINE_in_string754 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_STRING_in_string759 = new BitSet(new long[]{0x0000000004010002L});
}
