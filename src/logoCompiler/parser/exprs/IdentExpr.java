package logoCompiler.parser.exprs;

import logoCompiler.Writer;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.parser.Parser;

public class IdentExpr extends Expr {

	private String name;
	
	public IdentExpr(String name) {
		this.name = name;
	}
	
	public static Expr parse(){
		String name;
		
		name = ((IdentToken)Parser.t).getName();
		
		return new IdentExpr(name);
		
	}
	
	@Override
	public void codegen() {
		Writer.write("dup");
	}
	
}
