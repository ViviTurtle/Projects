
/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount
{  
   private double balance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {   
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance)
   {   
      balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }

   /**
      Adds a given percentage to the balance of this account, using
      compound interest
      @param n how often to add the interest (e.g. 10 for ten times)
      @param percent the percentage to add, e.g. 5.5 to add 5.5%
   */
   public void addInterest(int n, double percent)
   {
      if (n > 0)
      {
         deposit(getBalance() * percent / 100);
         addInterest(n - 1, percent);
      }
   }
}
