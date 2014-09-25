import java.util.ArrayList;

public interface Grid
{
   /**
      Returns all occupied locations.
      @return a list of all locations with non-zero values
   */
   public ArrayList<Location> occupiedLocations();

   /**
      Returns all valid neighboring locations of a given location.
      @param loc a valid location 
      @return a list of all valid neighboring locations of loc
   */
   public ArrayList<Location> validNeighbors(Location loc);

   /**
      Returns the value at a given location.
      @param loc a valid location 
      @return the value at loc
   */

   public int get(Location loc);

   /**
      Sets the value at a given location.
      @param loc a valid location       
      @param value the value to set at loc
   */
   public void set(Location loc, int value);
}