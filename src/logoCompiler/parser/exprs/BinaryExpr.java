package logoCompiler.parser.exprs;
import logoCompiler.Writer;
import logoCompiler.lexer.tokens.operators.OperatorToken;

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
    Writer.write(oper.psOpCode());
  }
}
