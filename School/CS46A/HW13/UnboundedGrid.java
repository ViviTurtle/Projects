// This creates an unbounded grid that can give occupied locations, set, get, or count how many neigbors are set.
import java.util.ArrayList;
public class UnboundedGrid implements Grid
{
    ArrayList<Location> location;
    ArrayList<Integer> values;
    
    /*
     * This creates the unbounded grid by using two parallel Arrays
     */
    public UnboundedGrid()
    {
        location = new ArrayList<Location>();
        values = new ArrayList<Integer>();
    }

    /*
     * This gets the value of a certain location in the grid
     * @param loc the location of where the value should be found
     * @return the value at the location
     */
    public int get(Location loc)
    {
        if (location.indexOf(loc) == -1) //-1 = it isn't found
        {
            return 0;
        }   
        int place = location.indexOf(loc);
        return values.get(place);
    }
    
    /*
     * This sets a specific value on the grid
     * @param loc the location of where to set the value on the grid
     * @param value the value to set the location
     */
    public void set(Location loc, int value)
    {
        if (location.indexOf(loc) == -1)
        {
            location.add(loc);
            values.add(value);
        }
        else
        {
            if (value == 0)
            {
                values.set(location.indexOf(loc), value);
                location.remove(location.indexOf(loc));
            }
            else values.set(location.indexOf(loc), value);

        }
    }

    /*
    Returns all occupied locations.
    @return a list of all locations with non-zero values
     */
    public ArrayList<Location> occupiedLocations()
    {
        return location;
    }

    /*
    Returns all valid neighboring locations of a given location.
    @param loc a valid location 
    @return a list of all valid neighboring locations of loc
     */
    public ArrayList<Location> validNeighbors(Location loc)
    {
        ArrayList<Location> locations = new ArrayList<Location>();
        int maxX= loc.getColumn() + 1;
        int maxY= loc.getRow() + 1;
        int minX = loc.getColumn() - 1;
        int minY= loc.getRow() -1;
        for (int i = minX; i <= maxX; i++)

        {
            for (int j = minY; j <= maxY; j++)
            {
                if (!new Location (i,j).equals(loc))
                {
                    locations.add(new Location (i,j));
                }
            }
        }
        return locations;
    }

}