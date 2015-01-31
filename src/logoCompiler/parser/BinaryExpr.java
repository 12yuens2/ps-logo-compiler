package logoCompiler.parser;
import  logoCompiler.lexer.*;

/*
 * binary-expr:
 *   expr op expr
 *
 *   where op is one of '+',  '-',  '*', '/',
 *                      '==', '!=', '>', '<', '<=', '>='
 */
public final class BinaryExpr extends Expr {
  public Expr  left;
  public OperatorToken oper;
  public Expr  right;

  public BinaryExpr(Expr left, OperatorToken oper, Expr right) {
    this.left  = left;
    this.oper  = oper;
    this.right = right;
  }


  @Override
public void codegen() {
    left.codegen();
    right.codegen();
    System.out.println(oper.psOpCode());
  }
}
