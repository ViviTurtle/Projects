public class Tester
{
   public static void main(String[] args)
   {
      Person richard = new Person();
      Person helene = new Person();
      Person paris = new Person();
      Person johanna = new Person();

      Person bernd = new Person(richard, helene);
      Person jutta = new Person(null, helene);
      Person margreth = new Person(paris, johanna);
      Person alexander = new Person(paris, johanna);
      Person cay = new Person(bernd, margreth);
      Person frank = new Person(bernd, margreth);

      System.out.println("1: " + bernd.isParent(frank));
      System.out.println("Expected: true");
      System.out.println("2: " + margreth.isParent(frank));
      System.out.println("Expected: true");
      System.out.println("3: " + helene.isParent(frank));
      System.out.println("Expected: false");
      System.out.println("4: " + cay.isParent(frank));
      System.out.println("Expected: false");
      System.out.println("5: " + frank.isParent(bernd));
      System.out.println("Expected: false");
      try
      {
         System.out.println("6: " + frank.isParent(richard));
      }
      catch (NullPointerException ex)
      {
         System.out.println("NullPointerException");                  
      }
      System.out.println("Expected: false");         

      System.out.println("7: " + richard.isGrandParent(frank));
      System.out.println("Expected: true");
      try
      {
         System.out.println("8: " + richard.isGrandParent(frank));
      }
      catch (NullPointerException ex)
      {
         System.out.println("NullPointerException");                  
      }
      System.out.println("Expected: true");         
      try
      {
         System.out.println("9: " + bernd.isGrandParent(frank));
      }
      catch (NullPointerException ex)
      {
         System.out.println("NullPointerException");                  
      }
      System.out.println("Expected: false");         

      System.out.println("10: " + cay.isSibling(frank));
      System.out.println("Expected: true");         
      System.out.println("11: " + bernd.isSibling(frank));
      System.out.println("Expected: false");         
      try
      {
         System.out.println("12: " + bernd.isSibling(jutta));
      }
      catch (NullPointerException ex)
      {
         System.out.println("NullPointerException");                  
      }
      System.out.println("Expected: false");         
   }
}