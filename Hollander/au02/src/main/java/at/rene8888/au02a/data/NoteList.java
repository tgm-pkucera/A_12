package at.rene8888.au02a.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Verwaltet Notizen
 * 
 * @author Rene Hollander 3AHIT
 *
 */
public class NoteList extends ArrayList<Note> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 */
	public NoteList() {
		super();
	}
	
	/**
	 * @param notelist
	 */
	public NoteList(ArrayList<Note> notelist) {
		super(notelist);
	}
	
	/**
	 * @param i Index des Element
	 * @return Returns note at index
	 */
	public Note getNote(int i) {
		return this.get(i);
	}
	
	/**
	 * Sets old note to new note
	 * 
	 * @param oldnote Old note
	 * @param newnote New Note
	 */
	public void setNote(Note oldnote, Note newnote) {
		this.set(this.indexOf(oldnote), newnote);
	}
	
	/**
	 * @param note Note to adds
	 */
	public void addNote(Note note) {
		this.add(note);
	}
	
	/**
	 * @param note Note to adds
	 * @param index index where to add
	 */
	public void addNote(Note note, int index) {
		this.add(index, note);
	}
	
	/**
	 * @param i Removes note where index=i
	 */
	public void removeNote(int i) {
		this.remove(i);
	}
	
	/**
	 * @param n Removes note where note=note
	 */
	public void removeNote(Note n) {
		this.remove(n);
	}
	
	/**
	 * @return Returns String array of all Notes
	 */
	public String[] getSubjectList() {
		String[] subjectlist = new String[this.size()];
		for (int i = 0; i < this.size(); i++) {
			subjectlist[i] = this.get(i).getNoteName();
		}
		return subjectlist;
	}
	
}
