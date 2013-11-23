package at.sgeyer.au05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {

	//ANSI codes fuer die farben rot, und die standartfarbe des terminals
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";

	public static void main(String args[]) {
		//Wenn zu wenige Argumente Meldung ausgeben
		if (args.length < 2) {
			System.out.println("Correct usage: java "
					+ JGrep.class.getName().substring(
							JGrep.class.getName().lastIndexOf('.') + 1)
					+ " <regex;--> <filename> [filename]");
		} else {

			String regex = "";

			ArrayList<String> arguments = new ArrayList<String>();

			//Wenn das 1. argument nicht kein Eingabekommando ist, wird es als die regex festgelelgt
			//Argumente aufsplitten, damit die regex nicht als file gewertet wird
			if (!args[0].equalsIgnoreCase("--")) {
				regex = args[0];

				for (int i = 1; i < args.length; i++) {
					arguments.add(args[i]);
				}
			} else {
				for (int i = 0; i < args.length; i++) {
					arguments.add(args[i]);
				}
			}

			for (String s : arguments) {
				//Regex wird via cli bestimmt
				if (s.equalsIgnoreCase("--")) {
					System.out
							.println("Entered input mode. Exit by typing 'stop'");

					BufferedReader br = null;
					ArrayList<String> in = new ArrayList<String>();

					//Fuer alle angegebenen files die zeilen auslesen und in die input arraylist schreiben
					for (String st : arguments) {
						if (!st.equals("--")) {
							try {
								File f = new File(st);
								br = new BufferedReader(new FileReader(f));
								String line = "";

								while ((line = br.readLine()) != null) {
									in.add(line);
								}

								br.close();
							} catch (FileNotFoundException e) {
								System.out.println("Given file doesnt exist!");
								e.printStackTrace();
							} catch (IOException e) {
								System.out.println("Error on reading file!");
								e.printStackTrace();
							}
						}
					}

					//Listener
					boolean tmp = true;
					while (tmp) {
						Scanner scan = new Scanner(System.in);

						String line = "";
						while ((line = scan.nextLine()) != null) {
							//Wenn der eingegbene Text stop lautet, wird das Programm beendet
							if (line.equalsIgnoreCase("stop")) {
								System.out.println("Exiting input mode...");
								System.exit(0);
							//Andernfalls wird nach der angegbenen regex in den files gesucht
							} else {
								System.out.println("Lines matching to regex "
										+ line + ":");
								System.out.println("	"
										+ convert(line,
												in.toArray(new String[in.size()])));
							}
						}

						//Scanner schliessen, damit er nicht als ungeschlossene ressource gezaehlt wird
						scan.close();
					}

					break;
					
				//Regex fix angegeben
				} else {
					BufferedReader br = null;
					ArrayList<String> in = new ArrayList<String>();

					//Aus files lesen und in die arraylist schreiben
					try {
						File f = new File(s);
						br = new BufferedReader(new FileReader(f));
						String line = "";

						while ((line = br.readLine()) != null) {
							in.add(line);
						}

						br.close();

						System.out.println("Lines matching to regex in file "
								+ f.getName() + " :");

						//Nach output für den inhalt der al suchen und ausgeben
						System.out.println("	"
								+ convert(regex,
										in.toArray(new String[in.size()])));

					} catch (FileNotFoundException e) {
						System.out.println("Given file doesnt exist!");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("Error on reading file!");
						e.printStackTrace();
					}
				}
			}
		}
	}

	//String... = String[]
	public static String convert(String regex, String... lines) {
		String out = "";
		Pattern p = Pattern.compile(regex);

		//In jeder Zeile suchen, gefundnene bereiche rot einfaerben und zum output string hinzufuegen
		for (String s : lines) {
			Matcher m = p.matcher(s);
			if (m.find())
				out += s.substring(0, m.start()) + RED
						+ s.substring(m.start(), m.end()) + RESET
						+ s.substring(m.end(), s.length()) + "\n";
		}

		return out;
	}
}
