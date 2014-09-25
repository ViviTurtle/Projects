import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
/**
 * This class creates a flag which has three horizontal rectangles of different colors.
 */
public class HorizontalFlag
{
   private int xtop;
   private int yTop;
   private int width;
   private Color color1;
   private Color color2;
   private Color color3;
   /**
    * Contructs the Horizontal Flag
    * @param x the top left x coordinate of the flag
    * @param y the top left y coordinate of the flag
    * @param aWidth the width of the flag
    * @param c1 the color of the top rectangle of the flag
    * @param c2 the color of the middle rectangle of the flag
    * @param c3 the color of the bottom rectangle of the flag
    */
   public HorizontalFlag(int x, int y, int aWidth, Color c1, Color c2, Color c3)
   {
      xtop = x;
      yTop = y;
      width = aWidth;
      color1 = c1;
      color2 = c2;
      color3 = c3;
   }
   /**
    * Draws the actual flag
    * @param g2 returns graphics to be used in the method
    */
   public void draw(Graphics2D g2)
   {
      int height = width * 2 / 3;
      
      Rectangle topRectangle = new Rectangle(xtop, yTop, width, height/3);
      Rectangle middleRectangle = new Rectangle(xtop, yTop + height/3, width, height/3);
      Rectangle bottomRectangle = new Rectangle(xtop, yTop + 2*height/3, width, height/3);
      Rectangle totalRectangle = new Rectangle(xtop,yTop,width,height);
      
      g2.setColor(color1);
      g2.fill(topRectangle);
      g2.setColor(color2);
      g2.fill(middleRectangle);
      g2.setColor(color3);
      g2.fill(bottomRectangle);
      g2.setColor(Color.BLACK);
      g2.draw(totalRectangle);
   }
}
