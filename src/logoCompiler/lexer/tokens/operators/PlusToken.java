package logoCompiler.lexer.tokens.operators;

public class PlusToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "add";
	}

	@Override
	public int precedence() {
		return 2;
	}

}
