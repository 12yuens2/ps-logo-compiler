package logoCompiler.lexer.tokens.keywords;

public class IdentToken extends StatementToken{
	
	private String name;
	
	public IdentToken(String n){
		this.name = n;
	}
	
	public String getName() {
		return name;
	}

}
