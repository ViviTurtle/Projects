import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class System {

	static HotelController controller;
	static CalendarModel calendar;
	static HotelModel model;

	public static void main(String[] args) {
		loadReservation(new File("reservation.txt"));
		loadGuests(new File("hotel.txt"));
		// System.out.println("Please Select User type");
		// if selects user
		// display make reservation and view/cancel a reservation conneted to
		// the thingies

		MainView view = new MainView();
		model = new HotelModel();
		// calendar = new CalendarModel();
		controller = new HotelController(view, calendar);

		write(controller.getCalendarModel().reservationsToData(),
				"reservations.txt");
		write(model.toString(), "hotel.txt");

	}

	public static void addGuest(int userID, String username) {
		model.addGuest(new Guest(userID, username));
	}

	public static int getUserIndex(int userID) {
		int i = 0;
		ArrayList<Guest> guests;
		guests = model.getGuests();
		/*
		 * } catch(NullPointerException e){ return -1; }
		 */
		for (Guest g : guests) {
			if (g.getUserID() == userID) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static void write(String s, String name) {
		PrintWriter out;
		try {
			out = new PrintWriter(name);
			out.println(s);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadGuests(File name) {
		String s;
		try {
			Scanner scan = new Scanner(name);
			while (scan.hasNextLine()) {
				
				s = scan.nextLine();
				String[] g = s.split(",");
				model.addGuest(new Guest(Integer.parseInt(g[0]),g[1]));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// System.out.println("Invalid File");

		}
	}

	public static void loadReservation(File name) {
		String string;
		try {
			Scanner scan = new Scanner(name);
			while (scan.hasNextLine()) {
				string = scan.nextLine().toLowerCase();
				Scanner scan2 = new Scanner(string).useDelimiter(",");
				while (scan2.hasNext()) {

					calendar.loadReservation(scan2.nextInt(), scan2.nextInt(),
							scan2.next(), scan2.next(), scan2.nextInt());
					// scan2.nextInt(), scan2.next() , scan2.next(),
					// scan2.next());
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// System.out.println("Invalid File");

		}
	}
}
