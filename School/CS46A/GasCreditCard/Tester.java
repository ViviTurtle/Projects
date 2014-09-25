public class Tester
{
   public static void main(String[] args)
   {
      GasCreditCard card = new GasCreditCard();
      card.buyGas(20);
      System.out.println(card.getSavings());
      System.out.println("Expected: 0");
      card.resetMonth();
   }
}