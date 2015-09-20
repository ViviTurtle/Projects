import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Takes a file and prints each line with the words in reverse order
 */
public class Main {

	/*
	 * @param args[0] the file name to access
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanWord;
		String strings;
		ArrayList<String> scanned = new ArrayList<String>();
		Scanner scanLine = new Scanner(new File(args[0]));
		/*
		 * Scans for lines, then for each line it scans for words which are
		 * added to an ArrayList, then printed out in reverse Order
		 */
		while (scanLine.hasNextLine()) {
			strings = scanLine.nextLine();
			scanWord = new Scanner(strings);
			while (scanWord.hasNext()) {
				scanned.add(scanWord.next());
			}
			scanWord.close();
			for (int i = scanned.size() - 1; i > 0; i--) {
				System.out.print(scanned.get(i) + " ");
			}
			System.out.print(scanned.get(0));
			System.out.println("");
			scanned.clear();
		}
		scanLine.close();
	}
}
