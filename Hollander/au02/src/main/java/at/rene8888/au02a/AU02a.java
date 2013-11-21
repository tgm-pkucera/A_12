package at.rene8888.au02a;

import javax.swing.UIManager;

/**
 * @author Rene Hollander 3AHIT
 * @version 1.0
 * 
 *          Programm um Notitzen zu verwalten
 * 
 */
public class AU02a {

	/**
	 * @param args
	 *            Kommandozeilenargumente
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Control();

	}

}
