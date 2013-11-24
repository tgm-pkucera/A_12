package Kraft;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class JGrep {
        private static String text="";
        private static String dp;
        private static String datei ="";
        private static RandomAccessFile raf=null;

        public static String JGrepdatei(){
                try {
                        //Scannt die eingabe in der Console
                        Scanner in=new Scanner(System.in);
                        System.out.println("Bitte geben sie ihren gesuchten Text an: ");
                        
                        //Zuweisung des eingegeben Textes
                        text=in.nextLine();
                        System.out.println("Bitte geben sie den Dateipfad an: ");
                        
                        //Zuweisung der eingegeben Datei/Dateipfades
                        dp=in.nextLine();
                        
                        Pattern p=Pattern.compile(text);
                        
                        //"Schlieﬂen" der Konsole
                        in.close();
                        
                        //RAF liest die Datei
                        raf=new RandomAccessFile(dp,"r");  
                        
                        //Setzt den Pointer an die erste Stelle
                        raf.seek(0);
                        
                        //Erstellt eine Zeichenkette
                        while(raf.getFilePointer() < raf.length()) {
                            String inhalt=raf.readLine();
                            Matcher m=p.matcher(inhalt);
                            boolean mb=m.find();
                                //falls die gesuchte Zeichenkette einer der in der Datei enthaltenen ¸bereinstimmt
                                if (mb == true) {
                                        System.out.println("Ihre gesuchte Zeichenkette: "+text);
                                }
                        }
                        
                } catch (IOException e){
                        System.err.println("Datei/Dateipfad nicht gefunden!");
                        System.exit(1);
                }
                //Zur¸ckgeben der Datei
                return datei;
        }

}