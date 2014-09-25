public class Words
{
    /**
    Removes all short words (length <= 3) from an array. The 
    order of the remaining element is left unchanged. The unused
    end of the array is filled with empty strings.
    @param words the array from which the short words are to be removed
     */
    public static void removeShortWords(String[] words)
    {
        for (int i = 0; i <= words.length-1; i++)
        {
            if (words[i].equals(""))
            {
                i++;
            }
            else if (words[i].length() <= 3)
            {
                for (int j = i+1; j <= words.length -1; j++)
                {
                    words[j-1] = words[j];
                }
                words[words.length-1] = "";
                i--;
            }
        }

    }
}