package at.sew.au05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * v1.0
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
	
	//Fuer faerbigen Output unter Windows ist eine Library erforderlich
	
	
	/**
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
				String norm1 = s.substring(0, m.start());
				String color = s.substring(m.start(), m.end());
				String norm2 = s.substring(m.end(), s.length());
				output += norm1 + ANSI_RED + color + ANSI_RESET + norm2 + "\n";
			}
		}
		return output;
	}
}
