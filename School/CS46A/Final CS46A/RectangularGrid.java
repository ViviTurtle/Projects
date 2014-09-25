public class RectangularGrid implements Grid
{
   private int maxx;
   private int maxy;

   public RectangularGrid(int maxx, int maxy)
   {
      this.maxx = maxx;
      this.maxy = maxy;
   }

   /**
      Checks whether a location is a valid location inside this grid.
      @param x the x-coordinate of the location
      @param y the y-coordinate of the location
   */
   public boolean isValid(int x, int y)
   {
      return 0 <= x && x <= maxx && 0 <= y && y <= maxy;
   }


   /**
      Gets the x-coordinate of the center of this grid.
      @return the x-coordinate of the center
   */
   public int getCenterX()
   {
      return maxx / 2;
   }

   /**
      Gets the x-coordinate of the center of this grid.
      @return the x-coordinate of the center
   */
   public int getCenterY()
   {
      return maxy / 2;
   }
}
