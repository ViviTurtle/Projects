import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class HashSetDraftTester
{
   public static void main(String[] args)
   {
      HashSet h = new HashSet(10);
      h.add("first");
      h.add("second");
      h.add("third");
      Iterator it = h.iterator();

      while(it.hasNext())
         it.next();

      Iterator it2 = h.iterator();
      it = h.iterator();
      it2.next();
      it.next();
      it2.next();
      it.next();
      
      System.out.println("Made it past no exception cases");
      System.out.println("Expected:  Made it past no exception cases");
      h.add("fourth");
      
      try
      {
         it.next();
      } catch (ConcurrentModificationException ex)
      {
         System.out.println("ConcurrentModificationException");
      }
      System.out.println("Expected:  ConcurrentModificationException");

      it = h.iterator();
      h.remove("ninth");
      it.next();
      h.remove("second");
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