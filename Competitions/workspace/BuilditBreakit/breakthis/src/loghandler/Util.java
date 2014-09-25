package loghandler;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static boolean debugEnabled() {
		return "true".equalsIgnoreCase(System.getProperty("debug"));
	}

	public static void debug(String message) {
		if (debugEnabled()) {
			System.out.println(new Date() + " " + message);
		}
	}
	
	public static void showOutput(String message) {
		System.out.println(message);
	}
	
	public static void printRooms(AllRooms rooms) {
		
		if (debugEnabled()) {
			for (Room room : rooms.getRooms()) {
				System.out.println("Room : " + room.getId() + " - Visitors :"
						+ room.getVisitors());
			}
		}
	}
	
	public static boolean isTrue(String value) {
		return "true".equalsIgnoreCase(value);
	}
	
	public static LogData getLogData(Map<String, String> inputs) {
		String file = inputs.get("file");
		File fp = new File(file);
		if (fp.exists()) {
			return Serializer.read(file);
		} else {
			LogData data = new LogData();
			data.setToken(inputs.get("token"));
			return data;
		}
	}
	
	public static boolean isAlphaNum(String var)
	{
		Pattern p=Pattern.compile("^[a-zA-Z0-9]*$");
		Matcher m=p.matcher(var);
		return (m.matches());
	}

	public static boolean isAlpha(String var)
	{
		Pattern p=Pattern.compile("^[a-zA-Z]*$");
		Matcher m=p.matcher(var);
		return (m.matches());
	}

	public static boolean isNumeric(String var)
	{
		Pattern p=Pattern.compile("^[0-9]*$");
		Matcher m=p.matcher(var);
		return (m.matches());
	}
}
