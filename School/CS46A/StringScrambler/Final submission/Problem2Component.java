import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Problem2Component extends JComponent
{  
    private int bigCircles;
    private int diameter;

    /**
    Draws a given number of big black circles, each of which
    contains two red circles with half the diameter. 
    @param bigCircles the number of big circles
    @param diameter the diameter of the big circles
     */
    public Problem2Component(int bigCircles, int diameter)
    {
        this.bigCircles = bigCircles;
        this.diameter = diameter;
    }

    public void paintComponent(Graphics g)
    {  
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i <=bigCircles-1; i++)
        {
            g2.setColor(Color.BLACK);
            Ellipse2D.Double circle = new Ellipse2D.Double(diameter*i,10,diameter, diameter);
            g2.draw(circle);
            g2.setColor(Color.RED);
            Ellipse2D.Double circle1 = new Ellipse2D.Double(diameter*i,25,diameter/2, diameter/2);
            g2.draw(circle1);
            Ellipse2D.Double circle2 = new Ellipse2D.Double(diameter*i+diameter/2,25,diameter/2, diameter/2);
            g2.draw(circle2);

        }
    }
}
