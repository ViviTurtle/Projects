/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Hw3cTester {
   public static void main(String[] args)
   {
      System.out.println("You may alway assume there is one space between any two words.");
      System.out.println("Six levels of functionality get you 12 points below./n");

      
      
      String input = "you get two points for handling it with no uppercase or punctuation";
      String output = Hw3c.e2PL(input);
      String expected = "ouyay etgay otway ointspay orfay andlinghay itay ithway onay uppercaseay oray unctuationpay";
      
      System.out.println("Input: " + input);
      System.out.println("Output: " + output.toLowerCase());
      System.out.println("Expected: " + expected.toLowerCase());
      
      input = "Do Cases for Another two";
      output = Hw3c.e2PL(input);
      expected = "Oday Asescay orfay Anotheray otway";
      System.out.println("Input: " + input);
      System.out.println("Output: " + output);
      System.out.println("Expected: " + expected);

      input = "end of word punctuation!! for two more.";
      output = Hw3c.e2PL(input);
      expected = "enday ofay ordway unctuationpay!! orfay otway oremay.";
      System.out.println("Input: " + input);
      System.out.println("Output: " + output);
      System.out.println("Expected: " + expected);

      input = "'twas two more for start of word 'unctuation";
      output = Hw3c.e2PL(input);
      expected = "'astway otway oremay orfay artstay ofay ordway 'unctuationay";
      System.out.println("Input: " + input);
      System.out.println("Output: " + output);
      System.out.println("Expected: " + expected);

      
      input = "don't forget within a word m'kay";
      output = Hw3c.e2PL(input);
      expected = "on'tday orgetfay ithinway aay ordway 'kaymay";
      System.out.println("Input: " + input);
      System.out.println("Output: " + output);
      System.out.println("Expected: " + expected);

      
      
      input = "If you want to sleep in, don't!! Get-r-going early.";
      output = Hw3c.e2PL(input);
      expected = "Ifay ouyay antway otay eepslay inay, on'tday!! Et-r-goinggay earlyay.";

      System.out.println("Input: " + input);
      System.out.println("Output: " + output);
      System.out.println("Expected: " + expected);

   }
   
   
  
   
}