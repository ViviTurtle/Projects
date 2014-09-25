import org.lgna.story.Color;
import org.lgna.story.Orientation;
import org.lgna.story.Position;
import org.lgna.story.SBillboard;
import org.lgna.story.SThing;
import org.lgna.story.Size;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cay
 */
public class Window extends SBillboard 
{  
    public static final int X_DIRECTION = 1;
    public static final int Y_DIRECTION = 2;
    
    private double x;
    private double y;
    private int direction;

    /**
     * Construct a window that is north or west of a robot at a given location
     * @param x the x location of a robot adjacent to this wall
     * @param y the y location of a robot adjacent to this wall
     * @param direction X_DIRECTION or Y_DIRECTION
     */
    public Window(int x, int y, int direction)
    {        
        this.x = x;
        this.y = y;
        this.direction = direction;
        setOpacity(0);
    }    

    @Override
    public void setVehicle(SThing vehicle) 
    {
        super.setVehicle(vehicle);
        Orientation q;
        if (direction == X_DIRECTION)
        {
            this.x = x;
            this.y = y - 0.5;
            q = new Orientation(0, 0, 0, 1);
        }
        else
        {
            this.x = x - 0.5;
            this.y = y;
            q = new Orientation(0, Math.sqrt(0.5), 0, Math.sqrt(0.5));
        }
        setOrientationRelativeToVehicle(q);
        setPositionRelativeToVehicle(new Position(this.x, 0, this.y));
    }
        
    /**
    * Gets the x location of the center of this wall.
    * @return the x location
    */
    public double getX()
    {
        return x;
    }

    /**
    * Gets the y location of the center of this wall.
    * @return the y location
    */
    public double getY()
    {
        return y;
    }

    /**
    * Gets the direction of this wall.
    * @return X_DIRECTION or Y_DIRECTION
    */
    public int getDirection()
    {
        return direction;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + ",direction="  + (direction == X_DIRECTION ? "X" : "Y") + "_DIRECTION]";
    }    
}

