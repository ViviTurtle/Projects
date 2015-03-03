import java.util.*;
public class Operations {

	public static <T> Set<T> intersect(Set<T> a ,Set<T> b)
	{
		Set<T> answer = new HashSet<T>();
		
		for (T x: a)
		{
			if (b.contains(x)) answer.add(x);
		}
		return answer;
	}
	public static <T> Set<T> union(Set<T> a ,Set<T> b)
	{
		Set<T> answer = new HashSet<T>();
		for (T x: a)
		{
			answer.add(x);
		}
		for (T y: b)
		{
			answer.add(y);
		}
		return answer;
		
	}
	public static <T> Set<T> diff(Set<T> a ,Set<T> b)
	{
		Set<T> answer = new HashSet<T>();
		for (T x: b)
		{
			if (!a.contains(x)) answer.add(x);
		}
		return answer;
		 
	}
	public static <T> boolean subset(Set<T> a,Set<T> b)
	{
		for (T x: a)
		{
			if (!b.contains(x)) return false;
		}
		return true;
		
		
	}
	
	 public static <T> Set<T> filter(Set<T> a, Predicate<T> f) {
		 Set<T> answer = new HashSet<T>();
		 for (T x: a)
		 {
			 if (f.apply(x)){
				 answer.add(x);
			 }
		 }
		 return answer;
	 }
		 
	   public static <T> Set<T> map(Set<T> a, UnaryOperator<T> f) {
		   
		   Set<T> answer = new HashSet<T>();
			 for (T x: a)
			 {
					 answer.add(f.apply(x));
			 }
			 return answer;
	   }
	   
	   @SuppressWarnings("unchecked")
	public static <T> Set<Set<T>> power(Set<T> a) {
		   Set<Set<T>> answer = new HashSet<Set<T>>();
		   Set<T> tail = new HashSet<T>();
		   if(a.size() == 0)
		   {
			   answer.add(new HashSet<T>());
			   return answer;
		   }
		   //copies tail to be same as Set A
		   for (T x: a)
		   {
			   tail.add(x);
		   }
		   Iterator<T> iter = a.iterator();
		   Object head = iter.next();
		   //removes first object
		   tail.remove(head);
		   Set<Set<T>> tailSubsets = power(tail);
		   Set<Set<T>> headSubsets = new HashSet<Set<T>>();
			   for (Set<T> x: tailSubsets)
			   {
				   x.add((T) head);
				   headSubsets.add(x);
			   }
		   return union(tailSubsets,headSubsets);
		   //Taken from Piazza
		   //if (a is empty) return {{}}
		   //head = first element of a
		   //tail = a - {head}
		   //tailSubsets = power(tail) // this is the recursion
		   //headSubsets = result of adding head to each member of tailSubset
		   //return headSubsets U tailSubsets
	   }
	
}
