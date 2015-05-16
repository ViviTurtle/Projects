import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	/*
	 * Swaps letters' case in a sentence. All non-letter characters should
	 * remain the same.
	 * 
	 * @param args[0] the file to swap the cases for
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		char[] string;
		while (scan.hasNextLine()) {
			string = scan.nextLine().toCharArray();
			for (int i = 0; i < string.length; i++) {
				if (Character.isUpperCase(string[i])) {
					string[i] = Character.toLowerCase(string[i]);
				} else if (Character.isLowerCase(string[i])) {
					string[i] = Character.toUpperCase(string[i]);
				}
			}
			System.out.println(string);
		}
		scan.close();
	}
}
