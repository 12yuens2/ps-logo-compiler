package logoCompiler.lexer.tokens.operators;


public class MinusToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "sub";
	}

	@Override
	public int precedence() {

		return 2;
	}

}
