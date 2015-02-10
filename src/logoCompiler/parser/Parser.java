package logoCompiler.parser;
import java.util.ArrayList;

import  logoCompiler.lexer.*;
import logoCompiler.lexer.tokens.Token;

public final class Parser {
	public static Token t;
	public static boolean error = false;

	public static ArrayList<Error> errors = new ArrayList<>();
	
	public static void addError(String s) {
		addError(s, Lexer.lineNumber);
	}
	
	public static void addError(String s, int l){
		//Avoiding multiple errors on the same line.
		if (errors.isEmpty() ||errors.get(errors.size()-1).getLineNumber() != Lexer.lineNumber) { 
			errors.add(new Error(s, l));
		}
	}
	
	public static void printErrors() {
		for (Error e : errors) {
			e.printError();
		}
	}

}
