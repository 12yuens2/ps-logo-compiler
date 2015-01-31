package logoCompiler.lexer;

public abstract class OperatorToken extends Token {
	public abstract String psOpCode();
	public abstract int precedence();
}
