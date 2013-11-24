import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
/**
 * 
 * @author Gradonski Janusz 3AHIT 
 * Version 1.0
 * Linux "grep" in Java... =  JGrep!
 * 
 *
 */
public class JGrep_g {
	/* ANSI-CODES: RED für die rote Farbe , RESET für die Standartfarbe*/
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";

	/* Main */
	
	public static void main(String args[]) {
		
		/* Wenn zu wenig argumente angegeben werden */
		if (args.length < 2) {
			
			System.out.println("Please enter more arguments. Correct usage: java "
					+ JGrep_g.class.getName().substring(
							JGrep_g.class.getName().lastIndexOf('.') + 1)
					+ " <regex;--> <filename> [filename]");
		} else {
			
			
			String regex = "";
			
			ArrayList<String> eing = new ArrayList<String>();
			
			if (!args[0].equalsIgnoreCase("--")) {

				/* Die Zeilen wo sich der reguläre Ausdruck befindet werden herausgeholt  */
				regex = args[0];
				for (int i = 1; i < args.length; i++) {
					File file = new File(args[i]);
					eing = getFileContent(args[i]);
					
					/* Ausgabe */
					
					System.out.println("Lines matching to Regular Expression in File "
							+ file.getName() + ":");
					System.out.println(convert(regex,
							eing.toArray(new String[eing.size()])));

				}
				
			} else {
				
				/* In den argument "--" steht wird mittels Scanner die Eingabe eingelesen .*/
                Scanner scan = new Scanner(System.in);
                
                System.out.println("Enter Regular Expression:");
                
                /* Suchen der Eingabe */
                for (int i = 1; i < args.length; i++) {
                        eing.addAll(getFileContent(args[i]));
                }            
                /*Ausgabe der Zeilen die gleich der eingabe sind */
                String nline = "";
                while ((nline = scan.nextLine()) != null) {
                        System.out.println("Lines matching to given regular expression:");
                        System.out.println(convert(nline, eing.toArray(new String[eing.size()])));
			
                }
			}
		}
		
	}

	/* Auslesen der Textdatei und in ArrayList speichern. */
	
	public static ArrayList<String> getFileContent(String fi) {
		ArrayList<String> ruckgabe = new ArrayList<String>();
		RandomAccessFile f = null;
		try {
			File file = new File(fi);
			f = new RandomAccessFile(file, "r");

			String line = "";

			while ((line = f.readLine()) != null) {
				ruckgabe.add(line);
			}

			f.close();
			/* Wenn die angebenene Datein nicht gefunden wurde:*/
	    } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            e.printStackTrace();
            
    } catch (IOException e) {
            System.out.println("Error on reading file!");
            e.printStackTrace();
    }
		return ruckgabe;
	}

	/* Die Convert-methode (String... = String[]) */
	
	public static String convert(String regex, String... eing) {
		String output = "";
		Pattern p = Pattern.compile(regex);

		for (String s : eing) {
			Matcher m = p.matcher(s);
			// Zeilen suchen.. Rot färben und dann zu Output hinzufügen
			if (m.find())
				output += s.substring(0, m.start()) + RED
						+ s.substring(m.start(), m.end()) + RESET
						+ s.substring(m.end(), s.length()) + "\n";
		}

		return output;
	}
}
