package at.rene8888.au02a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import at.rene8888.au02a.data.Note;

/**
 * Panelklasse für die Notiz
 * 
 * @author Rene Hollander 3AHIT
 * @version 1.0
 * 
 */
public class NotePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Control c;

	private JPanel header;
	private JPanel content;
	private JPanel footer;

	private JLabel subject;

	private JTextArea text;

	private JLabel author;
	private JLabel createdate;
	private JLabel editdate;

	private Note currentNote;

	/**
	 * Konstruktor für die NotePanel Klasse
	 * 
	 * @param c
	 *            Instanz der Control Klasse
	 * @param currentNote
	 *            Note die beim start ausgewählt werden soll
	 */

	public NotePanel(Control c, Note currentNote) {

		this.c = c;

		this.setLayout(new BorderLayout());

		this.header = new JPanel();
		this.header.setLayout(new GridLayout(1, 1));

		this.content = new JPanel();
		this.content.setLayout(new GridLayout(1, 1));

		this.footer = new JPanel();

		this.subject = new JLabel("");
		subject.setFont(new Font("Arial", Font.PLAIN, 30));
		this.header.add(this.subject);

		this.text = new JTextArea("");
		this.text.setLineWrap(true);
		this.text.setWrapStyleWord(true);
		this.text.setBackground(Color.yellow);
		JScrollPane scroll = new JScrollPane(text);
		this.content.add(scroll, BorderLayout.CENTER);

		this.author = new JLabel("");
		this.footer.add(this.author);

		this.createdate = new JLabel("");
		this.footer.add(this.createdate);

		this.editdate = new JLabel("");
		this.footer.add(this.editdate);

		this.add(this.header, BorderLayout.NORTH);
		this.add(this.content, BorderLayout.CENTER);
		this.add(this.footer, BorderLayout.SOUTH);

		this.subject.addMouseListener(this.c);

		this.writeNote(currentNote);

	}

	/**
	 * Setzt den Text des Headers
	 * 
	 * @param s
	 *            Text für den Header (Betreff)
	 */
	public void setSubjectText(String s) {
		this.subject.setText(s);
	}

	/**
	 * @return Gibt die gerade verwendete Notiz zurück
	 */
	public Note getNote() {
		return this.currentNote;
	}

	/**
	 * @param note
	 *            Schreibt die Inhalte der neuen Notiz
	 */
	@SuppressWarnings("deprecation")
	public void writeNote(Note note) {
		this.currentNote = note;
		this.subject.setText(note.getNoteName());
		this.text.setText(note.getNoteContent());
		this.author.setText("Author: " + note.getNoteAuthor());
		this.createdate.setText("Create Date: " + note.getCreateDate().toLocaleString());
		this.editdate.setText("Edit Date: " + note.getChangeDate().toLocaleString());
	}

	/**
	 * Liest der Inhalt der Notizen in das Objekt
	 */
	public void updateNote() {

		this.currentNote.setNoteName(this.subject.getText());
		this.currentNote.setChangeDate(new Date());
		this.currentNote.setNoteContent(this.text.getText());

	}

	/**
	 * @param e
	 *            MouseEvent e
	 * @return Gibt true zrück, wenn due Source mit dem Subject Label
	 *         übereinstimmt
	 */
	public boolean checkSubjectLabel(MouseEvent e) {
		if (e.getSource() == this.subject)
			return true;
		return false;
	}

}
