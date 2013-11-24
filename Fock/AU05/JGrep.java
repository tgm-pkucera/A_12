import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {

	public static String grep(Pattern p, ArrayList<String> al) {
		String ausgabe = "";
		for (String s : al) {
			Matcher m = p.matcher(s);
			if (m.find()) ausgabe += s + "\n";
		}
		return ausgabe;
	}
}

