public class Main {

	/*
	 * Prints the Multiplication table
	 */
	public static void main(String[] args) {
		String s;
		for (int i = 1; i < 13; i++) {
			System.out.print(i);
			for (int j = 2; j < 13; j++) {
				s = String.format("%4s", Integer.toString(j * i));
				System.out.print(s);
			}
			System.out.println("");
		}
	}
}
