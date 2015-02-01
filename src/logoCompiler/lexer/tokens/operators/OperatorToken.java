package logoCompiler.lexer.tokens.operators;

import logoCompiler.lexer.tokens.Token;

public abstract class OperatorToken extends Token {
	public abstract String psOpCode();
	public abstract int precedence();
}
