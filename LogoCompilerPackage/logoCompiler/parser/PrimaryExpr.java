package logoCompiler.parser;
import  logoCompiler.lexer.*;
/*
 * primary-expr:
 *   num
 *   ident
 */
public abstract class PrimaryExpr extends Expr {
  public static Expr parse() {
    if (Parser.t instanceof NumToken) {
      return NumExpr.parse();
    } else if (Parser.t instanceof IdentToken) {
      return IdentExpr.parse();
    } else {
      //error?
    } 
  }
}
