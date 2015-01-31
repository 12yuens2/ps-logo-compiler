package logoCompiler.lexer;
import java.awt.font.NumericShaper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public final class Lexer {
  static int ch = ' ';
  static File logoFile = new File("src/LogoPrograms/dragon.t");
  static FileReader reader;

  public static Token lex() {

    //skip the white space
    while (ch == ' ' || ch == '\n' || ch == '\t') {
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
	  
	  switch (token.trim()) {
	  case "(":
		  ch = getChar();
		  return new LParenToken();
	  case ")":
		  ch = getChar();
		  return new RParenToken();
	  }
	  
	    while (ch != ' ' && ch != '\n' && ch != '\t') {
	     	ch = getChar();
	     	token = token.concat(Character.toString((char) ch));
	     	System.out.println(token);
        }
	    switch (token.toUpperCase().trim()){
	    case "PROC":
	    	return new PROCToken();
		default:
			return getOtherToken(token);
	    	//...
	    }
	  
  }
  
  static Token getOtherToken(String token) {
	  try {
		  Integer.parseInt(token);
		  return new NumToken();
	  } catch (NumberFormatException e) {
		  return new IdentToken();
	  }
  }
}
