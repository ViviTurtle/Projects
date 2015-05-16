import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	/*
	 * Capitalizes the first of each Word in a file
	 * 
	 * @param args[0] the file read the lines from
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		Scanner scan2;
		while (scan.hasNextLine()) {
			scan2 = new Scanner(scan.nextLine());
			System.out.print(capitalize(scan2.next()));
			while (scan2.hasNext()) {
				System.out.print(" ");
				System.out.print(capitalize(scan2.next()));
			}
			scan2.close();
			System.out.println("");
		}
		scan.close();
	}

	/*
	 * Given a word, capitalizes the first letter
	 * 
	 * @param string the word to capitalize the first letter
	 * 
	 * @return the word edited
	 */
	private static char[] capitalize(String string) {
		char[] word = string.toCharArray();
		word[0] = Character.toUpperCase(word[0]);
		return word;
	}
}
