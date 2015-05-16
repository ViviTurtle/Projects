import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * A number is a self-describing number when (assuming digit positions are labeled 0 to N-1),
 * the digit in each position is equal to the number of times that that digit appears in the
 * number. If your the curious, here's how 2020 is a self-describing number: Position '0' has
 *  value 2 and there is two 0 in the number. Position '1' has value 0 because there are not 1's
 * in the number. Position '2' has value 2 and there is two 2. And the position '3' has value 0
 *  and there are zero 3's. 
 */

public class Main {
	/*
	 * Scan a file for each line which contains an integer. Will be scanning
	 * that integer to check if its self-describing
	 * 
	 * @param args[0] the fil the scan for Prints 1 if its self-describing and 0
	 * if not.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextInt()) {
			System.out.println(selfDestructCheck(scan.next()));
		}
		scan.close();
	}

	/*
	 * Checks to see if an a number is self-describing
	 * 
	 * @param x the number in string form
	 * 
	 * @returns 1 if its self-describing or 0 if its not.
	 */
	private static int selfDestructCheck(String x) {
		int location;
		int count = 0;
		int[] numbers = new int[10];
		Scanner scanNumber1 = new Scanner(x).useDelimiter("");
		while (scanNumber1.hasNextInt()) {
			location = scanNumber1.nextInt();
			numbers[location]++;
		}
		scanNumber1.close();
		Scanner scanNumber2 = new Scanner(x).useDelimiter("");
		while (scanNumber2.hasNextInt()) {
			location = scanNumber2.nextInt();
			if (location != numbers[count]) {
				return 0;
			}
			count++;
		}
		scanNumber2.close();
		return 1;
	}

}
