import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Manager extends User {
public Manager(int userID, String userName)
{
	super.userID = userID;
	super.username = userName;
}
	

	public void saveReservation()
	{
		PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
		//Requires the a Calender has a int getSize(return reservations.length())
		for (int i = 0; i < [Calender].getSize(); i++)
		{
			//need to require that Calender has a String getReservation{return Reservation.toString } 
			writer.println([Calender].getReservation(i));
			writer.close();
			
		}
	}

	}
