import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

/**
 * This VisibleRectangle class is similar to the Rectangle class in the standard Java 
 * library, but the rectangles are displayed in a window and updated when 
 * you call translate or grow, so that you can visualize them easily.
 * 
 * Don't look at the code inside--you will not know what these constructs mean until 
 * Chapter 11.
 */
public class VisibleRectangle extends Rectangle
{
   private static JFrame frame = new JFrame();
   private static ArrayList<Shape> shapes = new ArrayList<Shape>();
   private static JComponent component = new JComponent()
      {
         public void paintComponent(Graphics g)
         {
            Graphics2D g2 = (Graphics2D) g;
            for (Shape s : shapes) g2.draw(s);
         }
      };
    
   static
   {
      frame.add(component);
      frame.setSize(300, 300);
      frame.setVisible(true);
   }

   /**
      Clears the display.
   */
   public static void clear()
   {
      shapes.clear();
   }

    
      private static void addShape(Shape shape)
   {
      shapes.add(shape);
      repaintFrame();
   }
    
   private static void repaintFrame()
   {
      component.repaint();
      frame.setVisible(true);
   }

   /**
    * Constructs a rectangle with top left corner (0, 0), width 0, and height 0.
    */
   public VisibleRectangle()
   {
      addShape(this);
   }
    
   /**
    * Constructs a new <code>Rectangle</code> with a given upper left corner,
    * width, and height. 
    * @param     x the y coordinate of the top left corner
    * @param     y the y coordinate of the top left corner
    * @param     width the width of the <code>Rectangle</code>
    * @param     height the height of the <code>Rectangle</code>
    */
   public VisibleRectangle(int x, int y, int width, int height)
   {
      super(x, y, width, height);
      addShape(this);
   }

   /**
    * Translates this <code>Rectangle</code> the indicated distance,
    * to the right along the X coordinate axis, and 
    * downward along the Y coordinate axis.
    * @param dx the distance to move this <code>Rectangle</code> 
    *                 along the X axis
    * @param dy the distance to move this <code>Rectangle</code> 
    *                 along the Y axis
    */
   public void translate(int dx, int dy)
   {
      super.translate(dx, dy);
      repaintFrame();
   }
    
   /**
    * Resizes the <code>Rectangle</code> both horizontally and vertically.
    * <p>
    * This method modifies the <code>Rectangle</code> so that it is 
    * <code>h</code> units larger on both the left and right side, 
    * and <code>v</code> units larger at both the top and bottom. 
    * <p>
    * The new <code>Rectangle</code> has (x - h, y - v)
    * as its upper-left corner,
    * new width equal to old width + 2h,
    * new height equal to old height + 2v.
    * <p>
    * If negative values are supplied for <code>h</code> and 
    * <code>v</code>, the size of the <code>Rectangle</code> 
    * decreases. 
    * @param h the horizontal expansion
    * @param v the vertical expansion
    */
   public void grow(int h, int v)
   {
      super.grow(h, v);
      repaintFrame();
   }
}
