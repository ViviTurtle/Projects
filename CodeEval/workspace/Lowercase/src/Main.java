import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String string;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			string = scan.nextLine();
			System.out.println(string.toLowerCase());
		}
	}
}
