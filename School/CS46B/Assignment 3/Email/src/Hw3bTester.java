/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Hw3bTester {
   public static void main(String[] args)
   {
      String[] args1 = {"inputFile1.txt", "-1"};
      try
      {
         Hw3b.main(args1);
         System.out.println("This line should not be printed");
      }
      catch (IndexOutOfBoundsException e)
      {
         System.out.println("Got IndexOutOfBoundsException");
      }
      System.out.println("Expected: Got IndexOutOfBoundsException");

      String[] args2 = {"too", "many", "arguments"};
      Hw3b.main(args2);
      System.out.println("Expected: Usage: Hw3b inputFileName desiredEmailIndex");
      String[] args3 = {};
      Hw3b.main(args3);
      System.out.println("Expected: Usage: Hw3b inputFileName desiredEmailIndex");
      String[] args4 = {"thisFileNameIsNotTheNameOfAnExistingFile.txt", "1"};
      Hw3b.main(args4);
      System.out.println("Expected: File not found: thisFileNameIsNotTheNameOfAnExistingFile.txt");
   }
   
}
