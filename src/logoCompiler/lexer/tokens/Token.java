package logoCompiler.lexer.tokens;

public abstract class Token {
	
	static int x = 0;
	
	public int precedence() {
		//set precedence of all non-operators to 0
		//Override this for Operators
	    return 0;
	  }
	
	public Token(){
// Debugging
//		System.out.println(this);
	}
}
