import java.util.Arrays;
import java.util.ArrayList;

public class Problem5
{
    /**
    Removes adjacent duplicates from an array list of strings. (See Lab 11B)
    @param words an array list of strings
    @return the number of removed strings
     */
    public static int removeAdjacentDuplicates(ArrayList<String> words)
    {
        int removed = 0;
        for (int i = 1; i <= words.size()-1; i++)
        {
            if (words.get(i).equals(words.get(i-1)))
            {
                for (int j = i; j <= words.size()-1; j++)
                {
                    words.set(j-1, words.get(j));
                }
                removed++;
                words.remove(words.size()-1);
                i--;
            }
        }
        return removed;

    }

    public static void main(String[] args)
    {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Mary had had a little lamb lamb lamb".split(" ")));
        int removed = removeAdjacentDuplicates(words);
        System.out.println(removed);
        System.out.println("Expected: 3");
        System.out.println(words);
        System.out.println("Expected: [Mary, had, a, little, lamb]");
    }
}
