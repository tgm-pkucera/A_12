package jgrep;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Jgrep {
        private static String text="";
        private static String pf;
        private static String datei ="";
        private static RandomAccessFile fi=null;

        public static String JGrepdatei(){
                try {
                        //Scannt die eingabe in der Console
                        Scanner in=new Scanner(System.in);
                        System.out.println("Bitte geben sie ihren gesuchten Text an: ");

                        text=in.nextLine();
                        System.out.println("Bitte geben sie den Dateipfad an: ");
                        pf=in.nextLine();
                        Pattern p=Pattern.compile(text);
                        in.close();
                        fi=new RandomAccessFile(pf,"r");  
                        fi.seek(0);
                        
                        //Initialisiert die Zeichenkette
                        while(fi.getFilePointer() < fi.length()) 
                        {
                            String inhalt=fi.readLine();
                            Matcher m=p.matcher(inhalt);
                            boolean mb=m.find();
                                if (mb == true)
                                	{
                                        System.out.println("Ihre gesuchte Zeichenkette: "+text);
                                	}
                        }
                        
                } catch (IOException e){
                        System.err.println("Datei/Dateipfad nicht gefunden!");
                        System.exit(1);
                }
                return datei;
        }

}