package at.rene8888.au04;

/**
 * Klasse um das CTRL-C zu überwachen
 * 
 * @author Rene Hollander 3AHIT
 *
 */
public class ShutdownThread extends Thread {

	private Main m;

	/**
	 * Konstruktor
	 * 
	 * @param m Instanz der Main Klasse
	 */
	public ShutdownThread(Main m) {
		this.m = m;
	}

	public void run() {
		m.stop();
	}

}
