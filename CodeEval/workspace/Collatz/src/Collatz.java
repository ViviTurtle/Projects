// Determines the cycle of collatz such that collatz is given n :If n is even, divide by 2. If n is odd, multiply by 3 and add 1 until it termiantes to 1
import java.util.ArrayList;

public class Collatz {

	static int cycle_length = 1;
	static ArrayList<Long> cycle_table = new ArrayList<Long>() {
		{
			add((long) 1);
		}
	};

	/*
	 * Determine the maximum cycle length over all numbers between i and j
	 * 
	 * @param i the starting number
	 * 
	 * @param j the ending number
	 * 
	 * @return the largest cycle length
	 */
	public static int maximumCycle(int i, int j) {
		long max = 0;
		long temp1;
		if (i > j) {
			int temp2 = i;
			i = j;
			j = temp2;
		}
		for (int k = i; k <= j; k++) {
			temp1 = cycling(k);
			if (temp1 > max) {
				max = temp1;
			}
		}
		return (int) max;
	}

	/*
	 * Compute the length of the cycle starting from 1 - 1000000
	 * 
	 * @param the collatz cycle number to calculate the cycle for
	 * 
	 * @return the length of the collatz cycle
	 */
	public static int cycleLength(int n) {
		return (int) cycling(n);
	}

	private static long cycling(long n) {
		long answer = 0;

		while (n >= cycle_table.size() && cycle_table.size() <= 710000) {
			cycle_table.add(0L);
		}
		if (n < 710000) {
			answer = cycle_table.get((int) n - 1);
		}
		if (answer == 0) {
			if (n % 2 == 0) {
				answer = cycling(n / 2) + 1;
			} else {
				answer = cycling(n * 3 + 1) + 1;
			}
			if (n <= 710000) {
				cycle_table.set((int) n - 1, answer);
			}
		}
		return answer;
	}
}
