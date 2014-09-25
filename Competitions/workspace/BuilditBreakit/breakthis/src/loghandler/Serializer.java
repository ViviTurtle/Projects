package loghandler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serializer {

	public static void write(String file, LogData data) {
		ObjectOutputStream outputStream = null;
		try {
			OutputStream fileOs = new FileOutputStream(file);
			OutputStream buffer = new BufferedOutputStream(fileOs);
			outputStream = new ObjectOutputStream(buffer);
			outputStream.writeObject(data);

		} catch (Exception e) {
			Util.debug("Exception writing to " + file + ", e = " + e);
			Util.showOutput("Integrity Error");
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static LogData read(String file) {
		InputStream fileIs = null;
		
		try {
			fileIs = new FileInputStream(file);
			InputStream buffer = new BufferedInputStream(fileIs);
			ObjectInput input = new ObjectInputStream (buffer);
			LogData fromFile = (LogData) input.readObject();
			fromFile.deepCopy();
			
			return fromFile;
		} catch (Exception e) {
			Util.debug("Exception writing to " + file + ", e = " + e);
			Util.showOutput("Integrity Error");
			e.printStackTrace();
		} finally {
			try {
				fileIs.close();
			} catch (IOException e) {
			}
		}
		
		return null;
	}
}
