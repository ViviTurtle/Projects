public class Word
{
    /**
    Tests whether a letter is a vowel
    @param letter a string of length 1
    @return true if letter is a vowel
     */
    public boolean isVowel(String letter)
    {     
        
            //return letter.equalsIgnoreCase("u")||letter.equalsIgnoreCase("y")||letter.equalsIgnoreCase("a")||letter.equalsIgnoreCase("e")||letter.equalsIgnoreCase("i")||letter.equalsIgnoreCase("o");
            return letter.contains("a");
    }
}
