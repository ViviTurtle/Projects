
public class Hw6bTester {
   public static void main(String[] args)
   {
      Hw6b h = new Hw6b(10);
      boolean result = h.guess(2) > 0;
      System.out.println("Received:  " + result);
      System.out.println("Expected:  " + true);
      result = h.guess(8) < 0;
      System.out.println("Received:  " + result);
      System.out.println("Expected:  " + true);
      result = h.guess(6) < 0;
      System.out.println("Received:  " + result);
      System.out.println("Expected:  " + true);
      result = h.guess(4) < 0;
      System.out.println("Received:  " + result);
      System.out.println("Expected:  " + true);
      result = h.guess(3) == 0;
      System.out.println("Received:  " + result);
      System.out.println("Expected:  " + true);
      System.out.println("Guesses:  " + h.numberGuesses());
      System.out.println("Expected:  " + 5);

   }
   
}
