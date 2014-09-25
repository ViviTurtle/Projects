import java.util.ArrayList;

public class Tester2
{
   public static void sameLocations(ArrayList<Location> actual, int... locs)
   {
      System.out.println(actual);
      ArrayList<Location> expected = new ArrayList<>();
      for (int i = 0; i < locs.length; i += 2)
         expected.add(new Location(locs[i], locs[i + 1]));

      if (actual.size() != expected.size())
      {
         System.out.println("Expected: " + expected);
         return;
      }

      for (Location a : actual)
         if (!expected.contains(a))
         {
            System.out.println("Expected: " + expected);
            return;
         }

      for (Location e : expected)
         if (!actual.contains(e))
         {
            System.out.println("Expected: " + expected);
            return;
         }
      System.out.println("Expected: " + actual);         
   }

   public static void main(String[] args)
   {
      Grid gr = new UnboundedGrid();
      gr.set(new Location(3, 3), 3);
      gr.set(new Location(4, 4), 4);
      sameLocations(gr.occupiedLocations(), 3,3, 4,4);
      gr.set(new Location(3, 3), 0);
      sameLocations(gr.occupiedLocations(), 4,4);
      sameLocations(gr.validNeighbors(new Location(5, 5)), 
         4,4, 4,5, 4,6, 5,4, 5,6, 6,4, 6,5, 6,6);
      sameLocations(gr.validNeighbors(new Location(0, 0)), 
         -1,-1, -1,0, -1,1, 0,-1, 0,1, 1,-1, 1,0, 1,1);
   }
}