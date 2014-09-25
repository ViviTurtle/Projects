public class Tester
{
   public static void main(String[] args)
   {
      Word word = new Word("reassuring");
      word.replaceEachConsonantWithX();
      System.out.println(word.toString());
      System.out.println("Expected: XeaXXuXiXX");
   }
}