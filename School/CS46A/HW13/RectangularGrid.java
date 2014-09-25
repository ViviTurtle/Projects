import java.util.ArrayList;
/*
 * This class deals with two dimensional grids that uses a Grid interface, the grid can get,set and return neighbors.
 */
public class RectangularGrid implements Grid
{
    int[][] grid;

    /*
     * Constructs the two dimensional grid.
     */
    public RectangularGrid(int x, int y)
    {
        grid = new int[x][y];
    }

    /*
    Returns all occupied locations.
    @return a list of all locations with non-zero values
     */
    public ArrayList<Location> occupiedLocations()
    {
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int i = 0; i <= grid.length-1; i++)
        {
            for (int j = 0; j <= grid[0].length-1; j++)
            {
                if (grid[i][j] != 0)
                {
                    locations.add(new Location(j, i));
                }
            }
        }
        return locations;
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
        if (minX < 0)
        {
            minX = loc.getColumn();
        }
        if (minY < 0)
        {
            minY = loc.getRow();
        }
        if (maxX > grid.length-1)
        {
            maxX = loc.getColumn();
        }
        if (maxY > grid[0].length-1)
        {
            maxY= loc.getRow();
        }
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

    /*
    Returns the value at a given location.
    @param loc a valid location 
    @return the value at loc
     */
    public int get(Location loc)
    {
        int y = loc.getRow();
        int x = loc.getColumn();
        return grid[x][y];
    }

    /*
    Sets the value at a given location.
    @param loc a valid location       
    @param value the value to set at loc
     */
    public void set(Location loc, int value)
    {
        int y = loc.getRow();
        int x =  loc.getColumn();
        grid[x][y] = value;
    }
}