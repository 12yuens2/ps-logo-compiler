package logoCompiler.parser.stmts;

import java.util.ArrayList;

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
}
