package logoCompiler.lexer.tokens.operators.booleans;

import logoCompiler.lexer.tokens.operators.OperatorToken;


public class GreaterOrEqualsToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "ge";
	}

	@Override
	public int precedence() {
		return 1;
	}

}
