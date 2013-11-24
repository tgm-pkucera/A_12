package at.rene8888.au04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;

import at.rene8888.au04.jgrep.JGrep;

/**
 * Main Klasse
 * 
 * @author Rene Hollander 3AHIT
 * 
 */
public class Main {

	/**
	 * Main Methode
	 * 
	 * @param args
	 *            Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		new Main(args);
	}

	private boolean running;
	private Scanner s;

	/**
	 * @param args
	 *            Kommandzeilenargumente
	 */
	public Main(String[] args) {
		this.running = true;
		if ((args.length == 2) && (args[1].equals("--"))) {
			this.s = new Scanner(System.in);
			System.out.print("in >");
			while (s.hasNext() && this.running) {
				String in = s.nextLine();
				String ret = JGrep.grep(args[0], in, true);
				if (ret != null) {
					AnsiConsole.out.println("out>" + ret);
				} else {
					AnsiConsole.out.println("out>Regex Pattern not matching!");
				}
				System.out.print("in >");
			}
		} else if (args.length >= 2) {
			for (int i = 1; i < args.length; i++) {
				File f = new File(args[i]);
				if (f.exists() && f.isFile()) {
					try {
						System.out.println(f.getName() + ":");
						JGrep.grepToConsole(args[0], f, true);
						System.out.println("");
					} catch (IOException e) {
						e.printStackTrace();
						continue;
					}
				} else {
					System.out.println("Invalid File!");
					continue;
				}
			}
		} else if (args.length < 2) {
			System.out.println("Arguments: jgrep.jar <regex> <file> [file, ...] or jgrep.jar <regex> <-->!");
		} else {
			System.out.println("Unexpected Error!");
		}
	}
}
