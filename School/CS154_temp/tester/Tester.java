import java.util.*;

public class Tester {
  
   public static void main(String args[]) {
      Set<Integer> a = new HashSet<Integer>();
      // a = first 20 multiples of 3
      for(int i = 0; i < 20; i++) a.add(i * 3);
  
      Set<Integer>  b = Operations.filter(a,(Integer x)->x%2==0);
      Set<Integer> c = Operations.map(b, (x)->2 * x);
      System.out.println("a = " + a);
      System.out.println("b = " + b);
      System.out.println("c = " + c);
   }
}

//a = [0, 33, 3, 36, 6, 39, 9, 42, 12, 45, 15, 48, 18, 51, 21, 54, 24, 57, 27, 30]
//b = [0, 48, 18, 36, 6, 54, 24, 42, 12, 30]
//c = [0, 96, 48, 36, 84, 72, 24, 12, 108, 60]