/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taylor
 */
public class Hw7bFinalTester {
   public static void main(String[] args)
   {
      String[] l = {"<p>", "<ul>", "<li>", "</li>",
         "</ul>", "<a>", "</a>", "</p>"};
      System.out.println(Hw7b.checkTags(l));
      System.out.println("Expected:  true");
      
      String[] l2 = {"<p>", "<ul>", "<li>", "</li>",
         "</ul>", "<a>", "</a>", "</p>", "<p>", "</p>"};
      System.out.println(Hw7b.checkTags(l2));
      System.out.println("Expected:  true");
      
      String[] l3 = {"<p>", "<ul>", "<li>", "</li>", "</li>",
         "</ul>", "<a>", "</a>", "</p>"};
      System.out.println(Hw7b.checkTags(l3));
      System.out.println("Expected:  false");
   }

}