package logoCompiler.lexer;

import logoCompiler.lexer.tokens.*;
import logoCompiler.lexer.tokens.keywords.*;
import logoCompiler.lexer.tokens.operators.*;
import logoCompiler.lexer.tokens.operators.booleans.*;

public class Dictionary {

	final static int LPAREN = (int) ( (char) "(".charAt(0));
	final static int RPAREN = (int) ( (char) ")".charAt(0));
	final static int MINUS = (int) ( (char) "-".charAt(0));
	final static int PLUS = (int) ( (char) "+".charAt(0));
	final static int DIVIDE = (int) ( (char) "/".charAt(0));
	final static int MULTIPLY = (int) ( (char) "*".charAt(0));
	final static int EQUALS = (int) ( (char) ")".charAt(0));
	final static int EXCLAMATION = (int) ( (char) ")".charAt(0));
	final static int GREATERTHAN = (int) ( (char) ")".charAt(0));
	final static int LESSTHAN = (int) ( (char) ")".charAt(0));

	public static Token findToken(int ch){

		if (ch == -1) {
			return new EOIToken();
		} else if (ch == LPAREN) {
			return new LParenToken();
		} else if (ch == RPAREN) {
			return new RParenToken();
		} else if (ch == PLUS) {
			return new PlusToken();
		} else if (ch == MINUS) {
			return new MinusToken();
		} else if (ch == DIVIDE) {
			return new DivideToken();
		} else if (ch == MULTIPLY) {
			return new MultiplyToken(); 
		} else { 
			return null;
		}

		/*switch (ch){
		case -1:
			return new EOIToken();
		case LPAREN:
			return new LParenToken();
		case RPAREN:
			return new RParenToken();
		case MINUS:
			return new MinusToken();
		case PLUS:
			return new PlusToken();
		case DIVIDE:
			return new DivideToken();
		case MULTIPLY:
			return new MultiplyToken();
		default:
			return null;
		}*/
	}
	
	public static Token findBooleanToken(String token) {
		switch(token){
		case "==": 
			return new BooleanEqualsToken();
		case"!=":
			return new NotEqualsToken();
		case "<=" :
			return new LessOrEqualsToken();
		case ">=" :
			return new GreaterOrEqualsToken();
		default :
			return null;
		}
	}


	public static Token findToken(String token){
		switch (token.trim()){
		case "PROC":
			return new PROCToken();
		case "IF":
			return new IFToken();
		case "ELSE":
			return new ELSEToken();
		case "ENDIF":
			return new ENDIFToken();
		case "FORWARD":
			return new FORWARDToken();
		case "RIGHT":
			return new RIGHTToken();
		case "LEFT":
			return new LEFTToken();
		case "THEN":
			return new THENToken();
			/*	    case "MAIN":
	    	return new MAINToken(); */
		case "VOID":
			return new VOIDToken();
		case "==": 
			return new BooleanEqualsToken();
			/*	case"-":
		return new MinusToken(); */
		case"+":
			return new PlusToken();
		case"*":
			return new MultiplyToken();
		case"/":
			return new DivideToken(); 
		case"!=":
			return new NotEqualsToken();
		case "<" :
			return new LessThanToken();
		case "<=" :
			return new LessOrEqualsToken();
		case ">" :
			return new GreaterThanToken();
		case ">=" :
			return new GreaterOrEqualsToken();
		default:
			try {
				Integer.parseInt(token.trim());
				return new NumToken(token);
			} catch (NumberFormatException e) {
				return new IdentToken(token.trim());
			}
		}
	}

	public static boolean isSpecial(int ch) {
		return ( ch == EQUALS || ch == EXCLAMATION || ch == GREATERTHAN || ch == LESSTHAN);
	}
	
	public static String processText(String s){
		return s
				.replaceAll(">=", " >= ")
				.replaceAll("<=", " <= ")
				.replaceAll("==", " == ")
				.replaceAll("(", " ( ")
				.replaceAll(")", " ) ")
				.replaceAll("+", " + ")
				.replaceAll("-", " - ")
				.replaceAll("/", " / ")
				.replaceAll("*", " * ");
		
	}
	
}
