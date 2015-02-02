package logoCompiler.parser.stmts;

import java.util.ArrayList;
import java.util.ListIterator;

import logoCompiler.parser.Proc;

public class Stmts {

	private ArrayList<Stmt> stmts;

	public Stmts(){
		stmts = new ArrayList<Stmt>();
	}
	
	public void add (Stmt s){
		stmts.add(s);
	}
	
	public ArrayList<Stmt> getStmts(){
		return stmts;
	}

	public void codegen() {
		for (Stmt s: stmts){
			s.codegen();
		}
	}
}
