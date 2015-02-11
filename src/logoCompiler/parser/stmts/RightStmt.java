package logoCompiler.parser.stmts;

import logoCompiler.Writer;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;
import logoCompiler.parser.exprs.Expr;

public class RightStmt extends Stmt {
	Expr expr;

	public RightStmt(Expr expr) {
		this.expr = expr;
	}

	public static Stmt parse() {

		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new RightStmt(expr);
	}

	@Override
	public void codegen() {
		expr.codegen();
		Writer.write("Right");
	}
	
	public Expr getExpr() {
		return expr;
	}
}
