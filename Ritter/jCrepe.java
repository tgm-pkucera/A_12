package at.mritter.a05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * jCrepe Klasse zum finden von Regular Expressions in Files oder Benutzereingaben
 * @author Mathias Ritter 3AHIT
 *
 */
public class jCrepe {
	
	//ANSI-Farbcodes fuer die Farben rot und schwarz (reset)
	public static final String rot = "\u001B[31m";
	public static final String reset = "\u001B[0m";
	
	/**
	 * Diese Methode sucht eine Regular Expression in einer String ArrayList
	 * Sie gibt alle matchenden Zeilen in Form einer String ArrayList zurueck
	 * 
	 * @param regex Die Regular Expression
	 * @param inhalt Der Text, der analysiert werden soll
	 * @return Die Zeilen, die matchen
	 */
	public static ArrayList<String> suche(String regex, ArrayList<String> inhalt) {

		ArrayList<String> matches = new ArrayList<String>();
		
		Pattern p1 = Pattern.compile(regex);
		
		//Jede Zeile (entspricht Element in der ArrayList) durchgehen
		for (String s : inhalt) {
			
			Matcher m1 = p1.matcher(s);
			
			//Falls die Regex in der akt. Zeile gefunden wird, 
			//wird der die Regex eingefaerbt und zu matches hinzugefuegt
			if (m1.find()) {

				String davor = s.substring(0, m1.start());
				String treffer = s.substring(m1.start(), m1.end());
				String dahinter = s.substring(m1.end(), s.length());
				
				String zeile = davor + rot + treffer + reset + dahinter;

				matches.add(zeile);
			}
		}

		return matches;

	}

	/**
	 * Main-Methode fuer jCrepe
	 * @param args Die eingegebenen Argumente
	 */
	public static void main(String[] args) {

		//Das Programm wird nur ausgefuhert, wenn mind. 2 Argumente angegeben werden
		if (args.length < 2) {
			System.out.println("Correct usage: java -jar "
					+ jCrepe.class.getName().substring(jCrepe.class.getName().lastIndexOf('.') + 1)
					+ " <regex> <filename;--> [filename;--]");
		} else {

			//Scanner fuer die Benutzereingaben
			Scanner s1 = new Scanner(System.in);
			
			//ArrayList fuer die Ausgabe am Ende
			ArrayList<String> out = new ArrayList<String>();
			
			//Die Nummer der Benutzereingabe
			int userinput = 1;
			
			//For-Schleife arbeitet alle Argumente ab, die ausgewertet werden muessen
			//Die Regex zaehlt nicht dazu, deshalb beginnt sie bei 1
			for (int i = 1; i < args.length; i++) {

				//ArrayList fuer den Dateiinhalt bzw. Benutzereingabe
				ArrayList<String> inhalt = new ArrayList<String>();

				//Falls das Argument ein Dateipfad ist (nicht "--" ist),
				//wird die Datei mit einem BufferedReader eingelesen
				if (!args[i].equals("--")) {

					//File mit angegebenem Dateipfad anlegen
					File datei = new File(args[i]);

					BufferedReader b1 = null;

					try {
						//mit BufferedReader den Inhalt zeilenweise einlesen
						b1 = new BufferedReader(new FileReader(datei));
						String zeile = "";
						while ((zeile = b1.readLine()) != null) {
							//adden der jeweiligen Zeile zur ArrayList inhalt
							inhalt.add(zeile);
						}
						//am Ende den BufferedReader schließen
						b1.close();
						
					} catch (FileNotFoundException e) {
						//Falls die Datei nicht gefunden wird:
						System.out.println(args[i] + " does not exist!");
						continue;
						
					} catch (IOException e) {
						//Falls es zu einem Lesefehler kommt:
						System.out.println("Error while reading file: " + args[i]);
						e.printStackTrace();
						continue;
					}
					
					out.add("matching lines in " + args[i] + ":");
					
				//Else: Sollte der User keinen Dateipfad, sondern "--" eingeben
				//dann wird die Eingabe zeilenweise direkt eingelesen
				} else {

					System.out.println("jCrepe - user input " + userinput + ":");
					
					System.out.print("jCrepe - end by entering stop>");

					String zeile = "";
					
					//zeilenweise einlesen mit dem Scanner
					while ((zeile = s1.nextLine()) != null) {
						if (zeile.equalsIgnoreCase("stop"))
							break;
						inhalt.add(zeile);
						System.out.print("jCrepe - end by entering stop>");
					}
					
					out.add("matching lines in user input " + userinput + ":");
					
					//Nummer der Benutzereingabe um 1 erhoehen (fuer die eventuelle naechste Eingabe)
					userinput ++;

				}
				
				//Auswerten der inhalts-ArrayList
				ArrayList<String> ergebnis = suche(args[0], inhalt);
				
				//alle matches zur Ausgabe-ArrayList hinzufuegen
				for (String s : ergebnis) {
					out.add(s);
				}

			}
			
			//Beenden des Scanners
			s1.close();
			
			//Ausgabe der Ausgabe-ArrayList
			for (String s : out) {
				System.out.println(s);
			}
		}
	}

}
