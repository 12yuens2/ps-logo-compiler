package logoCompiler;

import java.io.FileNotFoundException;

import logoCompiler.lexer.*;
import logoCompiler.parser.*;
import logoCompiler.parser.stmts.IdentStmt;
import logoCompiler.Writer;

public class LogoPSCompiler {
	public static void main(String[] args) {

		if (args.length != 2){
			System.err.println("Incorrect parameters.\n\tUsage: LogoPSCompiler input_file output_file\nThe file names are relative to their respective folders.");
			System.err.println("Example usage: LogoPSCompiler dragon.t dragon.gs");
			System.exit(0);
		}
		
		try {
			Lexer.init(args[0]);
			Writer.init(args[1]);
		} catch (FileNotFoundException e) {
			System.err.println("There was a problem with opening the specified file.");
		}
		
		Parser.t = Lexer.lex();
		Prog prog = Prog.parse();
		IdentStmt.compare(prog.getProcNames());
		prog.compare();
		
		if (Parser.errors.isEmpty()) {
			psPrologue();
			prog.codegen();
			psEpilogue();
			System.out.println("No problems found.\nOutput file created.");
		} else {
			Parser.printErrors();
			System.err.println("Output file not created.");
		}
		Writer.close();
	}

	public static void psPrologue() {
		Writer.write("%!PS-Adobe-3.0");	// Adobe header
		/* rest of prologue ... */
		Writer.write("/Xpos    { 300 } def");
		Writer.write("/Ypos    { 500 } def");
		Writer.write("/Heading { 0   } def");
		Writer.write("/Arg     { 0   } def");
		//Implementation of Right, Left and Forward procedures in PostScript
		Writer.write("/Right   {");
		Writer.write("Heading exch add Trueheading");
		Writer.write("/Heading exch def");
		Writer.write("} def");

		Writer.write("/Left {");
		Writer.write("Heading exch sub Trueheading");
		Writer.write("/Heading exch def");
		Writer.write("} def");

		Writer.write("/Trueheading {");
		Writer.write("360 mod dup");
		Writer.write("0 lt { 360 add } if");
		Writer.write("} def");

		Writer.write("/Forward {");
		Writer.write("dup  Heading sin mul");
		Writer.write("exch Heading cos mul");
		Writer.write("2 copy Newposition");
		Writer.write("rlineto");
		Writer.write("} def");

		Writer.write("/Newposition {");
		Writer.write("Heading 180 gt Heading 360 lt");
		Writer.write("and { neg } if exch");
		Writer.write("Heading  90 gt Heading 270 lt");
		Writer.write("and { neg } if exch");
		Writer.write("Ypos add /Ypos exch def");
		Writer.write("Xpos add /Xpos exch def");
		Writer.write("} def");
	}

	public static void psEpilogue() {
		/* epilogue ... */
		Writer.write("Xpos Ypos moveto");
		//Call Main to start
		Writer.write("MAIN");
		Writer.write("stroke");
		Writer.write("showpage");
	}
}
