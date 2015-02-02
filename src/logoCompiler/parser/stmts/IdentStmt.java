package logoCompiler.parser.stmts;

import logoCompiler.lexer.Lexer;
import logoCompiler.lexer.tokens.LParenToken;
import logoCompiler.lexer.tokens.RParenToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.parser.Parser;
import logoCompiler.parser.exprs.Expr;


public class IdentStmt extends Stmt {

	String name;
	Expr expr;
	
	public IdentStmt(String n, Expr e) {
		this.name = n;
		this.expr = e;
	}
	
	public static Stmt parse() {
		

		String name = ((IdentToken)Parser.t).getName();
		Parser.t = Lexer.lex();
		
	    if (Parser.t instanceof LParenToken) {
	        Parser.t = Lexer.lex();
	      } else {
	        //error?
	      }
		
	    Expr expr = Expr.parse();
	    
	    if (Parser.t instanceof RParenToken) {
	        Parser.t = Lexer.lex();
	    } else {
	        //error?
	    }
	    
		return new IdentStmt(name, expr);
	}
	
	public void codegen(){
		expr.codegen();
		System.out.println(name);
	}
}
