package at.sew.au05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AU05
 * 
 * @author Paul Kalauner 3AHIT
 * 
 */
public class AU05 {
	/**
	 * Main
	 * 
	 * @param args
	 *            pattern file
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Invalid arguments");
			System.out.println("Usage:\njgrep <Regex-Pattern> <file 1> <file 2> <file n>");
			System.exit(1);
		}

		String pattern = args[0];

		String[] files = new String[args.length - 1];
		for (int i = 0; i < files.length; i++)
			files[i] = args[i + 1];

		FileReader fr;
		BufferedReader br;
		try {
			for (int i = 0; i < files.length; i++) {
				if (files[i].equals("--")) {
					@SuppressWarnings("resource")
					Scanner scan = new Scanner(System.in);
					while (true) {
						System.out.print("Enter string: ");
						String[] in = { scan.nextLine() };
						System.out.print(JGrep.jgrep(in, pattern));
					}
				} else {
					fr = new FileReader(new File(files[i]));
					br = new BufferedReader(fr);
					String s;
					ArrayList<String> input = new ArrayList<String>();
					while ((s = br.readLine()) != null) {
						input.add(s);
					}
					System.out.println(files[i] + ":\n");
					System.out.println(JGrep.jgrep(input.toArray(new String[input.size()]), pattern));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		} catch (Exception e) {
			System.exit(1);
		}
	}
}
