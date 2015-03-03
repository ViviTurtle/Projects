import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HotelModel {
	ArrayList<Guest> guests;
	CalendarModel calendar;
	// ArrayList<Manager> managers = new ArrayList<Manager>();
	Room[] twoRooms = new Room[10];
	Room[] eightyRooms = new Room[10];

	public HotelModel() {
		GregorianCalendar now = new GregorianCalendar();
		calendar = new CalendarModel(now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.YEAR));
		guests = new ArrayList<Guest>();
	}

	public HotelModel(File file) {
		GregorianCalendar now = new GregorianCalendar();
		calendar = new CalendarModel(now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.YEAR));
		guests = new ArrayList<Guest>();
	}


	public boolean makeReservation(Room room, Day dateStart, Day dateEnd, int UserID){
		return calendar.makeReservation(room, dateStart, dateEnd, UserID);
	}
	public ArrayList<Reservation> getReservations() {
		return calendar.getReservations();
	}

	public Room[] getTwoRooms() {
		return twoRooms;
	}

	public Room[] getEightyRooms() {
		return eightyRooms;
	}

	public ArrayList<Guest> getGuests() {
		return guests;
	}

	public void addGuest(Guest g) {
		guests.add(g);
	}
	public String toString(){
		String s = "";
		for(Guest g:guests){
			s+=g.toString()+"\n";
		}
		return s;
	}
}
