package logoCompiler.parser.exprs;
import logoCompiler.Writer;
import logoCompiler.lexer.Lexer;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.parser.Parser;

public class IdentExpr extends Expr {

	private String name;
	private int lineNumber;
	
	public IdentExpr(String name, int line) {
		this.name = name;
		this.lineNumber = line;
	}
	
	public static Expr parse(){
		String name;
		
		name = ((IdentToken)Parser.t).getName();
		return new IdentExpr(name, Lexer.lineNumber);
		
	}
	
	@Override
	public void codegen() {
		//Replaced Writer.write("dup");
		Writer.write("/Arg exch def Arg Arg");
	}

	public String getName() {
		return name;
	}
	
	public int getLine() {
		return lineNumber;
	}

	
}
