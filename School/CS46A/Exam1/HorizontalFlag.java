import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class HorizontalFlag
{
   private int xtop;
   private int yTop;
   private int width;
   ...
   
   public HorizontalFlag(int x, int y, int aWidth, 
      ...)
   {
      xtop = x;
      yTop = y;
      width = aWidth;
      ...
   }

   public void draw(Graphics2D g2)
   {
      int height = width * 2 / 3;
      
      Rectangle topRectangle = new Rectangle(
         ...);
      Rectangle middleRectangle = new Rectangle(
         ...);
      Rectangle bottomRectangle = new Rectangle(
         ...);
      Rectangle totalRectangle = new Rectangle(
         xtop, yTop,
         width, height);
      
      g2.....(...);
      g2.....(topRectangle);
      g2.....(...);
      g2.....(middleRectangle);
      g2.....(...);
      g2.....(bottomRectangle);
      g2.setColor(Color.BLACK);
      g2.draw(totalRectangle);
   }
}
