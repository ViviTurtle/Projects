public class PersistentListFinalTester {
   public static void main(String[] args)
   {
      PersistentList a = new PersistentList("a", new PersistentList());
      PersistentList b = new PersistentList("b", a);  //list b = b, a
      PersistentList c = new PersistentList("c", b);  //list c = c, b, a
      PersistentList d = new PersistentList("d", c);  //list d = d, c, b, a
      PersistentList e = new PersistentList("e", c);  //list e = e, c, b, a

      ListIterator aIter = a.listIterator();
      ListIterator bIter = b.listIterator();
      ListIterator cIter = c.listIterator();
      ListIterator dIter = d.listIterator();
      ListIterator eIter = e.listIterator();

      System.out.println(dIter.next());
      System.out.println("Expected:  d");
      System.out.println(eIter.next());
      System.out.println("Expected:  e");
      System.out.println(dIter.next());
      System.out.println("Expected:  c");
      System.out.println(eIter.next());
      System.out.println("Expected:  c");
      System.out.println(cIter.next());
      System.out.println("Expected:  c");
      System.out.println(cIter.nextIndex());
      System.out.println("Expected:  1");
      System.out.println(dIter.nextIndex());
      System.out.println("Expected:  2");
      System.out.println(eIter.nextIndex());
      System.out.println("Expected:  2");
      System.out.println(dIter.next());
      System.out.println("Expected:  b");
      System.out.println(eIter.next());
      System.out.println("Expected:  b");
      System.out.println(cIter.next());
      System.out.println("Expected:  b");
      System.out.println(bIter.next());
      System.out.println("Expected:  b");
      System.out.println(bIter.nextIndex());
      System.out.println("Expected:  1");
      System.out.println(cIter.nextIndex());
      System.out.println("Expected:  2");
      System.out.println(dIter.nextIndex());
      System.out.println("Expected:  3");
      System.out.println(eIter.nextIndex());
      System.out.println("Expected:  3");
      System.out.println(bIter.hasNext());
      System.out.println("Expected:  true");
      System.out.println(cIter.hasNext());
      System.out.println("Expected:  true");
      System.out.println(dIter.hasNext());
      System.out.println("Expected:  true");
      System.out.println(eIter.hasNext());
      System.out.println("Expected:  true");
      System.out.println(dIter.next());
      System.out.println("Expected:  a");
      System.out.println(eIter.next());
      System.out.println("Expected:  a");
      System.out.println(cIter.next());
      System.out.println("Expected:  a");
      System.out.println(bIter.next());
      System.out.println("Expected:  a");
      System.out.println(bIter.nextIndex());
      System.out.println("Expected:  2");
      System.out.println(cIter.nextIndex());
      System.out.println("Expected:  3");
      System.out.println(dIter.nextIndex());
      System.out.println("Expected:  4");
      System.out.println(eIter.nextIndex());
      System.out.println("Expected:  4");
      System.out.println(bIter.hasNext());
      System.out.println("Expected:  false");
      System.out.println(cIter.hasNext());
      System.out.println("Expected:  false");
      System.out.println(dIter.hasNext());
      System.out.println("Expected:  false");
      System.out.println(eIter.hasNext());
      System.out.println("Expected:  false");
   }
}