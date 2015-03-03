import java.util.*;

public class Tester {

	public static void main(String args[]) {
		System.out.println("Exercise 1");
		Set<Integer> b = new HashSet<Integer>();
		b.add(0);
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(5);
		b.add(6);
		b.add(7);
		b.add(8);
		b.add(9);
		b.add(10);
		Set<Integer> a = new HashSet<Integer>();
		a.add(0);
		a.add(2);
		a.add(4);
		a.add(6);
		a.add(8);
		a.add(10);
		Set<Integer> c = new HashSet<Integer>();
		c.add(1);
		c.add(3);
		c.add(5);
		c.add(7);
		c.add(9);
		c.add(11);
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);
		System.out.println("Intersect(A,B): "
				+ Operations.intersect(a, b).toString());
		System.out.println("Difference(A,B): "
				+ Operations.diff(a, b).toString());
		System.out.println("Union(A,C): " + Operations.union(a, c).toString());
		System.out.println("SubsetFalse(A,C): " + Operations.subset(a, c));
		System.out.println("SubsetTrue(A,B): " + Operations.subset(a, b));
		System.out.println("SubsetFalse2(B,A): " + Operations.subset(b, a));

		System.out.println("Exercise 2");
		Set<Integer> tempa = new HashSet<Integer>();
		// d = first 20 multiples of 3
		for (int i = 0; i < 20; i++) {
			tempa.add(i * 3);
		}
		//Taken from Exercises page
		Set<Integer> tempb = Operations
				.filter(tempa, (Integer x) -> x % 2 == 0);
		Set<Integer> tempc = Operations.map(tempb, (x) -> 2 * x);
		System.out.println("Total Set = " + tempa);
		System.out.println("Filter out Odds: = " + tempb);
		System.out.println("Multiple 3 on B = " + tempc);
		// a = [0, 33, 3, 36, 6, 39, 9, 42, 12, 45, 15, 48, 18, 51, 21, 54, 24, 57, 27, 30]
		// b = [0, 48, 18, 36, 6, 54, 24, 42, 12, 30]
		// c = [0, 96, 48, 36, 84, 72, 24, 12, 108, 60]
		
		
		//System.out.println("Exercise clone");
		//System.out.println("A: " + a);
		//Set<Integer> test = new HashSet<Integer>();
		//test = Operations.clone(a);
		//test.add(1231);
		//System.out.println("A + 12341: " + test);
		//System.out.println("A-Original: " + a);
		
		System.out.println("Exercise 3");
		Set<Integer> e = new HashSet<Integer>();
		e.add(0);
		System.out.println("E: " + e);
		System.out.println("PowerSet of E= " + Operations.power(e));
		e.add(1);
		System.out.println("E: " + e);
		System.out.println("PowerSet of E= " + Operations.power(e));
		e.add(2);
		System.out.println("E: " + e);
		System.out.println("PowerSet of E= " + Operations.power(e));
		
		System.out.println("Exercise 4");
		System.out.println("Unicode of 12345 " + Operations.unicode_map(12345));
	}

}
