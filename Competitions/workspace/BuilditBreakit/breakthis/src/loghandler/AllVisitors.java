package loghandler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AllVisitors  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final Map<String, Visitor> visitors = new TreeMap<String, Visitor>();

	public void addVisitor(Visitor visitor) {
		visitors.put(visitor.getName(), visitor);
	}
	
	public Visitor getOrCreate(String name, String type) {
		if (visitors.get(name) == null) {
			visitors.put(name, new Visitor(name,type));
		}
		
		return visitors.get(name);
	}
	public Visitor getVisitor(String name) {
		return visitors.get(name);
	}
	public Visitor removeVisitor(String name) {
		return visitors.remove(name);
	}
	
	public Map<String, Visitor> getVisitors() {
		return visitors;
	}
	
	public Map<String, Visitor> getEmployees() {
		Map<String, Visitor> employees = new TreeMap<String, Visitor>();
		
		for (Visitor v : visitors.values()) {
			if (v.isEmployee()) {
				employees.put(v.getName(), v);
			}
		}
		
		return employees;
	}

	public Map<String, Visitor> getGuests() {
		Map<String, Visitor> guests = new TreeMap<String, Visitor>();
		
		for (Visitor v : visitors.values()) {
			if (v.isGuest()) {
				guests.put(v.getName(), v);
			}
		}
		
		return guests;
	}

	public AllVisitors deepCopy() {
		
		AllVisitors clone = new AllVisitors();
		
		for (Visitor visitor : visitors.values()) {
			clone.getOrCreate(visitor.getName(), visitor.getType());
		}
		
		return clone;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Visitors : ");
		for (Visitor v : visitors.values()) {
			builder.append("{ ").append(v.getName()).append(".").append(v.getType())
			.append("R-").append(v.getState().getCurrentPlace().getId()).append(" S:").append(v.getState().getState())
			.append(" }");
		}
		
		return builder.toString();
	}
}
