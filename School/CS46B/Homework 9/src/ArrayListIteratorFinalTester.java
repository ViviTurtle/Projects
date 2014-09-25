import java.util.NoSuchElementException;

public class ArrayListIteratorFinalTester {
   public static void main(String[] args)
   { 
      ArrayList names = new ArrayList();
      names.addLast("Tom");
      names.addLast("Jerry");
      
      ListIterator iter = names.listIterator();
	  
      System.out.println(iter.nextIndex());
      System.out.println("Expected: 0");
      System.out.println(iter.hasNext());
      System.out.println("Expected: true");
      System.out.println(iter.next());
      System.out.println("Expected: Tom"); 
      System.out.println(iter.hasNext());
      System.out.println("Expected: true");      
      System.out.println(iter.nextIndex());
      System.out.println("Expected: 1");
      iter.set("Harry");
      System.out.println(iter.next());
      System.out.println("Expected: Jerry"); 
      iter.add("Sally");
      System.out.println(iter.hasNext());
      System.out.println("Expected: false");
      System.out.println(iter.nextIndex());
      System.out.println("Expected: 3");
      iter = names.listIterator();
      iter.next();
      iter.next();
      iter.remove();
      iter = names.listIterator();
      System.out.println(iter.nextIndex());
      System.out.println("Expected: 0");
      System.out.println(iter.hasNext());
      System.out.println("Expected: true");
      System.out.println(iter.next());
      System.out.println("Expected: Harry"); 
      System.out.println(iter.hasNext());
      System.out.println("Expected: true");      
      System.out.println(iter.nextIndex());
      System.out.println("Expected: 1");      
      System.out.println(iter.next());
      System.out.println("Expected: Sally"); 
      System.out.println(iter.hasNext());
      System.out.println("Expected: false");
      System.out.println(iter.nextIndex());
      System.out.println("Expected: 2");
      try
      {
         iter.next();
      } catch (NoSuchElementException e)
      {
         System.out.println("NoSuchElementException thrown");
      }
      System.out.println("Expected:  NoSuchElementException thrown");      
   }
}