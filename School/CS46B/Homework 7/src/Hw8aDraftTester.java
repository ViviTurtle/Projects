/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taylor
 */
public class Hw8aDraftTester {
      public static void main(String[] args)
   {
      StockPortfolio p = new StockPortfolio();
      p.buy("AAPL", 100, 12);
      p.buy("AAPL", 100, 9);
      System.out.println("Profit:  " + p.sell("AAPL", 150, 15));
      System.out.println("Expected:  600");
      p.buy("AAPL", 200, 25);
      System.out.println("Profit:  " + p.sell("AAPL", 250, 20));
      System.out.println("Expected:  -450");
   }

}