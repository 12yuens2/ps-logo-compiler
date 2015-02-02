package logoCompiler.lexer.tokens.operators.booleans;

import logoCompiler.lexer.tokens.operators.OperatorToken;


public class NotEqualsToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "ne";
	}

	@Override
	public int precedence() {
		return 1;
	}

}
