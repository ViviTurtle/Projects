
import java.util.HashMap;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TODD
 */
public class StockPortfolio {

    public static Map<String, StockHolding> portfolio;

    public StockPortfolio() {
        portfolio = new HashMap<String, StockHolding>();
    }
        /**
     * Handle a user buying a given quantity of stock at a given price.
     */
    public void buy(String ticker, int quantity, int price) {
        if (portfolio.containsKey(ticker)) {
            portfolio.get(ticker).buy(quantity, price);
        }
        else {
            StockHolding temp = new StockHolding(ticker);
            temp.buy(quantity, price);
        }
                
    
    }
    
        public int sell(String ticker, int quantity, int price) {
        return portfolio.get(ticker).sell(quantity, price);
    }
    
}


