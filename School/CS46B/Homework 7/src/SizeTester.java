/**
   A tester program for a revised version of the LinkedList class.
*/
public class SizeTester
{  
   public static void main(String[] args)
   { 
      LinkedList names = new LinkedList();
      names.addFirst("Peter");
      names.addFirst("Paul");
      names.addFirst("Mary");
      System.out.println(names.size1());
      System.out.println("Expected: 3");
      System.out.println(names.size2());
      System.out.println("Expected: 3");
      System.out.println(names.size3());
      System.out.println("Expected: 3");
   }
}