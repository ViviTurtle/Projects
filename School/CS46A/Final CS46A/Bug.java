/**
This class models a bug that crawls in a box.
 */
public class Bug
{
    private int xposition;
    private int yposition;
    private int xdirection;
    private int ydirection;
    private Grid bugsHome;

    /**
    Constructs a bug at the center of the grid, facing to the right.
    @param home the grid that's the bug's home
     */
    public Bug(Grid home)
    {
        bugsHome = home;
        xposition = bugsHome.getCenterX();
        yposition = bugsHome.getCenterY();
        xdirection = 1;
        ydirection = 0;
    }

    /**
    Moves the bug by one unit in the current direction.
    If the movement would cause the bug to leave the box, it
    should reverse direction and move in the reversed direction.
     */
    public void move()
    {
        if (bugsHome.isValid(xposition +1, yposition +1))
        {
            xposition += 1*xdirection;
            yposition += 1*ydirection;
        }
        else if (!bugsHome.isValid(xposition +1, yposition +1))
        {
            this.turn();
            this.turn();
            xposition += 1*xdirection;
            yposition += 1*ydirection;
            this.turn();
            this.turn(); 
        }
    }

    /**
    Makes the bug turn 90 degrees clockwise.
     */
    public void turn()
    {
        int newDx = ydirection;
        int newDy = -xdirection;
        xdirection = newDx;
        ydirection = newDy;
    }

    /**
    Gets a string describing the current position of this bug.
    @return the position string, of the format (x, y)
     */
    public String getPosition()
    {
        return "(" + xposition + ", " + yposition + ")";
    }
}
