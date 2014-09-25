package loghandler;

import java.io.Serializable;

public class Visitor implements Serializable ,Comparable<Visitor>{
	
	private static final long serialVersionUID = 1L;
	
	public static final String TypeEmployee = "E";
	public static final String TypeGuest = "G";
	
	private String name;
	private String type;
	private VisitorState state;
	
	Visitor(String name, String type) {
		this.name = name;
		this.type = type;
		this.state = new VisitorState();
		
		Util.debug("Created visitor " + name
				+ "." + type);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public boolean isGuest() {
		return this.type.equals(TypeGuest);
	}
	
	public boolean isEmployee() {
		return this.type.equals(TypeEmployee);
	}
	
	public VisitorState getState() {
		return state;
	}

	public void setState(VisitorState state) {
		this.state = state;
	}

	public void updateState(Room room, String state) {
		Util.debug("Visitor " + name + " did " + state
				+ " room " + room.getId());
		
		this.state.setCurrentPlace(room);
		this.state.setState(state);
	}
	
	public String toString() {
		return name + "(" + type +")";
	}

	@Override
	public int compareTo(Visitor o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
		
	}
}
