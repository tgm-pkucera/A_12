import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * v1.0
 * 
 * @author Paul Kalauner 3AHIT
 * 
 */
public class JGrep {

	/**
	 * ANSI Escape Code fuer Rot
	 */
	public static final String ANSI_RED = "\u001B[31m";

	/**
	 * ANSI Escape Code um die Farbe zurueckzusetzen
	 */
	public static final String ANSI_RESET = "\u001B[0m";

	// Fuer faerbigen Output unter Windows ist eine Library erforderlich

	/**
	 * jgrep method for multiple inputs
	 * @param input
	 * @param pattern
	 * @return output
	 */
	public static String jgrep(String[] input, String pattern) {
		String output = "";
		Pattern p = Pattern.compile(pattern);
		for (String s : input) {
			Matcher m = p.matcher(s);
			if (m.find()) {
				if (!isWindows()) {
					String norm1 = s.substring(0, m.start());
					String color = s.substring(m.start(), m.end());
					String norm2 = s.substring(m.end(), s.length());
					output += norm1 + ANSI_RED + color + ANSI_RESET + norm2 + "\n";
				} else {
					output += s + "\n";
				}
			}
		}
		return output;
	}

	/**
	 * jgrep method for single input
	 * 
	 * @param input
	 * @param p compiled regex pattern
	 * @return output
	 */
	public static String jgrep(String input, Pattern p) {
		String output = "";

		Matcher m = p.matcher(input);
		if (m.find()) {
			if (!isWindows()) {
				String norm1 = input.substring(0, m.start());
				String color = input.substring(m.start(), m.end());
				String norm2 = input.substring(m.end(), input.length());
				output += norm1 + ANSI_RED + color + ANSI_RESET + norm2 + "\n";
			} else {
				output += input + "\n";
			}
		}

		return output;
	}

	private static boolean isWindows() {
		return (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0);
	}

}
