public class Hw8cFinalTester {
   public static void main(String[] args)
   { 
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");
      names.addFirst("Harry");
      names.addFirst("Dick");
      names.addFirst("Bill");

      LinkedList names2 = names.unzip();
      ListIterator iter = names.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      System.out.println("Expected: Bill Harry Tom ");
      iter = names2.listIterator();
      while (iter.hasNext()) {
           System.out.print(iter.next() + " ");
       }
      System.out.println();
      System.out.println("Expected: Dick Romeo ");
      
      LinkedList names3 = names2.unzip();
      iter = names2.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      System.out.println("Expected: Dick ");
      iter = names3.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      System.out.println("Expected: Romeo ");
   }
   
}