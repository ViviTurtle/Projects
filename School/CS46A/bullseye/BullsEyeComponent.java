import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;


public class BullsEyeComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        //Recoevrs Graphcios2D
        Graphics2D g2 = (Graphics2D) g;
        
        //Changes the g2 object to Blue
        g2.setColor(Color.BLUE);
        
        //Conrructs the final circle
        Ellipse2D.Double circle3 = new Ellipse2D.Double(10,25,60, 60);
        g2.fill(circle3);
        
        //changes the g2 object to White
        g2.setColor(Color.WHITE);
        
        //Contructs a second circle bigger then the first
        Ellipse2D.Double circle2 = new Ellipse2D.Double (20,35,40,40);
        g2.fill(circle2);        
        
        //Changes g2 object to red
        g2.setColor(Color.RED);
        
        //Constructs the circle and draws ut
        Ellipse2D.Double circle1 = new Ellipse2D.Double (30,45,20,20);
        g2.fill(circle1);
        

        

    }
}