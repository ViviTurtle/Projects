import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Operations {

	public static <T> Set<T> intersect(Set<T> a, Set<T> b) {
		Set<T> answer = new HashSet<T>();
		for (T x : a) {
			if (b.contains(x))
				answer.add(x);
		}
		return answer;
	}

	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> answer = new HashSet<T>();
		for (T x : a) {
			answer.add(x);
		}
		for (T y : b) {
			answer.add(y);
		}
		return answer;

	}

	public static <T> Set<T> diff(Set<T> a, Set<T> b) {
		Set<T> answer = new HashSet<T>();
		for (T x : b) {
			if (!a.contains(x))
				answer.add(x);
		}
		return answer;

	}

	public static <T> boolean subset(Set<T> a, Set<T> b) {
		for (T x : a) {
			if (!b.contains(x))
				return false;
		}
		return true;

	}

	public static <T> Set<T> filter(Set<T> a, Predicate<T> f) {
		Set<T> answer = new HashSet<T>();
		for (T x : a) {
			if (f.test(x)) {
				answer.add(x);
			}
		}
		return answer;
	}

	public static <T> Set<T> map(Set<T> a, UnaryOperator<T> f) {

		Set<T> answer = new HashSet<T>();
		for (T x : a) {
			answer.add(f.apply(x));
		}
		return answer;
	}

	public static <T> Set<T> clone(Set<T> a) {
		Set<T> answer = new HashSet<T>();
		for (T x: a)
		{
			answer.add(x);
		}
		return answer;
	}

	@SuppressWarnings("unchecked")
	public static <T> Set<Set<T>> power(Set<T> a) {
		Set<Set<T>> answer = new HashSet<Set<T>>();
		Set<T> tail = clone(a);
		if (a.size() == 0) {
			answer.add(new HashSet<T>());
			return answer;
		}
		Iterator<T> iter = a.iterator();
		Object head = iter.next();
		// removes first object
		tail.remove(head);
		Set<Set<T>> tailSubsets = power(tail);
		Set<Set<T>> headSubsets = new HashSet<Set<T>>();
		for (Set<T> x : tailSubsets) {
			Set<T> temp = clone(x);;
			temp.add((T) head);
			headSubsets.add(temp);
		}
		return union(tailSubsets, headSubsets);
		// Taken from Piazza
		// if (a is empty) return {{}}
		// head = first element of a
		// tail = a - {head}
		// tailSubsets = power(tail) // this is the recursion
		// headSubsets = result of adding head to each member of tailSubset
		// return headSubsets U tailSubsets
	}

	public static String unicode_map(int digit) {
		String answer = "";
		String[] digits = Integer.toString(digit).split("");
		Map<Integer, String> intMap = new HashMap<Integer, String>();
		intMap.put(0, "48");
		intMap.put(1, "49");
		intMap.put(2, "50");
		intMap.put(3, "51");
		intMap.put(4, "52");
		intMap.put(5, "53");
		intMap.put(6, "54");
		intMap.put(7, "55");
		intMap.put(8, "56");
		intMap.put(9, "57");
		answer = intMap.get(Integer.parseInt(digits[0]));
		for (int i = 1; i < digits.length; i ++)
		{
		
			answer += "-"+ intMap.get(Integer.parseInt(digits[i]));
		}
		return answer;
	}

}