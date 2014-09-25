import java.util.Scanner;

// Adapted from ch06/dataset/DataAnalyzer.java
// Removed DataSet which isn't needed here
// Change as necessary

public class Problem4
{  
    public static void main(String[] args)
    {  
        Scanner in = new Scanner(System.in);

        boolean done = false;
        String previous = "";
        while (!done)
        {   

            System.out.print("Enter value, Q to quit: ");
            String input = in.next(); 
            if (input.equalsIgnoreCase("Q"))
            {
                System.out.println("Goodbye");
                done = true;
            }
            else if (input.equals(previous))
            {  
                int previousInt = Integer.parseInt(previous);
                double x = previousInt*previousInt;
                System.out.print(x);
                done = true;
            }
            else previous = input;
        }

    }
}
