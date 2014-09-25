// This class constructs a string and can test for vowels, count vowels, vowel groups, replace letters , test similar or different letters.
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

    public Word(char letter, int counter)
    {

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

    /*
     * Replaces each consonant group with an X
     */
    public void replaceEachConsonantGroupWithX()
    {
        String output = "";
        int i = 0;
        while (i <= text.length()-1)
        {
            String letter = text.substring(i, i + 1); // the ith letter 
            if (isVowel(letter))
            {
                output = output + letter;
                i = i + 1;
            }
            else 
            {
                while (!isVowel(letter))
                {
                    i = i + 1;
                    if (i >= text.length())
                    {
                        letter = "a";
                    }
                    else letter = text.substring(i, i + 1);
                }
                output = output + "X";
            }

        }
        text = output;
    }

    /*
     * Replaces each consonant group in the middle of the word with an X
     */
    public void replaceEachInteriorConsonantGroupWithX()
    {
        String output = "";
        int i = 1;
        while (i <= text.length()-1)
        {
            String letter = text.substring(i, i + 1); // the ith letter 
            if (isVowel(letter))
            {
                output = output + letter;
                i = i + 1;
            }
            else 
            {
                while (!isVowel(letter))
                {
                    i = i + 1;
                    if (i >= text.length())
                    {
                        letter = "a";
                    }
                    else letter = text.substring(i, i + 1);
                }
                if (i >= text.length())
                {
                    output = output;
                }

                else output = output + "X";
            }

        }
        text = output;
    }

    /*
     * Tests if all letters are the same
     * @return true if all letters in the word are the same
     */
    public boolean allLettersAreTheSame()
    { 
        for (int i=1; i <= text.length()-1; i++)
        {
            if (text.charAt(i-1) != text.charAt(i))
            {
                return false;
            }

        }
        return true;
    }

    /*
     * Tests if all letters are different
     * @return true if all letters are different
     */
    public boolean allLettersAreDifferent()
    {
        for (int i = 0; i<= text.length()-1; i++)
        {
            for (int j = i+1; j <= text.length()-1; j++)
            {
                if ((text.charAt(i) == text.charAt(j)))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Counts the most frequent letters in the word
     * @return the most repeated letter
     */
    public String mostFrequentLetter()
    {
        int mostFrequent = 0;
        String mostFrequentLetter = "";
        for (int i = 0; i<= text.length() -1; i++)
        {
            int counter = 0;

            for (int j = i; j<= text.length() -1; j++)
            {
                if (text.charAt(i) == text.charAt(j))
                {
                    counter += 1;
                }

            }
            if (counter > mostFrequent)
            {
                mostFrequent = counter;
                mostFrequentLetter = text.substring(i, i+1);
            }

        }
        return mostFrequentLetter;
    }
}
