public class Tester2
{
   public static void main(String[] args)
   {
      TerrainMap map = new TerrainMap(100, 300, 100, 200, 10, 20, 50);
      for (int i = 0; i < 10; i++)
         for (int j = 0; j < 20; j++)
            map.set(100 + 10 * j + 5, 100 + 10 * i + 5, 50 + i - j);

      System.out.println(map.get(105, 115));
      System.out.println("Expected: 51");
      System.out.println(map.get(115, 105));
      System.out.println("Expected: 49");
      System.out.println(map.get(115, 115));
      System.out.println("Expected: 50");
      System.out.println(map.get(114, 106));
      System.out.println("Expected: 49");
      System.out.println(map.get(110, 100));
      System.out.println("Expected: 49");
      System.out.println(map.get(120, 100));
      System.out.println("Expected: 48");
   }
}