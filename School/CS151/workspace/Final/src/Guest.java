
public class Guest extends User {

	/**
	 * Constructs an new guess
	 * 
	 * @param userID
	 *            the userID of the new person
	 * @param username
	 *            the Username of this peron
	 */
	public Guest(int userID, String username) {
		super.userID = userID;
		super.username = username;
	}

	
	public String toString() {
		return super.userID + "," + super.username;
	}

}
