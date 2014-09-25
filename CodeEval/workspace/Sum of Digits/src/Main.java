import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	/*
	 * Prints the sum the digits in a particular line from a file.
	 * 
	 * @param args[0] the file to be read from
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String numbers;
		int answer;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			answer = 0;
			numbers = scan.nextLine();
			for (int i = 0; i < numbers.length(); i++) {
				answer += Integer.parseInt(numbers.substring(i, i + 1));
			}
			System.out.println(answer);
		}
		scan.close();

	}
}
