public class Problem3
{
    /**
    Checks whether the first, middle, and last values
    of an array are the same.
    @param values an array with at least one element.
    @return true if the first, last, and either the middle value
    (if the array length is odd) or the middle two values (if
    the array length is even) are all the same.
     */
    public static boolean firstMiddleLastAreSame(int[] values)
    {
        int middle = (int) values.length/2;
        if (values.length % 2 == 0)
        {
            if (values[0] == values[values.length-1] && values[0] == values[middle] && values[0] == values[middle-1])
            {
                return true;
            }
        }
        else if (values.length % 2 == 1)
        {
            if (values[0] == values[values.length-1]  && values[0] == values[middle])
            {
                return true;
            }
        }
       return false;
    }

    public static void main(String[] args)
    {
        System.out.println(firstMiddleLastAreSame(new int[] {1, 2, 1, 3, 1 }));
        System.out.println("Expected: true");
        System.out.println(firstMiddleLastAreSame(new int[] {1, 2, 1, 1, 3, 1 }));
        System.out.println("Expected: true");

        System.out.println(firstMiddleLastAreSame(new int[] {1, 2, 1, 2, 3 }));
        System.out.println("Expected: false");
        System.out.println(firstMiddleLastAreSame(new int[] {1, 2, 3, 2, 1 }));
        System.out.println("Expected: false");
        System.out.println(firstMiddleLastAreSame(new int[] {1, 2, 1, 1, 2, 3 }));
        System.out.println("Expected: false");      
        System.out.println(firstMiddleLastAreSame(new int[] {1, 2, 3, 1, 1, 1 }));
        System.out.println("Expected: false");      
    }
}
