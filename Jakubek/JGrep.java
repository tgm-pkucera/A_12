package at.petrus.sew.a05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * 
 * @author Petrus
 *
 */

public class JGrep {
	 
	  /**
	   * @param input String-Array
	   * @param pattern Regex
	   */
	  public static String grep(String[] input, String pattern) {
          String output = null;
          Pattern p = Pattern.compile(pattern);
          for (String s : input) {
                  if (p.matcher(s).find()) {
                          output += s + "\n";
                  }
          }
          return output;
  }
	 /**
	  * 
	  * @param args Kommandozeilenparamater
	  */
	 public static void main(String[] args) {
         if (args == null) {
                 System.out.println("Usage: java JGrep [regex] file");
         }
         
         String file = args[0];
         String pattern = args[0];
         FileReader freader;
         
         try {
        	 freader = new FileReader(new File(file));
             BufferedReader breader = new BufferedReader(freader);
             String s;
            ArrayList<String> input = new ArrayList<String>();
                 while ((s=breader.readLine())!=null) {
                         input.add(s);
                 }
           
                 System.out.println(grep(input.toArray(new String[input.size()]), pattern));
                 freader.close();
                 breader.close();
                 
         } catch (FileNotFoundException e) {
                 System.out.println("Error: File not found");
                 System.exit(1);
         } catch (Exception e) {
                 System.exit(1);
         }      
 }
}