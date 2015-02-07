package logoCompiler.lexer;

import logoCompiler.lexer.tokens.*;
import logoCompiler.lexer.tokens.keywords.*;
import logoCompiler.lexer.tokens.operators.*;
import logoCompiler.lexer.tokens.operators.booleans.*;

public class Dictionary {

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
		case"-":
			return new MinusToken();
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
		case ")" :
			return new RParenToken();
		case "(" :
			return new LParenToken();
		default:
			try {
				Integer.parseInt(token.trim());
				return new NumToken(token);
			} catch (NumberFormatException e) {
				return new IdentToken(token.trim());
			}
		}
	}

	public static String processText(String s){
		return s
				.replaceAll(">=", " >= ")
				.replaceAll("<=", " <= ")
				.replaceAll("==", " == ")
				.replaceAll("\\(", " ( ")
				.replaceAll("\\)", " ) ")
				.replaceAll("\\+", " + ")
				.replaceAll("\\-", " - ")
				.replaceAll("\\/", " / ")
				.replaceAll("\\*", " * ")
				.replaceAll("<", " < ")
				.replaceAll(">"," > ")
				.replaceAll("> =", ">=")
				.replaceAll("< =", "<=")
				.replaceAll("!=", " != ")
				.replaceAll("\n", " N_E_W_L_I_N_E ");
		
	}
	
}
