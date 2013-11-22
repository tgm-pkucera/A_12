import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Palatschinkenkuchl {
	public static void main(String []args) {
		// Wenn zu wenige Argumente angegeben werden, in diesem Beispiel 0 oder 1
		if(args.length < 2) {
			System.out.println("Mind. 2 Argumente!");
			return;
		}
		
		// Beinhaltet die RegularExpression (Regulärer Ausdruck)
		String regularExpression = args[0];
		Pattern pattern = Pattern.compile(regularExpression);
		
		// Geht alle angegebenen Dateien durch, so dass es mehrere Dateien in der Kommandozeile angegeben werden können
		for(int i=1; i<args.length; i++) {
			
			String fileName = args[i]; // Holt sich den jeweiligen Dateinamen von der jeweiligen Datei
			
			try {
				// Initialisiert RandomAccessFile, um die Dateien auslesen zu können
	            RandomAccessFile f = new RandomAccessFile(fileName, "r");
	            // Geht Zeile für Zeile in die Datei durch
	            while(f.getFilePointer() != f.length()) {
	            	// Holt sich die aktuelle Zeile
	            	String line = f.readLine();
	            	// Wendet die RegularExpression an
	            	Matcher mat = pattern.matcher(line);
	            	// if-Anweisung ist true, wenn RegularExpression matcht
	            	if (mat.matches()) {
	            		System.out.println(line); //ausgabe
	            	}
	            }
	            f.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Datei nicht gefunden/nicht erzeugt");
	        } catch (IOException e) {
	            System.out.println("Zugriffsfehler");
	        }
		}
		
	}
}
