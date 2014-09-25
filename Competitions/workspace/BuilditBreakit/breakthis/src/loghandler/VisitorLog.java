package loghandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitorLog  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private final List<VisitorLogEntry> logs = new ArrayList<VisitorLogEntry>(); 

	public VisitorLog() {
		
	}
	
	public VisitorLog(List<VisitorLogEntry> entries) {
		
		if (entries != null && entries.size() > 0)
			logs.addAll(entries);
	}
	
	public void addEntry(int timestamp, AllRooms rooms, AllVisitors visitors) {
		if (logs.size() > 0) {
			VisitorLogEntry entry = logs.get(logs.size()-1);
			if (entry.getTime() > timestamp) {
				Util.showOutput("invalid");
				Util.debug("Invalid Timestamp");
			} else {
				logs.add(new VisitorLogEntry(timestamp, rooms, visitors));
			}
				
		} else {
			logs.add(new VisitorLogEntry(timestamp, rooms, visitors));
		}
	}
	
	public List<VisitorLogEntry> getLogs(int time) {
		
		List<VisitorLogEntry> returnLogs = new ArrayList<VisitorLogEntry>();
		for (VisitorLogEntry entry : logs) {
			if (entry.getTime() == time) {
				returnLogs.add(entry);
			}
		}
		
		return returnLogs;
	}
	
	public List<VisitorLogEntry> getLogs() {
		return logs;
	}

	public List<VisitorLogEntry> getLogs(int startTime, int endTime) {
		List<VisitorLogEntry> returnLogs = new ArrayList<VisitorLogEntry>();
		for (VisitorLogEntry entry : logs) {
			if (entry.getTime() >= startTime && entry.getTime() <= endTime) {
				returnLogs.add(entry);
			}
		}
		
		return returnLogs;
	}
	
	public int getTotalTimeSpent(String name) {
		
		int end=logs.get(logs.size()-1).getTime();
		int start = -1;
		
		for (VisitorLogEntry entry : logs) {
			Visitor v = entry.getVisitors().getVisitor(name);
			
			if( start < 0 && v != null ) {
				if (v.getState().arrivedAtGallery()) {
					start = entry.getTime();
				}
			} else if (start >= 0 && v == null) {
				end = entry.getTime();
				break;
			}
		}
		
		return end-start;
	}
}
