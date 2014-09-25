package loghandler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LogReader {
	private static final String FourSpaces = "    ";
	private static final String NewLine = "\n";
	private static final String NewLine1 = "";
	private static final String FourSpaces1 = "";
	
	public static void main(String... a) throws Exception {
		if (a == null || a.length == 0)
			throw new Exception("Invalid Input");

		String input = a[0];
		Util.debug("LogHandlermain.main() input : " + input);

		if (input.indexOf(",") < 0) {
			Util.showOutput("Invalid");
			System.exit(-1);
		}

		String[] inParts = input.split(",");
		Map<String, String> inputs = new HashMap<String, String>();

		for (String part : inParts) {
			if (part.indexOf("=") <= 0) {
				Util.showOutput("Invalid");
				System.exit(-1);
			}

			inputs.put(part.split("=")[0], part.split("=")[1]);
		}

		Util.debug("LogHandlermain.main() input : " + inputs);
		handleRequest(inputs);

	}

	private static void handleRequest(Map<String, String> inputs) {
		LogData data = Util.getLogData(inputs);
		if (data != null && validate(inputs, data)) {
			showResult(inputs, data);
		}
	}
	

	private static void showResult(Map<String, String> inputs, LogData data) {
		String show = inputs.get("show");
		String showRooms = inputs.get("showrooms");
		String showHtml = inputs.get("html");
		String name = inputs.get("name");
		String type = inputs.get("type");
		String file = inputs.get("file");
		String token = inputs.get("token");
		String timespent = inputs.get("timespent");
		String empRoomList=inputs.get("empRoomHistory");
		String exclusivebound=inputs.get("exclusivebound");
		
		if (Util.isTrue(show)) {
		    
		    if (Util.isTrue(showHtml))
		        showAllData(inputs, data);
		    else 
		        showTextData(inputs, data);
		    
		} else if (Util.isTrue(showRooms)) {
			 if (Util.isTrue(showHtml))
				 showHtmlRooms(inputs,data);
			 else
				 showRoomHistory(inputs, data);
		} else if (Util.isTrue(timespent)) {
			
			int timeSpentValue = data.getLog().getTotalTimeSpent(name);
			
			if (timeSpentValue > 0)
				Util.showOutput(""+timeSpentValue);
		}else if (Util.isTrue(empRoomList)) {
			 if (Util.isTrue(showHtml))
				 showHtmlEmployeeHistory(inputs,data);
			 else
				 showEmployeeHistory(inputs, data);
		}else if (Util.isTrue(exclusivebound)) {
			 if (Util.isTrue(showHtml))
				 showHtmlExclusiveBounds(inputs,data);
			 else
				 showExclusiveBounds(inputs, data);
		}
	}

	private static void showRoomHistory(Map<String, String> inputs, LogData data) {

		String name = inputs.get("name");
		VisitorLog log = data.getLog();
		Set<String> rooms = new LinkedHashSet<String>();
		for (VisitorLogEntry entry : log.getLogs()) {
			Visitor visitor = entry.getVisitors().getVisitor(name);
			
			if (visitor != null) {
				rooms.add("" + visitor.getState().getCurrentPlace().getId());
			}
		}

		int i=0, size = rooms.size();
		for (String r : rooms) {
			i++;
			
			if(Integer.parseInt(r) != -1)
			{
				System.out.print(r);
				System.out.print((i<size) ? "," : "\n");
			}
		}
	}
	private static void showEmployeeHistory(Map<String, String> inputs, LogData data)
	{
		int startTime=Integer.parseInt(inputs.get("x"));
		int endTime=Integer.parseInt(inputs.get("y"));
		
		List<VisitorLogEntry> logs=data.getLog().getLogs(startTime, endTime);
		int i=0;
		Set<String> names = new TreeSet<String>();
		for (VisitorLogEntry visEntry :logs)
		{
			Map<String,Visitor> employees=visEntry.getVisitors().getEmployees();
			if (employees.size() > 0)
				names.addAll(employees.keySet());
		}
		
		int size = names.size();
		
		for (String name : names) 
		{
			i++;
			System.out.print(name);
			System.out.print(i<size ? ",":"\n");
		}
	}
	private static void showExclusiveBounds(Map<String, String> inputs, LogData data)
	{
		int startTime=Integer.parseInt(inputs.get("x"));
		int endTime=Integer.parseInt(inputs.get("y"));
		int xstartTime=Integer.parseInt(inputs.get("xexclude"));
		int xendTime=Integer.parseInt(inputs.get("yexclude"));
		
		List<VisitorLogEntry> logs=data.getLog().getLogs(startTime, endTime);
		int i=0;
		Set<String> names = new TreeSet<String>();
		for (VisitorLogEntry visEntry :logs)
		{
			Map<String,Visitor> employees=visEntry.getVisitors().getEmployees();
			if (employees.size() > 0)
				names.addAll(employees.keySet());
		}
		List<VisitorLogEntry> xlogs=data.getLog().getLogs(xstartTime, xendTime);
		Set<String> xnames = new TreeSet<String>();
		for (VisitorLogEntry visEntry :xlogs)
		{
			Map<String,Visitor> employees=visEntry.getVisitors().getEmployees();
			if (employees.size() > 0)
				xnames.addAll(employees.keySet());
		}
		
		names.removeAll(xnames);
		int size = names.size();
		
		for (String name : names) 
		{
			i++;
			System.out.print(name);
			System.out.print(i<size ? ",":"\n");
		}
	}
	private static void showHtmlExclusiveBounds(Map<String, String> inputs, LogData data)
	{
		int startTime=Integer.parseInt(inputs.get("x"));
		int endTime=Integer.parseInt(inputs.get("y"));
		int xstartTime=Integer.parseInt(inputs.get("xexclude"));
		int xendTime=Integer.parseInt(inputs.get("yexclude"));
		
		List<VisitorLogEntry> logs=data.getLog().getLogs(startTime, endTime);
		
		Set<String> names = new TreeSet<String>();
		for (VisitorLogEntry visEntry :logs)
		{
			Map<String,Visitor> employees=visEntry.getVisitors().getEmployees();
			if (employees.size() > 0)
				names.addAll(employees.keySet());
		}
		List<VisitorLogEntry> xlogs=data.getLog().getLogs(xstartTime, xendTime);
		Set<String> xnames = new TreeSet<String>();
		for (VisitorLogEntry visEntry :xlogs)
		{
			Map<String,Visitor> employees=visEntry.getVisitors().getEmployees();
			if (employees.size() > 0)
				xnames.addAll(employees.keySet());
		}
		
		names.removeAll(xnames);
		
		StringBuilder htmlOutput = new StringBuilder();
		htmlOutput.append("<html>").append(NewLine1);
		htmlOutput.append("<body>").append(NewLine1);
		htmlOutput.append("<table>").append(NewLine1);
		htmlOutput.append("<tr>").append(NewLine1);
		htmlOutput.append(FourSpaces1).append("<th>Employees</th>").append(NewLine1);
		htmlOutput.append("</tr>").append(NewLine1);
		for (String name : names) 
		{
			htmlOutput.append("<tr>").append(NewLine1);
			htmlOutput.append(FourSpaces1).append("<td>");
			htmlOutput.append(name);
			htmlOutput.append("</td>").append(NewLine1);
			htmlOutput.append("</tr>").append(NewLine);
			
		}
		htmlOutput.append("</table>").append(NewLine1);
        htmlOutput.append("</body>").append(NewLine1);
        htmlOutput.append("</html>").append(NewLine1);
        Util.showOutput(htmlOutput.toString());
	}
	private static void showHtmlEmployeeHistory(Map<String, String> inputs, LogData data)
	{
		int startTime=Integer.parseInt(inputs.get("x"));
		int endTime=Integer.parseInt(inputs.get("y"));
		
		List<VisitorLogEntry> logs=data.getLog().getLogs(startTime, endTime);
	
		Set<String> names = new TreeSet<String>();
		for (VisitorLogEntry visEntry :logs)
		{
			Map<String,Visitor> employees=visEntry.getVisitors().getEmployees();
			if (employees.size() > 0)
				names.addAll(employees.keySet());
		}
		
		
		StringBuilder htmlOutput = new StringBuilder();
		htmlOutput.append("<html>").append(NewLine1);
		htmlOutput.append("<body>").append(NewLine1);
		htmlOutput.append("<table>").append(NewLine1);
		htmlOutput.append("<tr>").append(NewLine1);
		htmlOutput.append(FourSpaces1).append("<th>Employees</th>").append(NewLine1);
		htmlOutput.append("</tr>").append(NewLine1);
		for (String name : names) 
		{
		
			htmlOutput.append("<tr>").append(NewLine1);
			htmlOutput.append(FourSpaces1).append("<td>");
			htmlOutput.append(name);
			htmlOutput.append("</td>").append(NewLine1);
			htmlOutput.append("</tr>").append(NewLine);
			
		}
		htmlOutput.append("</table>").append(NewLine1);
        htmlOutput.append("</body>").append(NewLine1);
        htmlOutput.append("</html>").append(NewLine1);
        Util.showOutput(htmlOutput.toString());
	}
	private static void showTextData(Map<String, String> inputs, LogData data) {
		AllVisitors visitors = data.getVisitors();
		Map<String, Visitor> employees = visitors.getEmployees();
		Map<String, Visitor> guests =  visitors.getGuests(); 
        Collection<Room> roomList = data.getRooms().getRooms();
        
		StringBuilder textOutput = new StringBuilder();
		
		if (employees.values().size() == 0){
			textOutput.append("\n");
		}
		
		int i = 0, size = employees.values().size();
		for (Visitor e : employees.values()) {
		    i++;
		    textOutput.append(e.getName());
		    textOutput.append((i < size) ? "," : "\n");
		}
		
		if (guests.values().size() == 0){
			textOutput.append("\n");
		}
		i = 0; size = guests.values().size();
		for(Visitor g : guests.values()) {
		    i++;
		    textOutput.append(g.getName());
            textOutput.append((i < size) ? "," : "\n");
		}
		
        for (Room room : roomList) {
            if (room.getId() == -1 || room.getVisitors().size() ==0)
                continue;
            
            textOutput.append(room.getId() + ": ");
            
            i = 0; size = room.getVisitors().size();
            for (Visitor v : room.getVisitors()) {
                i++;
                textOutput.append(v.getName());

                if (i<size)
                    textOutput.append(",");
            }
            
            textOutput.append("\n");
        }
        
        Util.showOutput(textOutput.toString());
	}
	private static void showHtmlRooms(Map<String, String> inputs, LogData data)
	{
		String name = inputs.get("name");
		VisitorLog log = data.getLog();
		Set<String> rooms = new LinkedHashSet<String>();
		for (VisitorLogEntry entry : log.getLogs()) {
			Visitor visitor = entry.getVisitors().getVisitor(name);
			if (visitor != null) {
				rooms.add("" + visitor.getState().getCurrentPlace().getId());
			}
		}

		StringBuilder htmlOutput = new StringBuilder();
		htmlOutput.append("<html>").append(NewLine);
		htmlOutput.append("<body>").append(NewLine);
		htmlOutput.append("<table>").append(NewLine);
		htmlOutput.append("<tr>").append(NewLine);
		htmlOutput.append(FourSpaces).append("<th>Rooms</th>").append(NewLine);
		htmlOutput.append("</tr>").append(NewLine);
		
		for (String room:rooms)
		{
			if(Integer.parseInt(room) != -1)
			{
				htmlOutput.append("<tr>").append(NewLine);
				htmlOutput.append(FourSpaces).append("<td>");
				htmlOutput.append(room);
				htmlOutput.append("</td>").append(NewLine);
				htmlOutput.append("</tr>").append(NewLine);
			}
		}
		htmlOutput.append("</table> ").append(NewLine);
        htmlOutput.append("</body>").append(NewLine);
        htmlOutput.append("</html>").append(NewLine);
        Util.showOutput(htmlOutput.toString());
	}
	private static void showAllData(Map<String, String> inputs, LogData data) {
		AllVisitors visitors = data.getVisitors();
		Map<String, Visitor> employees = visitors.getEmployees();
		Map<String, Visitor> guests =  visitors.getGuests(); 
		boolean done = false;
		
		StringBuilder htmlOutput = new StringBuilder();
		htmlOutput.append("<html>").append(NewLine);
		htmlOutput.append("<body>").append(NewLine);
		htmlOutput.append("<table>").append(NewLine);
		htmlOutput.append("<tr>").append(NewLine);
		htmlOutput.append(FourSpaces).append("<th>Employee</th>").append(NewLine);
		htmlOutput.append(FourSpaces).append("<th>Guest</th>").append(NewLine);
		htmlOutput.append("</tr>").append(NewLine);
		
		Iterator<Visitor> eIter = employees.values().iterator();
		Iterator<Visitor> gIter = guests.values().iterator();
		
		while (!done) {
            htmlOutput.append("<tr>").append(NewLine);
            
            if (eIter.hasNext())
                htmlOutput.append(FourSpaces)
                          .append("<td>").append(eIter.next().getName())
                          .append("</td>").append(NewLine);
            if (gIter.hasNext())
                htmlOutput.append(FourSpaces)
                          .append("<td>").append(gIter.next().getName())
                          .append("</td>").append(NewLine);
            
            htmlOutput.append("</tr>").append(NewLine);
            
            done = !eIter.hasNext() && !gIter.hasNext(); 
		}
		
        htmlOutput.append("</table>").append(NewLine);
        htmlOutput.append("<table>").append(NewLine);
        htmlOutput.append("<tr>").append(NewLine);
        htmlOutput.append(FourSpaces).append("<th>Room Id</th>").append(NewLine);
        htmlOutput.append(FourSpaces).append("<th>Occupants</th>").append(NewLine);
        htmlOutput.append("</tr>").append(NewLine);

		AllRooms rooms = data.getRooms();
		Collection<Room> roomList = rooms.getRooms();

		for (Room room : roomList) {
			if (room.getId() == -1)
				continue;
			
            htmlOutput.append("<tr>").append(NewLine);
            htmlOutput.append(FourSpaces).append("<td>").append(room.getId()).append("</td>").append(NewLine);
            htmlOutput.append(FourSpaces).append("<td>");
            
            int i=0, size = room.getVisitors().size();
			for (Visitor v : room.getVisitors()) {
			    i++;
                htmlOutput.append(v.getName());

                if (i < size)
                    htmlOutput.append(",");
			}
			
            htmlOutput.append("</td>").append(NewLine);
            htmlOutput.append("</tr>").append(NewLine);
		}
        htmlOutput.append("</table> ").append(NewLine);
        htmlOutput.append("</body>").append(NewLine);
        htmlOutput.append("</html>").append(NewLine);
        Util.showOutput(htmlOutput.toString());
	}

	private static boolean validate(Map<String, String> inputs, LogData data) {
	    
	    if (!data.getToken().equals(inputs.get("token"))) {
            Util.showOutput("Invalid token");
	        System.exit(-1);
	    }
	    if (Util.isTrue(inputs.get("show")))
	    {
	    	if(Util.isTrue(inputs.get("showrooms")))
	    	{
	    		 Util.showOutput("Invalid ");
	 	        return false;
	    	}
	    }
	    if (Util.isTrue(inputs.get("showrooms")))
	    {
	    	if(Util.isTrue(inputs.get("show")))
	    	{
	    		 Util.showOutput("Invalid ");
	 	        return false;
	    	}
	    	if(inputs.get("type") !=null)
	    	{
	    		
	    		if(!"E".equals(inputs.get("type")) &&  !"G".equals(inputs.get("type")))
		    	{
		    		 Util.showOutput("Invalid ");
		 	        return false;
		    	}
	    	}
	    	else
	    	{
	    		 Util.showOutput("Invalid ");
		 	        return false;
	    	}
	    	if(inputs.get("name")== null)
	    	{
	    		 Util.showOutput("Invalid ");
		 	        return false;
	    	}
	    
	    }
	    if(inputs.get("file")==null)
	    {
	    	 Util.showOutput("Invalid ");
	 	        return false;
	    }
	    
	    
		return true;
	}
}
