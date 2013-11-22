import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Palatschinkenkuchl {
	public static void main(String []args) {
		if(args.length < 2) {
			System.out.println("Mind. 2 Argumente!");
			return;
		}
		
		String regularExpression = args[0];
		String fileName = args[1];
		
		Pattern pattern = Pattern.compile(regularExpression);
		
		try {
            RandomAccessFile f = new RandomAccessFile(fileName, "r");
            while(f.getFilePointer() != f.length()) {
            	String line = f.readLine();
            	Matcher mat = pattern.matcher(line);
            	if (mat.matches()) {
            		System.out.println(line);
            	}
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden/nicht erzeugt");
        } catch (IOException e) {
            System.out.println("Zugriffsfehler");
        }
		
	}
}
