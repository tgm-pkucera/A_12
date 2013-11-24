package at.rene8888.au01a;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 * @author Rene Hollander 3AHIT
 * @version 1.0
 * 
 * SliderPanel Klasse
 */
public class SliderPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Control control;

	private JPanel panelRed;
	private JPanel panelGreen;
	private JPanel panelBlue;

	private JLabel labelRed;
	private JLabel labelGreen;
	private JLabel labelBlue;

	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;

	private JLabel labelRedValue;
	private JLabel labelGreenValue;
	private JLabel labelBlueValue;

	/**
	 * @param control Instanz der Control Klasse
	 * 
	 * Konstruktor f�r die SLiderPanel Klasse
	 */
	public SliderPanel(Control control) {

		this.control = control;

		initPanel();

	}

	private void initPanel() {
		
		//Zeichnet die Steuerelemente f�r das ButtonPanel
		
		this.setLayout(new GridLayout(3, 1));

		this.panelRed = new JPanel();
		this.panelGreen = new JPanel();
		this.panelBlue = new JPanel();

		this.labelRed = new JLabel("Red:");
		this.labelGreen = new JLabel("Green:");
		this.labelBlue = new JLabel("Blue:");

		this.sliderRed = new JSlider(0, 255, 255);
		this.sliderGreen = new JSlider(0, 255, 255);
		this.sliderBlue = new JSlider(0, 255, 255);

		this.labelRedValue = new JLabel("255");
		this.labelGreenValue = new JLabel("255");
		this.labelBlueValue = new JLabel("255");

		this.sliderBlue.addChangeListener(this.control);
		this.sliderRed.addChangeListener(this.control);
		this.sliderGreen.addChangeListener(this.control);

		this.panelRed.add(labelRed);
		this.panelRed.add(sliderRed);
		this.panelRed.add(labelRedValue);

		this.panelGreen.add(labelGreen);
		this.panelGreen.add(sliderGreen);
		this.panelGreen.add(labelGreenValue);

		this.panelBlue.add(labelBlue);
		this.panelBlue.add(sliderBlue);
		this.panelBlue.add(labelBlueValue);

		this.add(panelRed);
		this.add(panelGreen);
		this.add(panelBlue);

	}

	// -----------------

	/**
	 * @return Gibt den Wert vom Roten Slider zur�ck
	 */
	public int getSliderRedValue() {
		return this.sliderRed.getValue();
	}

	/**
	 * @return Gibt den Wert vom Gr�nen Slider zur�ck
	 */
	public int getSliderGreenValue() {
		return this.sliderGreen.getValue();
	}

	/**
	 * @return Gibt den Wert vom Blauen Slider zur�ck
	 */
	public int getSliderBlueValue() {
		return this.sliderBlue.getValue();
	}

	// -----------------

	/**
	 * @param v Setzt den Wert vom Label f�r den Roten RGB Wert
	 */
	public void setLabelRedValue(int v) {
		this.labelRedValue.setText(String.valueOf(v));
	}

	/**
	 * @param v Setzt den Wert vom Label f�r den Gr�nen RGB Wert
	 */
	public void setLabelGreenValue(int v) {
		this.labelGreenValue.setText(String.valueOf(v));
	}

	/**
	 * @param v Setzt den Wert vom Label f�r den Blauen RGB Wert
	 */
	public void setLabelBlueValue(int v) {
		this.labelBlueValue.setText(String.valueOf(v));
	}

	// -----------------

	/**
	 * @param e ActionEvent zum �berpr�fen welcher Button gedr�ckt wurde
	 * @return Gibt true zur�ck wenn die Source vom ActionEvent dem Button Fill �bereinstimmt
	 */
	public boolean checkSliderRed(ChangeEvent e) {
		if (e.getSource() == this.sliderRed) {
			return true;
		}
		return false;
	}

	/**
	 * @param e ActionEvent zum �berpr�fen welcher Button gedr�ckt wurde
	 * @return Gibt true zur�ck wenn die Source vom ActionEvent dem Button Fill �bereinstimmt
	 */
	public boolean checkSliderGreen(ChangeEvent e) {
		if (e.getSource() == this.sliderGreen) {
			return true;
		}
		return false;
	}

	/**
	 * @param e ActionEvent zum �berpr�fen welcher Button gedr�ckt wurde
	 * @return Gibt true zur�ck wenn die Source vom ActionEvent dem Button Fill �bereinstimmt
	 */
	public boolean checkSliderBlue(ChangeEvent e) {
		if (e.getSource() == this.sliderBlue) {
			return true;
		}
		return false;
	}

}
