import java.util.*;
public class Grids
{
    int[][] grid;
    public Grids(int x, int y)
    {
        grid = new int[x][y];
    }

    /*
     * This counts the amount of non Zero neighbord adjacent to a certain area in a frid
     * @param grid the grid used to check for adjacent neighbors
     * @param row the row of the certain box
     * @param the column of the certain box
     * @return counter which counts the amount of non zero neighbord.
     */
    public static int countNonZeroNeighbors(int[][] grid, Location placement)
    {
        int counter = 0;
        int maxX= placement.getColumn() + 1;
        int maxY= placement.getRow() + 1;
        int minX = placement.getColumn() - 1;
        int minY= placement.getRow() -1;
        if (minX < 0)
        {
            minX = placement.getColumn();
        }
        if (minY < 0)
        {
            minY = placement.getRow();
        }
        if (maxX > grid.length-1)
        {
            maxX = placement.getColumn();
        }
        if (maxY > grid[0].length-1)
        {
            maxY= placement.getRow();
        }
        for (int i = minX; i <= maxX; i++)
        {
            for (int j = minY; j<= maxY; j++)
            {
                if (grid[i][j] != 0)
                {
                    counter++;
                }
            }

        }
        if (grid[placement.getColumn()][placement.getRow()] != 0)
        {
            counter--;
        }
        return counter;
    }

    public static ArrayList<Location> locationsWithNeighbors(int[][] grid, int neighborCount)
    {
        /*
        location = new ArrayList<Location>();
        for (int i = 0; i <= grid.length-1; i++)
        {
            for (int j = 0; j <= grid[0].length-1; j++)
            {
                int test = countNonZeroNeighbors(grid, i, j);  
                if (test == neighborCount)
                {
                    location.add(new Location(i, j));
                }
            }
        }
        return location;
        */
       return null;
    }

    public static void setLocations(int[][] grid, ArrayList<Location> locations, int value)
    {
        for (int i = 0; i <= locations.size()-1; i++)
        {
            int x = locations.get(i).getRow();
            int y = locations.get(i).getColumn();
            grid[x][y] = value;
        }

    }
}
