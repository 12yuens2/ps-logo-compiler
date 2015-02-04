package logoCompiler.parser.stmts;

import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.parser.exprs.Expr;

public class Stmt {
	Expr expr;

	public static Stmt parse() {
		return null;
	}

	public void codegen() {
		// TODO Auto-generated method stub
		
	}

	public Expr getExpr() {
		return expr;
	}

}
