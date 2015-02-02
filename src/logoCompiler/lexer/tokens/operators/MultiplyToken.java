package logoCompiler.lexer.tokens.operators;


public class MultiplyToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "mul";
	}

	@Override
	public int precedence() {
		return 3;
	}

}
