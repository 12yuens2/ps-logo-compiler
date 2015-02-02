package logoCompiler.parser.stmts;

import logoCompiler.lexer.Lexer;
import logoCompiler.lexer.tokens.keywords.ELSEToken;
import logoCompiler.lexer.tokens.keywords.ENDIFToken;
import logoCompiler.lexer.tokens.keywords.FORWARDToken;
import logoCompiler.lexer.tokens.keywords.IFToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.lexer.tokens.keywords.LEFTToken;
import logoCompiler.lexer.tokens.keywords.PROCToken;
import logoCompiler.lexer.tokens.keywords.RIGHTToken;
import logoCompiler.lexer.tokens.keywords.THENToken;
import logoCompiler.parser.Parser;
import logoCompiler.parser.exprs.Expr;

public class IfStmt extends Stmt {

	private Expr expr;
	private Stmts thenStmts;
	private Stmts elseStmts;
	
	public IfStmt(Expr e, Stmts t, Stmts el) {
		this.expr = e;
		this.thenStmts = t;
		this.elseStmts = el;
	}
	
	
	public static Stmt parse () {
		
		Stmts then = new Stmts();
		Stmts el = new Stmts();
		
	    Parser.t = Lexer.lex();

	    Expr expr = Expr.parse();
  
	    if (Parser.t instanceof THENToken){
	    	
	    } else {
	    	//error?
	    }
	    Parser.t = Lexer.lex();

	    while (!(Parser.t instanceof ELSEToken)){
	        if (Parser.t instanceof IFToken){
	        	then.add(IfStmt.parse());
	        } else if (Parser.t instanceof FORWARDToken){
	        	then.add(ForwardStmt.parse());
	        } else if (Parser.t instanceof LEFTToken){
	        	then.add(LeftStmt.parse());
	        } else if (Parser.t instanceof RIGHTToken){
	        	then.add(RightStmt.parse());
	        } else if (Parser.t instanceof IdentToken){
	        	then.add(IdentStmt.parse());
	        }
	    }

	    Parser.t = Lexer.lex();
	    
	    while (!(Parser.t instanceof ENDIFToken)){
	        if (Parser.t instanceof IFToken){
	        	el.add(IfStmt.parse());
	        } else if (Parser.t instanceof FORWARDToken){
	        	el.add(ForwardStmt.parse());
	        } else if (Parser.t instanceof LEFTToken){
	        	el.add(LeftStmt.parse());
	        } else if (Parser.t instanceof RIGHTToken){
	        	el.add(RightStmt.parse());
	        } else if (Parser.t instanceof IdentToken){
	        	el.add(IdentStmt.parse());
	        }
	    }	    
	    
	    Parser.t = Lexer.lex();
		return new IfStmt(expr, then, el);
	}
	
	@Override
	public void codegen(){
		expr.codegen();
		System.out.println("{");
		thenStmts.codegen();
		System.out.println("}{");
		elseStmts.codegen();
		System.out.println("} ifelse");
	}
}
