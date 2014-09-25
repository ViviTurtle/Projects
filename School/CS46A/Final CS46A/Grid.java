public interface Grid
{
   /**
      Checks whether a location is a valid location inside this grid.
      @param x the x-coordinate of the location
      @param y the y-coordinate of the location
   */
   boolean isValid(int x, int y);

   /**
      Gets the x-coordinate of the center of this grid.
      @return the x-coordinate of the center
   */
   int getCenterX();

   /**
      Gets the x-coordinate of the center of this grid.
      @return the x-coordinate of the center
   */
   int getCenterY();
}
