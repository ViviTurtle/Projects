/**
   A tester program for a revised version of the LinkedList class.
*/
public class Hw8bDraftTester
{  
   public static void main(String[] args)
   { 
      LinkedList names = new LinkedList();
      names.addFirst("Peter");
      names.addFirst("Paul");
      names.addFirst("Mary");
      System.out.println(names.size1());
      System.out.println("Expected: 3");
      System.out.println(names.size2() * 0);
      System.out.println("Expected: 0");
      System.out.println(names.size3() * 0);
      System.out.println("Expected: 0");
   }
}