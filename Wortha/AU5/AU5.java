
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Simon
 *
 */
public class AU5 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length<2) {
			System.out.println("Nene, zwei bitte");
			System.exit(1);
		}
		String pattern = args[0];
		RandomAccessFile raf;
		for(int i = 1; i < args.length; i++) {
			if(args[i].equals("--")){
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				while(scanner.hasNext()){
					ArrayList<String> list = new ArrayList<String>();
					list.add(scanner.nextLine());
					System.out.print(JGrep.grep(pattern, list));
				}
			}else{
				try {
					raf = new RandomAccessFile(args[i], "r");
					String zeile = "";
					ArrayList<String> list = new ArrayList<String>();
					while ((zeile = raf.readLine()) != null) {
						list.add(zeile);
					}
					System.out.println(args[i] + ": \n"+ JGrep.grep(pattern, list));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Datei nicht gefunden!");
					System.exit(1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("FEHLER!");
					System.exit(1);
				}
			}
		}
	}
}
