import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Calender {
	static int currentYear;
	static int currentMonth;
	static int currentDay;
	static List<Event> EventList = new ArrayList<Event>();

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner read = new Scanner(System.in);
		Calendar calendar = new GregorianCalendar();
		currentYear = calendar.get(Calendar.YEAR);
		currentMonth = calendar.get(Calendar.MONTH);
		currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		print_month_view(currentYear, currentMonth, currentDay);
		mainMenu(read);
	}

	protected static void mainMenu(Scanner read) throws FileNotFoundException, UnsupportedEncodingException {
		String next = "X";
		while (!next.equals("Q")) {
			System.out
					.println("[V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
			next = read.next();
			switch (next) {
			case "V":
				boolean pass = false;
				System.out.println("[D]ay view or [M]onth view?");
				while (pass == false) {
					next = read.next();
					if (next.equals("D")) {
						pass = true;
						viewByDay(read);
					} else if (next.equals("M")) {
						pass = true;
						viewByMonth(read);
					} else {
						System.out.println("Invalid Selection");
						System.out.println("[D]ay view or [M]onth view?");
					}
				}

				break;
			case "C":
				createEvent(read);
				break;
			case "G":
				System.out.println("Please enter a date (MM/DD/YYYY) (MM:0-11)");
				int[] dates = getValidDate(read);
				print_day_view(dates[0], dates[1], dates[2]);
				break;
			case "E":
				EventList = mergeSort(EventList);
				for (int i = 0; i < EventList.size(); i++) {
					System.out.print(EventList.get(i).printDate());
					System.out.print("  -");
					EventList.get(i).toStrings();
				}
				break;
			case "D":
				next = "X";
				System.out.println("Please select a option:");
				System.out.println("[S]elected: all the events on the selected date will be deleted");
				System.out.println("[A]ll: All the events will be deleted");
				next = read.next();
				while (!next.equals("S") && !next.equals("A"))
				{
				System.out.println("Invalid Option");
				System.out.println("Please select a option:");
				System.out.println("[S]elected: all the events on the selected date will be deleted");
				System.out.println("[A]ll: All the events will be deleted");
				next = read.next();
				}
				if (next.equals("S"))
				{
					System.out.println("Please enter a date");
					int[] dates2 = getValidDate(read);
					for (int i =0 ; i < EventList.size(); i++)
					{
						
						System.out.println();
						if (EventList.get(i).toCompare().equals(String.valueOf(dates2[0]) + String.valueOf(dates2[1]) + String.valueOf(dates2[2])))
						{
							EventList.remove(i);
						}
					}
				}
				
				else if (next.equals("A"))
				{
					EventList.clear();
				}
				break;
			case "Q":
				EventList = mergeSort(EventList);
				PrintWriter writer = new PrintWriter ("reservation.txt", "UTF-8");
				for (int i = 0 ; i < EventList.size();i++)
				{
					writer.println(EventList.get(i).printDate());
					writer.println(EventList.get(i).toString());
				}
				writer.close();
				read.close();
				
				
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}
	}

	public static List<Event> mergeSort(List<Event> list) {
		List<Event> left2 = new ArrayList<> (list.subList(0, list.size()));
		if (left2.size() <= 1) {
			return left2;
		}
		List<Event> left = left2.subList(0, left2.size() / 2);
		List<Event> right = left2.subList(left2.size() / 2, left2.size());
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}

	public static List<Event> merge(List<Event> left, List<Event> right) {
		List<Event> answer = new ArrayList<Event>();
		while (left.size() > 0 || right.size() > 0) {
			if (left.size() > 0 && right.size() > 0) {
				if (Integer.parseInt(left.get(0).toCompare()) <= Integer
						.parseInt(right.get(0).toCompare())) {
					answer.add(left.remove(0));
				} else {
					answer.add(right.remove(0));
				}
			} else if (left.size() > 0) {
				answer.add(left.remove(0));
			} else if (right.size() > 0) {
				answer.add(right.remove(0));
			}
		}
		return answer;
	}

	public static void createEvent(Scanner read) {
		System.out.println("Please enter a title (No Spaces)");
		String title = read.next();
		System.out.println("Please enter a date (MM/DD/YYYY) (MM:0-11)");
		int[] dates = getValidDate(read);
		System.out.println("Please enter a start time i.e (1:30, 13:30)");
		int startTime = getValidTime(read);
		int endTime = -1;
		while (endTime < startTime) {
			System.out.println("Please enter an end time i.e (1:30, 13:30)");
			endTime = getValidTime(read);
			if (endTime < startTime) {
				System.out.println("End time msut be after the Start Time");
			}
		}
		System.out.println("Event added");
		Event temp = null;
		for (int i = 0; i < EventList.size(); i++) {
			if ((String.valueOf(dates[0]) + String.valueOf(dates[1]) + String
					.valueOf(dates[2])).equals(EventList.get(i).toCompare())) {
				EventList.get(i).add(
						title + " " + String.valueOf(startTime) + " - "
								+ String.valueOf(endTime));
				temp = EventList.get(i);
			}
		}
		if (temp == null) {
			EventList.add(new Event(dates[0], dates[1], dates[2], title + " "
					+ String.valueOf(startTime) + " - "
					+ String.valueOf(endTime)));
		}
	}

	public static int getValidTime(Scanner read) {
		boolean valid = false;
		String[] times = null;
		while (valid == false) {
			String time = read.next();
			times = time.split(":");
			try {
				if (Integer.parseInt(times[0]) >= 0
						&& Integer.parseInt(times[0]) < 24) {
					if (Integer.parseInt(times[1]) >= 0
							&& Integer.parseInt(times[1]) < 60) {
						valid = true;
					} else {
						valid = false;
						System.out.println("Invalid Time please try again");
						System.out
								.println("Please a start time i.e (1:30, 13:30)");
					}
				} else {
					valid = false;
					System.out.println("Invalid Time please try again");
					System.out.println("Please a start time i.e (1:30, 13:30)");
				}
			} catch (Exception e) {
				valid = false;
				System.out.println("Invalid Time please try again");
				System.out.println("Please a start time i.e (1:30, 13:30)");
			}
		}
		return Integer.parseInt(times[0] + times[1]);

	}

	public static int[] getValidDate(Scanner read) {
		boolean valid = false;
		String dates = null;
		String[] datesArray = null;
		while (valid == false) {
			dates = read.next();
			try {
				datesArray = dates.split("/");
				GregorianCalendar calender = new GregorianCalendar(
						Integer.parseInt(datesArray[2]),
						Integer.parseInt(datesArray[0]),
						Integer.parseInt(datesArray[1]));
				calender.setLenient(false);
				valid = true;
				calender.getTime();
			} catch (Exception e) {
				System.out.println("Date is Invalid Please try again");
				System.out.println("Please enter a date (MM/DD/YYYY) (MM:0-11)");
				valid = false;
			}
		}
		int temp[] = { Integer.parseInt(datesArray[2]),
				Integer.parseInt(datesArray[0]),
				Integer.parseInt(datesArray[1]) };
		return temp;
	}

	public static void viewByDay(Scanner read) {
		int modifiedYear = currentYear;
		int modifiedMonth = currentMonth;
		int modifiedDay = currentDay;
		print_day_view(currentYear, currentMonth, currentDay);
		String next = "X";
		Calendar calendar;

		while (!next.equals("M")) {
			calendar = new GregorianCalendar(modifiedYear, modifiedMonth,
					modifiedDay);
			System.out.println("P]revious or [N]ext or [M]ain menu?");
			next = read.next();
			while (!(next.equals("P") || next.equals("N") || next.equals("M")))

			{
				System.out.println("Invalid command");
				System.out.println("P]revious or [N]ext or [M]ain menu?");
				next = read.next();
			}
			if (next.equals("N")) {
				if (modifiedDay == calendar
						.getActualMaximum(Calendar.DAY_OF_MONTH)) {

					if (modifiedMonth == 11) {
						modifiedYear++;
						modifiedMonth = 0;
					} else {
						modifiedMonth++;
					}
					modifiedDay = 1;
				} else {
					modifiedDay++;
				}
				print_day_view(modifiedYear, modifiedMonth, modifiedDay);
			}
			if (next.equals("P")) {

				if (modifiedDay == 1) {
					if (modifiedMonth == 0) {
						modifiedYear--;
						modifiedMonth = 11;
					} else {
						modifiedMonth--;
					}
					calendar = new GregorianCalendar(modifiedYear,
							modifiedMonth, 1);
					modifiedDay = calendar
							.getActualMaximum(Calendar.DAY_OF_MONTH);
				} else {
					modifiedDay--;
				}
				print_day_view(modifiedYear, modifiedMonth, modifiedDay);
			}
		}
	}

	public static void print_day_view(int year, int month, int day) {
		Event temp = null;
		Calendar calendar = new GregorianCalendar(year, month, day);
		System.out.println(calendar.getDisplayName(Calendar.MONTH,
				Calendar.LONG, Locale.US)
				+ " "
				+ String.valueOf(day)
				+ ", "
				+ String.valueOf(year));
		for (int i = 0; i < EventList.size(); i++) {
			String toCompare = String.valueOf(year) + String.valueOf(month)
					+ String.valueOf(day);
			if (toCompare.equals(EventList.get(i).toCompare())) {
				temp = EventList.get(i);
			}
			if (temp != null) {
				temp.toStrings();
			} else {
				System.out.println("No Events on this day");

			}

		}

	}

	public static void viewByMonth(Scanner read) {

		int modifiedYear = currentYear;
		int modifiedMonth = currentMonth;
		int modifiedDay = currentDay;
		print_month_view(modifiedYear, modifiedMonth, modifiedDay);
		String next = "X";
		while (!next.equals("M")) {
			System.out.println("[P]revious or [N]ext or [M]ain menu?");
			next = read.next();
			while (!(next.equals("P") || next.equals("N") || next.equals("M")))

			{
				System.out.println("Invalid command");
				System.out.println("[P]revious or [N]ext or [M]ain menu?");
				next = read.next();
			}
			if (next.equals("N")) {
				if (modifiedMonth == 11) {
					modifiedYear++;
					modifiedMonth = 0;
				} else {
					modifiedMonth++;
				}
				print_month_view(modifiedYear, modifiedMonth, modifiedDay);
			}
			if (next.equals("P")) {
				if (modifiedMonth == 0) {
					modifiedYear--;
					modifiedMonth = 11;
				} else {
					modifiedMonth--;
				}
				print_month_view(modifiedYear, modifiedMonth, modifiedDay);
			}
		}
	}


	public static void print_month_view(int year, int month, int dayOfMonth) {
		int currentWeekDay;
		boolean current = false;
		Calendar calendar = new GregorianCalendar(year, month, 1);
		calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(" "
				+ calendar.getDisplayName(Calendar.MONTH, Calendar.LONG,
						Locale.US) + " " + year);
		System.out.println("Su Mo Tu We Th Fr Sa");
		int startWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 0; i < startWeek; i++) {
			System.out.print("   ");
		}
		currentWeekDay = startWeek;
		for (int i = 1; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			current = false;
			if (currentYear == year && currentMonth == month
					&& (currentDay == i || currentDay - 1 == i)) {
				current = true;
				if (i == (dayOfMonth - 1)) {
					if (currentWeekDay == 7) {
						currentWeekDay = 0;
						System.out.println();
						if (i > 9)
							System.out.print(i + "[");
						else
							System.out.print(" " + i + "[");
					} else {
						if (i > 9)
							System.out.print(i + "[");
						else
							System.out.print(" " + i + "[");
					}
				} else if (i == (dayOfMonth)) {
					if (currentWeekDay == 7) {
						currentWeekDay = 0;
						System.out.println();
						if (i > 9)
							System.out.print(i + "]");
						else
							System.out.print(" " + i + "]");
					} else {
						if (i > 9)
							System.out.print(i + "]");
						else
							System.out.print(" " + i + "]");
					}
				}
			}
			if (current == false) {
				if (currentWeekDay == 7) {
					currentWeekDay = 0;
					System.out.println();
					if (i > 9)
						System.out.print(i + " ");
					else
						System.out.print(" " + i + " ");
				} else {
					if (i > 9)
						System.out.print(i + " ");
					else
						System.out.print(" " + i + " ");
				}
			}
			currentWeekDay++;
		}
		System.out.println();

	}
}
