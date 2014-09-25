
import org.lgna.common.DoTogether;
import org.lgna.story.resources.biped.BunnyResource;
import org.lgna.story.*;

/**
 * A robot that lives on a grid.
 * @author cay
 */
public class Robot extends SBiped 
{
    private int x;
    private int y;
    private int dx;
    private int dy;
    private boolean crashed;
    
    /**
     * Constructs a robot at a given grid location. The robot faces north.
     * @param x the x location of the robot
     * @param y the y location of the robot
     */
    public Robot(int x, int y)
    {
        super(BunnyResource.BUNNY);
        setPaint(Color.PINK);
        this.x = x;
        this.y = y;
        dx = 1;
        dy = 0;
    }

    @Override
    public void setVehicle(SThing vehicle) {
        super.setVehicle(vehicle);
        setOrientationRelativeToVehicle(new Orientation(0, -Math.sqrt(0.5), 0, Math.sqrt(0.5)));
        setPositionRelativeToVehicle(new Position(x, -0.05, y));    
    }

    
    
    /**
     * Moves this robot one step in the direction that it is facing.
     */
    public void moveForward()
    {
        if (crashed) return;
        if (frontHasWallorWindow())
        {
           setPaint(Color.BLACK);
           crashed = true;
           return;
        }
        x += dx;
        y += dy;
        if (dy != 0)
        {
            final SCamera camera = ((Scene) getVehicle()).getCamera();
            DoTogether.invokeAndWait(
                new Runnable() {
                    public void run() {
                        move(MoveDirection.FORWARD, 1);
                    }
                },
                new Runnable() {
                    public void run() {
                        camera.move(dy == 1 ? MoveDirection.BACKWARD : MoveDirection.FORWARD, 1);
                    }
                });
        }
        else
        {
            move(MoveDirection.FORWARD, 1);        
        }
    }

    public Robot() {
        this(0, 0);
    }

    /**
     * Turns this robot left.
     */
    public void turnLeft()
    {
        if (crashed) return;
        int newDx = dy;
        dy = -dx;
        dx = newDx;
        turn(TurnDirection.LEFT, 0.25);
    }

    /**
     * Turns this robot right.
     */
    public void turnRight()
    {
        if (crashed) return;
        int newDx = -dy;
        dy = dx;
        dx = newDx;
        turn(TurnDirection.RIGHT, 0.25);
    }

    /**
     * Checks whether there is a wall or window in front of this robot.
     * @return true if there is a wall or window, false if there is neither.
     */
    public boolean frontHasWallorWindow()
    {
        for (Window w : ((Scene) getVehicle()).getWallsAndWindows())
        {
             if (w.getX() == x + dx * 0.5 && w.getY() == y + dy * 0.5)
             {
                 System.out.println(this);
                 System.out.println(w);
                 return true;
             }
        }
        return false;
    }

    /**
     * Checks whether there is a wall to the right of this robot.
     * @return true if there is a wall, false if there isn't a wall.
     */
    public boolean rightHasWall()
    {
        for (Window w : ((Scene) getVehicle()).getWallsAndWindows())
        {
            if (w instanceof Wall)
            {
                if (w.getX() == x + -dy * 0.5 && w.getY() == y + dx * 0.5)
                    return true;
            }
        }
        return false;
    }    
    
    public String toString() 
    {
        return getClass().getName() + "[x=" + x + ",y=" + y + ",dx=" + dx + ",dy=" + dy + "]";
    }
}
