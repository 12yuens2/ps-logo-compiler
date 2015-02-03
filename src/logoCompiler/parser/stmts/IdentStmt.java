package logoCompiler.parser.stmts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import logoCompiler.Writer;
import logoCompiler.lexer.Lexer;
import logoCompiler.lexer.tokens.LParenToken;
import logoCompiler.lexer.tokens.RParenToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.parser.Parser;
import logoCompiler.parser.exprs.Expr;


public class IdentStmt extends Stmt {

	private static HashMap<String ,Integer> idents = new HashMap<String, Integer>();
	
	String name;
	Expr expr;

	public IdentStmt(String n, Expr e) {
		this.name = n;
		this.expr = e;
		idents.put(name, Lexer.lineNumber);
	}

	public static Stmt parse() {


		String name = ((IdentToken)Parser.t).getName();
		Parser.t = Lexer.lex();

		if (Parser.t instanceof LParenToken) {
			
		} else {
			Parser.addError("'(' expected");
		}
		Parser.t = Lexer.lex();

		Expr expr = Expr.parse();

		if (Parser.t instanceof RParenToken) {

		} else {
			Parser.addError("')' expected");
		}
		Parser.t = Lexer.lex();
		
		return new IdentStmt(name, expr);
	}

	public void codegen(){
		expr.codegen();
		Writer.write(name);
	}
	
	public static void compare(ArrayList<String> procNames) {
		for (String name : idents.keySet()){
			boolean matches = false;
			for (String procName : procNames){
				if (name.toUpperCase().equals(procName)){
					matches = true;
				}
			}
			if (!matches){
				Parser.addError("Unknown procedure " + name, idents.get(name));
			}
		}
	}
}
