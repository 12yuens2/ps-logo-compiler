package logoCompiler.parser;
import  logoCompiler.lexer.*;

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
    System.out.println("Left");
  }
}
