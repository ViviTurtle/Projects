public class Bug3 
{
    private int x;
    private int y;
    private int dx;
    private int dy;

   /**
      Constructs a bug at an auspicious location.
   */
   public Bug3()
   {
      x = 1;
      y = 1;
      dx = 1;
      dy = -1;
   }

   /**
      Moves this bug in the direction into which it faces.
      @param n the amount by which to move
   */
   public void moveForward(int n) 
   {
      x = x + n * dx;
      y = y + n * dy;
   }

   /**
      Moves this bug away from the direction into which it faces.
      @param n the amount by which to move
   */
   public void moveBackward(int n) 
   {
      x = x - n * dx;
      y = y - n * dy;
   }

   /**
      Turns this bug left.
   */
   public void turnLeft()
   {
      int newDx = dy;
      dy = -dx;
      dx = newDx;
   }
   
   /**
      Turns this bug right.
   */
   public void turnRight()
   {
      int newDx = -dy;
      dy = dx;
      dx = newDx;
   }

   /**
      Returns a string describing the bug's position
   */
   public String getPosition()
   {
      return "(" + x + ", " + y + ")";
   }
}
