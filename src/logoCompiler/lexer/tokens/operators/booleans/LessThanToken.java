package logoCompiler.lexer.tokens.operators.booleans;

import logoCompiler.lexer.tokens.operators.OperatorToken;


public class LessThanToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "lt";
	}

	@Override
	public int precedence() {
		return 1;
	}

}
