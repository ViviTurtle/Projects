public class TerrainMap
{
    public double[][] map;
    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;
    public TerrainMap(double xmin, double xmax, double ymin, double ymax, int rows, int columns, double defaultHeight)
    {
        map = new double[rows][columns];
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        for (int i = 0; i<= rows-1; i++)
        {
            for (int j = 0; j <= columns-1; j++)
            {
                map[i][j] = defaultHeight;
            }
        }

    }

    public int getColumn(double x)
    {
        int columns = map[0].length;
        double width = xmax-xmin;
        double colWidth = width / columns;
        return (int)((x-xmin)/colWidth);
    }

    public int getRow (double y)
    {
        int rows = map.length;
        double length = ymax - ymin;
        double rowLength = length/rows;
        return (int)((y-ymin)/rowLength);
    }

    public double get(double x, double y)
    {
        int yLocation = this.getColumn(x);
        int xLocation = this.getRow(y);
        return map[xLocation][yLocation];
    }

    public void set(double x, double y, double height)
    {
        int yLocation = this.getColumn(x);
        int xLocation = this.getRow(y);    
        map[xLocation][yLocation] = height;
    }

    public void printTerrainMap(double waterLevel)
    {
        for (int i = 0; i <= map.length-1; i++)
        {

            for (int j = 0; j <= map[0].length-1; j++)
            {
                if (map[i][j] >= waterLevel)
                {
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
