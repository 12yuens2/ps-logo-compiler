package logoCompiler.parser.exprs;

import logoCompiler.Writer;
import logoCompiler.lexer.tokens.NumToken;
import logoCompiler.parser.Parser;

public class NumExpr extends Expr {
	
	String number;
	
	public NumExpr(String n){
		this.number = n;
	}
	
	public static Expr parse(){
		String n = ((NumToken)Parser.t).getNumber();
		
		return new NumExpr(n);
	}
	
	@Override
	public void codegen() {
		Writer.write(number);
	}

}
