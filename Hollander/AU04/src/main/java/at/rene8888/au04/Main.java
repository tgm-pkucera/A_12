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
	 * @param args Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		new Main(args);
	}

	private boolean running;
	private Scanner s;

	/**
	 * @param args Kommandzeilenargumente
	 */
	public Main(String[] args) {
		this.running = true;
		if ((args.length == 2) && (args[1].equals("--"))) {
			Runtime.getRuntime().addShutdownHook(new ShutdownThread(this));
			this.s = new Scanner(System.in);
			while (s.hasNext() && this.running) {
				String in = s.nextLine();
				String ret = JGrep.grep(args[0], in, true);
				if (ret != null) {
					AnsiConsole.out.println(ret);
				}
			}
		} else if (args.length >= 2) {

			File[] files = new File[args.length - 1];

			for (int i = 1; i < args.length; i++) {
				File f = new File(args[i]);
				if (f.exists() && f.isFile()) {
					files[i - 1] = f;
				} else {
					System.out.println("Invalid File!");
					return;
				}
			}

			for (File f : files) {
				try {
					String[] out = JGrep.grep(args[0], f, true);
					for (String s : out) {
						AnsiConsole.out.println(s);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (args.length < 2) {
			System.out.println("Not enough arguments!");
		} else {
			System.out.println("Unexpected Error!");
		}
	}

	/**
	 * Methode um den Scanner zu beenden
	 */
	public void stop() {
		this.running = false;
		this.s.close();
	}

}
