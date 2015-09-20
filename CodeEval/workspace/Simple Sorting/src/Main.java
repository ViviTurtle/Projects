import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/*
	 * Reads from a file that contains numbers and sorts them
	 * 
	 * @param args[0] the file to be read from
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan2;
		ArrayList<Double> numbers;
		ArrayList<Double> answer;
		Scanner scan = new Scanner(new File(args[0]));
		while (scan.hasNextLine()) {
			numbers = new ArrayList<Double>();
			scan2 = new Scanner(scan.nextLine());
			while (scan2.hasNextDouble()) {
				numbers.add(scan2.nextDouble());
			}
			scan2.close();
			answer = mergeSort(numbers);
			System.out.print(String.format("%.3f", answer.remove(0)));
			while (!answer.isEmpty()) {
				System.out.print(" " + String.format("%.3f", answer.remove(0)));
			}
			System.out.println("");
		}
		scan.close();
	}

	/*
	 * Sorts an arraylist of doubles via Mergesort
	 * 
	 * @param set2 the arraylist to sort
	 * 
	 * @returns the sorrted arraylist
	 */
	private static ArrayList<Double> mergeSort(ArrayList<Double> set2) {
		ArrayList<Double> set3 = new ArrayList<Double>();
		ArrayList<Double> set1 = new ArrayList<Double>();
		if (set2.size() == 1) {
			return set2;
		}
		int iterations = set2.size() / 2;
		for (int i = 0; i < iterations; i++) {
			set1.add(set2.remove(0));
		}
		set1 = mergeSort(set1);
		set2 = mergeSort(set2);
		while ((!set2.isEmpty()) && (!set1.isEmpty())) {
			if (compareTo(set1.get(0), set2.get(0)) >= 0) {
				set3.add(set2.remove(0));
			} else
				set3.add(set1.remove(0));
		}
		while (!set1.isEmpty()) {
			set3.add(set1.remove(0));
		}

		while (!set2.isEmpty()) {
			set3.add(set2.remove(0));
		}
		return set3;
	}

	/*
	 * Compares two doubles
	 * 
	 * @param x the first double
	 * 
	 * @param y the second double
	 * 
	 * @returns 1 if the first is bigger, or -1 is smaller and 0 if equal
	 */
	private static int compareTo(double x, double y) {
		if (x > y) {
			return 1;
		} else if (x < y) {
			return -1;
		}
		return 0;
	}
}
