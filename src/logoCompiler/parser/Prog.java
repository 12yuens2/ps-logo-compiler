package logoCompiler.parser;
import  logoCompiler.lexer.*;
import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.keywords.PROCToken;

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

		if (!(Parser.t instanceof PROCToken)){
			Parser.addError("Missing 'PROC'");
		}

		procs.add(Proc.parse());

		while (Parser.t instanceof PROCToken) {
			procs.add(Proc.parse());
		}

		if (Parser.t instanceof EOIToken) {
			Parser.t = Lexer.lex();

		} else {

		}
		return new Prog(procs);
	}

	public void codegen() {
		ListIterator<Proc> li = procs.listIterator();
		while (li.hasNext()) {
			li.next().codegen();
		} 
	}

	public ArrayList<String> getProcNames(){
		ArrayList<String> names = new ArrayList<>();

		for (Proc p : procs){
			names.add(p.getName());
		}
		return names;
	}
	
	public void compare(){
		for (Proc p: procs) {
			p.compareArgs();
		}
	}
}
