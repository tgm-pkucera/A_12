package sew.bruckner.AU03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {

	//... Notation bedeutet String[]
	public static String jgrep(String regex, String... lines) {
		String out = "";
		
		//Pattern initialisieren
		Pattern p = Pattern.compile(regex);
		//Matcher aus kompilierter regex auswerten; String extends CharSequence
		for (String s : lines) {
			Matcher m = p.matcher(s);
			
			//Wenn matcher den string findet dann zum output hinzufügen
			if (m.find()) out += s + "\n";
		}
		
		return out;
	}
}
