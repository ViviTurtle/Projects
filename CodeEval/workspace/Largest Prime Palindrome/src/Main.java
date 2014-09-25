import java.util.ArrayList;

/*
 * Finds the largest Prime Palindrome under a certain number
 */
public class Main {

	private static final int max = 1000; // the max number used in CodeEval
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static ArrayList<Integer> palindromes = new ArrayList<Integer>();

	public static void main(String[] args) {
		find_primes(max);
		find_palindromes(primes);
		System.out
				.print(Integer.toString(palindromes.get(palindromes.size() - 1)));
	}

	/*
	 * Takes a list of numbers and checks to see if it is a palindrome
	 * 
	 * @primes the list of numbers to be checked (in this case it is primes)
	 */
	private static void find_palindromes(ArrayList<Integer> primes) {
		String string = "";
		for (int i = 0; i < primes.size(); i++) {
			string = Integer.toString(primes.get(i));
			if (is_palindrome(string)) {
				palindromes.add(primes.get(i));
			}
		}
	}

	/*
	 * Takes a string and checks to see if its a palindrome (e.g 11 121 131 595
	 * 5555)
	 * 
	 * @param string the string to be checked
	 * 
	 * @returns true if the string is a palindrome
	 */
	private static boolean is_palindrome(String string) {
		if (string.length() != 1 && string.length() != 0) {
			if (string.startsWith(string.substring(string.length() - 1))) {
				if (string.length() == 2) {
					return true;
				}
				return is_palindrome(string.substring(1, string.length() - 2));
			}
			return false;
		}
		return true;
	}

	/*
	 * finds all the primes under a certain number
	 * 
	 * @param x the max number to check for
	 */
	private static void find_primes(int x) {
		for (int i = 1; i <= x; i++) {
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
		for (int i = 1; i < primes.size(); i++) {
			if (x % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
}
