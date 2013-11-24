import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JGrepMain {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("error");
			System.exit(1);
		}	
		Pattern p = Pattern.compile(args[0]);
		RandomAccessFile raf;
		for (int i = 1; i < args.length; i++)	{
			if(args[i].equals("--")){
				Scanner scanner = new Scanner(System.in);
				while(scanner.hasNext()){
					ArrayList<String> al = new ArrayList<String>();
					al.add(scanner.nextLine());
					System.out.print(JGrep.grep(p, al));
				}
		} else {
			try {
				raf = new RandomAccessFile(args[i], "r");
				String row = "";
				ArrayList<String> al = new ArrayList<String>();
				while ((row = raf.readLine()) != null) {
					al.add(row);
				}
				System.out.println(args[i] + ": \n"+ JGrep.grep(p, al));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Datei nicht gefunden!");
				System.exit(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
				System.exit(1);
			}	
			}
		}
	}
}