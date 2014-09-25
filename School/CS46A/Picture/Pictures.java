public class Pictures
{
    final static int DEFAULT_GREY = 127;
    public static int[][] merge(int[][] a, int[][] b) 
    {

        int largerX= a.length;
        int largerY= a[0].length;
        if (b.length > largerX)
        {
            largerX = b.length;
        }
        if (b[0].length > largerY)
        {
            largerY = b[0].length; 
        }
        int[][] merge = new int[largerX][largerY];
        for (int x = 0; x <= largerX-1; x++)
        {
            for (int y = 0; y <=largerY-1; y++)
            {
                if (isValid(a, b[y][0], b[0][x]))
                {

                    if (isValid(b,a[y][0], a[0][x]))
                    {
                        merge[x][y] = (a[x][y] + b[x][y]) /2;
                    }
                    else 
                    {
                        merge[x][y] = b[x][y];
                    }
                }

                else if (isValid(b,a[0].length,a.length))
                {
                    merge[x][y] = a[x][y];
                }

                else
                {
                    merge[x][y] = DEFAULT_GREY;
                }

            }
        }
        return merge;
    }

    /*
     * Finds whether a given position(x, y) is valid in a 2D array, and if so,
     * whether the element is between 0 and 255 inclusive.
     * @param a the 2D array to check.
     * @param x x-coordinate of the position.
     * @param y y-coordinate of the position.
     * @return true if the position exists, false otherwise.
     */
    //https://piazza.com/class#fall2012/cs46a/1527 (copied the idea)
    private static boolean isValid(int[][] a, int x, int y) 
    {
        if (x <= a[0].length && y <= a.length )
        {
            return true;
        }
        else return false;
    }

}

