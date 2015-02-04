package logoCompiler.lexer;
public abstract class Token {
	public int precedence() {
		//set precedence of all non-operators to 0
		//Override this for Operators
	    return 0;
	  } 
}
