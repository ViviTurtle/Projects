import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class System {
	ArrayList<Guest> guests = new ArrayList<Guest>()
	room[] twoRooms = new room[10];
	room[] eightyRooms = new room[10];

	public static void main(String[] args)
	{
		loadReservation(new File("something"));
		System.out.println("Please Select User type")
		//if selects user
		//display make reservation and  view/cancel a reservation conneted to the thingies	
		
	}
			
	public void addGuest(int userID, String username)
	{		
	
	}
				public static void loadReservation(File name)
				{	
					String string;
					try
					{
					Scanner scan = new Scanner(name);
					while (scan.hasNextLine()) {
						string = scan.nextLine().toLowerCase();
						Scanner scan2 = new Scanner(string).useDelimiter(";");
						while (scan2.hasNext())
						{	
							
								/*
								 * Calender needs the following
								 		* public void makeReservaton(int roomNumber, String dateStart, String dateEnd, String userCreated)
						{
	
}
 */
							[Calender].makeReservaton(scan2.nextInt(), scan2.next() , scan2.next(), scan2.next());
						}
					}
					scan.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println("Invalid File");
						
					}
					
				}
}


