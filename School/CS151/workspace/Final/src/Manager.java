import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * A user that is a Manager
 */
public class Manager extends User {

	/**
	 * Constructs a manager with user ID and username
	 * 
	 * @param userID
	 *            the user ID number of the manager
	 * @param username
	 *            the username of the manager
	 */
	public Manager(int userID, String userName) {
		super.userID = userID;
		super.username = userName;
	}

	/**
	 * Saves reservations to a file
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void saveReservation() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
		// Requires the a Calender has a int getSize(return
		// reservations.length())
		//for (int i = 0; i < Calender.getSize(); i++) {

		//	writer.println(Calender.Reservation2Data(i));
			writer.close();

		//}
	}

}
