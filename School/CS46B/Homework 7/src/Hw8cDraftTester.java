public class Hw8cDraftTester {
   public static void main(String[] args)
   { 
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");

      LinkedList names2 = names.unzip();
      ListIterator iter = names.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      System.out.println("Expected: Romeo ");
      iter = names2.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      System.out.println("Expected: Tom ");
   }

}