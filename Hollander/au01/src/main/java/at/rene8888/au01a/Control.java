package at.rene8888.au01a;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Rene Hollander 3AHIT
 * @ersion 1.0
 * 
 * Controlklasse
 */
public class Control implements ActionListener, ChangeListener {

	@SuppressWarnings("unused")
	private View view;
	private Panel panel;
	private ButtonPanel bpanel;
	private SliderPanel spanel;

	/**
	 * Konstruktor für die Control Klasse
	 */
	public Control() {
		
		//Erzeugt die jeweiligen Instanzen der Klasse und weist die Instanzen den anderen Klassen zu
		
		panel = new Panel(this);
		spanel = new SliderPanel(this);
		bpanel = new ButtonPanel(this, this.spanel);

		view = new View(this, this.panel, this.bpanel);

	}

	public void actionPerformed(ActionEvent e) {

		//ActionListener für den Fill und Clear Button
		
		if (bpanel.checkButtonFill(e)) {

			panel.numberLabels();
			bpanel.setLabelSum("5050");

		}

		if (bpanel.checkButtonClear(e)) {

			panel.clearLabels();
			bpanel.setLabelSum("0");

		}

	}

	public void stateChanged(ChangeEvent e) {
		
		//Change Listener für die RGB Slider
		
		if (spanel.checkSliderRed(e)) {
			spanel.setLabelRedValue(spanel.getSliderRedValue());
			panel.updateColor(new Color(spanel.getSliderRedValue(), spanel.getSliderGreenValue(), spanel.getSliderBlueValue()));
		}

		if (spanel.checkSliderGreen(e)) {
			spanel.setLabelGreenValue(spanel.getSliderGreenValue());
			panel.updateColor(new Color(spanel.getSliderRedValue(), spanel.getSliderGreenValue(), spanel.getSliderBlueValue()));
		}

		if (spanel.checkSliderBlue(e)) {
			spanel.setLabelBlueValue(spanel.getSliderBlueValue());
			panel.updateColor(new Color(spanel.getSliderRedValue(), spanel.getSliderGreenValue(), spanel.getSliderBlueValue()));
		}
	}

}
