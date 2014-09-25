import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
/* 
 *  This class creates a bug that can move plane in all directions. The class can obtain its position and able to make a drawing of its trail and direction.
 */
public class Bug2
{
    public static final double OFFSET = 20;
    public static final double MAGNIFICATION = 200;
    public static final double CIRCLE = 10;
    public static final double APEX_VERT = 20;
    public static final double BASE_CORNER = 15;
    private double dx;
    private double dy;
    private double x;
    private double y;
    /* 
    Creates a bug that starts at the origin facing to the right that can me changed using the move and turn methods.
     */
    public Bug2()
    {
        x = 0.0;
        y = 0.0;
        dx = 1.0;
        dy = 0.0;
    }

    /* 
    Moves the bug and draws a line of its movement and draws a red triangle for its direction
    @param disttance how far the bug is moved
    @param g2 draws the line of the bug movement
     */
    public void move(double distance, Graphics2D g2)
    {
        double a = x;
        double b = y;
        x = a + distance*dx;
        y = b + distance*dy;
        double xgraphics1 = a * OFFSET + MAGNIFICATION;
        double ygraphics1 = -b * OFFSET + MAGNIFICATION;
        double xgraphics = x * OFFSET + MAGNIFICATION;
        double ygraphics = -y * OFFSET + MAGNIFICATION;
        
        g2.setColor(Color.BLACK);
        Line2D.Double bugLine = new Line2D.Double (xgraphics1, ygraphics1, xgraphics, ygraphics);
        g2.draw(bugLine);

        double xApex = xgraphics + dx*APEX_VERT;
        double yApex = ygraphics + -dy*APEX_VERT;
        double xBase = xgraphics - dx*APEX_VERT;
        double yBase = ygraphics - -dy*APEX_VERT;
        double xCorner1 = xBase + dy*BASE_CORNER;
        double yCorner1 = yBase + dx*BASE_CORNER;
        double xCorner2 = xBase - dy*BASE_CORNER;
        double yCorner2 = yBase - dx*BASE_CORNER;

        Point2D.Double point1 = new Point2D.Double(xApex, yApex);
        Point2D.Double point2 = new Point2D.Double(xCorner1, yCorner1);
        Point2D.Double point3 = new Point2D.Double(xCorner2, yCorner2);

        Line2D.Double line1 = new Line2D.Double(point1, point2);
        Line2D.Double line2 = new Line2D.Double(point2, point3);
        Line2D.Double line3 = new Line2D.Double(point3, point1);

        g2.setColor(Color.RED);
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);

   
    }
    /* 
     * Turns the bug
     * @param degrees how far the bug should turn in the direction in degrees 
     */
    public void turn(double degrees)
    {
        double radian = Math.toRadians(degrees);
        double newDx = Math.cos(radian)*dx + Math.sin(radian)*dy;
        double newDy = -Math.sin(radian)*dx + Math.cos(radian)*dy;
        dx = newDx;
        dy = newDy;

    }

    /*
     * Gets the current position of the Bug on x-axis
     * @return the x value of the bug
     */
    public double getX()
    {
        return x;
    }

    /*
     * Gets the current position of the bug on the y-axis
     * @return the y value of the bug
     */
    public double getY()
    {
        return y;
    }
}
