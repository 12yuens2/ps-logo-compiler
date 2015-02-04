package logoCompiler.parser;
import  logoCompiler.lexer.*;
import java.util.*;
/*
 * prog:
 *   { proc }
 */
public class Prog {
	
	List<Proc> procs;	
	
	public Prog(List<Proc> procs) {
		this.procs = procs;
	}
	
  public static Prog parse() {
	 List<Proc> procs = new ArrayList<Proc>();
	 procs.add(Proc.parse());

    while (Parser.t instanceof PROCToken) {
   	    procs.add(Proc.parse());
    }
    if (Parser.t instanceof EOIToken) {
      Parser.t = Lexer.lex();
    } else {
      //error?
    } 
    return new Prog(procs);
  }

  public void codegen() {
	ListIterator<Proc> li = procs.listIterator();
    while (li.hasNext()) {
        li.next().codegen();
     } 
  } 
}
