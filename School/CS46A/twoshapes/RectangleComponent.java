import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;

/**
   A component that draws two rectangles.
*/
public class RectangleComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;

      // Construct a circle and draw it
      Ellipse2D.Double box = new Ellipse2D.Double (30, 45, 20, 20);
      g2.draw(box);
      
      // draws a second ellipse at th a different spot from the firest one
      Ellipse2D.Double ellipse = new Ellipse2D.Double (20, 35, 40 ,40);


      // Draw moved rectangle
      g2.draw(ellipse);
   }
}
