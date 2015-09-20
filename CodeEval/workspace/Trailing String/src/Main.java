import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	/*
	 * Scans a file prints 1 or 0 depending on if the second String is trailing
	 * the first
	 * 
	 * @param args[0] the file to scan for
	 * 
	 * @Prints 0 if it doesnt trail
	 * 
	 * @Prints 1 if it does trail
	 */
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan1 = new Scanner(new File(args[0])).useDelimiter("[,\n\r]+");
		while (scan1.hasNext()) {
			System.out.println(isTrailing(scan1.next(), scan1.next()));
		}
	}

	/*
	 * Takes two strings and checks to see if one trails the other
	 * 
	 * @param original the String to check inside
	 * 
	 * @param trail the Sting to check in the original
	 * 
	 * @Returns 0 if it doesn't trail or 1 if it does
	 */
	private static int isTrailing(String original, String trail) {
		if (trail.length() > original.length()) {
			return 0;
		}
		if (original.substring(original.length() - trail.length())
				.equals(trail)) {
			return 1;
		}
		return 0;
	}
}
