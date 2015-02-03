package logoCompiler.parser.stmts;
import logoCompiler.Writer;
import  logoCompiler.lexer.*;
import logoCompiler.parser.Parser;
import logoCompiler.parser.exprs.Expr;

/*
 *   "LEFT" expr
 */
public final class LeftStmt extends Stmt {
  Expr expr;

  public LeftStmt(Expr expr) {
    this.expr = expr;
  }

  public static Stmt parse() {

    Parser.t = Lexer.lex();
    Expr expr = Expr.parse();
    return new LeftStmt(expr);
  }

  @Override
public void codegen() {
    expr.codegen();
    Writer.write("Left");
  }
}
