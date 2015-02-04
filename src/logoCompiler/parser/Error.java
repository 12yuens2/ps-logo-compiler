package logoCompiler.parser;

import logoCompiler.lexer.Lexer;

public class Error {

	private String errorMessage;
	private int lineNumber;
	
	public Error(String s, int lineNumber) {
		this.errorMessage = s;
		this.lineNumber = lineNumber;
	}
	
	public Error(String s) {
		this(s, Lexer.lineNumber);
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public void printError() {
		System.err.println(errorMessage+" on line number "+lineNumber+".");
	}
	
}
