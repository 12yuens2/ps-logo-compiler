package logoCompiler.lexer.tokens.operators.booleans;

import logoCompiler.lexer.tokens.operators.OperatorToken;


public class LessOrEqualsToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "le";
	}

	@Override
	public int precedence() {
		return 1;
	}

}
