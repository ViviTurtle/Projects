import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int answer;
	static ArrayList<Integer> numbers; // each digit of a number stored into an
										// ArrayList

	static int[] expressions; // A ternary sequence in which 0 = Nothing 1 =
								// Addition and 2 = Subtraction between numbers

	/*
	 * Scans a file, and for each Integer in each lines, solves how many ugly
	 * numbers are there
	 * 
	 * @param args[0] the file to scan for Prints the amount of ugly numbers
	 * each number has
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNext()) {
			answer = 0;
			countUglies(scan.next());
			System.out.println(answer);
		}
		scan.close();
	}

	/*
	 * Counts how many ugly numbers are there in one integer
	 * 
	 * @param x The number to count how many uglies exist in
	 */
	private static void countUglies(String x) {
		numbers = new ArrayList<Integer>();
		Scanner scan2 = new Scanner(x).useDelimiter(""); // no delimiter
		// Stores each digit into an arraylist
		while (scan2.hasNextInt()) {
			numbers.add(scan2.nextInt());
		}
		scan2.close();
		expressions = new int[numbers.size() - 1];
		// Starts the recursive class at zero
		if (isUgly(getNumber(0))) {
			answer++;
		}
		while (!isDone()) {
			changeExpressions(0);
			if (isUgly(getNumber(0))) {
				answer++;
			}
		}
	}

	/*
	 * Checks to see if a there are any other permutations to check for (A
	 * ternary sequence of all 2's being that it went through all the ones with
	 * 1's and 0's already)
	 * 
	 * @returns true if it went through all permutations of the ternary sequence
	 * (ends in 2222*)
	 * 
	 * @returns false if it hasn't went through all the permutations
	 */
	private static boolean isDone() {
		for (int i = 0; i < expressions.length; i++) {
			if (expressions[i] != 2) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Checks to see if a number is ugly (Divisible by a single digit prime or
	 * 0)
	 * 
	 * @param x the number to check to see if its ugly
	 * 
	 * @returns true if it is divisible by a single digit prime or is a zero
	 * 
	 * @returns false if it isn't divisible by a single digit prime or not a
	 * zero
	 */
	private static boolean isUgly(long x) {
		if (x == 0) {
			return true;
		}
		if (x % 2 == 0) {
			return true;
		}
		if (x % 3 == 0) {
			return true;
		}
		if (x % 5 == 0) {
			return true;
		}
		if (x % 7 == 0) {
			return true;
		}
		return false;
	}

	/*
	 * Takes the current set of numbers and expressions stored and either
	 * concatenates, adds, or subtracts each one
	 * 
	 * @param position the position to start grabbing the next set of numbers
	 * that concatenate with each other
	 * 
	 * @return the sum, difference, and permutations for this currrent set of
	 * numbers and expressions
	 */
	private static long getNumber(int position) {
		long temp;
		String Sanswer;
		// Concatenation initialization and loop via conversions between string
		// and long
		Sanswer = String.valueOf(numbers.get(position++));
		while ((position <= expressions.length)
				&& (expressions[position - 1] == 0)) {
			Sanswer += String.valueOf(numbers.get(position++));
		}

		temp = Long.valueOf(Sanswer);
		// If the current expression is a 1 or 2, then it needs to stop
		// concatenation and add or subtract the next set
		if ((position <= expressions.length)
				&& (expressions[position - 1] == 1)) {
			return temp + getNumber(position);
		} else if ((position <= expressions.length)
				&& (expressions[position - 1] == 2)) {
			return temp - getNumber(position);
		}
		return temp;
	}

	/*
	 * A recursive Ternary sequence which goes through all the different
	 * patterns of 0's, 1's and 2's
	 * 
	 * @param position the position to change (by default zero)
	 */
	private static void changeExpressions(int position) {
		if (expressions[position] == 2) {
			expressions[position] = 0;
			changeExpressions(++position);
		} else
			expressions[position]++;
	}

}
