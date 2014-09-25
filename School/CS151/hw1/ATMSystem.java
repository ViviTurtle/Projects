/*
 * Print States
 * BankofA(Six customers) 
 * Customer - Cash card(bankID":A, card # 1) Can access both checking or saving, expires after today, password = "3231"
 * Customer - Cash card(bankID":A, card # 2) Can access both checking or saving, expires after today, password = "3231"
 * Customer - Cash card(bankID":A, card # 3) Can access both checking or saving, expires after today, password = "3231"
 * Customer - Cash card(bankID":A, card # 4) Can access both checking or saving, expires 1/19/2011, password = "3231"
 * Customer - Cash card(bankID":A, card # 5) Can access saving, expires after today, password = "3231"
 * Customer - Cash card(bankID":A, card # 6) Can access checking , expires after today, password = "3231"
 * 
 * BankofB(Three customers)
 * Customer - Cash card(bankID":B, card # 1) Can access both checking or saving, expires after today, password = "3231"
 * Customer - Cash card(bankID":B, card # 2) Can access both checking or saving, expires after today, password = "3231"
 * Customer - Cash card(bankID":B, card # 3) Can access both checking or saving, expires after today, password = "3231"
 * 
 * Print States of four ATMs:
 * 	  A.1_A
 *    The maximum of cash a card can withdraw per day is $500
 *    The maximum amount of cash a card can withdraw per transaction $250
 *    the minimum cash in the ATM to permit a transaction $30
 *    the total fun in the ATM at start of the day $1000
 *     
 *    A.2_A
 *    The maximum of cash a card can withdraw per day is 500
 *    The maximum amount of cash a card can withdraw per transction 100
 *    the minimum cash in the ATM to permit a transaction 50
 *    the total fun in the ATM at start of the day 200
 *    
 *    B.1_B
 *    The maximum of cash a card can withdraw per day is 500
 *    The maximum amount of cash a card can withdraw per transaction 100
 *    the minimum cash in the ATM to permit a transaction 50
 *    the total fun in the ATM at start of the day 25
 *    
 *    B.2_B
 *    The maximum of cash a card can withdraw per day is 500
 *    The maximum amount of cash a card can withdraw per transaction 100
 *    the minimum cash in the ATM to permit a transaction 50
 *    the total fun in the ATM at start of the day 75
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ATMSystem {
	
	static ArrayList<BankComputer> bankList = new ArrayList<BankComputer>();
	static BankComputer bankComp;
	static int atm_index;
	/*
	 * The main class
	 * @args no arguments
	 */
	public static void main(String[] args)
	{
		initializeBank();
		Scanner read = new Scanner(System.in);
		System.out.println("Enter your choice of ATM");
		String atm = read.next();
		findComputer(atm);
		if(bankComp == null)
		{
			System.out.println("Invalid ATM");
			System.exit(-1);
		}
		bankComp.initiateEverything(atm_index, read);
		read.close();
	}
	/*
	 * Finds the Bank and computer with the ATM asked for
	 * @param atm the user wanted to use
	 */
	private static void findComputer(String atm)
	{
		for (int i = 0 ; i < bankList.size(); i++)
		{
			for (int j = 0; j< bankList.get(i).getATMs().size(); j++)
			{
				if (bankList.get(i).getATMs().get(j).getATM().equals(atm))
				{
				 bankComp =  bankList.get(i);
				 atm_index = j;
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	/*
	 * Initializes all test cases
	 */
	private static void initializeBank()
	{	
		bankList.add(new BankComputer("A"));
		bankList.get(0).addATM(500,  250,  50,  1000,  "A.1");
		//Check Day Limit or transanction limit
		bankList.get(0).addCards( 1, new Date());		
		bankList.get(0).addAccount(1, "3231",  100000,  200 );
		bankList.get(0).addCards( 2, new Date());
		bankList.get(0).addAccount(2, "3231",  100,  200 );
		//Expired Date
		bankList.get(0).addCards( 4, new Date(2011, 01, 19));
		bankList.get(0).addAccount(4, "3231",  100,  200 );
		bankList.get(0).addATM(500,  100,  50,  200,  "A.2");
		//Check not enough funds
		bankList.get(0).addCards( 3, new Date());
		bankList.get(0).addAccount(3, "3231",  25,  2 );
		//Check if prints checking
		bankList.get(0).addCards( 5, new Date());
		bankList.get(0).addAccount(5, "3231",  -1,  200 );
		//Check if print Saving
		bankList.get(0).addCards( 6, new Date());
		bankList.get(0).addAccount(6, "3231",  100,  -1 );
		bankList.add(new BankComputer("B"));
		//Check if ATM ran out of funds
		bankList.get(1).addATM(500,  100,  50,  25,  "B.1");
		bankList.get(1).addCards( 1, new Date());
		bankList.get(1).addAccount(1, "3231",  100,  -1 );
		bankList.get(1).addCards( 2, new Date());
		bankList.get(1).addAccount(2, "3231",  100,  200 );
		bankList.get(1).addCards( 3, new Date());
		bankList.get(1).addAccount(3, "3231",  100,  200 );
		bankList.get(1).addATM(500,  100,  50,  75, "B.2");
	}
}
