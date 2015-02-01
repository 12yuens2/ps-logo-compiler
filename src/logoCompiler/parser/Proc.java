package logoCompiler.parser;
import  logoCompiler.lexer.*;
import logoCompiler.lexer.tokens.*;
import logoCompiler.lexer.tokens.keywords.FORWARDToken;
import logoCompiler.lexer.tokens.keywords.IFToken;
import logoCompiler.lexer.tokens.keywords.IdentToken;
import logoCompiler.lexer.tokens.keywords.LEFTToken;
import logoCompiler.lexer.tokens.keywords.PROCToken;
import logoCompiler.lexer.tokens.keywords.RIGHTToken;
import logoCompiler.lexer.tokens.keywords.StatementToken;
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
      Parser.t = Lexer.lex();
    } else {
      //error?
    }
    if (Parser.t instanceof LParenToken) {
      Parser.t = Lexer.lex();
    } else {
      //error?
    }
    if (Parser.t instanceof IdentToken) {
        arg = ((IdentToken) Parser.t).getName();
        Parser.t = Lexer.lex();
      } else {
        //error?
      }    
    if (Parser.t instanceof RParenToken) {
        Parser.t = Lexer.lex();
    } else {
        //error?
    }
    
    while (!(Parser.t instanceof PROCToken)){
        if (Parser.t instanceof IFToken){
        	stmts.add(IfStmt.parse());
        } else if (Parser.t instanceof FORWARDToken){
        	stmts.add(ForwardStmt.parse());
        } else if (Parser.t instanceof LEFTToken){
        	stmts.add(LeftStmt.parse());
        } else if (Parser.t instanceof RIGHTToken){
        	stmts.add(RightStmt.parse());
        } else if (Parser.t instanceof IdentToken){
        	stmts.add(IdentStmt.parse());
        }
    }
    
    System.out.println("FINISHED PROC");
    return new Proc(name, arg, stmts);
  }

  public void codegen() {
    System.out.print("/");
    System.out.print(name);
    System.out.println(" {");
//    stmts.codegen();
    System.out.println("} def");
  }
}
