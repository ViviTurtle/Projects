import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// You are given a string 'S' and a character 't'. Print out the position of the rightmost occurrence of 't' (case matters) in 'S' or -1 if there is none. The position to be printed out is zero based.
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String string;
		String character;
		Scanner stack = new Scanner(new File(args[0])).useDelimiter("[,\n\r]+"); // \\n
																					// and
																					// \r
																					// are
																					// carraige
																					// returns.
		while (stack.hasNext()) {
			string = stack.next();
			character = stack.next();
			System.out.println(string.lastIndexOf(character));
		}
		stack.close();
	}
}
