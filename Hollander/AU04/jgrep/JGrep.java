package at.rene8888.au04.jgrep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
public class JGrep {

	public static String[] grep(String pattern, String[] input) {
		ArrayList<String> out = new ArrayList<String>();
		Pattern p = Pattern.compile(pattern);
		for (String s : input) {
			if (p.matcher(s).matches()) {
				out.add(s);
			}
		}
		return out.toArray(new String[0]);
	}
	
	public static String[] grep(String pattern, File f) throws IOException {
		FileReader fis = new FileReader(f);
		BufferedReader br = new BufferedReader(fis);
		
		ArrayList<String> in = new ArrayList<String>();
		
		String s = "";
		
		while((s = br.readLine()) != null) {
			in.add(s);
		}
		return grep(pattern, in.toArray(new String[0]));
	}
	
}
