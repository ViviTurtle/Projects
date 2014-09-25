
public class Hw7aDraftTester {
    
   public static void main (String[] args)
   {
      StockHolding s = new StockHolding("AAPL");
      s.buy(100, 12);
      System.out.println("Profit:  " + s.sell(50, 15));
      System.out.println("Expected:  150");
      
      StockHolding s2 = new StockHolding("FFT");
      s2.buy(3000, 20);
      System.out.println("Profit:  " + s2.sell(3000, 10));
      System.out.println("Expected:  -30000");
   }
}
