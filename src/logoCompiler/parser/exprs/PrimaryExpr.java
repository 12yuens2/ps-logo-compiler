package logoCompiler.parser.exprs;
import logoCompiler.lexer.tokens.NumToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.parser.Parser;

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
    	Parser.addError("Number or identity expected");
      return null;
    } 
  }
}
