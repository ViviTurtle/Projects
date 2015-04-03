Calculate Distance (**Solved**):
-------------------

 
https://www.codeeval.com/open_challenges/99/



**Challenge Description:**

>You have coordinates of 2 points and need to find the distance between them.

**Input sample:**

Your program should accept as its first argument a path to a filename. Input example is the following

> (25, 4) (1, -6)

> (47, 43) (-25, -11)

All numbers in input are integers between -100 and 100.

**Output sample:**

Print results in the following way.

> 26

> 90

You don't need to round the results you receive. They must be integer numbers. 

Main.java
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	/*
	 * Scans a file for two coordinate points and prints the distance between
	 * the two param args[0] the file to scan in
	 */
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan1 = new Scanner(new File(args[0]))
				.useDelimiter("[( \n \r,)]+");
		while (scan1.hasNextInt()) {
			System.out.println((int) findDistance(scan1.next(), scan1.next(),
					scan1.next(), scan1.next()));
		}
		scan1.close();
	}

	/*
	 * Takes 2 pairs of integers and finds the distance betewen the two
	 * 
	 * @param x1 the first integer of the first pair
	 * 
	 * @param y1 the second integer of the first pair
	 * 
	 * @param x2 the first integer of the second pair
	 * 
	 * @param y2 the second integer of the second pair
	 * 
	 * @returns the distance beteen these two coordinates
	 */
	private static double findDistance(String x1, String y1, String x2,
			String y2) {

		return Math.sqrt(Math.pow(Integer.valueOf(x2) - Integer.valueOf(x1), 2)
				+ Math.pow(Integer.valueOf(y2) - Integer.valueOf(y1), 2));
	}
}
```
