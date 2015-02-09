package logoCompiler.lexer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.Token;



public final class Lexer {
	static int ch = ' ';
	static File logoFile = new File("src/LogoPrograms/dragon.t");
	static String file;
	static Scanner scanner;
	public static int lineNumber = 1;
	
	public static Token lex() {
		
		if (scanner == null){
			initReader();
		}
		if (scanner.hasNext()){
			String token = scanner.next();
			while (token.equals("N_E_W_L_I_N_E")){
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
			scanner = new Scanner(logoFile);
			scanner.useDelimiter("\\z");
			file = scanner.next();
			file = Dictionary.processText(file);
			scanner.close();
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("The requested file was not found.");
		}
	}


}
