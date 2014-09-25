import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class logread {
	private static ArrayList<Data> DataList = new ArrayList<Data>();
	private static String token = "", path = "";
	static boolean K = false, H = false, S = false, R = false, T = false,
			I = false, A = false, B = false, uniqueFlag = false;
	static int[][] timeBound = new int[2][2];
	static ArrayList<String> employeeNames = new ArrayList<String>();
	static ArrayList<String> guestNames = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException {

		int[][] timeBound = new int[2][2];
		if (args.length == 0) {
			System.out.println("invalid");
			System.exit(-1);
		}
		LinkedList<String> command = new LinkedList<String>(Arrays.asList(args));
		while (!command.isEmpty()) {
			String arg = command.removeFirst();
			boolean uFlag = false;
			switch (arg) {
			case "-K":
				K = true;
				try {
					token = command.removeFirst();
				} catch (NoSuchElementException e) {
					System.out.println("invalid");
					System.exit(-1);
				}
				break;
			case "-H":
				H = true;
				break;
			case "-S":
				S = true;
				uFlag = true;
				break;
			case "-R":
				R = true;
				uFlag = true;
				break;
			case "-T":
				T = true;
				uFlag = true;
				break;
			case "-I":
				I = true;
				uFlag = true;
				break;
			case "-A":
				A = true;
				try {
					if (!(command.removeFirst().equals("-L") && command.remove(
							1).equals("-U"))) {
						throw new NoSuchElementException();
					}
					timeBound[0][0] = Integer.parseInt(command.removeFirst());
					timeBound[0][1] = Integer.parseInt(command.removeFirst());
					if (timeBound[0][1] < timeBound[0][0]) {
						throw new NumberFormatException();
					}
				} catch (NoSuchElementException e) {
					System.out.println("invalid");
					System.exit(-1);
				} catch (NumberFormatException e) {
					System.out.println("invalid");
					System.exit(-1);
				}
				uFlag = true;
				break;
			case "-B":
				B = true;
				try {
					if (!(command.removeFirst().equals("-L")
							&& command.remove(1).equals("-U")
							&& command.remove(2).equals("-L") && command
							.remove(3).equals("-U"))) {
						throw new NoSuchElementException();
					}
					timeBound[0][0] = Integer.parseInt(command.removeFirst());
					timeBound[0][1] = Integer.parseInt(command.removeFirst());
					timeBound[1][0] = Integer.parseInt(command.removeFirst());
					timeBound[1][1] = Integer.parseInt(command.removeFirst());
					if ((timeBound[0][1] < timeBound[0][0])
							|| timeBound[1][1] < timeBound[1][0]) {
						throw new NumberFormatException();
					}
				} catch (NoSuchElementException e) {
					System.out.println("invalid");
					System.exit(-1);
				} catch (NumberFormatException e) {
					System.out.println("invalid");
					System.exit(-1);
				}
				uFlag = true;
				break;
			case "-E":
				try {
					employeeNames.add(command.removeFirst());
				} catch (NoSuchElementException e) {
					System.out.println("invalid");
					System.exit(-1);
				}
				break;
			case "-G":
				try {
					guestNames.add(command.removeFirst());
				} catch (NoSuchElementException e) {
					System.out.println("invalid");
					System.exit(-1);
				}
				break;
			default:
				if (path.isEmpty()) {
					path = arg;
				} else {
					System.out.println("invalid");
					System.exit(-1);
				}
			}
			if (uFlag && uniqueFlag) {
				System.out.println("invalid");
				System.exit(-1);
			} else if (uFlag) {
				uniqueFlag = true;
			}
		}
		if (!K || token.isEmpty()) {
			System.out.println("invalid");
			System.exit(-1);
		}
		// TODO: Verify authentication token
		if (path.isEmpty()) {
			System.out.println("invalid");
			System.exit(-1);
		}
		// TODO: Check path to make sure it's a valid path
		if (R && (employeeNames.isEmpty() && guestNames.isEmpty())) {
			System.out.println("invalid");
			System.exit(-1);
		}
		if (T && H) {
			System.out.println("invalid");
			System.exit(-1);
		}
		// TODO: Prints
		// Extra Note: Unsure if second lower/upperTimeBound pair for B needs to
		// be greater
		// than first lower/upperTimeBound pair
		execute();

		DataList.clear();
	}

	private static void execute() throws FileNotFoundException {
		setDataList();
		if (S) {
			s();
		} else if (R) {
			r();
		}
	}

	private static void r() {
		String answer = "";
		boolean isGuest = false;
		String name;
		if (employeeNames.isEmpty()) {
			name = guestNames.get(0);
			isGuest = true;
		} else
			name = employeeNames.get(0);
		for (int i = 1; i < DataList.size(); i++) {
			if (DataList.get(i).getName().equals(name)
					&& DataList.get(i).isGuest() == isGuest
					&& DataList.get(i).getRoom() != -1) {
				answer += DataList.get(i).getRoom() + ",";
			}
		}
		if (H == false && answer.length() > 0) {
			System.out.println(answer.substring(0, answer.length() - 1));
		} else {
			rH(answer);
		}
	}

	private static void rH(String answer) {
		Scanner scan = new Scanner(answer).useDelimiter(",");
		System.out.println("<html>");
		System.out.println("<body>");
		System.out.println("<table>");
		System.out.println("<tr>");
		System.out.println("  <th>Rooms</th>");
		while (scan.hasNextLong()) {
			System.out.println("</tr>");
			System.out.println("<tr>");
			System.out.print("  <td>");
			System.out.println(scan.nextLong() + "</td>");
		}
		System.out.println("</tr>");
		System.out.println("</table>");
		System.out.println("</body>");
		System.out.println("</html>");
		scan.close();
	}

	private static void s() {
		List<helper> answer = new ArrayList<helper>();
		List<String> guests = new ArrayList<String>();
		List<String> employees = new ArrayList<String>();

		for (int i = 0; i < DataList.size(); i++) {
			boolean added = false;
			if (DataList.get(i).getLeaveTime() == -1) {
				// checks if room is already in the answer else add it
				for (int j = 0; j < answer.size(); j++) {
					if (answer.get(j).getRoom() == DataList.get(i).getRoom()) {
						answer.get(j).add(DataList.get(i).getName());
						added = true;
					}
				}
				if (added == false) {
					helper temp = new helper(DataList.get(i).getRoom(),
							DataList.get(i).getName());
					answer.add(temp);
				}
				if (DataList.get(i).getLeaveTime() == -1) {
					if (DataList.get(i).isGuest()) {
						guests.add(DataList.get(i).getName());
					} else
						employees.add(DataList.get(i).getName());
				}
			}
		}
		answer = merge_helper(answer);
		guests = stringMerge(guests);
		employees = stringMerge(employees);
		if (H == false) {
			printString(employees);
			printString(guests);
			int j = 0;
			if (answer.get(0).getRoom() == -1) {
				j++;
			}
			while (j < answer.size()) {
				System.out.println(answer.get(j).toString());
				j++;
			}
		} else
			sH(employees, guests, answer);

	}

	private static void sH(List<String> employees, List<String> guests,
			List<helper> answer) {
		System.out.println("<html>");
		System.out.println("<body>");
		System.out.println("<table>");
		System.out.println("<tr>");
		System.out.println("  <th>Employee</th>");
		System.out.println("  <th>Guest</th>");
		System.out.println("</tr>");

		for (int i = 0; i < employees.size() || i < guests.size(); i++) {
			System.out.println("<tr>");
			System.out.print("  <td>");
			if (i < employees.size()) {
				System.out.println(employees.get(i) + "</td>");
			} else {
				System.out.println("</td>");
			}
			System.out.print("  <td>");
			if (i < employees.size()) {
				System.out.println(guests.get(i) + "</td>");
			} else {
				System.out.println(guests.get(i) + "</td>");
			}
			System.out.println("</tr>");
		}
		System.out.println("</table>");
		System.out.println("<table>");
		System.out.println("<tr>");
		System.out.println("  <th>Room ID</th>");
		System.out.println("  <th>Occupants</th>");
		System.out.println("</tr>");

		for (int i = 0; i < answer.size(); i++) {
			System.out.println("<tr>");
			System.out.print("  <td>");
			System.out.println(answer.get(i).getRoom() + "</td>");
			System.out.print("  <td>");
			System.out.println(answer.get(i).namesToString() + "</td>");
			System.out.println("</tr>");
		}
		System.out.println("</table>");
		System.out.println("</body>");
		System.out.println("</html>");
	}

	private static void printString(List<String> toPrint) {
		if (toPrint.size() > 0) {
			System.out.print(toPrint.get(0));
		}
		for (int i = 1; i < toPrint.size(); i++) {
			System.out.print("," + toPrint.get(i));
		}
		System.out.println();
	}

	static class helper {
		private ArrayList<String> names;
		private long room;

		protected helper(long room, String name) {
			this.room = room;
			names = new ArrayList<String>();
			names.add(name);

		}

		protected long getRoom() {
			return room;
		}

		protected void add(String name) {
			names.add(name);
		}

		private List<helper> merge_helper(List<helper> list) {
			if (list.size() <= 1) {
				return list;
			}
			List<helper> left = list.subList(0, list.size() / 2);
			List<helper> right = list.subList(list.size() / 2, list.size() - 1);
			left = merge_helper(left);
			right = merge_helper(right);
			return merge(left, right);

		}

		private List<helper> merge(List<helper> bottom, List<helper> top) {
			List<helper> list = new ArrayList<helper>();
			while (bottom.size() > 0 || top.size() > 0) {
				if (bottom.size() > 0 && top.size() > 0) {
					if (bottom.get(0).getRoom() < (top.get(0).getRoom())) {
						list.add(bottom.remove(0));
					} else {
						list.add(top.remove(0));
					}
				} else if (bottom.size() > 0) {
					list.add(bottom.remove(0));
				} else {
					list.add(top.remove(0));
				}
			}
			return list;
		}

		public String toString() {
			String answer = Long.toString(room);
			for (int i = 0; i < names.size(); i++) {
				answer += "," + names.get(i);
			}
			return answer;
		}

		public String namesToString() {
			String answer;
			if (names.size() == 0) {
				return "";
			} else {
				answer = names.get(0);
				for (int i = 1; i < names.size(); i++) {
					answer += "," + names.get(i);
				}
				return answer;
			}

		}

	}

	private static List<helper> merge_helper(List<helper> list) {
		if (list.size() <= 1) {
			return list;
		}
		int size = list.size() / 2;
		List<helper> right = list;
		List<helper> left = new ArrayList<helper>();
		for (int i = 0; i < size; i++) {
			left.add(right.remove(0));
		}
		left = merge_helper(left);
		right = merge_helper(right);
		return merge(left, right);

	}

	private static List<helper> merge(List<helper> left, List<helper> right) {
		List<helper> list = new ArrayList<helper>();
		while (left.size() > 0 || right.size() > 0) {
			if (left.size() > 0 && right.size() > 0) {
				if (left.get(0).getRoom() < (right.get(0).getRoom())) {
					list.add(left.remove(0));
				} else {
					list.add(right.remove(0));
				}
			} else if (left.size() > 0) {
				list.add(left.remove(0));
			} else {
				list.add(right.remove(0));
			}
		}
		return list;
	}

	private static List<String> stringMerge(List<String> list) {
		if (list.size() <= 1) {
			return list;
		}
		int size = list.size() / 2;
		List<String> right = list;
		List<String> left = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			left.add(right.remove(0));
		}
		left = stringMerge(left);
		right = stringMerge(right);
		return stringMerge_helper(left, right);

	}

	private static List<String> stringMerge_helper(List<String> left,
			List<String> right) {
		List<String> list = new ArrayList<String>();
		while (left.size() > 0 || right.size() > 0) {
			if (left.size() > 0 && right.size() > 0) {
				if ((left.get(0)).compareTo(right.get(0)) < 0) {

					list.add(left.remove(0));
				} else {
					list.add(right.remove(0));
				}
			} else if (left.size() > 0) {
				list.add(left.remove(0));
			} else {
				list.add(right.remove(0));
			}
		}
		return list;
	}

	private static void setDataList() throws FileNotFoundException {

		String tname;
		long troom;
		boolean tguest;
		long tarrival;
		long tleave;
		Scanner scan = new Scanner(parseLogFile()).useDelimiter("[\n\r_]");
		// Scanner scan = new Scanner(new File(path)).useDelimiter("[\n\r_]");
		while (scan.hasNext()) {
			tname = scan.next();
			if (!tname.isEmpty()) {
				troom = scan.nextLong();
				tguest = scan.nextBoolean();
				tarrival = scan.nextLong();
				tleave = scan.nextLong();
				Data insert = new Data(tname, troom, tguest, tarrival, tleave);
				DataList.add(insert);
			}
		}
		scan.close();
	}

	private static String parseLogFile() {
		String decyptedLogFile = "";

		String s = null;

		try {

			// Run decrypt ruby
			// using the Runtime exec method:
			Process p = Runtime.getRuntime().exec(
					"ruby ruby/Decrypt.rb " + token + " " + path);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			// BufferedReader stdError = new BufferedReader(new
			// InputStreamReader(
			// p.getErrorStream()));

			// read the output from the command
			while ((s = stdInput.readLine()) != null) {
				decyptedLogFile += s;
			}

			// read any errors from the attempted command
			// System.out.println("Here is the standard error of the command (if any):\n");
			// while ((s = stdError.readLine()) != null) {
			// System.out.println(s);
			// }
			//
		} catch (IOException e) {
			System.out.println("invalid");
			e.printStackTrace();
			System.exit(-1);
		}
		if (decyptedLogFile.equals("Fail:Authentication")) {
			System.out.println("security error");
			System.exit(-1);
		} else if (decyptedLogFile.isEmpty()) {
			return "";
		}
		return decyptedLogFile;
	}

}
