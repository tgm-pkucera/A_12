package weinberger;

import java.util.regex.*;
import java.io.*;

/**
 * Liest eine Datei ein, untersucht den Inhalt mithilfe der regulaeren Ausdruecke auf Aehnlichkeiten und gibt jeweilige Zeilen aus.
 * 
 * Der Programmablauf wurde in 2 Teile geteilt: Datei einlesen & Datei verarbeiten
 * 
 * @author Michael Weinberger
 * @version 2013-22-11
 *
 */
public class JCrepe {
	String dateiname;
	String regex;
	
	/**
	 * Hier wird der Programmablauf der Palatschinkenkueche gesteuert.
	 * 
	 * @param args Die Argumente von der Konsoleneingabe.
	 */
	public static void main(String[] args) { 
		if (args[0] != null && args[1] != null) {
			JCrepe palatschinke = new JCrepe(args[0], args[1]);
			String[] eingabe = palatschinke.holRezept();
			palatschinke.inDerPfanneBrutzelnUndServieren(eingabe);
		} else {
			System.out.println("Bitte geben Sie Argumente ein!");
			System.exit(0);
		}
	}
	
	/**
	 * Erstellt eine Crépe mit den 2 Attributen:
	 * 
	 * @param dateiname Der angegebene Dateipfad
	 * @param regex Die angegebenen Regulaeren Ausdruecke
	 */
	public JCrepe(String dateiname, String regex) {
		this.dateiname = dateiname;	
		this.regex = regex;
	}
	
	/**
	 * Liest die Datei aus dem Dateipfad nach Rezept aus.
	 * 
	 * @return ausgabe Das String-Array mit allen im File vorhandenen Zeilen als durchsuchbarer String.
	 */
	public String[] holRezept() {
		String[] ausgabe = null;
		try {
			FileReader einlesen = new FileReader(dateiname);
			BufferedReader file = new BufferedReader(einlesen);
			
			int anzahlzeilen = 0;
			
			while (file.readLine() != null) { //Merkt sich die Gesamtgroesse des Files anhand der Zeilenanzahl.
				anzahlzeilen++;
			}
			
			ausgabe = new String[anzahlzeilen];
			
			for (int i = 0; i < anzahlzeilen; i++) {
				ausgabe[i] = file.readLine(); //Hier wird in jede Array-Stelle eine Zeile des Files eingefuegt.
			}
			
			return ausgabe;
			
		} catch (IOException e) {
			System.out.println("Es ist ein Fehler beim Auslesen passiert!");
			System.exit(0);
		}
		return ausgabe;
	}
	
	/**
	 * Die eigentliche Zubereitung der Palatschinke à la carte.
	 * Hier wird die jeweilige Zeile verglichen/ausgegeben, sofern ident mit dem Regulaeren Ausdruck.
	 * 
	 * @param eingabe Die Zeilen des Files im Array.
	 */
	public void inDerPfanneBrutzelnUndServieren(String[] eingabe) {
		if (eingabe != null) {
			Matcher vergleichswert;
			Pattern suchmuster = Pattern.compile(regex); //Compiliert den Regex.
			for (int i = 0; i < eingabe.length; i++) {
				
				vergleichswert = suchmuster.matcher(eingabe[i]); //Vergleicht den Matcher mit der aktuellen Zeile.
				
				if(vergleichswert.matches()) { //Wenn Regex zutrifft, soll diejenige Zeile ausgegeben werden.
					
					System.out.println(eingabe[i]);
					
				}
				
			}
			
		} else {
			System.out.println("Das File ist leer!");
			System.exit(0);
		}
	}
}
