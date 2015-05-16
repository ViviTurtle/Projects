import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Write a program which finds the next-to-last word in a string. 
public class Main {

	/*
	 * Reads a file that contains a string in each line and prints the second to
	 * last word
	 * 
	 * @param args[0] the file to be read
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		Scanner scan2;
		String answer = "";
		String temp = "";
		while (scan.hasNextLine()) {
			scan2 = new Scanner(scan.nextLine());
			while (scan2.hasNext()) {
				answer = temp;
				temp = scan2.next();
			}
			scan2.close();
			System.out.println(answer);
		}
		scan.close();

	}
}
