package sew.bruckner.AU03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AU05 {
	
	public static void main(String[]args){
		if (args.length < 2) {
			System.out.println("Correct usage: java JGrep <regex> <filename>");
		} else {
			String regex = args[0];
			File file = new File(args[1]);
			ArrayList<String> input = new ArrayList<String>();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				
				//Line wird zur inputzeile gesetzt
				while((line = br.readLine()) != null) {
					//Damit wird jede zeile des files ausgelesen und zur arraylist hinzugefügt
					input.add(line);
				}
				
				//Bufferedreader schließen zm ressourcen zu sparen
				br.close();
				
				System.out.println("Lines matching to given regex:");
				System.out.println(JGrep.jgrep(regex, input.toArray(new String[input.size()])));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}