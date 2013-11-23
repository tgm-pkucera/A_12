import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Simon
 *
 */
public class JGrep {
	/**
	 * @param gesucht
	 * @param eingabe 
	 * @param datei
	 * @return bullshit
	 */
	public static String grep(String gesucht, ArrayList<String> eingabe){
		String ausgabe = "";
		Pattern p = Pattern.compile(gesucht);
		for(String s : eingabe){
			Matcher m = p.matcher(s);
			if(m.find()) ausgabe += s + "\n";
		}
		return ausgabe;
	}	
}
