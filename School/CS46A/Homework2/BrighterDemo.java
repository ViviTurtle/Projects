import java.awt.Color;
import javax.swing.JFrame;

/**
   This class demonstrates the brighter method 
   of the Color class and displays the color.
*/
public class BrighterDemo
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(200,200);
		
      Color mycolor = new Color(60,70,80);
      Color mycolor2 = mycolor.brighter();
      Color mycolor3 = mycolor2.brighter();
      Color mycolor4 = mycolor3.brighter();
		
      frame.getContentPane().setBackground(mycolor4);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }    
}
