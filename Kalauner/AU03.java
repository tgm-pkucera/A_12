package at.sew.au03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Paul Kalauner 3AHIT
 *
 */
public class AU03 {
	/**
	 * Main
	 * @param args
	 * file pattern
	 */
	public static void main(String[] args) {
		if (args == null) {
			System.out.println("Invalid arguments");
			System.exit(1);
		}
		
		String file = args[1];
		String pattern = args[0];
		
		FileReader fr;
		try {
			fr = new FileReader(new File(file));
			BufferedReader br = new BufferedReader(fr);
			String s;
			ArrayList<String> input = new ArrayList<String>();
			while ((s=br.readLine())!=null) {
				input.add(s);
			}
			System.out.println(JGrep.jgrep(input.toArray(new String[input.size()]), pattern));
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		} catch (Exception e) {
			System.exit(1);
		}
		
		
		
	}
}
