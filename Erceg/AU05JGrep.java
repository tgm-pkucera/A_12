package at.stefanerceg.au05;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

/**
 * @author Stefan Erceg
 * 
 * angefangen am: 20.11.13
 * fertiggestellt am: 23.11.13
 * 
 * Aufgabe: 
 * 
 * Es wird ein Programm erstellt, das auf der Kommandozeile einen regul�ren Ausdruck und einen Dateinamen 
 * entgegennimmt. Das Programm soll die Datei mit Hilfe des regul�ren Ausdrucks durchsuchen und die "matchenden" 
 * Zeilen auf der Konsole ausgeben.
 * Zur Auswertung der regul�ren Ausdr�cke wird die Klasse Pattern verwenden.
 * 
 * Erweiterungen:
 * 
 * - Die matchenden Elemente werden in der Ausgabe eingef�rbt.
 * - Mehrere Dateien k�nnen in der Kommandozeile angegeben werden k�nnen, die dann hintereinander 
 * 	 ausgegeben werden (inkl. Dateinamen).
 * - Wenn der Benutzer f�r den Dateinamen "--" angibt, soll der Text von der Konsole gelesen werden. 
 * 	 Dr�ckt der Benutzer "Enter" wird der String analysiert und wenn er matcht wiederholt. Das Programm muss 
 *   mit Ctrl+C, Ctrl+D und Ctrl+Z beendet werden k�nnen.
 * 
 */

public class AU05JGrep {
	
	/* ANSI-Codes: RED f�r die Farbe rot und RESET f�r die Standardfarbe der Konsole */
	
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	
	/* Konstruktor */
	
	public AU05JGrep(String[] args) {
		
		String regex = "";
		ArrayList<String> input = new ArrayList<String>();
		
		/* springt in die if-Unterscheidung, wenn zu Beginn ein regul�rer Ausdruck verwendet wurde */
		
		if (!args[0].equalsIgnoreCase("--")) {
			
			regex = args[0];
			RandomAccessFile f = null;
			
			/* holt sich die Zeilen aus dem Text heraus, wo der regul�re Ausdruck gefunden wurde */
			
			for (int i = 1; i < args.length; i++) {
				File file = new File(args[i]);
				input = getFileContent(args[i]);
				
				/* Ausgabe der Textzeilen */
				
				System.out.println("Lines matching to given regex in file" + file.getName() + ":");
				System.out.println(converter(regex, input.toArray(new String[input.size()])));
				
			}
		
		/* springt in den else-Fall, wenn zu Beginn "--" angegeben wurde */	
			
		} else {
			
			/* ein Textscanner, welcher den eingegeben regul�ren Ausdruck analysiert, wird verwendet */
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter regex:");
			
			/* Textzeilen werden nach dem angegebenen regul�ren Ausdruck gesucht */
			
			for (int i = 1; i < args.length; i++) {
				input.addAll(getFileContent(args[i]));
			}
			
			/* Ausgabe der Textzeilen */
			
			String line = "";
			while ((line = scan.nextLine()) != null) {
				System.out.println("Lines matching to given regex:");
				System.out.println(converter(line, input.toArray(new String[input.size()])));
			}
		}
	}
	
	/* statischer Main-Teil des Programms */
	
	public static void main(String[] args) {
		
		/* wenn nicht mind. 2 Argumente (regul�rer Ausdruck oder "--" und Filename) angegeben wurden, wird
		 * eine Fehlermeldung ausgegeben */
		
		if (args.length < 2) {
			System.out.println("Too few arguments. Correct usage: java " + AU05JGrep.class.getName().substring(AU05JGrep.class.getName().lastIndexOf(".") + 1) + " <regex;--> <file> [file]");
		
		/* ansonsten wird Konstruktor normal durchgef�hrt */
		
		} else {
			new AU05JGrep(args);
		}
	}
	
	/* Methode zum Konvertieren wird erstellt
		"..."-Schreibweise erleichtert das Initialisieren eines String-Arrays */
	
	public String converter(String regex, String... input) {
		String toReturn = "";
		
		/* kompilieren des regul�ren Ausdrucks - dazu wird die Klasse Pattern verwendet */
		
		Pattern p = Pattern.compile(regex);
		for (String s : input) {
			Matcher m = p.matcher(s);
			
			/* falls der Matcher gefunden wurde, wird der Text aufgeteilt in:
			 * 	- nor1 = von Zeilenbeginn bis zu der Stelle, wo Matcher gefunden wurde
			 *  - col1 = von der Stelle, wo Matcher gefunden wurde, bis zu der Stelle, wo Matcher aufh�rt
			 *  - nor2 = von der Stelle, wo Matcher aufh�rt, bis zum Zeilenende */
			
			if (m.find()) {
				String nor1 = s.substring(0, m.start());
				String col1 = s.substring(m.start(), m.end());
				String nor2 = s.substring(m.end(), s.length());
				
				toReturn += nor1 + RED + col1 + RESET + nor2 + "\n";
			}
		}
		
		return toReturn;
	}
	
	/* Methode zum Herauslesen des Textinhaltes (mittels RandomAccessFile) wird erstellt */
	
	public ArrayList<String> getFileContent(String fi) {
		ArrayList<String> toReturn = new ArrayList<String>();
		RandomAccessFile f = null;
			try {
				File file = new File(fi);
				f = new RandomAccessFile(file, "r");
				
				String line = "";
				
				while ((line = f.readLine()) != null) {
					toReturn.add(line);
				}
				
				f.close();
			}catch(IOException e) {
				System.out.println("Error on reading file!");
				e.printStackTrace();
			}	
		return toReturn;
	}
}