package uam.extremo.ui.views.searchtree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import uam.extremo.ui.Activator;

public final class Serializer {
	public static  <T> byte[] serialize(T object) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
			out = new ObjectOutputStream(bos);
			out.writeObject(object);

			byte[] byteArray = bos.toByteArray();
			return byteArray;
		}
		catch (IOException e) {
			Activator.writeConsole(e.getMessage());
			return null;
		} finally {
			try {
				if (out != null)
					out.close();
			}
			catch (IOException ex) {
				Activator.writeConsole(ex.getMessage());
			}
			try {
				bos.close();
			}
			catch (IOException ex) {
				Activator.writeConsole(ex.getMessage());
			}
		}
	}

	/**
	 * Converts a byte array to an Object.
	 * 
	 * @param byteArray, a byte array that represents a serialized Object.
	 * @return, an instance of the Object class.
	 */
	public static Object deserialize(byte[] byteArray) {
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
		ObjectInput in = null;
		try {
			in = new ObjectInputStream(bis);
			Object o = in.readObject();
			return o;
		}
		catch (ClassNotFoundException | IOException e) {
			Activator.writeConsole(e.getMessage());
			return null;
		}
		finally {
			try {
				bis.close();
			}
			catch (IOException ex) {
				Activator.writeConsole(ex.getMessage());
			}
			try {
				if (in != null)
					in.close();
			}
			catch (IOException ex) {
				Activator.writeConsole(ex.getMessage());
			}
		}
	}
}