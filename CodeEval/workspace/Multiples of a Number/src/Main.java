import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Given numbers x and n, where n is a power of 2, print out the smallest multiple of n which is greater than or equal to x. Do not use division or modulo operator. -CodeEval
 * @param args[0] the file to read from
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String string;
		Scanner line;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			string = scan.nextLine();
			line = new Scanner(string);
			line.useDelimiter(",");
			System.out.println(multiples(line.nextInt(), line.nextInt()));
			line.close();
		}
		scan.close();

	}

	/*
	 * Returns the lowest multiple of 'B' is greater then another number 'A'
	 * 
	 * @param ceiling the number the multiple needs to pass
	 * 
	 * @param multiple the multiples to check return the lowest multiple
	 */
	private static int multiples(int ceiling, int multiple) {
		int answer = 0;
		int count = 0;
		while (answer < ceiling) {
			answer = multiple * count;
			count++;
		}
		return answer;
	}
}
