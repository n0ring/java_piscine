package edu.school21.printer.app;
import edu.school21.printer.logic.*;

public class Program {
	public static void main(String[] args) {
		char	white, black;
		Printer printer = new Printer();

		if (args.length != 2) {
			System.out.println("Incorrect args (not 2)");
			System.exit(-1);
		}
		white = args[0].toCharArray()[0];
		black = args[1].toCharArray()[0];
		
		try {
			printer.setImageChar(black, white);
			printer.printImage();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
