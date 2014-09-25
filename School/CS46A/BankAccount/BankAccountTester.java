public class BankAccountTester
{
    public static void main (String[] args)
    {
        BankAccount myAccount = new BankAccount(1000);
        myAccount.addInterest(10 , 5);
        double interest = 1000* Math.pow(1.05, 10);
        System.out.println(myAccount.getBalance());
        System.out.print("Expected: ");
        System.out.println(interest);
    }
}