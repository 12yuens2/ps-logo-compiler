package logoCompiler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
	
	static PrintWriter writer = null;
	private static final String filename = "src/GhostScript/result.gs";
	
	public static void init(){
		try {
			writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			System.err.println("Something went wrong. :(");
		}
	}
	
	public static void write(String s){
		if (writer == null) { 
			Writer.init(); 
		}
		writer.println(s);
	}
	
	public static void close(){
		writer.close();
	}
}
