import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * You are given two sorted list of numbers (ascending order). The lists themselves are comma delimited and the two lists are semicolon delimited. Print out the intersection of these two sets.
 * @param args[0] the file to be read
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String string;
		String string1;
		String string2;
		Scanner scanNumber;
		int index;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Scanner scan = new Scanner(new File(args[0]));
		// Scans for each line
		while (scan.hasNextLine()) {
			string = scan.nextLine();
			index = string.indexOf(";");
			// splits each line into two substrings of which are split by a ';'
			string1 = string.substring(0, index);
			string2 = string.substring(index + 1, string.length());
			// scans each string into integer and adds it to an arrayList
			scanNumber = new Scanner(string1).useDelimiter(",");
			while (scanNumber.hasNextInt()) {
				list1.add(scanNumber.nextInt());
			}
			scanNumber.close();
			scanNumber = new Scanner(string2).useDelimiter(",");
			while (scanNumber.hasNextInt()) {
				list2.add(scanNumber.nextInt());
			}
			scanNumber.close();
			// compares the first of each list and deletes the smaller of the
			// two. If theyre equal theyre removed and added to a new list.
			while (!list1.isEmpty() && !list2.isEmpty()) {
				if (list1.get(0) == list2.get(0)) {
					answer.add(list1.remove(0));
					list2.remove(0);
				} else if (list1.get(0) > list2.get(0)) {
					list2.remove(0);
				} else
					list1.remove(0);
			}
			if (!answer.isEmpty()) {
				System.out.print(answer.remove(0));
			}
			while (!answer.isEmpty()) {
				System.out.print("," + answer.remove(0));
			}
			System.out.println();
			list1.clear();
			list2.clear();
		}
		scan.close();
	}
}
