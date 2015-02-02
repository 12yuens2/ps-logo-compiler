package logoCompiler.lexer.tokens.operators;


public class DivideToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "div";
	}

	@Override
	public int precedence() {
		return 3;
	}

}
