public class WordTester
{
   public static void main(String[] args)
   {
      Word word = new Word();
      String vowels = "aeiouyAEIOUY";
      for (int i = 0; i < vowels.length(); i++)
      {
         String letter = vowels.substring(i, i + 1);
         System.out.println(letter + "is a vowel: " + word.isVowel(letter));
         System.out.println("Expected: true");
      }
      String nonVowels = "bBxX.!";
      for (int i = 0; i < nonVowels.length(); i++)
      {
         String letter = nonVowels.substring(i, i + 1);
         System.out.println(letter + " is a vowel: " + word.isVowel(letter));
         System.out.println("Expected: false");
      }
   }
}