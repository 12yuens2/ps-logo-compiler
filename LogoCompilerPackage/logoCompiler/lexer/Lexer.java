package logoCompiler.lexer;
import java.util.*;


public final class Lexer {
  static int ch = ' ';

  public static Token lex() {

    //skip the white space
    while (ch == ' ' || ch == '\n' || ch == '\t') {
 	ch = getChar();
    }

    //identify new character and return correct token
    switch (ch) {
    	case -1 : {
	    return new EOIToken();
    	}
    }
  }

  
  //this reads chars from stdin. You can read in files any way you want, using FileReader etc.
  static int getChar() {
    try {
      ch = System.in.read();
    } catch (Exception e) {
      System.out.println(e); System.exit(1);
    }
    return ch;
  }
}
