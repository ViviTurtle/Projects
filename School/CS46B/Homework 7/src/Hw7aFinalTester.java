/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taylor
 */
public class Hw7aFinalTester {
   public static void main(String[] args)
   {
      StockHolding s = new StockHolding("AAPL");
      s.buy(100, 12);
      s.buy(100, 9);
      System.out.println("Profit:  " + s.sell(150, 15));
      System.out.println("Expected:  600");
      s.buy(200, 25);
      System.out.println("Profit:  " + s.sell(250, 20));
      System.out.println("Expected:  -450");
   }

}