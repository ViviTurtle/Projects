// This class constructs a string and can test for vowels, count vowels, vowel groups, or replace letters
public class Word
{
    private String text;

    /*
    Constructs a word.
    @param text the characters in this word
     */
    public Word(String text)
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
     * Replaces each consonant with an "X"
     */
    public void replaceEachConsonantWithX()
    {
        String output = "";
        for (int i = 0; i < text.length(); i++)
        {
            String letter = text.substring(i, i + 1); // the ith letter 
            if (isVowel(letter))
            {
                output = output + letter;
            }
            else if (!isVowel(letter))
            {     
                output = output + "X";
            }
        }
        text = output;
    }
}