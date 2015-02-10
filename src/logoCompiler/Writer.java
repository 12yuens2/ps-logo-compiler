package logoCompiler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
	
	static PrintWriter writer = null;

	public static void init(String filename) throws FileNotFoundException{
		writer = new PrintWriter("src/GhostScript/" + filename);
	}
	
	public static void write(String s){
		if (writer == null) { 
			return;
		}
		writer.println(s);
	}
	
	public static void close(){
		writer.close();
	}
}
