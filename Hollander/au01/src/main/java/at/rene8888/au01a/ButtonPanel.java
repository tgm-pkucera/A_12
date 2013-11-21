package at.rene8888.au01a;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Rene Hollander 3AHIT
 * @version 1.0
 * 
 * ButtonPanel Klasse für das Panel mit den Buttons
 *
 */
public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Control control;

	private JButton buttonFill;
	private JButton buttonClear;
	private JLabel labelSum;
	private SliderPanel spanel;

	/**
	 * @param control Instanz der Control Klasse
	 * @param spanel Instanz der SliderPanel Klasse
	 * 
	 * Konstruktor für die ButtonPanel Klasse
	 */
	public ButtonPanel(Control control, SliderPanel spanel) {

		this.control = control;
		this.spanel = spanel;
		
		initPanel();

	}

	private void initPanel() {
		
		//Zeichnet die GUI
		
		this.setLayout(new GridLayout(2, 2));

		this.buttonFill = new JButton("Fill");
		this.buttonClear = new JButton("Clear");
		this.labelSum = new JLabel("0", JLabel.CENTER);

		this.buttonFill.addActionListener(this.control);
		this.buttonClear.addActionListener(this.control);
		
		this.add(buttonFill);
		this.add(buttonClear);
		this.add(spanel);
		this.add(labelSum);

	}
	
	/**
	 * @param s Setzt das Summenlabel
	 */
	public void setLabelSum(String s) {
		
		this.labelSum.setText(s);
		
	}

	/**
	 * @param e ActionEvent zum überprüfen welcher Button gedrückt wurde
	 * @return Gibt true zurück wenn die Source vom ActionEvent dem Button Fill übereinstimmt
	 */
	public boolean checkButtonFill(ActionEvent e) {

		if (e.getSource() == this.buttonFill) {
			return true;
		}

		return false;
		
	}
	
	/**
	 * @param e ActionEvent zum überprüfen welcher Button gedrückt wurde
	 * @return Gibt true zurück wenn die Source vom ActionEvent dem Button Fill übereinstimmt
	 */
	public boolean checkButtonClear(ActionEvent e) {
		
		if (e.getSource() == this.buttonClear) {
			return true;
		}

		return false;
		
	}

}
