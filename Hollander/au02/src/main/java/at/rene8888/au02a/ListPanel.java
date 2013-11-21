package at.rene8888.au02a;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

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

		for (String s : nl.getSubjectList()) {
			this.dlm.addElement(s);
		}

		this.list = new JList<String>(dlm);
		this.list.addListSelectionListener(this.c);
		
		JScrollPane scroll = new JScrollPane(list);
		this.add(scroll, BorderLayout.CENTER);
		this.newNote = new JButton("New Note");
		this.newNote.addActionListener(this.c);
		this.deleteNote = new JButton("Delete Note");
		this.deleteNote.addActionListener(this.c);
		JPanel buttonp = new JPanel();
		buttonp.setLayout(new GridLayout(1, 2));
		buttonp.add(this.newNote);
		buttonp.add(this.deleteNote);
		this.add(buttonp, BorderLayout.SOUTH);
	}

	/**
	 * @param index
	 *            Index des Element
	 * @return Gibt das Element beim Index zurück
	 */
	public Note getNoteElement(int index) {
		return this.nl.getNote(index);
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
	 * @param index
	 *            Index des Element
	 */
	public void removeNoteElement(int index) {
		this.nl.removeNote(index);
		this.dlm.remove(index);
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

}
