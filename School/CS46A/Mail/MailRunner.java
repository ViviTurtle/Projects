public class MailRunner
{
   public static void main(String[] args)
   {
      Mail warning = new Mail("It appears you have not turned in ",
         ". Please remember that\nyou are expected to attempt all assignments in this class.",
         "Professor Fiendish");
      String message1 = warning.createMessage("John", "CS46A homework 2 draft");
      String message2 = warning.createMessage("Mary", "CS46A homework 2 draft");
      String message3 = warning.createMessage("Shawn", "CS46A homework 2 final");
      System.out.println(message1);
      System.out.println(message2);
      System.out.println(message3);
   }
}
