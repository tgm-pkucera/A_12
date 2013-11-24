package at.rene8888.au02a.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author Rene Hollander
 * @version 1.0
 * 
 */
public class ObjectSerialization {

	/**
	 * @param obj
	 *            Object to Serialize
	 * @param f
	 *            file to write to
	 */
	static public void WriteToFile(Object obj, File f) {
		if (obj != null) {
			try {
				FileOutputStream fos = new FileOutputStream(f);
				GZIPOutputStream gos = new GZIPOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(gos);
				oos.writeObject(obj);
				oos.close();
				gos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param f
	 *            File to read
	 * @return Object from file
	 */
	static public Object ReadFromFile(File f) {
		Object out = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			GZIPInputStream gis = new GZIPInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(gis);
			out = ois.readObject();
			ois.close();
			gis.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
}