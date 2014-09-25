public class PersistentListDraftTester {
   public static void main(String[] args)
   {
      PersistentList emptyList = new PersistentList();
      
      ListIterator emptyIter = emptyList.listIterator();

      System.out.println(emptyIter.hasNext());
      System.out.println("Expected:  false");
      System.out.println(emptyIter.nextIndex() );
      System.out.println("Expected:  0");

      PersistentList a = new PersistentList("a", new PersistentList());
   }
   
}