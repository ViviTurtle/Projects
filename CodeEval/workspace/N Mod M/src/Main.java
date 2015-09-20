import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *  Given two integers N and M, calculate N Mod M (without using any inbuilt modulus operator). 
 */
public class Main {
	/*
	 * Scans the file for the numbers to find the modulus for
	 * 
	 * @param args[0] the file to scan in
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0])).useDelimiter("[\\n\r,]+");
		while (scan.hasNextDouble()) {
			System.out.println(mod(scan.nextDouble(), scan.nextDouble()));
		}
		scan.close();
	}

	/*
	 * Finds the modulus of the two numbers
	 * 
	 * @param x the first number to be divided into
	 * 
	 * @param y the divisor
	 * 
	 * @returns the modulus of the two aka the remainder
	 */
	private static int mod(double x, double y) {
		double exact = x / y;
		return (int) Math.round((exact - Math.floor(exact)) * y);
	}
}
