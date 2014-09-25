package loghandler;

import java.io.Serializable;

public class VisitorState  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String Arrived = "A";
	public static final String Left = "L";
	
	private Room currentPlace;
	private String state;
	
	public Room getCurrentPlace() {
		return currentPlace;
	}
	public void setCurrentPlace(Room currentPlace) {
		this.currentPlace = currentPlace;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public boolean arrivedAtGallery() {
		return this.currentPlace.getId() == -1 && Arrived.equals(state); 
	}
}
