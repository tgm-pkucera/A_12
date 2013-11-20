import java.io.*;
import java.util.regex.*;

/**
 * Gradonski Janusz JGrep v 0.1
 */
public class jgrep {
	public static void main(String[] args) {
		if (args == null) {
			System.out.println("Keine Argumente");
			System.out.println("jgrep [File] [Pattern]");
		}
		String eingabe = args[0];
		String pattern = args[1];
		try {
			FileReader file = new FileReader(new File(eingabe));
			BufferedReader br = new BufferedReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(eingabe);
		if (m.find()) {
			System.out.println();
		} else {
			System.out.println("Nichts Gefunden");
		}

	}
}
