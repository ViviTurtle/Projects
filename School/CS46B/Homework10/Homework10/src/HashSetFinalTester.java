import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class HashSetFinalTester
{
   public static void main(String[] args)
   {
      HashSet h = new HashSet(10);
      h.add("first");
      h.add("second");
      h.add("third");
      h.add("fourth");
      h.add("fifth");
      System.out.println("Size:  " + h.size());
      System.out.println("Expected:  5");
      Iterator it = h.iterator();

      while(it.hasNext())
         System.out.println(it.next());

      it = h.iterator();
      Iterator it2 = h.iterator();
      
      it.next();
      it2.next();
      it.next();
      it2.remove();
      try
      {
         it2.remove();
      } catch (IllegalStateException ex)
      {
         System.out.println("IllegalStateException");
      }
      System.out.println("Expected:  IllegalStateException");
      
      it2.next();
      
      try
      {
         it.next();
      } catch (ConcurrentModificationException ex)
      {
         System.out.println("ConcurrentModificationException");
      }
      System.out.println("Expected:  ConcurrentModificationException");

      it = h.iterator();
      it.next();
      it.next();
      it.next();
      it.next();
      System.out.println(it.hasNext());
      System.out.println("Expected:  false");
      it2.next();
      it2.next();
      it2.next();
      System.out.println(it2.hasNext());
      System.out.println("Expected:  false");      

      it = h.iterator();
      h.add("sixth");
      try
      {
         it.next();
      } catch (ConcurrentModificationException ex)
      {
         System.out.println("ConcurrentModificationException");
      }
      System.out.println("Expected:  ConcurrentModificationException");
   

      it = h.iterator();
      it.next();
      h.remove("sixth");
      try
      {
         it.next();
      } catch (ConcurrentModificationException ex)
      {
         System.out.println("ConcurrentModificationException");
      }
      System.out.println("Expected:  ConcurrentModificationException");
   }

}