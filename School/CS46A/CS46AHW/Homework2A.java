import java.awt.Color;

/**
   This class demonstrates the brighter method of the Color class.
 */
public class Homework2A
{
   public static void main(String[] args)
   {
      Color red = new Color(60,70,80);
      System.out.print("Red: ");
      int redness = red.getRed();
      System.out.println(redness);
   }    
}
