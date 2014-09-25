// This class makes a bug that lives in a box and able to track its position, when it moves towards its edges of its home it turns 
public class Bug4
{
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int newDx;
    private int newDy;
    private double height1;
    private double width1;
    /*
     * This constructs the bug in the center of its home facing northeast
     * @param width1 the width of the home
     * @param height1 the height of the home
     */
    public Bug4(int width, int height)
    {
        dx = 1;
        dy = 1;
        x = width/2; //center of the width
        y = height/2; //center of the length
        newDx = 0;
        newDy = -1;
        height1 = height;
        width1 = width;
    }

    /*
     * This method moves the bug and also makes it turn when it moves towards the walls of its home
     * @param n the amount the bug moves
     */
    public void move(int n)
    {
        for (int i=1; i <= n; i++)
            if ((x == width1 && dx == 1) || (x ==0 && dx == -1))
            {
                dx = -dx;
                x = x + 1*dx;
                if ((y ==0 && dy == -1) || (y == height1 && dy == 1))
                {
                    dy = -dy;
                    y = y + 1*dy;
                }
                else y = y + 1*dy;

            }
            else if ((y == 0 && dy == -1) || (y == height1 && dy == 1))
            {
                dy = -dy;
                y = y + 1*dy;
                x = x + 1*dx;
            }

            else
            {
                x = x + 1*dx;
                y = y + 1*dy;
        }
    }

    /*
     * This method turns the bug
     */
    public void turn()
    {
        newDx = dy;
        newDy = -dx;
        dx = newDx;
        dy = newDy;
    }

    /*
     * Gets the x position of the bug
     * @return the x-coordinate
     */
    public int getX()
    {
        return x;
    }

    /*
     *Gets the y position of the bug
     *@returns the y-coordinate of the bug
     */
    public int getY()
    {
        return y;
    }
    
    public int moveToBoundary()
    while ((Bug4.getX() != width) || (Bug4.getY() != length))
    
}
