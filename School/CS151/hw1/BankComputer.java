import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/*
 * Simulate a Bank computer which uses ATMs to process transactions and a list of credit cards
 * It is also connected to only one bank
 */
	public class BankComputer extends Bank{
	ArrayList<ATM> atmList;
	ArrayList<CreditCard> cardList;
	String BankID;
	String[] errors = new String[5];
	
	/*
	 * Constructs a BankComputer with errors and an ATM/Card records
	 * @param bank the Bank's name that is it connected too
	 */
	public BankComputer(String bank)
	{
		errors[0] = "Invalid Card Number, your card has been returned to you";
		errors[1] = "This card is not supported by this ATM, your card has been returned to you";
		errors[2] =  "This is the wrong password, please try again" ;
		errors[3] = "Invalid Password, Please call your bank for assistance. Your card will be kept.";
		errors[4] = "This amount exceeds your current balance. Please try again or enter -1 to quit";				
		BankID = bank;
		atmList = new ArrayList<ATM>();
		cardList = new ArrayList<CreditCard>();
	}
	/*
	 * Adds an ATM to its records with the required fields
	 * @param maxDay the amount per day a card holder is allowed to withdraw
	 * @param maxTransaction the amount a card holder is allowed to withdraw per transaction
	 * @param minCash the minimum cash required in the ATM to process transactions
	 * @param totalFunds the total amount of funds in the ATM
	 * @param ATMname the ATM's name
	 */
	public void addATM(long maxDay, long maxTransaction, long minCash, long totalFunds, String ATMname)
	{
		atmList.add(new ATM(maxDay,  maxTransaction,  minCash,  totalFunds,  ATMname));
	}
	/*
	 * Adds a credit card to its records
	 * @param cardNum the cards number
	 * @param expiration the date the card expires
	 */
	public void addCards(long cardNum, Date expiration)
	{
		cardList.add(new CreditCard(cardNum,  expiration));
	}
	/*
	 * The main dialogue between the BankComputer and the ATM
	 * @param ATMindex the ATM's index in its records
	 * @param read A scanner to capture user input
	 */
	public void initiateEverything(int ATMindex, Scanner read)
	{
		
		System.out.println("Please enter your card");
		//Gets users Card info in the form (<BankID>  <cardNumber>)
		String bID = read.next();	
		int cardIndex = findCard(read.nextInt());
		//Simulates a card insertion to a ATM machine, than checks if card is within this this bank
		if ((!atmList.get(ATMindex).cardInserted(cardList.get(cardIndex))) || (!BankID.equals(bID)))
		{
			System.out.println(errors[1]);
			System.exit(-1);
		}
		//Finds the account index from the user's card information
		int accountIndex = getAccount(cardList.get(cardIndex).getCardNum());
		//Requests the ATM machine for the card holders password
		System.out.println("Card accepted. Please enter your password");
		String password = atmList.get(ATMindex).getPassword(read);
		//Validates the user's password using the Bank's Account records, and gives three tries
		for (int i = 0; i < 2 && (authorizeSession(accountList.get(accountIndex), password) == false); i++)
		{
			System.out.println(errors[2]);
			password = atmList.get(ATMindex).getPassword(read);
		}
		//Final check for the user's password than exits
		if (authorizeSession(accountList.get(accountIndex), password) == false)
		{
			System.out.println(errors[3]);
			System.exit(-1);
		}
		//Passes validation, sends OK to ATM and requests the ATM for which account to withdraw from
		int account = atmList.get(ATMindex).getAccount(accountList.get(accountIndex).hasChecking(),accountList.get(accountIndex).hasSavings(), read);
		//Requests the ATM to ask how much to withdraw from
		System.out.println("Please select amount you wish to withdraw");
		long amount = atmList.get(ATMindex).getWithdrawal(read);
		//The user may withdraw until he/she wants to quit
		while (amount != -1)
		{
			//Checks if withdrawal amount exceeds account balance
			while (checkWithdrawal(accountIndex, amount, account) == false)
			{
				System.out.println(errors[4]);
				amount = atmList.get(ATMindex).getWithdrawal(read);
			}
			//Withdraws from the account and decrements balance and ATM limit
			withdraw(accountIndex, amount, account);
			atmList.get(ATMindex).withdraw(amount);
			amount = atmList.get(ATMindex).getWithdrawal(read);
			}
	}
	/*
	 * Finds the card index from its records
	 * @param cardNumber the cardNumber to search for
	 * @returns the index of the card
	 */
	private int findCard(int cardNumber)
	{
		for (int i = 0 ; i < cardList.size(); i++)
		{
			if (cardList.get(i).getCardNum()== cardNumber)
			{
				return i;
			}
		}
		System.out.println(errors[0]);
		System.exit(-1);
		return -1;
	}
	/*
	 * Returns the ATM list records
	 */
	public ArrayList<ATM> getATMs()
	{
		return atmList;
	}
	
}

