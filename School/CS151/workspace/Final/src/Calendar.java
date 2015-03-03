
import java.util.*;

/**
 * A calendar that holds hotel room reservations
 * @author Michelle Lopez
 */
public class Calendar 
{
    private ArrayList<Reservation> reservations;
    //private GregorianCalendar calendar;
    private Day currentDay;
    private Hotel hotel;
    
    private int LUXURIOUS_PRICE = 200;
    private int ECONOMIC_PRICE = 80;
    
    /**
     * Constructs a hotel and a calendar that will hold the hotel's reservations
     * @param year the current year
     * @param month the current month
     * @param dayOfMonth the current day
     */
    public Calendar(int month, int dayOfMonth, int year)
    {
        //calendar = new GregorianCalendar(year, month, dayOfMonth);
        reservations = new ArrayList<>();
        currentDay = new Day(month, dayOfMonth, year);
        hotel = new Hotel();
    }
    
    /**
     * Gets calendar's hotel
     * @return calendar's hotel
     */
    public Hotel getHotel()
    {
        return hotel;
    }
    
    /**
     * Gets all calendar's reservations
     * @return ArrayList of calendar reservations
     */
    public ArrayList<Reservation> getReservations()
    {
        return reservations;
    }
    
    /**
     * Checks if a specific room is reserved on a certain date
     * @param room the room to check
     * @param date the day to see if room is taken
     * @return true if room isn't taken on the date, false if room is taken
     */
    public boolean validDate(Room room, Day date)
    {
        for (Reservation r : reservations)
        {
            if (r.includesDate(date)) { return false; }
        }
        return true;
    }
    
    /**
     * Gets all available rooms of a certain type between the two dates provided
     * @param roomTypePrice price of the room based on what type it is
     * @param start the beginning date
     * @param end the ending date
     * @return ArrayList of rooms available between the beginning and ending date
     */
    public ArrayList<Room> availableRooms(int roomTypePrice, Day start, Day end)
    {
        //Only check days [60 days before start up to 60 days after end]    
        //From those reservations, get the rooms taken
        //Rooms available are ones that AREN'T those rooms
        Day sixtyBefore = start.addDays(-60);
        Day sixtyAfter = end.addDays(60);
        int index1 = search(0, reservations.size()-1, sixtyBefore, sixtyBefore);
        int index2 = search(index1, reservations.size()-1, sixtyAfter, sixtyAfter);
        Room[] unavailable = new Room[20];
        for (int i = index1; i<index2; i++)
        {
            Reservation current = reservations.get(i);
            //check if reservation conflicts with dates
            //if it does, add to notAvailable
            if (current.overlap(start, end))
            {
                unavailable[current.getRoom().getRoomNumber()] = current.getRoom();
            }
        }
        ArrayList<Room> available = new ArrayList<>();
        if (roomTypePrice==ECONOMIC_PRICE)//
        {
            for (int j = 10; j < 20; j++)
            {
                if (unavailable[j]==null) { available.add(hotel.getRoom(j)); }
            }
        }
        else
        {
            for (int j = 0; j < 10; j++)
            {
                if (unavailable[j]==null) { available.add(hotel.getRoom(j)); }
            }
        }
        /*for (int j = 0; j < 20; j++)
        {
            if (unavailable[j]==null) { available.add(hotel.getRoom(j)); }
        }*/
        return available;
    }
    
