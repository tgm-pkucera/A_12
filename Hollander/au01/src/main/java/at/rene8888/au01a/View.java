package at.rene8888.au01a;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author Rene Hollander 3AHIT
 * @version 1.0
 * 
 * View Klasse
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Panel panel;
	@SuppressWarnings("unused")
	private Control control;
	private ButtonPanel bpanel;
	@SuppressWarnings("unused")
	private SliderPanel spanel;
	
	/**
	 * @param control Instanz von der Control Klasse
	 * @param panel	Instanz von der Panel Klasse
	 * @param bpanel Instanz von der Button Panel Klasse
	 * 
	 * Konstruktor für die View Klasse
	 */
	public View(Control control, Panel panel, ButtonPanel bpanel) {
		
		this.control = control;
		this.panel = panel;
		this.bpanel = bpanel;
		
		initGUI();
		
	}
	
	private void initGUI() {
		
		//Zeichnet das JFrame
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 600);
		
		this.setTitle("AU01a");
		
		this.setLayout(new GridLayout(2, 1));
		
		this.add(this.panel);
		this.add(this.bpanel);
		
		this.setVisible(true);
		
	}
	
}
