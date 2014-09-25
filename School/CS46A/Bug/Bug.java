/**
   This class models a bug that crawls along a horizontal line.
*/
public class Bug
{
private double turns;
private double position;
    public Bug(double startingPoint)
    {
        turns = 1;
        position = startingPoint;
    }
    
    public void move()
    {
        position = position + 1*turns;
    }
    public void turn()
    {
        turns = turns*-1;
    }
    public double getPosition()
    {
        return position;
    }
}
