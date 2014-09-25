package loghandler;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Room implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private final Set<Visitor> visitors = new TreeSet<Visitor>();
	
	public Room(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void addVisitor(Visitor visitor) {
		visitors.add(visitor);

		Util.debug("Added visitor " + visitor.getName() 
				+ "." + visitor.getType() + " to room " + id);
	}
	
	public void removeVisitor(Visitor visitor) {
		visitors.remove(visitor);

		Util.debug("Removed visitor " + visitor.getName() 
				+ "." + visitor.getType() + " to room " + id);
	}
	
	public Set<Visitor> getVisitors() {
		return visitors;
	}
}
