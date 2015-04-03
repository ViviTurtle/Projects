Armstrong Numbers
--------------------

CodeEval: https://www.codeeval.com/open_challenges/82/

Challenge Description:

>An Armstrong number is an n-digit number that is equal to the sum of the n'th powers of its digits. Determine if the input numbers are Armstrong numbers.

Input sample:

Your program should accept as its first argument a path to a filename. Each line in this file has a positive integer. E.g.
Output sample:

>6

>153

>351

Print out True/False if the number is an Armstrong number or not. E.g.

>True

>True

>False

1) Scanned each digit and saved them as an int
2) Counted how many digits there
3) Took each individual digit and did a power to the answer  to step 2
4) Added all then numbers from step 3 together

Main.java
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * An Armstrong number is an n-digit number that is equal to the sum 
 * of the n'th powers of its digits. Determine if the input numbers 
 * are Armstrong numbers. 
 */
public class Main {

	/*
	 * Scans a file and checks to see if the number on each line is an Armstrong
	 * number
	 * 
	 * @param args[0] the file to scan
	 * 
	 * @Prints true if its an armstrong number or False if not
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String string;

		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			string = scan.nextLine();
			System.out.println(isArmstrong(string));
		}
	}

	/*
	 * Given a string, checks to see if its an amstrong number
	 * 
	 * @param string the number to check in string form
	 * 
	 * @returns True if it is or False if not.
	 */
	private static String isArmstrong(String string) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int size;
		int answer = 0;
		Scanner digit = new Scanner(string).useDelimiter("");
		while (digit.hasNextInt()) {
			numbers.add(digit.nextInt());
		}
		digit.close();
		size = numbers.size();
		while (!numbers.isEmpty()) {
			answer += Math.pow(numbers.remove(0), size);
		}
		if (answer == Integer.parseInt(string)) {
			return "True";
		} else
			return "False";
	}

}
```
