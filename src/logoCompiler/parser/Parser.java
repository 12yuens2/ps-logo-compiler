package logoCompiler.parser;
import java.util.ArrayList;

import  logoCompiler.lexer.*;
import logoCompiler.lexer.tokens.Token;

public final class Parser {
	public static Token t;
	public static boolean error = false;

	public static ArrayList<String> errors = new ArrayList<>();
	
	public static void addError(String s) {
		errors.add(s+" on line number " + Lexer.lineNumber + ".");
	}
	
	public static void addError(String s, int l){
		errors.add(s+" on line number "+ l + ".");
	}
	
	public static void printErrors() {
		for (String s : errors) {
			System.err.println(s);
		}
	}

}
