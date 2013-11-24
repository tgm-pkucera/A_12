package koelbl;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Alexander Kölbl
 * @verisn 24.11.2013
 */
public class Jgrep {
	/**
	 * Durchsucht die Datei nach dem Ausdruck
	 * @param expression Die Regular Expression mit der man nach Ausdrücken sucht
	 * @param inhalt[] Die Zeilen des Dateiinhalts
	 */
	public static void Jgrep(String expression,String[] inhalt){
		if(expression != null && inhalt != null)	{ // Vermeindung einer NullPointer Exception
			Pattern p = Pattern.compile(expression); 
			Matcher m;
			for(int x = 0; x < inhalt.length; x++)	{ // Durchlauf des Arrays
				m = p.matcher(inhalt[x]);
				if(m.matches()){ // falls eine Übereinstimmung gefunden wurde, gibt er diesen Ausdruck aus
					System.out.println(inhalt[x]);
				}	
			}
		} else
			System.out.println("Sie haben keine Ausdruck der auf diese Expression zutrifft oder eine ungültige Expression angegeben");
	}
	/**
	 * Die angegebene Datei wird ausgelesen und in ein Array gepeichert
	 * @param dn Der Dateipfad
	 * @return String[] die abgespeicherte Datei
	 * @throws FileNotFoundException
	 */
	public static String[] dateiAuslesen(String dpfad) throws FileNotFoundException	{
		FileReader fr = new FileReader(dpfad);
		
		BufferedReader br = new BufferedReader(fr);
		
		String z = "";
		
		int anz = 0;
		
			while( (z = br.readLine()) != null )	{
				anz++;
			}
			anz = 0;
			
			String[] w = new String[anz];
			
			while( (z = br.readLine()) != null )	{
				w[anz] = z;
				anz++;
			}
			br.close();
			return w;
	}
	public static void main (String expr, String datei)	{
		try {
			Jgrep.Jgrep(expr, Jgrep.dateiAuslesen(datei));
		} catch (FileNotFoundException e) {
			System.out.println("Die Datei konnte nicht gefunden werden");
		}
	}
}
