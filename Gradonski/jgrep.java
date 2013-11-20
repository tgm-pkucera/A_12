import java.util.regex.*;


public class jgrep {
public static void main(String[] args) {
	
	String eingabe = args[0];
	String pattern =  args[1];
	
	Pattern p = Pattern.compile(pattern);
	Matcher m = p.matcher(eingabe);
	if (m.find()){
		 
		
	}
	else {
	System.out.println("Nichts Gefunden");	
	}
	
	
}

}
