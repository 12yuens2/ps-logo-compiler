package logoCompiler.lexer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.Token;

public final class Lexer {
	static int ch = ' ';
	static String file;
	static Scanner scanner;
	public static int lineNumber = 1;
	
	public static Token lex() {
		if (scanner.hasNext()){
			String token = scanner.next();
// Debugging
//			System.out.println(token);
			while (token.equals("N_E_W_L_I_N_E")){
				if (scanner.hasNext()){
					lineNumber++;
					token = scanner.next();
				} else {
					return new EOIToken();
				}
			}
			return Dictionary.findToken(token.toUpperCase().trim());			
		} else {
			return new EOIToken();
		}
	}

	/**
	 * Processes the specified file and re-opens the Scanner object to begin tokenization.
	 * @param filename the file name
	 * @throws FileNotFoundException
	 */
	public static void init(String filename) throws FileNotFoundException {
		scanner = new Scanner(new File("src/LogoPrograms/" + filename));
		scanner.useDelimiter("\\z");
		file = scanner.next();
		file = Dictionary.processText(file);
		scanner.close();
		scanner = new Scanner(file);
	}

}
