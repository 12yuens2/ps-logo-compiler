package logoCompiler.parser;
import logoCompiler.Writer;
import  logoCompiler.lexer.*;
import logoCompiler.lexer.tokens.*;
import logoCompiler.lexer.tokens.keywords.FORWARDToken;
import logoCompiler.lexer.tokens.keywords.IFToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.lexer.tokens.keywords.LEFTToken;
import logoCompiler.lexer.tokens.keywords.PROCToken;
import logoCompiler.lexer.tokens.keywords.RIGHTToken;
import logoCompiler.lexer.tokens.keywords.StatementToken;
import logoCompiler.lexer.tokens.keywords.VOIDToken;
import logoCompiler.parser.exprs.Expr;
import logoCompiler.parser.exprs.IdentExpr;
import logoCompiler.parser.stmts.ForwardStmt;
import logoCompiler.parser.stmts.IdentStmt;
import logoCompiler.parser.stmts.IfStmt;
import logoCompiler.parser.stmts.LeftStmt;
import logoCompiler.parser.stmts.RightStmt;
import logoCompiler.parser.stmts.Stmt;
import logoCompiler.parser.stmts.Stmts;


/*
 * proc:
 *   "PROC" ident '(' ident ')' stmts 
 */
public final class Proc {
	String name;
	String arg;
	Stmts stmts;

	public Proc(String name, String arg, Stmts stmts) {
		this.name  = name;
		this.arg   = arg;
		this.stmts = stmts;
	}

	public static Proc parse() {
		String   name  = "";
		String   arg   = "";
		Stmts stmts = new Stmts();

		Parser.t = Lexer.lex();

		if (Parser.t instanceof IdentToken) {
			name = ((IdentToken) Parser.t).getName();
		} else {
			Parser.addError("Identity expected");
		}
		Parser.t = Lexer.lex();

		if (Parser.t instanceof LParenToken) {
		} else {
			Parser.addError("'(' expected");
		}
		Parser.t = Lexer.lex();

		if (Parser.t instanceof IdentToken) {
			arg = ((IdentToken) Parser.t).getName();
		} else if (Parser.t instanceof VOIDToken) {
			arg = "VOID";
		} else {
			Parser.addError("Argument expected");
		}
		Parser.t = Lexer.lex();

		if (Parser.t instanceof RParenToken) {
		} else {
			Parser.addError("')' expected");
		}
		Parser.t = Lexer.lex();

		while (!(Parser.t instanceof PROCToken || Parser.t instanceof EOIToken)){
			stmts.findStmts();
		}

		return new Proc(name, arg, stmts);
	}

	public void codegen() {
		Writer.write("/" + name + "{");
		stmts.codegen();
		Writer.write("} def");
	}

	public String getName(){
		return this.name;
	}

	public void compareArgs(){
		for (Stmt s: stmts.getStmts()){
			if (s instanceof IfStmt){
				for (Stmt ifs : ((IfStmt)s).getThens().getStmts() ){
					testArgs(ifs.getExpr());
				}
				for (Stmt elses : ((IfStmt)s).getElses().getStmts() ){
					testArgs(elses.getExpr());
				}
			}
			testArgs(s.getExpr());
		}
	}
	
	public void testArgs(Expr e) {
		if (e instanceof IdentExpr){
			IdentExpr x = (IdentExpr) e;
			if (!x.getName().equals(arg)){
				Parser.addError("Unknown variable " + x.getName(), x.getLine());
			}
		}
	}
}
