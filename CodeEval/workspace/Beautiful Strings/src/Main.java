import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String string;
		Scanner scan2;
		char[] numbers;
		int last;
		ArrayList<Integer> answer = new ArrayList<Integer>() {
			{
				add(1);
			}
		};
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			string = scan.nextLine().toLowerCase();
			numbers = string.toCharArray();
			Arrays.sort(numbers);
			for (int i = 1; i < numbers.length; i++) {
				if (numbers[i] != numbers[i - 1]) {
					answer.add(1);
				}

				else {
					last = answer.get(answer.size() - 1);
					answer.set(answer.get(answer.size() - 1), last++);
				}
			}

		}
		scan.close();
	}
}
