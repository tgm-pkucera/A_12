/**
 * The JGrep package
 */
package at.hampl.jgrep;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.fusesource.jansi.AnsiConsole; For Microsoft Windows

/**
 * Implements the UNIX grep command in java
 * 
 * @author Burkhard Hampl
 * @version 1.0
 */
public class JGrep {
	private RandomAccessFile f;
	private Pattern p;
	private int fileFor;

	/**
	 * The Constructor
	 * 
	 * @param args
	 *            The commandline arguments
	 */
	public JGrep(String[] args) {
		try {
			p = Pattern.compile(args[0]);
			for (this.fileFor = 1; this.fileFor < args.length; this.fileFor++) {
				System.out.println(args[this.fileFor] + ":");
				if (args[this.fileFor].equals("--")) {
					Scanner s = new Scanner(System.in);
					while (s.hasNext()) {
						String userInput = s.next();
						Matcher m = p.matcher(userInput);
						boolean matchFound = false;
						StringBuffer sb = new StringBuffer(userInput.length());
						while (m.find()) {
							m.appendReplacement(sb, "\u001b[31m$0\u001b[0m");
							matchFound = true;
						}
						m.appendTail(sb);
						if (matchFound) {
							//AnsiConsole.out.println(sb); For Microsoft Windows
							System.out.println(sb);
						}
					}
					s.close();
				} else {
					this.f = new RandomAccessFile(args[this.fileFor], "r");
					String input = "";
					while (true) {
						input = f.readLine();
						if (input == null)
							break;
						Matcher m = p.matcher(input);
						boolean matchFound = false;
						StringBuffer sb = new StringBuffer(input.length());
						while (m.find()) {
							m.appendReplacement(sb, "\u001b[31m$0\u001b[0m");
							matchFound = true;
						}
						m.appendTail(sb);
						if (matchFound) {
							//AnsiConsole.out.println(sb); For Microsoft Windows
							System.out.println(sb);
						}
					}
					f.close();
					System.out.println("");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Usage: java JGrep <pattern> <file>...");
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found: " + args[this.fileFor]);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				f.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * The main method
	 * 
	 * @param args
	 *            The commandline arguments
	 */
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		JGrep grep = new JGrep(args);
	}
}
