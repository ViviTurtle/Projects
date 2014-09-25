public class WordTester1
{
   public static void main(String[] args)
   {
      Word w = new Word("beauty");
      System.out.println("Vowels in " + w + ": " + w.countVowels());
      System.out.println("Expected: 4");
      w = new Word("mississippi");
      System.out.println("Vowels in " + w + ": " + w.countVowels());
      System.out.println("Expected: 4");
      w = new Word("ant");
      System.out.println("Vowels in " + w + ": " + w.countVowels());
      System.out.println("Expected: 1");
      w = new Word("treasure");
      System.out.println("Vowels in " + w + ": " + w.countVowels());
      System.out.println("Expected: 4");    
   }
}
