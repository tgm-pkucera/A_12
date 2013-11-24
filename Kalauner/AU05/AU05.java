import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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

		FileReader fr;
		BufferedReader br;
		try {
			for (int i = 1; i < args.length; i++) {
				if (args[i].equals("--")) {
					@SuppressWarnings("resource")
					Scanner scan = new Scanner(System.in);
					Pattern p = Pattern.compile(pattern);
					while (true) {
						System.out.print("Enter string: ");
						System.out.print(JGrep.jgrep(scan.nextLine(), p));
					}
				} else {
					fr = new FileReader(new File(args[i]));
					br = new BufferedReader(fr);
					String s;
					ArrayList<String> input = new ArrayList<String>();
					while ((s = br.readLine()) != null) {
						input.add(s);
					}
					System.out.println(args[i] + ":\n");
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
