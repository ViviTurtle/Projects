/**
   This class models a bug that crawls along a horizontal line.
*/
public class Bug1
{
   private int position;
   private int direction;

   /**
      Constructs a bug with a given position, facing right.
      @param initialPosition the initial position
   */
   public Bug(int initialPosition)
   {
      initialPosition = position;
      direction = 1;
   }
   
   /**
      Moves the bug in the current direction.
      @param distance the distance by which to move
   */
   public void move()
   {
      direction = position + distance * direction;
   }
   
   /**
      Flips the direction of this bug. 
   */
   public int turn()
   {
      int direction = -direction;
   }
   
   /**
      Gets the current position of this bug.
      @return the position
   */
   public int getPosition()
   {
      return position;
   }
}
