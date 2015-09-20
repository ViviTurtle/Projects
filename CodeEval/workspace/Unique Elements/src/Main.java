import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	/*
	 * You are given a sorted list of numbers with duplicates. Print out the
	 * sorted list with duplicates removed.
	 * 
	 * @param args[0] the file to get the list from
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Set<Integer> list = new LinkedHashSet<>();
		Scanner scanWords;
		String string;
		int remove;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			string = scan.nextLine();
			scanWords = new Scanner(string).useDelimiter(",");
			while (scanWords.hasNextInt()) {
				list.add(scanWords.nextInt());
			}
			scanWords.close();
			Iterator<Integer> it = list.iterator();
			remove = it.next();
			it.remove();
			System.out.print(remove);
			while (!list.isEmpty()) {
				remove = it.next();
				it.remove();
				System.out.print("," + remove);
			}
			System.out.println("");
		}
		scan.close();

	}
}
