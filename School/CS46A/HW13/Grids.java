/*
 * This class uses a mysterious unknown grid in which one can count Nonzero neigbors, count how many neighbors it has, and set multiple locations.
 */
import java.util.ArrayList;
public class Grids
{
    /*
    Counts the number of neighbors that are not zero.
    @param grid a grid
    @param loc a valid location in the grid
    @return the number of non-zero neighbors around loc
     */
    public static int countNonZeroNeighbors(Grid grid, Location loc)
    {
        int counter = 0;
        ArrayList<Location> places = grid.validNeighbors(loc);
        for (int i = 0; i<= places.size()-1; i++)
        {
            Location loca = places.get(i);
            if (grid.get(loca) !=0)
            {
                counter++;
            }
        }
        return counter;
    }

    /*
    Gets all locations that have a given neighbor count.
    @param grid a grid
    @param neighborCount the desired neighbor count
    @return all locations in the grid with the given number
    of nonzero neighbors
     */
    public static ArrayList<Location> locationsWithNeighbors(Grid grid, int neighborCount)
    {
        ArrayList<Location> places = new ArrayList<>();
        ArrayList<Location> occupied = grid.occupiedLocations();
        for (int i = 0; i <= occupied.size() -1; i++) //goes through each occupied location
        {  
            Location loca = occupied.get(i);
            ArrayList<Location> valid = grid.validNeighbors(loca);
            for (int j = 0; j <= valid.size() -1; j++)
            {
                loca = valid.get(j); 
                if (countNonZeroNeighbors(grid, loca) == neighborCount)
                {
                    if (places.indexOf(loca) == -1)
                    {
                        places.add(loca);
                    }
                }
            }

        }
        return places;
    }
    
    /*
     * This sets multiple locations on the grid with a certan value
     * @param grid the grid to to be set
     * @param locations the list of locations that need to be changed
     * @param value the value to set the locations with
     */
    public static void setLocations(Grid grid, ArrayList<Location> locations, int value)
    {
        for (int i = 0 ; i <= locations.size()-1; i++)
        {
            Location loca = locations.get(i);
            grid.set(loca, value);
        }
    }

}
