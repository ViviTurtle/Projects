import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	/*
	 * Reads and adds the sum of a list of numbers
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int answer = 0;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextInt()) {
			answer += scan.nextInt();
		}
		scan.close();
		System.out.println(answer);
	}
}
