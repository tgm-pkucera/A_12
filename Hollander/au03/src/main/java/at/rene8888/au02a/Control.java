package at.rene8888.au02a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import at.rene8888.au02a.data.Note;
import at.rene8888.au02a.data.NoteList;
import at.rene8888.au02a.data.ObjectSerialization;

/**
 * @author Rene Hollander 3AHIT
 * @version 1.0
 */
public class Control implements ActionListener, ListSelectionListener, MouseListener, WindowListener {

	@SuppressWarnings("unused")
	private View v;
	private ListPanel lp;
	private NotePanel np;
	private Note origNote;

	/**
	 * Konstruktor für Control Klasse
	 */
	public Control() {
		NoteList nl;
		File f = new File("save.dat");
		if (f.exists()) {
			nl = (NoteList) ObjectSerialization.ReadFromFile(f);
			if (nl.size() == 0) {
				this.origNote = new Note("Willkommen!", "Rene8888", new Date(), "Willkommen zu meinem Notizprogramm!\nEs ist gratis! :D\n-Rene Hollander 3AHIT");
				nl.add(this.origNote);
			} else {
				this.origNote = nl.getFirstNote();
			}
		} else {
			nl = new NoteList();
			this.origNote = new Note("Willkommen!", "Rene8888", new Date(), "Willkommen zu meinem Notizprogramm!\nEs ist gratis! :D\n-Rene Hollander 3AHIT");
			nl.add(this.origNote);
		}
		this.lp = new ListPanel(this, nl);
		this.lp.setSelectedIndex(0);
		this.np = new NotePanel(this, nl.getFirstNote());
		this.v = new View(this, this.lp, this.np);

	}

	public void actionPerformed(ActionEvent e) {
		this.np.updateNote();
		this.lp.setNoteElement(this.origNote, this.np.getNote());
		if (this.lp.checkNewNoteButton(e)) {
			if ((this.lp.getListSize() == 1) && (this.lp.getFirstNote().getNoteName().equals("Willkommen!"))) {
				this.lp.removeNoteElement("Willkommen!", 0);
				Note n = new Note("Neu " + this.lp.getListSize(), System.getProperty("user.name"), new Date(), "");
				this.lp.addNoteElement(n);
				this.np.writeNote(n);
				this.origNote = n;
				this.lp.setSelectedIndex(this.lp.getListSize() - 1);
				this.lp.scroll();
			} else {
				Note n = new Note("Neu " + this.lp.getListSize(), System.getProperty("user.name"), new Date(), "");
				this.lp.addNoteElement(n);
				this.np.writeNote(n);
				this.origNote = n;
				this.lp.setSelectedIndex(this.lp.getListSize() - 1);
				this.lp.scroll();
			}

		} else if (this.lp.checkDeleteNoteButton(e)) {
			if (this.lp.getListSize() == 1) {
				this.lp.removeNoteElement(this.lp.getSelectedIndexName(), 0);
				this.origNote = new Note("Willkommen!", "Rene8888", new Date(), "Willkommen zu meinem Notizprogramm!\nEs ist gratis! :D\n-Rene Hollander 3AHIT");
				this.lp.addNoteElement(this.origNote);
				this.np.writeNote(this.origNote);
				this.lp.setSelectedIndex(0);
				this.lp.scroll();
			} else {
				int index = this.lp.getSelectedIndex();
				this.lp.removeNoteElement(this.lp.getSelectedIndexName(), index);

				if (index == this.lp.getListSize()) {
					this.lp.setSelectedIndex(index - 1);
					this.origNote = this.lp.getNoteElement(this.lp.getSelectedIndexName());
					this.np.writeNote(this.origNote);
				} else {
					this.lp.setSelectedIndex(index);
					this.origNote = this.lp.getNoteElement(this.lp.getSelectedIndexName());
					this.np.writeNote(this.origNote);
				}
			}
		} else if (this.lp.checkSortAtoZButton(e)) {
			this.lp.sortNotes(false);
		} else if (this.lp.checkSortZtoAButton(e)) {
			this.lp.sortNotes(true);
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (this.np.checkSubjectLabel(e)) {
			try {
				String input = JOptionPane.showInputDialog(null, "Geben Sie einen neuen Betreff ein!");
				if ((!input.equals("")) && (this.lp.getNoteByName(input) == null)) {
					this.np.setSubjectText(input);
					this.np.updateNote();
					this.lp.setNoteElementAt(this.lp.getSelectedIndex(), this.np.getNote());
				}
			} catch (Exception ex) {
			}
		}
	}

	public void windowClosing(WindowEvent e) {
		this.np.updateNote();
		this.lp.setNoteElement(this.origNote, this.np.getNote());
		File f = new File("save.dat");
		ObjectSerialization.WriteToFile(this.lp.getNoteList(), f);
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			this.np.updateNote();
			this.lp.setNoteElement(this.origNote, this.np.getNote());
			Note note = this.lp.getNoteElement(this.lp.getSelectedIndexName());
			this.origNote = note;
			this.np.writeNote(note);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

}
