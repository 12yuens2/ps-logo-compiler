package logoCompiler.parser.stmts;

import java.util.ArrayList;

import logoCompiler.lexer.Lexer;
import logoCompiler.lexer.tokens.keywords.FORWARDToken;
import logoCompiler.lexer.tokens.keywords.IFToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.lexer.tokens.keywords.LEFTToken;
import logoCompiler.lexer.tokens.keywords.RIGHTToken;
import logoCompiler.parser.Parser;

public class Stmts {

	private ArrayList<Stmt> stmts;

	public Stmts(){
		stmts = new ArrayList<Stmt>();
	}
	
	public void add (Stmt s){
		stmts.add(s);
	}
	
	public ArrayList<Stmt> getStmts(){
		return stmts;
	}

	public void codegen() {
		for (Stmt s: stmts){
			s.codegen();
		}
	}
	
	public void findStmts(){

		if (Parser.t instanceof IFToken){
        	this.add(IfStmt.parse());
        } else if (Parser.t instanceof FORWARDToken){
        	this.add(ForwardStmt.parse());
        } else if (Parser.t instanceof LEFTToken){
        	this.add(LeftStmt.parse());
        } else if (Parser.t instanceof RIGHTToken){
        	this.add(RightStmt.parse());
        } else if (Parser.t instanceof IdentToken){
        	this.add(IdentStmt.parse());
        } else {
        	Parser.addError("Unexpected statement");
        	Parser.t = Lexer.lex();
        }
	}
}
