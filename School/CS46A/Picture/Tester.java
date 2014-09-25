import java.util.Arrays;
public class Tester
{
    public static void main(String[] args)
    {
        int[][] array1 = {
           {100, 120, 130, 140, 150},
           {0, 0, 100, 150, 60}
        };
        int[][] array2 = {
           {0, 0, 100, 150, 60},
           {100, 120, 130, 140, 150}
        };
        System.out.println(Arrays.deepToString(Pictures.merge(array1, array2)));
        System.out.println("Expected: [[50, 60, 115, 145, 105], [50, 60, 115, 145, 105]]");
    }
}