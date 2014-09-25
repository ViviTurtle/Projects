import java.awt.Rectangle;

/**
   Prints a square, then translates it, and grows it so that
   the new square is twice the size of the original and has the
   same top-left corner.
*/
public class GrowSquarePrinter
{  
   public static void main(String[] args)
   {  
      /*
         Construct the square
      */
     Rectangle rect1 = new Rectangle(50,50,100,100);
     System.out.println(rect1);
      /*
         Call the translate method (Skip for draft)
      */
     rect1.translate(50,50);
     
      /*
         Call the grow method and print the square again (Skip for draft)
      */
     rect1.grow(50,50);
     System.out.println(rect1);
   }
}
