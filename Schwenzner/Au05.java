  import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.util.ArrayList;
 import java.util.regex.Pattern;
 
 /**
  * 
  * @author Marc Schwenzner
  * 
  * @date 22.11.13
  *
  */
 

public class Au05 {
    
public static String grep(String[] input, String pattern) {
	String ausgabe = null;
    Pattern p = Pattern.compile(pattern);
    	for (String string : input) {
    		if (p.matcher(string).find()) {
    			ausgabe += string + "\n";
                   }
           }
            return ausgabe;
   }
    
public static void main(String[] args) {
	if (args == null) {
		System.out.println("Usage: java JGrep [regex] file");
    }
          
	String f = args[0];
    String p = args[0];
    FileReader fr;
          
    try {
    	fr = new FileReader(new File(f));
        BufferedReader br = new BufferedReader(fr);
        String string;
        ArrayList<String> al = new ArrayList<String>();
        while ((string=br.readLine())!=null) {
        	al.add(string);
        }
            
        System.out.println(grep(al.toArray(new String[al.size()]), p));
        fr.close();
        br.close();
                  
    } catch (FileNotFoundException e) {
    	System.out.println("Error: File not found");
        System.exit(1);
                  
    } catch (Exception e) {
    	System.exit(1);
    }      
   }
  }