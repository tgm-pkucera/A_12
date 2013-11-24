package at.rene8888.au02a;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import at.rene8888.au02a.data.Note;
import at.rene8888.au02a.data.NoteList;

/**
 * Panelklasse für die Notizliste
 * 
 * @author Rene Hollander 3AHIT
 * @version 1.0
 * 
 */
public class ListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Control c;
	private NoteList nl;
	private DefaultListModel<String> dlm;
	private JList<String> list;
	private JButton newNote;
	private JButton deleteNote;

	private JButton sortAtoZ;
	private JButton sortZtoA;

	/**
	 * Letzte Notiz
	 */
	public Note lastNote;

	/**
	 * Konstruktor für die ListPanel Klasse
	 * 
	 * @param c
	 *            Instanz der Control Klasse
	 * @param nl
	 *            NoteList to write in JList
	 * @param noteList
	 *            Notizen die beim start geschrieben werden sollen
	 */
	public ListPanel(Control c, NoteList nl) {
		this.c = c;
		this.setLayout(new BorderLayout());

		this.dlm = new DefaultListModel<String>();
		this.nl = nl;

		for (Object o : nl.getSubjectList()) {
			this.dlm.addElement((String) o);
		}

		this.list = new JList<String>(dlm);
		this.list.addListSelectionListener(this.c);

		JScrollPane scroll = new JScrollPane(list);
		this.add(scroll, BorderLayout.CENTER);
		this.newNote = new JButton("New Note");
		this.newNote.addActionListener(this.c);
		this.deleteNote = new JButton("Delete Note");
		this.deleteNote.addActionListener(this.c);
		this.sortAtoZ = new JButton("Sort A to Z");
		this.sortAtoZ.addActionListener(this.c);
		this.sortZtoA = new JButton("Sort Z to A");
		this.sortZtoA.addActionListener(this.c);

		JPanel buttonp = new JPanel();
		buttonp.setLayout(new GridLayout(2, 2));
		buttonp.add(this.newNote);
		buttonp.add(this.deleteNote);
		buttonp.add(this.sortAtoZ);
		buttonp.add(this.sortZtoA);
		this.add(buttonp, BorderLayout.SOUTH);
	}

	/**
	 * @param name
	 *            s Index des Element
	 * @return Gibt das Element beim Index zurück
	 */
	public Note getNoteElement(String name) {
		return this.nl.getNote(name);
	}

	/**
	 * @param oldnote
	 *            Alte Note
	 * @param newnote
	 *            Neue Note
	 */
	public void setNoteElement(Note oldnote, Note newnote) {
		this.nl.setNote(oldnote, newnote);
	}

	/**
	 * @param index
	 *            Index
	 * @param n
	 *            Note
	 */
	public void setNoteElementAt(int index, Note n) {
		this.dlm.set(index, n.getNoteName());
	}

	/**
	 * Fügt ein Note Element der Liste hinzu
	 * 
	 * @param note
	 *            Instanz eines Note Element
	 */
	public void addNoteElement(Note note) {
		this.nl.addNote(note);
		this.dlm.addElement(note.getNoteName());
		this.list.setSelectedIndex(this.nl.size());
	}

	/**
	 * @param s
	 *            String des element
	 * @param i
	 *            Index des element
	 */
	public void removeNoteElement(String s, int i) {
		this.nl.removeNote(this.nl.getNoteByName(s));
		this.dlm.remove(i);
	}

	/**
	 * @return Gibt den ausgewählten index zurück
	 */
	public int getSelectedIndex() {
		return this.list.getSelectedIndex();
	}

	/**
	 * @param i
	 *            Wählt item in list aus
	 */
	public void setSelectedIndex(int i) {
		this.list.setSelectedIndex(i);
	}

	/**
	 * @return Gibt größe der Liste zurück
	 */
	public int getListSize() {
		return this.dlm.getSize();
	}

	/**
	 * @return Returns NoteList
	 */
	public NoteList getNoteList() {
		return this.nl;
	}

	/**
	 * Scrolls Jlist to bottom
	 */
	public void scroll() {
		this.list.ensureIndexIsVisible(this.dlm.size() - 1);
	}

	/**
	 * @return first note
	 */
	public Note getFirstNote() {
		return this.nl.getFirstNote();
	}

	/**
	 * @return gets selected string
	 */
	public String getSelectedIndexName() {
		return this.list.getSelectedValue();
	}

	/**
	 * @param e
	 *            MouseEvent
	 * @return Gibt true zurück, wenn die Source vom Event mit der Componente
	 *         übereinstimmt
	 */
	public boolean checkNoteList(MouseEvent e) {
		if (e.getSource() == this.list)
			return true;
		return false;
	}

	/**
	 * @param s
	 *            String s
	 * @return note
	 */
	public Note getNoteByName(String s) {
		return this.nl.getNoteByName(s);
	}

	/**
	 * @param e
	 *            ActionEvent
	 * @return Gibt true zurück, wenn die Source vom Event mit der Componente
	 *         übereinstimmt
	 */
	public boolean checkNewNoteButton(ActionEvent e) {
		if (e.getSource() == this.newNote)
			return true;
		return false;
	}

	/**
	 * @param e
	 *            ActionEvent
	 * @return Gibt true zurück, wenn die Source vom Event mit der Componente
	 *         übereinstimmt
	 */
	public boolean checkDeleteNoteButton(ActionEvent e) {
		if (e.getSource() == this.deleteNote)
			return true;
		return false;
	}

	/**
	 * @param e
	 *            ActionEvent
	 * @return Gibt true zurück, wenn die Source vom Event mit der Componente
	 *         übereinstimmt
	 */
	public boolean checkSortAtoZButton(ActionEvent e) {
		if (e.getSource() == this.sortAtoZ)
			return true;
		return false;
	}

	/**
	 * @param e
	 *            ActionEvent
	 * @return Gibt true zurück, wenn die Source vom Event mit der Componente
	 *         übereinstimmt
	 */
	public boolean checkSortZtoAButton(ActionEvent e) {
		if (e.getSource() == this.sortZtoA)
			return true;
		return false;
	}

	/**
	 * Sorts JList
	 * 
	 * @param reverse
	 *            wenn true von hinten nach vorne
	 */
	public void sortNotes(boolean reverse) {
		TreeSet<Note> s = this.nl.sortNotes(reverse);
		this.dlm.removeAllElements();
		for (Note n : s) {
			this.dlm.addElement(n.getNoteName());
		}
	}

}
