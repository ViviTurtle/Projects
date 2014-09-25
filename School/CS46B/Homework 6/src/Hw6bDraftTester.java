public class Hw6bDraftTester {
   public static void main(String[] args)
   {
      Hw6b h = new Hw6b(10);
      h.guess(2);
      h.guess(8);
      h.guess(6);
      h.guess(4);
      h.guess(3);
      System.out.println("Guesses:  " + h.numberGuesses());
      System.out.println("Expected:  " + 5);
   }
}