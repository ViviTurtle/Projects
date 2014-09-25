import java.util.Arrays;
public class WordsTester
{
  public static void main(String[] args)
   {
      String[] sentence = { "Mary", "had", "a", "little", "lamb" };
      Words words = new Words();
      words.removeShortWords(sentence);
      System.out.println(Arrays.toString(sentence));
      System.out.println("Expected: [Mary, little, lamb, , ]");
   }
}