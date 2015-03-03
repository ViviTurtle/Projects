/**
 * A room that can be either be luxurious or economic
 * 
 * @author Michelle Lopez
 */
public class Room {
	private int roomType;
	private int roomNumber;

	/**
	 * Constructs a room with a room number and a price
	 * 
	 * @param num
	 *            the room number
	 * @param type
	 *            the price of the room, which tells what type it is
	 */
	public Room(int num, int type) {
		roomNumber = num;
		roomType = type;
	}

	/**
	 * Gets room number
	 * 
	 * @return the number of this room
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	public String toString() {
		return roomNumber + "," + roomType;
	}
}
