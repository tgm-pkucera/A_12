package ghamberger;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class jgrep {
	private static String regex, filepath;
	private static String file = "";
	private static RandomAccessFile raf;
	private static boolean gefunden = true;

	/**
	 * @return Gibt die gefundenen Zeilen aus.
	 */
	@SuppressWarnings("unused")
	public static String ausfuehren() {
		try {
			
			//Zuständig für das einlesen auf der Console.
			Scanner in = new Scanner(System.in);
			System.out.print("Bitte die RegEx:");
			regex = in.nextLine();
			System.out.print("Bitte das File:");
			filepath = in.nextLine();
			in.close();
			
			//Holt sich das File.
			raf = new RandomAccessFile(filepath,"r");
			
			//Machst aus der Eingabe eine regex.
			Pattern pat = Pattern.compile(regex);
			
			for (int i = 1; raf.getFilePointer() < raf.length(); i++) {
				String zeile = raf.readLine();
			
				if (Pattern.matches(regex, zeile)) {
					System.out.println(zeile);
				} else {
					gefunden = false;
				}
			}
		
			if (gefunden == false) {
				System.out.print("Keine passende Zeile gefunden!");
			}
			
		} catch (IOException e) {
			System.out.print("Datei nicht gefunden!");
		}
		return file;
	}
}