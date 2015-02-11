package logoCompiler.parser.stmts;

import logoCompiler.Writer;
import logoCompiler.lexer.Lexer;
import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.keywords.ELSEToken;
import logoCompiler.lexer.tokens.keywords.ENDIFToken;
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
  
	    int line = Lexer.lineNumber;
	    if (Parser.t instanceof THENToken){
	    	
	    } else {
	    	Parser.addError("Missing 'THEN'");
	    }
	    Parser.t = Lexer.lex();
	    line = Lexer.lineNumber;
	    while (!(Parser.t instanceof ELSEToken)){
	    	if (Parser.t instanceof EOIToken){
	    		Parser.addError("Missing 'ELSE'",line);
	    		return null;
	    	}
	    	then.findStmts();
	    }

	    Parser.t = Lexer.lex();
	    
	    line = Lexer.lineNumber;
	    while (!(Parser.t instanceof ENDIFToken)){
	    	if (Parser.t instanceof EOIToken){
	    		Parser.addError("Missing 'ENDIF'",line);
	    		return null;
	    	}
	    	el.findStmts();
	    }	    
	    
	    Parser.t = Lexer.lex();
		return new IfStmt(expr, then, el);
	}
	
	@Override
	public void codegen(){
		expr.codegen();
		Writer.write("{");
		thenStmts.codegen();
		//Replaced Writer.write("pop }{");
		Writer.write("/Arg exch def }{");
		elseStmts.codegen();
		//Replaced Writer.write("pop } ifelse");
		Writer.write("/Arg exch def } ifelse");
	}
	
	public Stmts getThens(){
		return thenStmts;
	}
	
	public Stmts getElses(){
		return elseStmts;
	}
	
	public Expr getExpr() {
		return expr;
	}
}
