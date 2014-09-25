public class Problem1
{
   /**
      Counts how many strings have length >= len.
      @param words the strings to check 
      @param len the minimum length to count
      @return the number of strings with at least the given length
   */
   public static int longStrings(String[] words, int len)
   {
      int count = 0;
      for (String w : words)
      {
         if (w.length() >= len)
         {
            count++;
         }
      }
      return count;
   }


   public static void main(String[] args)
   {
      String[] words = {"Mary", "had", "little", "lambs" };
      int count = longStrings(words, 4);
      System.out.println(count);
      System.out.println("Expected: 3");
   }
}
