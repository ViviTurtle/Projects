import java.awt.Color;

/**
   This class demonstrates the brighter method of the Color class.
 */
public class Homework2A
{
   public static void main(String[] args)
   {
      Color mycolor = new Color(60,70,80);
      Color brightcolor = mycolor.brighter().brighter().brighter();
      System.out.print("Red: ");
      System.out.println(brightcolor.getRed());
      System.out.print("Green: ");
      System.out.println(brightcolor.getGreen());
      System.out.print("Blue: ");
      System.out.println(brightcolor.getBlue());
   }    
}
