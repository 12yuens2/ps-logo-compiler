package logoCompiler.lexer.tokens;

public class NumToken extends Token{
	
	private String num;
	
	public NumToken(String i){
		this.num = i;
	}
	
	public String getNumber(){
		return num;
	}
}
