package at.rene8888.au02a.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Verwaltet Notizen
 * 
 * @author Rene Hollander 3AHIT
 * 
 */
public class NoteList extends HashSet<Note> implements Serializable {

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
		super();
	}

	/**
	 * @param subject
	 *            name of element
	 * @return Returns note at index
	 */
	public Note getNote(String subject) {
		for (Note note : this) {
			if (note.getNoteName().equals(subject))
				return note;
		}
		return null;
	}

	/**
	 * Sets old note to new note
	 * 
	 * @param oldnote
	 *            Old note
	 * @param newnote
	 *            New Note
	 */
	public void setNote(Note oldnote, Note newnote) {
		this.remove(oldnote);
		this.add(newnote);
	}

	/**
	 * @param note
	 *            Note to adds
	 */
	public void addNote(Note note) {
		this.add(note);
	}

	/**
	 * @param n
	 *            removes element where note = n
	 */
	public void removeNote(Note n) {
		this.remove(n);
	}

	/**
	 * @return Returns String array of all Notes
	 */
	public Object[] getSubjectList() {
		ArrayList<String> s = new ArrayList<String>();
		for (Note n : this) {
			s.add(n.getNoteName());
		}
		return s.toArray();
	}

	/**
	 * @return first note
	 */
	public Note getFirstNote() {
		for (Note n : this) {
			return n;
		}
		return null;
	}

	/**
	 * @param s
	 *            Note name
	 * @return note by name
	 */
	public Note getNoteByName(String s) {
		for (Note n : this) {
			if (n.getNoteName().equals(s))
				return n;
		}
		return null;
	}

	/**
	 * Sorts Set
	 * 
	 * @param reverse
	 *            Wenn true von hinten nach vorne
	 * @return sorted tree set
	 */
	public TreeSet<Note> sortNotes(boolean reverse) {
		if (reverse) {
			TreeSet<Note> s = new TreeSet<Note>(new InvertedNoteComparator());
			s.addAll(this);
			return s;
		} else {
			TreeSet<Note> s = new TreeSet<Note>(new NoteComparator());
			s.addAll(this);
			return s;
		}
	}
}
