package logoCompiler.lexer.tokens.operators.booleans;

import logoCompiler.lexer.tokens.operators.OperatorToken;

public class BooleanEqualsToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "eq";
	}

	@Override
	public int precedence() {
		return 1;
	}

}
