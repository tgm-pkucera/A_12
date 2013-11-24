package malik;

import java.io.*;
import java.util.regex.*;

/**
 * @author: patrick
 * @version: 131124
 * 
 * Ein Programm das die eingegebenen regulären Ausdrücke übersetzt und mit der gewünschten Datei vergleicht.
 */
public class JGrep	{
	String input;
	String regEx;
	String datei;
	String inhalt = "";

	Matcher m;
	Pattern p;

	RandomAccessFile file;

	public JGrep()	{

		System.out.println("Bitte geben Sie die regEx in \"...\" und nach einem Space den Dateipfad an!");
		//Einlesen der Konsoleneingabe
		try	{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			input = bufferRead.readLine();
		}
		catch (IOException e)	{

		}
		if (!input.contains("\""))	{
			System.exit(0);
		}

		regEx = input.substring(input.indexOf("\"")+1, input.lastIndexOf("\""));
		datei = input.substring(input.lastIndexOf("\"")+2);

		p = Pattern.compile(regEx);
		m = p.matcher(inhalt);

		try {
			//speichern der gesuchten datei in RandomAccessFile
			file = new RandomAccessFile(datei, "r");
			for (int i = 1; file.getFilePointer() < file.length(); i++)	{
				//einlesen der jeweiligen Zeile
				inhalt = file.readLine();
				if (Pattern.matches(regEx, inhalt))	{
					System.out.println("Zeile " + i + ": " + inhalt);
				}


			}
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException ex)	{
			System.out.println("IOException");
		}
		

	}

	public static void main(String[] args) {	
		new JGrep();
	}
}