    /**
      Finds a value in a range of a sorted array, using the binary
      search algorithm.
      @param low the low index of the range
      @param high the high index of the range
      @param start the start date to look for
      @param end the end date to look for
      @return the index at which the value occurs, or should be placed
   */
    public int search(int low, int high, Day start, Day end) {

        int mid = (low + high) / 2;

        if (reservations.get(mid).compareTo(start, end)==0) 
        {
            return mid;
        } 
        else if (reservations.get(mid).compareTo(start, end) < 0) {
            if (low <= high) {
                return search(mid + 1, high, start, end);
            } else {
                return mid+1;
            }
        } else {
            if (low <= high) {
                return search(low, mid - 1, start, end);
            } else {
                if (mid==0) { return mid; }
                return mid+1;
            }
        }
    }
    
    
    /**
    * Gets all reservations on a specific day
    * @param day the day to check for reservations
    * @return ArrayList of reservations on the provided day
    */
    public ArrayList<Reservation> viewAllReservation(Day day)
    {
        //find Reservation that are 60 days before and after day
        //see if those reservations contain day (overlap method)
        Day sixtyBefore = day.addDays(-60);
        Day sixtyAfter = day.addDays(60);
        int index1 = search(0, reservations.size()-1, sixtyBefore, sixtyBefore);
        int index2 = search(index1, reservations.size()-1, sixtyAfter, sixtyAfter);
        ArrayList<Reservation> includesDay = new ArrayList<>();
        for (int i = index1; i<=index2; i++)
        {
            if (reservations.get(i).overlap(day, day))
            {
                includesDay.add(reservations.get(i));
            }
        }
        return includesDay;
    }
            
    /**
     * Adds reservation to Calendar if it is valid (or does System check?)
     * @param room the room to reserve
     * @param dateStart the start date of the reservation
     * @param dateEnd the end date of the reservation
     * @param UserID the user who makes the reservation
     * @return true if reservation was made, false if it wasn't
     */
    public boolean makeReservation(Room room, Day dateStart, Day dateEnd, String UserID)
    {
        //check if reservation is after current date
        //check if reservation is more than 60 days
        //check if room is available
        if (currentDay.compareTo(dateStart)<0 && dateEnd.daysFrom(dateStart) < 60)
        {
            Reservation res = new Reservation(room, dateStart, dateEnd, UserID);
            if (!reservations.isEmpty()) 
            { 
                int i = search(0, reservations.size()-1, dateStart, dateEnd); 
                reservations.add(i, res);
                //add to User reservations?
            }
            else { reservations.add(res); }
            return true;
        }
        return false;
    }
    
    /**
     * Cancels a reservation
     * @param r the reservation to cancel
     */
    public void cancelReservation(Reservation r)
    {
        Day start = r.getStartDate();
        Day end = r.getEndDate();
        int index = search(0, reservations.size()-1, r.getStartDate(), r.getEndDate());
        reservations.remove(index);
    }
    
    /**
     * A hotel with 20 rooms
     */
    class Hotel
    {
        private Room[] luxurious;
        private Room[] economic;
        
        /**
         * Constructs a hotel with 10 luxurious an 10 economic rooms, room
         * numbers are also given to each room
         */
        public Hotel()
        {
            luxurious = new Room[10];
            economic = new Room[10];
            for (int i=0; i<10; i++)
            {
                Room l = new Room(i, LUXURIOUS_PRICE);//luxurious room #'s range 0-9
                luxurious[i] = l;
                Room e = new Room(10+i, ECONOMIC_PRICE);//economic room #'s range 10-19
                economic[i] = e;
            }
        }
        
        /**
         * Gets a room from its room number
         * @param roomNum the number of the room to get
         * @return the room with the provided room number
         */
        public Room getRoom(int roomNum)
        {
            if (roomNum < 10) { return luxurious[roomNum]; }
            return economic[roomNum-10];
        }
    }
	public int getSize()
	{
	 return reservations.length(); 
}
	public String Reservation2Data(int index)
{
	return reservations.get(index).twoData();
}
    public boolean loadReservation(int aRoom, int aType,  String aDateStart, String aDateEnd, String UserID)
    {
        //check if reservation is after current date
        //check if reservation is more than 60 days
        //check if room is available
	Room room = new Room(aRoom, aType);
	Day dateStart = inputToDay(aDateStart);
	Day dateEnd = inputToDay(aDateEnd);
        if (currentDay.compareTo(dateStart)<0 && dateEnd.daysFrom(dateStart) < 60)
        {
            Reservation res = new Reservation(room, dateStart, dateEnd, UserID);
            if (!reservations.isEmpty())
            {
                int i = search(0, reservations.size()-1, dateStart, dateEnd);
                reservations.add(i, res);
                //add to User reservations?
            }
            else { reservations.add(res); }
            return true;
        }
        return false;
    }




}
