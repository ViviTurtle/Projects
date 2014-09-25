import java.util.Date;
import  java.util.Scanner;
/*
 * Simulates an ATM Machine, which has the ability to check a cards expiration date,
 * and withdraw money from the card with limits on the withdrawal amount
 */
public class ATM {
	private long maxDay;
	private long maxTransaction;
	private long minCash;
	private long totalFunds;
	private String ATMname;
	/*
	 * Gets the ATM's name
	 * @returns the ATMname
	 */
	public String getATM()
	{
		return ATMname;
	}
	/*
	 * Constructs an ATM
	 * @param maxDay the amount per day a card holder is allowed to withdraw
	 * @param maxTransaction the amount a card holder is allowed to withdraw per transaction
	 * @param minCash the minimum cash required in the ATM to process transactions
	 * @param totalFunds the total amount of funds in the ATM
	 * @param ATMname the ATM's name
	 */
	public ATM(long maxDay, long maxTransaction, long minCash, long totalFunds, String ATMname)
	{
		this.maxDay = maxDay;
		this.maxTransaction =maxTransaction;
		this.minCash = minCash;
		this.totalFunds = totalFunds;
		this.ATMname = ATMname;
	}
	/*
	 * Simulates a card being inserted to the ATM which checks if the card
	 * is expired or of the ATM is out of order
	 * @param card the credit card that gets inserted
	 * @return false if card is expired or out of order else returns true
	 */
	public boolean cardInserted(CreditCard card)
	{
		if(checkExpiration(card.getExpiration()) == false)
		{
			System.out.println("This card is expired, your card has been returned to you");
			System.exit(-1);
			return false;
		
		} 
		if (totalFunds < minCash)
		{
			System.out.println("This ATM's money has been depleted, please use a different ATM");
			System.exit(-1);
			return false; 
		}
		return true;
	}
	/*
	 * Gets which accounts the user wants to withdraw from (savings or checkings)
	 * @param hasChecking if it has checking it'll display in the cmd line
	 * @param hasSaving if the user has a Savings account it will be displayed
	 * @param read A scanner collect the user's input
	 * @returns 1 if its checking or 2 if saving
	 */
	public int getAccount(boolean hasChecking, boolean hasSaving, Scanner read)
	{
	
		System.out.println("Password accepted.");
		if (hasChecking)
		{
			System.out.println("Press 1 for Checking");
		}
		if (hasSaving)
		{
			System.out.println("Press 2 for Saving");
		}
		int account = read.nextInt();
		return account;
	}
	/*
	 * Gets the user's withdrawal amount and checks it against the ATM's limits
	 * @param read A scanner to get the user's input
	 * @returns the withdrawal amount
	 */
	public long getWithdrawal(Scanner read)
	{
		boolean validationDay = false;
		boolean validationEach = false;
		boolean validationFunds = false;
		long withdrawalAmmount = -1;
		//A few checks to see if withdrawal amount exceeds any limits
		while (validationDay == false  || validationEach == false || validationFunds == false)
		{
			withdrawalAmmount = read.nextLong();
			//The user may exit the ATM terminal using -1
			if (withdrawalAmmount == -1)
			{
				System.exit(-1);
			}
			if (withdrawalAmmount > maxDay)
			{
				System.out.println("This amount exceeds the total amount of money you can withdraw per day, please enter a new ammount or -1 to quit");
				validationDay = false;
			} 
			else 
			{
				validationDay = true;
			}
			if (withdrawalAmmount > maxTransaction)
			{
				System.out.println("This amount exceeds the total amount of money you can withdraw per Transanction, please enter a new amount of -1 to quit");
				validationEach = false;
			}
			else 
			{
				validationEach = true;
			}
			if (withdrawalAmmount > totalFunds)
			{
				System.out.println("This ATM doesn't have enough funds to process your transaction, please enter a new amount or press -1 to quit");
				validationFunds = false;
			} 
			else 
			{
				validationFunds = true;
			}
			
		}
		return withdrawalAmmount;

	}

	/*
	 * Requests the user for his/her password
	 * @param read a scanner to get the user's input
	 * returns the user's input
	 */
	public String getPassword(Scanner read)
	{
		String answer=  read.next();
		return answer;
	}
	/*
	 * Tells the user the withdraw was successful and decrements today's limit
	 * @param the amount to decrement the today's limit for a transaction
	 */
	public void withdraw(long amount)
	{
		maxDay -= amount;
		totalFunds -= amount;
		System.out.println("Transanction sucess, if you have more transanction please enter the amount or quit");
	}
	/*
	 * Checks if a date is expired
	 * @param expiration the date to check if its expired
	 * returns false if expired else returns true
	 */
	private boolean checkExpiration(Date expiration)
	{
		Date today = new Date();
		if (expiration.compareTo(today) > 0)
		{
			return false;
		}
		return true;
	}
	
}