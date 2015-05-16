import java.util.ArrayList;

/*
 * Finds the sum of all the prime numbers under a certain number
 */
public class Main {
	private static final int max = 2000000000;
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		int answer = 0;
		find_primes(max);
		for (int i = 0; i < primes.size(); i++) {
			primes.get(i);
		}
		//System.out.print(answer);
		System.out.println(" " + primes.size());
	}

	/*
	 * finds all the primes until a certain amount of primes numbers are found
	 * (1 is not a prime number)
	 * 
	 * @param x the max numbers of primnumbers to look for
	 */
	private static void find_primes(int x) {
		for (int i = 2; primes.size() < x; i++) {
			if (is_prime(i)) {
				primes.add(i);
			}
		}
	}

	/*
	 * Checks to see if a number is prime by seeing if its divisable by any
	 * prime number underneath it
	 * 
	 * @param x the number to check for
	 * 
	 * @returns true if it is prime
	 */
	private static boolean is_prime(int x) {
		for (int i = 0; i < primes.size(); i++) {
			if (x % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
}
