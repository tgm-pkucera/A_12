package at.rene8888.au01a;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Panelklasse für das Label Raster
 * 
 * @author Rene Hollander 3AHIT
 * @version 1.0
 */
public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Control control;

	private ArrayList<JLabel> labels;

	/**
	 * Kunstruktor für die Panel Klasse
	 * 
	 * @param control Instanz der Control Klasse
	 */
	public Panel(Control control) {

		this.control = control;

		initPanel();

	}

	private void initPanel() {
		
		//Zeichnet das GrundLayout des Rasters
		
		this.setLayout(new GridLayout(10, 10));
		
		this.setBackground(new Color(255, 255, 255));
		
		this.labels = new ArrayList<JLabel>();

		//Erzeugt 100 Labels, weist sie dem Panel und der ArrayList zu
		
		for (int i = 1; i <= 100; i++) {
			
			Border b = BorderFactory.createLineBorder(Color.black);
			JLabel l = new JLabel("", JLabel.CENTER);
			l.setBorder(b);
			this.add(l);
			this.labels.add(l);

		}

	}

	/**
	 * Methode zum durchnummerieren des Rasters
	 */
	public void numberLabels() {

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (JLabel l : this.labels) {
			
			//Erzeugt eine Zufallszahl die nicht doppelt vorkommt
			
			while (true) {

				int number = (int) (Math.random() * 100 + 1);

				if (al.contains(new Integer(number)))
					continue;

				l.setText(number + "");
				al.add(new Integer(number));

				break;

			}

		}

	}
	
	/**
	 * Methode zum leeren des Rasters
	 */
	public void clearLabels() {

		for (JLabel l : this.labels) {

			l.setText("");

		}

	}
	
	/**
	 * @param c Hintergrundfarbe für Raster
	 */
	public void updateColor(Color c) {
		
		this.setBackground(c);
		
	}

}
