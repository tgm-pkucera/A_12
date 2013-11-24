import java.awt.Window;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class JCrepe {
	public JCrepe(String muster, String filename){
		RandomAccessFile check = null;
		
		try {
			check = new RandomAccessFile(filename,"r");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "notfound");
			System.err.println("File nicht gefunden");
			System.exit(1);
			e1.printStackTrace();
		}
		Pattern p = Pattern.compile(muster);
		String inhalt="";
		try {
			check.seek(0);//Hier setzte ich den pointer auf den anfang
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			while(check.getFilePointer()<check.length()){
				  
			inhalt = check.readLine();
			Matcher m=p.matcher(inhalt);
			boolean matchesbo=m.matches();
			
			//System.err.println( matchesbo);
			
			if(matchesbo == true)
			System.err.println(m.group());
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "notxt");
			System.err.println("Fehler beim Auslesen");
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(null, inhalt);
		/*
		Matcher m=p.matcher(inhalt);
		boolean matchesbo=m.matches();
		//System.err.println( matchesbo);
		String matched =m.group();
		//JOptionPane.showMessageDialog(null, matched);
		
		System.err.print(matched);
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Filenamen eingeben: ");
		String filename="";
		String suchmuster="";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    filename = bufferRead.readLine();
		    
		   
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Suchmuster eingeben: ");
		 
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    suchmuster = bufferRead.readLine();
		    
		    
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		JCrepe test=new JCrepe(suchmuster,filename);
		
		
	}

}