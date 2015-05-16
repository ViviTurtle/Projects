import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Prints a sequence of numbers until 'N' which prints "F" if its divisible by int 'A' and prints "B" if divisible by int 'B' and "FB" if divisible by both.
 */
public class Main {

	/*
	 * Prints the Fizz Buzz sequence until N
	 * 
	 * @param args[0] first number to check if it divides into a number.
	 * 
	 * @param args[1] second number to check if it divides into a number.
	 * 
	 * @param args[2] the max from 1-max to keep printing the sequence for.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		Scanner scan2;
		String string;
		int div1;
		int div2;
		int max;
		while (scan.hasNextLine()) {
			string = scan.nextLine();
			scan2 = new Scanner(string);
			while (scan2.hasNextInt()) {
				div1 = scan2.nextInt();
				div2 = scan2.nextInt();
				max = scan2.nextInt();
				String answer = "";
				for (int i = 1; i <= max; i++) {
					if (i % div1 == 0) {
						if (i % div2 == 0) {
							answer = answer + " FB";
						} else
							answer = answer + " F";
					} else if (i % div2 == 0) {
						answer = answer + " B";
					} else
						answer = answer + " " + Integer.toString(i);
				}
				System.out.println(answer.substring(1, answer.length()));
				answer = "";
			}
			scan2.close();
		}
		scan.close();

	}
}
