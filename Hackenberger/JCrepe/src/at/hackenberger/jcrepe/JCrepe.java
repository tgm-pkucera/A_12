package at.hackenberger.jcrepe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fusesource.jansi.AnsiConsole;

/**
 * Mit dieser Klasse können Datein mit Regular Expressions auf passende Zeilen geprüft werden
 * @author Hackenberger Christoph
 * @version 2013-11-24 (1.0)
 */
public class JCrepe {

	private File[] files;
	private Pattern pattern;
	
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Error: JGrep usage: JCrepe <regex> <file> [file,...]");
			System.exit(0);
		}else {
			JCrepe crepe = null;
			String[] files = new String[args.length-1];
			for(int i = 0; i < files.length; i++) {
				files[i] = args[i+1];
			}
			try{
				crepe = new JCrepe(args[0], files);
			}catch(FileNotFoundException e) {
				System.out.print("Error: " + e.getMessage());
				System.exit(0);
			}
			try{
				crepe.start();
			}catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Erstellt ein neues JCrepe Objekt
	 * @param regex Regular Expression die verwendet werden soll
	 * @param fileNames Dateinamen
	 * @throws FileNotFoundException Wenn eine der Datein nicht gefunden werden kann
	 */
	public JCrepe(String regex, String[] fileNames) throws FileNotFoundException {
		createPattern(regex);
		loadFiles(fileNames);
	}
	
	/**
	 * Lädet die angegebenen Datein
	 * @param fileNames Dateinamen
	 * @throws FileNotFoundException Wenn eine der Datein nicht gefunden werden kann
	 */
	private void loadFiles(String[] fileNames) throws FileNotFoundException {
		files = new File[fileNames.length];
		for(int i = 0; i < files.length; i++)
			files[i] = new File(fileNames[i]);
		
	}
	
	/**
	 * "Kompliliert" die Regular Expression
	 * @param regex Regular Expression die verwendet werden soll
	 */
	private void createPattern(String regex) {
		pattern = Pattern.compile(regex);
	}
	
	/**
	 * Liefert alle passenden Zeilen in einer Dateo. Matchende Teile sind rot makiert
	 * @param file Datei in der nach passenden Zeilen gesucht werden soll
	 * @return Ein Array mit allen passenden Zeilen
	 * @throws IOException Wenn ein I/O Fehler auftritt
	 */
	private String[] getMatchingLines(File file) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		for(String line = br.readLine(); line != null; line = br.readLine()) {
			Matcher m = pattern.matcher(line);
			if(m.find()) {
					String group = m.group();
					lines.add(line.replace(group, "\u001B[31m" + group + "\u001B[0m"));
			}
		}
		br.close();
		fr.close();
		return lines.toArray(new String[lines.size()]);
	}
	
	/**
	 * Startet den JCreper und gibt alle passenden Zeilen auf der Konsole aus
	 * @throws IOException Wenn ein I/O Fehler auftritt
	 */
	public void start() throws IOException {
		for(int i = 0; i < files.length; i++) {
			System.out.println("\u001B[1m" + files[i].getName()+":" + "\u001B[0m");
			for(String t : getMatchingLines(files[i])) {
				AnsiConsole.out.println(t);
			}
			System.out.println("");
		}
	}
}
