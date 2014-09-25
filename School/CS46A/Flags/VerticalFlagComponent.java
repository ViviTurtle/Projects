  import java.awt.Graphics;
  import java.awt.Graphics2D;
  import javax.swing.JPanel;
  import javax.swing.JComponent;
  import java.awt.Color;
  import java.awt.Rectangle;
  import java.awt.geom.Line2D;
  /* 
   * This class creates the French and Belgian Flags using rectangles. 
   */
  public class VerticalFlagComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        //recovers Graphics 2D
        Graphics2D g2 = (Graphics2D) g;
        
        //Changes the g2 object to Blue
        g2.setColor(Color.BLUE);
        
        //Constructs the blue Rectangle
        Rectangle blueBox = new Rectangle (100, 100 , 50, 100);
        g2.fill(blueBox);
        
        //Changes the g2 object to red
        g2.setColor(Color.RED);

        //Constructs the Red Rectangle on the right side of the flag of the French Flag
        Rectangle redBox = new Rectangle (200, 100, 50, 100);
        g2.fill(redBox);
        
        //Constructs the Red Rectangle of the Belgian Flag
        Rectangle redBox2 = new Rectangle (200, 250 , 50, 100);
        g2.fill(redBox2);
        
        //changes the g2 object to black
        g2.setColor(Color.BLACK);
        
        //Constructs the outline of the French Recntangle
        Rectangle frenchBox = new Rectangle ( 100, 100 ,150, 100);
        g2.draw(frenchBox);
        
        // Constructs the outline of the Belgian Rectangle 
        Rectangle belgianBox = new Rectangle (100,250,150,100);
        g2.draw(belgianBox);
        
        // Constructs the Black Rectangle of the Belgian Flag
        Rectangle blackBox = new Rectangle (100, 250, 50, 100);
        g2.fill(blackBox);
        
        //Changes g2 to Yellow
        g2.setColor(Color.YELLOW);
        
        //Constructs the Yellow Rectangle of the Belgian Flag
        Rectangle yellowBox = new Rectangle (150, 250 , 50 ,100);
        g2.fill(yellowBox);
    }
}
    