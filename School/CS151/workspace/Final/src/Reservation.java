/**
 * A reservation with a start date, end date, room type, and User ID
 * 
 * @author Michelle Lopez
 */
public class Reservation {
	private Room reserved;
	private Day dateStart;
	private Day dateEnd;
	private int userCreated;

	/**
	 * Constructs a reservation
	 * 
	 * @param res
	 *            the room the reserve
	 * @param start
	 *            the start date of the reservation
	 * @param end
	 *            the end date of the reservation
	 * @param userID
	 *            the user who holds this reservation
	 */
	public Reservation(Room res, Day start, Day end, int userID) {
		reserved = res;
		dateStart = start;
		dateEnd = end;
		userCreated = userID;
	}

	/**
	 * Gets ID of the owner of this reservation
	 * 
	 * @return the id of the user that made this reservation
	 */
	public int getUserID(){
		return userCreated;
	}
	/**
	 * Gets day when reservation starts
	 * 
	 * @return first day of reservation
	 */
	public Day getStartDate() {
		return dateStart;
	}

	/**
	 * Gets day when reservation ends
	 * 
	 * @return last day of reservation
	 */
	public Day getEndDate() {
		return dateEnd;
	}

	/**
	 * Checks if this reservation includes a certain day
	 * 
	 * @param date
	 *            the day to check for
	 * @return true if reservation includes date, false if it doesn't
	 */
	public boolean includesDate(Day date) {
		if (date.compareTo(dateStart) > 0 && date.compareTo(dateEnd) < 0) {
			return true;
		}
		return false;
	}

	/**
	 * Gets room in reservation
	 * 
	 * @return the room reserved in this reservation
	 */
	public Room getRoom() {
		return reserved;
	}

	/**
	 * Checks if this reservations conflicts with a time period
	 * 
	 * @param start
	 *            the beginning of the time period to check
	 * @param end
	 *            the ed of the time period to check
	 * @return false if reservation doesn't overlap with dates provided, true if
	 *         reservation overlaps
	 */
	public boolean overlap(Day start, Day end) {
		// Reservations overlap if this.endDate is after start or this.startDate
		// before end
		if (dateEnd.compareTo(start) < 0 || dateStart.compareTo(end) > 0) {
			return false; // reservation doesn't overlap w/ given dates
		}
		return true;
	}

	/**
	 * Compares this reservation's start and end dates with other start and end
	 * date to see if it comes before them
	 * 
	 * @param start
	 *            the other start day to compare this start day to
	 * @param end
	 *            the other end day to compare this end day to
	 * @return -1 if this reservation comes before the dates provided, 1 if this
	 *         reservation comes after, 0 if this reservation start and end
	 *         dates are equal to the other ones
	 */
	public int compareTo(Day start, Day end) {
		if (dateStart.compareTo(start) < 0) {
			return -1;
		}
		if (dateStart.compareTo(start) > 0) {
			return 1;
		} else { // have same start day
			if (dateEnd.compareTo(end) < 0) {
				return -1;
			}
			if (dateEnd.compareTo(end) > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * Returns reservation in String format containing reservation info
	 * "Username: Room#, StartDate to EndDate"
	 * 
	 * @return reservation in String format
	 */
	public String toString() {
		return userCreated + ": Room#" + reserved.getRoomNumber() + ", "
				+ dateStart.toString() + " to " + dateEnd.toString();
	}

	public String toData()

	{
		return reserved.toString() + "," + dateStart.toString() + ","
				+ dateEnd.toString() + "," + userCreated;
	}

}
