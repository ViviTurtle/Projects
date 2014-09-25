import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
/* 
 * This class creates flags
 */
public class VerticalFlag
{
   private int xLeft;
   private int yTop;
   private int width;
   private int height;
   private Color color1;
   private Color color2;
   private Color color3;
   /*
    * This constructs the variables for the flag
    * @param x top left x-coordinate of the flag
    * @param y top coordinates of the flag
    * @param aWidth Total width of the flag
    * @param aHeight total Height of the flag
    * @param c1 color of the left rectangle of the flag
    * @param c2 color of the middle rectangle of the flag
    * @param c3 color of the right rectangle of the flag
    */
   public VerticalFlag(int x, int y, int aWidth, int aHeight, Color c1, Color c2, Color c3)
   {
      xLeft = x;
      yTop = y;
      width = aWidth;
      height = aHeight;
      color1 = c1;
      color2 = c2;
      color3 = c3;
   }
   /*
    * Draws the actual flag
    */
   public void draw(Graphics2D g2)
   {
       //constucts the left rectangle
      Rectangle leftRectangle = new Rectangle(xLeft, yTop, width/3, height);
       //constucts the middle rectangle
      Rectangle middleRectangle = new Rectangle (xLeft + width / 3, yTop, width / 3, height); 
       //constucts the right rectangle
      Rectangle rightRectangle = new Rectangle(xLeft + 2 * width / 3, yTop, width / 3, height);
       //constucts the black outline of the flag
      Rectangle totalRectangle = new Rectangle (xLeft, yTop, width, height);
      
      // Sets, colors and draws the left, middle, and right rectangle and outline
      g2.setColor(color1);
      g2.fill(leftRectangle);
      g2.setColor(color2);
      g2.fill(middleRectangle);
      g2.setColor(color3);
      g2.fill(rightRectangle);
      g2.setColor(Color.BLACK);
      g2.draw(totalRectangle);
   }
}
