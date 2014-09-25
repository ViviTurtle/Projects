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
   public Bug1(int initialPosition) // Corrected compile-time error
   {
      position = initialPosition; //Corrected run-time error
      direction = 1;
   }
   
   /**
      Moves the bug in the current direction.
      @param distance the distance by which to move
   */
   public void move(int distance) // Corrected compile-time error
   {
      position = position + distance * direction;
   }
   
   /**
      Flips the direction of this bug. 
   */
   public void turn() // Corrected compile-time error
   {
      direction = - direction;// Corrected compile-time error
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
