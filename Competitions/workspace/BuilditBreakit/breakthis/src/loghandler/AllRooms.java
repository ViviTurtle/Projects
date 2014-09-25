package loghandler;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AllRooms  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final Map<Integer, Room> rooms = new TreeMap<Integer, Room>();
	
	public Room getOrCreate(int id) {
		if (rooms.get(id) == null) {
			rooms.put(id, new Room(id));
		}
		
		return rooms.get(id);
	}
	
	public Room getRoom(int id) {
		return rooms.get(id);
	}
	
	public Collection<Room> getRooms() {
		return rooms.values();
	}
	
	public Map<Integer, Room> getRoomsMap() {
		return rooms;
	}
	
	public AllRooms deepCopy() {
		AllRooms clone = new AllRooms();
		
		for (Room room : this.rooms.values()) {
			clone.getOrCreate(room.getId());
		}
		
		return clone;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rooms { ");
		
		for (Room r : this.rooms.values()) {
			builder.append("R-").append(r.getId()).append(" (");
			
			for (Visitor v : r.getVisitors()) {
				builder.append(v.getName()).append(".")
				.append(v.getType()).append(",");
			}
			
			builder.append(" ), ");
		}
		builder.append(" }");
		return builder.toString();
	}
}
