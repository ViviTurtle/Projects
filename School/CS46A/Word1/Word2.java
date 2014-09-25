// This class constructs a string and can test for vowels, count vowels, vowel groups, replaces letters, or prints triangles or shifts using the word.
public class Word2
{
    private String text;

    /*
    Constructs a word.
    @param text the characters in this word
     */
    public Word2(String text)
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

    /*
     * Prints a triangle using the text by subtracting the last letter on each line
     */
    public void printLeftTriangle()
    {
        String word = text;
        for (int i = word.length()-1; i >= 0; i--)
        {

            for (int j = 0; j <= i; j++)
            {
                System.out.print(word.charAt(j));

            }
            System.out.println("");
        }

    }

    /*
     * Prints a right triangle using the text by only printing the last letter in the word, and adding the one before in the next line
     */
    public void printRightTriangle()
    {
        String word = text; 
        for (int i = word.length()-1; i >= 0; i--) //outer loop is how many rows of words
        {     

            for (int j = 1; j <= i; j++) //inner loop is how many spaces in the word
            {
                System.out.print(" ");
            }
            for (int k = i; k <= word.length() -1; k++) // inner loop of what to write after the spaces.
            {
                System.out.print(word.charAt(k));
            }
            System.out.println("");
        }
    }

    /*
     * Prints a word, but in each line, the first letter gets moved to the back, so that the word shifts to a different word.
     */
    public void printShifts()
    {
        String word = text;
        int k;
        int i;
        int j;
        for (i = 0; i <= word.length() - 1; i++) //total rows
        {
            for (k = i; k <= word.length() - 1; k++) //what to print first
            {
                System.out.print(word.charAt(k));
            }

            for (j = 0; j <= i-1; j++)
            {
                System.out.print(word.charAt(j));
            }
            System.out.println("");

        }
    }

}
