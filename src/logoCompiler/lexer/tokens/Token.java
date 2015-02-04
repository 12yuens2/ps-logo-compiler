package logoCompiler.lexer.tokens;

import logoCompiler.parser.Parser;

public abstract class Token {
	
	static int x = 0;
	
	public int precedence() {
		//set precedence of all non-operators to 0
		//Override this for Operators
	    return 0;
	  }
	
	public Token(){
		if (x < 90){
			x++;
			System.out.println(this);			
		}

	}
}
