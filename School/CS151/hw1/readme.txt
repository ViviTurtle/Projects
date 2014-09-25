All you need to know is that each card is connected to an account which has both saving and checking
e.g
bankList.get(0).addCards( 1, new Date()); (dates can also be new Date(2011, 01, 19))		
bankList.get(0).addAccount(1, "3231",  100000,  200 );

New Banks are made like this bankList.add(new BankComputer("A"));

--In this case because bankList.get(0) the bank I just made to access a card in that Bank is "A #" eg
"A 3" 

Money formats are whole numbers (No dollar signs needed)

Just make sure you are not putting in characters for numbers


ATMS are initiated like this 
	bankList.get(0).addATM(500,  250,  50,  1000,  "A.1");
	--In this case the ATM to be used is A.1
	
