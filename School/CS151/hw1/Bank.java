import java.util.ArrayList;
/*
 * Simulates a Bank which holds all Account information and validates pins.
 */
public class Bank {
	ArrayList<Account> accountList = new ArrayList<Account>();
	/*
	 * Authorizes a card holder using the password they gave
	 * @param account the account to check the password for
	 * @param password the password to use against the account
	 * @returns true if authorized or false if invalid
	 */
	protected boolean authorizeSession(Account account, String password)
	{
		if (account.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	/*
	 * Adds an account to the Bank's records
	 * @param cardNum the card Number it is related to
	 * @param password the password to access the account
	 * @param checkingBalance the balance for checking account
	 * @param savingsBalance the balance for savings account
	 */
	protected void addAccount(long cardNum, String password, long checkingBalance, long savingsBalance )
	{
		accountList.add(new Account(cardNum, password,  checkingBalance,  savingsBalance ));
	}
	/*
	 * Finds the index of the Account from the Bank's records
	 * @param cardNum the cardNum to search for in the account
	 * @returns the index of the Account
	 */
	protected int getAccount(long cardNum)
	{
		for (int i = 0; i< accountList.size(); i++)
		{
			if(accountList.get(i).getCardNum() == cardNum)
			{
				return i;
			}
		}
		System.out.println("Account doesn't exist");
		return -1;
	}
	/*
	 * Withdraws from an account
	 * @param accountIndex the location the account in the banks records
	 * @param withdrawal the amount of money to withdraw
	 * @param account the checking to savings account to withdraw from
	 */
	protected void withdraw(int accountIndex, long withdrawal, int account)
	{
		
		if (account == 1)
		{
			long checking = accountList.get(accountIndex).getChecking();
			accountList.get(accountIndex).setChecking(checking-withdrawal);
		}
		if (account == 2)
		{
			long checking = accountList.get(accountIndex).getSavings();
			accountList.get(accountIndex).setSavings(checking-withdrawal);
		}
	}
	/*
	 * Checks to see if a withdrawal amount exceeds an Account's balance.
	 * @param accountIndex the location the account in the banks records
	 * @param withdrawal the amount of money to check if exceeds balance
	 * @param account the checking to savings account to withdraw from
	 * @returns true if there is enough money on that person's account else false
	 */
	protected boolean checkWithdrawal(int accountIndex, long withdrawal, int account)
	{
		if (account == 1)
		{
			if (accountList.get(accountIndex).getChecking() >= withdrawal)
			{
				return true;
			}
		}
		if (account == 2)
		{
			if (accountList.get(accountIndex).getSavings() >= withdrawal)
			{
				return true;
			}
		}
		return false;
	}
	
}