package logoCompiler.lexer;
import java.awt.font.NumericShaper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import logoCompiler.lexer.tokens.EOIToken;
import logoCompiler.lexer.tokens.IdentToken;
import logoCompiler.lexer.tokens.LParenToken;
import logoCompiler.lexer.tokens.NumToken;
import logoCompiler.lexer.tokens.RParenToken;
import logoCompiler.lexer.tokens.Token;
import logoCompiler.lexer.tokens.keywords.ELSEToken;
import logoCompiler.lexer.tokens.keywords.ENDIFToken;
import logoCompiler.lexer.tokens.keywords.FORWARDToken;
import logoCompiler.lexer.tokens.keywords.IFToken;
import logoCompiler.lexer.tokens.keywords.LEFTToken;
import logoCompiler.lexer.tokens.keywords.MAINToken;
import logoCompiler.lexer.tokens.keywords.PROCToken;
import logoCompiler.lexer.tokens.keywords.RIGHTToken;
import logoCompiler.lexer.tokens.keywords.THENToken;
import logoCompiler.lexer.tokens.keywords.VOIDToken;
import logoCompiler.lexer.tokens.operators.BooleanEqualsToken;
import logoCompiler.lexer.tokens.operators.DivideToken;
import logoCompiler.lexer.tokens.operators.EqualsToken;
import logoCompiler.lexer.tokens.operators.GreaterOrEqualsToken;
import logoCompiler.lexer.tokens.operators.GreaterThanToken;
import logoCompiler.lexer.tokens.operators.LessOrEqualsToken;
import logoCompiler.lexer.tokens.operators.LessThanToken;
import logoCompiler.lexer.tokens.operators.MinusToken;
import logoCompiler.lexer.tokens.operators.MultiplyToken;
import logoCompiler.lexer.tokens.operators.NotEqualsToken;
import logoCompiler.lexer.tokens.operators.OperatorToken;
import logoCompiler.lexer.tokens.operators.PlusToken;


public final class Lexer {
  static int ch = ' ';
  static File logoFile = new File("src/LogoPrograms/dragon.t");
  static FileReader reader;
  final static int LPAREN = (int) ( (char) "(".charAt(0));
  final static int RPAREN = (int) ( (char) ")".charAt(0));
  
  public static Token lex() {

    //skip the white space
    while (ch == ' ' || ch == '\n' || ch == '\t' ) {
    	ch = getChar();
    }

    //identify new character and return correct token
    switch (ch) {
    	case -1 : {
    		try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    return new EOIToken();
    	}
    	default: {
    		if (ch == LPAREN){
    			ch = getChar();
    			return new LParenToken();
    		}
    		if (ch == RPAREN){
				ch = getChar();
    			return new RParenToken();
    		}
    		return getToken(ch);
    	}
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
      System.out.println(e); System.exit(1);
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
  
  static Token getToken(int ch){
	  String token = Character.toString((char)ch);
	  
	    while (ch != ' ' && ch != '\n' && ch != '\t' && ch != RPAREN) {
	    	ch = getChar();
	     	if (ch != RPAREN){
	     		token = token.concat(Character.toString((char) ch));	     		
	     	}
	     	System.out.println(token);
        }
	    switch (token.toUpperCase().trim()){
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
	    case "MAIN":
	    	return new MAINToken();
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
	    case "=" :
	    	return new EqualsToken();
		default:
			return getOtherToken(token);
	    	//...
	    }
	  
  }
  
  static Token getOtherToken(String token) {
	  try {
		  Integer.parseInt(token.trim());
		  return new NumToken();
	  } catch (NumberFormatException e) {
		  return new IdentToken();
	  }
  }
}
