/* 
 *  This class creates a bug that can move plane in all directions. The class can also obtain its position.
 */
import java.awt.geom.Point2D;
public class Bug3
{
    private double angle;
    private Point2D.Double position;
    /* 
    Creates a bug that starts at the origin facing to the right that can me changed using the move and turn methods.
     */
    public Bug3()
    {
        angle = 0;
        position = new Point2D.Double (0 ,0);
    }

    /* 
    Moves the bug
    @param distance how far the bug is moved
     */
    public void move(double distance)
    {
        double x = position.getX() + distance*Math.cos(angle);
        double y = position.getY() + distance*Math.sin(angle);
        position.setLocation(x, y);
  

    }

    /* 
     * Turns the bug
     * @param degrees how far the bug should turn in the direction in degrees 
     */
    public void turn(double degrees)
    {
        double radian = Math.toRadians(degrees);
        angle = angle - radian;
    }

    /*
     * Gets the current position of the Bug on x-axis
     * @return the x value of the bug
     */
    public double getX()
    {
        return position.getX();
    }

    /*
     * Gets the current position of the bug on the y-axis
     * @return the y value of the bug
     */
    public double getY()
    {
        return position.getY();
    }
}
