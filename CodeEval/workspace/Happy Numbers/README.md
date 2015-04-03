Happy Numbers (Solved)
------------------------
https://www.codeeval.com/open_challenges/39/

**Challenge Description:**

>A happy number is defined by the following process. Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers, while those that do not end in 1 are unhappy numbers.

**Input sample:**

The first argument is the pathname to a file which contains test data, one test case per line. Each line contains a positive integer. E.g.

  1
  
  7
  
  22

Output sample:

If the number is a happy number, print out 1. If not, print out 0. E.g

  1
  
  1
  
  0

For the curious, here's why 7 is a happy number: 7->49->97->130->10->1. Here's why 22 is NOT a happy number: 22->8->64->52->29->85->89->145->42->20->4->16->37->58->89 ... 

Main.java
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * A happy number is defined by the following process. Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits, and repeat the process until
 *  the number equals 1 (where it will stay), or it loops endlessly in a cycle which does 
 *  not include 1. Those numbers for which this process ends in 1 are happy numbers, while
 * those that do not end in 1 are unhappy numbers. 
 */

public class Main {

	static ArrayList<Integer> numbers = new ArrayList<Integer>() {
		{
			add(0);
			add(1);
		}
	};

	static int counter = 0;

	/*
	 * Scans a file for each line in which it will solve if the number is happy
	 * or not happy being that it will eventually reach 1 using the happy
	 * pattern
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextInt()) {
			System.out.println(is_happy(scan.nextInt()));
			counter = 0;
		}
		scan.close();
	}

	/*
	 * Checks to see if a number is happy
	 * 
	 * @param x the number to check
	 * 
	 * @returns 0 if its not happy or 1 if it is
	 */
	private static int is_happy(int x) {
		// base case
		if (x == 1) {
			return 1;
		}
		// loops until 10 iterations
		if (counter > 10) {
			counter = 0;
			return 0;
		}
		counter++;
		// initializes the arrayList with -1
		while (x > numbers.size() - 1) {
			numbers.add(-1);
		}
		if (numbers.get(x) == -1) {
			numbers.set(x, is_happy(sumOfDigits(x)));
		}
		return numbers.get(x);
	}

	/*
	 * Finds the sum of the square of a number's individual digits
	 * 
	 * @param x the number to check
	 * 
	 * @returns the sum of the square of the numbers digits
	 */
	private static int sumOfDigits(int x) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int answer = 0;
		Scanner sumScan = new Scanner(Integer.toString(x)).useDelimiter("");
		while (sumScan.hasNext()) {
			digits.add(sumScan.nextInt());
		}
		sumScan.close();
		for (int i = 0; i < digits.size(); i++) {
			answer += Math.pow(digits.get(i), 2);
		}
		return answer;
	}
}
```
