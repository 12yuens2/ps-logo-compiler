package logoCompiler.lexer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.LParenToken;
import logoCompiler.lexer.tokens.RParenToken;
import logoCompiler.lexer.tokens.Token;
import logoCompiler.lexer.tokens.operators.DivideToken;
import logoCompiler.lexer.tokens.operators.MinusToken;



public final class Lexer {
	static int ch = ' ';
	static File logoFile = new File("src/LogoPrograms/fractal.t");
	static FileReader reader;
	public static int lineNumber = 1;

	final static int LPAREN = (int) ( (char) "(".charAt(0));
	final static int RPAREN = (int) ( (char) ")".charAt(0));
	final static int MINUS = (int) ( (char) "-".charAt(0));
	final static int PLUS = (int) ( (char) "+".charAt(0));
	final static int DIVIDE = (int) ( (char) "/".charAt(0));
	final static int MULTIPLY = (int) ( (char) "*".charAt(0));
	final static int EQUALS = (int) ( (char) "=".charAt(0));
	final static int EXCLAMATION = (int) ( (char) "!".charAt(0));
	final static int GREATERTHAN = (int) ( (char) ">".charAt(0));
	final static int LESSTHAN = (int) ( (char) "<".charAt(0));
	
	public static Token lex() {
		
		//skip the white space
		while (ch == ' ' || ch == '\n' || ch == '\t' ) {
			if (ch == '\n') {
				lineNumber++;
			}
			ch = getChar();
			
		}
				
		Token t = Dictionary.findToken(ch);
		if (t instanceof EOIToken){
			try {
				Lexer.reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (t instanceof LParenToken || t instanceof RParenToken || t instanceof DivideToken || t instanceof MinusToken){
			ch = getChar();
		}
		
		if (t != null){
			return t;
		} else {
			// get the string token
			String token = Character.toString((char)ch);
			while (ch != ' ' && ch != '\n' && ch != '\t' && ch != RPAREN && ch != LPAREN && ch != MINUS && ch != DIVIDE ) {
				ch = getChar();
				if (ch != RPAREN && ch != LPAREN){
					token = token.concat(Character.toString((char) ch));	     		
				} else {
				}
				
			}
			//identify new character and return correct token
			return Dictionary.findToken(token);
		}	

	}
	
	//this reads chars from stdin. You can read in files any way you want, using FileReader etc.
	static int getChar() {
		if (reader == null){
			initReader();
		}
		try {

			ch = reader.read();
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		return ch;
	}

	static void initReader() {
		try {
			reader = new FileReader(logoFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
