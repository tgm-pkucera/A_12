package jgrep;

import java.util.regex.*;
import java.io.*;

public class jgrep {
	
	private Pattern pattern;
	private Matcher matcher;
	
	/* Mit .compile() wird der eingegebene Wert f�r den Pattern komiliert
	 * und damit f�r den matcher vergleichbar gemacht.
	 */
	public jgrep(String eingabe){
		pattern = Pattern.compile(eingabe);
		matcher = pattern.matcher(eingabe);
	}
	
	/* auslesen erm�glicht es mir, das angegebene File auszulesen 
	 * und die Zeilen die den eingegebenen Inhalt enthalten anzuzeigen.
	 * Der BufferedReader liest das File aus.
	 * Wenn die eingegebenen Parameter mit der eingFile Zeile �berein stimmen, 
	 * wird diese Zeile dem String eingZeile �ber mittelt und ausgegeben.
	 */
	public void auslesen
	(BufferedReader eingFile, String fileName, boolean schreibFileName) {
		
		String eingZeile;
		
		try{
			while((eingZeile = eingFile.readLine()) != null){
				matcher.reset(eingZeile);
				if(matcher.lookingAt()){
					if(schreibFileName){
						System.out.print(fileName+": ");
					}
					System.out.println(eingZeile);
				}
			}
			eingFile.close();
		}catch (IOException e){
			System.err.println(e);
		}
		
	}
	
	public static void main(String [] argv) throws Exception {

		if(argv.length < 1){
			System.err.println("Usage: jgrep pattern [filename]");
			System.exit(1);
		}
		jgrep grep = new jgrep(argv[0]);
		if(argv.length == 1){
			grep.auslesen(new BufferedReader(new InputStreamReader(System.in)), "(standard Eingabe)", false);
		}else{
			for(int i=1; i<argv.length; i++){
				grep.auslesen(new BufferedReader(new FileReader(argv[i])), argv[1], true);
			}
		}
	}
}
