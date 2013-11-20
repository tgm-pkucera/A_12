package at.rene8888.au04;

import java.io.File;
import java.io.IOException;

import at.rene8888.au04.jgrep.JGrep;

public class Main {

	public static void main(String[] args) throws IOException {
		
		if (args.length == 2) {
			
			String pattern = args[1];
			String filename = args[0];
			
			File f = new File(filename);
			if (f.exists() && f.isFile()) {
				String[] out = JGrep.grep(pattern, f);
				for (String s : out) {
					System.out.println(s);
				}
			} else {
				System.out.println("Invalid File!");
			}
			
		} else if (args.length < 2){
			System.out.println("Not enough arguments!");
		} else if (args.length > 2) {
			System.out.println("Too many arguments!");
		} else {
			System.out.println("Unexpected Error!");
		}
		
	}
	
}
