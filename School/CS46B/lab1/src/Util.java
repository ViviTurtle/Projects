import java.util.ArrayList;

public class Util
{
   /**
      Returns the smallest element in an array
      @param values an array of non-null Comparable values of length >= 1
      @return the smallest value in values
   */
   public static Comparable smallest(Comparable[] values)
   {
      Comparable smallestSoFar = values[0];
      for (int i = 1; i < values.length; i++)
         if (values[i].compareTo(smallestSoFar) < 0)
            smallestSoFar = values[i];
      return smallestSoFar;
   }   

   /**
      Returns the smallest element in the array larger than a given value.
      @param values an array of non-null Comparable values
      @param after a value that may or may not be present in the array
      @return the smallest value in the array larger than value, or null if there isn't one
   */
   public static Comparable smallestAfter(Comparable[] values, Comparable after)
   {
      return null;
   }
}