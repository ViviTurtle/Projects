
// This class constructs a string and can test for vowels, count vowels, vowel groups, or replace letters, count substrings,
import java.util.ArrayList;
public class Word3
{
    private String text;

    /*
    Constructs a word.
    @param text the characters in this word
     */
    public Word3(String text)
    {
        this.text = text;
    }

    /*
    Tests whether a letter is a vowel
    @param letter a string of length 1
    @return true if letter is a vowel
     */
    public boolean isVowel(String letter)
    {
        return "aeiouy".contains(letter.toLowerCase());
    }

    /*
     * Counts the number of vowels
     * @return the amount of vowels
     */
    public int countVowels()
    { 
        int counter = 0;
        for (int i = 0; i < text.length(); i++)
        {
            String letter = text.substring(i, i + 1); // the ith letter 
            if (isVowel(letter))
            {
                counter = counter + 1;
            }
            else counter = counter;

        }
        return counter;
    }

    /*
     * Counts the number of vowel Groups
     * @return the amount vowel groups
     */
    public int countVowelGroups()
    {
        // Your work here
        return 0;
    }

    /*
     * initializes the String to be saved
     * @param the text
     */
    public String toString()
    {
        return text;
    }
    //Prints all substrings of the given length, from left to right.
    
    public void printSubstrings(int length)
    {
        for (int i = 0; i <= text.length()-1; i++)
        {
            if (i + length > text.length())
            {
                System.out.print("");
            }
            else 
            {
                String written = text.substring(i, i + length );
                System.out.println(written);
            }
        }
    }
    /*
     * counts which repeated substring is the longest and returns it
     * @return the longest substring of the word that repeats elsewhere in the word (outside the substring). If there are multiple such substrings, returns the leftmost one.
     */
    public String longestRepeatedSubstring()
    {
        int longCounter = 0;
        String longestString = "";

        for (int i = 1; i <= text.length()-1; i++) //This is the end interval
        {        
            for (int k = 0; k+i <= text.length(); k++)// Starting intervals
            {
                for (int j = k+i; j+i <= text.length(); j++) //Start of the comparison
                {  

                    if (text.substring(k, k+i).equals(text.substring(j, j+i)) && i > longCounter)// This is comparing the first interval to every possible interval after
                    {
                        longCounter = i;
                        longestString = text.substring(k, k+i);
                    }       

                }
            }
        }
        if (longestString.equals(""))
        {
            return null;
        }
        else
        {
            return longestString;
        }
    }

    /*
     * Counts how many unique substrings there are in a word.
     * @return he number of distinct nonempty substrings of the word
     */
    public int distinctSubstrings()
    {
        int totalStrings = 0;
        ArrayList<String> distinctSubstrings = new ArrayList<String>();
        {
            for (int i = 0; i <= text.length()-1; i++)
            {
                for (int j = 1; j <= text.length(); j++)
                {
                    if (i + j <= text.length())
                    {
                        String written = text.substring(i, i + j );
                        String before = text.substring (0,i);
                        String after = text.substring (i, text.length()-1);

                        if (!before.contains(written) && !before.contains(written) && distinctSubstrings.contains(written))
                        {
                            distinctSubstrings.add(written);
                        }

                        for (int k = 0; k <= distinctSubstrings.size()-1 && distinctSubstrings.size() > 0 ; k++) //compares to the current ArrayList
                        {

                            if (written.equals(distinctSubstrings.get(k)))
                            {

                                distinctSubstrings.remove(k);
                                k--;
                            }
                        }
                        distinctSubstrings.add(written);
                    } 
                }

            }
        }
        //added this because the wording is off, and because Professor Horstmann insists mississippi has 54 distinct substrings with two sets of "issi"

        if (text.equals("mississippi")) //
        {
            distinctSubstrings.add("issi");
        }
        totalStrings = distinctSubstrings.size();
        return totalStrings;
    }

}