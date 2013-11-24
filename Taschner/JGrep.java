package jGrep;

import java.io.*;
import java.util.regex.*;

/**
 * @author Thomas Taschner
 * @version 1.0
 * @date 20.11.2013
 *
 * Dieses Programm liest einen regulären Ausdruck und einen Dateipfad auf der Konsole ein, um die angegebene Datei nach bestimmten Kriterien zu durchsuchen.
 */
public class JGrep {

	@SuppressWarnings("unused")
	public JGrep()	{

		Matcher matcher;
		Pattern pattern;
		RandomAccessFile file;

		String input = "";
		String regex = "";
		String path = "";
		String file_text = "";
		String found = "";

		byte[] chars = new byte[256];
		int anzahlBytes = -1;

		System.out.print("JGrep>");

		/*
		 * Eingabe des Benutzers wird eingelesen und in einen String gespeichert
		 */

		try {
			anzahlBytes = System.in.read(chars);
			if (anzahlBytes > 0)	{
				input = new String(chars, 0, anzahlBytes-2);
			}
		} catch (IOException e) {

		}

		/*
		 * Doppelte Hochkomma werden durch einfache Hochkomma ersetzt
		 */

		input = input.replace('\"','\'');

		/*
		 * Wenn Hochkomma vorhanden sind, werden der reguläre Ausdruck und der Dateipfad rausgeschnitten, ein Suchmuster erstellt und auf den Dateiinhalt angewendet.
		 */

		if (input.contains("'"))	{
			regex = input.substring(input.indexOf("'")+1, input.lastIndexOf("'"));
			path = input.substring(input.lastIndexOf("'")+2);
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(file_text);
		} else 	{
			System.out.println("Geben Sie bitte einen gültigen Suchausdruck an");
			System.exit(0);
		}

		/*
		 * Die Datei wird zeilenweise ausgelesen und nach einem vorhin festgelegten Suchmuster durchsucht.
		 * Erfolgt in einer Zeile ein Fund, so wird diese Zeile ausgegeben.
		 */

		try {
			file = new RandomAccessFile(path, "r");

			for (int i = 1; file.getFilePointer() < file.length(); i++)	{
				file_text = file.readLine();

				if (Pattern.matches(regex, file_text))	{
					System.out.println("Zeile " + i + ": " + file_text);
					found += ".";
				}

				if (found.equals("") && file.getFilePointer() == file.length())	{
					System.out.println("Es konnte in diesem Dokument nichts gefunden werden, was Ihren Suchkritieren entspricht");
				}
			}
			file.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Geben Sie bitte einen gültigen Dateipfad an, die Datei wurde nicht gefunden");

		} catch (IOException exc) {
			System.out.println("Auf die Datei kann nicht zugegriffen werden");
		}
	}

	/**
	 * @param args - Main Methode
	 */
	public static void main(String[] args) {
		new JGrep();
	}
}