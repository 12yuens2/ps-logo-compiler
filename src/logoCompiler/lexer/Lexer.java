package logoCompiler.lexer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.LParenToken;
import logoCompiler.lexer.tokens.RParenToken;
import logoCompiler.lexer.tokens.Token;
import logoCompiler.lexer.tokens.operators.DivideToken;
import logoCompiler.lexer.tokens.operators.MinusToken;



public final class Lexer {
	static int ch = ' ';
	static File logoFile = new File("src/LogoPrograms/dragon.t");
	static FileReader reader;
	static String file;
	static Scanner scanner;
	public static int lineNumber = 1;
	
	public static Token lex() {
		
		if (scanner == null){
			initReader();
		}
		if (scanner.hasNext()){
			String token = scanner.next();
			System.out.println(token);
			while (token.equals("NEWLINE")){
				if (scanner.hasNext()){
					lineNumber++;
					token = scanner.next();
				} else {
					return new EOIToken();
				}
			}
			return Dictionary.findToken(token);			
		} else {
			return new EOIToken();
		}

	}

	static void initReader() {
		try {
			reader = new FileReader(logoFile);
			scanner = new Scanner(logoFile);
			scanner.useDelimiter("\\z");
			file = scanner.next();
			file = Dictionary.processText(file);
			scanner.close();
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
