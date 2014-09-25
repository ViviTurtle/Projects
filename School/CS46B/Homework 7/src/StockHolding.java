
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockHolding {

    public Queue<StockBlock> stocks;
    private String name;

    public StockHolding(String ticker) {
        name = ticker;
        stocks = new LinkedList<StockBlock>();
        StockPortfolio.portfolio.put(name ,this);
    }

   /**
      Handle a user buying a given quantity of stock at a given price.
   */
   public void buy(int quantity, int price)
   {
      stocks.add(new StockBlock(quantity, price));
   }

    /**
     * Handle a user selling a given quantity of stock at a given price.
     *
     * @return the profit from the sale
     */
   /**
      Handle a user selling a given quantity of stock at a given price.
      @return the profit from the sale
   */
   public int sell(int quantity, int price)
   {
      int profit = 0;
      while(!stocks.isEmpty() && stocks.peek().quantity < quantity)
      {
         StockBlock s = stocks.remove();
         quantity -= s.quantity;
         profit += (price - s.price) * s.quantity;
      }
      if(quantity > 0)
      {
         StockBlock s = stocks.peek();
         s.quantity -= quantity;
         profit += quantity * (price - s.price);
      }
      return profit;
   }

   private class StockBlock
   {
      public int quantity;
      public int price;
      
      public StockBlock(int q, int p)
      {
         quantity = q;
         price = p;
      }
   }
}
