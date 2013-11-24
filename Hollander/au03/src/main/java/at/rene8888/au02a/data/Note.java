package at.rene8888.au02a.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Notitzklasse
 * 
 * @author Rene Hollander
 * @version 1.0
 */
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Name der Note
	 */
	public String noteName;
	/**
	 * Name des Autor
	 */
	public String noteAuthor;
	/**
	 * Erstellungsdatum
	 */
	public Date createDate;
	/**
	 * Letzte veränderung
	 */
	public Date changeDate;

	/**
	 * Inhalt der Notiz
	 */
	public String noteContent;

	/**
	 * Konstruktor für die Note Klasse
	 * 
	 * @param noteName
	 *            Name der Notiz
	 * @param noteAuthor
	 *            Name des Author
	 * @param createDate
	 *            Erstellungsdatum der Notiz
	 * @param noteContent
	 *            Inhalt der Notiz
	 */
	public Note(String noteName, String noteAuthor, Date createDate, String noteContent) {

		this.noteName = noteName;
		this.noteAuthor = noteAuthor;
		this.createDate = createDate;
		this.changeDate = createDate;

		this.noteContent = noteContent;
	}

	/**
	 * @return the noteName
	 */
	public String getNoteName() {
		return noteName;
	}

	/**
	 * @param noteName
	 *            the noteName to set
	 */
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	/**
	 * @return the noteAuthor
	 */
	public String getNoteAuthor() {
		return noteAuthor;
	}

	/**
	 * @param noteAuthor
	 *            the noteAuthor to set
	 */
	public void setNoteAuthor(String noteAuthor) {
		this.noteAuthor = noteAuthor;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the changeDate
	 */
	public Date getChangeDate() {
		return changeDate;
	}

	/**
	 * @param changeDate
	 *            the changeDate to set
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * @return the noteContent
	 */
	public String getNoteContent() {
		return noteContent;
	}

	/**
	 * @param noteContent
	 *            the noteContent to set
	 */
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	/**
	 * @return Gibt den Text für die JList zurück
	 */
	public String getNoteEntity() {
		return this.noteName;
	}

	@Override
	public boolean equals(Object o) {
		return ((Note) o).getNoteName().equals(this.getNoteName());
	}

	@Override
	public int hashCode() {
		return this.getNoteName().hashCode();
	}

}
