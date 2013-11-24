import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.*;

/**
 * Autor: Martin Kritzl
 * Datum: 24.11.2013
 * Features: Einlesen von mehreren Datein
 * 		     Überprüfen eines eingegebenen Textes, ist nur mit strg+c zu beenden
 */

public class JCrepe{
	private String[] eingabe;
	private Pattern pattern;
	private String text;
	private BufferedReader input;
	
	public JCrepe(String[] args) {
		this.eingabe=args;
		//Es muss immer mehr als 1 Paramamter geben
		if (this.eingabe.length < 2) {
			System.err.println("Es wurden zu wenig Parameter angegeben");
			System.exit(1);		
		}
		//das Suchmuster bleibt den ganzen Programmverlauf gleich
		pattern = Pattern.compile(this.eingabe[0]);
		this.eingabeAnalysieren();
	}
	
	//Es wird zwischen manueller Eingabe und auslesen einer Datei unterschieden
	public void eingabeAnalysieren() {
		if (this.eingabe[1].indexOf("--") >= 0) {
			this.textAnalysieren();
		} else {
			this.auslesen();
		}
	}
	
	//Die manuelle Eingabe wird mittels System.in realisiert und deswegen ist das schließen mit anderen Tasten nicht möglich
	public void textAnalysieren() {
		try {
			System.in.read();
			input = new BufferedReader(new InputStreamReader(System.in));
			text=input.readLine();
		} catch (IOException e) {
			System.out.println("Falsche Eingabe");
		}
		//Es wird ausgewertet ob der Suchbegriff vorhanden ist
		Matcher m = this.pattern.matcher(this.text);
		if (m.matches()) {
			System.out.println("Die Suche trifft zu");
		} else {
			System.out.println("Die Suche trifft nicht zu");
		}
		//es wird wieder eine Eingabe eines Textes erwartet
		this.eingabeAnalysieren();
	}
	
	//Die Überprüfung des Suchmusters auf Datein
	public void auslesen() {
		String zeile ="";
		int anzahl = 1;
		//Die einzelnen Datein werden mit der for-Schleife realisiert
		for (int i = 1; i < this.eingabe.length; i++) {
			anzahl = 1;
			if (this.eingabe[i] != null) {
				try {
					RandomAccessFile f = new RandomAccessFile(this.eingabe[i], "r");
					do {
						zeile = f.readLine();
						if (zeile == null)break;
						Matcher m = this.pattern.matcher(zeile);
						//Hier wird die Ursprungsdatei nur bei mehr als einer Quelldatei angezeigt
						if (m.matches()) {
							if (eingabe.length<3) {
								System.out.println(zeile + "\tZeile:" + anzahl);
							} else {
								if (eingabe.length>=3) {
									//System.out.println(this.eingabe[i]);
									System.out.println(zeile + "\t" + eingabe[i].substring(eingabe[i].lastIndexOf('\\') + 1, eingabe[i].length()) + "\tZeile:" + anzahl);
								}
							}
							
						}
						anzahl++;
					}while(true);
				}catch(FileNotFoundException e){
					System.err.println("File konnte nicht gefunden werden");
				} catch (IOException e) {
					System.err.println("Keine Berechtigung");
				}
			} 
			
		}
	}
	
	
	//Der Keylistener konnte wegen dem System.in.read() nicht realisiert werden
	/*
	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyChar() == 'C') && (e.getKeyCode() == KeyEvent.VK_CONTROL)){
			System.exit(0);
		}
		if ((e.getKeyChar() == 'D') && (e.getKeyCode() == KeyEvent.VK_CONTROL)){
			System.exit(0);
		}
		if ((e.getKeyChar() == 'Z') && (e.getKeyCode() == KeyEvent.VK_CONTROL)){
			System.exit(0);
		}
		if (e.getKeyChar() == '\r'){
			textAnalysieren();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	*/
	
	public static void main(String[] args) {
		new JCrepe(args);
	}
	
}
