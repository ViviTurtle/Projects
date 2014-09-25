// This creates an array of Bank Accounts which can be added for interest, transfer, or get balances
import java.util.*;
public class Bank
{
    private BankAccount[] accounts;
    /*
     * This constructs the array of Bank Accounts
     * @param amount the amount of bank accounts wanting to add to the list
     * @param initialBalance the initialBalance for all the new accounts made
     */
    public Bank(int amount, double initialBalance)
    {
        accounts = new BankAccount[amount]; 
        for (int i = 0; i <= amount -1; i++)
        {
            accounts[i] = new BankAccount(initialBalance);
        }
    }

    /*
     * Gets the balance of a bank account in the list
     * @param index the index where the bank account is located
     * @return the balance
     */
    public double getBalance(int index)
    {
        if (index >= accounts.length)
        {
            return 0;
        }
        else
            return accounts[index].getBalance();
    }

    /*
     * This transfers money from one bank acount to another
     * @param fromIndex the index money is being withdrawn from
     * @param toIndex the index money is to be deposited to
     * @param amount the amount of money transferred
     */
    public void transfer(int fromIndex, int toIndex, double amount)
    {
        if (fromIndex < accounts.length || toIndex <  accounts.length)
        {
            accounts[fromIndex].withdraw(amount);
            accounts[toIndex].deposit(amount);
        }
    }

    /*
     * Adds interest to all the bank accounts
     * @param percent the amount of interest to be added to each account
     */
    public void addInterest(double percent)
    {
        double interest = percent/100; //divided by 100 to change percent to decimal form
        double amountAdded;
        for (BankAccount account : accounts)
        {
            amountAdded = account.getBalance()*interest;
            account.deposit(amountAdded);
        }
    }
}