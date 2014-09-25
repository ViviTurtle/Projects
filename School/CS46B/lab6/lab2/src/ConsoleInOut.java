import java.util.Scanner;

public class ConsoleInOut implements InOut
{
   private Scanner in;
   
   public ConsoleInOut()
   {
      in = new Scanner(System.in);
   }

   public String nextLine(String prompt)
   {
      System.out.print(prompt);
      return in.nextLine();
   }

   @Override
   public void message(String text)
   {
      System.out.println(text);
   }
}
