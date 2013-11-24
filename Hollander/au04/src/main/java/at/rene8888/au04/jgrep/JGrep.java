package at.rene8888.au04.jgrep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fusesource.jansi.AnsiConsole;

/**
 * JGrep Klasse um Strings und Files mit Regex zu pr�fen
 * 
 * @author Rene Hollander 3AHIT
 * 
 */
public class JGrep {

	/**
	 * Methode zum grepen von String[]
	 * 
	 * @param pattern
	 *            Regex Patter
	 * @param input
	 *            Input String[]
	 * @param colored
	 *            Gibt an ob der Text gef�rbt werden soll
	 * @return Gibt ein String[] mit den Zeilen zur�ck die dem Regex Pattern
	 *         entsprechen
	 */
	public static String[] grep(String pattern, String[] input, boolean colored) {
		ArrayList<String> out = new ArrayList<String>();
		Pattern p = Pattern.compile(pattern);
		for (String s : input) {
			Matcher m = p.matcher(s);
			if (m.find()) {
				if (colored) {
					String normal1 = s.substring(0, m.start());
					String colored1 = s.substring(m.start(), m.end());
					String normal2 = s.substring(m.end(), s.length());
					out.add(normal1 + "\u001B[31m" + colored1 + "\u001B[0m" + normal2);
				} else {
					out.add(s);
				}
			}
		}
		return out.toArray(new String[0]);
	}

	/**
	 * Methode zum grepen von Files direkt zu Konsole
	 * 
	 * @param pattern
	 *            Regex Patter
	 * @param f
	 *            Datei die gelesen werden soll
	 * @param colored
	 *            Gibt an ob der Text gef�rbt werden soll
	 * @throws IOException
	 *             Wird geworfen wenn ein Fehler beim Lesen der Datei auftritt
	 */
	public static void grepToConsole(String pattern, File f, boolean colored) throws IOException {
		FileReader fis = new FileReader(f);
		BufferedReader br = new BufferedReader(fis);
		Pattern p = Pattern.compile(pattern);
		String s = "";
		while ((s = br.readLine()) != null) {
			Matcher m = p.matcher(s);
			if (m.find()) {
				if (colored) {
					String normal1 = s.substring(0, m.start());
					String colored1 = s.substring(m.start(), m.end());
					String normal2 = s.substring(m.end(), s.length());
					AnsiConsole.out.println(normal1 + "\u001B[31m" + colored1 + "\u001B[0m" + normal2);
				} else {
					System.out.println(s);
				}
			}
		}

		br.close();
		fis.close();

	}

	/**
	 * Methode zum grepen von String[]
	 * 
	 * @param pattern
	 *            Regex Patter
	 * @param f
	 *            Datei die gelesen werden soll
	 * @param colored
	 *            Gibt an ob der Text gef�rbt werden soll
	 * @return Gibt ein String[] mit den Zeilen zur�ck die dem Regex Pattern
	 *         entsprechen
	 * @throws IOException
	 *             Wird geworfen wenn ein Fehler beim Lesen der Datei auftritt
	 */
	public static String[] grep(String pattern, File f, boolean colored) throws IOException {
		FileReader fis = new FileReader(f);
		BufferedReader br = new BufferedReader(fis);

		ArrayList<String> in = new ArrayList<String>();

		String s = "";

		while ((s = br.readLine()) != null) {
			in.add(s);
		}

		br.close();
		fis.close();

		return grep(pattern, in.toArray(new String[0]), colored);

	}

	/**
	 * Methode zum grepen von String[]
	 * 
	 * @param pattern
	 *            Regex Patter
	 * @param s
	 *            Input String
	 * @param colored
	 *            Gibt an ob der Text gef�rbt werden soll
	 * @return Gibt einen String mit den Zeilen zur�ck die dem Regex Pattern
	 *         entsprechen
	 */
	public static String grep(String pattern, String s, boolean colored) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		if (m.find()) {
			if (colored) {
				String normal1 = s.substring(0, m.start());
				String colored1 = s.substring(m.start(), m.end());
				String normal2 = s.substring(m.end(), s.length());
				return normal1 + "\u001B[31m" + colored1 + "\u001B[0m" + normal2;
			} else {
				return s;
			}
		}
		return null;
	}
}
