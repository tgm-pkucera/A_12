package at.rene8888.au02a;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 * View Klasse
 * 
 * @author Rene Hollander
 * @version 1.0
 * 
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	private Control c;
	private ListPanel lp;
	private NotePanel np;

	/**
	 * Konstruktor für die View Klasse
	 * 
	 * @param c
	 *            Instanz der Control Klasse
	 * @param lp
	 *            Instanz der ListPanel Klasse
	 * @param np
	 *            Instanz der NotePanel Klasse
	 */
	public View(Control c, ListPanel lp, NotePanel np) {

		this.c = c;
		this.lp = lp;
		this.np = np;

		this.setIconImage(Toolkit.getDefaultToolkit().createImage(
				this.getClass().getResource("/images/icon.png")));

		initGUI();

	}

	private void initGUI() {

		this.setTitle("Notizen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				this.lp, this.np);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(200);

		// Provide minimum sizes for the two components in the split pane
		Dimension minimumSize = new Dimension(200, 100);
		this.lp.setMinimumSize(minimumSize);
		this.np.setMinimumSize(minimumSize);

		this.setLayout(new BorderLayout());

		this.addWindowListener(this.c);

		this.setSize(700, 400);
		this.setLocationRelativeTo(null);

		this.add(splitPane, BorderLayout.CENTER);

		this.setVisible(true);

	}

}
