Fibonacci Series (**Solved**)
--------------------------------
https://www.codeeval.com/open_challenges/22/

**Challenge Description:**

>The Fibonacci series is defined as: F(0) = 0; F(1) = 1; F(n) = F(n–1) + F(n–2) when n>1. Given an integer n≥0, print out the F(n).

**Input sample:**

The first argument will be a path to a filename containing integer numbers, one per line. E.g.

>5

>12

**Output sample:**

Print to stdout, the fibonacci number, F(n). E.g.

>5

>144

Main.java (Solved using Phi's golden ratio)
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The Fibonacci series is defined as: F(0) = 0; F(1) = 1; F(n) = F(n-1) + F(n-2) when n>1. Given a positive integer 'n', print out the F(n). 
 */
public class Main {
	// Euler's Golden ratio PHI
	private static final double PHI = 1.618033988749895;

	public static void main(String[] args) throws FileNotFoundException {
		int number;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextInt()) {
			number = scan.nextInt();
			System.out.println(fib(number));
		}
		scan.close();
	}

	/*
	 * Finds the nth fibonacchi number ~ uses the golden ratio to calculate the
	 * fibonacchi number. fib(n) = (PHI^n)/sqrt(5) -
	 * http://www.goldennumber.net/fibonacci-series/
	 * 
	 * @param x the nth number to look for
	 * 
	 * @returns the nth fibonacchi number
	 */
	private static int fib(int x) {
		return (int) Math.round((Math.pow(PHI, (double) x) / Math.pow(5, 0.5)));
	}
}

// 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 ...
```
