package at.rene8888.au02a.data;

import java.util.Comparator;

/**
 * Sort Notes from A to Z
 * 
 * @author Rene Hollander 3AHIT
 * 
 */
public class NoteComparator implements Comparator<Note> {

	public int compare(Note n1, Note n2) {
		return n1.getNoteName().toLowerCase().compareTo(n2.getNoteName().toLowerCase());
	}

}
