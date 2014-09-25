/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taylor
 */
public class Hw8aFinalTester {
   public static void main(String[] args)
   {
      StockPortfolio p = new StockPortfolio();
      p.buy("AAPL", 100, 12);
      p.buy("AAPL", 100, 9);
      p.buy("XRX", 200,1);
      System.out.println("Profit:  " + p.sell("AAPL", 150, 15));
      System.out.println("Expected:  600");
      System.out.println("Profit:  " + p.sell("XRX", 150, 11));
      System.out.println("Expected:  1500");
      p.buy("AAPL", 200, 25);
      p.buy("AAPL", 300, 30);
      p.buy("XRX", 200, 25);
      System.out.println("Profit:  " + p.sell("AAPL", 250, 20));
      System.out.println("Expected:  -450");
      System.out.println("Profit:  " + p.sell("AAPL", 250, 40));
      System.out.println("Expected:  2500");
      p.buy("AAPL", 100, 35);
      System.out.println("Profit:  " + p.sell("AAPL", 150, 40));
      System.out.println("Expected:  1000");
   }
}