package logoCompiler.lexer.tokens.operators.booleans;

import logoCompiler.lexer.tokens.operators.OperatorToken;


public class GreaterThanToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "gt";
	}

	@Override
	public int precedence() {
		return 1;
	}

}
