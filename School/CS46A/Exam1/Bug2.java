/**
   This class models a bug that crawls in a 2D world.
*/
public class Bug2
{
   private double xposition;
   private double yposition;
   private double xdirection;
   private double ydirection;

   /**
      Constructs a bug at the origin, facing right.
   */
   public Bug2()
   {
      xposition = 0;
      yposition = 0;      
      xdirection = 1;
      ydirection = 0;
   }
   
   /**
      Moves the bug by one unit in the current direction.
      @param amount the amount by which to move the bug
   */
   public void move(double amount)
   {
      xposition = xposition + amount * xdirection;
      yposition = yposition + amount * ydirection;
   }
   
   /**
      Turns this bug by a given angle 
      @param angle the angle in degrees
   */
   public void turn(int angle)
   {
      double alpha = Math.toRadians(angle);
      double newDx = Math.cos(alpha) * xdirection + Math.sin(alpha) * ydirection;
      double newDy = -Math.sin(alpha) * xdirection + Math.cos(alpha) * ydirection;
      xdirection = newDx;
      ydirection = newDy;
   }
   
   /**
      Gets the current x position of this bug.
      @return the x position
   */
   public double getX()
   {
      return xposition;
   }

   /**
      Gets the current x position of this bug.
      @return the y position
   */
   public double getY()
   {
      return yposition;
   }
}
