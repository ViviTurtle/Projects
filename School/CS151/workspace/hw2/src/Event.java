import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Event {
		int year;
		int month;
		int day;
		ArrayList<String> details = new ArrayList<String>();

		public Event(int year, int month, int day, String details) {
			this.year = year;
			this.month = month;
			this.day = day;
			add(details);
		}

		public String toCompare() {
			return String.valueOf(year) + String.valueOf(month)
					+ String.valueOf(day);
		}

		public void add(String details) {
			this.details.add(details);
		}

		public void toStrings() {
			for (int i = 0; i < details.size(); i++) {
				System.out.println(details.get(i));
			}
		}
		public String toString() {
			String answer = "";
			for (int i = 0; i < details.size(); i++) {
				answer += details.get(i);
				answer += "\n";
			}
			return answer;
		}

		public String printDate() {
			Calendar calendar = new GregorianCalendar(year, month, day);
			return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG,
					Locale.US)
					+ " "
					+ String.valueOf(day)
					+ ", "
					+ String.valueOf(year);
		}

	}

