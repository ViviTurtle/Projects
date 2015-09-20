import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static String original;
	// List of positions in the string that cannot be changed.
	private static ArrayList<Integer> do_not_edit = new ArrayList<Integer>();

	/*
	 * Scans a file and for each line prints out the new first delimited word
	 * with the replacements to be done
	 * 
	 * @param args[0] the file to scan
	 * 
	 * @Prints a new string that was substituted with strings from the original
	 */
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan2;
		Scanner scan1 = new Scanner(new File(args[0]));
		while (scan1.hasNextLine()) {
			scan2 = new Scanner(scan1.nextLine()).useDelimiter("[;,]");
			original = scan2.next();
			do_not_edit.clear();
			while (scan2.hasNext()) {
				replace(scan2.next(), scan2.next());
			}
			scan2.close();
			System.out.println(original);
		}
		scan1.close();

	}

	/*
	 * Searched from left to right a certain string, and replaces with with
	 * another as long as it wasn't edited or added before
	 * 
	 * @param search the string to search for
	 * 
	 * @param replace the string to replace the search with
	 */
	private static void replace(String search, String replace) {
		int length = search.length();
		int difference;
		boolean skip;
		for (int i = 0; (i + length <= original.length()); i++) {
			skip = false;
			for (int l = i; l < i + length; l++) {
				if (do_not_edit.contains(l)) {
					skip = true;
				}

			}
			if (skip != true) {
				// Replacement code
				if (original.substring(i, i + length).equals(search)) {
					original = original.substring(0, i) + replace
							+ original.substring(i + length, original.length());
					// Adding the positions to the do not edit list
					if (length != replace.length()) {
						// in case of difference of letters need to add or
						// subtract to the list to account for them
						difference = length - replace.length();
						for (int k = 0; k < do_not_edit.size(); k++) {
							if (do_not_edit.get(k) >= i) {
								do_not_edit.set(k, do_not_edit.get(k)
										- difference);
							}
						}
					}
					for (int j = i; j < replace.length() + i; j++) {
						do_not_edit.add(j);
					}
					i += replace.length() - 1;
				}
			}
		}

	}
}
