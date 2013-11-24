package polydor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;

/**
 * 
 * @author Stefan Polydor
 * @version 2013.11.20
 */

public class jCrepe {
	/**
	 * Durchsucht die Datei
	 * @param expr hier wird die Regular Expression angegeben
	 * @param dateiinhalt[] hier werden die einzelnen Zeilen der Datei angegeben
	 * @return
	 */
	public static void jCrepe(String expr, String[] dateiinhalt)	{
		if(expr != null && dateiinhalt != null)	{
			Pattern p = Pattern.compile(expr); // Bereitet die Expression zur Verwendung vor
			Matcher m;
			for(int x = 0; x < dateiinhalt.length; x++)	{ // geht das Array solange durch bis es keine Zeilen mehr gibt
				m = p.matcher(dateiinhalt[x]);
				if(m.matches()) // wenn in der Zeile etwas matcht wird diese ausgegeben
					System.out.println(dateiinhalt[x]);
			}
		} else
			System.out.println("Sie haben keine Expression oder keine gültige Expression eingegeben");
	}
	/**
	 * Liest die angegebene Datei aus und speichert diese Zeile für Zeile in ein Array
	 * @param dateiname hier kann der Absolute Dateipfad angegeben werden
	 * @return String[] gibt die Datei abgespeichert (Zeile für Zeile) zurück
	 * @throws FileNotFoundException
	 */
	public static String[] dateiAuslesen(String dateiname) throws FileNotFoundException	{
		FileReader fr = new FileReader(dateiname);
		BufferedReader br = new BufferedReader(fr);
		String zeile = "";
		int anzz = 0;
		while( (zeile = br.readLine()) != null )	{
			anzz++;
		}
		anzz = 0;
		String[] weiter = new String[anzz];
		while( (zeile = br.readLine()) != null )	{
	      weiter[anzz] = zeile;
	      anzz++;
	    }
		br.close();
		return weiter;
	}
	public static void main (String expr, String datei)	{
		try {
			jCrepe.jCrepe(expr, jCrepe.dateiAuslesen(datei));
		} catch (FileNotFoundException e) {
			System.out.println("Die Datei konnte nicht gefunden werden");
		}
	}
}
