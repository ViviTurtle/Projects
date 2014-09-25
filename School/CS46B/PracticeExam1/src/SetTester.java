import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTester
{
   public static void main(String[] args)
   {
      Set A = new HashSet();
      Set B = new TreeSet();

      A.add("puma");
      A.add("leopard");
      A.add("lynx");
      A.add("lion");
      A.add("tiger");

      B.add("tiger");
      B.add("cheetah");
      B.add("puma");

      Set cats =  SetUtil.union(A,B);
      System.out.println(cats);
      System.out.println("Expected: [cheetah, leopard, lion, lynx, puma, tiger]");

      System.out.println(A);
      System.out.println(B);
   }
}